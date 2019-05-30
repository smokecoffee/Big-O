package bigO.orange01.lecture15;
/*
 * 
 Curious Robin Hood
Robin Hood likes to loot rich people since he helps the poor people with this money. Instead of keeping all the money together he does another trick. He keeps nn sacks where he keeps this money. The sacks are numbered from 00 to n-1n−1.

Now each time he can he can do one of the three tasks:

Give all the money of the i^{th}i
​th
​​  sack to the poor, leaving the sack empty.
Add new amount (given in input) in the i^{th}i
​th
​​  sack.
Find the total amount of money from i^{th}i
​th
​​  sack to j^{th}j
​th
​​  sack.
Since he is not a programmer, he seeks your help.

Input
Input starts with an integer T (\le 5)T(≤5), denoting the number of test cases.

Each case contains two integers nn (1 \le n \le 10^5)(1≤n≤10
​5
​​ ) and qq (1 \le q \le 50000)(1≤q≤50000). The next line contains nn space separated integers in the range [0, 1000][0,1000]. The i^{th}i
​th
​​ integer denotes the initial amount of money in the i^{th}i
​th
​​  sack (0 \le i < n)(0≤i<n).

Each of the next qq lines contains a task in one of the following form:

1 i: Give all the money of the i^{th}i
​th
​​  (0 \le i < n)(0≤i<n) sack to the poor.
2 i v: Add money vv (1 \le v \le 1000)(1≤v≤1000) to the i^{th}i
​th
​​  (0 \le i < n)(0≤i<n) sack.
3 i j: Find the total amount of money from i^{th}i
​th
​​  sack to j^{th}j
​th
​​  sack (0 \le i \le j < n)(0≤i≤j<n)
Output
For each test case, print the case number first. If the query type is 11, then print the amount of money given to the poor. If the query type is 33, print the total amount from i^{th}i
​th
​​  sack to j^{th}j
​th
​​  sack.

Ví dụ
inputcopy
1
5 6
3 2 1 4 5
1 4
2 3 4
3 0 3
1 2
3 0 4
1 1
outputcopy
Case 1:
5
14
1
13
2
Language:
1
​
 Submit
 
 */
public class ORANGE_L15P01 {

}
