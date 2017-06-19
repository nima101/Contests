package codeforces.round419;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        String[] split = s.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int min = h * 60 + m;

        int inc = 0;
        while(!palindrome(min)) {
            inc++;
            min++;
        }

        out.println(inc);
    }

    private static boolean palindrome(int min) {
        int h = min / 60;
        if (h == 24) h = 0;
        int m = min % 60;
        String sh = String.format("%02d", h);
        String sm = String.format("%02d", m);
        return (sh.charAt(0) == sm.charAt(1) && sh.charAt(1) == sm.charAt(0));
    }

}
