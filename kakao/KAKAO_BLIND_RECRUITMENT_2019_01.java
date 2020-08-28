package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/42889
// 실패율

import java.util.ArrayList;
import java.util.Arrays;

public class KAKAO_BLIND_RECRUITMENT_2019_01 {

    static class StageClass {
        int stage;
        float fail;

        StageClass(int stage, float fail) {
            this.stage = stage;
            this.fail = fail;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        Arrays.sort(stages);

        ArrayList<StageClass> arrayList = new ArrayList<>();
        int e = 0, cnt = 0;
        for (int i = 0; i < len; i += cnt) {
            int num = stages[i];
            if (num > N) break;
            setEmptyNum(arrayList, e, num - 1);
            cnt = 0;
            while (i + cnt < len && num == stages[i + cnt]) cnt++;
            arrayList.add(new StageClass(num, (float) cnt / (len - i)));
            e = num;
        }
        setEmptyNum(arrayList, e, N);

        arrayList.sort((o1, o2) -> (Float.compare(o2.fail, o1.fail)));
        for (int i = 0; i < N; i++) answer[i] = arrayList.get(i).stage;

        return answer;
    }

    static void setEmptyNum(ArrayList<StageClass> arrayList, int s, int e) {
        for (int i = s + 1; i <= e; i++) arrayList.add(new StageClass(i, 0));
    }
}
