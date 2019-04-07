import java.io.Serializable;
import java.util.HashMap;

public class DistributedMap implements SimpleStringMap, Serializable {

    private HashMap<String, Integer> hashMap;


    public DistributedMap(HashMap<String, Integer> hashMap){
        this.hashMap = hashMap;
    }

    @Override
    public boolean containsKey(String key){
        return hashMap.containsKey(key);
    }

    @Override
    public Integer get(String key){
        return hashMap.get(key);
    }

    @Override
    public void put(String key, Integer value){
         hashMap.put(key, value);
    }

    @Override
    public Integer remove(String key){
        return hashMap.remove(key);
    }


    @Override
    public String toString() {
        return hashMap.toString();
    }
}
