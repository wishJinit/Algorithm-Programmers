// https://programmers.co.kr/learn/courses/30/lessons/68644
// 두 개 뽑아서 더하기

import java.util.*;

public class Q68644 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0, len = numbers.length; i < len - 1; i++) {
            int value = numbers[i];
            for (int j = i + 1; j < len; j++) {
                hs.add(value + numbers[j]);
            }
        }
        return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
