package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/67256
// 키패드 누르기

import java.io.*;
import java.util.*;

public class KAKAO_INTERNSHIP_2020_01 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int number : numbers) {
            int[] point = keypad[number];
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer.append("L");
                    left = point;
                    break;

                case 3:
                case 6:
                case 9:
                    answer.append("R");
                    right = point;
                    break;

                default:
                    int l = Math.abs(point[0] - left[0]) + Math.abs(point[1] - left[1]);
                    int r = Math.abs(point[0] - right[0]) + Math.abs(point[1] - right[1]);
                    if (l < r || (l == r && hand.equals("left"))) {
                        answer.append("L");
                        left = point;
                    } else {
                        answer.append("R");
                        right = point;
                    }
                    break;
            }
        }

        return answer.toString();
    }
}
