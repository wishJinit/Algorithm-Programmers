
// https://programmers.co.kr/learn/courses/30/lessons/12901
// 2016년

import java.io.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Q12901 {
    public static String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        return localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
    }
}
