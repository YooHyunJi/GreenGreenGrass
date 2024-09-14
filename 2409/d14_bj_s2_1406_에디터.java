package a2409;

import java.io.*;
import java.util.*;

public class d14_bj_s2_1406_에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        int N = word.length;
        int M = Integer.parseInt(br.readLine());
        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();
        for(int n=0; n<N; n++){
            left.offerFirst(word[n]);
        }
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op){
                case "L":
                    if(left.isEmpty()){
                        continue;
                    }
                    right.offerFirst(left.pollFirst());
                    break;
                case "D":
                    if(right.isEmpty()){
                        continue;
                    }
                    left.offerFirst(right.pollFirst());
                    break;
                case "B":
                    if(left.isEmpty()){
                        continue;
                    }
                    left.pollFirst();
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    left.offerFirst(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()){
            sb.append(left.pollLast());
        }
        while(!right.isEmpty()){
            sb.append(right.pollFirst());
        }
        System.out.println(sb);
    }
}
