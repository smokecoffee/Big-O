package bigO.orange01.lecture06;
/*
 * Boxes of Chocolates
Little PippyPippy has got a lot of chocolates on her 6^{th}6
​th
​​  birthday. She is a very good and charming girl and always shares his belongings with her friends (and she has lots of friends). Now she wants to share all the chocolate with her friends. She will try her best to give all her friend equal number of chocolates but in case she fails, she will give her pet cat KittuKittu the residue number of chocolates. The chocolates she has got are in boxes wrapped with beautiful papers. Sometimes a box do not contain chocolates but have smaller boxes inside them. Even sometimes the smaller boxes do not contain any chocolates but have further smaller boxes inside them. Only the smallest boxes always contain some chocolates.

Input
Input will start with an integer TT. Following lines will contain descriptions for TT test cases.

First line of each test case will contain two integers NN and BB indicating the number of friends PippyPippy has and the number of box of chocolates she has got respectively.

Each of the next BB lines will contain a description of a single box. These lines will start with an integer KK followed by KK integers identified as a_1, a_2, a_3, ...,a_ka
​1
​​ ,a
​2
​​ ,a
​3
​​ ,...,a
​k
​​ . Here a_ia
​i
​​  indicates the number of boxes the i^{th}i
​th
​​  box contains within it where (0 < i < K)(0<i<K). The last number of the line indicates the number of chocolates contained in each of the smallest box.

All the numbers will be positive and T, B, KT,B,K will be less than 101101 and NN, a_ia
​i
​​  will be less than 1000110001.

Output
For each test case, print an integer on a single line indicating the number of extra chocolates KittuKittu will get after dividing all of them equally among PippyPippy’s friends.

Ví dụ
input
2
5 2
3 2 3 4
4 5 2 3 1
6 1
4 5 6 7 8
output
output
4
0
Giải thích ví dụ:

Hình ảnh ví dụ minh họa hộp quà thứ nhất:

Số bạn của Pippy là N = 5N=5, số hộp quà mà Pippy có được là B = 2B=2.

Hộp quà thứ nhất có 22 hộp quà nhỏ bên trong. 22 hộp quà nhỏ bên trong, mỗi hộp có 33 hộp nhỏ bên trong nữa. Mỗi hộp nhỏ này có 44 viên kẹo.
\to→ Hộp quà thứ nhất có 2 \times 3 \times 4 = 242×3×4=24 viên kẹo
Tương tự hộp quà nhỏ thứ hai có 5 \times 2 \times 3 \times 1 = 305×2×3×1=30 viên kẹo. Vậy Pippy có tổng cộng 24 + 30 = 5424+30=54 viên kẹo. Mang chia đều cho 55 bạn, mỗi bạn sẽ được 5 / 45 = 105/45=10, dư 44.
Hướng dẫn giải:

Để tìm được số kẹo còn dư, trước tiên ta phải tìm được tổng số viên kẹo ở tất cả các hộp, sau đó thực hiện phép modulo cho NN - số lượng bạn bè.

Trong đó, tổng số viên kẹo trong một hộp chính là tích của dãy số a_1, a_2, ...,a_ka
​1
​​ ,a
​2
​​ ,...,a
​k
​​ . Tuy nhiên với trường hợp K = 100K=100 và a_i = 10000a
​i
​​ =10000 với mọi (0 < i \leq K)(0<i≤K) thì tổng số lượng kẹo thu được ở mỗi hộp là 10000^{100}10000
​100
​​  - là một số rất lớn, dẫn đến tràn số. Để giải vấn đề này, ta áp dụng hai tính chất của phép modulo:

(a \times b) \% m = ((a \% m) * (b \% m)) \% m(a×b)%m=((a%m)∗(b%m))%m
(a + b) \% m = ((a \% m) + (b \% m)) \% m(a+b)%m=((a%m)+(b%m))%m
Độ phức tạp: O(T * B * K)O(T∗B∗K) Với TT là số lượng test, BB là số hộp quà PippyPippy nhận được, và KK là số hộp quà mà hộp quà thứ ii chứa bên trong.

 */
public class ORANGE_L06P02 {

}
