package dsa.two_pointer;

public class CheckPalindrome {

    public static void main(String[] args) {
        String palindromeStr = "madam";
        System.out.println(isPalindrome(palindromeStr));
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
