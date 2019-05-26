package bigO.orange01.lecture03;

/**
 * @author ThinkPad-PC
 *Minimize Absolute Difference
You are given a int[] x that contains exactly five positive integers. You want to put four of them instead of the question marks into the following expression: | (?/?) - (?/?) |. Which numbers should you put there and in what order, if your goal is to make the value of the expression as small as possible?

More formally, you have the following expression: | (xa / xb) - (xc / xd) |. Here, "/" denotes real division (e.g., 7/2 = 3.57/2=3.5) and "||" denotes absolute value. You want to find the four distinct subscripts a, b, c, da,b,c,d for which the value of the expression is minimized.

Output a int[] with four elements: the optimal subscripts \{a, b, c, d\}{a,b,c,d}. If there are multiple optimal answers, return the lexicographically smallest one among them.

Notes

Given two distinct arrays AA and BB with the same number of elements, we say that AA is lexicographically smaller than BB if AA has a smaller value at the first index at which they differ.
Input
Input contains five integers, each separated by space. Each integer will be between 11 and 1000010000, inclusive.

Output
Output four integers, separated by space, that is the optimal answer.

Ví dụ
input
1 1 1 1 1
output
0 1 2 3
input
2 3 5 7 11
output
0 3 1 4
input
8 2 4 2 6
output
1 0 3 4
input
124 182 9 33 70
output
2 4 3 1
input
9947 3 7 11 13
output
1 4 3 0
input
10000 4 10 4 10
output
1 2 3 4
Giải thích
In the first example, regardless of our choice of subscripts, the expression always evaluates to | (1/1) - (1/1) | = |1-1| = 0∣(1/1)−(1/1)∣=∣1−1∣=0. The lexicographically smallest optimal solution is \{0, 1, 2, 3\}{0,1,2,3}
In the second example, both \{0, 3, 1, 4\}{0,3,1,4} and \{1, 4, 0, 3\}{1,4,0,3} would minimize the given expression, but \{0, 3, 1, 4\}{0,3,1,4} comes lexicographically first, so that is the only correct answer. The corresponding expression is |(2/7) - (3/11)| = 0.012987∣(2/7)−(3/11)∣=0.012987
In the third example, there are four sets of subscripts that minimize the given expression: \{1, 0, 3, 4\}, \{1, 4, 3, 0\}, \{3, 0, 1, 4\}{1,0,3,4},{1,4,3,0},{3,0,1,4}, and \{3, 4, 1, 0\}{3,4,1,0}.
In the last example, the smallest possible value of our expression is |(4/10) - (4/10)| = 0∣(4/10)−(4/10)∣=0.
 */
