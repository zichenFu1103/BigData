/*
    找出1000以内所有的完数
 */
public class FindAllPerfectNumbers {
    public static void main (String[] args){
        System.out.print("1000以内的完数有：");
        for(int i = 1; i <= 1000; i++){
            if(isPerfectNumber(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean isPerfectNumber(int number){
        int sum = 0;
        for(int i = 1; i < number; i++){
            if(number % i == 0){
                sum += i;
            }
        }
        if(sum == number){
            return true;
        }else{
            return false;
        }
    }
}
