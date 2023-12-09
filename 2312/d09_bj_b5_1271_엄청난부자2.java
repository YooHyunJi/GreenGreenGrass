import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class d09_bj_b5_1271_엄청난부자2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());
        
		System.out.println(num1.divide(num2));
        System.out.println(num1.remainder(num2));
			}
		}
