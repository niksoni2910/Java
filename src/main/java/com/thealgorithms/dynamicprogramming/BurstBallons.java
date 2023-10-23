import java.util.Arrays;
public class BurstBallons {
    static public int f(int i,int j,int[] num,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=num[i-1]*num[ind]*num[j+1]+f(i,ind-1,num,dp)+f(ind+1,j,num,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
    static public int maxCoins(int[] nums) {

        int[] num=new int[nums.length+2];
        num[0]=1;
        for(int i=1;i<nums.length+1;i++) num[i]=nums[i-1];
        num[nums.length+1]=1;
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(1,nums.length,num,dp);
    }
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
    
}
