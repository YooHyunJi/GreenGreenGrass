package a2406;

public class d17_pr_2_86971_전력망을_둘로_나누기 {
    static int[] p;

    public int solution(int n, int[][] wires) {
        int answer = 99999;
        p = new int[n+1];
        for(int i=1; i<=n; i++){ p[i] = i; }
        int w = wires.length;

        for(int i=0; i<w; i++){
            for(int j=1; j<=n; j++){ p[j] = j; }
            for(int j=0; j<w; j++){
                if(i==j){ continue; }
                union(wires[j][0], wires[j][1]);
            }
            int groupA = 0, groupB = 0;
            for(int j=1; j<=n; j++){
                if(find(j) == find(1)){ groupA++; }
                else{ groupB++; }
            }
            answer = Math.min(answer, Math.abs(groupA-groupB));
        }
        return answer;
    }

    static int find(int x){
        if(p[x] == x){ return x; }
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){ return; }
        p[py] = px;
    }
}
