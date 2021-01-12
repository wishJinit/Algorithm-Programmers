package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/17677
// 뉴스 클러스터링

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1_03 {
    final static int FLAG = 65536;

    public int solution(String str1, String str2) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.equals(str2)) return FLAG;

        for (int i = 1, len = str1.length(); i < len; i++) {
            if (checkAlphabet(str1.charAt(i - 1)) && checkAlphabet(str1.charAt(i))) {
                String s = str1.substring(i - 1, i + 1);
                str1Map.put(s, str1Map.getOrDefault(s, 0) + 1);
            }
        }
        for (int i = 1, len = str2.length(); i < len; i++) {
            if (checkAlphabet(str2.charAt(i - 1)) && checkAlphabet(str2.charAt(i))) {
                String s = str2.substring(i - 1, i + 1);
                str2Map.put(s, str2Map.getOrDefault(s, 0) + 1);
            }
        }

        str1Map.keySet().iterator().forEachRemaining(set::add);
        str2Map.keySet().iterator().forEachRemaining(set::add);


        int intersection = 0, union = 0;
        for (String key : set.toArray(String[]::new)) {
            int str1Cnt = str1Map.getOrDefault(key, 0), str2Cnt = str2Map.getOrDefault(key, 0);
            intersection += Math.min(str1Cnt, str2Cnt);
            union += Math.max(str1Cnt, str2Cnt);
        }

        return (int) ((float) intersection / union * FLAG);
    }

    private boolean checkAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }
}
