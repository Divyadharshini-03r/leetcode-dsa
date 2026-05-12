public class validPalindrome {

    public boolean isPalindrome(String str) {

        boolean isPal =
                str.equals(new StringBuilder(str)
                .reverse()
                .toString());

        return isPal;
    }

    public static void main(String[] args) {

        validPalindrome obj = new validPalindrome();

        String str = "madam";

        boolean result = obj.isPalindrome(str);

        System.out.println(result);
    }
}