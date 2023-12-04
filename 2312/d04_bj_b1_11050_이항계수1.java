package etc;

import java.util.Scanner;

public class d04_bj_b1_11050_이항계수1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        System.out.println(multiple(N, K)/multiple(K, K));
    }

    private static int multiple(int from, int cnt){
        int answer = 1;
        for(int c=0; c<cnt; c++) answer *= from--;
        return answer;
    }
}
