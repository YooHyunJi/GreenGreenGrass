package a231102;

import java.util.*;
import java.io.*;

public class Main_g2_1918_후위표기식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] infix = br.readLine().split("");
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayDeque<String> stack = new ArrayDeque<String>();
		map.put("+", 0); map.put("-", 0);
		map.put("*", 1); map.put("/", 1);
		map.put("(", -1); map.put(")", -1);
		for(String now: infix) {
			// operand
			if(map.get(now)==null) sb.append(now);
			
			// operator
			else {
				if(now.equals("(")) stack.addFirst(now);
				else if(now.equals(")")) {
					while(!stack.peek().equals("(") && !stack.isEmpty()) sb.append(stack.removeFirst());
					stack.removeFirst(); }
				else {
					while(!stack.isEmpty() && map.get(stack.peek())>=map.get(now)) sb.append(stack.removeFirst());
					stack.addFirst(now); } }
		}
		while(!stack.isEmpty()) sb.append(stack.removeFirst());
		System.out.println(sb.toString());
	}
}
