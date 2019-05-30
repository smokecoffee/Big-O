package bigO.orange01.lecture15;
/*
 Brackets
We will call a bracket word any word constructed out of two sorts of characters: the opening bracket "(" and the closing bracket ")". Among these words we will distinguish correct bracket expressions. These are such bracket words in which the brackets can be matched into pairs such that

every pair consists of an opening bracket and a closing bracket appearing further in the bracket word
for every pair the part of the word between the brackets of this pair has equal number of opening and closing brackets
On a bracket word one can do the following operations:

replacement - changes the i^{th}i
​th
​​  bracket into the opposite one
check - if the word is a correct bracket expression
You should write a program which

reads (from standard input) the bracket word and the sequence of operations performed,
for every check operation determines if the current bracket word is a correct bracket expression,
writes out the outcome (to standard output).
Input
Ten test cases (given one under another, you have to process all!). Each of the test cases is a series of lines. The first line of a test consists of a single number nn (1 \le n \le 30000)(1≤n≤30000) denoting the length of the bracket word. The second line consists of nn brackets, not separated by any spaces. The third line consists of a single number mm - the number of operations. Each of the following mm lines carries a number kk denoting the operation performed. k=0k=0 denotes the check operation, k>0k>0 denotes replacement of k^{th}k
​th
​​  bracket by the opposite.

Output
For every test case your program should print a line:

Test i:

where ii is replaced by the number of the test and in the following lines, for every check operation in the i^{th}i
​th
​​  test your program should print a line with the word YES, if the current bracket word is a correct bracket expression, and a line with a word NO otherwise. (There should be as many lines as check operations in the test.)

Ví dụ
inputcopy
4
()((
4
4
0
2
0
6
((()))
4
0
1
6
0
2
()
4
0
1
2
0
5
((())
4
0
1
2
0
6
()()()
5
0
2
3
0
0
6
)))(((
8
0
1
2
3
4
5
6
0
4
(()(
5
0
4
0
1
0
4
()()
4
0
2
3
0
6
())())
7
0
3
6
0
6
0
1
3
(()
7
0
2
0
3
0
3
0
outputcopy
Test 1:
YES
NO
Test 2:
YES
NO
Test 3:
YES
NO
Test 4:
NO
NO
Test 5:
YES
YES
YES
Test 6:
NO
YES
Test 7:
NO
YES
NO
Test 8:
YES
YES
Test 9:
NO
NO
YES
Test 10:
NO
NO
NO
NO

 */
public class ORANGE_L15P03 {

}
