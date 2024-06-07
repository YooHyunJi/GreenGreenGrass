package a2406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d07_bj_g3_20366_같이_눈사람_만들래 {
    static class Snowman implements Comparable<Snowman>{
        int idx1;
        int idx2;
        int height;

        public Snowman(int idx1, int idx2, int height){
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.height = height;
        }

        @Override
        public int compareTo(Snowman o){
            return Integer.compare(height, o.height);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Snowman[] snowmans = new Snowman[N*(N-1)/2];
        int cnt = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                snowmans[cnt++] = new Snowman(i, j, arr[i]+arr[j]);
            }
        }
        Arrays.sort(snowmans);
        int gap = Integer.MAX_VALUE;
        for(int i=1; i<N*(N-1)/2; i++){
            if(snowmans[i].height-snowmans[i-1].height < gap && !usingSameSnowball(snowmans[i-1], snowmans[i])){
                gap = snowmans[i].height-snowmans[i-1].height;
            }
        }
        System.out.println(gap);
    }
    static boolean usingSameSnowball(Snowman s1, Snowman s2){
        return s1.idx1 == s2.idx1 || s1.idx1 == s2.idx2 || s1.idx2 == s2.idx1 || s1.idx2 == s2.idx2;
    }
}
