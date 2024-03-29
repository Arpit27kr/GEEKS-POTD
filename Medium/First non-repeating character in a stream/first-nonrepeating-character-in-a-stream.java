//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public String FirstNonRepeating(String A) {
        Map<Character, Integer> counter = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : A.toCharArray()) {
            // Update the count of the character
            counter.put(c, counter.getOrDefault(c, 0) + 1);

            // Find the first non-repeating character
            char firstNonRepeating = '#';
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                if (entry.getValue() == 1) {
                    firstNonRepeating = entry.getKey();
                    break;
                }
            }

            result.append(firstNonRepeating);
        }

        return result.toString();
    }
}