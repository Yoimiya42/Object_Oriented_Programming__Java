import java.util.Scanner;

public class Example1 {
    public int sumOfDigits(int n) {
        int digitSum = 0;
        n = Math.abs(n);
        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }

        return digitSum;
    }

    public void inputAndProcess() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Please enter a integer: ");
            int org_num = scan.nextInt();
            int sum = sumOfDigits(org_num);
            System.out.printf("Number you typed: %d, Sum of Digits: %d", org_num, sum);
        }
    }

    public static void main(String[] args){
        Example1 ex1 = new Example1();
        ex1.inputAndProcess();
    }
}
