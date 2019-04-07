import com.google.protobuf.InvalidProtocolBufferException;
import protos.HashTabOperationProtos.*;
import java.net.*;
import java.util.Arrays;

public class ClientRequestsHandler {

    private DatagramSocket sock;
    private int port;
    private DistributedMap map;
    private JGroupCommunicationHandler jGroupCommunicationHandler;

    public ClientRequestsHandler(DistributedMap map, int port){
        this.map = map;
        this.port = port;
    }

    public void setjGroupCommunicationHandler(JGroupCommunicationHandler handler){
        this.jGroupCommunicationHandler = handler;
    }

    public void setMap(DistributedMap map){
        this.map = map;
    }

    public void responseToClients() throws Exception {

        sock = new DatagramSocket(port);
        byte [] recvBuf = new byte[1024];


        while (true){

            DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
            sock.receive(packet);

            // use JChannel communication to synchronize other servers
            HashTabOperation op = HashTabOperation.parseFrom(Arrays.copyOf(packet.getData(), packet.getLength()));


            if (op.getType().equals(HashTabOperation.OperationType.PUT) ||
                    op.getType().equals(HashTabOperation.OperationType.RMV) ){
                jGroupCommunicationHandler.sendMsg(Arrays.copyOf(packet.getData(), packet.getLength()));
            }

            HashTabOperation clientRequest = processClientRequest(packet);
            byte[] buf = clientRequest.toByteArray();
            packet = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());


            // send response to client
            sock.send(packet);

        }
    }



    public HashTabOperation processClientRequest (DatagramPacket packet) throws InvalidProtocolBufferException {

        HashTabOperation operation = HashTabOperation.parseFrom(Arrays.copyOf(packet.getData(), packet.getLength()));

        HashTabOperation.Builder builder = HashTabOperation.newBuilder();

      //  synchronized (map){

            if (operation.getType().equals(HashTabOperation.OperationType.CONTAINS)){
                if (map.containsKey(operation.getKey()) )
                    return builder.setType(HashTabOperation.OperationType.ACK).setValue(0).setKey("").build();
                return builder.
                        setType(HashTabOperation.OperationType.NACK).setValue(0).setKey("").build();
            }

            else if (operation.getType().equals(HashTabOperation.OperationType.PUT)){
                map.put(operation.getKey(), operation.getValue());
                return builder.setType(HashTabOperation.OperationType.ACK).setValue(0).setKey("").build();
            }

            else if (operation.getType().equals(HashTabOperation.OperationType.GET)){
                Integer val =  map.get(operation.getKey());
                if (val != null) return builder.setValue(val).setKey("").setType(HashTabOperation.OperationType.ACK).build();
                else return builder.setType(HashTabOperation.OperationType.NACK).setValue(0).setKey("").build();
            }

            else {
                Integer val =  map.remove(operation.getKey());
                if (val != null) {
                    return builder.setValue(val).setType(HashTabOperation.OperationType.ACK).setKey("").build();
                }
                return builder.setValue(0).setType(HashTabOperation.OperationType.NACK).setKey("").build();
            }
    }




}
