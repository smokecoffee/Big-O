package bigO.orange01.lecture12;
/*
 * Price And Pricess
In an n*nn∗n chessboard, Prince and Princess plays a game. The squares in the chessboard are numbered 1, 2, 3, ..., n * n1,2,3,...,n∗n, as shown below:



Prince stands in square 11, make pp jumps and finally reach square n * nn∗n. He enters a square at most once. So if we use x_px
​p
​​  to denote the p^{th}p
​th
​​  square he enters, then x_1, x_2, ..., x_{p + 1}x
​1
​​ ,x
​2
​​ ,...,x
​p+1
​​  are all diﬀerent. Note that x_1 = 1x
​1
​​ =1 and x_{p+1} = n * nx
​p+1
​​ =n∗n. Princess does the similar thing – stands in square 11, make q jumps and finally reach square n * nn∗n. We use y_1, y_2, ..., y_{q+1}y
​1
​​ ,y
​2
​​ ,...,y
​q+1
​​  to denote the sequence, and all q + 1q+1 numbers are diﬀerent.

Figure 22 belows show a 3 \times 33×3 square, a possible route for Prince and a diﬀerent route for Princess.



The Prince moves along the sequence: 1 -> 7 -> 5 -> 4 -> 8 -> 3 -> 91−>7−>5−>4−>8−>3−>9 (Black arrows), while the Princess moves along this sequence: 1 -> 4 -> 3 -> 5 > 6 -> 2 -> 8 -> 91−>4−>3−>5>6−>2−>8−>9 (White arrow).

The King – their father, has just come. "Why move separately? You are brother and sister!" said the King, "Ignore some jumps and make sure that you’re always together."

For example, if the Prince ignores his 2^{nd}, 3^{rd}, 6^{th}2
​nd
​​ ,3
​rd
​​ ,6
​th
​​  jump, he’ll follow the route: 1 -> 4 -> 8 -> 91−>4−>8−>9. If the Princess ignores her 3^{rd}, 4^{th}, 5^{th}, 6^{th}3
​rd
​​ ,4
​th
​​ ,5
​th
​​ ,6
​th
​​ jump, she’ll follow the same route: 1 -> 4 -> 8 -> 91−>4−>8−>9, (The common route is shown in figure 33) thus satisfies the King, shown above. The King wants to know the longest route they can move together, could you tell him?

Input
The ﬁrst line of the input contains a single integer t (1 \le t \le 10)t(1≤t≤10), the number of test cases followed. For each case, the ﬁrst line contains three integers n, p, q (2 \le n \le 250, 1 \le p,q < n*n)n,p,q(2≤n≤250,1≤p,q<n∗n). The second line contains p+1p+1 diﬀerent integers in the range [1...n*n][1...n∗n], the sequence of the Prince. The third line contains q + 1q+1 diﬀerent integers in the range [1...n*n][1...n∗n], the sequence of the Princess.

Output
For each test case, print the case number and the length of longest route. Look at the output for sample input for details.

Ví dụ
Input:
1
3 6 7
1 7 5 4 8 3 9
1 4 3 5 6 2 8 9
Output:
Case 1: 4

 */
public class ORANGE_L12P05 {

}
