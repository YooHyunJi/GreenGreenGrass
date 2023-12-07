package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d07_bj_s4_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int n=0; n<N; n++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push":
					stack.offer(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.isEmpty()) System.out.println("-1");
					else System.out.println(stack.pollLast());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.isEmpty()) System.out.println("1");
					else System.out.println("0");
					break;
				case "top":
					if(stack.isEmpty()) System.out.println("-1");
					else System.out.println(stack.peekLast());
					break;
			}
		}
	}
}
