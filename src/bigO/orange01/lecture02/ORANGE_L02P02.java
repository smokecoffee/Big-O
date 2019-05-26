package bigO.orange01.lecture02;

/**
 * @author ThinkPad-PC
 *Mattey Multiplication
Mattey has an assignment that he should submit tomorrow. The assignment has one question which asks to write a program to multiply two numbers without using *∗ operator. As Mattey finds no interest in this subject, he never listens to classes and so do not know about shift operators.

He comes to you to learn about this topic. You can explain in any manner you wish. But for this question, given NN and MM, write an equation using left shift operators whose result will be equal to the product N * MN∗M.

Input
The first line has TT denoting number of test cases.

Next TT lines has two integers NN, MM.

Output
For each test case print an equation resembling (N<<p1) + (N<<p2) + ... + (N<<pk) where p_1 \ge p_2 \ge ... \ge p_kp
​1
​​ ≥p
​2
​​ ≥...≥p
​k
​​  and kk is minimum.

CONTRAINTS:

1 \le T \le 5 \cdot 10^41≤T≤5⋅10
​4
​​ 
1 \le N, M \le 10^{16}1≤N,M≤10
​16
​​ 
Ví dụ
input
2
2 1
2 3
output
(2<<0)
(2<<1) + (2<<0)
---------------------
Nhận xét:

Theo yêu cầu của đề bài, ta cần biểu diễn:

N * MN∗M

= (N << p_1) + (N << p_2) + (N << p_3) + ... + (N << p_k)=(N<<p
​1
​​ )+(N<<p
​2
​​ )+(N<<p
​3
​​ )+...+(N<<p
​k
​​ )

= (N * 2^{p_1}) + (N * 2^{p_2}) + (N * 2^{p_3}) + ... (N * 2^{p_k})=(N∗2
​p
​1
​​ 
​​ )+(N∗2
​p
​2
​​ 
​​ )+(N∗2
​p
​3
​​ 
​​ )+...(N∗2
​p
​k
​​ 
​​ ) (phép dịch trái p_ip
​i
​​  tương đương với phép nhân 2^{p_i}2
​p
​i
​​ 
​​ )

= N * (2^{p_1} + 2^{p_2} + 2^{p_3}+ ... + 2^{p_k})=N∗(2
​p
​1
​​ 
​​ +2
​p
​2
​​ 
​​ +2
​p
​3
​​ 
​​ +...+2
​p
​k
​​ 
​​ )

Suy ra M = 2^{p_1} + 2^{p_2} + 2^{p_3}+ ... + 2^{p_k}M=2
​p
​1
​​ 
​​ +2
​p
​2
​​ 
​​ +2
​p
​3
​​ 
​​ +...+2
​p
​k
​​ 
​​ . Nói cách khác, p_1, p_2, p_3, ..., p_kp
​1
​​ ,p
​2
​​ ,p
​3
​​ ,...,p
​k
​​  chính là những vị trí của bit 11 trong MM.

Từ đây, ta thấy chỉ cần chuyển số MM về hệ nhị phân và lần lượt duyệt qua các bit của MM, bit ở vị trí thứ ii nào bằng 11 sẽ tương ứng với một phép dịch trái p_ip
​i
​​ .

Độ phức tạp: O(T * log(M))O(T∗log(M)) với TT là số lượng bộ test.

O(log(M))O(log(M)) là thời gian tìm vị trí của tất cả các bit 11 trong MM.
Mã nguồn tham khảo
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int t;
    long long n, m;
    vector<int> pos_one;
    cin >> t;

    for (int tc = 0; tc < t; tc++) {
        cin >> n >> m;
        
        int i = 0;
        while (m != 0) {
            if (m & 1) {
                pos_one.push_back(i);
            }
            m >>= 1;
            i++;
        }

        for (int i = pos_one.size() - 1; i >= 0; i--) {
            if (i != pos_one.size() - 1) {
                cout << " + ";
            }
            cout << "(" << n << "<<" << pos_one[i] << ")";
        }
        cout << endl;
        pos_one.clear();
    }

    return 0;
}
------python
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    pos_one = []
    i = 0

    while m != 0:
        if m & 1:
            pos_one.append(i)
        m >>= 1
        i += 1
    
    print(' + '.join('({}<<{})'.format(n, pos) for pos in reversed(pos_one)))
    
---------java8
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long n, m;
        
        for (int tc = 0; tc < t; tc++) {
            ArrayList<Integer> pos_one = new ArrayList<Integer>();
            n = sc.nextLong(); m = sc.nextLong();
            int i = 0;

            while (m != 0) {
                if ((m & 1L) == 1) {
                    pos_one.add(i);
                }
                m >>= 1;
                i++;
            }

            for (i = pos_one.size() - 1; i >= 0; i--) {
                if (i != pos_one.size() - 1) {
                    System.out.print(" + ");
                }
                System.out.printf("(%d<<%d)", n, pos_one.get(i));
            }
            System.out.println();
        }
    }
}

 */
public class ORANGE_L02P02 {

}
