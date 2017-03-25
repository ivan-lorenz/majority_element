import java.util.*;
import java.io.*;

public class MajorityElement {
    public static int getMajorityElementLoop(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int mid = left + ((right - left)) / 2;
        int leftCandidate = getMajorityElementLoop(a, left, mid );
        int rightCandidate = getMajorityElementLoop(a, mid + 1, right);

        int leftCandidateCount = 0;
        int rightCandidateCount = 0;
        for (int i = left; i <= right; i ++) {
            if (a[i] == leftCandidate)
                leftCandidateCount++;
            if (a[i] == rightCandidate)
                rightCandidateCount++;
        }

        int majority = (right - left + 1) / 2;
        if (leftCandidateCount >= rightCandidateCount && leftCandidateCount > majority) {
            return leftCandidate;
        } else if (rightCandidateCount > majority)
            return  rightCandidate;

        return -1;
    }

    public static int getMajorityElement(int[] a, int left, int right) {
        return getMajorityElementLoop(a,left,right-1);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

