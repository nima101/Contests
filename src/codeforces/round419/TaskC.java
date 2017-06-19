package codeforces.round419;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private int cnt;
    private List<String> tempOut;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        cnt = 0;
        tempOut = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) {
            g[i] = new int[m];
            for (int j = 0; j < m ; j++) {
                g[i][j] = in.nextInt();
            }
        }

        if (n < m) {
            doRow(g, n, m);
            doCol(g, n, m);
        } else {
            doCol(g, n, m);
            doRow(g, n, m);
        }

        if (done(g, n, m)) {
            out.write(cnt + "\n");
            for (String line : tempOut) {
                out.write(line);
                out.write("\n");
            }
        } else {
            out.write("-1");
            out.write("\n");
        }

    }

    private static boolean done(int[][] g, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void doCol(int[][] g, int n, int m) {
        for (int j = 0; j < m; j++) {
            int min = 5000;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, g[i][j]);
            }
            if (min > 0) {
                for (int k = 0; k < n; k++) {
                    g[k][j] -= min;
                }
            }
            for (int k=0; k<min; k++) {
                cnt ++;
                tempOut.add("col " + (j+1));
            }
        }
    }

    private void doRow(int[][] g, int n, int m) {
        for (int i = 0; i < n; i++) {
            int min = 5000;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, g[i][j]);
            }
            if (min > 0) {
                for (int k = 0; k < m; k++) {
                    g[i][k] -= min;
                }
            }
            for (int k=0; k<min; k++) {
                cnt ++;
                tempOut.add("row " + (i+1));
            }
        }
    }

}
