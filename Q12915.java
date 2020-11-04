// https://programmers.co.kr/learn/courses/30/lessons/12915
// 문자열 내 마음대로 정렬하기

import java.util.Arrays;

public class Q12915 {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((str1, str2) -> (str1.charAt(n) > str2.charAt(n) ? 1 : (str1.charAt(n) < str2.charAt(n) ? -1 : str1.compareTo(str2))))
                .toArray(String[]::new);
    }
}
