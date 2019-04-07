import com.google.protobuf.InvalidProtocolBufferException;
import protos.HashTabOperationProtos.*;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class DistributedMap  implements SimpleStringMap {

   private DatagramSocket socket = new DatagramSocket();
   private InetAddress address = InetAddress.getLocalHost();
   private int port;


    public DistributedMap (int port) throws SocketException, UnknownHostException {
        this.port = port;
    }


    @Override
    public boolean containsKey(String key) {
        HashTabOperation operation =
                createHashTabOperation(HashTabOperation.OperationType.CONTAINS, key, 0);
        sendDatagramPacket(operation);

        HashTabOperation responseOp = receiveResponse();
        return (responseOp.getType() == HashTabOperation.OperationType.ACK);

    }

    @Override
    public Integer get(String key){
        HashTabOperation operation =
                createHashTabOperation(HashTabOperation.OperationType.GET, key, 0);
        sendDatagramPacket(operation);

        HashTabOperation responseOp = receiveResponse();

        if (responseOp.getType() == HashTabOperation.OperationType.NACK) return null;
        return (responseOp.getValue());
    }

    @Override
    public void put(String key, Integer value){
        HashTabOperation operation =
                createHashTabOperation(HashTabOperation.OperationType.PUT, key, value);
        sendDatagramPacket(operation);

        // TODO
        HashTabOperation responseOp = receiveResponse();

    }

    @Override
    public Integer remove(String key){
        HashTabOperation operation =
                createHashTabOperation(HashTabOperation.OperationType.RMV, key, 0);
        sendDatagramPacket(operation);

        HashTabOperation responseOp = receiveResponse();
        if (responseOp.getType() == HashTabOperation.OperationType.ACK) return (responseOp.getValue());
        return null;
    }



    private HashTabOperation createHashTabOperation(HashTabOperation.OperationType type, String key, int value){
        HashTabOperation operation;
        operation = HashTabOperation.newBuilder()
                .setType(type)
                .setKey(key)
                .setValue(value)
                .build();
        return operation;
    }


    private void sendDatagramPacket(HashTabOperation operation) {
        DatagramPacket packet;
        byte[] buf = operation.toByteArray();

        try {
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
        }
        catch (IOException ioEx){ throw new RuntimeException(ioEx.getMessage()); }
    }


    private HashTabOperation receiveResponse(){

        byte [] recvBuf = new byte[1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
        HashTabOperation operation;

        try {
            socket.receive(recvPacket);
            operation = HashTabOperation.parseFrom(Arrays.copyOf(recvPacket.getData(),recvPacket.getLength()));
        }
        catch (IOException ioEx) {throw new RuntimeException(ioEx.getMessage()); }
        return operation;
    }


}
