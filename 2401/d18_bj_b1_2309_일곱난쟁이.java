package a2401;

import java.io.*;
import java.util.*;

public class d18_bj_b1_2309_일곱난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;
        boolean solved = false;
        for(int i=0; i<9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        sum -= 100;
        Arrays.sort(height);
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(height[i] + height[j] == sum) {
                    solved = true;
                    for(int k=0; k<9; k++) {
                        if(k==i || k==j) { continue; }
                        System.out.println(height[k]);
                    }
                }
                if(solved) { return; }
            }
        }
    }
}