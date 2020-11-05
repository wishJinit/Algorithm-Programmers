// https://programmers.co.kr/learn/courses/30/lessons/42746
// 가장 큰 수

import java.util.*;
import java.util.stream.*;

public class Q42746 {
    public String solution(int[] numbers) {
        String value = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2)))
                .collect(Collectors.joining());
        return (value.charAt(0) == '0' ? "0" : value);
    }
}
