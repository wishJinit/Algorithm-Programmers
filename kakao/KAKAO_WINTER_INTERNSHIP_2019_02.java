package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/64065
// 튜플

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class KAKAO_WINTER_INTERNSHIP_2019_02 {
    public static int[] solution(String s) {
        String[] arr = s.split("},");
        int len = arr.length;
        for (int i = 0; i < len; i++) arr[i] = arr[i].replace("{", "").replace("}", "");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        HashSet<Integer> hashSet = new HashSet<>();
        String[] numArr = arr[len - 1].split(",");
        for (int i = 0; i < numArr.length; i++) {
            hashSet.add(Integer.parseInt(numArr[i]));
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            String[] temp = arr[i].replace(" ", "").split(",");
            for (int j = 0; j < temp.length; j++) {
                int num = Integer.parseInt(temp[j]);
                if (hashSet.contains(num)) {
                    answer[i] = num;
                    hashSet.remove(num);
                }
            }
        }

        return answer;
    }
}
