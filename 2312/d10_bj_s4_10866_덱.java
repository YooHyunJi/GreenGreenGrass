package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d10_bj_s4_10866_덱 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int n=0; n<N; n++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push_front":
					deque.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.offerLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.pollFirst()).append("\n");
					break;
				case "pop_back":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.pollLast()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					if(deque.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case "front":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peekFirst()).append("\n");
					break;
				case "back":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peekLast()).append("\n");
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
