package bigO.orange01.lecture15;
/*
Xenia and Bit Operations
Xenia the beginner programmer has a sequence aa, consisting of 2^n2
​n
​​  non-negative integers: a_1, a_2, ..., a_{2^n}a
​1
​​ ,a
​2
​​ ,...,a
​2
​n
​​ 
​​ . Xenia is currently studying bit operations. To better understand how they work, Xenia decided to calculate some value vv for aa.

Namely, it takes several iterations to calculate value vv. At the first iteration, Xenia writes a new sequence: a_1a
​1
​​  or a_2a
​2
​​ , a_3a
​3
​​  or a_4a
​4
​​ , ..., a_{2^n - 1}a
​2
​n
​​ −1
​​  or a_{2^n}a
​2
​n
​​ 
​​ , consisting of 2^n - 12
​n
​​ −1 elements. In other words, she writes down the bit-wise OR of adjacent elements of sequence aa. At the second iteration, Xenia writes the bitwise exclusive OR of adjacent elements of the sequence obtained after the first iteration. At the third iteration Xenia writes the bitwise OR of the adjacent elements of the sequence obtained after the second iteration. And so on; the operations of bitwise exclusive OR and bitwise OR alternate. In the end, she obtains a sequence consisting of one element, and that element is vv.

Let's consider an example. Suppose that sequence a = (1, 2, 3, 4)a=(1,2,3,4). Then let's write down all the transformations (1, 2, 3, 4) \rightarrow (1 \ or \ 2 = 3, 3 \ or \ 4 = 7) \rightarrow (3 \ xor \ 7 = 4)(1,2,3,4)→(1 or 2=3,3 or 4=7)→(3 xor 7=4). The result is v = 4v=4.

You are given Xenia's initial sequence. But to calculate value vv for a given sequence would be too easy, so you are given additional mm queries. Each query is aa pair of integers p, bp,b. Query p, bp,b means that you need to perform the assignment a_p=ba
​p
​​ =b. After each query, you need to print the new value vv for the new sequence aa.

Input
The first line contains two integers nn and mm (1 \le n \le 17, 1 \le m \le 10^5)(1≤n≤17,1≤m≤10
​5
​​ ). The next line contains 2^n2
​n
​​  integers a_1, a_2, ..., a_{2^n}a
​1
​​ ,a
​2
​​ ,...,a
​2
​n
​​ 
​​  (0 \le a_i < 2^{30})(0≤a
​i
​​ <2
​30
​​ ). Each of the next mm lines contains queries. The i^{th}i
​th
​​  line contains integers p_i, b_ip
​i
​​ ,b
​i
​​  (1 \le p_i \le 2^n, 0 \le b_i < 2^{30})(1≤p
​i
​​ ≤2
​n
​​ ,0≤b
​i
​​ <2
​30
​​ ) — the i^{th}i
​th
​​  query.

Output
Print mm integers — the i^{th}i
​th
​​  integer denotes value vv for sequence aa after the i^{th}i
​th
​​  query.

Ví dụ
inputcopy
2 4
1 6 3 5
1 4
3 4
1 2
1 2
outputcopy
1
3
3
3
 */
public class ORANGE_L15P04 {

}
