package bigO.orange01.lecture01;

/**
 * @author ThinkPad-PC
 *Hierarchy
A group of graduated students decided to establish a company; however, they don't agree on who is going to be who's boss.

Generally, one of the students will be the main boss, and each of the other students will have exactly one boss (and that boss, if he is not the main boss, will have a boss of his own too). Every boss will have a strictly greater salary than all of his subordinates - therefore, there are no cycles. Therefore, the hierarchy of the company can be represented as a rooted tree.

In order to agree on who is going to be who's boss, they've chosen KK most successful students, and each of them has given a statement: I want to be the superior of him, him, and him (they could be successful or unsuccessful). And what does it mean to be a superior? It means to be the boss, or to be one of the boss' superiors (therefore, a superior of a student is not necessary his direct boss).

Help this immature company and create a hierarchy that will satisfy all of the successful students' wishes. A solution, not necessary unique, will exist in all of the test data.

Input
In the first line of input, read positive integers NN (N \le 100000N≤100000), total number of students, and KK (K < NK<N), the number of successful students. All students are numbered 1..N1..N, while the successful ones are numbered 1..K1..K. Then follow KK lines. In A^{th}A
​th
​​  of these lines, first read an integer WW (the number of wishes of the student AA, 1 \le W \le 101≤W≤10), and then WW integers from the range [1, N][1,N] which denote students which student AA wants to be superior to.

Output
Output NN integers. The A^{th}A
​th
​​  of these integers should be 00 if student AA is the main boss, and else it should represent the boss of the student AA.

Ví dụ
input
4 2
1 3
2 3 4

output
4
0
1
2

input
7 4
2 2 3
1 6
1 7
2 1 2

output
4
7
1
5
0
2
3
Xây dựng một đồ thị có hướng không trọng số tương ứng với các nguyện vọng của KK người xuất sắc nhất: có cạnh nối u \rightarrow vu→v khi người uu muốn làm cấp trên của vv. Đồ thị này không có chu trình nên có thể sắp xếp Topo được. Gọi TT là thứ tự Topo của đồ thị vừa xây dựng. Theo định nghĩa thì nếu có cạnh nối u \rightarrow vu→v thì uu sẽ đứng trước vv trong TT. Điều này có nghĩa là với mỗi người uu, tất cả những người cấp dưới mà uu muốn đều nằm sau uu trong TT.

Cách xây dựng cây phân cấp đơn giản nhất là xây dựng theo thứ tự T:

T_1T
​1
​​  làm sếp tổng \leftrightarrow boss(T_1) = -1↔boss(T
​1
​​ )=−1.
Sếp của T_2T
​2
​​  là T_1T
​1
​​  \leftrightarrow boss(T_2) = T_1↔boss(T
​2
​​ )=T
​1
​​ .
Sếp của T_3T
​3
​​  là T_2T
​2
​​  \leftrightarrow boss(T_3) = T_2↔boss(T
​3
​​ )=T
​2
​​ .
…
Sếp của T_NT
​N
​​  là T_{N-1}T
​N−1
​​  \leftrightarrow boss(T_N) = T_{N-1}↔boss(T
​N
​​ )=T
​N−1
​​ .
Cuối cùng mảng boss chính là kết quả cần xuất ra màn hình.

Độ phức tạp: \mathcal{O} \left( N + sum({W_i}) \right)O(N+sum(W
​i
​​ )). với NN là số người trong công ty và W_iW
​i
​​  là số người cấp dưới mà người i chọn.

---------Mã nguồn tham khảo
#include <bits/stdc++.h>
using namespace std;

void dfs(int u, const vector<vector<int>> &graph, vector<bool> &visited, vector<int> &result) {
    visited[u] = true;
    for (int i = 0; i < graph[u].size(); i++) {
        int v = graph[u][i];
        if (!visited[v]) {
            dfs(v, graph, visited, result);
        }
    }
    result.push_back(u);
}

vector<int> topologicalSort(const vector<vector<int>> &graph) {
    int V = graph.size();
    vector<int> result;
    result.reserve(V);
    vector<bool> visited(V, false);

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            dfs(i, graph, visited, result);
        }
    }
    std::reverse(result.begin(), result.end());
    return result;
}

int main() {
    int n, k;
    scanf("%d%d", &n, &k);
    vector<vector<int>> graph(n);
    for (int u = 0; u < k; ++u) {
        int w, v;
        scanf("%d", &w);
        while (w--) {
            scanf("%d", &v);
            graph[u].push_back(v - 1);
        }
    }

    auto topo_order = topologicalSort(graph);
    vector<int> boss(n);
    boss[topo_order[0]] = -1;
    for (int i = 1; i < n; ++i) {
        boss[topo_order[i]] = topo_order[i - 1];
    }
    
    for (int i = 0; i < n; ++i) {
        printf("%d\n", boss[i] + 1);
    }
}
--------java
--------python




 */
public class ORANGE_L01P02 {

}
