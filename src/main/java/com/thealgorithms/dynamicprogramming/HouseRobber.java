public class HouseRobber {
    static public int rob(int[] nums) {
        int n=nums.length;
        int[][] dp =new int[n+1][2];
        for(int i=n;i>=0;i--){
            for(int j=0;j<2;j++){
                if(i==n) dp[i][j]=0;
                else if(j==0) dp[i][j]=dp[i+1][1];
                else dp[i][j]=Math.max(nums[i]+dp[i+1][0],dp[i+1][1]);
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    
}
