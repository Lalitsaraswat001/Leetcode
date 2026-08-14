class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        /// its diff from |

        int low = 0;
        int high = m-1;

        while(low < n && high >= 0){

            if(matrix[low][high]==target){
                return true;
            }
            else if(matrix[low][high]<target){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}