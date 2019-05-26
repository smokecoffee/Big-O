package bigO.orange01.lecture06;
/*
 * Ones
Given any integer 0 \le n \le 100000≤n≤10000 not divisible by 22 or 55, some multiple of nn is a number which in decimal notation is a sequence of 11’s. How many digits are in the smallest such a multiple of nn?

Input
A file of integers at one integer per line.

Output
Each output line gives the smallest integer x > 0x>0 such that \sum_{i = 0}^{x - 1} 1 * 10^i = a \times b∑
​i=0
​x−1
​​ 1∗10
​i
​​ =a×b, where aa is the corresponding input integer, and bb is an integer greater than zero.

Ví dụ
input
3
7
9901
output
3
6
12
Giải thích ví dụ:

Ví dụ 1:

Ở bộ dữ liệu đầu tiên, ta có 111111 là bội nhỏ nhất chứa toàn chữ số 11 của 33. Vì 111111 có 33 chữ số nên ta sẽ ghi ra 33.

Ví dụ 2

Ở bộ dữ liệu thứ hai, 111111111111 là bội nhỏ nhất chứa toàn chữ số 11 của 77 bao gồm 66 chữ số nên ta ghi ra 66.

Hướng dẫn giải:

Để bắt đầu với bài này, một cách giải đơn giản là ta cứ thêm một số 11 vào cuối số của mình và kiểm tra xem số đó có chia hết cho nn hay không:

b = b \times 10 + 1b=b×10+1

Tuy nhiên, đến một lúc nào đó khi số quá lớn, lớn hơn cả giá trị tối đa của kiểu số nguyên 6464 bit thì ta sẽ bị tràn số. Lúc này, áp dụng tính chất nhân và cộng của phép modulo, ta có thể đưa ra một cách tăng giá trị ước “giả định” của chúng ta như sau:

b = (b \times 10 + 1) \% nb=(b×10+1)%n

Như thế này ta sẽ không phải lo về chuyện tràn số nữa vì giới hạn của nn là khá nhỏ chỉ với 1000010000.

Tóm lại, ta chỉ cần một vòng lặp để tăng ước “giả định” của chúng ta lên, áp dụng công thức tính được chỉnh sửa như trên đến khi b = 0b=0 hay nói cách khác là chia hết cho nn.

Độ phức tạp: Độ phức tạp mỗi bộ dữ liệu là O(x)O(x) với xx là số lượng chữ số trong kết quả, có thể nhỏ hơn vì vòng lặp sẽ kết thúc sớm hơn khi tìm được đã tìm ra kết quả.

Mã nguồn tham khảo
#include <iostream>
using namespace std;
 
int n;
 
int main() {
    while (cin >> n) {
        int b = 1;
        int cnt = 1;
        while (b % n != 0) {
            b = b * 10 + 1;
            b %= n;
            cnt++;
        }
        cout << cnt << endl;
    }
    return 0;
}
-----------
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int b = 1;
            int cnt = 1;
            while (b % n != 0) {
                b = b * 10 +1;
                b %= n;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
------------
if __name__ == '__main__':
    while(True):
        try:
            n = int(input())
        except EOFError:
            import sys
            sys.exit()
        b = 1
        cnt = 1
        while b % n != 0:
            b = b *10 + 1
            b %= n
            cnt += 1
        print(cnt)
 */
public class ORANGE_L06P04 {

}
