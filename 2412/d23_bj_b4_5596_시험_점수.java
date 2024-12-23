import java.io.*;
import java.util.*;

public class d23_bj_b4_5596_시험_점수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = 0;
        int T = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(st.nextToken());
            S += num;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(st.nextToken());
            T += num;
        }
        System.out.println(Math.max(S, T));
    }
}
