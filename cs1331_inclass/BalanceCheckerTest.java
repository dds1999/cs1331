public class BalanceCheckerTest {
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
    public static void main(String[] args) {
        String balanced = "()()()";
        String balanced2 = "()(()())";
        String balancedWithContent = "(((123321)))";
        String empty = "";
        String unbalanced = "(()";
        String unbalancedWithContent = "()33(";
        /* String balancedButInvalid = ")(";
        should we be testing for invlaid math syntax? you can't start with
        an ending parenthsis */
        assert isStringBalanced(balanced);
        assert isStringBalanced(balanced2);
        assert isStringBalanced(balancedWithContent);
        assert isStringBalanced(empty);
        assert !isStringBalanced(unbalanced);
        assert !isStringBalanced(unbalancedWithContent);

        assert ("N").equals("n");
    }
}