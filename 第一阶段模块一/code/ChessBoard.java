/*
    打印棋盘
 */
import java.util.Arrays;

public class ChessBoard {
    public static void main(String[] args){
        char[][] chessboard = new char[17][17];
        chessboard[0][0] = ' ';
        for(int i = 1; i < 17; i++){
            for(int j = 1; j < 17; j++){
                chessboard[i][j]='+';
            }
        }
        char val1 = 48;
        char val2 = 97;
        for(int i = 1; i < 17; i++){
            if(i < 11){
                chessboard[0][i] = val1;
                chessboard[i][0] = val1;
                val1++;
            }else{
                chessboard[0][i] = val2;
                chessboard[i][0] = val2;
                val2++;
            }
        }
        for(int i = 0; i < chessboard.length; i++){
            System.out.println(Arrays.toString(chessboard[i]));
        }
    }
}
