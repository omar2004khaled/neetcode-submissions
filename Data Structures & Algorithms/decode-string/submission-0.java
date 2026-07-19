class Solution {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c != ']') {
                stack.push(c + "");
            } else {

                String str = "";

                while (!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }

                stack.pop(); // remove [

                String num = "";

                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num = stack.pop() + num;
                }

                int repeat = Integer.parseInt(num);

                String temp = "";

                for (int i = 0; i < repeat; i++) {
                    temp += str;
                }

                stack.push(temp);
            }
        }

        String ans = "";

        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}