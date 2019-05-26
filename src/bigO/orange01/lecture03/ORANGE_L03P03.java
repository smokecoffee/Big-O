package bigO.orange01.lecture03;

/**
 * @author ThinkPad-PC
 *
 *Digger Octaves
After many years spent playing Digger, little Ivan realized he was not taking advantage of the octaves. Oops, sorry! Most of you were not born when Digger came to light!

Digger is a Canadian computer game, originally designed for the IBM personal computer, back in 1983. The aim of the game is to collect precious gold and emeralds buried deep in subterranean levels of an old abandoned mine.

We Digger gurus call a set of eight consecutive emeralds an octave. Notice that, by consecutive we mean that we can collect them one after another. Your Digger Mobile is able to move in the four directions: North, South, West and East.

In a simplified Digger version, consisting only of emeralds and empty spaces, you will have to count how many octaves are present for a given map.

Input
Input starts with an integer TT, representing the number of test cases (1 \le T \le 201≤T≤20). Each test case consists of a map, described as follows:

An integer NN (1 \le N \le 81≤N≤8), representing the side length of the square-shaped map. NN lines follow, NN characters each. A X character represents an emerald, and a . represents an empty space.

Output
For each test case print the number of octaves on a single line.

Ví dụ
input
2
3
XXX
X.X
XXX
3
XXX
XXX
XXX
output
1
5
----------
Vì N \le 8N≤8 nên ta chỉ có tối đa 6464 ô, và vì trạng thái của các ô chỉ có thể là X hoặc . nên ta có thể quy thành các số trong dãy bit, với 11 là X và 00 là .

Ta đánh số các ô trên bảng từ 00 đến N^2 - 1N
​2
​​ −1 theo thứ tự từ trên xuống dưới và từ trái sang phải. Như vậy, giả sử để biểu diễn trạng thái {XXX, X.X, XXX}, dãy bit của ta chính là 111101111111101111. Ta thực hiện duyệt DFS trên bảng này, với một ô xuất phát là ô (i,j)(i,j), ta gọi hàm DFS(step, x, y) với ý nghĩa: Hiện tại đang đứng tại ô (x,y)(x,y) là một ô có chứa lục bảo, stepstep là số lượng lục bảo hiện tại. Nếu step = 8step=8, điều này đồng nghĩa với việc ta đã có một hành trình thu đủ 88 lục bảo, ta sẽ đưa trạng thái dãy bit thỏa mãn ở trên vào set nhằm mục đích loại bỏ những trạng thái giống nhau. Ngược lại, ta sẽ thăm tiếp đỉnh kề (nx, ny)(nx,ny) với (x, y)(x,y) với step thêm 11 đơn vị. Sau đó, ta hủy vết đã đánh dấu ở ô (nx, ny)(nx,ny) để tiến hành tìm một đường đi khác.

Kết quả là kích thước của set.

Độ phức tạp: Trong trường hợp xấu nhất, ta có 64 lựa chọn cho đỉnh bắt đầu. Mỗi bước tiếp theo có 4 hướng đi, nhưng phải loại bỏ hướng từ bước trước đó nên còn lại 3 lựa chọn. Vậy số trạng thái tối đa có thể tạo thành là O(64*3^7)O(64∗3
​7
​​ )

Mã nguồn tham khảo
------cpp14
#include <iostream>
#include <set>
using namespace std;
const int MAX = 10;
const int dx[] = {0, 0, 1, -1};
const int dy[] = {1, -1, 0, 0};

char graph[MAX][MAX];
bool visited[MAX][MAX];
int n;
set<long long> octaves;

bool onBoard(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
}

void dfs(int sx, int sy, int step, long long bits) {
    visited[sx][sy] = true;
    bits |= 1LL << (sx * n + sy);

    if (step == 8) {
        octaves.insert(bits);
    }
    else {
        for (int i = 0; i < 4; i++) {
            int x = sx + dx[i];
            int y = sy + dy[i];

            if (onBoard(x, y) && !visited[x][y] && graph[x][y] == 'X') {
                dfs(x, y, step + 1, bits);
            }
        }
    }

    bits &= ~(1 << (sx * n + sy));
    visited[sx][sy] = false;
}

int main() {
    int t;
    long long bits;
    cin >> t;

    for (int tc = 0; tc < t; tc++) {
        cin >> n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> graph[i][j];
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'X') {
                    bits = 0;
                    dfs(i, j, 1, bits);
                }
            }
        }

        cout << octaves.size() << endl;
        octaves.clear();
    }
    return 0;
}
-------java
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static final int MAX = 10;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static String[] graph = new String[MAX];
    static boolean[][] visited = new boolean[MAX][MAX];
    static TreeSet<Long> octaves;
    static int n;

    static boolean onBoard(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void dfs(int sx, int sy, int step, long bits) {
        visited[sx][sy] = true;
        bits |= 1L << (sx * n + sy);

        if (step == 8) {
            octaves.add(bits);
        }
        else {
            for (int i = 0; i < 4; i++) {
                int x = sx + dx[i];
                int y = sy + dy[i];

                if (onBoard(x, y) && !visited[x][y] && graph[x].charAt(y) == 'X') {
                    dfs(x, y, step + 1, bits);
                }
            }
        }

        bits &= ~(1 << (sx * n + sy));
        visited[sx][sy] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long bits;

        for (int tc = 0; tc < t; tc++) {
            n = sc.nextInt();
            octaves = new TreeSet<Long>();

            for (int i = 0; i < n; i++) {
                graph[i] = sc.next();
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i].charAt(j) == 'X') {
                        bits = 0;
                        dfs(i, j, 1, bits);
                    }
                }
            }

            System.out.println(octaves.size());
        }
    }
}
--------python
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(sx, sy, step, bits):
    global octaves, graph, n, visited
    visited[sx][sy] = True
    bits |= 1 << (sx * n + sy)

    if step == 8:
        octaves.add(bits)
    else:
        for i in range(4):
            x, y = sx + dx[i], sy + dy[i]
            if x in range(n) and y in range(n) and not visited[x][y] and graph[x][y] == 'X':
                dfs(x, y, step + 1, bits)
                
    bits &= ~(1 << (sx * n + sy))
    visited[sx][sy] = False
    

t = int(input())
for _ in range(t):
    n = int(input())
    visited = [[False] * n for i in range(n)]
    graph = []
    octaves = set()

    for i in range(n):
        graph.append(input())
    
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 'X':
                bits = 0
                dfs(i, j, 1, bits)

    print(len(octaves))
    
 */
public class ORANGE_L03P03 {

}
