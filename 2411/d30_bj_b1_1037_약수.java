import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<N; n++) {
			int now = Integer.parseInt(st.nextToken());
			max = now > max ? now : max;
			min = now < min ? now : min;
		}
		System.out.println(max * min);
	}
}
