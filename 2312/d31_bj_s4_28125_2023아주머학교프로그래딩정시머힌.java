package a2312;

import java.io.*;
import java.util.*;

public class d31_bj_s4_28125_2023아주머학교프로그래딩정시머힌 {
    static String translate(String before, HashMap<Character, Character> map){
        StringBuilder result = new StringBuilder();
        int len = before.length();
        int idx = 0;
        int cnt = 0;
        while(idx<len){
            char now = before.charAt(idx);
            if(map.get(now)==null){ result.append(now); }
            else{
                if(map.get(now)=='v'){
                    if(before.charAt(idx+1)=='\''){
                        idx++;
                        result.append("v");
                    }
                    else{
                        idx+=2;
                        result.append("w");
                    }
                }
                else{ result.append(map.get(now)); }
                cnt++;
            }
            idx++;
        }
        if(cnt>=(result.length()+1)/2){ return "I don't understand"; }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('@', 'a'); map.put('[', 'c'); map.put('!', 'i');
        map.put(';', 'j'); map.put('^', 'n'); map.put('0', 'o');
        map.put('7', 't'); map.put('\\', 'v');
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){ sb.append(translate(br.readLine(), map)).append("\n"); }
        System.out.println(sb);
    }
}