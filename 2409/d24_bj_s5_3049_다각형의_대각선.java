package a2409;

import java.io.*;

public class d24_bj_s5_3049_다각형의_대각선 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = (N * (N - 1) * (N - 2) * (N - 3)) / 24;
        System.out.println(answer);
    }
}
