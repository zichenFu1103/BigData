import java.util.Scanner;

/*
    提示用户输入年月日信息，判断这一天是这一年的第几天并打印
 */
public class DayInTheYear {
    public static void main(String[] args){
        System.out.println("请输入年月日信息");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int dayInTheYear = 0;
        if(isValid(year,month,day)){
            boolean flag = isLeapYear(year);
            for(int i = 1; i <= month - 1; i++){
                if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    dayInTheYear += 31;
                }else if(i == 2){
                    if(flag){
                        dayInTheYear += 29;
                    }else{
                        dayInTheYear += 28;
                    }
                }else{
                    dayInTheYear += 30;
                }
            }
            dayInTheYear += day;
            System.out.println("这一天是这一年中的第"+dayInTheYear+"天");
        };
    }

    //判断是不是有效输入信息
    public static boolean isValid(int year, int month, int day){
        if(year <= 0){
            System.out.println("年份应大于0，请重新输入");
            return false;
        }else if(month > 12 || month <= 0){
            System.out.println("月份应在1到12之间，请重新输入");
            return false;
        }else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31 || day <= 0) {
                    System.out.println("日期应在1到31之间，请重新输入");
                    return false;
                }
            }else if(month == 2){
                if(isLeapYear(year)){
                    if(day > 29 || day <= 0){
                        System.out.println("日期应在1到29之间，请重新输入");
                        return false;
                    }
                }else{
                    if(day > 28 || day <= 0){
                        System.out.println("日期应在1到28之间，请重新输入");
                        return false;
                    }
                }
            }else{
                if(day > 30 || day <= 0){
                    System.out.println("日期应在1到30之间，请重新输入");
                    return false;
                }
            }
        }
        return true;
    }

    //判断是不是润年
    public static  boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }
}
