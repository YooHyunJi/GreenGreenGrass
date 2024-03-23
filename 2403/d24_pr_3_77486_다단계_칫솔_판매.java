package a2403.week4;

import java.util.*;

public class pr_3_77486_다단계_칫솔_판매 {
    static class Info{
        int idx;
        String parent;

        public Info(int idx, String parent){
            this.idx = idx;
            this.parent = parent;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int lenMember = enroll.length;
        int lenIncome = seller.length;
        int[] answer = new int[lenMember];
        HashMap<String, Info> map = new HashMap<>();

        for(int i=0; i<lenMember; i++){ map.put(enroll[i], new Info(i, referral[i])); }
        for(int i=0; i<lenIncome; i++){
            String member = seller[i];
            int income = amount[i] * 100;
            int parentIncome = income / 10;
            int childIncome = income - parentIncome;
            while(true){
                if(member.equals("-") || childIncome == 0){ break; }
                answer[map.get(member).idx] += childIncome;
                member = map.get(member).parent;
                childIncome = parentIncome;
                parentIncome = childIncome / 10;
                childIncome -= parentIncome;
            }
        }
        return answer;
    }
}
