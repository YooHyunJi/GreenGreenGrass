package a2402;

import java.io.*;
import java.util.*;

public class d08_bj_s5_11651_좌표정렬하기2 {
    static class Dot implements Comparable<Dot> {
        int x;
        int y;

        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot o){
            if(y < o.y){ return -1; }
            else if(y > o.y){ return 1; }
            if(x < o.x){ return -1; }
            else { return 1; }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Dot[] arr = new Dot[N];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[n] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for(int n=0; n<N; n++){ sb.append(arr[n].x+" "+arr[n].y+"\n"); }
        System.out.println(sb);
    }
}
