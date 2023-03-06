package 剑指offer;

public class Offer_05_替换空格 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(Offer_05_替换空格.replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
