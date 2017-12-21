package CodeFight.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CryptSolution {
    /* *
        String[] crypt = {"AAAAAAAAAAAAAA",                "BBBBBBBBBBBBBB",                "CCCCCCCCCCCCCC"};
        char[][] solution = {{'A','1'}, {'B','2'}, {'C','3'}};
        System.out.println(isCryptSolution(crypt, solution));
    * */
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        try {
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();

            for(int i = 0; i < solution.length; i ++){
                if(set1.add(solution[i][0]) == false || set2.add(solution[i][1]) == false){
                    return false;
                }
            }

            HashMap<Character, Character> hm = new HashMap<Character, Character>();
            for (int i = 0; i < solution.length; i++) {
                hm.put(solution[i][0], solution[i][1]);
            }
            String[] w = new String[3];

            for (int i = 0; i < crypt.length; i++) {
                String num = "";
                for (int j = 0; j < crypt[i].length(); j++) {
                    num += hm.get(crypt[i].charAt(j));
                }
                w[i] = num;
            }

            if (w[0].length() == 1 || w[1].length() == 1) {
                if (Integer.parseInt(w[0]) + Integer.parseInt(w[1]) == Integer.parseInt(w[2])) {
                    return true;
                }
            } else {
                if (w[0].charAt(0) == '0' || w[1].charAt(0) == '0' || w[2].charAt(0) == '0') {
                    return false;
                } else {
                    if (Long.parseLong(w[0]) + Long.parseLong(w[1]) == Long.parseLong(w[2])) {
                        return true;
                    }
                }
            }
            return false;
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            return false;
        }
    }
}
