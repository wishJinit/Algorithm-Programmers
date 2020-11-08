// https://programmers.co.kr/learn/courses/30/lessons/12922
// 수박수박수박수박수박수?

public class Q12922 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        answer.append("수박".repeat(Math.max(0, (n / 2))));
        if(n%2==1) answer.append("수");
        return answer.toString();
    }
}
