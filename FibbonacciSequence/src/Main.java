import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 1 && n <= 500) {
            long[] nums = new long[n + 1];
            nums[1] = 1;
            if (n == 1) {
                System.out.println(1);
            } else {
                for (int i = 2; i < n; i++) {
                    nums[i] = nums[i - 1] + nums[i - 2];
                }
                System.out.println(nums[n - 1] + nums[n - 2]);
            }
        }
    }
}

