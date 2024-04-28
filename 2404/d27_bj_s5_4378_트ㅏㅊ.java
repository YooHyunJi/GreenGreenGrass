package a2404;

import java.io.*;
import java.util.*;

public class d27_bj_s5_4378_트ㅏㅊ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '`');
        map.put('2', '1');
        map.put('3', '2');
        map.put('4', '3');
        map.put('5', '4');
        map.put('6', '5');
        map.put('7', '6');
        map.put('8', '7');  
        map.put('9', '8');
        map.put('0', '9');
        map.put('-', '0');
        map.put('=', '-');
        map.put('W', 'Q');
        map.put('E', 'W');
        map.put('R', 'E');
        map.put('T', 'R');
        map.put('Y', 'T');
        map.put('U', 'Y');
        map.put('I', 'U');
        map.put('O', 'I');
        map.put('P', 'O');
        map.put('[', 'P');
        map.put(']', '[');
        map.put('\\', ']');
        map.put('S', 'A');
        map.put('D', 'S');
        map.put('F', 'D');
        map.put('G', 'F');
        map.put('H', 'G');
        map.put('J', 'H');
        map.put('K', 'J');
        map.put('L', 'K');
        map.put(';', 'L');
        map.put('\'', ';');
        map.put('X', 'Z');
        map.put('C', 'X');
        map.put('V', 'C');
        map.put('B', 'V');
        map.put('N', 'B');
        map.put('M', 'N');
        map.put(',', 'M');
        map.put('.', ',');
        map.put('/', '.');
        String str = "";
        while((str = br.readLine()) != null && !str.isEmpty()){
            char[] line = str.toCharArray();
            for(char c: line){
                if(c==' '){ sb.append(c); }
                else{ sb.append(map.get(c)); }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
