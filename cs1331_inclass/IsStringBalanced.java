public class isStringBalanced {
    public static boolean isStringBalanced(String s) {
        int  balance = 0;
        boolean first = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
        }
        return balance == 0;
    }
}