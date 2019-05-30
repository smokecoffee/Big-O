package bigO.orange01.lecture13;

/*
 * Pick The Sticks
The story happened long long ago. One day, Cao Cao made a special order called “Chicken Rib” to his army. 
No one got his point and all became very panic. However, Cao Cao himself felt very proud of his interesting idea and enjoyed it.
Xiu Yang, one of the cleverest counselors of Cao Cao, understood the command Rather than keep it to himself, he told the point to the whole army.
Cao Cao got very angry at his cleverness and would like to punish Xiu Yang. But how can you punish someone because he’s clever? 
By looking at the chicken rib, he finally got a new idea to punish Xiu Yang.
He told Xiu Yang that as his reward of encrypting the special order, he could take as many gold sticks as possible from his desk. 
But he could only use one stick as the container.
Formally, we can treat the container stick as an LL length segment. And the gold sticks as segments too. 
There were many gold sticks with different length a​i and value v​i. Xiu Yang needed to put these gold segments onto the container segment. 
No gold segment was allowed to be overlapped. Luckily, Xiu Yang came up with a good idea. 
On the two sides of the container, he could make part of the gold sticks outside the container as long as the center of the gravity of each gold stick was still within the container. This could help him get more valuable gold sticks.

As a result, Xiu Yang took too many gold sticks which made Cao Cao much more angry. Cao Cao killed Xiu Yang before he made himself home. 
So no one knows how many gold sticks Xiu Yang made it in the container.

Can you help solve the mystery by finding out what’s the maximum value of the gold sticks Xiu Yang could have taken?

Input
The first line of the input gives the number of test cases, T(1≤T≤100). T test cases follow. Each test case start with two integers, N(1≤N≤500) and L(1≤L≤1000), represents the number of gold sticks and the length of the container stick. 
N lines follow. Each line consist of two integers, a​i(1≤a​i≤1000) and v​i(1≤v​i​​≤10^​9), represents the length and the value of the i​th gold stick.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum value of the gold sticks Xiu Yang could have taken.

Ví dụ
input
4

3 7
4 1
2 1
8 1

3 7
4 2
2 1
8 4

3 5
4 1
2 2
8 9

1 1
10 3
output
Case #1: 2
Case #2: 6
Case #3: 11
Case #4: 3

Giải thích
In the third case, assume the container is lay on x-axis from 00 to 55. Xiu Yang could put the second gold stick center at 00 and put the third gold stick center at 55, so none of them will drop and he can get total 2 + 9 = 112+9=11 value.

In the fourth case, Xiu Yang could just put the only gold stick center on any position of [0, 1][0,1], and he can get the value of 33.
 */
public class ORANGE_L13P05 {

}
