package etc;

import java.io.*;
import java.util.*;

public class d10_bj_s4_9012_괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) sb.append(balance(br.readLine().toCharArray())).append("\n");
		System.out.println(sb.toString());
	}

	private static String balance(char[] line){
		ArrayDeque<Character> stack = new ArrayDeque();
		for(int c=0; c<line.length; c++){
			if(line[c]=='(') stack.offerLast('(');
			else{
				if(stack.isEmpty() || stack.peekLast()!='(') return("NO");
				else stack.pollLast();
			}
		}
		if(stack.isEmpty()) return("YES");
		else return("NO");
	}
}