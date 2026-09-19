import java.util.*;

class Solution {

    void fun(int n, int open, int close,
             StringBuilder tmp, List<String> res) {

        if (open == n && close == n) {
            res.add(tmp.toString());
            return;
        }

        if (open < n) {
            tmp.append('(');

            fun(n, open + 1, close, tmp, res);

            tmp.deleteCharAt(tmp.length() - 1);
        }

        if (close < open) {
            tmp.append(')');

            fun(n, open, close + 1, tmp, res);

            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        fun(n, 0, 0, tmp, res);

        return res;
    }
}