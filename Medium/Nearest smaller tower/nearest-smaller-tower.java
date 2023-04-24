//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends



//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int n=arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(left[i]==-1 && right[i]==-1){
                ans[i]=-1;
            }else if(left[i]==-1){
                ans[i]=right[i];
            }else if(right[i]==-1){
                ans[i]=left[i];
            }else if(Math.abs(i-left[i]) == Math.abs(i-right[i])){
                ans[i]=(arr[left[i]]>arr[right[i]])?right[i]:left[i];
                    
            }else if(Math.abs(i-left[i])<Math.abs(i-right[i])){
                ans[i] = left[i];
            }else{
                ans[i]=right[i];
            }
        }
        return ans;
	}
}