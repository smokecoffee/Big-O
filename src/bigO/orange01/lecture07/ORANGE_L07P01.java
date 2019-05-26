package bigO.orange01.lecture07;
/*
 * Irreducible Basic Fractions
A fraction \frac{m}{n}
​n
​
​m
​​  is basic if 0 \le m < n0≤m<n and it is irreducible if gcd(m, n) = 1gcd(m,n)=1. Given a positive integer nn, in this problem you are required to find out the number of irreducible basic fractions with denominator nn.

For example, the set of all basic fractions with denominator 1212, before reduction to lowest terms, is

\frac{0}{12}, \frac{1}{12}, \frac{2}{12}, \frac{3}{12}, \frac{4}{12}, \frac{5}{12}, \frac{6}{12}, \frac{7}{12}, \frac{8}{12}, \frac{9}{12}, \frac{10}{12}, \frac{11}{12}
​12
​
​0
​​ ,
​12
​
​1
​​ ,
​12
​
​2
​​ ,
​12
​
​3
​​ ,
​12
​
​4
​​ ,
​12
​
​5
​​ ,
​12
​
​6
​​ ,
​12
​
​7
​​ ,
​12
​
​8
​​ ,
​12
​
​9
​​ ,
​12
​
​10
​​ ,
​12
​
​11
​​ 

Reduction yields

\frac{0}{1}, \frac{1}{12}, \frac{1}{6}, \frac{1}{4}, \frac{1}{3}, \frac{5}{12}, \frac{1}{2}, \frac{7}{12}, \frac{2}{3}, \frac{3}{4}, \frac{5}{6}, \frac{11}{12}
​1
​
​0
​​ ,
​12
​
​1
​​ ,
​6
​
​1
​​ ,
​4
​
​1
​​ ,
​3
​
​1
​​ ,
​12
​
​5
​​ ,
​2
​
​1
​​ ,
​12
​
​7
​​ ,
​3
​
​2
​​ ,
​4
​
​3
​​ ,
​6
​
​5
​​ ,
​12
​
​11
​​ 

Hence there are only the following 44 irreducible basic fractions with denominator 1212

\frac{1}{12}, \frac{5}{12}, \frac{7}{12}, \frac{11}{12}
​12
​
​1
​​ ,
​12
​
​5
​​ ,
​12
​
​7
​​ ,
​12
​
​11
​​ 

Input
Each line of the input contains a positive integer nn (n < 1000000000)(n<1000000000) and the input terminates with a value 00 for nn (do not process this terminating value).

Output
For each nn in the input print a line containing the number of irreducible basic fractions with denominator nn.

Ví dụ
input
12
123456
7654321
0
output
4
41088
7251444
Phân số \frac{m}{n}
​n
​
​m
​​  tối giản khi và chỉ khi gcd(m, n) = 1gcd(m,n)=1, khi đó mm và nn là nguyên tố cùng nhau. Vậy, để đếm số lượng phân số \frac{m}{n}
​n
​
​m
​​  cơ bản tối giản với 0 \le m < n0≤m<n, ta đếm số lượng số nguyên tố cùng nhau với nn mà nhỏ hơn nn, chính là kết quả của hàm phi Euler của nn.

Độ phức tạp: O(T * \sqrt{n})O(T∗√
​n
​
​​ ) với TT là số lượng test cases.

Mã nguồn tham khảo
#include <iostream>
using namespace std;

int eulerPhi(int n) {
    int result = n;

    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            while (n % i == 0) {
                n /= i;
            }
            result = result / i * (i - 1);
        }
    }

    if (n > 1) {
        result = result / n * (n - 1);
    }

    return result;
}

int main() {
    int n;
    while (cin >> n) {
        if (n == 0) {
            break;
        }
        cout << eulerPhi(n) << endl;
    }
    return 0;
}
 */
public class ORANGE_L07P01 {

	public static void main(String[] args) {

	}

}
