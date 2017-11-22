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
    }

