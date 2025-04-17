package a2504;

import java.io.*;
import java.util.*;

public class d17_bj_s5_27964_콰트로치즈피자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        while(st.hasMoreTokens()){
            String ingredient = st.nextToken();
            if(ingredient.endsWith("Cheese")){
                set.add(ingredient);
                if(set.size() == 4){
                    System.out.println("yummy");
                    return;
                }
            }
        }
        System.out.println("sad");
    }
}
