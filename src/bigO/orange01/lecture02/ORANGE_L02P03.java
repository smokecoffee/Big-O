package bigO.orange01.lecture02;

/**
 * @author ThinkPad-PC
 *Given an array AA. Is there any subset of array AA in which if we do AND of all elements of that subset then output should be in power of two (for example: 1, 2, 4, 8, 161,2,4,8,16 and so on).

Input
First line contains number of test cases TT. Each test first line contains NN size of array AA and next line contains NN space separated integers.

CONSTRAINTS:

1 \le T \le 10001≤T≤1000
1 \le N \le 2001≤N≤200
0 \le A_i \le 10^90≤A
​i
​​ ≤10
​9
​​ 
Output
For each test case print "YES" if there is any subset of array AA in which if we do AND of all elements of that subset then output should be in power of two else print "NO".

Ví dụ
input
2
3
1 2 3
2
10 20
output
YES
NO
--------
Trước hết, ta cần làm rõ rằng một subset, tức tập hợp con là một tập hợp bao gồm một hoặc một số các phần tử trong tập ban đầu và không nhất thiết phải liên tục. Do đó, nếu ta giải bài toán theo hướng phát sinh tất cả các subset có thể có của tập hợp ban đầu và kiểm tra kết quả AND của các phần tử trong mỗi subset được phát sinh có đúng là lũy thừa 2 không sẽ rất tốn kém.

Mặt khác, ta biết rằng nếu có bất cứ subset nào mà kết quả AND của nó bằng lũy thừa 2 thì lũy thừa đó cũng chỉ thuộc trong khoảng 1, 2, 4, ..., 2^{30}1,2,4,...,2
​30
​​  (vì mảng được cho chỉ chứa các số nguyên không âm, nên khi AND các số lại chắc chắn ta được một số nguyên có giá trị cao nhất là 2^{31} - 12
​31
​​ −1, như vậy lũy thừa 2 cao nhất là 2^{30}2
​30
​​ ).

Ý tưởng: Duyệt qua từng lũy thừa 2 từ 11 đến 2^{30}2
​30
​​  và kiểm tra kết quả AND các phần tử trong subset tốt nhất hiện tại có bằng với lũy thừa 2 đang xét hay không. Nếu đúng, ta ngay lập tức kết luận “YES”. Nếu đã duyệt qua tất cả lũy thừa 2 mà vẫn không có subset nào AND ra được kết quả tương ứng, in ra “NO”.

Subset tốt nhất ở đây là subset mà khi AND các phần tử của nó có khả năng cho lũy thừa 2 cao nhất.
Với một số AA là lũy thừa 2, tức số AA phải có dạng 0...010...00...010...0 (chỉ có duy nhất một bit 11 tại vị trí xx) thì subset tốt nhất có khả năng cho kết quả AND đúng bằng số AA đó sẽ chỉ chứa các phần tử mà bit tại vị trí xx cũng bằng 11. Nói cách khác, subset tốt nhất sẽ chỉ bao gồm các số mà khi AND nó với số AA không làm mất bit 11 duy nhất của số AA, tức không làm cho số AA bằng 00.
Như vậy, với một số AA, subset tốt nhất tương ứng sẽ được xây dựng bằng cách lấy tất cả các phần tử trong mảng thỏa điều kiện khi AND với AA không bằng 00 (bằng cách lấy càng nhiều càng tốt như vậy, ta sẽ tăng khả năng các bit đằng sau bit 11 khi AND với nhau sẽ cho kết quả là 00).
Độ phức tạp: O(T * N * max(\log(A_i)))O(T∗N∗max(log(A
​i
​​ ))) với TT là số lượng bộ test, NN là số phần tử của mảng, A_iA
​i
​​  là phần tử thứ ii của mảng.

O(max(\log(A_i)))O(max(log(A
​i
​​ ))) là chi phí phát sinh tất cả các số lũy thừa 2.
Mã nguồn tham khảo

#include <iostream>
using namespace std;
const int MAX = 205;

int main() {
    int t, n, power_of_two;
    bool found_subset;
    int a[MAX];
    cin >> t;

    for (int tc = 0; tc < t; tc++) {
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        found_subset = false;
        power_of_two = 1;

        for (int i = 0; i < 31; i++) {
            int and_subset = 0xFFFFFFFF;

            for (int j = 0; j < n; j++) {
                if (a[j] & power_of_two) {
                    and_subset &= a[j];
                }
            }

            if (and_subset == power_of_two) {
                found_subset = true;
                break;
            }

            power_of_two <<= 1;
        }

        cout << (found_subset ? "YES" : "NO") << endl;
    }
    return 0;
}
--------java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int power_of_two = 1;
            boolean found_subset = false;

            for (int i = 0; i < 31; i++) {
                int and_subset = 0xFFFFFFFF;
                for (int j = 0; j < n; j++) {
                    if ((a[j] & power_of_two) != 0) {
                        and_subset &= a[j];
                    }
                }

                if (and_subset == power_of_two) {
                    found_subset = true;
                    break;
                }

                power_of_two <<= 1;
            }

            System.out.println(found_subset ? "YES" : "NO");
        }
    }
}
---------python
t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    
    found_subset = False
    power_of_two = 1
    
    for i in range(31):
        and_subset = 0xFFFFFFFF
        for x in a:
            if x & power_of_two:
                and_subset &= x

        if and_subset == power_of_two:
            found_subset = True
            break
        
        power_of_two <<= 1
    
    print('YES' if found_subset else 'NO')
    
    
 */
public class ORANGE_L02P03 {

}
