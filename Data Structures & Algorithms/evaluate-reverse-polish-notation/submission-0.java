class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNum(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean isOperator (String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
