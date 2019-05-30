package bigO.orange01.finalExam;

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
