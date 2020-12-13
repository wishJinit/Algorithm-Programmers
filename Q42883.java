
// TODO : 다시 풀어보기
// https://programmers.co.kr/learn/courses/30/lessons/42883
// 큰 수 만들기

public class Q42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0, index = -1, len = number.length(); i < len - k; i++) {
            char max = 0;

            for (int j = index + 1; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    index = j;
                    max = number.charAt(j);
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}