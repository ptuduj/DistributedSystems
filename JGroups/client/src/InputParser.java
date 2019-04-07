import protos.HashTabOperationProtos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

public class InputParser {

    SimpleStringMap map;

    public InputParser(SimpleStringMap map){
        this.map = map;
    }


    public void readFromInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            out.println("Podaj typ wiadomości: ");
            String type = br.readLine();

            out.println("Podaj klucz: ");
            String key = br.readLine();

            int value = -1;
            if (type.equals("PUT")) {
                out.println("Podaj wartość: ");
                value = Integer.parseInt(br.readLine());
            }

            executeMsg(type, key, value);
        }
    }



    public void executeMsg(String type, String key, int value){

        if (type.contains("PUT"))
            map.put(key, value);

        else if (type.contains("GET")) {
            Integer val =  map.get(key);
            if (val != null) out.println("Received value " + val);
            else out.println("Map contains no mapping for the key");
        }

        else if (type.contains("CONTAINS")) {
            if (map.containsKey(key)) out.println("Map contains the key");
            else out.println("Map doesn't contain the key");
        }

        else if (type.contains("RMV")) {
            if (map.remove(key) == null) out.println("Key doesn't exist");
        }

        else out.println("Invalid operation type. Try again");
    }


}
