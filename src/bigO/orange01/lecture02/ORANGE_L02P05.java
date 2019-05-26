package bigO.orange01.lecture02;

/**
 * @author ThinkPad-PC
 *Sansa and XOR
Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Can you help her in this task?

For example, if arr = [3, 4, 5][3,4,5]:

Subarray	Operation	Result
3	None	3
4	None	4
5	None	5
3, 4	3 XOR 4	7
4, 5	4 XOR 5	1
3, 4, 5	3 XOR 4 XOR 5	2
Now we take the resultant values and XOR them together: 3 \oplus 4 \oplus 5 \oplus 7 \oplus 1 \oplus 2 = 63⊕4⊕5⊕7⊕1⊕2=6

Input
The first line contains an integer TT, the number of the test cases.

Each of the next TT pairs of lines is as follows:

The first line of each test case contains an integer nn, the number of elements in arr.
The second line of each test case contains nn space-separated integers arr_iarr
​i
​​ .
CONSTRAINTS:

1 \le T \le 51≤T≤5
2 \le n \le 10^52≤n≤10
​5
​​ 
1 \le arr_i \le 10^81≤arr
​i
​​ ≤10
​8
​​ 
Output
Print the result of each test case on a separate line.

Ví dụ
input
2
3
1 2 3
4
4 5 7 5
output
2
0
Giải thích
Test case 1:


Test case 2:

 */
public class ORANGE_L02P05 {

}
