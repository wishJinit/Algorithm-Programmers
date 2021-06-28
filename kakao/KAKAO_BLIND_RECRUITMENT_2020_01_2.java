package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60057
// 문자열 압축

public class KAKAO_BLIND_RECRUITMENT_2020_01_2 {
    public static int solution(String s) {
        final int LEN = s.length();

        int answer = LEN;
        for (int size = LEN / 2; size >= 1; size--) {
            StringBuilder sb = new StringBuilder();

            int cnt;
            for (int i = 0; i < LEN; i += size * cnt) {
                cnt = 1;
                String word = s.substring(i, Math.min(i + size, LEN));
                for (int j = i + size; j < LEN; j += size) {
                    if (word.equals(s.substring(j, Math.min(j + size, LEN)))) cnt++;
                    else break;
                }
                if (cnt > 1) sb.append(cnt);
                sb.append(word);
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
