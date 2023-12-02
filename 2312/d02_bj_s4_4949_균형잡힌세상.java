package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class d02_bj_s4_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> stack = new ArrayDeque<>();
		while(true){
			String str = br.readLine();
			if(str.equals(".")) return;
			System.out.println(isBalanced(str, stack));
		}
	}

	private static String isBalanced(String str, ArrayDeque<Character> stack){
		stack.clear();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c=='(' || c=='['){
				stack.offer(c);
				continue;
			}
			if(c==')'){
				if(stack.isEmpty() || stack.peekLast()!='(') return "no";
				stack.pollLast();
				continue;
			}
			if(c==']'){
				if(stack.isEmpty() || stack.peekLast()!='[') return "no";
				stack.pollLast();
			}
		}
		if(!stack.isEmpty()) return "no";
		return "yes";
	}
}