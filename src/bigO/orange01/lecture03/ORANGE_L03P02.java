package bigO.orange01.lecture03;

/**
 * @author ThinkPad-PC
 *The Hamming Distance Problem
The Hamming distance between two strings of bits (binary integers) is the number of corresponding bit positions that differ. This can be found by using XORXOR on corresponding bits or equivalently, by adding corresponding bits (base 22) without a carry. For example, in the two bit strings that follow

A	0	1	0	0	1	0	1	0	0	0
B	1	1	0	1	0	1	0	1	0	0
A XOR B	1	0	0	1	1	1	1	1	0	0
The Hamming distance (H)(H) between these 1010-bit strings is 66, the number of 11's in the XORXOR string.

Input
Input consists of several datasets.

The first line of the input contains the number of datasets, and it's followed by a blank line.

Each dataset contains NN, the length of the bit strings and HH, the Hamming distance, on the same line. There is a blank line between test cases.

Output
For each dataset print a list of all possible bit strings of length NN that are Hamming distance HH from the bit string containing all 0's (origin). That is, all bit strings of length NN with exactly HH 1's printed in ascending lexicographical order.

The number of such bit strings is equal to the combinatorial symbol C(N, H)C(N,H). This is the number of possible combinations of N - HN−H zeros and HH ones. It is equal to

\frac{N!}{(N - H)! H!}
​(N−H)!H!
​
​N!
​​ 

This number can be very large. The program should work for 1 \le H \le N \le 161≤H≤N≤16.

Print a blank line between datasets.

Ví dụ
input
1

4 2
output
0011
0101
0110
1001
1010
1100

---------
Ý tưởng: Dùng kỹ thuật backtracking để phát sinh tất cả các tổ hợp chập HH bit 11 của dãy NN bit.

Tuy nhiên, ta thấy rằng nếu phát sinh các bit 11 thì rất khó để đảm bảo thứ tự phát sinh tăng dần. Ví dụ: Phát sinh tổ hợp chập 22 bit 11 của dãy 44 bit. Khi ta cố gắng phát sinh bit 11 theo hướng "tiến lên", ta thu được các dãy bit theo thứ tự như sau:

1100
1010
1001
0110
0101
0011
Thế nhưng ta lại nhận thấy từ ví dụ trên, thay vì cho bit 11 "tiến lên", ta cho bit 00 "tiến lên" thì kết quả thu được là:

0011
0101
0110
1001
1010
1100
Đây chính là kết quả mà ta mong đợi. Nói cách khác, khi bit 00 càng "tiến lên" thì dãy bit thu được có giá trị càng tăng. Như vậy, ta cần phải phát sinh tất cả các tổ hợp chập N - HN−H bit 00 của dãy NN bit.

Gọi resres là dãy bit ban đầu gồm NN bit 11. Cấu trúc của hàm backtracking, tạm gọi là hàm permutation(i, p, n, k) với i là vị trí của bit cần phát sinh trong mảng resres, bit 00 được phát sinh sẽ nằm từ vị trí p trở về sau (vị trí được đánh số từ 00), n là độ dài của dãy bit, k là số lượng bit 00 cần phát sinh, được viết dưới dạng mã giả như sau:

func permutation(i, p, n, k):
    if i == k:					# Nếu đã phát sinh đủ k phần tử thì in ra màn hình   
        print res[]
        return
            
    for j: p -> (n - 1):
        res[j] = 0				# Lần lượt cố định giá trị của res bằng 0 tại vị trí từ p về sau 
        permutation(i + 1, j + 1, n, k)		# Bit 0 tiếp theo sẽ nằm từ vị trí (j + 1) trở về sau
        res[j] = 1				# Quay lui, gán lại giá trị của res bằng 1        
Độ phức tạp: O(T * C_N^{N - H})O(T∗C
​N
​N−H
​​ ) với TT là số lượng bộ test, NN là độ dài của dãy bit, HH là số bit 11 cần có trong dãy.

Mã nguồn tham khảo
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[] res = new int[20];

    static void permutation(int i, int p, int n, int k) {
        if (i == k) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[j]);
            }
            System.out.println();
            return;
        }

        for (int j = p; j < n; j++) {
            res[j] = 0;
            permutation(i + 1, j + 1, n, k);
            res[j] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean blank_line = false;

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(), h = sc.nextInt();
            if (blank_line) {
                System.out.println();
            }

            Arrays.fill(res, 1);
            permutation(0, 0, n, n - h);
            blank_line = true;
        }
    }
}
-------python3
def permutation(i, p, n, k):
    global res
    if i == k:
        print(*res)
        return

    for j in range(p, n):
        res[j] = 0
        permutation(i + 1, j + 1, n, k)
        res[j] = 1

t = int(input())
blank_line = False

for _ in range(t):
    input()
    n, h = map(int, input().split())
    if blank_line:
        print()

    res = [1] * n
    permutation(0, 0, n, n - h)
    blank_line = True
    
-------cpp14
#include <iostream>
using namespace std;
const int MAX = 20;
int res[MAX];

void permutation(int i, int p, int n, int k) {
    if (i == k) {
        for (int j = 0; j < n; j++) {
            cout << res[j];
        }
        cout << endl;
        return;
    }

    for (int j = p; j < n; j++) {
        res[j] = 0;
        permutation(i + 1, j + 1, n, k);
        res[j] = 1;
    }
}

int main() {
    int t, n, h;
    bool blank_line = false;
    cin >> t;

    for (int tc = 0; tc < t; tc++) {
        cin >> n >> h;
        if (blank_line) {
            cout << endl;
        }

        fill(res, res + sizeof(res), 1);
        permutation(0, 0, n, n - h);
        blank_line = true;
    }
    return 0;
}

 */
public class ORANGE_L03P02 {

}
