package bigO.orange01.finalExam;
Trainsorting
ErinErin is an engineer. She drives trains. She also arranges the cars within each train. She prefers to put the cars in decreasing order of weight, with the heaviest car at the front of the train.

Unfortunately, sorting train cars is not easy. One cannot simply pick up a car and place it somewhere else. It is impractical to insert a car within an existing train. A car may only be added to the beginning and end of the train.

Cars arrive at the train station in a predetermined order. When each car arrives, ErinErin can add it to the beginning or end of her train, or refuse to add it at all. The resulting train should be as long as possible, but the cars within it must be ordered by weight.

Given the weights of the cars in the order in which they arrive, what is the longest train that ErinErin can make?

Input
The first line is the number of test cases to follow. The test cases follow, one after another; the format of each test case is the following:

The first line contains an integer 0 \le n \le 20000≤n≤2000, the number of cars. Each of the following nn lines contains a non-negative integer giving the weight of a car. No two cars have the same weight.

Output
Output a single integer giving the number of cars in the longest train that can be made with the given restrictions.

Ví dụ
inputcopy
1
3
1
2
3
outputcopy
3
public class ORANGE_L16P02 {

	
	/* A Naive recursive implementation of LCS problem in java*/
	  
	  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	  int lcs( char[] X, char[] Y, int m, int n ) 
	  { 
	    if (m == 0 || n == 0) 
	      return 0; 
	    if (X[m-1] == Y[n-1]) 
	      return 1 + lcs(X, Y, m-1, n-1); 
	    else
	      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n)); 
	  } 
	  
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 
	  
	  
	  public static void main(String[] args) {
//			Scanner scan = new Scanner(System.in);
//
//			int n = scan.nextInt();
//			int i = 0;
//			while (i < n) {
//				int value = scan.nextInt();
//				System.out.println(2*value - 2);
//				i++;
//			}
//			scan.close();
//			System.exit(0);
			
			ORANGE_L16P02 lcs = new ORANGE_L16P02(); 
		    String s1 = "AGGTAB"; 
		    String s2 = "GXTXAYB"; 
		  
		    char[] X=s1.toCharArray(); 
		    char[] Y=s2.toCharArray(); 
		    int m = X.length; 
		    int n1 = Y.length; 
		  
		    System.out.println("Length of LCS is" + " " + 
		                                  lcs.lcs( X, Y, m, n1 ) ); 
		    

			
		}
	
}
