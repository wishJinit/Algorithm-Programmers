package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/64061
// 크레인 인형뽑기 게임

import java.io.*;
import java.util.*;

public class KAKAO_WINTER_INTERNSHIP_2019_01 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0, boardLen = board.length;
        Stack<Integer> q = new Stack<>();
        int[] tops = new int[boardLen];

        for(int i = 0; i < boardLen; i++) {
            for(int j = 0; j < boardLen; j++) {
                if(board[j][i] != 0) {
                    tops[i] = j; break;
                }
            }
        }

        for (int i = 0, len = moves.length; i < len; i++) {
            int move = moves[i] - 1;
            if (tops[move] != boardLen) {
                int value = board[tops[move]++][move];
                if (!q.isEmpty() && q.peek() == value) {
                    q.pop(); answer++;
                } else {
                    q.add(value);
                }
            }

        }
        return answer*2;
    }
}
