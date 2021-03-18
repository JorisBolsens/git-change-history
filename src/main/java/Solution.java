import java.util.Arrays;

public class Solution {

    public boolean isBalanced(String substr) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        Arrays.fill(lower, false);
        Arrays.fill(upper, false);

        for (char c : substr.toCharArray()){
            if (c > 90) {
                lower[c - 97] = true;
            } else {
                upper[c-65] = true;
            }
        }

        return Arrays.equals(lower, upper);
    }
    public int solution(String s) {
        int len = s.length();
        int solution = len;

        for(int i = 0; i < len; i++){
            for(int j = i; j < len && (j-i+1 < solution); j++){
                if(isBalanced(s.substring(i,j+1))){
                    solution = j-i+1;
                }
            }
        }

        if(solution == len){
            solution = isBalanced(s) ? solution : -1;
        }
        return solution;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.solution("AcZCbaBz"));
    }
}
