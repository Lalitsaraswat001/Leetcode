class Solution {
    public int calPoints(String[] operations) {
        int[] ans = new int[operations.length];
        int size = 0;
        int sum = 0;

        for(int i = 0; i<operations.length; i++){
            if(operations[i].equals("+")){
                ans[size] = ans[size-1]+ans[size-2];
                size++;
            }
            else if(operations[i].equals("D")){
                ans[size] = 2*ans[size-1];
                size++;
            }
            else if(operations[i].equals("C")){
                size--;
            }
            else{
                ans[size] = Integer.parseInt(operations[i]);
                size++;
            }
        }

        for(int i = 0; i < size; i++){
            sum += ans[i];
        }

        return sum;
    }
}