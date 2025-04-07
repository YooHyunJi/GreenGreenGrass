package a2504;

import java.io.*;
import java.util.*;

public class d07_bj_s4_2840_행운의_바퀴 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] alphabets = new char[N];
        boolean[] visit = new boolean[N];
        HashSet<Character> set = new HashSet<>();
        int idx = 0;
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char alphabet = st.nextToken().charAt(0);
            S = S % N == 0? N: S % N;
            idx = (idx + S) % N;
            if((visit[idx] && alphabets[idx] != alphabet) || (!visit[idx] && set.contains(alphabet))){
                System.out.println("!");
                return;
            }
            alphabets[idx] = alphabet;
            visit[idx] = true;
            set.add(alphabet);
        }
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            sb.append(visit[idx]? alphabets[idx]: "?");
            idx = (N + idx - 1) % N;
        }
        System.out.println(sb);
    }
}
