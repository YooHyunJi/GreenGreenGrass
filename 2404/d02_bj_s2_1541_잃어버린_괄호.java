package a2404;

import java.io.*;
import java.util.*;

public class d02_bj_s2_1541_잃어버린_괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        int[] numbers = new int[25];
        boolean[] operators = new boolean[25];
        int idxN = 0, idxO = 0;
        while (st.hasMoreTokens()){
            String now = st.nextToken();
            if(now.equals("+")){ operators[idxO++] = true; }
            else if(now.equals("-")){ operators[idxO++] = false; }
            else{ numbers[idxN++] = Integer.parseInt(now); }
        }
        int answer = numbers[0];
        int sumMinus = 0;
        boolean isMinus = false;
        for(int i=0; i<idxO; i++){
            if(operators[i]){
                if(isMinus){ sumMinus += numbers[i+1]; }
                else{ answer += numbers[i+1]; }
            }
            else{
                if(!isMinus){ isMinus = true; }
                else{ answer -= sumMinus; }
                sumMinus = numbers[i+1];
            }
        }
        if(isMinus){ answer -= sumMinus; }
        System.out.println(answer);
    }
}
