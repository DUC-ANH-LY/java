/**
 * Created by Lyducanh
 * Date: 7/19/2025
 * Time: {11:15 AM}
 * Project Name: Interview
 */


public class Test {
    public void main(String[] args) {
//        ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
        ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("Compare address");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println("Compare value");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
