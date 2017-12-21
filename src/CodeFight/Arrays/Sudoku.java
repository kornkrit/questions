package CodeFight.Arrays;

public class Sudoku {
    /*
    *  char[][] sudoku = {{'.','.','4','.','.','.','6','3','.'},  {'.','.','.','.','.','.','.','.','.'},  {'5','.','.','.','.','.','.','9','.'},  {'.','.','.','5','6','.','.','.','.'},  {'4','.','3','.','.','.','.','.','1'},  {'.','.','.','7','.','.','.','.','.'},  {'.','.','.','5','.','.','.','.','.'},  {'.','.','.','.','.','.','.','.','.'},  {'.','.','.','.','.','.','.','.','.'}};
    *  char[][] sudoku5 =  {{'.','4','.','.','.','.','.','.','.'},  {'.','.','4','.','.','.','.','.','.'},  {'.','.','.','1','.','.','7','.','.'},  {'.','.','.','.','.','.','.','.','.'},  {'.','.','.','3','.','.','.','6','.'},  {'.','.','.','.','.','6','.','9','.'},  {'.','.','.','.','1','.','.','.','.'},  {'.','.','.','.','.','.','2','.','.'}, {'.','.','.','8','.','.','.','.','.'}};
    *  System.out.println(sudoku2(sudoku5));
    * */
    boolean sudoku2(char[][] grid) {
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

    boolean sudoku3(char[][] grid) {
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



}
