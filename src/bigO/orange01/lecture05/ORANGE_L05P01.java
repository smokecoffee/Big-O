package bigO.orange01.lecture05;
/*
 * The Number on the Board
Some natural number was written on the board. Its sum of digits was not less than kk. But you were distracted a bit, and someone changed this number to nn, replacing some digits with others. It's known that the length of the number didn't change.

You have to find the minimum number of digits in which these two numbers can differ.

Input
The first line contains integer kk (1 \le k \le 10^91≤k≤10
​9
​​ ).

The second line contains integer nn (1 \le n < 10^{100000}1≤n<10
​100000
​​ ).

There are no leading zeros in nn. It's guaranteed that this situation is possible.

Output
Print the minimum number of digits in which the initial number and nn can differ.

Ví dụ
input
3
11
output
1
input
3
99
output
0
Giải thích
In the first example, the initial number could be 1212.

In the second example the sum of the digits of nn is not less than kk. The initial number could be equal to nn.
-----------------------
Nhận xét:

Nếu tổng chữ số ban đầu đã thỏa điều kiện lớn hơn hoặc bằng số kk → ta không cần phải thay đổi bất cứ chữ số nào trong số ban đầu.

Ngược lại, để tối thiểu số lượng chữ số cần thay đổi thì phải làm cho tổng chữ số tăng lên càng nhanh càng tốt. Để làm được điều này, ta sắp xếp các chữ số trong số nn ban đầu theo thứ tự từ bé đến lớn và lần lượt thay đổi các chữ số thành chữ số lớn nhất là 99 cho đến khi nào tổng các chữ số thỏa điều kiện lớn hơn hoặc bằng số kk. In ra kết quả cần tìm.

Độ phức tạp: O(Nlog(N) với N là số lượng chữ số của số n.

 */
public class ORANGE_L05P01 {

}
