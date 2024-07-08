package a2407;

import java.io.*;
import java.util.*;

public class d09_bj_s1_5525_IOIOI {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        char[] M = br.readLine().toCharArray();
        ArrayList<Integer> P = new ArrayList<>();
        boolean isCounting = false, isFromO = false;
        int length = 0;
        for(int i=0; i<S-1; i++){
            if(M[i] != M[i+1]){
                if(!isCounting){
                    isCounting = true;
                    length = 1;
                    if(M[i] == 'O'){ isFromO = true; }
                }
                length++;
                if(i==S-2){
                    P.add(length);
                }
            }
            else if(isCounting){
                if(isFromO){ length--; }
                P.add(length);
                isCounting = false;
                isFromO = false;
                length = 0;
            }
        }
        int answer = 0;
        int LN = 2*N + 1;
        for(int p: P){
            if(p < LN){ continue; }
            answer += (p - LN) / 2 + 1;
        }
        System.out.println(answer);
    }
}
