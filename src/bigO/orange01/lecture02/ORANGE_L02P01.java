package bigO.orange01.lecture02;

/**
 * @author ThinkPad-PC
 *
 *AISH AND XOR
“…I always wanted to become an architect, but I’m not very good at math.”

Aishwarya was saying this to her friend Puper. Puper motivated her for screwing up the things related to math and said he will also help her if needed.

Being motivated, she started up practicing hard problems of maths and she got stuck in a problem and asked for help from Puper. She is playing with XOR, given an array (containing only 00 and 11) as element of NN length.

Given LL and RR, she wants to know the value of XOR of all elements from LL to RR (both inclusive) and number of unset bits (00's) in the given range of the array.

Being new she finds it tough so she asked for help from Puper. Puper also finds it tough and confusing. So he asked for your help.

Input
The first line contains the number NN.

The second line contains NN numbers containing 00 and 11 only.

The third line contains number of query QQ.

The next QQ lines contains LL and RR.

Output
For each query print the XOR value and number of unset bits in that range.

CONSTRAINTS:

1 \le N \le 1000001≤N≤100000 (11-based indexing of elements)
1 \le Q \le N1≤Q≤N
1 \le L \le R \le 1000001≤L≤R≤100000
0 \le R - L \le 1000000≤R−L≤100000
Ví dụ
input
5
1 0 0 0 1
3
2 4
1 5
3 5

output
0 3
0 3
1 2
------Giải thích
In the given case the bit sequence is of length 55 and the sequence is 1 0 0 0 110001.
For query 11 the range is 22 44, and the answer is (array_2 \oplus array_3 \oplus array_4array​2​​ ⊕array​3​​ ⊕array​4​​ ) = 0=0, and number of zeroes are 33, so output is 00 33. Similarly for other queries.


Nhận xét:

Ta biết rằng cứ hai bit 11 XOR với nhau sẽ được bit 00 và bit 00 khi XOR với một bit AA bất kỳ đều trả về AA (AA \oplus⊕ 00 = AA). Do đó, ta chỉ cần đếm số lượng bit 11 trong đoạn [L, R][L,R]: nếu số lượng bit 11 là chẵn thì kết quả phép XOR là 00 và ngược lại, kết quả là 11. Số lượng bit 00 lúc này sẽ bằng RR – (L - 1)(L−1) + số lượng bit 11.

Tuy nhiên, thay vì với mỗi truy vấn ta đều phải duyệt từ vị trí LL đến RR để đếm số lượng chữ số 11 trong đoạn, ta có thể sử dụng một mảng tiền tố D để tăng tốc độ tính toán. Trong đó, D[i] là số lượng chữ số 11 tính từ vị trí bắt đầu đến vị trí ii (mảng đánh số từ 11).

Ví dụ: Mảng A = [1, 1, 0, 1, 0, 0] thì ta có mảng tiền tố D tương ứng là D = [1, 2, 2, 3, 3, 3].

Lúc này, số lượng chữ số 1 thuộc trong đoạn [L, R][L,R] chính bằng D[R] - D[L - 1]. Từ đây ta có thể tính được các kết quả của bài toán.

Độ phức tạp: O(N + Q)O(N+Q) với NN là số lượng phần tử trong mảng, QQ là số lượng truy vấn.

O(1)O(1) cho mỗi truy vấn.
O(N)O(N) cho việc xây dựng mảng D.
Mã nguồn tham khảo
#include <iostream>
using namespace std;
const int MAX = 100000 + 5;

int main() {
    int n, q, l, r;
    int a[MAX], d[MAX] = {0};
    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        d[i] = d[i - 1] + a[i];
    }

    cin >> q;
    for (int i = 0; i < q; i++) {
        cin >> l >> r;
        int n_ones = d[r] - d[l - 1];
        int n_zeroes = r - (l - 1) - n_ones;
        cout << (n_ones % 2) << " " << n_zeroes << endl;
    }

    return 0;
}
----------
n = int(input())
a = [0] + list(map(int, input().split()))
d = [0] * (n + 1)

for i in range(1, n + 1):
    d[i] = d[i - 1] + a[i]

q = int(input())
for _ in range(q):
    l, r = map(int, input().split())
    n_ones = d[r] - d[l - 1]
    n_zeroes = r - (l - 1) - n_ones
    print(n_ones % 2, n_zeroes)
    
-----------java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1], d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            d[i] = d[i - 1] + a[i];
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            int n_ones = d[r] - d[l - 1];
            int n_zeroes = r - (l - 1) - n_ones;
            System.out.printf("%d %d\n", n_ones % 2, n_zeroes);
        }
    }
}
 */
public class ORANGE_L02P01 {

}
