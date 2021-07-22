package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60060
// 가사 검색

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2020 {
    private final int MAX_WORD_LENGTH = 10000;

    List<List<String>> list = new ArrayList<>();
    List<List<String>> reverseList = new ArrayList<>();

    public int[] solution(String[] words, String[] queries) {
        final int queryLen = queries.length;
        int[] answer = new int[queryLen];

        for (int i = 0, len = MAX_WORD_LENGTH + 1; i <= len; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (String word : words) {
            int wordLen = word.length();
            list.get(wordLen).add(word);
            reverseList.get(wordLen).add(new StringBuilder().append(word).reverse().toString());
        }

        for (int i = 0, len = MAX_WORD_LENGTH + 1; i <= len; i++) {
            Collections.sort(list.get(i));
            Collections.sort(reverseList.get(i));
        }

        for (int i = 0; i < queryLen; i++) {
            String query = queries[i];
            int len = query.length();
            if (query.charAt(0) == '?') {
                query = new StringBuilder(query).reverse().toString();
                String start = query.replaceAll("\\?", "a");
                String end = query.replaceAll("\\?", "z");
                answer[i] = getWordsCount(reverseList.get(len), start, end);
            } else {
                String start = query.replaceAll("\\?", "a");
                String end = query.replaceAll("\\?", "z");
                answer[i] = getWordsCount(list.get(len), start, end);
            }
        }

        return answer;
    }

    private int getWordsCount(List<String> wordList, String start, String end) {
        int minIdx = getWordsMinIndex(wordList, start);
        int maxIdx = getWordsMaxIndex(wordList, end);
        return maxIdx - minIdx;
    }

    private int getWordsMinIndex(List<String> wordList, String query) {
        int start = 0, end = wordList.size();
        while (start < end) {
            int mid = (start + end) >> 1;
            if (wordList.get(mid).compareTo(query) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private int getWordsMaxIndex(List<String> wordList, String query) {
        int start = 0, end = wordList.size();
        while (start < end) {
            int mid = (start + end) >> 1;
            if (wordList.get(mid).compareTo(query) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
