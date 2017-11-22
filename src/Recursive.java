import com.sun.org.apache.xpath.internal.operations.Bool;

class Recursive {

    public int factorial(int num){
        if(num <= 1){
            return 1;
        }else{
            return num * factorial(num-1);
        }
    }

    public int fibonacci(int num){
        System.out.print(num + " ");
        if(num == 0 ){
            return 0;
        }else if(num == 1){
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public int sumNutural(int num){
        if(num == 1){
            return 1;
        }else{
            return num + sumNutural(num-1);
        }
    }

    public int multiply(int a, int b){
        if(b <= 1){
            return a;
        }else{
            return a + multiply(a,b-1);
        }
    }

    public double callPower(double a, int b) {
        int c = Math.abs(b);
        if( c == 0){
            return 1;
        }
        if (c == 1) {
            return a;
        } else {
            return a * callPower(a, c - 1);
        }
    }
        public double power(double a , int b){
            if(b > 0){
                return callPower(a,b);
            }else{
                return 1/callPower(a,b);
            }
        }

        public String reverse(String a){
            if(a.length() == 1){
                return a;
            }else{
                return a.charAt(a.length()-1) + reverse(a.substring(0,a.length()-1));
            }
        }

    public String reverseWord(String a){
        String[] tmp = a.split(" ");
        if(tmp.length == 1){
            return tmp[0];
        }else{
            String x = String.join(" ", tmp);
            return tmp[tmp.length - 1] + " " + reverseWord(x.substring(0, x.lastIndexOf(" ")));
        }
    }

    public Boolean contains(String a, String b){
        if(a.equals("") && b.equals("")){
            return true;
        }else if(a.equals("") || b.equals("")){
            return false;
        }else {
            int count = 0;
            for(int i = 0; i < b.length(); i++) {
               if(a.charAt(0) == b.charAt(i)){
                   return checkContain(a.substring(1,a.length()), b.substring(i+1,b.length()));
               }else{
                   count ++;
               }
            }
            if(count == b.length() - 1){
                return false;
            }
        }
        return false;
    }

    public Boolean checkContain(String a, String b){
        if(a.length() == 1){
            if(a.charAt(0) == b.charAt(0)){
                return true;
            }else{
                return false;
            }
        }else{
            return  checkContain(a.substring(1,a.length()), b.substring(1,b.length()));
        }
    }

//        public double GSD(double a, double b){
//            if(a == 0){
//                return a;
//            }else if(b == 0){
//                return
//            }
//        }


    }

