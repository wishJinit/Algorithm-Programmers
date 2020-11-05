package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/17682
// 다트 게임

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1_02 {
    public int solution(String dartResult) {
        List<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : dartResult.toCharArray()) {
            if (isNumber(c)) sb.append(c);
            else if (isBonus(c)) {
                int pow = (c == 'T' ? 3 : (c == 'D' ? 2 : 1));
                arrayList.add((int) Math.pow(Integer.parseInt(sb.toString()), pow));
                sb.delete(0, sb.length());
            } else {
                int size = arrayList.size();
                if (c == '*') {
                    arrayList.set(size - 1, arrayList.get(size - 1) * 2);
                    if (size >= 2) arrayList.set(size - 2, arrayList.get(size - 2) * 2);
                } else if (c == '#') {
                    arrayList.set(size - 1, -arrayList.get(size - 1));
                }
            }
        }

        return arrayList.stream().mapToInt(Integer::intValue).sum();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isBonus(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
