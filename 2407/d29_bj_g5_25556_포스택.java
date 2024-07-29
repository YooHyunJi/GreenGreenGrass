package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d29_bj_g5_25556_포스택 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer>[] stacks = new ArrayDeque[4];
        for(int s=0; s<4; s++){ stacks[s] = new ArrayDeque<>(); }
        for(int n=0; n<N; n++){
            boolean isPossible = false;
            int num = Integer.parseInt(st.nextToken());
            for(int s=0; s<4; s++){
                if(stacks[s].isEmpty() || stacks[s].peekLast() < num){
                    stacks[s].offerLast(num);
                    isPossible = true;
                    break;
                }
            }
            if(isPossible){ continue; }
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
