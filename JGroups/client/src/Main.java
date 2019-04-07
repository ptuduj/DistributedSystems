import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        int serverPort = Integer.parseInt(args[0]);

        SimpleStringMap map = new DistributedMap( serverPort);
        InputParser parser = new InputParser(map);
        parser.readFromInput();
    }


}
