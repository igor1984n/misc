public class Main {
    public static void main(String[] args) {
        int num = 10001;
        int a = 12345;
        int b = 123454321;
        int c = 123453421;
        System.out.println(isPallindrome(num));
        System.out.println(isPallindrome(a));
        System.out.println(isPallindrome(b));
        System.out.println(isPallindrome(c));
        System.out.println(isSumEven(num));
    }

    public static boolean isPallindrome(int num) {
        String num2string = String.valueOf(num);
        int length = num2string.length();
        if (length == 1) return false;
        else {
            for (int i = 0; i < length / 2; i++) {
//                System.out.println("i " + num2string.charAt(i) + " <=> j " + num2string.charAt(length - 1 - i));
                if (num2string.charAt(i) != num2string.charAt(length - 1 - i)) return false;
            }
            return true;
        }
    }

    public static boolean isSumEven(int num) {
        String num2string = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < num2string.length(); i++) {
            sum += Integer.parseInt(String.valueOf(num2string.charAt(i)));
        }
        return sum % 2 == 0;
    }
}
