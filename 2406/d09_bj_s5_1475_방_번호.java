package a2406;

import java.io.*;
import java.util.*;

public class d09_bj_s5_1475_방_번호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<9; i++){ map.put(i, 0); }
        for(char c: arr) {
            int n = c - '0'==9? 6: c - '0';
            map.replace(n, map.get(n)+1);
        }
        map.replace(6, Math.round((float) map.get(6) /2));
        int answer = -1;
        for(int num: map.values()){
            answer = Math.max(answer, num);
        }
        System.out.println(answer);
    }
}
