package bigO.orange01.lecture07;
/*
 * Anagrammatic Primes
A number greater than one is prime if it has no divisors other than itself and 11 (note that 11 is not prime). For example, 2323 is prime and 3535 is not prime because 35 = 7 * 535=7∗5. When the digits of a number are rearranged, its primeness may change — for example, 3535 is not prime but 5353 is. For this problem, you have to find numbers which are prime no matter how you rearrange their digits. For example, all of the numbers 113, 131113,131 and 311311 are prime, so we say that 113113 is an anagrammatic prime (also 131131 and 311311 are anagrammatic primes).

Input
Each line of input will contain a single positive number nn, less than 1000000010000000. You must find the first anagrammatic prime which is larger than nn and less than the next power of 1010 greater than nn. The input will be terminated by a line consisting of a single 0.

Output
For each number in the input, one line of output must be produced. This output line should contain either the next anagrammatic prime, as described above, or 0 if there is no anagrammatic prime in the range defined.

Ví dụ
input
10
16
900
113
8000000
0
output
11
17
919
131
0
Ta không biết được đề bài cho bao nhiêu số nn, yêu cầu mình tìm bao nhiêu số Anagrammatic Prime. Nên để tránh code bị TLE, ta tìm trước mảng anaPrime gồm những số Anagrammatic Prime trong giới hạn của đề. Với mỗi nn, ta tìm được số Anagrammatic Prime dựa vào mảng anaPrime.

Để tạo mảng anaPrime, trước tiên ta phải dùng sàng Eratosthennes tìm các số nguyên tố có trong khoảng [1, maxN][1,maxN] với maxN = 10000000maxN=10000000. Với mỗi số nguyên tố, ta kiểm tra xem tất cả hoán vị của nó có phải số nguyên tố không, nếu tất cả các hoán vị đều là số nguyên tố thì ta thêm số đó vào mảng anaPrime.

Ta có nhận xét là nếu số xx chứa các chữ số chẵn, hoặc chứa chữ số 55 thì xx không phải là số Anagrammatic Prime (trừ x = 2x=2 và x = 5x=5) vì khi ta xét các hoán vị của xx, nếu các chữ số chẵn đó nằm ở hàng đơn vị thì nó chia hết cho 22, còn nếu chữ số 55 nằm ở hàng đơn vị thì nó chia hết cho 55. Dựa vào nhận xét này mà ta giảm đi đáng kể số lần kiểm tra số Anagrammatic Prime.

Độ phức tạp: O(\sqrt{maxN} * log(log(maxN)))O(√
​maxN
​
​​ ∗log(log(maxN))) với maxN = 10000000maxN=10000000.

Mã nguồn tham khảo
// UVA: 897 - Anagrammatic Primes

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

const int maxN = 1e7;
vector<bool> prime;
vector<int> anaPrime;

void sieveOfEratosthenes(int n) {
    prime.resize(n + 1, true);
    prime[0] = prime[1] = false;
    for (int i = 2; i*i <= n; i++) {
        if (prime[i] == true) {
            for (int j = i * 2; j <= n; j += i)
                prime[j] = false;
        }
    }
}

void swap(int &x, int &y) {
    int tmp = x;
    x = y; y = tmp;
}

bool nextPermutation(vector<int> &a) {
    int m = a.size();
    for (int i = m - 2; i >= 0; i--) {
        if (a[i] < a[i + 1]) {
            for (int j = m - 1; j > i; j--)
                if (a[i] < a[j]) {
                    swap(a[i], a[j]);
                    reverse(a.begin() + i + 1, a.end());
                    return true;
                }
        }
    }
    return false;
}

bool isAnaPrime(int n) {
    vector<int> a;
    while (n > 0) {
        a.push_back(n % 10);
        n /= 10;
    }
    sort(a.begin(), a.end());
    int m = a.size();
    for (int i = 0; i < m; i++) {
        if (a[i] % 2 == 0 || (a[i] == 5 && m > 1)) return false;
    }
    do {
        n = 0;
        for (int i = 0; i < m; i++)
            n = n*10 + a[i];
        if (!prime[n]) return false;
    } while (nextPermutation(a));
    return true;
}

void init(int n) {
    sieveOfEratosthenes(n);
    anaPrime.push_back(2);
    for (int i = 3; i <= n; i += 2) {
        if (prime[i]) {
            if (isAnaPrime(i)) anaPrime.push_back(i);
        }
    }
}

int main() {
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    init(maxN);
    int n;
    while (true) {
        cin >> n;
        if (n == 0) break;
        int m = anaPrime.size();
        //for (int  i = 0; i < m; i++) cout << anaPrime[i] << ' ';cout << endl << endl;
        int index = m - 1;
        for (; index >= 0 && anaPrime[index] > n; index--);
        index++;
        if (index < m) {
            int pow10 = 1;
            while (n > 0) {
                n /= 10;
                pow10 *= 10;
            }
            if (anaPrime[index] < pow10)
                cout << anaPrime[index] << endl;
            else
                cout << 0 << endl;
        }
        else {
            cout << 0 << endl;
        }
    }
    return 0;
}
 */
public class ORANGE_L07P05 {

}
