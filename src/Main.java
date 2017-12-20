import java.io.CharConversionException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args){


       Recursive recursive = new Recursive();
//       System.out.println("Factorial : " + recursive.factorial(5));
//       System.out.println("Fibonacci : " + recursive.fibonacci(6));
//       System.out.println("Sum natural : " + recursive.sumNutural(5));
//       System.out.println("Multiply : " + recursive.multiply(2,3));
       //System.out.println("Power : " + recursive.power(2,3));
//       System.out.println("String : " + recursive.reverse("Hello"));
//       System.out.println("String : " + recursive.reverseWord("My name is Kornkrit"));
//       System.out.println("String : " + recursive.contains("gear", "My name is kornkrit"));

         //System.out.print(transactionsStability(new int[]{1,4,1}));
        int[] a = new int[]{2, 3, 3, 1, 5, 2};
        int[] b = new int[]{2, 4, 3, 5, 1};
        int[] c = new int[]{2 , 3, 3};
        int[] d = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
//        System.out.println(firstDuplicate(a));
//        System.out.println(firstDuplicate(b));
//        System.out.println(firstDuplicate(c));
//        System.out.println(firstDuplicate(d));
        String x = "aabcc";
        System.out.println(firstNotRepeatingCharacter(x));
    }

    char firstNotRepeatingCharacter(String s){
        for(int i = 0; i < s.length(); i++){
          if(getUnique(s.charAt(i),s, i)){
              return s.charAt(i);
          }
        }
        return '_';
    }

    boolean getUnique(char c, String s, int current){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
           if(current == i){
               count++;
           }
           else if(c == s.charAt(i)){
               return false;
           }else{
               count++;
           }
        }
        if(count == s.length()){
            return true;
        }
        return false;
    }

    static int firstDuplicatePractice(int[] a){
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

    static int firstDuplicate(int[] a) {
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


    static double transactionsStability(int[] t) {
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
