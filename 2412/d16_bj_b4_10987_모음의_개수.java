import java.io.*;
import java.util.*;

public class d16_bj_b4_10987_모음의_개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        for(char c : arr){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
               answer++;
            }
        }
        System.out.println(answer);
    }
}
