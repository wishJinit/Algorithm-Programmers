import java.util.*;

public class Q42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (String[] clothe : clothes) {
            String name = clothe[1];
            hashmap.put(name, hashmap.getOrDefault(name, 0) + 1);
        }

        for (Integer integer : hashmap.values()) {
            answer *= integer + 1;
        }

        return answer - 1;
    }
}
