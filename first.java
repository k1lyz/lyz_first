package first_homework;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
//打印选择题答案
        System.out.print("第一答案: B. .class  第二答案: B. javac.exe  第三答案: D. int→char  第四答案: B. a和b指向同一个实例对象，a和c不指向同一个实例对象  第五答案: D. public class Car { … }");
        System.out.println(); // 换行
//每个编程题都要调用
        Triangle();
        System.out.println();
        reverseSUM();
        System.out.println();
        Palindrome();
        System.out.println();
        ShuiXianHua();
        System.out.println();
        arraysDemo();
        System.out.println();


//思考如果函数是有返回值呢， 以及如果函数定义中没有加static还可以直接调用吗？
    }
    public static void ShuiXianHua() {
        findNarcissisticNumbers();
    }

    // 寻找所有水仙花数
    private static void findNarcissisticNumbers() {
        for (int num = 100; num <= 999; num++) {
            if (isNarcissisticNumber(num)) {
                System.out.print(num);
                System.out.print(' ');
            }
        }
    }

    // 判断一个数是否为水仙花数
    private static boolean isNarcissisticNumber(int number) {
        int original = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3);
            number /= 10;
        }

        return original == sum;
    }
    public static void Palindrome() {
        Scanner scanner = new Scanner(System.in);

        // 输入整数
        System.out.print("请输入一个正整数：");
        int num_1 = scanner.nextInt();

        // 判断是否为回文数
        boolean isPalindrome = isPalindrome(num_1);

        // 输出判断结果
        if (isPalindrome) {
            System.out.println("是的");
        } else {
            System.out.println("不是");
        }

        scanner.close();
    }

    // 判断是否为回文数
    private static boolean isPalindrome(int number) {
        if (number < 0) {
            return false; // 负数不是回文数
        }

        int original = number;
        int reversed = 0;

        // 反转数字
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        // 判断是否相等
        return original == reversed;
    }
    public static void reverseSUM() {
        Scanner scanner = new Scanner(System.in);

        // 输入正整数
        System.out.print("请输入一个正整数：");
        int num = scanner.nextInt();

        // 计算位数
        int digitCount = countDigits(num);
        System.out.println("您输入的正整数位数是"+digitCount);

        // 逆序打印各位数字
        System.out.print("您输入的正整数逆序是：");
        reverseAndPrintDigits(num);

        scanner.close();
    }

    // 计算位数
    private static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    // 逆序打印各位数字
    private static void reverseAndPrintDigits(int number) {
        while (number != 0) {
            int digit = number % 10;
            System.out.print(digit);
            number /= 10;
        }
        System.out.println();
    }
    public static void Triangle() {
        System.out.println("输入我想要打印的等腰三角形行数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][];

        // 初始化二维数组
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        // 计算杨辉三角的值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        // 打印杨辉三角
        for (int i = 0; i < n; i++) {
            // 打印空格对齐
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 打印数字
            for (int j = 0; j <= i; j++) {
                //System.out.print(triangle[i][j] + " ");
                System.out.print('*' + " ");
            }

            System.out.println();
        }
    }
    public static void arraysDemo() {
        int[] array = {5, 2, 8, 1, 6, 9, 3, 7, 4, 10};

        // 计算最小值和最大值之和
        int sum = calculateMinMaxSum(array);

        System.out.println("最小值和最大值之和为：" + sum);
    }

    // 计算最小值和最大值之和
    private static int calculateMinMaxSum(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("数组长度必须至少为2");
        }

        int min = array[0];
        int max = array[0];

        // 寻找最小值和最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // 计算最小值和最大值之和
        return min + max;
    }
}
