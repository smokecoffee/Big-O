package bigO.orange01.lecture13;
/*
 * 
Diving for Gold
John is a diver and a treasure hunter. He has just found the location of a pirate ship full of treasures. The sofisticated sonar system on board his ship allows him to identify the location, depth and quantity of gold in each suken treasure. Unfortunatelly, John forgot to bring a GPS device and the chances of ever finding this location again are very slim so he has to grab the gold now. To make the situation worse, John has only one compressed air bottle.

John wants to dive with the compressed air bottle to recover as much gold as possible from the wreck. Write a program John can use to select which treasures he should pick to maximize the quantity of gold recovered.

The problem has the following restrictions:

There are nn treasures {(d_1, v_1),(d_2, v_2), ..., (d_n, v_n)}(d
​1
​​ ,v
​1
​​ ),(d
​2
​​ ,v
​2
​​ ),...,(d
​n
​​ ,v
​n
​​ ) represented by the pair (depth, quantity of gold). There are at most 3030 treasures.
The air bottle only allows for tt seconds under water. tt is at most 10001000 seconds.
In each dive, John can bring the maximum of one treasure at a time.
The descent time is td_i = w * d_itd
​i
​​ =w∗d
​i
​​ , where ww is an integer constant.
The ascent time is ta_i = 2w * d_ita
​i
​​ =2w∗d
​i
​​ , where ww is an integer constant.
Due to instrument limitations, all parameters are integer
Input
The input to this program consists of a sequence of integer values. Input contains several test cases. The first line of each dataset should contain the values tt and ww. The second line contains the number of treasures. Each of the following lines contains the depth d_id
​i
​​  and quantity of gold v_iv
​i
​​  of a different treasure.

A blank line separates each test case.

Output
The first line of the output for each dataset should contain the maximum amount of gold that John can recover from the wreck. The second line should contain the number of recovered treasures. Each of the following lines should contain the depth and amount of gold of each recovered treasure. Treasures should be presented in the same order as the input file.

Print a blank line between outputs for different datasets

Ví dụ
inputcopy
210 4
3
10 5
10 1
7 2
outputcopy
7
2
10 5
7 2
Giải thích
In this sample input, the bottle of compressed air has a capacity of 200200 seconds, the constant ww has the value 44 and there are 33 treasures, the first one at a depth of 1010 meters and worth 55 coins of gold, the second one at a depth of 1010 meters and worth 11 coin of gold, and the third one at 77 meters and worth 22 coins of gold.

 */
public class ORANGE_L13P04 {

}
