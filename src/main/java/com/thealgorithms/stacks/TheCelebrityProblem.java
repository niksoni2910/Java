import java.util.*;

class TheCelebrityProblem
{ 
    //Function to find if there is a celebrity in the party or not.
    public static int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	while(st.size()>1){
    	    int a=st.pop();
    	    int b=st.pop();
    	    if(M[a][b]==1 && M[b][a]==0){
    	        st.push(b);
    	    }
    	    else if(M[a][b]==0 && M[b][a]==1){
    	        st.push(a);
    	    }
    	}
    	if(st.isEmpty()){
    	    return -1;
    	}
    	int ans=st.peek();
    	for(int j=0;j<n;j++){
    	    if(j==ans){
    	        continue;
    	    }
    	    if(M[j][ans]==0){
    	        return -1;
    	    }
    	    if(M[ans][j]==1) return -1;
    	}
    	return ans;
    }
    public static void main(String[] args) {
        int[][] t={{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(celebrity(t, 3));
    }
}