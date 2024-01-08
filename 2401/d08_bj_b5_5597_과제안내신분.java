package a2401;

import java.io.*;
import java.util.*;

public class d08_bj_b5_5597_과제안내신분 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isSubmit = new boolean[31];
        for(int i=0; i<28; i++) { isSubmit[Integer.parseInt(br.readLine())] = true; }
        for(int i=1; i<=30; i++) {
            if(isSubmit[i]) { continue; }
            System.out.println(i);
        }
    }
}