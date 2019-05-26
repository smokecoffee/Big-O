package bigO.orange01.lecture02;

/**
 * @author ThinkPad-PC
 *Samu and her Birthday Party
Samu's Birthday is near so she had started planning a party for all of her friends. Being a kind and caring girl she calls each of her friend and asks for his/her favorite dish. Now each friend has own liking/disliking for different dishes.

A friend can only like or dislike a dish. It means if we are having three dishes 1,2,31,2,3 then if a friend says that he likes Dishes 11 and 22 then it’s obvious that he dislikes Dish 33. So for each friend we are given a string of 11 and 00 where 11 shows that this person likes this particular dish.

Now we are given that Samu has NN friends and total of KK dishes available to make her menu. Now Samu doesn't want to make any of her friend unhappy, after all it’s her birthday.

So she got confused on what dishes to count in menu and calls you for help. You need to find count of minimum dishes to order so that all of her NN friends are happy, which means everyone has at least one dish to eat in party.

Note: It’s for sure that everyone has at least liking for one dish.

Input
Input will contain TT test cases and each of the test case has following description:

First line of test case has NN denoting the total number of friends and KK denoting the total number of dishes available. Both are separated by a space (dishes are numbered from 11 to KK).

Then it is followed by NN lines each of length KK. Each of the NN lines contains a string of 00 and 11 where if j^{th}j
​th
​​  (1 \le j \le K1≤j≤K) value in i^{th}i
​th
​​  line (1 \le i \le N1≤i≤N) is set 11 then it shows that dish number jj is liked by that i^{th}i
​th
​​  Samu's friend.

CONSTRAINTS:

1 \le T \le 101≤T≤10
1 \le N \le 5001≤N≤500
1 \le K \le 101≤K≤10
Output
You need to tell the minimum number of dishes to be taken in menu so that all friends are happy.

Each string will only contain 00 or 11 and it is sure that there is at least one 11 in each string depicting like/dislike of Samu's friend.

Ví dụ
input
1
2 2
10
01
output 
2
-------Giải thích
Both dishes are to be taken into account as Friend 11 doesn't like Dish 22 and Friend 22 doesn't like Dish 11.
---------
Ý tưởng: Duyệt qua tất cả các cách chọn món ăn có thể có từ KK món ăn được cho và kiểm tra xem cách chọn đó có thỏa yêu cầu mỗi người đều có một món ăn yêu thích hay không. Nếu có thì đó là một cách chọn hợp lệ. Ta chọn cách chọn nào có ít món ăn nhất trong các cách chọn hợp lệ này.

Cho rằng mỗi cách chọn sẽ được biểu diễn bằng một dãy bit 00 và 11. Trong đó, bit 11 tại vị trí xx nghĩa là ta sẽ chọn món ăn thứ xx vào menu. Như vậy, để phát sinh ra tất cả các cách chọn món ăn từ KK món ăn được cho, ta chỉ việc duyệt qua các dãy bit 000...001, 000...010, 000...011, ..., 111...111, tương ứng với các số từ 11 đến 2^K - 12
​K
​​ −1.

Các món ăn yêu thích của một người cũng được biểu diễn bằng một dãy bit 00 và 11. Do đó để kiểm tra xem cách chọn hiện tại có bao gồm ít nhất một món ăn yêu thích của người đó hay không, ta chỉ việc AND hai dãy bit với nhau. Nếu kết quả khác 00 là đúng.

Tìm số lượng bit 11 nhỏ nhất trong số các dãy bit của những cách chọn hợp lệ chính là kết quả của bài toán.

Độ phức tạp: O(T * 2^K * (N + log(K)))O(T∗2
​K
​​ ∗(N+log(K))) với TT là số lượng bộ test, NN là tổng số bạn của Samu và KK là số món ăn có sẵn cần chọn. Trong đó, với mỗi bộ test:

O(N * K)O(N∗K) là chi phí chuyển chuỗi các món ăn yêu thích của NN người bạn thành NN dãy bit.
O(2^K * (N + log(K)))O(2
​K
​​ ∗(N+log(K))) là chi phí tìm ra tất cả các dãy bit tương ứng với các cách chọn phù hợp thỏa yêu cầu và tính số bit 11 trong dãy bit hợp lệ để cho ra dãy bit có ít bit 11 nhất.
Mã nguồn tham khảo
#include <iostream>
#include <string>
#include <bitset>
using namespace std;
const int MAX = 505;

int main() {
    int t, n, k, a[MAX];
    string bits;
    cin >> t;

    for (int tc = 0; tc < t; tc++) {
        cin >> n >> k;

        for (int i = 0; i < n; i++) {
            cin >> bits;
            a[i] = stoi(bits, nullptr, 2);
        }

        int min_dish = k;
        for (int i = 1; i < (1 << k); i++) {
            bool valid = true;

            for (int j = 0; j < n; j++) {
                if ((a[j] & i) == 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                int n_ones = bitset<10>(i).count();
                min_dish = min(min_dish, n_ones);  
            }
        }

        cout << min_dish << endl;
    }
    return 0;
}

------python
t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    a = [0] * n

    for i in range(n):
        a[i] = int(input(), 2)

    min_dish = k
    for i in range(1, 1 << k):
        valid = True
        for people in a:
            if ((people & i) == 0):
                valid = False
                break

        if valid:
            min_dish = min(min_dish, bin(i).count("1"))
    
    print(min_dish)
    
--------java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(sc.next(), 2);
            }

            int min_dish = k;
            for (int i = 0; i < (1 << k); i++) {
                boolean valid = true;
                for (int people : a) {
                    if ((people & i) == 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    min_dish = Math.min(min_dish, Integer.bitCount(i));
                }
            }

            System.out.println(min_dish);
        }
    }
}    

 */
public class ORANGE_L02P04 {

}
