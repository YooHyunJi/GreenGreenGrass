package a2507;

import java.io.*;
import java.util.*;

public class d01_bj_b2_1408_24 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer A = new StringTokenizer(br.readLine(), ":");
        StringTokenizer B = new StringTokenizer(br.readLine(), ":");
        int Ha, Ma, Sa;
        int Hb, Mb, Sb;
        Ha = Integer.parseInt(A.nextToken());
        Ma = Integer.parseInt(A.nextToken());
        Sa = Integer.parseInt(A.nextToken());
        Hb = Integer.parseInt(B.nextToken());
        Mb = Integer.parseInt(B.nextToken());
        Sb = Integer.parseInt(B.nextToken());
        int Hc, Mc, Sc;
        if(Sa > Sb){
            Mb--;
            Sb += 60;
        }
        Sc = Sb - Sa;
        if(Ma > Mb){
            Hb--;
            Mb += 60;
        }
        Mc = Mb - Ma;
        if(Ha > Hb){
            Hc = 24 - Ha + Hb;
        }
        else{
            Hc = Hb - Ha;
        }
//        System.out.println(Ha+" "+Ma+" "+Sa);
//        System.out.println(Hb+" "+Mb+" "+Sb);
        System.out.printf("%02d:%02d:%02d", Hc, Mc, Sc);
    }
}
