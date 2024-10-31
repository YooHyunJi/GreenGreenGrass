package a2410;

import java.io.*;

public class d30_bj_s5_5555_반지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            line = line.concat(line);
            if (line.contains(target)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
