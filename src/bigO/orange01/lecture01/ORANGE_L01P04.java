package bigO.orange01.lecture01;

/**
 * @author ThinkPad-PC
 *Answer the boss!
Eloy is a hard worker man, however, he is constantly bullied by his superiors, molested by this, one day he was wondering in what "rank" you are, so you can bully the people with lower ranks, also to discover who can really bully Eloy!.

Now, given the number of employees and the number of relations between them, Eloy need you to output the "rank" which employee is in, being 11 the "boss" (not bullied by anybody) and the employee who are in these ranks.

Input
There will be an integer TT denoting the test cases, then, TT test cases will follow, each test case starts with two integers NN and RR, the number of employees and the number of relations between them, the next RR lines consists in two integers R_1R
​1
​​  and R_2R
​2
​​ , meaning that "employee R_1R
​1
​​  is lower than employee R_2R
​2
​​ 's rank".

CONSTRAINTS: 1 \le N \le 10001≤N≤1000, 1 \le R \le 100001≤R≤10000

Output
You will output for each test case the string "Scenario #i:"" where ii is the test case you are analyzing, after that, you will print NN lines, for each line you will output the rank of the employee and the employee itself, if there is the same rank for several employees, then output them lexicographically ordered (the first is the lower)

Ví dụ
input
2
5 6
2 0
2 4
1 4
1 2
3 2
4 0
5 4
1 0
2 0
3 2
4 2

output
Scenario #1:
1 0
2 4
3 2
4 1
4 3
Scenario #2:
1 0
2 1
2 2
3 3
3 4
-----------------
Ta nhận xét rằng đây là một đồ thị có hướng và không có chu trình đơn, vì sẽ không có chuyện người AA cấp bậc cao hơn người BB, người BB cấp bậc cao hơn người CC và người CC lại có cấp bậc cao hơn người AA được.
Trước hết, ta lưu ý về việc tạo đồ thị, khi ta nhập đỉnh uu và vv. Vì uu là cấp bậc nhỏ hơn vv cho nên ta phải thêm một cạnh 11 chiều nối từ vv sang uu chứ không phải từ uu sang vv.
Ta gọi indeg_uindeg
​u
​​  là số lượng đỉnh mà nối trực tiếp đến uu. Như vậy khi ta đọc nối cạnh từ vv sang uu, ta tăng indeg_uindeg
​u
​​  lên 11 đơn vị.
Ta sử dụng thuật toán Kahn để thực hiện việc sắp xếp Topo trên đồ thị.
Với mỗi đỉnh ii có indeg_i = 0indeg
​i
​​ =0, tức là đỉnh này không có đỉnh nào làm đỉnh đầu vào, ta sẽ khởi gán đỉnh ii này có rank là 11, đồng thời tiến hành duyệt dfs từ đỉnh ii.
Với mỗi đỉnh uu từ stack , ta duyệt mọi đỉnh vv là đỉnh kề của uu, và cập nhật rank_vrank
​v
​​  là rank cao nhất với mọi rank_u + 1rank
​u
​​ +1.
Ta lưu toàn bộ cặp <rank_u, u><rank
​u
​​ ,u> vào một mảng động và sắp xếp chúng tăng dần theo thứ tự rank, nếu rank bằng nhau thì ta sắp xếp tăng dần theo đỉnh.
Kết quả là mọi cặp <rank_u, u><rank
​u
​​ ,u> in ra từ mảng động đó.
Độ phức tạp: \mathcal{O} \left( V + E \right)O(V+E). với VV là số lượng đỉnh và EE là số lượng cạnh.

Mã nguồn tham khảo
-------cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Employee {
    int index;
    int rank;

    Employee(int index, int rank) : index(index), rank(rank) {}
};

void dfs(int u, vector<vector<int>>& adj, vector<int>& visited, vector<int>& topoOrder) {
    visited[u] = 1;

    for (int v : adj[u]) {
        if (!visited[v]) {
            dfs(v, adj, visited, topoOrder);
        }
    }

    topoOrder.push_back(u);
}

vector<int> topoSort(vector<vector<int>>& adj) {
    vector<int> topoOrder;
    int n = adj.size();
    vector<int> visited(n, 0);

    for (int u = 0; u < n; u++) {
        if (!visited[u]) {
            dfs(u, adj, visited, topoOrder);
        }
    }

    reverse(topoOrder.begin(), topoOrder.end());

    return topoOrder;
}

void solveTest(int testNumber) {
    int n, r;
    cin >> n >> r;

    vector<vector<int>> adj(n, vector<int>());
    vector<int> inDeg(n, 0);

    for (int i = 0; i < r; i++) {
        int u, v;
        cin >> u >> v;
        adj[v].push_back(u);
        ++inDeg[u];
    }

    vector<int> topoOrder = topoSort(adj);
    vector<int> rank(n);

    for (int u  : topoOrder) {
        if (inDeg[u] == 0) {
            rank[u] = 1;
        }
        for (int v : adj[u]) {
            rank[v] = max(rank[v], rank[u] + 1);
        }
    }

    vector<Employee> employees;

    for (int u = 0; u < n; u++) {
        employees.push_back(Employee(u, rank[u]));
    }

    sort(employees.begin(), employees.end(), [](const Employee& e1, const Employee& e2) {
        if (e1.rank == e2.rank) {
            return e1.index < e2.index;
        }
        return e1.rank < e2.rank;
    });
    
    cout << "Scenario #" << testNumber << ":\n";

    for (Employee& e : employees) {
        cout << e.rank << ' ' << e.index << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);

    int t;
    cin >> t;

    for (int testNumber = 1; testNumber <= t; testNumber++) {
        solveTest(testNumber);
    }    

    return 0;
}

------java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
    static Scanner in;
    static PrintWriter out;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);

        int t = in.nextInt();

        for (int testNumber = 1; testNumber <= t; testNumber++) {
            solveTest(testNumber);
        }

        out.close();
    }

    static void solveTest(int testNumber) {
        int n = in.nextInt();
        int r = in.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[n];

        for (int u = 0; u < n; u++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < r; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(v).add(u);
            ++inDeg[u];
        }

        ArrayList<Integer> topoOrder = topoSort(adj);
        int[] rank = new int[n];

        for (int u : topoOrder) {
            if (inDeg[u] == 0) {
                rank[u] = 1;
            }
            for (int v : adj.get(u)) {
                rank[v] = Math.max(rank[v], rank[u] + 1);
            }
        }

        ArrayList<Employee> employees = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            employees.add(new Employee(u, rank[u]));
        }

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                if (e1.rank == e2.rank) {
                    return Integer.compare(e1.index, e2.index);
                }
                return Integer.compare(e1.rank, e2.rank);
            }
        });


        out.println("Scenario #" + testNumber + ":");

        for (Employee e : employees) {
            out.println(e.rank + " " + e.index);
        }
    }

    static ArrayList<Integer> topoSort(List<List<Integer>> adj) {
        ArrayList<Integer> topoOrder = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];

        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                dfs(u, adj, visited, topoOrder);
            }
        }

        Collections.reverse(topoOrder);

        return topoOrder;
    }

    static void dfs(int u, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> topoOrder) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, topoOrder);
            }
        }

        topoOrder.add(u);
    }

    static class Employee {
        int index;
        int rank;

        Employee(int index, int rank) {
            this.index = index;
            this.rank = rank;
        }
    }
}
------python
def main():
    t = int(input())
    for testNumber in range(1, t + 1):
        solveTest(testNumber)


def solveTest(testNumber):
    n, r = map(int, input().split())

    adj = [[] for u in range(n)]
    in_deg = [0 for u in range(n)]

    for i in range(r):
        u, v = map(int, input().split())
        adj[v].append(u)
        in_deg[u] += 1
    
    topo_order = topo_sort(adj)
    rank = [0 for i in range(n)]

    for u in topo_order:
        if in_deg[u] == 0:
            rank[u] = 1
        for v in adj[u]:
            rank[v] = max(rank[v], rank[u] + 1)
    
    employees = [Employee(u, rank[u]) for u in range(n)]
    employees.sort(key=lambda e: (e.rank, e.index))

    print("Scenario #{0}:".format(testNumber))

    for e in employees:
        print("{0} {1}".format(e.rank, e.index))
    

def topo_sort(adj):
    topo_order = []
    n = len(adj)
    visited = [False for u in range(n)]

    for u in range(n):
        if not visited[u]:
            dfs(u, adj, visited, topo_order)
    
    topo_order.reverse()

    return topo_order


def dfs(u, adj, visited, topo_order):
    visited[u] = True

    for v in adj[u]:
        if not visited[v]:
            dfs(v, adj, visited, topo_order)
    
    topo_order.append(u)


class Employee:
    def __init__(self, index, rank):
        self.index = index
        self.rank = rank


if __name__ == "__main__":
    main()
 */
public class ORANGE_L01P04 {

}
