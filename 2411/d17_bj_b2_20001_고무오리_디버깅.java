package a2411;

import java.io.*;

public class d17_bj_b2_20001_고무오리_디버깅 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int cnt = 0;
        br.readLine();
        while (!(line = br.readLine()).equals("고무오리 디버깅 끝")) {
            if (line.equals("문제")) {
                cnt++;
            } else {
                if (cnt == 0) {
                    cnt += 2;
                } else {
                    cnt--;
                }
            }
        }
        System.out.println(cnt == 0 ? "고무오리야 사랑해" : "힝구");
    }
}