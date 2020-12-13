
// https://programmers.co.kr/learn/courses/30/lessons/12914
// 멀리 뛰기

public class Q12914 {
    public long solution(int n) {

        long[] arr = new long[n + 1];
        arr[0] = arr[1] = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
            }
        }

        return arr[n];
    }
}
