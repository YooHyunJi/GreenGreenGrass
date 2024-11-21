package a2411;

import java.io.*;
import java.util.*;

public class d22_bj_s4_1302_베스트셀러 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        String answer = "";
        for(int n=0; n<N; n++){
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
            int bookCnt = map.get(title);
            if(max < bookCnt){
                max++;
                answer = title;
            }
            else if(max == bookCnt){
                if(title.compareTo(answer) < 0){
                    answer = title;
                }
            }
        }
        System.out.println(answer);
    }
}
