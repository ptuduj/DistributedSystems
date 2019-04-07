import com.google.protobuf.InvalidProtocolBufferException;
import org.jgroups.*;
import org.jgroups.protocols.*;
import org.jgroups.protocols.pbcast.*;
import org.jgroups.stack.ProtocolStack;
import org.jgroups.util.Util;
import protos.HashTabOperationProtos.HashTabOperation;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.JarURLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JGroupCommunicationHandler {

    private DistributedMap map;
    private ClientRequestsHandler handler;
    JChannel channel;

    public JGroupCommunicationHandler(DistributedMap map, ClientRequestsHandler handler){
        this.map = map;
        this.handler = handler;
    }

    private class MergeHandler extends Thread
    {
        private MergeView view;
        public MergeHandler(MergeView view)
        {
            this.view = view;
        }

        public void run()
        {
            List<View> views= view.getSubgroups();
            View primaryCluster= views.get(0);
            if (primaryCluster.getMembers().contains(channel.getAddress())) {
                System.out.println("Merging in primaty cluster, nothung to do");
            }
            else {
                System.out.println("Merging in non-primary cluster, aquiring state");
                try {
                    channel.getState(null, 30000);
                } catch (Exception ex) {throw new RuntimeException(ex.getMessage(),ex.getCause());}

            }

        }
    }


    public void initCommunication() throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");

        channel = new JChannel(false);


        ProtocolStack stack=new ProtocolStack();
        channel.setProtocolStack(stack);
        stack.addProtocol(new UDP().setValue("mcast_group_addr", InetAddress.getByName("230.100.200.2")))
                .addProtocol(new PING())
                .addProtocol(new MERGE3())
                .addProtocol(new FD_SOCK())
                .addProtocol(new FD_ALL().setValue("timeout", 12000).setValue("interval", 3000))
                .addProtocol(new VERIFY_SUSPECT())
                .addProtocol(new BARRIER())
                .addProtocol(new NAKACK2())
                .addProtocol(new UNICAST3())
                .addProtocol(new STABLE())
                .addProtocol(new GMS())
                .addProtocol(new UFC())
                .addProtocol(new MFC())
                .addProtocol(new FRAG2())
                .addProtocol(new STATE_TRANSFER())
                .addProtocol(new SEQUENCER())
                .addProtocol(new FLUSH());

        stack.init();


        channel.setReceiver(new ReceiverAdapter(){
            @Override
            public void viewAccepted(View view) {
                super.viewAccepted(view);
                System.out.println(view.toString());
                if(view instanceof MergeView)
                {
                    MergeHandler handler = new MergeHandler((MergeView) view);
                    handler.start();
                }
            }

            @Override
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc());

                try {
                    HashTabOperation op = HashTabOperation.parseFrom(msg.getBuffer());
                    if (op.getType().equals(HashTabOperation.OperationType.PUT))
                        map.put(op.getKey(), op.getValue());

                    else map.remove(op.getKey());

                }
                catch (InvalidProtocolBufferException e) { e.printStackTrace(); }
            }

            @Override
            public void getState(OutputStream output) throws Exception {
                System.out.println("in get state");
                Util.objectToStream(JGroupCommunicationHandler.this.map, new DataOutputStream(output));
            }

            @Override
            public void setState(InputStream input) throws Exception {
                JGroupCommunicationHandler.this.map = (DistributedMap) Util.objectFromStream(new DataInputStream(input));
                JGroupCommunicationHandler.this.handler.setMap(JGroupCommunicationHandler.this.map);
                System.out.println("Synchronization successfluf " +  JGroupCommunicationHandler.this.map);
            }
        });
        channel.connect("operationCluster24", null, 100000);
    }


    public void sendMsg(byte[] buf) throws Exception {
        Message msg = new Message(null, null, buf);
        channel.send(msg);
        System.out.println("MSG sent");
    }



}
