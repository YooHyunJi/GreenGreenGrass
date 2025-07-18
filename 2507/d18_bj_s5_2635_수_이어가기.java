package a2507;

import java.io.*;
import java.util.*;

public class d18_bj_s5_2635_수_이어가기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for(int n=1; n<=N; n++){
            ArrayList<Integer> list = new ArrayList<>();
            int num1 = N;
            int num2 = n;
            int num3 = num1 - num2;
            list.add(num1);
            list.add(num2);
            while(0 <= num3){
                list.add(num3);
                num1 = num2;
                num2 = num3;
                num3 = num1 - num2;
            }
            int size = list.size();
            if(max < size){
                max = size;
                sb = new StringBuilder();
                sb.append(size).append("\n");
                for(int i: list){
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}
