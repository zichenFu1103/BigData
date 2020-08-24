package com.zichenfu.homework1;

/**
 * 定义一个长度为16*16的整型二维数组并输入或指定所有位置的元素，
 * 分别实现二维数组中所有行和所有列中所有元素的累加并打印，
 * 再分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印
 *
 * 为了方便验证，二维数组的值都为1。
 * 所有元素之和为256；对角线之和为32
 */
public class SumOfTwoDimensionalArray {

    public static void main(String[] args){
        int[][] arr = new int[16][16];

        //给二维数组赋值，这里我们把所有元素赋值为1
        for(int r = 0;  r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                arr[r][c] = 1;
            }
        }

        //计算所有元素之和
        int totalSum = 0;
        for(int r = 0;  r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                totalSum += arr[c][r];
            }
        }
        System.out.println("所有元素之和：" + totalSum);

        //计算对角线之和
        int diagonalSum = 0;
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                if(r == c){
                    diagonalSum += arr[r][c];
                }
                if(r + c == arr.length - 1){
                    diagonalSum += arr[r][c];
                }
            }
        }

        System.out.println("对角线所有元素之和：" + diagonalSum);
    }
}

