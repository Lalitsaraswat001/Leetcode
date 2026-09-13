class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
/*
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '#'){
                if(!st1.isEmpty()){
                     st1.pop();
                } 
            }
            else{
                st1.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();

        while(!st1.isEmpty()){
            res.append(st1.pop());
        }
        String str1= res.reverse().toString();


        for(int i = 0; i<t.length(); i++){

            char ch = t.charAt(i);
            if(ch == '#'){
                if(!st2.isEmpty()){
                    st2.pop();
                }  
            }
            else{
                st2.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!st2.isEmpty()){
            result.append(st2.pop());
        }

        String str2 = result.reverse().toString();

        return str1.equals(str2);
*/

    for(char ch : s.toCharArray()){
        if(!st1.isEmpty() && ch == '#'){
            st1.pop();
        }
        else{
            if(ch != '#'){
                st1.push(ch);
            }
        }
    }

    for(char ch : t.toCharArray()){
        if(!st2.isEmpty() && ch == '#'){
            st2.pop();
        }
        else{
            if(ch != '#'){
                st2.push(ch);
            }
        }
    }
    return st1.equals(st2);
    }
}