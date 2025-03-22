package a2503;

import java.io.*;
import java.util.*;

public class d22_bj_s5_27111_출입_기록 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(b == 1){
                if(set.contains(a)){
                    answer++;
                }
                else{
                    set.add(a);
                }
            }else{
                if(set.contains(a)){
                    set.remove(a);
                }
                else{
                    answer++;
                }
            }
        }
        answer += set.size();
        System.out.println(answer);
    }
}
