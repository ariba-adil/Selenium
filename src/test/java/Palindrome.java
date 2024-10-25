import java.util.Scanner;

public class Palindrome {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        String s = sc.nextLine();

        boolean palindrome = true;

        for(int i =0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                palindrome = false;
            }
        }

        if(palindrome) {
            System.out.println("palindrome");
        }
        else {
            System.out.println("not palindrome");
        }
    }
}
