package com.zichenfu.homework2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 模拟双人对战的五子棋游戏
 * 游戏分为黑白双方。游戏规定棋盘大小为16*16，黑方显示X，白方显示O，并且黑方先下。一方获胜，则游戏结束。
 * 用户通过棋盘上的坐标来确定想要下的位置。横纵坐标的合理输入范围1～16。
 * 注：游戏规定二维数组的行为横坐标，列为纵坐标。
 */
public class ChessGame {
    public static void main(String[] args) {
        landingGame();
    }

    /*
        创建一个方法用来加载游戏。
        提示用户输入Y/y来开始游戏；若用户输入其他信息，则说明用户还在准备阶段。
     */
    private static void landingGame(){
        System.out.println("--------------------------");
        System.out.println("欢迎来到五子棋大战！");
        System.out.println("黑方为先手方，显示X；白方为后手方，显示O！");
        //表示是否准备开始游戏，false代表准备中，true代表开始游戏。
        boolean startFlag = false;
        while (!startFlag){
            System.out.println("--------------------------");
            System.out.println("开始游戏请按Y确认：");
            Scanner scanner = new Scanner(System.in);
            String confirmInfo = scanner.next();
            if(confirmInfo.equals("Y") || confirmInfo.equals("y")){
                startFlag = true;
                char[][] chessBoard = createChessBoard( 16);
                playGame(chessBoard);
            }else{
                System.out.println("准备中......");
            }
        }
    }

    /*
        创建一个方法开始游戏。
     */
    private static void playGame(char[][] chessBoard){
        System.out.println("--------------------------");
        System.out.println("游戏开始！黑方先下!");
        printChessBoard(chessBoard);
        //表示用户下的棋的横纵坐标。
        int x = 0;
        int y = 0;
        //表示用户下的棋是否有效。
        boolean isValidFlag;
        //表示黑白双方，false代表黑方，true代表白方。
        boolean playerFlag = false;
        //表示比赛输赢结果，false代表输，true代表赢。
        boolean winFlag = false;
        while(!winFlag){
            System.out.println("--------------------------");
            isValidFlag = false;
            if(!playerFlag){
                while(!isValidFlag){
                    System.out.println("请黑方输入横纵坐标：");
                    Scanner scanner = new Scanner(System.in);
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    if(isValidAndAssign(x, y, chessBoard, false)){
                        isValidFlag = true;
                    }
                }
            }else{
                while (!isValidFlag){
                    System.out.println("请白方输入横纵坐标：");
                    Scanner scanner = new Scanner(System.in);
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    if(isValidAndAssign(x, y, chessBoard, true)){
                        isValidFlag = true;
                    }
                }
            }
            printChessBoard(chessBoard);
            if(isWin(x, y, chessBoard, playerFlag)){
                winFlag = true;
            }
            playerFlag = !playerFlag;
        }
    }

    /*
        创建一个方法判断输赢。
        形参是横纵坐标，二维数组和角色信息，返回值是boolean类型。
        若有一方获胜，则退出游戏。
     */
    private static boolean isWin(int x, int y, char[][] chessboard, boolean playerFlag){
        if(!playerFlag){
            for(int i = 1; i <= 8; i++){
                if(sum(x, y, chessboard, i) == 440){
                    System.out.println("恭喜黑方获胜！");
                    return true;
                }
            }
        }else{
            for(int i = 1; i <= 8; i++){
                if(sum(x, y, chessboard, i) == 395){
                    System.out.println("恭喜白方获胜！");
                    return true;
                }
            }
        }
        return false;
    }

