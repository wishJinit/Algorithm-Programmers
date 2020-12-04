// https://programmers.co.kr/learn/courses/30/lessons/43165
// 타겟 넘버

public class Q43165 {
    int[] n;
    int t, len, answer = 0;

    public int solution(int[] numbers, int target) {
        n = numbers;
        t = target;
        len = numbers.length;
        dfs(0, 0);
        return answer;
    }

    private void dfs(int sum, int idx) {
        if (idx == len) {
            if (t == sum) answer++;
            return;
        }
        dfs(sum + n[idx], idx + 1);
        dfs(sum - n[idx], idx + 1);
    }
}
