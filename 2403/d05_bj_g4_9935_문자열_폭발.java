package a2403;

import java.io.*;
import java.util.*;

public class d05_bj_g4_9935_문자열_폭발 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        for(int i=0; i<bomb.length/2; i++){
            char tmp = bomb[i];
            bomb[i] = bomb[bomb.length-1-i];
            bomb[bomb.length-1-i] = tmp;
        }
        char trigger = bomb[0];
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char cTarget: target){
            stack.offerLast(cTarget);
            if(cTarget == trigger){
                ArrayList<Character> save = new ArrayList<>();
                for(char cBomb: bomb){
                    if(stack.isEmpty() || stack.peekLast() != cBomb){
                        for(char cSave: save){ stack.offerLast(cSave); }
                        break;
                    }
                    save.add(0, stack.pollLast());
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(char cStack: stack){ sb.append(cStack); }
        System.out.println(sb);
    }
}
