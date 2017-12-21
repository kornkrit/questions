package CodeFight.Arrays;

public class FirstNotRepeatingCharacter {
    /* *
        String x = 'aabcc';
        System.out.println(firstNotRepeatingCharacter(x));
    * */
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



}
