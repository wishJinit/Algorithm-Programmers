
// https://programmers.co.kr/learn/courses/30/lessons/42586
// 기능개발

import java.util.ArrayList;

public class Q42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int len = progresses.length, complete = 0;
        while (complete < len) {
            int cnt = 0;
            for (int i = complete; i < len; i++) progresses[i] += speeds[i];
            for (int i = complete; i < len; i++) {
                if(progresses[i] >= 100) cnt++;
                else break;
            }
            if (cnt > 0) {
                arrayList.add(cnt);
                complete += cnt;
            }
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = arrayList.get(i);
        return answer;
    }
}