/*
 * Vì số lượng phần tử đầu vào rất nhỏ, chỉ có 55 phần tử. Do đó, ta có thể sử dụng backtracking để có thể sinh ra toàn bộ 5!5! trường hợp, mỗi trường hợp ta sẽ tính giá trị của biểu thức và so sánh để tìm ra trường hợp có giá trị nhỏ nhất có thể.

Tuy nhiên, cách làm ở trên không được tốt và đảm bảo đúng 100\%100%, vì khi ta tính các số theo dạng số thực, rất dễ bị sai số và khi so sánh chúng với nhau không khớp 100\%100%. Thay vì như thế, ta có thể so sánh theo kiểu số nguyên bằng cách : Biến đổi giá trị |(a/b) - (c/d)|∣(a/b)−(c/d)∣ thành |(a * d - b * c) / (b * d)| = |(a * d - b * c)| / (b * d)∣(a∗d−b∗c)/(b∗d)∣=∣(a∗d−b∗c)∣/(b∗d). Như vậy, với mỗi giá trị, ta sẽ lưu dưới dạng một cặp gồm tử và mẫu đều là 2 số nguyên dương. Ta tạo một hàm comp(a, b) với aa là phân số thứ nhất và bb là phân số thứ 22. Hàm comp(a, b) này trả ra truetrue hoặc falsefalse tương ứng là aa có nhỏ hơn bb hay không bằng cách so sánh giữa 22 số nguyên. Phân số (a.tu / a.mau) < (b.tu / b.mau) khi và chỉ khi a.tu * b.mau < b.tu * a.mau. Cần lưu ý việc tràn số khi so sánh phân số như thế này, vì giá trị của những phần tử trong mảng xx đầu vào không vượt quá 1000010000.

Để thực hiện hàm backtracking để thực hiện việc liệt kê những hoán vị, ta sẽ tạo hàm backTrack(pos) với ý nghĩa: Ta đang điền vị trí phần tử trong dãy vào vị trí pos hiện tại. Ta lưu các vị trí vào một mảng p[ ]. Nếu pos = 3pos=3 (đủ 44 phần tử) thì ta tiến hành tính giá trị |(a/b) - (c/d)|∣(a/b)−(c/d)∣, ngược lại ta tiếp tục gọi backtracking với pos + 1. Sau khi gọi backTrack(pos + 1), ta hủy vết đã lưu các phần tử trước đó.

Độ phức tạp: O(N! * N)O(N!∗N) với NN là số lượng phần tử trong dãy đầu vào.

Mã nguồn tham khảo
def cmp(num, denom, _num, _denom):
    return (num * _denom < _num * denom)

def check(c, a, minn, ans):
    num = abs(c[a[0]] * c[a[3]] - c[a[1]] * c[a[2]])
    denom = c[a[1]] * c[a[3]]
    
    if cmp(num, denom, minn[0], minn[1]):
        minn[0] = num
        minn[1] = denom
        for i in range(4):
            ans[i] = a[i]

def permutation(c, a, b, j, minn, ans):
    for i in range(5):
        if (b[i]):
            a[j] = i
            b[i] = False
            if j == 4:
                check(c, a, minn, ans)
            else:
                permutation(c, a, b, j + 1, minn, ans)
            b[i] = True

a = []
b = []
ans = []
c = list(map(int, input().split()))
minn = []
minn.append(1000000)
minn.append(1)

for i in range(5):
    a.append(i)

for i in range(4):
    ans.append(0)

b = [True] * 6
permutation(c, a, b, 0, minn, ans)
print(str(ans[0]) + " " + str(ans[1]) + " " + str(ans[2]) + " " + str(ans[3]))

---------
#include <iostream>
#include <algorithm>
#include <iomanip>
using namespace std;

bool cmp(long long num, long long denom, long long _num, long long _denom) { 
    long long a = num * _denom;
    long long b = _num * denom;
    return (a < b);
}

void check(long long(&c)[5], long long(&a)[5], long long(&minn)[2], long long(&ans)[4]) {
    long long num = abs(c[a[0]] * c[a[3]] - c[a[1]] * c[a[2]]), denom = c[a[1]] * c[a[3]];
    if (cmp(num, denom, minn[0], minn[1])) {
        minn[0] = num;
        minn[1] = denom;
        for (long long i = 0; i < 4; i++) ans[i] = a[i];
    }
}

void permutation(long long(&c)[5], long long(&a)[5], bool(&b)[5], long long j, long long(&minn)[2], long long(&ans)[4]) {
    for (long long i = 0; i < 5; i++) {
        if (b[i]) {
            a[j] = i;
            b[i] = false;
            if (j == 3) {
                check(c, a, minn, ans);
            }
            else permutation(c, a, b, j + 1, minn, ans);
            b[i] = true;
        }
    }
}
int main() {
    long long a[5], c[5], ans[4];
    for (long long i = 0; i < 5; i++) cin >> c[i];
    long long minn[2];
    minn[0] = 10000000007; minn[1] = 1;
    for (int i = 0; i < 5; i++) a[i] = i;
    for (int i = 0; i < 4; i++) ans[i] = 0;

    bool b[5];
    for (long long i = 0; i < 5; i++) b[i] = true;
    permutation(c, a, b, 0, minn, ans);
    cout << ans[0] << " " << ans[1] << " " << ans[2] << " " << ans[3] << endl;

    return 0;
}
-------java
import java.util.Scanner;

public class sol{
    public static boolean cmp(long num, long denom, long _num, long _denom) {
        long x = num * _denom;
        long y = _num * denom;
        return (x < y);
    }
  
    public static void check(long []c, int []a, long []minn, long []ans) {
        long num = Math.abs(c[a[0]] * c[a[3]] - c[a[1]] * c[a[2]]), denom=c[a[1]]*c[a[3]];
        if (cmp(num, denom, minn[0], minn[1])){
            minn[0] = num;
            minn[1] = denom;
            for (int i = 0; i < 4; i++) ans[i] = a[i];
        }
    }
  
    public static void permutation(long []c, int []a,  boolean[]b, int j, long [] minn, long []ans) {
        for (int i = 0; i < 5; i++) {
            if (b[i]) {
                a[j] = i;
                b[i] = false;
                if (j == 4) {
                    check(c, a, minn, ans);
                }
                else permutation(c, a, b, j + 1, minn, ans);
                b[i] = true;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long []c = new long[5];
        for (int i = 0; i < 5; i++) 
            c[i] = sc.nextLong();

        long []minn = new long[2];
        minn[0] = 1000000; minn[1] = 1;

        int []a = new int[5];
        for (int i = 0; i < 5; i++) a[i] = i;

        long []ans = new long[4];
        for (int i = 0; i < 4; i++) ans[i] = 0;

        boolean []b = new boolean[5];
        for (int i = 0; i < 5; i++) b[i] = true;
        
        permutation(c, a, b, 0, minn, ans);
        
        System.out.print(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3]);
    }
}
 */
public class ORANGE_L03P05 {

}
