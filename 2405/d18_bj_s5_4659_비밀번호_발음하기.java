package a2405;

import java.io.*;
import java.util.*;

public class d18_bj_s5_4659_비밀번호_발음하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> aeiou = new ArrayList<>();
        aeiou.add('a'); aeiou.add('e'); aeiou.add('i'); aeiou.add('o'); aeiou.add('u');
        String pw;
        while(!(pw = br.readLine()).equals("end")){
            String result = "";
            int cnt1 = 0;
            int cnt2_1 = 0;
            int cnt2_2 = 0;
            char prev = '.';
            for(int i=0; i<pw.length(); i++){
                char now = pw.charAt(i);
                if(aeiou.contains(now)){
                    cnt1++;
                    cnt2_1++;
                    cnt2_2 = 0;
                }
                else{
                    cnt2_1 = 0;
                    cnt2_2++;
                }
                if(cnt2_1==3 || cnt2_2==3){
                    result = "not ";
                    break;
                }
                if(prev == now){
                    if(prev != 'e' && prev != 'o'){
                        result = "not ";
                        break;
                    }
                }
                else{
                    prev = now;
                }
            }

            if(cnt1==0){
                result = "not ";
            }
            sb.append("<").append(pw).append("> is ").append(result).append("acceptable.\n");
        }
        System.out.println(sb);
    }
}