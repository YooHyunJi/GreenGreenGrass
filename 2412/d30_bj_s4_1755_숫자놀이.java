package a2412;

import java.io.*;
import java.util.*;

public class d30_bj_s4_1755_숫자놀이 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int num=M; num<=N; num++){
            String tmp = "";
            if(0 < num / 10){
                tmp += numToString(num/10);
                tmp += " ";
            }
            tmp += numToString(num%10);
            pq.add(tmp);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            sb.append(stringToNum(pq.poll())).append(" ");
            if(++cnt % 10 == 0){ sb.append("\n"); }
        }
        System.out.println(sb);
    }

    static String numToString(int num){
        switch (num){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    static int charToNum(String str) {
        switch (str){
            case "zero" : return 0;
            case "one" : return 1;
            case "two" : return 2;
            case "three" : return 3;
            case "four" : return 4;
            case "five" : return 5;
            case "six" : return 6;
            case "seven" : return 7;
            case "eight" : return 8;
            case "nine" : return 9;
            default : return 0;
        }
    }
    
    static int stringToNum(String str){
        StringTokenizer st = new StringTokenizer(str);
        int num = 0;
        while(st.hasMoreTokens()){
            num = 10 * num + charToNum(st.nextToken());
        }
        return num;
    }
}
