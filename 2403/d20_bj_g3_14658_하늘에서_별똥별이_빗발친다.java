package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d20_bj_g3_14658_하늘에서_별똥별이_빗발친다 {
    static class Star{
        int x;
        int y;

        public Star(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        st.nextToken();
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Star[] stars = new Star[K];
        int answer = 0;
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[k] = new Star(y, x);
        }

        for(int s1=0; s1<K; s1++){
            for(int s2=0; s2<K; s2++){
                int r = stars[s1].y;
                int c = stars[s2].x;
                int cnt = 0;
                for(int k=0; k<K; k++){
                    if(c <= stars[k].x && stars[k].x <= c+L && r <= stars[k].y && stars[k].y <= r+L){ cnt++; }
                }
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(K - answer);
    }
}