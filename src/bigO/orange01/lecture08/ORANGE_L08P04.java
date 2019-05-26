package bigO.orange01.lecture08;
/*
 * Polo the Penguin and the XOR
Polo, the Penguin, likes the XORXOR operation. Please read NOTE if you are not familiar with XORXOR operation.

XORXOR-sum of a list of numbers is the result of XORXOR-ing all of them. XORXOR-sum of (A_1 \oplus A_2 \oplus ... \oplus A_N)(A
​1
​​ ⊕A
​2
​​ ⊕...⊕A
​N
​​ ) is defined as A_1 \oplus (A_2 \oplus (A_3 \oplus (... \oplus A_N)))A
​1
​​ ⊕(A
​2
​​ ⊕(A
​3
​​ ⊕(...⊕A
​N
​​ )))

He has an array AA consisting of NN integers. Index in the array are numbered from 11 to NN, inclusive. Let us denote by F(L, R)F(L,R), the XORXOR-sum of all integers in the array AA whose indices lie from LL to RR, inclusive, i.e. F(L, R) = A_L \oplus A_{L+1} \oplus ... \oplus A_RF(L,R)=A
​L
​​ ⊕A
​L+1
​​ ⊕...⊕A
​R
​​ . Your task is to find the total sum of XORXOR-sums F(L, R)F(L,R) over all LL and RR, such that 1 \le L \le R \le N1≤L≤R≤N.

Input
The first line contains an integer TT denoting the number of test cases. The description of TT test cases follows. The first line of each test case contains a single integer NN denoting the size of AA. The second line contains NN space-separated integers A_1, A_2, ..., A_NA
​1
​​ ,A
​2
​​ ,...,A
​N
​​ .

Constraints:

1 \le T \le 100,0001≤T≤100,000
1 \le N \le 100,0001≤N≤100,000
0 \le A_i \le 1,000,000,000 (10^9)0≤A
​i
​​ ≤1,000,000,000(10
​9
​​ )
The total sum of all NN over all test cases will not exceed 100,000100,000.
Output
For each test case, output a single line containing the total sum to the corresponding test case.

Ví dụ
input
1
2
1 2
output
6
Giải thích
F(1, 1) = A_1 = 1F(1,1)=A
​1
​​ =1, F(2, 2) = A_2 = 2F(2,2)=A
​2
​​ =2 and F(1, 2) = A_1 \oplus A_2 = 1 \oplus 2 = 3F(1,2)=A
​1
​​ ⊕A
​2
​​ =1⊕2=3. Hence the answer is 1 + 2 + 3 = 61+2+3=6.
Cách làm đơn giản nhất là duyệt qua tất cả các cặp giá trị (L, R)(L,R), thực hiện phép XORXOR tất cả các phần tử từ A_LA
​L
​​  đến A_RA
​R
​​  rồi cộng vào kết quả. Cách làm này có độ phức tạp thời gian là O(n^3)O(n
​3
​​ ).

Ta có thể thực hiện phép XORXOR tất cả các phần tử từ A_LA
​L
​​  đến A_RA
​R
​​  nhanh hơn bằng cách áp dụng tính chất sau:

Cho P_i = A_1 \oplus A_2 \oplus ... \oplus A_i, P_i = 0P
​i
​​ =A
​1
​​ ⊕A
​2
​​ ⊕...⊕A
​i
​​ ,P
​i
​​ =0.
Ta có: A_L \oplus A_{L+1} \oplus .. A_R = P_R \oplus P_{L-1}A
​L
​​ ⊕A
​L+1
​​ ⊕..A
​R
​​ =P
​R
​​ ⊕P
​L−1
​​ 
Ta tính các giá trị P_iP
​i
​​  trước khi chọn ra từng cặp giá trị (L, R)(L,R). Với cải tiến này, độ phức tạp thời gian còn lại là O(n^2)O(n
​2
​​ ), nhưng vẫn là quá lớn đối với giới hạn dữ liệu là n \le 10^5n≤10
​5
​​ .

Gọi là S_RS
​R
​​  tổng các phép F(L, R)F(L,R) của tất cả các cặp (L, R)(L,R) với RR không thay đổi, (1 \le L \le R - 1)(1≤L≤R−1). S_R = (P_R \oplus P_1) + (P_R \oplus P_2) ... (P_R \oplus P_{R-1}) = \sum_{L = 0}^{R = 1} (P_R \oplus P_L)S
​R
​​ =(P
​R
​​ ⊕P
​1
​​ )+(P
​R
​​ ⊕P
​2
​​ )...(P
​R
​​ ⊕P
​R−1
​​ )=∑
​L=0
​R=1
​​ (P
​R
​​ ⊕P
​L
​​ )

Ta ký hiệu x_{(i)}x
​(i)
​​  là bit thứ ii của số nguyên khi viết dưới dạng nhị phân (ii tính từ 00 từ phải sang trái). Mỗi số nguyên xx đều có thể được viết dưới dạng: x = x_{(0)} \times 2^0 + x_{(1)} \times 2^1 + ...x=x
​(0)
​​ ×2
​0
​​ +x
​(1)
​​ ×2
​1
​​ +... . Mỗi bit có giá trị là 00 hoặc 11.

Khi ta cho thực hiện phép XORXOR giữa số xx và một số nguyên yy, ta có kết quả zz	là như sau: z = x \oplus y = ( x_{(0)} \oplus y_{(0)}) * 2^0 + ( x_{(1)} \oplus y_{(1)}) * 2^1 + ...z=x⊕y=(x
​(0)
​​ ⊕y
​(0)
​​ )∗2
​0
​​ +(x
​(1)
​​ ⊕y
​(1)
​​ )∗2
​1
​​ +...
Như vậy, mỗi bit x_{(j)}x
​(j)
​​  có thể được giữ nguyên hoặc thay đổi (00 thành 11 hoặc 11 thành 00) tuỳ vào bit y_{(j)}y
​(j)
​​  tương ứng.

Quay lại với tổng S_RS
​R
​​ , ta nhận thấy: mỗi bit P_{R_(i)}P
​R
​(
​​ i)
​​  "tương tác" XORXOR với RR bit P_{L_(i)}P
​L
​(
​​ i)
​​  tương ứng (1 \le L \le R - 1 )(1≤L≤R−1).
Nếu P_{R_(i)} = 1P
​R
​(
​​ i)
​​ =1, các bit P_{L_(i)}P
​L
​(
​​ i)
​​  tương ứng có giá trị là 11 bị đổi thành 00 còn các bit tương ứng có giá trị là 00 bị đổi thành 11.
Nếu P_{R_(i)} = 0P
​R
​(
​​ i)
​​ =0, các bit P_{L_(i)}P
​L
​(
​​ i)
​​  tương ứng không bị thay đổi giá trị.
Gọi jj là vị trí mà P_{R_(i)} = 1P
​R
​(
​​ i)
​​ =1, là số lượng bit ở vị trí ii có giá trị là 11 trong tất cả các số P_{L_(i)}, 1 \le L \le R-1P
​L
​(
​​ i)
​​ ,1≤L≤R−1.
Như vậy, ta có:
S_R = \sum_{i} (m_i * 2^i)S
​R
​​ =∑
​i
​​ (m
​i
​​ ∗2
​i
​​ ) Trong đó: Nếu P_{R_(i)} = 0 : m_i = q_iP
​R
​(
​​ i)
​​ =0:m
​i
​​ =q
​i
​​ , với mm là số bit ở vị trí ii có giá trị là 11 trước và sau "tương tác" XORXOR.

Nếu P_{R_(i)} = 1 : m_i = R - q_iP
​R
​(
​​ i)
​​ =1:m
​i
​​ =R−q
​i
​​  , với là số bit ở vị trí ii có giá trị là 00 trước “tương tác” và là 11 sau “tương tác”.

Nói cách khác, công thức S_RS
​R
​​  trên cho ta thấy rằng, kết quả của S_RS
​R
​​  phụ thuộc vào số lượng và vị trí các bit có giá trị là 11 sau khi thực hiện phép XORXOR. Như vậy, để tính S_RS
​R
​​ , ta tạo một mảng q[0..31]q[0..31], mỗi phần tử q_jq
​j
​​  lưu số lượng bit có giá trị là 11 ở vị trí jj của các số từ P_1P
​1
​​  đến P_{R-1}P
​R−1
​​ . Ở mỗi bước duyệt đến một giá trị RR, ta cập nhật qq theo P_{R - 1}P
​R−1
​​  và sử dụng qq để tính S_RS
​R
​​ . Kích thước mảng qq là 3232 vì số nguyên của mảng không vượt quá 3232 bit, đồng nghĩa với việc XORXOR của chúng không vượt quá 3232 bit.

Độ phức tạp: O(N)O(N) với NN là số phần tử của mảng AA.

 */
public class ORANGE_L08P04 {

}
