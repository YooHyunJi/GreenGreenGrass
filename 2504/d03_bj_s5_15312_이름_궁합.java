package a2504;

import java.io.*;
import java.util.*;

public class d03_bj_s5_15312_이름_궁합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 3);
        map.put('B', 2);
        map.put('C', 1);
        map.put('D', 2);
        map.put('E', 3);
        map.put('F', 3);
        map.put('G', 2);
        map.put('H', 3);
        map.put('I', 3);
        map.put('J', 2);
        map.put('K', 2);
        map.put('L', 1);
        map.put('M', 2);
        map.put('N', 2);
        map.put('O', 1);
        map.put('P', 2);
        map.put('Q', 2);
        map.put('R', 2);
        map.put('S', 1);
        map.put('T', 2);
        map.put('U', 1);
        map.put('V', 1);
        map.put('W', 1);
        map.put('X', 2);
        map.put('Y', 2);
        map.put('Z', 1);
        int len = A.length();
        int[] whole = new int[len * 2];
        for(int i=0; i<len * 2; i++){
            if(i % 2 == 0){
                whole[i] = map.get(A.charAt(i/2));
            }
            else{
                whole[i] = map.get(B.charAt(i/2));
            }
        }
        for(int i=len * 2 - 1; i>1; i--){
            for(int j=0; j<i; j++){
                whole[j] = (whole[j] + whole[j+1]) % 10;
            }
        }
        System.out.println(whole[0]+""+whole[1]);
    }
}
