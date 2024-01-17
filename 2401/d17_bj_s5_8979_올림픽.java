package a2401;

import java.io.*;
import java.util.*;

public class d17_bj_s5_8979_올림픽 {
    static class Country implements Comparable<Country> {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if(gold > o.gold) { return -1; }
            else if(gold < o.gold) { return 1; }
            else {
                if(silver > o.silver) { return -1; }
                else if(silver < o.silver) { return 1; }
                else { return Integer.compare(o.bronze, bronze); }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] medals = new Country[N];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            medals[n] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(medals);
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if (medals[i].num == K) {
                for(int j=i-1; j>=0; j--) {
                    if(medals[i].compareTo(medals[j]) > 0) { break; }
                    cnt++;
                }
                System.out.println(i-cnt+1);
                break;
            }
        }
    }
}