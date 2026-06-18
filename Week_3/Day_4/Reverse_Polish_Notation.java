class Solution {
    int a;

    public int evalRPN(String[] tokens) {
        a = tokens.length - 1;
        return solve(tokens);
    }

    private int solve(String[] tokens) {
        String token = tokens[a--];

        if (!token.equals("+") &&
            !token.equals("-") &&
            !token.equals("*") &&
            !token.equals("/")) {
            return Integer.parseInt(token);
        }

        int right = solve(tokens);
        int left = solve(tokens);

        switch (token) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            default:  return left / right;
        }
    }
}