package bigO.orange01.lecture05;
/*
 * Petya and Catacombs
A very brave explorer Petya once decided to explore Paris catacombs. Since Petya is not really experienced, his exploration is just walking through the catacombs.

Catacombs consist of several rooms and bidirectional passages between some pairs of them. Some passages can connect a room to itself and since the passages are built on different depths they do not intersect each other. Every minute Petya arbitrary chooses a passage from the room he is currently in and then reaches the room on the other end of the passage in exactly one minute. When he enters a room at minute ii, he makes a note in his logbook with number t_it
​i
​​ :

If Petya has visited this room before, he writes down the minute he was in this room last time;
Otherwise, Petya writes down an arbitrary non-negative integer strictly less than current minute ii.
Initially, Petya was in one of the rooms at minute 00, he didn't write down number t_0t
​0
​​ . At some point during his wandering Petya got tired, threw out his logbook and went home. Vasya found his logbook and now he is curious: what is the minimum possible number of rooms in Paris catacombs according to Petya's logbook?

Input
The first line contains a single integer nn (1 \le n \le 2 * 10^5)(1≤n≤2∗10
​5
​​ ) — the number of notes in Petya's logbook.

The second line contains nn non-negative integers t_1t
​1
​​ , t_2t
​2
​​ , ..., t_nt
​n
​​  (0 \le t_i < i)(0≤t
​i
​​ <i) — notes in the logbook.

Output
In the only line print a single integer — the minimum possible number of rooms in Paris catacombs

Ví dụ
input
2
0 0
output
2
input
5
0 1 0 1 3
output
3
-----------
Giải thích
In the first sample, sequence of rooms Petya visited could be, for example 1 \rightarrow 1 \rightarrow 21→1→2, 1 \rightarrow 2 \rightarrow 11→2→1 or 1 \rightarrow 2 \rightarrow 31→2→3. The minimum possible number of rooms is 22.

In the second sample, the sequence could be 1 \rightarrow 2 \rightarrow 3 \rightarrow 1 \rightarrow 2 \rightarrow 11→2→3→1→2→1.

----Huong dan giai----------
Ở bài này, đề yêu cầu tìm số phòng ít nhất có thể. Ta dễ dàng thấy được căn phòng số 11 sẽ luôn luôn phải đi qua, nhiệm vụ của chúng ta là tìm những căn phòng còn lại. Rõ ràng số phòng đó là tổng số lượng các phút không được ghi nhận lại tính từ phút thứ 00 đến phút thứ n - 1n−1.

Bước 1: Đọc dữ liệu vào, đồng thời dùng một mảng để đánh dấu các phút đã được ghi lại.
Bước 2: Khởi tạo biến count = 1=1 tương ứng với phòng số một chắc chắn được chọn.
Bước 3: Duyệt từ 00 đến n – 1, kiểm tra phút nào chưa được đánh dấu thì tăng count lên 11.
Bước 4: In count là kết quả cần tìm.
Độ phức tạp: O(n)O(n) với nn là số lượng ghi chú.
 */
public class ORANGE_L05P05 {

}
