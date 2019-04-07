import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        DistributedMap map = new DistributedMap(new HashMap<>());

        int port = Integer.parseInt(args[0]);

        try {
            ClientRequestsHandler clientResponseHandler = new ClientRequestsHandler(map, port);
            JGroupCommunicationHandler handler = new JGroupCommunicationHandler(map, clientResponseHandler);
            clientResponseHandler.setjGroupCommunicationHandler(handler);
            handler.initCommunication();
            clientResponseHandler.responseToClients();
        }
        catch (Exception exception)  { out.println(exception.getMessage()); }


    }
}
