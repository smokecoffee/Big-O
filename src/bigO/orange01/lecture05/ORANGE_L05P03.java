package bigO.orange01.lecture05;
/*
 * Wine trading in Gergovia
Gergovia consists of one street, and every inhabitant of the city is a wine salesman. Everyone buys wine from other inhabitants of the city. Every day each inhabitant decides how much wine he wants to buy or sell. Interestingly, demand and supply is always the same, so that each inhabitant gets what he wants.

There is one problem, however: Transporting wine from one house to another results in work. Since all wines are equally good, the inhabitants of Gergovia don't care which persons they are doing trade with, they are only interested in selling or buying a specific amount of wine.

In this problem you are asked to reconstruct the trading during one day in Gergovia. For simplicity we will assume that the houses are built along a straight line with equal distance between adjacent houses. Transporting one bottle of wine from one house to an adjacent house results in one unit of work.

Input
The input consists of several test cases.

Each test case starts with the number of inhabitants NN (2 \le N \le 100000)(2≤N≤100000).

The following line contains nn integers a_ia
​i
​​  (-1000 \le a_i \le 1000)(−1000≤a
​i
​​ ≤1000).

If a_i \ge 0a
​i
​​ ≥0, it means that the inhabitant living in the i^{th}i
​th
​​  house wants to buy a_ia
​i
​​  bottles of wine. If a_i < 0a
​i
​​ <0, he wants to sell -{a_i}−a
​i
​​  bottles of wine.

You may assume that the numbers a_ia
​i
​​  sum up to 00.

The last test case is followed by a line containing 00.

Output
For each test case print the minimum amount of work units needed so that every inhabitant has his demand fulfilled.

Ví dụ
input
5
5 -4 1 -3 1
6
-1000 -1000 -1000 1000 1000 1000
0
output
9
9000
---------------------
Nhận xét:

Mỗi người cần mua thì đều chỉ cần mua từ những người gần mình nhất, và cũng tương tự với những người bán. Điều này có nghĩa là, giả sử ta xét từng người từ người đầu tiên, khi ta gặp một người muốn bán thì ta sẽ ưu tiên bán cho những người chưa mua đủ trước đó, nếu còn dư thì ta mới để dành bán cho những người ở sau.

Gọi tổng lượng rượu tích lũy của ii người đầu là SS:

Nếu S < 0S<0 có nghĩa là ta đang tập trung -S−S chai rượu cần bán tại nhà ii.
Nếu S \ge 0S≥0 có nghĩa là ta đang tập trung một số người trước đó có tổng lượng rượu cần mua là SS (ai mua đủ rồi thì có thể quay về).
Khi đi từ nhà ii sang nhà i+1i+1:

Ta di chuyển rượu từ nhà ii sang nhà i+1i+1 (khi đó mỗi chai rượu cần 11 đơn vị năng lượng nên ta cần thêm |S|∣S∣ đơn vị năng lượng vào kết quả.
Ta cộng a_{i+1}a
​i+1
​​  vào S. Nghĩa là nếu a_{i+1} \ge 0a
​i+1
​​ ≥0 thì ta sẽ thêm người i+1i+1 vào nhóm những người đang đợi mua rượu, còn a_{i+1} < 0a
​i+1
​​ <0 thì ta sẽ bán cho một số người ở trước đó đang cần mua, lúc này họ có thể đi về nên SS giảm đi một lượng bằng -a_{i+1}−a
​i+1
​​ , nếu còn dư thì mang đi bán cho các nhà phía sau.
Độ phức tạp: O(n)O(n) với nn là số người trong thị trấn.

 */
public class ORANGE_L05P03 {

}
