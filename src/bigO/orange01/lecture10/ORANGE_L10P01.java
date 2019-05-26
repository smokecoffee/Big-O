package bigO.orange01.lecture10;
/*
 * Bytelandian gold coins
In Byteland they have a very strange monetary system. Each Bytelandian gold coin has an integer number written on it. A coin nn can be exchanged in a bank into three coins: \frac{n}{2}, \frac{n}{3}
​2
​
​n
​​ ,
​3
​
​n
​​  and \frac{n}{4}
​4
​
​n
​​ . But these numbers are all rounded down (the banks have to make a profit). You can also sell Bytelandian coins for American dollars. The exchange rate is 1:11:1. But you can not buy Bytelandian coins. You have one gold coin. What is the maximum amount of American dollars you can get for it?

Input
The input will contain several test cases (not more than 1010). Each testcase is a single line with a number n, 0 \le n \le 1 000 000 000n,0≤n≤1000000000. It is the number written on your coin.

Output
For each test case output a single line, containing the maximum amount of American dollars you can make.

Ví dụ
input
12
2
output
13
2
Giải thích
You can change 1212 into 6, 46,4 and 33, and then change these into \$6+\$4+\$3 = \$13$6+$4+$3=$13. If you try changing the coin 22 into 33 smaller coins, you will get 1, 01,0 and 00, and later you can get no more than \$1$1 out of them. It is better just to change the 22 coin directly into \$2$2
 */
public class ORANGE_L10P01 {

}
