package a2404;

import java.io.*;

public class d06_bj_b2_1100_하얀_칸    {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        int answer = 0;
        for(int r=0; r<8; r++){ board[r] = br.readLine().toCharArray(); }
        for(int r=0; r<8; r++){
            boolean isZero = true;
            if(r % 2 == 1){ isZero = false; }
            for(int c=0; c<8; c++){
                if(((isZero && c%2 == 0) || (!isZero && c%2 == 1)) && board[r][c] == 'F'){ answer++; }
            }
        }
        System.out.println(answer);
    }
}
