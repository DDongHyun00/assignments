package week2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q1021_boj {
    /**
     * 메모리: 14312 KB  ( / 128000 KB)
     * 시간: 124 ms     ( / 2000 ms)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기 N (N은 50보다 작거나 같은 자연수)
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수 M (M은 N보다 작거나 같은 자연수)

        if (N < 0 || N > 50 || M > N) {
            throw new IllegalArgumentException("예외처리");
        }

        int[] locations = new int[M]; // 뽑을려는 수 위치 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++) {
            deq.addLast(i);
        }

        int mincnt = 0; // 연산 최소횟수
        for (int i = 0; i < M; i++) {
            int index = -1; // 초기 인덱스값 -1로 지정해 못찾으면 -1 반환하게함
            int location = locations[i]; // location은 위치번호숫자 locations는 위치번호 저장배열
            for (int j = 0; j < N; j++) {
                if (deq.peekFirst() == location) {
                    index = j;
                    break;
                }
                deq.addLast(deq.removeFirst());
            }
            int leftloc = index;
            int rightloc = deq.size() - index;
            mincnt += Math.min(leftloc, rightloc);
            deq.removeFirst();
        }

        bw.write(Integer.toString(mincnt));
        bw.flush();
        bw.close();
    }
}
