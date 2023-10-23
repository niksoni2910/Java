import java.util.Arrays;
public class LCS_OF_3 {
    static int f(int x, int y,int z, String s1, String s2,String s3,int[][][] dp){
        if(x>=s1.length() || y>=s2.length() || z>=s3.length()) return 0;
        if(dp[x][y][z]!=-1) return dp[x][y][z];
        if(s1.charAt(x)==s2.charAt(y) && s2.charAt(y)==s3.charAt(z)) return dp[x][y][z]=1+f(x+1,y+1,z+1,s1,s2,s3,dp);
        int a=f(x+1,y,z,s1,s2,s3,dp);
        int b=f(x,y+1,z,s1,s2,s3,dp);
        int c=f(x,y,z+1,s1,s2,s3,dp);
        int d=f(x+1,y+1,z,s1,s2,s3,dp);
        int e=f(x+1,y,z+1,s1,s2,s3,dp);
        int f=f(x,y+1,z+1,s1,s2,s3,dp);
        return dp[x][y][z]= Math.max(a,Math.max(b,Math.max(c,Math.max(d,Math.max(e,f)))));
    }
    static int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int[][][] dp=new int[n1][n2][n3];
        for(int[][] row:dp){
            for(int[] rows:row) Arrays.fill(rows,-1);
        }
        return f(0,0,0,A,B,C,dp);
    }
    public static void main(String[] args) {
        System.out.println(LCSof3("abcd","efgh","ijkl",4,4,4));
    }
    
}
