package etc;

import java.util.Scanner;

public class d01_bj_b1_2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int div = 1;
        int small = num1<num2? num1: num2;
        for(int i=2; i<=small; i++){ if(num1%i==0 && num2%i==0) div = i; }
        System.out.println(div);
        System.out.println((num1/div)*(num2/div)*div);
    }
}
