package bigO.orange01.finalExam;

import java.util.Scanner;

/**
 * @author ThinkPad-PC
 *File Recover Testing --https://www.spoj.com/problems/FILRTEST/
In a recent programming contest appeared a problem named "File Recover". In that problem, repeated strings of a given text were to be counted. You are preparing test cases for that problem, and in order to test for border cases you want to generate a text with many repetitions of a particular string.
Of course, test cases cannot be arbitrarily long, so you decided to choose a length and a string, and then fit in a text of that length as many repetitions as possible of the string. For instance, if the length is 1414 and the string is abcab, you may generate the text abcabcabcabcab whose length is 1414 and where the string abcab appears 44 times (starting at positions 1, 4, 71,4,7 and 1010).
You would like to know how good your idea is before implementing. Given a length and a string, you must determine the maximum number of times the characters of the string can appear consecutively in a text of that length.
Input
Each test case is described using a single line. The line contains an integer K (1 \le K \le 10^9 )K(1≤K≤10
​9
​​ ) and a non-empty string SS of at most 10^610
​6
​​  lowercase letters. The end of input is indicated with a line containing the number -1−1 and an asterisk (*).
Output
For each test case, output a single line with a single integer representing the maximum number of times the characters of SS can appear consecutively in a text of length KK.
Ví dụ
inputcopy
14 abcab
1000 abcde
1000000000 z
1 zzzzz
-1 *
outputcopy
4
200
1000000000
0
 */
public class ORANGE_L16P01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] val = line.split(" ");
			Integer num = Integer.valueOf(val[0]);
			if(num == -1) return;
			//-1 *
			String str = val[1];
			int strLeng = str.length();
			if(num<strLeng) 
				System.out.println(0); 
			else {
				int loop = num/strLeng;
				int part = num%strLeng;
				String t =str;
				for(int i=1;i<loop;i++) {
					t= t+ str; 
				}
				t= t +str.substring(0, part);
				
				String p = str;
				int[] prefix = new int[p.length()];
				KMPprepare(p, prefix);
				System.out.println( KMPSearch(t, p, prefix));
			}
		}

		scan.close();
		System.exit(0);
		
		
	}

	private static void KMPprepare(String p, int[] prefix) {
		prefix[0] = 0;
		int m = p.length();
		int j = 0;
		int i = 1;
		while (i < m) {
			if (p.charAt(i) == p.charAt(j)) {
				j++;
				prefix[i] = j;
				i++;
			} else {
				if (j != 0)
					j = prefix[j - 1];
				else
					prefix[i] = 0;
				i++;
			}
		}
	}

	private static int KMPSearch(String t, String p, int[] prefix) {
		int result = 0;
		int n = t.length();
		int m = p.length();
		int i = 0, j = 0;
		while (i < n) {
			if (p.charAt(j) == t.charAt(i)) {
				j++;
				i++;
			}
			if (j == m) {
				result++;
				//System.out.printf("Found at : %d", i - j);
				j = prefix[j - 1];
			} else if (i < n && p.charAt(j) != t.charAt(i)) {
				if (j != 0)
					j = prefix[j - 1];
				else
					i = i + 1;
			}
		}
		return result;
	}
	
	private static int KMP2( String p) {
		int m = p.length();
		int[] border = new int[p.length()];
		border[0] = -1;
		for (int i = 0; i < m; ++i) {
		    border[i+1] = border[i];
		    while (border[i+1] > -1 &&
		    		//if (p.charAt(i) == p.charAt(j)) {
		    		
		    		p.charAt(border[i+1]) != p.charAt(i) ){
		      border[i+1] = border[border[i+1]];
		    }
		    border[i+1]++;
		  }

		  return border[border.length-1];
	}

}
