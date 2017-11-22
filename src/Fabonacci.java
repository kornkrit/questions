class Fabonacci {

    public int calculate(int num){
        if(num == 0 ){
            return 0;
        }else if(num == 1){
            return 1;
        }
        return calculate(num - 1) + calculate(num - 2);
    }
}
