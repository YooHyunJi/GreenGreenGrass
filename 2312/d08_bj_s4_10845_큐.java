package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d08_bj_s4_10845_큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int n=0; n<N; n++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push":
					queue.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(queue.isEmpty()) System.out.println("-1");
					else System.out.println(queue.pollFirst());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					if(queue.isEmpty()) System.out.println("1");
					else System.out.println("0");
					break;
				case "front":
					if(queue.isEmpty()) System.out.println("-1");
					else System.out.println(queue.peekFirst());
					break;
				case "back":
					if(queue.isEmpty()) System.out.println("-1");
					else System.out.println(queue.peekLast());
					break;
			}
		}
	}
}
