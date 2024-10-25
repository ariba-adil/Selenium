package Interview;

import java.util.Arrays;
import java.util.Scanner;


public class Anagram {

    public static boolean isAnagram(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        boolean anagram = true;

        if(a.length()!=b.length()) {
            anagram = false;
        }


        char [] c = a.toCharArray();
        char [] d = b.toCharArray();
        System.out.println(c);

        Arrays.sort(c);
        Arrays.sort(d);

        String x = new String(c);
        String y = new String(d);
        System.out.println(x);

        if(x.equals(y)) {
            anagram = true;
        }

        return anagram;

    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter first string");
        String a=sc.next();
        System.out.println("enter second string");
        String b=sc.next();
        boolean res = isAnagram(a,b);
        if(res) {
            System.out.println("strings are anagram");
        }
        else {
            System.out.println("strings are not anagram");
        }

    }
}