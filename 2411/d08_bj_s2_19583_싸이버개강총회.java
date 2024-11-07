package a2411;

import java.io.*;
import java.util.*;

public class d08_bj_s2_19583_싸이버개강총회 {

    static int SH, SM, EH, EM, QH, QM;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stTmp = new StringTokenizer(st.nextToken(), ":");
        SH = Integer.parseInt(stTmp.nextToken());
        SM = Integer.parseInt(stTmp.nextToken());
        stTmp = new StringTokenizer(st.nextToken(), ":");
        EH = Integer.parseInt(stTmp.nextToken());
        EM = Integer.parseInt(stTmp.nextToken());
        stTmp = new StringTokenizer(st.nextToken(), ":");
        QH = Integer.parseInt(stTmp.nextToken());
        QM = Integer.parseInt(stTmp.nextToken());

        HashSet<String> set = new HashSet<>();
        int answer = 0;

        String line;
        while ((line = br.readLine()) != null) {
            if(line.isEmpty()){ break; }
            st = new StringTokenizer(line);
            stTmp = new StringTokenizer(st.nextToken(), ":");
            int HH = Integer.parseInt(stTmp.nextToken());
            int HM = Integer.parseInt(stTmp.nextToken());
            String name = st.nextToken();
//            System.out.println("\n"+HH+" "+HM+" "+name);
            if (ipsilCheck(HH, HM)) {
                set.add(name);
//                System.out.println(set);
                continue;
            }
            else if(streaming(HH, HM) || streamingOver(HH, HM)){
                continue;
            }
            if (set.contains(name)) {
//                System.out.println(name);
                answer++;
                set.remove(name);
            }
        }
        System.out.println(answer);
    }

    static boolean ipsilCheck(int h, int m) {
        return h < SH || (h == SH && m <= SM);
    }

//    static boolean streaming(int h, int m) {
//        return h < EH || (h == EH && m < EM);
//    }
//
//    static boolean streamingOver(int h, int m) {
//        return QH < h || (h == QH && QM < m);
//    }

    static boolean streaming(int h, int m){
        return h < EH || (h == EH && m < EM);
    }

    static boolean streamingOver(int h, int m){
        return QH < h || (h == QH && QM < m);
    }
}