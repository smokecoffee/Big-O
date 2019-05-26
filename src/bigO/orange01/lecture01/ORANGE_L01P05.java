package bigO.orange01.lecture01;

/**
 * @author ThinkPad-PC
 *Beverages
Dilbert has just finished college and decided to go out with friends. Dilbert has some strange habits and thus he decided to celebrate this important moment of his life drinking a lot. He will start drinking beverages with low alcohol content, like beer, and then will move to a beverage that contains more alcohol, like wine, until there are no more available beverages. Once Dilbert starts to drink wine he will not drink beer again, so the alcohol content of the beverages never decreases with the time.

You should help Dilbert by indicating an order in which he can drink the beverages in the way he wishes.

Input
Each test case starts with 1 \le N \le 1001≤N≤100, the number of available beverages. Then will follow NN lines, informing the name of each beverage, a name has less than 5151 characters and has no white spaces. Then there is another line with an integer 0 \le M \le 2000≤M≤200 and MM lines in the form B_1B
​1
​​  B_2B
​2
​​  will follow, indicating that beverage B_2B
​2
​​  has more alcohol that beverage B_1B
​1
​​ , so Dilbert should drink beverage B_1B
​1
​​  before he starts drinking beverage B_2B
​2
​​ . Be sure that this relation is transitive, so if there is also a relation B_2B
​2
​​  B_3B
​3
​​  you should drink B_1B
​1
​​  before you can drink B_3B
​3
​​ . There is a blank line after each test case. In the case there is no relation between two beverages Dilbert should start drinking the one that appears first in the input. The input is terminated by end of file (EOF)

Output
For each test case you must print the message: Case #C: Dilbert should drink beverages in this order: B_1B
​1
​​  B_2B
​2
​​  ... B_NB
​N
​​ , where CC is the number of the test case, starting from 11, and B_1B
​1
​​  B_2B
​2
​​  ... B_NB
​N
​​  is a list of the beverages such that the alcohol content of beverage B_{i+1}B
​i+1
​​  is not less than the alcohol content of beverage B_{i-1}B
​i−1
​​ . After each test case you must print a blank line.

Ví dụ
input
3
vodka
wine
beer
2
wine vodka
beer wine

5
wine
beer
rum
apple-juice
cachaca
6
beer cachaca
apple-juice beer
apple-juice rum
beer rum
beer wine
wine cachaca

10
cachaca
rum
apple-juice
tequila
whiskey
wine
vodka
beer
martini
gin
11
beer whiskey
apple-juice gin
rum cachaca
vodka tequila
apple-juice martini
rum gin
wine whiskey
apple-juice beer
beer rum
wine vodka
beer tequila
output
Case #1: Dilbert should drink beverages in this order: beer wine vodka.

Case #2: Dilbert should drink beverages in this order: apple-juice beer wine rum cachaca.

Case #3: Dilbert should drink beverages in this order: apple-juice wine vodka beer rum cachaca tequila whiskey martini gin.
----------
Đây là một bài tập về sắp xếp topo. Ràng buộc "Nồng độ cồn của thức uống xx thấp hơn so với thức uống yy"" tương đương với cạnh một chiều từ đỉnh xx sang đỉnh yy trong đồ thị. Tuy nhiên, đề bài yêu cầu ta tìm thứ tự topo có thứ tự từ điển nhỏ nhất nên ta cần một vài chỉnh sửa trong thuật toán sắp xếp topo.

Trước hết, ta cần xử lí dữ liệu vào. Ta sẽ tạo một map (đối với C++) hoặc TreeMap (đối với Java) để lưu thứ tự trong danh sách của từng tên đồ uống. Với mỗi ràng buộc, ta sẽ tìm id_xid
​x
​​  và id_yid
​y
​​  lần lượt là thứ tự trong danh sách của từng xâu xx và yy, và thêm cạnh một chiều từ id_xid
​x
​​  sang id_yid
​y
​​ . Từ đó, ta thu được một đồ thị và thực hiện sắp xếp topo trên đồ thị này.

Ta sẽ áp dụng thuật toán Kahn (đã được trình bày trong slide của BigO) để thực hiện việc sắp xếp topo. Tuy nhiên, ta cần điều chỉnh lại thuật toán này: Với biến zero_indegree, thay vì sử dụng mảng động (vector), ta cần sử dụng hàng đợi ưu tiên (priority_queue). Bởi vì, theo yêu cầu của đề, nếu có nhiều đỉnh cùng có bậc 00, ta cần ưu tiên duyệt đỉnh có chỉ số nhỏ nhất. Do đó, khi lấy ra một đỉnh từ zero_indegree, ta cần lấy ra đỉnh có chỉ số nhỏ nhất.

Cuối cùng, ta in ra tên của các loại thức uống theo thứ tự topo tìm được. Độ phức tạp: \mathcal{O} \left( (N+M) \cdot \log(n) \right)O((N+M)⋅log(n)). với NN là số thức uống, MM là số ràng buộc.

Mã nguồn tham khảo

#include <iostream>
#include <map>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int V, E;

vector<int> topologicalSort(vector<vector<int>> &graph)
{
    vector<int> indegree(V, 0);
    vector<int> result;
    priority_queue<int, vector<int>, greater<int> > zero_indegree;

    for (int u = 0; u<V; u++)
    {
        vector<int>::iterator it;
        for (it = graph[u].begin(); it != graph[u].end(); it++)
            indegree[*it]++;
    }

    for (int i = 0; i < V; i++) {
        if (indegree[i]==0) {
            zero_indegree.push(i);
        }
    }

    while (!zero_indegree.empty())
    {
        int u = zero_indegree.top();
        zero_indegree.pop();

        result.push_back(u);

        vector<int>::iterator it;
        for (it = graph[u].begin(); it != graph[u].end(); it++)
        {
            indegree[*it]--;
            if (indegree[*it]==0) {
                zero_indegree.push(*it);
            }
        }
    }

    return result;
}

int main() {
    ios::sync_with_stdio(false);

    int iTest = 0;
    while (cin >> V) {
        ++iTest;

        vector<string> name(V);
        for(int u = 0; u < V; ++u)
            cin >> name[u];

        map<string, int> id;
        for(int u = 0; u < V; ++u)
            id[name[u]] = u;

        vector<vector<int>> graph;
        graph.assign(V, vector<int>());

        cin >> E;
        for(int i = 0; i < E; ++i) {
            string nameU, nameV;
            cin >> nameU >> nameV;
            int u = id[nameU], v = id[nameV];
            graph[u].push_back(v);
        }

        vector<int> topoOrd = topologicalSort(graph);

        cout << "Case #" << iTest << ": Dilbert should drink beverages in this order:";
        for(int u: topoOrd)
            cout << " " << name[u];
        cout << "." << endl;
        cout << endl;
    }

    return 0;
}

--------
from heapq import heappush, heappop

def topological_sort(graph, indegree, ordering):
    global N
    global names
    zero_indegree = []

    for u in range(N):
        if indegree[u] == 0:
            heappush(zero_indegree, u)
    
    while zero_indegree:
        u = heappop(zero_indegree)
        ordering.append(names[u])

        for v in graph[u]:
            indegree[v] -= 1
            if indegree[v] == 0:
                heappush(zero_indegree, v)

tc = 1
while True:
    try:
        N = int(input())
    except EOFError:
        exit()

    vertices = dict()
    names = []
    graph = [[] for _ in range(N)]
    indegree = [0] * N

    for i in range(N):
        beverage = input()
        vertices[beverage] = i
        names.append(beverage)

    M = int(input())
    for _ in range(M):
        beverage_1, beverage_2 = input().split()
        u, v = vertices[beverage_1], vertices[beverage_2]
        graph[u].append(v)
        indegree[v] += 1

    ordering = []
    topological_sort(graph, indegree, ordering)

    print('Case #{}: Dilbert should drink beverages in this order: '.format(tc), end='')
    print(*ordering, end='.\n\n')
    tc += 1
    input()
    
------------
import java.util.*;

class Solution_AC {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        ArrayList<Integer> indegree = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            indegree.add(0);
        }

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> zero_indegree = new PriorityQueue<>();
        for (int u = 0; u < V; ++u) {
            for (int v: graph.get(u)) {
                indegree.set(v, indegree.get(v) + 1);
            }
        }

        for (int i = 0; i < V; ++i) {
            if (indegree.get(i) == 0) {
                zero_indegree.add(i);
            }
        }

        while (!zero_indegree.isEmpty()) {
            int u = zero_indegree.peek();
            zero_indegree.remove();

            result.add(u);

            for (int v: graph.get(u)) {
                indegree.set(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0) {
                    zero_indegree.add(v);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTest = 0;
        while (sc.hasNext()) {
            int V = sc.nextInt();
            ++iTest;

            ArrayList<String> name = new ArrayList<>();
            for (int u = 0; u < V; ++u)
                name.add(sc.next());

            Map<String, Integer> id = new TreeMap<>();
            for (int u = 0; u < V; ++u)
                id.put(name.get(u), u);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; ++i) {
                graph.add(new ArrayList<>());
            }

            int E = sc.nextInt();
            for(int i = 0; i < E; ++i) {
                String nameU = sc.next(), nameV = sc.next();
                int u = id.get(nameU), v = id.get(nameV);
                graph.get(u).add(v);
            }

            ArrayList<Integer> topoOrd = topologicalSort(graph);

            System.out.print("Case #" + iTest + ": Dilbert should drink beverages in this order:");
            for (int u: topoOrd)
                System.out.print(" " + name.get(u));
            System.out.println(".");
            System.out.println();
        }
    }
}
    
 */
public class ORANGE_L01P05 {

}
