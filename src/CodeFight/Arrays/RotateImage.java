package CodeFight.Arrays;

public class RotateImage {
    /*
    *   int[][] a2 = {{1, 2, 3},     {4, 5, 6},     {7, 8, 9}};
    *   System.out.print(rotateImage(a2));
    * */
    int[][] rotateImage(int[][] a) {
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

}
