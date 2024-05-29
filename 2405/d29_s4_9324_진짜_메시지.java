package a2405;

import java.io.*;
import java.util.*;

public class d29_s4_9324_진짜_메시지 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            HashMap<Character, Integer> map = new HashMap<>();
            String code = br.readLine();
            String result = "OK";
            for(int i=0; i<code.length(); i++){
                char now = code.charAt(i);
                if(map.containsKey(now)){
                    map.replace(now, map.get(now)+1);
                    if(map.get(now) == 3){
                        if(i+1 == code.length() || now != code.charAt(i+1)){
                            result = "FAKE";
                            break;
                        }
                        i++;
                        map.remove(now);
                    }
                }
                else{
                    map.put(now, 1);
                }
            }
            answer.append(result).append("\n");
        }
        System.out.println(answer);
    }
}
