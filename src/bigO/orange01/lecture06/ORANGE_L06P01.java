package bigO.orange01.lecture06;
/*
 * Drazil and His Happy Friends
Drazil has many friends. Some of them are happy and some of them are unhappy. Drazil wants to make all his friends become happy. So he invented the following plan.

There are nn boys and mm girls among his friends. Let's number them from 00 to n - 1n−1 and 00 to m - 1m−1 separately. In i^{th}i
​th
​​  day, Drazil invites (i(i % n)^{th}n)
​th
​​ boy and (i(i % m)^{th}m)
​th
​​  girl to have dinner together (as Drazil is programmer, ii starts from 00). If one of those two people is happy, the other one will also become happy. Otherwise, those two people remain in their states. Once a person becomes happy (or if he/she was happy originally), he stays happy forever.

Drazil wants to know whether he can use this plan to make all his friends become happy at some moment.

Input
The first line contains two integer nn and mm (1 \le n, m \le 100)(1≤n,m≤100).

The second line contains an integer bb (0 \le b \le n)(0≤b≤n), denoting the number of happy boys among friends of Drazil, and then follow bb distinct integers x_1, x_2, ..., x_bx
​1
​​ ,x
​2
​​ ,...,x
​b
​​  (0 \le x_i < n)(0≤x
​i
​​ <n), denoting the list of indices of happy boys.

The third line contains an integer gg (0 \le g \le m)(0≤g≤m), denoting the number of happy girls among friends of Drazil, and then follow gg distinct integers y_1, y_2, ..., y_gy
​1
​​ ,y
​2
​​ ,...,y
​g
​​  (0 \le y_j < m)(0≤y
​j
​​ <m), denoting the list of indices of happy girls.

It is guaranteed that there is at least one person that is unhappy among his friends.

Output
If Drazil can make all his friends become happy by this plan, print Yes. Otherwise, print No.

Ví dụ
input
2 3
0
1 0
output
Yes
input 
2 4
1 0
1 2
output 
No
input 
2 3
1 0
1 1
output
Yes
Giải thích
By ii % kk we define the remainder of integer division of ii by kk.

In first sample case:

On the 0^{th}0
​th
​​  day, Drazil invites 0^{th}0
​th
​​  boy and 0^{th}0
​th
​​  girl. Because 0^{th}0
​th
​​  girl is happy at the beginning, 0^{th}0
​th
​​  boy become happy at this day.
On the 1^{st}1
​st
​​  day, Drazil invites 1^{st}1
​st
​​  boy and 1^{st}1
​st
​​  girl. They are both unhappy, so nothing changes at this day.
On the 2^{nd}2
​nd
​​  day, Drazil invites 0^{th}0
​th
​​  boy and 2^{nd}2
​nd
​​  girl. Because 0^{th}0
​th
​​  boy is already happy he makes 2^{nd}2
​nd
​​  girl become happy at this day.
On the 3^{rd}3
​rd
​​  day, Drazil invites 1^{st}1
​st
​​  boy and 0^{th}0
​th
​​  girl. 0^{th}0
​th
​​  girl is happy, so she makes 1^{st}1
​st
​​  boy happy.
On the 4^{th}4
​th
​​  day, Drazil invites 0^{th}0
​th
​​  boy and 1^{st}1
​st
​​  girl. 0^{th}0
​th
​​  boy is happy, so he makes the 1^{st}1
​st
​​  girl happy. So, all friends become happy at this moment.
Bài này ta sẽ đơn giản duyệt qua các ngày để xem các cặp bạn nam và bạn nữ để kiểm tra xem có ai trong hai người vui không. Ta có số lượng người không vui ban đầu (m + n - b - g)(m+n−b−g), mỗi lần duyệt một cặp nam – nữ nếu chỉ một người vui thì ta giảm lượng này đi 11. Nếu qua số ngày ta quy định mà lượng này vẫn chưa bằng 00 thì đáp án là "No" ngược lại là "Yes".

Nhưng câu hỏi đặt ra là số ngày cần phải duyệt qua là bao nhiêu?

Vào ngày thứ 00 thì bạn nam thứ 00 và bạn nữ thứ 00 được mời, ngày gần nhất tiếp theo mà 22 người này cùng nhau được mời là LCM(N, M)LCM(N,M) – bội chung nhỏ nhất của n, mn,m. Do: \left\{\begin{matrix} LCM(n, m) \% n = 0\\ LCM(n, m) \% m = 0 \end{matrix}\right.{
​LCM(n,m)%n=0
​LCM(n,m)%m=0
​​ 

Vậy số ngày tối đa bạn cần phải duyệt là 2 * LCM(m, n)2∗LCM(m,n) (để bạn nam thứ N - 1N−1 và nữ thứ M - 1M−1 có thể gặp nhau lần 22) với LCM(m, n) = \frac{m * n}{GCD(m, n)}LCM(m,n)=
​GCD(m,n)
​
​m∗n
​​ .

Độ phức tạp: O(LCM(n, m))O(LCM(n,m)) với n, mn,m là số bạn nam và nữ.
 */
public class ORANGE_L06P01 {

}
