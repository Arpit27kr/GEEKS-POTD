//{ Driver Code Starts
import java.util.*;

class TwoStack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T>0)
		{
			twoStacks g = new twoStacks();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int stack_no = sc.nextInt();
				int QueryType = sc.nextInt();
				
				
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					if(stack_no == 1)
					 g.push1(a);
					else if(stack_no ==2)
					 g.push2(a);
				}else if(QueryType == 2)
				{
					if(stack_no==1)
					System.out.print(g.pop1()+" ");
					else if(stack_no==2)
					System.out.print(g.pop2()+" ");
				}
			
				Q--;
			}
				System.out.println();
		  T--;
		}
	}
}


// } Driver Code Ends


class twoStacks {
    int arr[];
    int size;
    int top1, top2;

    // Constructor to initialize the two stacks
    twoStacks() {
        size = 100;
        arr = new int[100];
        top1 = -1; // Initialize top index of stack1
        top2 = size; // Initialize top index of stack2
    }

    // Function to push an integer into stack1
    void push1(int x) {
        // Check if there is space in stack1
        if (top1 < top2 - 1) {
            top1++; // Increment top1 index
            arr[top1] = x; // Insert element into stack1
        }
    }

    // Function to push an integer into stack2
    void push2(int x) {
        // Check if there is space in stack2
        if (top1 < top2 - 1) {
            top2--; // Decrement top2 index
            arr[top2] = x; // Insert element into stack2
        }
    }

    // Function to remove an element from the top of stack1
    int pop1() {
        // Check if stack1 is not empty
        if (top1 >= 0) {
            int x = arr[top1]; // Get the top element from stack1
            top1--; // Decrement top1 index
            return x; // Return the popped element
        } else {
            return -1; // Stack1 is empty, return -1
        }
    }

    // Function to remove an element from the top of stack2
    int pop2() {
        // Check if stack2 is not empty
        if (top2 < size) {
            int x = arr[top2]; // Get the top element from stack2
            top2++; // Increment top2 index
            return x; // Return the popped element
        } else {
            return -1; // Stack2 is empty, return -1
        }
    }
}


