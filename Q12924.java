// https://programmers.co.kr/learn/courses/30/lessons/12924
// 숫자의 표현

public class Q12924 {
    public int solution(int n) {
        int answer = 0, s = 0, e = 1, sum = s + e;
        while (s <= n) {
            if (sum < n) {
                sum += ++e;
            } else if (sum > n) {
                sum -= ++s;
            }
            if (sum == n) {
                answer++;
                sum -= ++s;
            }
        }
        return answer;
    }
}
