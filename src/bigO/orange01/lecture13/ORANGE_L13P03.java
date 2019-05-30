package bigO.orange01.lecture13;
/*
 * Scuba diver
A scuba diver uses a special equipment for diving. He has a cylinder with two containers: one with oxygen and the other with nitrogen. Depending on the time he wants to stay under water and the depth of diving the scuba diver needs various amount of oxygen and nitrogen. The scuba diver has at his disposal a certain number of cylinders. Each cylinder can be described by its weight and the volume of gas it contains. In order to complete his task the scuba diver needs specific amount of oxygen and nitrogen. What is the minimal total weight of cylinders he has to take to complete the task?

Write a program that for each test case:

reads scuba diver's demand for oxygen and nitrogen, the number of accessible cylinders and their descriptions;
computes the minimal total weight of cylinders the scuba diver needs to complete his task;
outputs the result.
Note: the given set of cylinders always allows to complete the given task.

Input
The number of test cases cc is in the first line of input, then cc test cases follow separated by an empty line.

In the first line of a test case there are two integers t, at,a separated by a single space, 1 \le t \le 211≤t≤21 and 1 \le a \le 791≤a≤79. They denote volumes of oxygen and nitrogen respectively, needed to complete the task. The second line contains one integer nn, 1 \le n \le 10001≤n≤1000, which is the number of accessible cylinders. The following nn lines contain descriptions of cylinders; i^{th}i
​th
​​  line contains three integers t_i, a_i, w_it
​i
​​ ,a
​i
​​ ,w
​i
​​  separated by single spaces, (1 \le t_i \le 21, 1 \le a_i \le 79, 1 \le w_i \le 800)(1≤t
​i
​​ ≤21,1≤a
​i
​​ ≤79,1≤w
​i
​​ ≤800). These are respectively: volume of oxygen and nitrogen in the i^{th}i
​th
​​  cylinder and the weight of this cylinder.

Output
For each test case your program should output one line with the minimal total weight of cylinders the scuba diver should take to complete the task.

Ví dụ
inputcopy
1
5 60
5
3 36 120
10 25 129
5 50 250
1 45 130
4 20 119
outputcopy
249
Giải thích
If the scuba diver needs 55 litres of oxygen and 6060 litres of nitrogen then he has to take two cylinders of total weight 249249 (for example the first and the second ones or the fourth and the fifth ones).

 */
public class ORANGE_L13P03 {

}
