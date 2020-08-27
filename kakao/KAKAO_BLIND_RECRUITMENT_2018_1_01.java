package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/17681
// 비밀지도

import java.io.*;
import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1_01 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                sb.insert(0, (num % 2 == 0 ? " " : "#"));
                num /= 2;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
