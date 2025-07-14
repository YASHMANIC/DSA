public class sort {
    public static void main(String[] args) {
        System.out.println(check("abcdefghijklmnopqrstuvwxzy"));
    }
    public static int check(String s) {
        int c = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) < s.charAt(i-1)) {
                c++;
            }
        }
        return c;
    }
}
