package bigO.orange01.lecture04;

/**
 * @author ThinkPad-PC
 
 Distance in Tree
A tree is a connected graph that doesn't contain any cycles.

The distance between two vertices of a tree is the length (in edges) of the shortest path between these vertices.

You are given a tree with nn vertices and a positive number kk. Find the number of distinct pairs of the vertices which have a distance of exactly kk between them. Note that pairs (v, u)(v,u) and (u, v)(u,v) are considered to be the same pair.

Input
The first line contains two integers nn and kk (1 \le n \le 50000, 1 \le k \le 500)(1≤n≤50000,1≤k≤500) — the number of vertices and the required distance between the vertices.

Next n - 1n−1 lines describe the edges as a_ia
​i
​​  b_ib
​i
​​  (1 \le a_i, b_i \le n, a_i \neq b_i)(1≤a
​i
​​ ,b
​i
​​ ≤n,a
​i
​​ ≠b
​i
​​ ) , where a_ia
​i
​​  and b_ib
​i
​​  are the vertices connected by the i^{th}i
​th
​​  edge. All given edges are different.

Output
Print a single integer — the number of distinct pairs of the tree's vertices which have a distance of exactly kk between them.

Ví dụ
input
5 2
1 2
2 3
3 4
2 5
output
4
input
5 3
1 2
2 3
3 4
4 5

output
2
--------Giải thích
In the first sample the pairs of vertexes at distance 2 from each other are (1, 3), (1, 5), (3, 5) and (2, 4).

-----------
Giải thích ví dụ:

Ví dụ 1:
Các cặp đỉnh có khoảng cách bằng 2 là (1, 3), (1, 5), (3, 5) và (2, 4). 

Ví dụ 2:
Các cặp đỉnh có khoảng cách bằng 3 là (1, 4), (2, 5). 

Hướng dẫn giải:

Cách 1:

Gỉa sử chúng ta đã có một cây đã được định hướng (tức là có một đỉnh làm gốc). Để đơn giản, ta coi gốc của cây là 11.
Ta chia nhỏ bài toán như sau: Kết quả của bài toán với cây con gốc uu bất kì sẽ bằng số lượng đường đi độ dài kk đi qua uu (nhưng chỉ bắt đầu và kết thúc trong cây con gốc uu) cộng với kết quả của các bài toán con trên mỗi cây con trực tiếp của uu.

Ví dụ: Với đồ thị dưới, ta coi gốc là 11, vậy nút con của 11 là 22, các nút con của 22 là 33 và 55 và con của 33 là 44. Giả sử k = 2k=2, khi xét tới đỉnh u = 2u=2 thì những đường đi hợp lệ là 4 \leftrightarrow↔ 2 và 3 \leftrightarrow↔ 5. Đường đi 1 \leftrightarrow↔ 3 và 1 \leftrightarrow↔ 5 ta chỉ xét khi đứng ở đỉnh u = 1u=1 nên không cần xét ở đây nữa. 
Xét hàm cal_nodes(u) là hàm trả về một danh sách k + 1k+1 phần tử, trong đó phần tử thứ ii (0 \le i \le k)(0≤i≤k) là số lượng nút trong cây con gốc uu có khoảng cách tới uu bằng đúng ii.
Ví dụ: với đồ thị trên và u = 2u=2, danh sách này là \{1, 2, 1\}{1,2,1} (số đỉnh có khoảng cách tới 22 là 00 - tức 22; 22 đỉnh có khoảng cách là 11 - tức 33 và 55; và 11 đỉnh có khoảng cách là 22 - tức đỉnh 44).
Chúng ta sẽ tính cal_nodes(u) bằng nhận xét: số đỉnh trong cây con gốc uu có khoảng cách tới uu là ii bằng tổng số đỉnh trong các cây con gốc vv có khoảng cách tới vv là i - 1i−1 (với vv là đỉnh con của uu).
Ngoài ra, hàm cal_nodes(u) cũng sẽ tính số lượng đường đi qua đỉnh uu mà chỉ bắt đầu và kết thúc trong cây con gốc uu. Như vậy, các bước trong cal_nodes(u) là:
Gọi count_ucount
​u
​​  là mảng kết quả cần tính. Ban đầu .
Khi xét tới đỉnh con vv của uu:
Tính count_ucount
​u
​​  = cal_nodes(v).
Với mỗi ii từ 00 tới k – 1, cộng count_u[i] * count_u[k - 1 - i]count
​u
​​ [i]∗count
​u
​​ [k−1−i] vào kết quả bài toán. Đây là tổ hợp các đường đi bắt đầu trong các cây con trước đó của uu, có khoảng cách tới uu là ii, và kết thúc trong cây con gốc vv, có khoảng cách tới vv là k - 1 - ik−1−i.
Sau đó, cập nhật count_u[i] += count_v[i - 1]count
​u
​​ [i]+=count
​v
​​ [i−1] với mọi ii từ 11 tới kk.
Cuối cùng, trả về count_ucount
​u
​​ .
Độ phức tạp: O(N * KO(N∗K) với NN là số lượng đỉnh trong cây và KK là khoảng cách yêu cầu.

Cách 2: Sử dụng kỹ thuật Centroid Decomposition

Centroid decomposition là kỹ thuật biến đổi cây thành một cây “cân bằng”, cụ thể là số phần tử trong mỗi cây con của một nút luôn không vượt quá một nửa số lượng nút trong cây con của nút đó. Sử dụng Centroid Decomposition, bài toán này có thể được giải khi KK đạt tới NN.
Giả sử ta đã biến đổi đồ thị ban đầu thành một Centroid tree. Điểm khác biệt trong việc chia nhỏ bài toán ở đây là các bài toán con được giải trên các cây con của uu trong Centroid tree, chứ không phải trong đồ thị ban đầu.
Ta định nghĩa hàm cal_nodes(u) với ý nghĩa tương tự như cách 1, tuy nhiên hàm này chỉ đếm đơn giản bằng DFS hoặc BFS. Lưu ý bây giờ cal_nodes nên trả về một hash table để tránh thời gian khởi tạo kích thước ban đầu.
Bài toán của chúng ta sẽ được giải từ gốc uu của Centroid tree:

Thực hiện các bước như trong hàm cal_nodes() ở cách 1 để đếm số lượng đường đi độ dài kk bắt đầu và kết thúc trong cây Centroid gốc uu.
Sau đó giải quyết các bài toán nhỏ hơn trên các cây Centroid con của uu.
Thuật toán xây dựng Centroid tree:

Ban đầu ta cũng định hướng đồ thị với gốc là 11, đồng thời tính số lượng đỉnh trong mỗi cây con gốc uu, ký hiệu là size[u].
Điều kiện để đỉnh uu là Centroid của cây đang xét là: max(Nmax(N - size[u], size[v_1], size[v_2]size[u],size[v
​1
​​ ],size[v
​2
​​ ],…) \le \frac{n}{2}≤
​2
​
​n
​​  (NN là số lượng đỉnh trong cây đang xét, và v_1, v_2v
​1
​​ ,v
​2
​​ ... là các đỉnh con của uu).
Như vậy để tìm Centroid trong đồ thị hiện có, ta bắt đầu từ gốc, nếu gốc không thỏa điều kiện là Centroid thì ta sẽ tìm trên cây con nhiều đỉnh nhất của gốc, lặp lại cho đến khi gặp Centroid.
Thuật toán để xây dựng Centroid tree:
Định nghĩa hàm decompose_tree(u) là hàm phân rã cây con gốc uu thành Centroid tree và trả về gốc của nó.
Trong decompose_tree(u):
Tìm Centroid cc trong cây hiện tại, đánh dấu cc là Centroid, giảm sizesize của các tổ tiên của cc đi một lượng là size[c]size[c].
Cho các đỉnh con của cc trong Centroid tree mới là decompose_tree(), decompose_tree(),… và decompose_tree(u) (nếu uu khác cc) với , ,... là các đỉnh con của cc trong cây hiện tại.
Độ phức tạp: O(NlogN)O(NlogN) với NN là số lượng đỉnh trong cây. Việc dựng Centroid tree được thực hiện trong O(NlogN)O(NlogN) do cây kích thước NN sẽ cần chia logNlogN lần, và để tìm Centroid trên mỗi cây kích thước NN thì cần chi phí O(N)O(N). Ngoài ra tổng chi phí khi gọi hàm cal_nodes() với mỗi đỉnh gốc cũng là O(N)O(N) với NN là kích thước cây gốc đó.

Mã nguồn tham khảo
-------java8
import java.io.*;
import java.util.*;
 
public class Main {
    static class Graph {
        public ArrayList<ArrayList<Integer>> adj;
 
        public Graph(int n) {
            adj = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                adj.add(new ArrayList<Integer>());
            }
        }
 
        public void add_2way_edge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    };
 
    static int res = 0, k;
    static int[] cal_nodes(Graph graph, int root, int par) {
        // reuse is_centroid as visited
 
        // the depth may be much less than k so dont need to initialize a vector of k
        int[] count = new int[k + 1]; 
        Arrays.fill(count, 0);
        count[0] = 1; // dist(root, root) = 0
 
        // count paths that starts and ends in decomposed graph rooted at root, and goes through root
        // O(N) in total
        for (int v : graph.adj.get(root)) {
            if (v != par) {
                int[] count_v = cal_nodes(graph, v, root);
 
                for (int i = 0; i < k; ++i) {
                    res += count[i] * count_v[k - 1 - i];
                }
 
                for (int i = 1; i <= k; ++i) {
                    count[i] += count_v[i - 1];
                }
            }
        }
 
        return count;
    }
 
    public static void main(String[] arg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        Graph graph = new Graph(n);
        for (int i = 1, x, y; i < n; ++i) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            graph.add_2way_edge(x, y);
        }
 
        cal_nodes(graph, 0, -1);
        System.out.print(res);
    }
}
----cpp14
#include <bits/stdc++.h>
using namespace std;

struct Graph {
    vector<vector<int>> adj;
    Graph(int n): adj(n) {}
    void add_edge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
};

int n, k, res;
vector<int> cal_nodes(Graph& graph, int u, int par) {
    vector<int> count(k + 1);
    count[0] = 1;

    for (int v : graph.adj[u]) {
        if (v != par) {
            vector<int> count_v = cal_nodes(graph, v, u);

            for (int i = 0; i < k; ++i) {
                res += count[i] * count_v[k - 1 - i];
            }

            for (int i = 1; i <= k; ++i) {
                count[i] += count_v[i - 1];
            }
        }
    }

    return count;
}

int main() {
    cin >> n >> k;
    Graph graph(n);
    for (int i = 1, x, y; i < n; ++i) {
        cin >> x >> y;
        graph.add_edge(x - 1, y - 1);
    }

    cal_nodes(graph, 0, -1);

    cout << res;
}
-------python3
import sys
sys.setrecursionlimit(1000000)
def get(graph, u, par):
    count = {0: 1}
    res = 0
    for v in graph[u]:
        if v != par:
            res_v, count_v = get(graph, v, u)
            res += res_v

            count_v[-1] = 0

            for key, val in count_v.items():
                res += val * count.get(k - 1 - key, 0)

            for key, val in count_v.items():
                count[key + 1] = count.get(key + 1, 0) + val
    
    return res, count

n, k = map(int, input().split())

graph = [[] for i in range(n)]
for i in range(n - 1):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    graph[x].append(y)
    graph[y].append(x)

print(get(graph, 0, -1)[0])
 */
public class ORANGE_L04P03 {

}
