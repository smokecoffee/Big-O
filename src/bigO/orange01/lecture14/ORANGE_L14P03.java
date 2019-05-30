package bigO.orange01.lecture14;
/*
Find String Roots
In mathematics, the N^{th}N
​th
​​  root of a number MM, is a number KK such that K^N = MK
​N
​​ =M , i.e. KKK ... K = MKKK...K=M where KK is multiplied NN times.

We can translate this into strings. In string notation, the yuxtaposition is concatenation instead of multiplication. So, the N^{th}N
​th
​​  root of a string SS is another string TT such that T^N = ST
​N
​​ =S, where T^N = TTT ...TT
​N
​​ =TTT...T is the string TT concatenated NN times. For instance, if S =S= abcabcabcabc, for N = 2N=2 the string T =T= abcabc is the N^{th}N
​th
​​ root of SS, while for N = 4N=4 its N^{th}N
​th
​​  root is T =T= abc. Note that for N = 1N=1 any string SS is the N^{th}N
​th
​​  root of SS itself.

Given a string SS you have to find the maximum NN such that the N^{th}N
​th
​​  root of SS exists. In the above example the answer would be 44, because there is no N^{th}N
​th
​​  root of S =S= abcabcabcabc for N > 4N>4.

Input
The input contains several test cases, each one described in a single line. The line contains a non-empty string SS of at most 10^510
​5
​​  characters, entirely formed of digits and lowercase letters. The last line of the input contains a single asterisk ("*") and should not be processed as a test case.

Output
For each test case output a single line with the greatest integer NN such that there exists a string TT that concatenated NN times is equal to SS.

Ví dụ
inputcopy
abcabcabcabc
abcdefgh012
aaaaaaaaaa
*
outputcopy
4
1
10
 */
public class ORANGE_L14P03 {

}
