package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60057
// 문자열 압축

public class KAKAO_BLIND_RECRUITMENT_2020_01 {
    public static int solution(String s) {
        int len = s.length(), answer = len, n = len / 2;

        while (n > 0) {
            StringBuilder sb = new StringBuilder();
            int cnt;
            for (int i = 0; i < len; i += cnt * n) {
                cnt = 1;
                String tmp = s.substring(i, Math.min(i + n, len));
                for (int j = i + n; j <= len - n; j += n) {
                    if (tmp.equals(s.substring(j, j + n))) cnt++;
                    else break;
                }
                if (cnt > 1) sb.append(cnt);
                sb.append(tmp);
            }
            answer = Math.min(answer, sb.toString().length());
            n--;
        }
        return answer;
    }
}
