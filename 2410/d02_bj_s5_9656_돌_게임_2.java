package a2410;

import java.io.*;

public class d02_bj_s5_9656_돌_게임_2 {
  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] name = {"SK", "CY"};
    int divide = N / 3;
    int remain = N - divide;
    System.out.println(name[(divide + remain) % 2]);
  }
}
