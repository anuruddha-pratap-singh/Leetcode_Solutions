class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        boolean check = true; // for -1 to 0 - 1; true means NEXT SHOULD BE A NUMBER
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
                continue;
            }
            // construct the number
            if(Character.isDigit(ch)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                check = false;
                continue;
            }
            if(ch == '('){
                ops.push(ch);
                check = true;
                i++;
            }else if(ch == ')'){
                while(ops.peek() != '('){
                    operations(nums , ops);
                }
                ops.pop();
                check = false;
                i++;
            }else{

                if(ch == '-' && check){
                    nums.push(0);
                }
                while(!ops.isEmpty() && ops.peek() != '(' && priority(ops.peek()) >= priority(ch)){
                    operations(nums , ops);
                }

                ops.push(ch);
                check = true;
                i++;
            }

        }

        while(!ops.isEmpty()){
            operations(nums , ops);
        }

        return nums.pop(); // ans
    }
     private int priority(char op){
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;

        return 0;
    }
    private void operations(Deque<Integer> nums , Deque<Character> ops){
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