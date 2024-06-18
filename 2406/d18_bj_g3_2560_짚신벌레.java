package a2406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d18_bj_g3_2560_짚신벌레 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int front = 0;
        int end = d+1;
        int bug = 0;
        int[] days = new int[end];
        days[0] = 1;
        for(int n=0; n<N; n++){
            a = (end + a - 1) % end;
            b = (end + b - 1) % end;
            d = (end + d - 1) % end;
            front = (end + front - 1) % end;
            bug = (1000 + bug + days[a] - days[b]) % 1000;
            days[front] = bug;
            days[d] = 0;
        }
        int answer = 0;
        for(int i=0; i<end; i++){
            answer = (answer + days[i]) % 1000;
        }
        System.out.println(answer);
    }
}
