import java.util.Arrays;
import java.util.Scanner;

/*
    自定义数组扩容规则，当已存储元素数量达到 总容量的 80% 时，扩容 1.5 倍。
    例如，总容量是10 ，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15
 */
public class EnhanceCapacity {
    public static void main(String[] args){
        System.out.println("请输入数组的容量（正整数）：");
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int[] arr = new int[capacity];
        int index = 0;
        boolean flag = true;
        while(flag){
            System.out.println("请在数组中输入数值:");
            int length = arr.length;
            int val = sc.nextInt();
            arr[index] = val;
            if(index+1 > (int)(0.8*length)){
                System.out.println("------------------------------");
                System.out.println("已经超出总容量的80%，系统会自动扩容");
                System.out.println("------------------------------");
                arr = enhanceCapacity(arr);
            }
            index++;
        }
    }

    public static int[] enhanceCapacity(int[] oldArr){
        int oldLength = oldArr.length;
        int newLength = (int)(Math.ceil(oldLength*1.5));
        int[] newArr = Arrays.copyOf(oldArr, newLength);
        return newArr;
    }
}
