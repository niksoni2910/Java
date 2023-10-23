import java.util.Arrays;

public class BooleanParenthization {
    static int m=1003;
    static int f(int i,int j,String s,int istrue,int[][][] dp){
        if(i>j) return 0;
        if(i==j){
            if(istrue == 1 && s.charAt(i) == 'T')
                return 1;
            if(istrue == 0 && s.charAt(i) == 'F')
                return 1;
            else
                return 0;
        }
        if(dp[i][j][istrue]!=-1) return dp[i][j][istrue];
        int ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            int lt=f(i,ind-1,s,1,dp);
            int lf=f(i,ind-1,s,0,dp);
            int rt=f(ind+1,j,s,1,dp);
            int rf=f(ind+1,j,s,0,dp);
            if(s.charAt(ind)=='&'){
                if(istrue==1) {
                    ways += (lt*rt)%m;
                }
                else {
                    ways += (lf*rt)%m;
                    ways += (lt*rf)%m;
                    ways += (lf*rf)%m;
                }
            }else if(s.charAt(ind)=='|'){
                if(istrue==1) {
                    ways += (lt*rt)%m;
                    ways += (lt*rf)%m;
                    ways += (lf*rt)%m;
                }
                else {
                    ways += (lf*rf)%m;
                }
            }else{
                if(istrue==1) {
                    ways += (lt*rf)%m;
                    ways += (lf*rt)%m;
                }
                else {
                    ways += (lt*rt)%m;
                    ways += (lf*rf)%m;
                }
            }
        }
        return dp[i][j][istrue]= ways%m;
    }
    static int countWays(int N, String S){
        // code here
        int[][][] dp=new int[N][N][2];
        for(int[][] rows:dp){
            for(int[] row:rows){
                Arrays.fill(row,-1);
            }
        }
        return f(0,N-1,S,1,dp);
    }
    public static void main(String[] args) {
        System.out.println(countWays(7,"T|T&F^T"));
    }
}
