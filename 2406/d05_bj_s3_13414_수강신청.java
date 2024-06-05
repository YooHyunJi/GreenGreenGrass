package a2406;

import java.io.*;
import java.util.*;

public class d05_bj_s3_13414_수강신청 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<String> list = new LinkedHashSet<>();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        for(int l=0; l<L; l++){
            String student = br.readLine();
            if(list.contains(student)) {
                list.remove(student);
            }
            list.add(student);
        }
        Iterator<String> itr = list.iterator();
        for(int k=0; itr.hasNext() && k<K; k++){
            sb.append(itr.next()).append("\n");
        }
        System.out.println(sb);
    }
}
