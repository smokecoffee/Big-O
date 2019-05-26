package bigO.orange01.lecture09;
/*
 * The Monk and Prateek
The Monk is extremely fond of Prateek, the new HackerEarth moderator. This time, Prateek had to deal with a crazy hash function, f(n)f(n), called the r3gz3n function, which is as follows: N \oplus (sum\ of\ digits \ of(N))N⊕(sum of digits of(N)).

For example, f(81) = 81 \oplus (8+1) = 88f(81)=81⊕(8+1)=88.

Now to test the efficiency of his friend, The Monk gives Prateek a list of NN numbers, and asks him to find out the following information about this list:

The value of the r3gz3n function which occurs the maximum number of times.
Number of collisions with the hash function.
Note 1: If all the values of the function are unique, print the maximum value which occurs in the list of the hashed values.

Note 2: If there are multiple hashed values which occur the maximum number of times, print the smallest hashed value with the maximum count.

Input
The first line will contain a single digit integer, NN, denoting the number of numbers in a list. The second line will contain NN integers, each separated by a space.

Constrain:

1 \le N \le 10^51≤N≤10
​5
​​ 
1 \le N_i \le 10^71≤N
​i
​​ ≤10
​7
​​ 
Output
Print two integers separated by a space, where the first integer denotes the value of the function which occurs the maximum number of times. Remember that if all the values of the function are unique, print the maximum value which occurs in the list. The second integer would denote the number of collisions.

Ví dụ
input
2
40 50
output
55 0

input
4
10 11 12 13
output
9 1

*/
public class ORANGE_L09P01 {

}
