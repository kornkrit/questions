package CodeFight;

import java.util.Arrays;

public class TransactionsStability {
    /* *
    System.out.print(transactionsStability(new int[]{1,4,1}));
    * */
    double transactionsStability(int[] t) {
        Arrays.sort(t);

        double min=t[0];
        double max=t[t.length-1];
        double o=min/max;
        double lock=max*.5;
        for(int i=t.length-1;i>0;i--){
            max=Math.max(Math.max(t[i]*.5,t[i-1]),lock);
            min=Math.min(t[i]*.5,t[0]);
            double p=min/max;
            if(p>o) o=p;
        }

        return o;
    }

}
