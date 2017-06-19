package codeforces.round419;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    private static class Range {
        int idx;
        boolean start;

        public Range(int idx, boolean start) {
            this.idx = idx;
            this.start = start;
        }

        public int getIdx() {
            return idx;
        }

        public boolean isStart() {
            return start;
        }
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        List<Range> ranges = new ArrayList<>(2*n);
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            ranges.add(new Range(start, true));
            ranges.add(new Range(end+1, false));
        }
        Collections.sort(ranges, Comparator.comparing(Range::getIdx));
        int min = ranges.get(0).getIdx();
        int max = ranges.get(ranges.size()-1).getIdx();

        final int maxn = 200005;
        int[] overlaps = new int[maxn];
        int cur = 0;
        int ri = 0;
        for (int i = min; i <= max; i++) {
            while(ri < ranges.size() && ranges.get(ri).getIdx() == i) {
                if (ranges.get(ri).isStart()) {
                    cur++;
                } else {
                    cur--;
                }
                ri++;
            }
            overlaps[i] = cur;
        }

        int[] sum = new int[maxn];
        for (int i = min; i < maxn; i++) {
            sum[i] = overlaps[i] >= k ? 1 : 0;
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            out.println(sum[end] - sum[start - 1]);
        }
    }
}
