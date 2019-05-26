package bigO.orange01.lecture06;
/*
 * Play with Floor and Ceil
TheoremTheorem : for any two integers xx and kk there exists two more integers pp and qq such that: x = p\left \lfloor \frac{x}{k} \right \rfloor + q\left \lceil \frac{x}{k} \right \rceilx=p⌊
​k
​
​x
​​ ⌋+q⌈
​k
​
​x
​​ ⌉

It’s a fairly easy task to prove this theorem, so we’d not ask you to do that. We’d ask for something even easier! Given the values of xx and kk, you’d only need to ﬁnd integers pp and qq that satisﬁes the given equation.

Input
The ﬁrst line of the input contains an integer, T (1 \le T \le 1000)T(1≤T≤1000) that gives you the number of test cases. In each of the following TT lines youd be given two positive integers xx and kk. You can safely assume that xx and kk will always be less than 10^810
​8
​​ .

Output
For each of the test cases print two integers: pp and qq in one line. These two integers are to be separated by a single space. If there are multiple pairs of pp and qq that satisfy the equation, any one would do. But to help us keep our task simple, please make sure that the values, p\left \lfloor \frac{x}{k} \right \rfloorp⌊
​k
​
​x
​​ ⌋ and q\left \lceil \frac{x}{k} \right \rceilq⌈
​k
​
​x
​​ ⌉ ﬁt in a 6464 bit signed integer.

Ví dụ
input
3
5 2
40 2
24444 6
output
1 1 
1 1 
0 6
Giải thích ví dụ:

Trước hết bạn đọc cần phải hiểu 2 ký hiệu toán học \left \lfloor x \right \rfloor⌊x⌋ và \left \lceil x \right \rceil⌈x⌉.
Ký hiệu đầu tiên trả về số nguyên lớn nhất nhỏ hơn hoặc bằng xx.
Ký hiệu thứ hai trả về số nguyên nhỏ nhất lớn hơn hoặc bằng xx.
Ví dụ:\left \lfloor 2 \times 4 \right \rfloor = 2⌊2×4⌋=2 và \left \lceil 2 \times 4 \right \rceil = 8⌈2×4⌉=8.
Từ đó, nếu xx là số nguyên, ta có: x = \left \lfloor x \right \rfloor = \left \lceil x \right \rceilx=⌊x⌋=⌈x⌉.

Ví dụ 1

Với test ví dụ đầu tiên, x = 5x=5 và k = 2k=2, ta có: \left \lfloor \frac{5}{2} \right \rfloor = 2⌊
​2
​
​5
​​ ⌋=2 và \left \lceil \frac{5}{2} \right \rceil = 3⌈
​2
​
​5
​​ ⌉=3. Do đó, (p, q) = (1, 1)(p,q)=(1,1) là 11 nghiệm thỏa mãn vì 5 = 1 \times 2 + 1 \times 35=1×2+1×3.

Hướng dẫn giải:

Ta thấy rằng phương trình của ta là phương trình diophantie ax + by = cax+by=c, với hệ số a, b, ca,b,c lần lượt là \left \lfloor \frac{x}{k} \right \rfloor, \left \lceil \frac{x}{k} \right \rceil, x⌊
​k
​
​x
​​ ⌋,⌈
​k
​
​x
​​ ⌉,x, còn xx và yy tương ứng là pp và qq.

Trước hết, phương trình diophante này bảo đảm luôn có nghiệm, vì ta nhận thấy như sau:

Nếu xx chia hết cho kk, thì \frac{x}{k}
​k
​
​x
​​  chắc chắn là số nguyên, ta thay q = 0, p = kq=0,p=k là đã có ngay một bộ nghiệm nếu xx chia hết cho kk.
Nếu xx không chia hết cho kk, đặt a = \left \lfloor \frac{x}{k} \right \rfloora=⌊
​k
​
​x
​​ ⌋, dễ dàng nhận thấy \left \lceil \frac{x}{k} \right \rceil = a + 1⌈
​k
​
​x
​​ ⌉=a+1, mặt khác, ta lại có xx và kk cùng là số nguyên dương, do đó sẽ không có trường hợp \frac{x}{k} = 0
​k
​
​x
​​ =0 được. Từ đó, với a > 0a>0, ta thấy gcd(a, a + 1) = 1gcd(a,a+1)=1 và xx nguyên dương nên chắc chắn xx chia hết cho 11. Do đó, phương trình đề bài cho ta luôn có nghiệm.
Ta sử dụng thuật toán Euclide mở rộng để giải. Big-O Coding sẽ không hướng dẫn chi tiết thuật toán này vì nó đã được hướng dẫn trong slide bài giảng, bạn đọc có thể đọc slide kết hợp cùng với đọc source code của Big-O Coding.
Độ phức tạp: O(Log(a))O(Log(a)) với a = \left \lfloor \frac{x}{k} \right \rfloora=⌊
​k
​
​x
​​ ⌋.

Bổ sung:

Nếu bạn đọc không thích việc làm theo khuôn khổ, tức là nếu bài này là một bài phương trình diophiante thì buộc phải sử dụng thuật Euclide mở rộng để tìm lời giải. Bạn đọc muốn tìm một lời giải khác mà không cần sử dụng thuật Euclide để tìm lời giải thì ta vẫn còn một cách tiếp cận trong O(1)O(1).
Theo nhận xét ở lời giải trên, nếu xx chia hết cho kk, lời giải q = 0, p = kq=0,p=k vẫn được giữ nguyên.
Trong trường hợp xx không chia hết cho kk, bạn đọc đặt a = \left \lfloor \frac{x}{k} \right \rfloora=⌊
​k
​
​x
​​ ⌋, ta sẽ đưa được phương trình trên về dạng: x = p * a + q*(a + 1) \Leftrightarrow x - q = a * (p + q).x=p∗a+q∗(a+1)⇔x−q=a∗(p+q).
Do đó, để đảm bảo pp và qq phải là số nguyên, thì vế trái phải chia hết cho aa. Do đó, ta sẽ tìm qq sao cho x - q = a \Leftrightarrow q = x - a.x−q=a⇔q=x−a.
Khi có x - q = ax−q=a, ta chia hai vế cho aa. Ta được p + q = 1 \Leftrightarrow p = 1 - q = 1 - (x - a) = a - x + 1.p+q=1⇔p=1−q=1−(x−a)=a−x+1. Như vậy, với trường hợp xx không chia hết cho kk, thì ta gán kết quả là p = a - x + 1p=a−x+1 và q = x - a.q=x−a.
 
 *
 
 *import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static long[] extendedEuclid(long a, long b) {
		long x, y;
		if (a == 0) {
			x = 0;
			y = 1;
			return new long[] {b, x, y};
		}

		long[] temp = extendedEuclid(b % a, a);
		x = temp[2] - (b / a) * temp[1];
		y = temp[1];
		return new long[] {temp[0], x, y};
	}

	public static void main(String[] args) {
		int T;
		long x, k;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tt = 1; tt <= T; tt++) {
			x = sc.nextInt();
			k = sc.nextInt();

			long p, q;
			long r = x % k;
			if (r == 0) {
				p = k;
				q = 0;
			}
			else {
				long a = x / k;
				long b = a + 1;
				long x0, y0;
				long[] temp = extendedEuclid(Math.abs(a), Math.abs(b));
				long g = temp[0];
				x0 = temp[1];
				y0 = temp[2];
				x0 *= x / g;
				y0 *= x / g;
				if (a < 0) {
					x0 = -x0;
				}

				if (b < 0) {
					y0 = -y0;
				}

				p = x0;
				q = y0;
			}

			System.out.printf("%d %d\n", p, q);
		}
	}
}

def extendedEuclid(a, b):
    global X, Y
    if a == 0:
        X, Y = 0, 1
        return [b, X, Y]

    temp = extendedEuclid(b % a, a)
    X = temp[2] - (b // a) * temp[1]
    Y = temp[1]
    return [temp[0], X, Y]

if __name__ == '__main__':
    T = int(input())
    for tt in range(T):
        x, k = map(int, input().split())
        p, q = 0, 0
        r = x % k
        if r == 0:
            p, q = k, 0
        else:
            a = x // k
            b = a + 1
            temp = extendedEuclid(abs(a), abs(b))
            g = temp[0]
            x0 = temp[1]
            y0 = temp[2]
            x0 *= x // g
            y0 *= x // g
            if a < 0:
                x0 = -x0

            if b < 0:
                y0 = -y0

            p, q = x0, y0
        print(p, q)
        
#include <bits/stdc++.h> 

using namespace std; 

int T; 
long long x, k; 

long long gcd(long long a, long long b, long long &x, long long &y) {
	if (a == 0) {
		x = 0;
		y = 1; 
		return b; 
	}

	long long x1, y1; 
	long long d = gcd(b % a, a, x1, y1); 
	x = y1 - (b / a) * x1; 
	y = x1; 
	return d; 
}

int main () {
	cin >> T;
	 
	for (int tt = 1; tt <= T; tt++) {
		cin >> x >> k; 

		long long p, q; 
		long long r = x % k; 
		if (r == 0) {
			p = k; 
			q = 0; 
		}
		else {          		
			long long a = x / k; 
			long long b = a + 1; 
			long long x0, y0; 
			long long g = gcd(abs(a), abs(b), x0, y0); 
			x0 *= x / g; 
			y0 *= x / g; 
			if (a < 0) {
				x0 = -x0; 
			}

			if (b < 0) {
				y0 = -y0; 
			}

			p = x0; 
			q = y0; 
		}

		cout << p << ' ' << q << endl; 
	}
	return 0; 
}        
 */
public class ORANGE_L06P05 {

}
