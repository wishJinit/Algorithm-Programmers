package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/42888
// 오픈채팅방

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KAKAO_BLIND_RECRUITMENT_2019_02 {

    public static String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String msg = st.nextToken(), id = st.nextToken(), nickName = null;

            if (!msg.equals("Leave")) nickName = st.nextToken();
            if (!msg.equals("Change")) answer.add(id + "-" + getMessage(msg));
            if (nickName != null) hm.put(id, nickName);
        }

        for (int i = 0, len = answer.size(); i < len; i++) {
            String[] msg = answer.get(i).split("-");
            answer.set(i, hm.get(msg[0]) + msg[1]);
        }
        return answer.toArray(new String[0]);
    }

    private static String getMessage(String state) {
        String answer = null;
        switch (state) {
            case "Enter":
                answer = "님이 들어왔습니다.";
                break;
            case "Leave":
                answer = "님이 나갔습니다.";
                break;
        }
        return answer;
    }
}