    /*
        创建一个方法计算以一个坐标为中心，一个方向的元素之和。
        形参是横纵坐标，二维数组，方向，返回类型是int类型。
        上下方向：横坐标加/减一，纵坐标不变；
        左右方向：横坐标不变，纵坐标加/减一；
        左上右下方向：横纵坐标加/减一；
        右上方向：横坐标减一，纵坐标加一；
        左下方向：横坐标加一，纵坐标减一；
     */
    private static int sum(int x, int y,  char[][] chessboard, int direction){
        int sum = 0;
        int updatedX = x;
        int updatedY = y;
        for(int i = 0; i < 5; i++){
            switch (direction){
                //上
                case 1:
                    updatedX = x - i;
                    break;
                //下
                case 2:
                    updatedX = x + i;
                    break;
                //左
                case 3:
                    updatedY = y - i;
                    break;
                //右
                case 4:
                    updatedY = y + i;
                    break;
                //左上
                case 5:
                    updatedX = x - i;
                    updatedY = y - i;
                    break;
                //右下
                case 6:
                    updatedX = x + i;
                    updatedY = y + i;
                    break;
                //左下
                case 7:
                    updatedX = x + i;
                    updatedY = y - i;
                    break;
                //右上
                case 8:
                    updatedX = x - i;
                    updatedY = y + i;
                    break;
            }
            if(updatedX < 1 || updatedX > 16 || updatedY < 1 || updatedY > 16){
                break;
            }else{
                sum += chessboard[updatedX][updatedY];
            }
        }

        if(sum == 440 || sum == 395){
            return sum;
        }else {
            sum = 0;
        }

        return sum;
    }

    /*
        创建一个方法用来判断用户输入的值是否有效并赋值。
        形参是横纵坐标，表示棋盘的二维数组和表示黑白双方的boolean值，返回类型是boolean。
        横纵坐标应在1～16之间，以被占用的坐标不能重复利用。
     */
    private static boolean isValidAndAssign(int x, int y, char[][] chessBoard, boolean playerFlag){
        boolean isValidAndAssign = true;
        if(x <= 0 || x > 16 || y <= 0 || y > 16){
            System.out.println("--------------------------");
            System.out.println("横纵坐标应在1～16之间，请输入有效坐标！");
            isValidAndAssign = false;
        }else if(chessBoard[x][y] == 79 || chessBoard[x][y] == 88){
            System.out.println("--------------------------");
            System.out.println("该坐标已被占用，请输入有效坐标！");
            isValidAndAssign = false;
        }else{
            if(!playerFlag){
                chessBoard[x][y] = 88;
            }else{
                chessBoard[x][y] = 79;
            }
        }
        return isValidAndAssign;
    }

    /*
        创建一个方法用来绘制棋盘。
        形参是棋盘的大小，返回类型是char类型的二维数组。
        这里棋盘的大小是包括横纵坐标的，我们规定横纵坐标的取值范围是1～9，a～z,
        所以我们可以最大绘制出一个35*35的棋盘。
        这里我们会对用户输入的棋盘大小做一个预先判断，棋盘的大小必须在5*5到35*35之间，
        如果不在这个范围，就会提示用户重新输入。
     */
    private static char[][] createChessBoard(int size) {
        char[][] chessBoard = null;
        if(size >= 5 && size <= 35){
            int ActualSize = size + 1;
            chessBoard = new char[ActualSize][ActualSize];
            chessBoard[0][0] = ' ';

            for (int r = 1; r < ActualSize; r++) {
                for (int c = 1; c < ActualSize; c++) {
                    chessBoard[r][c] = '+';
                }
            }
            char val1 = 49;
            char val2 = 97;

            for(int i = 1; i < ActualSize; i++) {
                if (i < 10) {
                    chessBoard[0][i] = val1;
                    chessBoard[i][0] = val1;
                    val1++;
                } else {
                    chessBoard[0][i] = val2;
                    chessBoard[i][0] = val2;
                    val2++;
                }
            }
        }else{
            System.out.println("--------------------------");
            System.out.println("棋盘大小不合理，请重新输入！");
            System.out.println("棋盘大小应在5*5到35*35之间！");
        }
        return chessBoard;
    }

    /*
        创建一个方法打印棋盘。
        形参是一个二维数组用来表示棋盘，返回类型是void。
        如果棋盘是一个有效值，打印棋盘；否则提示用户错误信息。
     */
    private static void printChessBoard(char[][] chessBoard) {
        if(chessBoard != null){
            for (char[] chars : chessBoard) {
                System.out.println(Arrays.toString(chars));
            }
        }else{
            System.out.println("--------------------------");
            System.out.println("棋盘大小不合理，无法正常打印！");
        }
    }
}
