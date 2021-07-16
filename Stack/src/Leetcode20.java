public class Leetcode20 {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack =new java.util.Stack<> ();

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char topChar=stack.pop();
                if (c==')' && topChar!='(') {
                    return false;
                }
                if (c==']' && topChar!='['){
                    return  false;
                }
                if (c=='}' && topChar!='{'){
                    return  false;
                }

            }
        }
        return stack.isEmpty();
    }

}
