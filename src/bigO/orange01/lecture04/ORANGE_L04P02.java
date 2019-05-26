package bigO.orange01.lecture04;

/**
 * @author ThinkPad-PC
 
 Painting Fence
Bizon the Champion isn't just attentive, he also is very hardworking.

Bizon the Champion decided to paint his old fence his favorite color, orange. The fence is represented as nn vertical planks, put in a row. Adjacent planks have no gap between them. The planks are numbered from the left to the right starting from one, the i^{th}i
​th
​​  plank has the width of 11 meter and the height of a_ia
​i
​​  meters.

Bizon the Champion bought a brush in the shop, the brush's width is 11 meter. He can make vertical and horizontal strokes with the brush. During a stroke the brush's full surface must touch the fence at all the time (see the samples for the better understanding). What minimum number of strokes should Bizon the Champion do to fully paint the fence? Note that you are allowed to paint the same area of the fence multiple times.

Input
The first line contains integer nn (1 \le n \le 50001≤n≤5000) — the number of fence planks.

The second line contains nn space-separated integers a_1a
​1
​​ , a_2a
​2
​​ , ..., a_na
​n
​​  (11 \le≤ a_ia
​i
​​  \le≤ 10^910
​9
​​ ).

Output
Print a single integer — the minimum number of strokes needed to paint the whole fence.

Ví dụ
input
5
2 2 1 2 1
output
3
input
2
2 2

output
2

input
1
5

output
1
-------------------Giải thích
In the first sample you need to paint the fence in three strokes with the brush: the first stroke goes on height 11 horizontally along all the planks. The second stroke goes on height 22 horizontally and paints the first and second planks and the third stroke (it can be horizontal and vertical) finishes painting the fourth plank.

In the second sample you can paint the fence with two strokes, either two horizontal or two vertical strokes.

In the third sample there is only one plank that can be painted using a single vertical stroke.
-----------Huong dan giai
Đầu tiên ta sẽ đọc chiều cao của các tấm ván vào một mảng tên là aa.
Với bài này, chúng ta sẽ giải quyết bằng cách chia để trị (Divide and Conquer): Ta sẽ xem hàng rào như một phân đoạn các tấm ván [0, n-1][0,n−1]. Sau đó, ta sẽ sơn lần lượt các đường theo chiều ngang từ dưới lên nhiều nhất có thể cho đến khi một đường sơn của chúng ta sẽ không thể sơn qua mọi tấm ván trong đoạn này nữa. Lúc này, chúng ta sẽ có các phần tấm ván chưa được sơn nằm tách biệt nhau. Ta sử dụng đệ quy để tính số lần sơn tối thiểu đối với các phần này và trả về tổng của chúng.
Hàm tính số đường cọ tối thiểu strokesNeeded(left, right, paintedHeight) (left và right đại diện cho vị trí bắt đầu và kết thúc của phân đoạn đang xét, paintedHeight là chiều cao của phần ván trước đó đã được sơn):
Nếu left > right: trả về 00
Khởi tạo biến mini (dùng để lưu lại vị trí của miếng ván có độ cao nhỏ nhất) bằng left. Sau đó duyệt các phần tử từ left đến right để tìm vị trí phần tử nhỏ nhất.
Lúc này, số các đường sơn ngang tối đa mà ta có thể thực hiện là a[mini]- paintedHeight
Tiếp theo, chúng ta tính kết quả nếu tiếp tục thực hiện đệ quy đối với các phân đoạn không liên kết với nhau (các phân đoạn sẽ không liên kết với nhau tại vị trí mini):
recursive = a[mini] - paintedHeight + strokesNeeded(left, mini-1, a[mini]) +strokesNeeded(mini + 1, right, a[mini])
Lưu ý là nếu một trong 2 đoạn [left, mini-1] hoặc [mini+1, right] rỗng thì ở lần đệ quy tiếp theo left > right và lần đệ quy đối với phân đoạn ấy sẽ trả về 0. Tức là:
Nếu [left, mini – 1] rỗng thì recursive = a[mini] - paintedHeight + 0 + strokesNeeded(mini + 1, right, a[mini])
Nếu [mini+1, right] rỗng thì recursive = a[mini] - paintedHeight + strokesNeeded(left, mini+1, a[mini]) + 0
Ngoài ra, ta còn phải kiểm tra xem rằng nếu ta sơn phân đoạn này hoàn toàn theo chiều dọc thì kết quả nhận được có nhỏ hơn là sơn ngang: allVertical = right - left + 1
Kết quả trả về sẽ là số nhỏ hơn trong hai cách sơn: return min(allVertical, recursive).
Hàm main:
Đọc n
Đọc n số trong hàng tiếp theo vào mảng a
In ra strokesNeeded(0, n-1, 0)
Độ phức tạp: O(n^2)O(n
​2
​​ ) với nn là số lượng phần tử mảng aa.

Mã nguồn tham khảo
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;
 
int n;
vector<int> a;
 
int strokesNeeded(int left, int right, int paintedHeight) {
    if (left > right)
        return 0;
 
    // find the index of the elements with the smallest value
    int mini = left;
    for (int i = left; i <= right; ++i) {
        if (a[i] < a[mini])
            mini = i;
    }
 
    // if we tried all vertical strokes
    int allVertical = right - left + 1;
 
    // if we tried horizontal strokes first then recursion
    int recursive = a[mini] - paintedHeight + strokesNeeded(left, mini - 1, a[mini]) + strokesNeeded(mini + 1, right, a[mini]);
 
    return min(allVertical, recursive);
}
 
int main() {
    scanf("%d", &n);
    int tmp;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &tmp);
        a.push_back(tmp);
    }
    printf("%d", strokesNeeded(0, n - 1, 0));
    return 0;
}
------java
import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
    private static int n;
    private static ArrayList<Integer> a = new ArrayList<Integer>();
 
    private static int strokesNeeded(int left, int right, int paintedHeight) {
        if (left > right) {
            return 0;
        }
 
        int mini = left;
        for (int i = left; i <= right; i++) {
            if (a.get(i) < a.get(mini)) {
                mini = i;
            }
        }
 
        int allVertical = right - left + 1;
        int recursive = a.get(mini) - paintedHeight + strokesNeeded(left, mini - 1, a.get(mini)) + strokesNeeded(mini + 1, right, a.get(mini));
 
        return Math.min(allVertical, recursive);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a.add(tmp);
        }
 
        System.out.println(strokesNeeded(0, n - 1, 0));
        sc.close();
    }
}
-------python3
import sys
 
 
def strokesNeeded(left, right, paintedHeight):
    if left > right:
        return 0
 
    mini = left + a[left:right+1].index(min(a[left:right+1]))
 
    allVerticle = right - left + 1
    recursive = a[mini] - paintedHeight + strokesNeeded(left, mini - 1, a[mini]) + strokesNeeded(mini + 1, right, a[mini])
 
    return min(allVerticle, recursive)
 
 
sys.setrecursionlimit(10000)
 
if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
 
    print(strokesNeeded(0, n - 1, 0))

 */
public class ORANGE_L04P02 {

}
