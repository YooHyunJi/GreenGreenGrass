package a1005.offline;

import java.util.*;
import java.io.*;

public class Solution_d0_5658_보물상자비밀번호_서울_20반_유현지 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d0_5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			char[] arr = br.readLine().toCharArray();
			
			PriorityQueue<String> pq = new PriorityQueue<String>(Collections.reverseOrder());
			for(int r=0; r<N/4; r++) {
				for(int i=0; i<4; i++) {
					String newNum = "";
					for(int j=0; j<N/4; j++) newNum += arr[(r+(N/4*i)+j)%N];
					if(!pq.contains(newNum)) pq.offer(newNum);
				}
			}
			for(int k=0; k<K-1; k++) pq.poll();
			sb.append("#").append(t).append(" ").append(Integer.parseInt(pq.poll(), 16)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
