package bigO.orange01.lecture07;
/*
 * Send a Table
When participating in programming contests, you sometimes face the following problem: You know how to calcutale the output for the given input values, but your algorithm is way too slow to ever pass the time limit. However hard you try, you just can’t discover the proper break-oﬀ conditions that would bring down the number of iterations to within acceptable limits.

Now if the range of input values is not too big, there is a way out of this. Let your PC rattle for half an hour and produce a table of answers for all possible input values, encode this table into a program, submit it to the judge, et voila: Accepted in 0.000 seconds! (Some would argue that this is cheating, but remember: In love and programming contests everything is permitted).

Faced with this problem during one programming contest, Jimmy decided to apply such a ’technique’. But however hard he tried, he wasn’t able to squeeze all his pre-calculated values into a program small enough to pass the judge. The situation looked hopeless, until he discovered the following property regarding the answers: the answers where calculated from two integers, but whenever the two input values had a common factor, the answer could be easily derived from the answer for which the input values were divided by that factor. To put it in other words

Say Jimmy had to calculate a function Answer(x, y)Answer(x,y) where xx and yy are both integers in the range [1, N][1,N]. When he knows Answer(x, y)Answer(x,y), he can easily derive Answer(k*x, k*y)Answer(k∗x,k∗y), where kk is any integer from it by applying some simple calculations involving Answer(x, y)Answer(x,y) and kk. For example if N = 4N=4, he only needs to know the answers for 1111 out of the 1616 possible input value combinations: Answer(1, 1)Answer(1,1), Answer(1, 2)Answer(1,2), Answer(2, 1)Answer(2,1), Answer(1, 3)Answer(1,3), Answer(2, 3)Answer(2,3), Answer(3, 2)Answer(3,2), Answer(3, 1)Answer(3,1), Answer(1, 4)Answer(1,4), Answer(3, 4)Answer(3,4), Answer(4, 3)Answer(4,3) and Answer(4, 1)Answer(4,1). The other 5 can be derived from them (Answer(2, 2)Answer(2,2), Answer(3, 3)Answer(3,3) and Answer(4, 4)Answer(4,4) from Answer(1, 1)Answer(1,1), Answer(2, 4)Answer(2,4) from Answer(1, 2)Answer(1,2), and Answer(4, 2)Answer(4,2) from Answer(2, 1)Answer(2,1)). Note that the function Answer is not symmetric, so Answer(3, 2)Answer(3,2) can not be derived from Answer(2, 3)Answer(2,3).

Now what we want you to do is: for any values of NN from 11 upto and including 5000050000, give the number of function Jimmy has to pre-calculate.

Input
The input fle contains at most 600600 lines of inputs. Each line contains an integer less than 5000150001 which indicates the value of NN. Input is terminated by a line which contains a zero. This line should not be processed.

Output
For each line of input produce one line of output. This line contains an integer which indicates how many values Jimmy has to pre-calculate for a certain value of NN.

Ví dụ
input
2
5
0
output
3
19
Ta có nhận xét:

Các giá trị Answer(x,y)Answer(x,y) với x=yx=y có thể được suy ra từ Answer(1,1)Answer(1,1) nên không cần phải tính nữa.
Giả sử x<yx<y, đặt d=gcd(x,y)d=gcd(x,y).
Nếu d>1d>1 thì Answer(x,y)Answer(x,y) có thể được suy ra từ Answer(x/d,y/d)Answer(x/d,y/d) nên không cần tính nó.
Nếu d=1d=1 thì không thể suy ra Answer(x,y)Answer(x,y) từ giá trị nào trước đó, nên ta phải tốn 11 phép tính cho Answer(x,y)Answer(x,y) (và tương tự, 11 phép tính cho Answer(y,x)Answer(y,x), vậy là 22 phép tính).
Như vậy, với một giá trị yy cố định, số phép tính Answer(x,y)Answer(x,y) (với x<yx<y) cần thực hiện chính là phi(y)phi(y), tức là số các số bé hơn yy và nguyên tố cùng nhau với yy.
Thuật toán:

Khởi tạo kết quả bằng 11.
Với mỗi giá trị yy từ 22 tới NN, cộng 2 * phi(y)2∗phi(y) vào kết quả.
Độ phức tạp: O(T * N * \sqrt{N})O(T∗N∗√
​N
​
​​ ) với TT là số test. Lưu ý, cần phải cache lại giá trị phi để tránh phải tính phiphi của một số rất nhiều lần, dẫn tới TLE.

Mã nguồn tham khảo
#include <iostream>

using namespace std;

const int N = 50001;
int phi_cache[N] = {0};

int eulerPhi(int n) {
    if (phi_cache[n] > 0) {
        return phi_cache[n];
    }
    
    int res = n, m = n;
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            while (n % i == 0) {
                n /= i;
            }
			res = res / i * (i - 1);
        }
    }
    
    if (n > 1) {
        res = res / n * (n - 1);
    }

    return phi_cache[m] = res;
}

int main() {
    int n;
    while (true) {
        cin >> n;
        if (n == 0) {
            break;
        }

        int res = 1;
        for (int y = 2; y <= n; ++y) {
            res += eulerPhi(y) * 2;
        }
        cout << res << endl;
    }
    
    return 0;
}

 */
public class ORANGE_L07P03 {

}
