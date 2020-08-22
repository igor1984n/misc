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
    }

    public static boolean isPallindrome(int num) {
        String num2string = String.valueOf(num);
        for (int i = 0; i < num2string.length() / 2; i++) {
            for (int j = num2string.length() - i - 1; j > num2string.length() / 2; j--) {
                System.out.println("i " + num2string.charAt(i) + "\nj " + num2string.charAt(j));
                if (num2string.charAt(i) != num2string.charAt(j)) return false;
                else i++;
            }
        }
        return true;
    }
}
