package bigO.orange01.lecture05;
/*
 * Roma and Changing Signs
Roma works in a company that sells TVs. Now he has to prepare a report for the last year.

Roma has got a list of the company's incomes. The list is a sequence that consists of nn integers. The total income of the company is the sum of all integers in sequence. Roma decided to perform exactly kk changes of signs of several numbers in the sequence. He can also change the sign of a number one, two or more times.

The operation of changing a number's sign is the operation of multiplying this number by -1−1.

Help Roma perform the changes so as to make the total income of the company (the sum of numbers in the resulting sequence) maximum. Note that Roma should perform exactly kk changes.

Input
The first line contains two integers nn and kk (1 \le n, k \le 10^51≤n,k≤10
​5
​​ ), showing how many numbers are in the sequence and how many swaps are to be made.

The second line contains a non-decreasing sequence, consisting of nn integers a_ia
​i
​​  (|{a_i}| \le 10^4)(∣a
​i
​​ ∣≤10
​4
​​ ).

The numbers in the lines are separated by single spaces. Please note that the given sequence is sorted in non-decreasing order.

Output
In the single line print the answer to the problem — the maximum total income that we can obtain after exactly kk changes.

Ví dụ
input
3 2
-1 -1 1
output
3
input
3 1
-1 -1 1
output
1
---------
Để tổng lợi nhuận thu về là lớn nhất, ta sẽ thực hiện đổi dấu trên các số âm theo thứ tự từ bé đến lớn (vì khi đổi dấu số âm càng nhỏ thì kết quả thu được là một số dương càng lớn). Nếu đã đổi dấu toàn bộ số âm mà vẫn chưa đủ k lần đổi dấu theo yêu cầu, ta xét:

Nếu số lần đổi dấu còn lại là chẵn, ta có thể giữ nguyên lợi nhuận hiện tại bằng cách thực hiện đổi dấu trên một số duy nhất bất kỳ.

Ngược lại nếu số lần đổi dấu còn lại là lẻ, để lợi nhuận giảm đi ít nhất có thể ta sẽ thực hiện đổi dấu trên số nhỏ nhất hiện có trong dãy, tạm gọi là xx. Khi này, tổng lợi nhuận sẽ giảm đi một lượng là 2 * x2∗x.

Độ phức tạp: O(n) với n là số lượng số nguyên trong dãy.

 */
public class ORANGE_L05P02 {

}
