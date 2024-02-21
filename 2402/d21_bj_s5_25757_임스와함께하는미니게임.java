package a2402;

import java.io.*;
import java.util.*;

public class d21_bj_s5_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        String G = st.nextToken();
        for(int n=0; n<N; n++) { set.add(br.readLine()); }
        if(G.equals("Y")){ System.out.println(set.size()); }
        else if(G.equals("F")){ System.out.println(set.size()/2); }
        else { System.out.println(set.size()/3); }
    }
}
