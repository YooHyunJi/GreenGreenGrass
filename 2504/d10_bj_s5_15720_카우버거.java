package a2504;

import java.io.*;
import java.util.*;

public class d10_bj_s5_15720_카우버거 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<Integer> listB = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();
        ArrayList<Integer> listD = new ArrayList<>();
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            int n = Integer.parseInt(st.nextToken());
            listB.add(n);
            sum += n;
        }
        listB.sort(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            int n = Integer.parseInt(st.nextToken());
            listC.add(n);
            sum += n;
        }
        listC.sort(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<D; i++){
            int n = Integer.parseInt(st.nextToken());
            listD.add(n);
            sum += n;
        }
        listD.sort(Collections.reverseOrder());

        int cnt = Math.min(B, Math.min(C, D));
        int min = 0;
        for(int i=0; i<cnt; i++){
            min += listB.get(i) + listC.get(i) + listD.get(i);
        }
        min *= 0.9;

        for(int i=cnt; i<B; i++){
            min += listB.get(i);
        }
        for(int i=cnt; i<C; i++){
            min += listC.get(i);
        }
        for(int i=cnt; i<D; i++){
            min += listD.get(i);
        }

        System.out.println(sum);
        System.out.println(min);
    }
}
