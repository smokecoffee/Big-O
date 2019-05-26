package bigO.orange01.lecture05;
/*
 * Building Permutation
Permutation pp is an ordered set of integers p_1p
​1
​​ ,  p_2p
​2
​​ , ..., p_np
​n
​​ , consisting of nn distinct positive integers, each of them doesn't exceed nn. We'll denote the i^{th}i
​th
​​  element of permutation pp as p_ip
​i
​​ . We'll call number nn the size or the length of permutation p_1p
​1
​​ ,  p_2p
​2
​​ , ..., p_np
​n
​​ .

You have a sequence of integers a_1a
​1
​​ ,  a_2a
​2
​​ , ..., a_na
​n
​​ . In one move, you are allowed to decrease or increase any number by one. Count the minimum number of moves needed to build a permutation from this sequence.

Input
The first line contains integer nn (1 \le n \le 3 * 10^5)(1≤n≤3∗10
​5
​​ ) — the size of the sought permutation.

The second line contains nn integers a_1a
​1
​​ ,  a_2a
​2
​​ , ..., a_na
​n
​​  (-10^9 \le a_i \le 10^9)(−10
​9
​​ ≤a
​i
​​ ≤10
​9
​​ ).

Output
Print a single number — the minimum number of moves.

Ví dụ
input
2
3 0
output
2
input
3
-1 -1 2

output
6
-----
Giải thích
In the first sample you should decrease the first number by one and then increase the second number by one. The resulting permutation is (2, 1)(2,1).

In the second sample you need 66 moves to build permutation (1, 3, 2)(1,3,2).
---------------------
Nhận xét:

Để đếm số thao tác nhỏ nhất, thực tế ta chỉ cần biến số nhỏ nhất thành số 11, số nhỏ nhì thành số 22, ..., số lớn nhất thành NN. Số lượng thao tác để biến số a_ia
​i
​​  thành xx là |a_i - x|∣a
​i
​​ −x∣.

Từ nhận xét trên, ta sẽ sắp xếp lại dãy aa theo chiều tăng dần của các giá trị a_ia
​i
​​ , sau đó tiến hành duyệt với mọi ii từ 11 đến NN, ta cộng vào kết quả giá trị |a_i - i|∣a
​i
​​ −i∣.

Chứng minh:

Ta sẽ đưa về chứng minh một bài toán tổng quát như sau: "Cho 22 dãy số nguyên aa (a_1, a_2, ..., a_N)(a
​1
​​ ,a
​2
​​ ,...,a
​N
​​ ) và bb (b_1, b_2, ..., b_N)(b
​1
​​ ,b
​2
​​ ,...,b
​N
​​ ) thỏa mãn a_1 \le a_2 \le ... \le a_Na
​1
​​ ≤a
​2
​​ ≤...≤a
​N
​​  và b_1 \le b_2 \le ... \le b_Nb
​1
​​ ≤b
​2
​​ ≤...≤b
​N
​​  thì tổng \sum_{i=1}^{N} {|a_i - b_i|}∑
​i=1
​N
​​ ∣a
​i
​​ −b
​i
​​ ∣ nhỏ nhất."

Ta sẽ chứng minh với N = 2N=2, cần chứng minh: |a_1 - b_1| + |a_2 - b_2| \le |a_1 - b_2| + |a_2 - b_1|∣a
​1
​​ −b
​1
​​ ∣+∣a
​2
​​ −b
​2
​​ ∣≤∣a
​1
​​ −b
​2
​​ ∣+∣a
​2
​​ −b
​1
​​ ∣.

Giả sử ta biểu diễn 44 con số nguyên này thành 44 điểm trên trục hoành (y = 0)(y=0), ta tạm gọi là 44 điểm A_1(a_1, 0)A
​1
​​ (a
​1
​​ ,0), A_2(a_2, 0)A
​2
​​ (a
​2
​​ ,0), B_1(b_1, 0)B
​1
​​ (b
​1
​​ ,0), B_2(b_2, 0)B
​2
​​ (b
​2
​​ ,0). Không mất tính tổng quát, giả sử ta tịnh tiến đoạn thẳng A_1 A_2A
​1
​​ A
​2
​​  sao cho A_1A
​1
​​  trùng với B_1B
​1
​​  thì tổng |a_1 - b_1| + |a_2 - b_2|∣a
​1
​​ −b
​1
​​ ∣+∣a
​2
​​ −b
​2
​​ ∣ và |a_1 - b_2| + |a_2 - b_1|∣a
​1
​​ −b
​2
​​ ∣+∣a
​2
​​ −b
​1
​​ ∣ vẫn không thay đổi. Như vậy khi điểm A_1A
​1
​​  trùng với B_1B
​1
​​ , thì a_1 = b_1a
​1
​​ =b
​1
​​  và khi đó hoành độ của điểm A_2A
​2
​​  là a_2 + b_1 - a_1a
​2
​​ +b
​1
​​ −a
​1
​​ .

Khi đó, bất đẳng thức được đưa về thành:

|b_1 - b_1| + |a_2 + b_1 - a_1 - b_2| \le |b_1 - b_2| + |a_2 + b_1 - a_1 - b_1| \Leftrightarrow |a_2 + b_1 - a_1 - b_2| \le |b_1 - b_2| + |a_2 - a_1|∣b
​1
​​ −b
​1
​​ ∣+∣a
​2
​​ +b
​1
​​ −a
​1
​​ −b
​2
​​ ∣≤∣b
​1
​​ −b
​2
​​ ∣+∣a
​2
​​ +b
​1
​​ −a
​1
​​ −b
​1
​​ ∣⇔∣a
​2
​​ +b
​1
​​ −a
​1
​​ −b
​2
​​ ∣≤∣b
​1
​​ −b
​2
​​ ∣+∣a
​2
​​ −a
​1
​​ ∣

Bất đẳng thức trên đúng vì |a| + |b| \ge |a+b|∣a∣+∣b∣≥∣a+b∣ với aa và bb là 22 số thực.

Từ bất đẳng thức trên, ta thấy rằng nếu giả sử trong 22 dãy aa và bb, tồn tại cặp vị trí (i, j)(i,j) sao cho i < ji<j và a_i \le a_ja
​i
​​ ≤a
​j
​​  nhưng b_i > b_jb
​i
​​ >b
​j
​​ , khi đó, theo bất đẳng thức ở trên, ta có:

|a_i - b_i| + |a_j - b_j| > |a_i - b_j| + |a_j - b_i|∣a
​i
​​ −b
​i
​​ ∣+∣a
​j
​​ −b
​j
​​ ∣>∣a
​i
​​ −b
​j
​​ ∣+∣a
​j
​​ −b
​i
​​ ∣ nên công việc ta cần làm là đổi chỗ 22 phần tử b_ib
​i
​​  và b_jb
​j
​​  lại. Thực hiện thao tác như thế cho đến khi không còn cặp (i, j)(i,j) nào sai vị trí nữa, ta sẽ được dãy aa và dãy bb được sắp xếp theo chiều không giảm. Áp dụng vào bài này, ta thấy rằng dãy aa đóng vai trò như dãy aa của đề bài nhập vào, còn dãy bb đóng vai trò như hoán vị của NN số được sắp xếp theo chiều tăng dần, tức b_i = ib
​i
​​ =i. Bài toán đã được chứng minh xong.

Độ phức tạp: {O}(N\log(N))O(Nlog(N)) với NN là số lượng phần tử trong dãy aa.

 */
public class ORANGE_L05P04 {

}
