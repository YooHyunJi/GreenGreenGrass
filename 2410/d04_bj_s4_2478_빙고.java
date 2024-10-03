package a2410;

import java.io.*;
import java.util.*;

public class d04_bj_s4_2478_빙고 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[][] visit = new boolean[5][5];
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int r = 0; r < 5; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 5; c++) {
        map.put(Integer.parseInt(st.nextToken()), new int[] {r, c});
      }
    }
    int answer = 0;
    for (int r = 0; r < 5; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 5; c++) {
        answer++;
        int num = Integer.parseInt(st.nextToken());
        int[] pos = map.get(num);
        visit[pos[0]][pos[1]] = true;
        if (isBingo(visit)) {
          System.out.println(answer);
          return;
        }
      }
    }
  }

  static boolean isBingo(boolean[][] visit) {
    int cnt = 0;
    for (int r = 0; r < 5; r++) {
      boolean isLine = true;
      for (int c = 0; c < 5; c++) {
        if (!visit[r][c]) {
          isLine = false;
          break;
        }
      }
      if (isLine) {
        cnt++;
      }
    }

    for (int c = 0; c < 5; c++) {
      boolean isLine = true;
      for (int r = 0; r < 5; r++) {
        if (!visit[r][c]) {
          isLine = false;
          break;
        }
      }
      if (isLine) {
        cnt++;
      }
    }

    boolean isLine = true;
    for (int r = 0; r < 5; r++) {
      if (!visit[r][r]) {
        isLine = false;
        break;
      }
    }
    if (isLine) {
      cnt++;
    }

    isLine = true;
    for (int r = 0; r < 5; r++) {
      if (!visit[r][4 - r]) {
        isLine = false;
        break;
      }
    }
    if (isLine) {
      cnt++;
    }

    return cnt >= 3;
  }
}
