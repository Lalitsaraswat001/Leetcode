class Solution {
    void fun(String digits, int n, int idx, StringBuilder dairy, List<String> res, HashMap<Character, String> f) {
        if (idx == n) {
            res.add(dairy.toString());
            return;
        }

        String choice = f.get(digits.charAt(idx));

        for (int i = 0; i < choice.length(); i++) {
            dairy.append(choice.charAt(i));
            fun(digits, n, idx + 1, dairy, res, f);
            dairy.deleteCharAt(dairy.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits.length() == 0) {
            return res;
        }

        HashMap<Character, String> f = new HashMap<>();

        f.put('2', "abc");
        f.put('3', "def");
        f.put('4', "ghi");
        f.put('5', "jkl");
        f.put('6', "mno");
        f.put('7', "pqrs");
        f.put('8', "tuv");
        f.put('9', "wxyz");

        StringBuilder dairy = new StringBuilder();

        fun(digits, digits.length(), 0, dairy, res, f);

        return res;
    }
}