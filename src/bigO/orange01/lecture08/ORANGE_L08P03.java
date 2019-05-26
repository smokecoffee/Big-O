package bigO.orange01.lecture08;

/**
 * @author ThinkPad-PC
 *Oliver and the Game
Oliver and Bob are best friends. They have spent their entire childhood in the beautiful city of Byteland. The people of Byteland live happily along with the King.

The city has a unique architecture with total NN houses. The King's Mansion is a very big and beautiful bungalow having address = 1=1. Rest of the houses in Byteland have some unique address, (say AA), are connected by roads and there is always a unique path between any two houses in the city. Note that the King's Mansion is also included in these houses.

Oliver and Bob have decided to play Hide and Seek taking the entire city as their arena. In the given scenario of the game, it's Oliver's turn to hide and Bob is supposed to find him.

Oliver can hide in any of the houses in the city including the King's Mansion. As Bob is a very lazy person, for finding Oliver, he either goes towards the King's Mansion (he stops when he reaches there), or he moves away from the Mansion in any possible path till the last house on that path.

Oliver runs and hides in some house (say XX) and Bob is starting the game from his house (say YY). If Bob reaches house XX, then he surely finds Oliver.

Given QQ queries, you need to tell Bob if it is possible for him to find Oliver or not.

The queries can be of the following two types:

0 \ X \ Y0 X Y : Bob moves towards the King's Mansion.
1 \ X \ Y1 X Y : Bob moves away from the King's Mansion

Input
The first line of the input contains a single integer NN, total number of houses in the city. Next N - 1N−1 lines contain two space separated integers AA and BB denoting a road between the houses at address AA and BB.
Next line contains a single integer QQ denoting the number of queries.
Following QQ lines contain three space separated integers representing each query as explained above.

CONSTRAINS:

1 \le N \le 10^51≤N≤10
​5
​​ 
1 \le A,B \le N1≤A,B≤N
1 \le Q \le 5*10^51≤Q≤5∗10
​5
​​ 
1 \le X,Y \le N1≤X,Y≤N
Output
Print YES or NO for each query depending on the answer to that query.

Ví dụ
input
9
1 2
1 3
2 6
2 7
6 9
7 8
3 4
3 5
5
0 2 8
1 2 8
1 6 5
0 6 5
1 9 1
output
YES
NO
NO
NO
YES
Giải thích
Query 11 Bob goes from 88 towards 11 meeting 22 in the path. Query 22 Bob goes from 88 away from 11 and never meets 22. Query 33 Bob goes from 55 away from 11 and never meets 66. Query 44 Bob goes from 55 towards 11 and never meets 66. Query 55 Bob goes from 11 away from 11 and meets finds Oliver at 99. He can take the following two paths 1 \to 2 \to 6 \to 91→2→6→9 OR 1 \to 2 \to 7 \to 81→2→7→8, 99 appears in at least one of them

Hết thời gian làm bài. Bạn không thể tiếp tục nộp bài!
Giải thích ví dụ

Truy vấn 11 Bob đi từ 88 đến 11 gặp 22 trên đường đi. Truy vấn 22 Bob đi từ 88 theo hướng rời xa 11 và không bao giờ gặp được 22. Truy vấn 33 Bob đi từ 55 theo hướng rời xa 11 và không bao giờ gặp 66. Truy vấn 44 Bob đi từ 55 đến 11 và không gặp được 66. Truy vấn 55 Bob đi từ 11 theo hướng rời xa 11 và gặp Oliver ở 99. Anh ta có thể đi theo hai con đường sau 1 \to 2 \to 6 \to 91→2→6→9 hoặc 1 \to 2 \to 7 \to 81→2→7→8, 99 xuất hiện ít nhất một trong số chúng.

Hướng dẫn giải

Với đề bài ràng buộc rằng giữa hai ngôi nhà bất kỳ có duy nhất một con đường đi thì ta có thể đảm bảo rằng đồ thị của thành phố là một đồ thị không có chu trình. Với yêu cầu rằng từ YY tới 11 hay từ YY đi xa 11 có gặp XX trên đường đi hay không thì ta hoàn toàn có thể dùng DFS để duyệt. Tuy nhiên vì số lượng nhà có thể lên tới 10^510
​5
​​  và số lượng truy vấn cho mỗi cặp X \ YX Y là 5*10^55∗10
​5
​​  nên nếu chỉ đơn thuần dùng DFS có thể dẫn tới TLE. Để giải quyết vấn đề này ta có thể tối ưu bài toán bằng cách sử dụng thêm hai mảng start\_timestart_time và finish\_timefinish_time để lưu “thời điểm” bắt đầu và kết thúc việc duyệt một node trong đồ thị (một ngôi nhà). Nếu ngôi nhà XX có “thời điểm” bắt đầu và kết thúc nằm trong khoảng thời gian duyệt của ngôi nhà YY thì trên đường đi từ YY ta sẽ bắt gặp XX. Do vì với mỗi lượt truy vấn 0 \ X \ Y0 X Y thì ta sẽ đi từ YY tới 11 hay 1 \ X \ Y1 X Y thì ta đi từ YY rời xa 11, vậy ta sẽ duyệt DFS bắt đầu từ 11.

Bước 1: Xây dựng danh sách kề cho đồ thị thành phố. Đồng thời khởi tạo các biến t = 0t=0 (thời điểm duyệt một node trong đồ thị), start\_timestart_time (mảng chứa thời điểm bắt đầu duyệt một node) và finish\_timefinish_time (mảng chứa thời điểm kết thúc duyệt một node) với giá trị khởi tạo các phần tử bằng 00.

Bước 2: Duyệt DFS bắt đầu từ đỉnh 11 (Biệt thự của Nhà vua). Trong quá trình duyệt gọi hàm DFS với một đỉnh vv bất kỳ:

Tăng tt lên một đơn vị và gán vào start\_timestart_time của đỉnh vv (xem như đây là thời điểm bắt đầu duyệt đỉnh vv).
Duyệt qua các đỉnh kề của vv, nếu đỉnh kề nào của v có start\_timestart_time khác 00 (tức chưa duyệt qua lần nào) thì duyệt DFS tiếp từ đỉnh này.
Sau khi duyệt hết các đỉnh kề của vv thì tăng tt lên một đơn vị và gán vào finish\_timefinish_time của vv (xem đây như là thời điểm kết thúc duyệt đỉnh vv).
Bước 3:	Xử lý lần lượt từng truy vấn, với mỗi truy vấn:

Nếu là 1 \ X \ Y1 X Y thì swap XX và YY với nhau, do nếu là 0 \ X \ Y0 X Y thì ta xem thời điểm bắt đầu và kết thúc của YY có nằm trong khoảng thời gian duyệt của XX hay không (suy ra đường đi từ YY tới 11 sẽ gặp XX). Ngược lại 1 \ X \ Y1 X Y sẽ là thời gian duyệt của XX có nằm trong thời gian duyệt của YY hay không nên để thống nhất code ta swap XX và YY để chỉ cần kiểm tra thời gian duyệt YY có nằm trong thời gian duyệt XX.
Nếu như start\_time_Xstart_time
​X
​​  <= start\_time_Ystart_time
​Y
​​  và finish\_time_Xfinish_time
​X
​​  >= finish\_time_Yfinish_time
​Y
​​  thì in ra YES ngược lại in ra NO.
Độ phức tạp: O(max(V+E,Q))O(max(V+E,Q)) với VV là số đỉnh, EE là số cạnh của đồ thị và QQ là số truy vấn.
Mã nguồn tham khảo
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(vector<vector<int>> &graph, vector<int> &start_time, vector<int> &finish_time, int &t, int v)
{
    start_time[v] = ++t;
    for (int u : graph[v])
    {
        if (!start_time[u])
        {
            dfs(graph, start_time, finish_time, t, u);
        }
    }
    finish_time[v] = ++t;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n, q;
    cin >> n;
    vector<vector<int>> graph(n);
    for (int a, b, i = 0; i < n - 1; i++)
    {
        cin >> a >> b;
        a--;
        b--;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    int t = 0;
    vector<int> start_time(n, 0);
    vector<int> finish_time(n, 0);
    dfs(graph, start_time, finish_time, t, 0);
    cin >> q;
    for (int s, a, b, i = 0; i < q; ++i)
    {
        cin >> s >> a >> b;
        --a;
        --b;
        if (s == 1)
            swap(a, b);
        if (start_time[a] <= start_time[b] && finish_time[a] >= start_time[b])
        {
            cout << "YES" << endl;
        }
        else
        {
            cout << "NO" << endl;
        }
    }
}
 */
public class ORANGE_L08P03 {

}
