import java.io.CharConversionException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args){


       Recursive recursive = new Recursive();
//       System.out.println('Factorial : ' + recursive.factorial(5));
//       System.out.println('Fibonacci : ' + recursive.fibonacci(6));
//       System.out.println('Sum natural : ' + recursive.sumNutural(5));
//       System.out.println('Multiply : ' + recursive.multiply(2,3));
       //System.out.println('Power : ' + recursive.power(2,3));
//       System.out.println('String : ' + recursive.reverse('Hello'));
//       System.out.println('String : ' + recursive.reverseWord('My name is Kornkrit'));
//       System.out.println('String : ' + recursive.contains('gear', 'My name is kornkrit'));

         //System.out.print(transactionsStability(new int[]{1,4,1}));
        int[] a = new int[]{2, 3, 3, 1, 5, 2};
        int[] b = new int[]{2, 4, 3, 5, 1};
        int[] c = new int[]{2 , 3, 3};
        int[] d = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
//        System.out.println(firstDuplicate(a));
//        System.out.println(firstDuplicate(b));
//        System.out.println(firstDuplicate(c));
//        System.out.println(firstDuplicate(d));
        //String x = 'aabcc';
        //System.out.println(firstNotRepeatingCharacter(x));

        int[][] a2 = {{1, 2, 3},     {4, 5, 6},     {7, 8, 9}};
//        System.out.print(rotateImage(a2));
        
        char[][] sudoku = {{'.','.','4','.','.','.','6','3','.'},  {'.','.','.','.','.','.','.','.','.'},  {'5','.','.','.','.','.','.','9','.'},  {'.','.','.','5','6','.','.','.','.'},  {'4','.','3','.','.','.','.','.','1'},  {'.','.','.','7','.','.','.','.','.'},  {'.','.','.','5','.','.','.','.','.'},  {'.','.','.','.','.','.','.','.','.'},  {'.','.','.','.','.','.','.','.','.'}};
        char[][] sudoku5 =  {{'.','4','.','.','.','.','.','.','.'},  {'.','.','4','.','.','.','.','.','.'},  {'.','.','.','1','.','.','7','.','.'},  {'.','.','.','.','.','.','.','.','.'},  {'.','.','.','3','.','.','.','6','.'},  {'.','.','.','.','.','6','.','9','.'},  {'.','.','.','.','1','.','.','.','.'},  {'.','.','.','.','.','.','2','.','.'}, {'.','.','.','8','.','.','.','.','.'}};
//        System.out.println(sudoku2(sudoku5));

        String[] crypt = {"AB","AB","CD"};
        char[][] solution = {{'A','1'},{'B','0'},{'C','2'},{'D','0'}};
        System.out.println(isCryptSolution(crypt, solution));
    }



    static boolean isCryptSolution(String[] crypt, char[][] solution) {
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
                if (w[0].charAt(0) == '0' || w[1].charAt(0) == '0') {
                    return false;
                } else {
                    if (Integer.parseInt(w[0]) + Integer.parseInt(w[1]) == Integer.parseInt(w[2])) {
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



    static boolean sudoku2(char[][] grid) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] !=  '.'){
                    for(int x = 0; x < 9; x++){
                        if(grid[i][j] == grid[i][x] && x != j){
                            return false;
                        }
                    }
                    for(int x = 0; x < 9; x++){
                        if(grid[i][j] == grid[x][j] && x != i){
                            return false;
                        }
                    }

                    if(i < 3){
                        int section;
                        if(j < 3){
                            section = 0;
                        }else if(j > 5){
                            section = 6;
                        }else{
                            section = 3;
                        }

                        for(int x = 0; x < 3; x++){
                            for(int y = section; y < section + 3 ; y++){
                                if(grid[i][j] == grid[x][y] && x != i && y != j){
                                    return false;
                                }
                            }
                        }
                    }else if(i > 5){
                        int section;
                        if(j < 3){
                            section = 0;
                        }else if(j > 5){
                            section = 6;
                        }else{
                            section = 3;
                        }

                        for(int x = 6; x < 9; x++){
                            for(int y = section; y < section + 3 ; y++){
                                if(grid[i][j] == grid[x][y] && x != i && y != j){
                                    return false;
                                }
                            }
                        }
                    }else{
                        int section;
                        if(j < 3){
                            section = 0;
                        }else if(j > 5){
                            section = 6;
                        }else{
                            section = 3;
                        }

                        for(int x = 3; x < 6; x++){
                            for(int y = section; y < section + 3 ; y++){
                                if(grid[i][j] == grid[x][y] && x != i && y != j){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }


        return true;
    }

    static boolean sudoku3(char[][] grid) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] !=  '.'){
                    int h = 0;
                    int v = 0;
                    for(int x = 0; x < 9; x++){
                        if(grid[i][j] == grid[i][x] && x != j){
                            return false;
                        }
                        if(grid[i][x] == '.')
                            v++;
                    }
                    for(int x = 0; x < 9; x++){
                        if(grid[i][j] == grid[x][j] && x != i){
                            return false;
                        }
                        if(grid[x][j] == '.')
                            h++;
                    }

                    if(v == 8 || h == 8)
                        return false;
                }
            }
        }
        return true;
    }


    static int[][] rotateImage(int[][] a) {
        if(a[0].length == 1){
            return a;
        }
        int dimension = a[0].length;
        int[][] b = new int[dimension][dimension];
        for(int i = 0; i < dimension;i++){
            for(int j = 0; j < dimension; j++){
                b[j][dimension - i - 1] = a[i][j];
            }
        }
        return b;
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
