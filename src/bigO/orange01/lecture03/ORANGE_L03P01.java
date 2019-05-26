package bigO.orange01.lecture03;

/**
 * @author ThinkPad-PC
 *Lotto
In the German Lotto you have to select 66 numbers from the set \{1,2,...,49\}{1,2,...,49}. A popular strategy to play Lotto - although it doesn’t increase your chance of winning — is to select a subset SS containing kk (k > 6k>6) of these 4949 numbers, and then play several games with choosing numbers only from SS.

For example, for k = 8k=8 and S = \{1, 2, 3, 5, 8, 13, 21, 34\}S={1,2,3,5,8,13,21,34} there are 2828 possible games: [1,2,3,5,8,13][1,2,3,5,8,13], [1,2,3,5,8,21][1,2,3,5,8,21], [1,2,3,5,8,34][1,2,3,5,8,34], [1,2,3,5,13,21][1,2,3,5,13,21], ..., [3,5,8,13,21,34][3,5,8,13,21,34].

Your job is to write a program that reads in the number kk and the set SS and then prints all possible games choosing numbers only from SS.

Input
Input will contain one or more test cases.

Each test case consists of one line containing several integers separated from each other by spaces. The first integer on the line will be the number k (6 < k < 13)k(6<k<13). Then kk integers, specifying the set SS, will follow in ascending order.

Input will be terminated by a value of zero (0) for kk.

Output
For each test case, print all possible games, each game on one line.

The numbers of each game have to be sorted in ascending order and separated from each other by exactly one space. The games themselves have to be sorted lexicographically, that means sorted by the lowest number first, then by the second lowest and so on, as demonstrated in the sample output below.

The test cases have to be separated from each other by exactly one blank line. Do not put a blank line after the last test case.

Ví dụ
input
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
output
1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

1 2 3 5 8 13
1 2 3 5 8 21
1 2 3 5 8 34
1 2 3 5 13 21
1 2 3 5 13 34
1 2 3 5 21 34
1 2 3 8 13 21
1 2 3 8 13 34
1 2 3 8 21 34
1 2 3 13 21 34
1 2 5 8 13 21
1 2 5 8 13 34
1 2 5 8 21 34
1 2 5 13 21 34
1 2 8 13 21 34
1 3 5 8 13 21
1 3 5 8 13 34
1 3 5 8 21 34
1 3 5 13 21 34
1 3 8 13 21 34
1 5 8 13 21 34
2 3 5 8 13 21
2 3 5 8 13 34
2 3 5 8 21 34
2 3 5 13 21 34
2 3 8 13 21 34
2 5 8 13 21 34
3 5 8 13 21 34
------------
Ý tưởng: Dùng kỹ thuật backtracking để phát sinh tất cả các tổ hợp chập 66 của kk phần tử trong mảng ban đầu.

Lợi dụng việc mảng ban đầu đã được sắp xếp tăng dần (không có giá trị trùng lặp), ta sẽ thiết kế hàm backtracking luôn "tiến tới" để đảm bảo tính tăng dần của các tổ hợp được phát sinh.

Gọi aa là mảng đề cho, resres là mảng lưu kết quả của mỗi tổ hợp được phát sinh. Cấu trúc của hàm backtracking, tạm gọi là hàm permutation(i, p, k, len_lotto = 6) với i là vị trí của phần tử thứ ii trong mảng resres, p là vị trí của phần tử thứ pp trong mảng aa (vị trí được đánh số từ 00), k là số lượng phần tử trong mảng ban đầu, len_lotto là độ dài của dãy cần được phát sinh (mặc định bằng 66), được viết dưới dạng mã giả như sau:

func permutation(i, p, k, len_lotto = 6):
    if i == len_lotto:		# Nếu mảng kết quả đã đủ len_lotto = 6 ký tự thì in ra màn hình   
            print res[]
            return
            
    for j: p -> (k - 1):
        res[i] = a[j]		# Lần lượt cố định giá trị res[i] bằng các giá trị từ vị trí p của mảng a trở về sau
        permutation(i + 1, j + 1, k, len_lotto)	# Vì vị trí j của mảng a đã được chọn cho res[i], ta xét tiếp từ vị trí (j + 1) trở về sau
Độ phức tạp: O(T * C_k^6)=O(T * k^6)O(T∗C
​k
​6
​​ )=O(T∗k
​6
​​ ) với TT là số lượng bộ test, kk là số lượng phần tử của tập SS.

Mã nguồn tham khảo
import java.util.Scanner;

public class Main {
    static int[] res = new int[6];
    static int[] a = new int[15];

    static void permutation(int i, int p, int k, int lotto_len) {
        if (i == lotto_len) {
            for (int ele : res) {
                System.out.printf("%d ", ele);
            }
            System.out.println();
            return;
        }
        
        for (int j = p; j < k; j++) {
            res[i] = a[j];
            permutation(i + 1, j + 1, k, lotto_len);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean blank_line = false;

        while (true) {
            int k = sc.nextInt();
            if (k == 0) {
                break;
            }

            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();
            }

            if (blank_line) {
                System.out.println();
            }

            permutation(0, 0, k, 6);
            blank_line = true;
        }
    }
}
---python3
def permutation(i, p, k, lotto_len):
    global a, res
    if i == lotto_len:
        print(*res)
        return

    for j in range(p, k):
        res[i] = a[j]
        permutation(i + 1, j + 1, k, lotto_len)

res = [None] * 6
blank_line = False

while True:
    k, *a = list(map(int, input().split()))
    if k == 0:
        break
    
    if blank_line:
        print()
    
    permutation(0, 0, k, 6)
    blank_line = True
---cpp14
#include <iostream>
using namespace std;
const int MAX = 15;
int a[MAX], res[6];

void permutation(int i, int p, int k, int lotto_len) {
    if (i == lotto_len) {
        for (int& ele : res) {
            cout << ele << " ";
        }
        cout << endl;
        return;
    }

    for (int j = p; j < k; j++) {
        res[i] = a[j];
        permutation(i + 1, j + 1, k, lotto_len);
    }
}

int main() {
    int k;
    bool blank_line = false;

    while (true) {
        cin >> k;
        if (k == 0) {
            break;
        }

        for (int i = 0; i < k; i++) {
            cin >> a[i];
        }

        if (blank_line) {
            cout << endl;
        }

        permutation(0, 0, k, 6);
        blank_line = true;
    }
}    
 */
public class ORANGE_L03P01 {

}
