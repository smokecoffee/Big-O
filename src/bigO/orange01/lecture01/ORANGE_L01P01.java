package bigO.orange01.lecture01;

/**
 * @author ThinkPad-PC
 *Topological Sorting
Sandro is a well organised person. Every day he makes a list of things which need to be done and enumerates them from 11 to nn. However, some things need to be done before others. In this task you have to find out whether Sandro can solve all his duties and if so, print the correct order.

Input
In the first line you are given an integer nn and mm (1 \le n \le 100001≤n≤10000, 1 \le m \le 10000001≤m≤1000000). On the next mm lines there are two distinct integers xx and yy, (1 \le x, y \le 100001≤x,y≤10000) describing that job xx needs to be done before job yy.

Output
Print "Sandro fails." if Sandro cannot complete all his duties on the list. If there is a solution print the correct ordering, the jobs to be done separated by a whitespace. If there are multiple solutions print the one, whose first number is smallest, if there are still multiple solutions, print the one whose second number is smallest, and so on.

Ví dụ
input
8 9
1 4
1 2
4 2
4 3
3 2
5 2
3 5
8 2
8 6
output
1 4 3 5 7 8 2 6 
input
2 2
1 2
2 1

output
Sandro fails.
-------Huongdan
Ta xem NN công việc là NN đỉnh của đồ thị, còn MM cặp công việc là MM cạnh của đồ thị có hướng. Vì một số công việc sẽ thực hiện trước một vài công việc khác nên ta sẽ dùng Topological Sort để giải quyết bài toán này. Nhận xét :

Sandro sẽ không thực hiện được tất cả công việc nếu xuất hiện chu trình trong đồ thị.
Do yêu cầu đặc biệt nếu có nhiều công việc có cùng thứ tự thực hiện thì ta chọn công việc có số nhỏ nhất. Vậy để luôn chọn được công việc có số thứ tự nhỏ nhất thực hiện lúc đó ta cần cấu trúc dữ liệu thích hợp, ở đây ta chọn thuật toán Kahn và min heap để lưu các đỉnh có thể được chọn tiếp.
Vậy với thuật toán Kahn, ta cần danh sách đỉnh kề, mảng đếm số bậc vào còn lại của mỗi đỉnh và min heap các đỉnh có bậc vào hiện tại bằng 00.

Ta bắt đầu với việc xác định các đỉnh có số bậc vào bằng 00 và cho vào heap.
Khi mà heap vẫn còn các đỉnh chưa được xét, ta chọn đỉnh đầu tiên trong heap sẽ là đỉnh tiếp theo được in ra.
Đồng thời, khi đỉnh này được chọn ta giảm đi số bậc vào của các đỉnh kề từ đỉnh này. Nếu có bất kì đỉnh kề nào có bậc vào bằng 00 thì ta cho đỉnh này vào heap.
Kết quả cuối cùng sau khi kết thúc thuật Kahn sẽ là danh sách các công việc cần thực hiện theo thứ tự thỏa mãn.
Độ phức tạp: \mathcal{O} \left( N \cdot \log(N) + M \right)O(N⋅log(N)+M) với NN là số công việc cần thực hiện, MM là số cặp công việc phải thực hiện theo đúng thứ tự.
 */
/*
 * #include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

vector<int> topoSort(vector< vector<int> > &adj, vector<int> &indegree){
    int n = indegree.size();
    priority_queue<int, vector<int>, greater<int> > zero_indegree;
    vector<int> topoSorted;
    // vector<bool> avail(n, true);

    for (int i = 0; i < indegree.size(); i++)
        if (indegree[i] == 0){
            zero_indegree.push(i);
            // avail[i] = false;
        }


    while (!zero_indegree.empty()){
        int u = zero_indegree.top();
        zero_indegree.pop();

        topoSorted.push_back(u);

        for (int i = 0;i < adj[u].size(); i++){
            int v = adj[u][i];
            indegree[v] --;
            if (indegree[v] == 0){
                zero_indegree.push(v);
            }
        }
    }

    
    return topoSorted;
}

int main(){
    // n: number of vertices
    // m: number of edges
    int n, m, u, v;
    vector< vector<int> > adj;
    vector<int> indegree;
    scanf("%d %d", &n, &m);
    adj.resize(n);
    indegree.assign(n, 0);
    for (int i = 0; i < m; i++){
        scanf("%d %d", &u, &v);
        adj[u - 1].push_back(v - 1);
        indegree[v - 1] ++;
    }
    
    vector<int> res = topoSort(adj, indegree);
    if (res.size() < n){
        printf("Sandro fails.\n");
        return 0;
    }

    for (int i = 0; i < res.size(); i++)
        printf("%d ", res[i] + 1);
    printf("\n");

    return 0;
}

-------java
import java.util.*;

class Solution_kahn {
    public static int n, m;

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        PriorityQueue<Integer> zero_indegree = new PriorityQueue<Integer>();
        ArrayList<Integer> topoSorted = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                zero_indegree.add(i);
        }

        while (!zero_indegree.isEmpty()) {
            int u = zero_indegree.peek();
            zero_indegree.remove();

            topoSorted.add(u);

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);
                indegree[v]--;
                if (indegree[v] == 0)
                    zero_indegree.add(v);
            }
        }

        return topoSorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++)
            adj.add(i, new ArrayList<Integer>());
        int[] indegree = new int[n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u - 1).add(v - 1);
            indegree[v - 1]++;
        }

        ArrayList<Integer> res = topoSort(adj, indegree);
        if (res.size() < n)
        {
            System.out.print("Sandro fails.");
            return;
        }

        for (int i = 0; i < n; i++)
            System.out.printf("%d ", res.get(i) + 1);

        sc.close();
    }
}
--------python
import queue


def topoSort(adj, indegree):
    zero_indegree = queue.PriorityQueue()
    topoSorted = []

    for i in range(n):
        if indegree[i] == 0:
            zero_indegree.put(i)

    while not zero_indegree.empty():
        u = zero_indegree.get()
        topoSorted.append(u)
        for v in adj[u]:
            indegree[v] -= 1
            if indegree[v] == 0:
                zero_indegree.put(v)

    return topoSorted


def main():
    global n, m
    n, m = map(int, input().split())
    adj = [[] for _ in range(n)]
    indegree = [0 for _ in range(n)]

    for i in range(m):
        u, v = map(int, input().split())
        adj[u-1].append(v-1)
        indegree[v-1] += 1

    res = topoSort(adj, indegree)
    if (len(res) < n):
        print("Sandro fails.")
        return 0

    for i in range(n):
        print("{} ".format(res[i] + 1), end="")


if __name__ == "__main__":
    main()
    
 */
public class ORANGE_L01P01 {

}
