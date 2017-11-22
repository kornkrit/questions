class Factorial {

    public int calculate(int num){
        if(num <= 1){
            return 1;
        }else{
            return num * calculate(num-1);
        }


    }
}
