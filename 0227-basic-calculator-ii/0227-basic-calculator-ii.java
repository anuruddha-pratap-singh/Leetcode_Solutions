class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
                continue;
            }
            if(Character.isDigit(ch)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                continue;
            }
            if(ch == '('){
                ops.push(ch);
                i++;
            }else if(ch == ')'){
                while(ops.peek() != '('){
                    operations(nums , ops);
                }
                ops.pop();
                i++;
            }else{
                while(!ops.isEmpty() && ops.peek() != '(' && priority(ops.peek()) >= priority(ch)){
                    operations(nums , ops);
                }

                ops.push(ch);
                i++;
            }

        }

        while(!ops.isEmpty()){
            operations(nums , ops);
        }

        return nums.pop();
    }
    private int priority(char op){
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;

        return 0;
    }
    private void operations(Stack<Integer> nums , Stack<Character> ops){
        int b = nums.pop();
        int a = nums.pop();

        char op = ops.pop();
        int result = 0;

        if(op == '+'){
            result = a+b;
        }else if(op == '-'){
            result = a-b;
        }else if(op == '*'){
            result = a*b;
        }else{
            result = a/b;
        }

        nums.push(result);
    }
}