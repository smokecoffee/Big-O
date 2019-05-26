package bigO.orange01.lecture07;
/*
 * Prime Cuts
A prime number is a counting number (1, 2, 3, ... )(1,2,3,...) that is evenly divisible only by 11 and itself. In this problem you are to write a program that will cut some number of prime numbers from the list of prime numbers between (and including) 11 and NN. Your program will read in a number NN; determine the list of prime numbers between 11 and NN; and print the 2C2C prime numbers from the center of the list if there are an even number of prime numbers or 2C-12C−1 prime numbers from the center of the list if there are an odd number of prime numbers in the list.

Input
There are multiple test cases for each test. Each test case will be on a line by itself and will consist of 22 numbers. The first number (1 \le N \le 1000)(1≤N≤1000) is the maximum number in the complete list of prime numbers between 11 and NN. The second number (1 \le C \le N)(1≤C≤N) defines the 2C2C prime numbers to be printed from the center of the list if the length of the list is even; or the 2C - 12C−1 numbers to be printed from the center of the list if the length of the list is odd.

Output
For each test case, you should print the number NN beginning in column 11 followed by a space, then by the number CC, then by a colon (:), and then by the center numbers from the list of prime numbers as defned above. If the size of the center list exceeds the limits of the list of prime numbers between 11 and NN, the list of prime numbers between 11 and NN (inclusive) should be printed. Each number from the center of the list should be preceded by exactly one blank. Each line of output should be followed by a blank line. Hence, your output should follow the exact format shown in the sample output.

Ví dụ
input
21 2
18 2
18 18
100 7
output
21 2: 5 7 11

18 2: 3 5 7 11

18 18: 1 2 3 5 7 11 13 17

100 7: 13 17 19 23 29 31 37 41 43 47 53 59 61 67
Do giới hạn của bài này nhỏ nên ta sẽ trước khi xử lý bất kì trường hợp nào, ta sẽ dùng sàng Eratosthenes để tìm toàn bộ các số nguyên tố. Lưu ý rằng ở bài này số 11 cũng được xem là một số nguyên tố.
Với mỗi trường hợp, ta sẽ duyệt từ 11 tới NN và bỏ toàn bộ các số nguyên tố vào 11 mảng:
Nếu kích cỡ của mảng bé hơn 2*C - 12∗C−1 thì ta in ra toàn bộ mảng các số nguyên tố ấy.
Nếu ngược lại thì ta sẽ phải in ra 2*C2∗C số ở trung tâm nếu như kích cỡ của mảng là số chẵn và 2*C - 12∗C−1 số ở trung tâm nếu như dãy có kích cỡ là số lẻ. Gọi mm là kích cỡ của mảng các số nguyên tố từ 11 đến nn.
Ở đây ta để ý rằng đoạn các số ở trung tâm sẽ luôn bắt đầu từ m/2 - C + (m \% 2)m/2−C+(m%2), lý do là vì ta sẽ đi từ trung tâm của dãy qua trái CC số, nếu như mm là số lẻ thì m \% 2 = 1m%2=1 và ta sẽ bắt đầu dãy số từ vị trí m/2 - C + 1m/2−C+1, nếu như mm là số chẵn thì ta bắt đầu từ vị trí m/2 – C
Ngoài ra, ta còn thấy rằng dù mm là chẵn hay lẻ thì index cuối cùng trong đoạn số cần in sẽ luôn là m/2 + C – 1.
Như vậy dãy của ta sẽ đi từ index m/2 - C + (m\%2)m/2−C+(m%2) cho đến m/2 + C -1m/2+C−1.
Độ phức tạp: O(\sqrt{N}*log(log(N)))O(√
​N
​
​​ ∗log(log(N))) với NN đề cho.

Mã nguồn tham khảo
#include <iostream>
#include <vector>
#include <string.h>
 
using namespace std;
 
bool isPrime[1001];
 
int main() {
    memset(isPrime, true, sizeof(isPrime));
    isPrime[0] = false;
    isPrime[1] = true;
     
    for (int i = 2; i * i <= 1000; ++i) {
        if (isPrime[i]) {
            for (int j = i * 2; j <= 1000; j += i) {
                isPrime[j] = false;
            }
        }
    }
 
    int n, c;
    while (cin >> n >> c) {
        vector<int> primes;
        for (int i = 1; i <= n; ++i) {
            if (isPrime[i]) {
                primes.push_back(i);
            }
        }
 
        int m = primes.size();
        cout << n << ' ' << c << ":";
   
        if (m < (2 * c - 1)) {
            for (int prime : primes) {
                cout << ' ' << prime;
            }
        }
        else {
            for (int i = m / 2 - c + (m % 2); i <= m / 2 + c - 1; ++i) {
                cout << ' ' << primes[i];
            }
        }
        cout << endl << endl;
    }
     
    return 0;
}

 */
public class ORANGE_L07P04 {

}
