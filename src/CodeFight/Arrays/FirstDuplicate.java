package CodeFight.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstDuplicate {
    /* *
       int[] a = new int[]{2, 3, 3, 1, 5, 2};
        int[] b = new int[]{2, 4, 3, 5, 1};
        int[] c = new int[]{2 , 3, 3};
        int[] d = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        System.out.println(firstDuplicate(a));
        System.out.println(firstDuplicate(b));
        System.out.println(firstDuplicate(c));
        System.out.println(firstDuplicate(d));
    * */

    int firstDuplicatePractice(int[] a){
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Map.Entry<Integer, Integer> min = null;

        for (int i = 0; i < a.length; i++){
            if(set.add(a[i]) == false && !hm.containsKey(a[i])) {
                hm.put(a[i], i);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if (min == null || entry.getValue() < min.getValue()){
                min = entry;
            }
        }
        return min == null ? new Integer(-1) : min.getKey();
    }

    int firstDuplicate(int[] a) {
        int index = -1;
        int key = -1;
        int maxIndex = -1;
        for(int i = 0; i < a.length - 1; i++){
            key = a[i];
            int count = i;
            for(int j = i + 1; j < a.length; j++){
                if(key == a[j]){
                    if(index == -1 || j < index){
                        index = j;
                    }
                }else{
                    count++;
                }
            }
            if(i > index - (index*.5)){
                break;
            }
        }

        if(index == -1){
            return -1;
        }else{
            return a[index];
        }
    }
}
