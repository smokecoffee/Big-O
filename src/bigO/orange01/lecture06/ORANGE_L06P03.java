package bigO.orange01.lecture06;
/*
 * Problem Makes Problem
As I am fond of making easier problems, I discovered a problem. Actually, the problem is how can you make n by adding k non-negative integers? I think a small example will make things clear. Suppose n = 4n=4 and k = 3k=3. There are 1515 solutions. They are:

 0 0 4
 0 1 3
 0 2 2
 0 3 1
 0 4 0
 1 0 3
 1 1 2
 1 2 1
 1 3 0
 2 0 2
 2 1 1
 2 2 0
 3 0 1
 3 1 0
 4 0 0
As I have already told you that I use to make problems easier, so, you don't have to find the actual result. You should report the result modulo 1000,000,0071000,000,007.

Input
Input starts with an integer T (\le 25000)T(≤25000), denoting the number of test cases.

Each case contains two integer n (0 \le n \le 10^6)n(0≤n≤10
​6
​​ ) and k (1 \le k \le 10^6)k(1≤k≤10
​6
​​ ).

Output
For each case, print the case number and the result modulo 10000000071000000007.

Ví dụ
input
4
4 3
3 5
1000 3
1000 5
output
Case 1: 15
Case 2: 35
Case 3: 501501
Case 4: 84793457
Hướng dẫn giải:

Ta có thể hiểu bài toán này như sau: Cho nn viên bi, kk cái túi. Đếm có bao nhiêu cách để bỏ nn viên bi vào kk túi.
Gọi mỗi viên bi là 00, mỗi túi là 11. Ta sắp các viên bi và những cái túi liền nhau. Khi đó sẽ tạo thành một dãy gồm các số 00 và 11. Các số 00 liên tục đứng liền trước số 11 chính là số viên bi có trong túi đó. Khi k - 1k−1 số 11 nằm trước nn số 00, tức là k - 1k−1 túi không chứa viên bi nào cả thì túi còn lại sẽ chứa toàn bộ nn viên bi. Vì vậy, ta chỉ xét k - 1k−1 cái túi. Dãy gồm nn viên bi và k - 1k−1 cái túi, dãy có tổng cộng n + k - 1n+k−1 vị trí. Ta chọn nn viên bi đặt vào n + k - 1n+k−1 vị trí đó, có C_{n + k - 1}^{n}C
​n+k−1
​n
​​  cách chọn, k - 1k−1 vị trí còn lại ta đặt các túi vào.

Tóm lại, ta chỉ cần tính C_{n + k - 1}^{n}C
​n+k−1
​n
​​  modulo cho 10000000071000000007.

Biết C_{n + k - 1}^{n} = \frac{(n + k - 1)!}{n!(k - 1)!}C
​n+k−1
​n
​​ =
​n!(k−1)!
​
​(n+k−1)!
​​ 

Độ phức tạp: O(T * \log(10^7))O(T∗log(10
​7
​​ )) với TT là số lượng testcases và chúng ta có thể tính C_{n + k - 1}^{n}C
​n+k−1
​n
​​  modulo 10000000071000000007 với độ phức tạp O(\log(10^7))O(log(10
​7
​​ )).

Mã nguồn tham khảo
#include <bits/stdc++.h>

using namespace std;

const int maxx  = 2000005;
const long long mod = 1000000007;
long long fact[maxx];

void init() {
    fact[0] = 1;
    for (int i = 1; i < maxx; i++) {
        fact[i] = (i * fact[i - 1]) % mod;
    }
}

long long modularExponentiation(long long a, long long b, long long m) {
    long long res = 1;
    a %= m;
    while (b > 0) {
        if (b % 2 == 1)
            res = (res * a) % m;
        b /= 2;
        a = (a * a) % m;
    }
    return res;
}

long long modInverse(long long b, long long m) {
    long long res = modularExponentiation(b, m - 2, m);
    if (res * b % m == 1)
        return res;
    return -1;
}

long long getC(long long n, long long k) {
    long long nu = fact[n + k - 1];
    long long de = (fact[n] * fact[k - 1]) % mod;
    return (nu * modInverse(de, mod)) % mod;
}

int main() {
    init();
    int test;
    cin >> test;
    for (int tt = 1; tt <= test; tt++) {
        long long n, k;
        cin >> n >> k;
        cout << "Case " << tt << ": " << getC(n, k) << endl;
    }
    return 0;
}

----------
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

public class solution_MLE {
    
    public static int maxx = 2000005;
    public static long mod = 1000000007;
    public static long fact[] = new long[maxx];

    public static void init() {
        fact[0] = 1;
        for (int i = 1; i < maxx; i++) {
            fact[i] = (i * fact[i-1]) % mod;
        }
    }
    
    public static long modularExponentiation(long a, long b, long m) {
        long res = 1;
        a %=m ;
        while (b > 0) {
            if (b%2 == 1)
                res = (res * a) %m;
            b /= 2;
            a = (a*a) %m;
        }
        return res;
    }

    public static long modInverse(long b, long m) {
        long res = modularExponentiation(b, m-2, m);
        if (res * b % m == 1)
            return res;
        return -1;
    }

    public static long  getC(int n, int k) {
        long nu = fact[n+k-1];
        long de = (fact[n] * fact[k-1]) % mod;
        return (nu * modInverse(de, mod)) % mod;
    }



    public static void main(String[] args) {
    	  init();
        int test;
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        for (int tt = 1; tt <= test; tt++) {
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            System.out.println("Case " + tt + ": " + getC(n, k));
        }
    }
}
------------
maxx = 20000001
mod = 1000000007
fact = [0] * maxx

def init():
    fact[0] = 1
    for i in range(1, maxx):
        fact[i] = (i * fact[i - 1]) % mod

def modularExponentiation(a, b):
    res = 1
    a %= mod
    while b > 0:
        if b % 2 == 1:
            res = (res * a) % mod
        b //= 2
        a = (a * a) % mod
    return res

def modInverse(b):
    return modularExponentiation(b, mod - 2)

def getC(n, k):
    nu = fact[n+k-1]
    de = fact[n] * fact[k-1] % mod
    return nu * modInverse(de) % mod

if __name__ == '__main__':
    init()
    test = int(input())
    for tt in range(1, test+1):
        n, k = map(int, input().split())
        print("Case {}: {}".format(tt, getC(n, k)))
 */
public class ORANGE_L06P03 {

}
