package a2404;

import java.io.*;
import java.util.*;

public class d17_bj_s5_7785_회사에_있는_사람 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet<>( Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String op = st.nextToken();
            if(op.equals("enter")){ treeSet.add(name); }
            else{ treeSet.remove(name); }
        }
        for(String name: treeSet){ sb.append(name).append("\n"); }
        System.out.println(sb);
    }
}
