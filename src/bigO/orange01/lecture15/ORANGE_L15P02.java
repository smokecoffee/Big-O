package bigO.orange01.lecture15;
/*
 Interval Product
It’s normal to feel worried and tense the day before a programming contest. To relax, you went out for a drink with some friends in a nearby pub. To keep your mind sharp for the next day, you decided to play the following game. To start, your friends will give you a sequence of NN integers X_1, X_2, ..., X_NX
​1
​​ ,X
​2
​​ ,...,X
​N
​​ . Then, there will be KK rounds; at each round, your friends will issue a command, which can be:

a change command, when your friends want to change one of the values in the sequence; or
a product command, when your friends give you two values I, JI,J and ask you if the product X_I * X_{I+1} * ... * X_{J-1} * X_JX
​I
​​ ∗X
​I+1
​​ ∗...∗X
​J−1
​​ ∗X
​J
​​  is positive, negative or zero.
Since you are at a pub, it was decided that the penalty for a wrong answer is to drink a pint of beer. You are worried this could affect you negatively at the next day’s contest, and you don’t want to check if Ballmer’s peak theory is correct. Fortunately, your friends gave you the right to use your notebook. Since you trust more your coding skills than your math, you decided to write a program to help you in the game.

Input
Each test case is described using several lines. The first line contains two integers NN and KK, indicating respectively the number of elements in the sequence and the number of rounds of the game (1 \le N, K \le 10^5(1≤N,K≤10
​5
​​  ). The second line contains NN integers X_iX
​i
​​  that represent the initial values of the sequence (-100 \le X_i \le 100(−100≤X
​i
​​ ≤100 for i = 1, 2, ..., N)i=1,2,...,N). Each of the next KK lines describes a command and starts with an uppercase letter that is either C or P. If the letter is C, the line describes a change command, and the letter is followed by two integers II and VV indicating that X_IX
​I
​​  must receive the value VV (1 \le I \le N(1≤I≤N and -100 \le V \le 100)−100≤V≤100). If the letter is P, the line describes a product command, and the letter is followed by two integers II and JJ indicating that the product from X_IX
​I
​​ to X_JX
​J
​​ , inclusive, must be calculated (1 \le I \le J \le N)(1≤I≤J≤N). Within each test case there is at least one product command.

Output
For each test case output a line with a string representing the result of all the product commands in the test case. The i^{th}i
​th
​​  character of the string represents the result of the i^{th}i
​th
​​  product command. If the result of the command is positive the character must be + (plus); if the result is negative the character must be - (minus); if the result is zero the character must be 0 (zero).

Ví dụ
inputcopy
4 6
-2 6 0 -1
C 1 10
P 1 4
C 3 7
P 2 2
C 4 -5
P 1 4
5 9
1 5 -2 4 3
P 1 2
P 1 5
C 4 -5
P 1 5
P 4 5
C 3 0
P 1 5
C 4 -5
C 4 -5
outputcopy
0+-
+-+-0
 */
public class ORANGE_L15P02 {

}
