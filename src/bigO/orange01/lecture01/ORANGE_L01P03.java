package bigO.orange01.lecture01;

/**
 * @author ThinkPad-PC
 *
Fox and Names
Fox Ciel is going to publish a paper on FOCS (Foxes Operated Computer Systems, pronounce: "Fox"). She heard a rumor: the authors list on the paper is always sorted in the lexicographical order.

After checking some examples, she found out that sometimes it wasn't true. On some papers authors' names weren't sorted in lexicographical order in normal sense. But it was always true that after some modification of the order of letters in alphabet, the order of authors becomes lexicographical!

She wants to know, if there exists an order of letters in Latin alphabet such that the names on the paper she is submitting are following in the lexicographical order. If so, you should find out any such order.

Lexicographical order is defined in following way. When we compare ss and tt, first we find the leftmost position with differing characters: s_i \neq t_is
​i
​​ ≠t
​i
​​ . If there is no such position (i. e. ss is a prefix of tt or vice versa) the shortest string is less. Otherwise, we compare characters s_is
​i
​​  and t_it
​i
​​  according to their order in alphabet.

Input
The first line contains an integer nn (1 \le n \le 1001≤n≤100): number of names.

Each of the following nn lines contain one string name_iname
​i
​​  (1 \le |{name_i}| \le 1001≤∣name
​i
​​ ∣≤100), the i_{th}i
​th
​​  name. Each name contains only lowercase Latin letters. All names are different.

Output
If there exists such order of letters that the given names are sorted lexicographically, output any such order as a permutation of characters 'a'–'z' (i. e. first output the first letter of the modified alphabet, then the second, and so on).

Ví dụ
input
3
rivest
shamir
adleman
output
bcdefghijklmnopqrsatuvwxyz

input
10
petr
egor
endagorion
feferivan
ilovetanyaromanova
kostka
dmitriyh
maratsnowbear
bredorjaguarturnik
cgyforever
output
aghjlnopefikdmbcqrstuvwxyz

input
10
tourist
petr
wjmzbmr
yeputons
vepifanov
scottwu
oooooooooooooooo
subscriber
rowdark
tankengineer
output
Impossible
input
7
car
care
careful
carefully
becarefuldontforgetsomething
otherwiseyouwillbehacked
goodluck

output
acbdefhijklmnogpqrstuvwxyz
-----------
Ta nhận thấy rằng bộ thứ tự trong chữ cái ‘a’-‘z’ thông thường có thể được xem như là 11 topo đã được sắp xếp với mỗi ký tự sẽ là một đỉnh và cạnh từ đỉnh uu đến đỉnh vv trong đồ thị sẽ là thứ tự uu trước vv (‘a’ -> ‘b’ -> ‘c’ -> ‘d’ -> ‘e’ -> … -> ‘z’).

Với bài toán này việc ta cần là đó là tìm ra được đồ thị mối quan hệ giữa các ký tự với nhau và sau đó dùng sắp xếp topo để tìm ra được thứ tự từ điển cần tìm. Lưu ý rằng sẽ có trường hợp đặc biệt ta cần xét đó là khi chuỗi thứ ii trong danh sách là hậu tố của chuỗi thứ i + 1i+1 (ví dụ “aaaa” và “aaa” thì “aaaa” là hậu tố của “aaa”) thì nếu tồn tại trường hợp này trong danh sách thì ta sẽ xuất ra Impossible luôn.

Đầu tiên ta nhập các chuỗi tên vào một mảng chuỗi names.

Sau đó ta tạo mảng bool 22 chiều 26 * 2626∗26 phần tử tên relation tượng trưng cho quan hệ giữa 2626 ký tự với nhau (ký tự ‘a’ sẽ là 00, ‘b’ sẽ là 11, …, ‘z’ sẽ là 2525). Ví dụ relation_{0, 1} = truerelation
​0,1
​​ =true tức là ký tự ‘a’ sẽ phải đứng trước ký tự ‘b’.

Tiếp theo ta duyệt ii từ chuỗi đầu đến chuỗi áp chót trong names. Mỗi lần duyệt ta sẽ có 11 biến bool là flag sẽ gán bằng falsefalse lúc đầu, nhiệm vụ của biến này là để kiểm tra trường hợp đặc biệt như ta đã nói ở trên. Sau đó ta sẽ xét 22 chuỗi names_inames
​i
​​  và names_{i + 1}names
​i+1
​​ :

Ta duyệt tiếp jj từ 00 đến độ dài của chuỗi ngắn hơn trong 22 chuỗi ta đang xét để tìm ký tự khác nhau đầu tiên giữa 22 chuỗi. Nếu names_{i, j}names
​i,j
​​  khác names_{i+1, j}names
​i+1,j
​​  thì đánh dấu quan hệ trong mảng relation_{names_{i,j} - 97, names_{i + 1,j} - 97}relation
​names
​i,j
​​ −97,names
​i+1,j
​​ −97
​​  = true=true (ta phải lấy ký tự trừ 9797 để ra thứ tự trong mảng vì ký tự ‘a’ trong bảng ascii có thứ tự là 9797, ‘a’ – 9797 \leftrightarrow↔ 97 – 97 = 0). Sau đó ta gán flag = trueflag=true tức đây không phải là trường hợp đặc biệt.

Sau khi xét xong thì ta sẽ kiểm tra xem nếu như độ dài chuỗi names_inames
​i
​​  > độ dài chuỗi names_{i + 1}names
​i+1
​​  và flag = falseflag=false thì tức là chuỗi names_inames
​i
​​  là hậu tố của chuỗi names_{i + 1}names
​i+1
​​ , lúc này ta chỉ cần xuất thẳng Impossible và kết thúc chương trình.

Dựa vào mảng quan hệ relation thì lúc này ta sẽ tạo ra đồ thị dưới dạng đỉnh kề tên lexicographical và sau đó áp dụng thuật toán DFS hoặc Kahn để tìm ra thứ tự topo. Nếu thuật toán trả ra falsefalse thì xuất Impossible, ngược lại thì xuất chuỗi tìm được.

Độ phức tạp: \mathcal{O} \left( N^2 \right)O(N
​2
​​ )., trong đó NN là số lượng tên (1 \le N \le 1001≤N≤100), với mỗi lần duyệt ii từ [0,N – 1) thì ta lại duyệt thêm chuỗi thứ i+1i+1 trong danh sách với khoảng độ dài chuỗi thứ ii cũng tương đương với NN (1 \le |{name_i}| \le 1001≤∣name
​i
​​ ∣≤100), do đó ta có độ phức tạp là \mathcal{O} \left( N^2 \right)O(N
​2
​​ )..

Mã nguồn tham khảo
#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> InputNames() {
    int n;
    cin >> n;
    
    string cache;
    getline(cin, cache);

    vector<string> names(n, string());
    for (int i = 0; i < n; ++i) {
        getline(cin, names[i]);
    }
    return names;
}

vector<vector<int>> SetupLexicographical(const vector<string> & names) {
    vector<vector<int>> lexicographical(26, vector<int>());
    vector<vector<bool>> relation(26, vector<bool>(26, false));

    bool flag;

    for (int i = 0; i < names.size() - 1; ++i) {
        flag = false;
        int minSize = names[i].length() < names[i + 1].length() ? names[i].length() : names[i + 1].length();
        for (int j = 0; j < minSize; ++j) {
            if (names[i][j] != names[i + 1][j]) {
                relation[names[i][j] - 97][names[i + 1][j] - 97] = true;
                flag = true;
                break;
            }
        }
        if (!flag && (names[i].length() > names[i + 1].length())) {
            cout << "Impossible";
            exit(0);
        }
    }

    for (int i = 0; i < 26; ++i) {
        for (int j = 0; j < 26; ++j) {
            if (relation[i][j]) {
                lexicographical[i].emplace_back(j);
            }
        }
    }

    return lexicographical;
}

pair<bool, string> TopoSort(vector<vector<int>> & lexicographical) {
    vector<int> inDegrees(26, 0);
    pair<bool, string> result;
    vector<int> zeroInDegree;

    for (int u = 0; u < 26; ++u) {
        vector<int>::iterator it;
        for (it = lexicographical[u].begin(); it != lexicographical[u].end(); ++it) {
            inDegrees[*it]++;
        }
    }

    for (int i = 0; i < 26; ++i) {
        if (inDegrees[i] == 0) {
            zeroInDegree.emplace_back(i);
        }
    }

    while (!zeroInDegree.empty()) {
        int u = zeroInDegree.back();
        zeroInDegree.pop_back();
        result.second.push_back(u + 97);
        vector<int>::iterator it;
        for (it = lexicographical[u].begin(); it != lexicographical[u].end(); ++it) {
            inDegrees[*it]--;
            if (inDegrees[*it] == 0) {
                zeroInDegree.emplace_back(*it);
            }
        }
    }

    for (int i = 0; i < 26; ++i) {
        if (inDegrees[i] != 0) {
            return pair<bool, string>(false, string());
        }
    }

    result.first = true;
    return result;
}

int main() {
    vector<string> names = InputNames();
    vector<vector<int>> lexicographical = SetupLexicographical(names);
    pair<bool, string> result = TopoSort(lexicographical);
    if (!result.first) {
        cout << "Impossible";
    }
    else {
        for (auto & i : result.second) {
            cout << i;
        }
    }
    return 0;
}
-------java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Codeforces_510C solver = new Codeforces_510C();
        solver.solve(in, out);
        out.close();
    }

    static class Codeforces_510C {
        InputReader in;
        OutputWriter out;

        public void solve(InputReader in_, OutputWriter out_) {
            in = in_;
            out = out_;

            int n = in.nextInt();
            String[] names = new String[n];

            for (int i = 0; i < n; i++) {
                names[i] = in.next();
            }

            ArrayList<Integer>[] lexicographical = setUpLexicographical(names);

            if (lexicographical == null) {
                out.println("Impossible");
                return;
            }

            String result = topoSort(lexicographical);

            if (result == null) {
                out.println("Impossible");
                return;
            }

            out.println(result);
        }

        private String topoSort(ArrayList<Integer>[] lexicographical) {
            int[] inDeg = new int[26];
            StringBuilder result = new StringBuilder();
            Queue<Integer> zeroInDegQueue = new LinkedList<>();

            for (int u = 0; u < 26; u++) {
                for (int v : lexicographical[u]) {
                    ++inDeg[v];
                }
            }

            for (int u = 0; u < 26; u++) {
                if (inDeg[u] == 0) {
                    zeroInDegQueue.add(u);

                }
            }

            while (!zeroInDegQueue.isEmpty()) {
                int u = zeroInDegQueue.poll();
                result.append((char) (u + 97));

                for (int v : lexicographical[u]) {
                    --inDeg[v];
                    if (inDeg[v] == 0) {
                        zeroInDegQueue.add(v);
                    }
                }
            }

            for (int i = 0; i < 26; i++) {
                if (inDeg[i] != 0) {
                    return null;
                }
            }

            return result.toString();
        }

        private ArrayList<Integer>[] setUpLexicographical(String[] names) {
            ArrayList<Integer>[] lexicographical = new ArrayList[26];
            boolean[][] relation = new boolean[26][26];

            for (int u = 0; u < 26; u++) {
                lexicographical[u] = new ArrayList<>();
            }

            for (int u = 0; u < 26; u++) {
                for (int v = 0; v < 26; v++) {
                    relation[u][v] = false;
                }
            }

            boolean flag;

            for (int i = 0; i < names.length - 1; i++) {
                flag = false;
                int minSize = Math.min(names[i].length(), names[i + 1].length());

                for (int j = 0; j < minSize; ++j) {
                    if (names[i].charAt(j) != names[i + 1].charAt(j)) {
                        relation[names[i].charAt(j) - 97][names[i + 1].charAt(j) - 97] = true;
                        flag = true;
                        break;
                    }
                }

                if (!flag && (names[i].length() > names[i + 1].length())) {
                    return null;
                }
            }

            for (int u = 0; u < 26; u++) {
                for (int v = 0; v < 26; v++) {
                    if (relation[u][v]) {
                        lexicographical[u].add(v);
                    }
                }
            }

            return lexicographical;
        }

    }

    static class InputReader {
        private final int BUFFER_SIZE = 32768;
        private InputStream stream;
        private byte[] buffer = new byte[BUFFER_SIZE + 1];
        private int pointer = 1;
        private int readLength = 0;
        private int lastWhiteSpace = '\n';

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private byte nextRawByte() {
            if (pointer > readLength) {
                pointer = 1;

                try {
                    readLength = stream.read(buffer, 1, BUFFER_SIZE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (readLength == -1) return -1;
            }

            return buffer[pointer++];
        }

        public int nextChar() {
            int c = nextRawByte();

            while (isWhiteSpace(c)) {
                c = nextRawByte();
            }

            return c;
        }

        public int nextInt() {
            int c = nextChar();
            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = nextRawByte();
            }

            int abs = 0;

            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                abs = c - '0' + abs * 10;
                c = nextRawByte();
            } while (!isWhiteSpace(c));

            lastWhiteSpace = c;

            return abs * sign;
        }

        public String nextString() {
            int c = nextChar();

            if (c == -1) return null;

            StringBuilder builder = new StringBuilder();

            do {
                builder.append((char) c);
                c = nextRawByte();
            } while (!isWhiteSpace(c));

            return builder.toString();
        }

        public String next() {
            return nextString();
        }

        public boolean isWhiteSpace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class OutputWriter {
        private PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (Object object : objects) {
                writer.print(object);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}
--------python
from sys import stdin, stdout
from queue import Queue

def main():
    global io
    io = Stdio()

    n = io.next_int()
    names = []

    for i in range(n):
        names.append(io.next())

    lexicographical = set_up_lexicographical(names)

    if lexicographical == None:
        io.println("Impossible")
        return

    result = topo_sort(lexicographical)

    if result == None:
        io.println("Impossible")
        return

    io.println(result)


def set_up_lexicographical(names):
    lexicographical = [[] for u in range(26)]
    relation = [[False for v in range(26)] for u in range(26)]

    for i in range(len(names) - 1):
        flag = False
        min_size = min(len(names[i]), len(names[i + 1]))

        for j in range(min_size):
            if names[i][j] != names[i + 1][j]:
                relation[ord(names[i][j]) - 97][ord(names[i + 1][j]) - 97] = True
                flag = True
                break

        if not flag and len(names[i]) > len(names[i + 1]):
            return None

    for i in range(26):
        for j in range(26):
            if relation[i][j]:
                lexicographical[i].append(j)

    return lexicographical


def topo_sort(lexicographical):
    in_deg = [0 for u in range(26)]
    result = []
    zero_in_deg_queue = Queue()

    for u in range(26):
        for v in lexicographical[u]:
            in_deg[v] += 1

    for u in range(26):
        if in_deg[u] == 0:
            zero_in_deg_queue.put(u)

    while not zero_in_deg_queue.empty():
        u = zero_in_deg_queue.get()
        result.append(chr(u + 97))

        for v in lexicographical[u]:
            in_deg[v] -= 1

            if in_deg[v] == 0:
                zero_in_deg_queue.put(v)

    for u in range(26):
        if in_deg[u] != 0:
            return None

    return ''.join(str(c) for c in result)


class Stdio:
    index = 0
    tokens = []
    line = None

    def next_line(self):
        tokens = []
        return stdin.readline()

    def next(self):
        while (self.index >= len(self.tokens)):
            self.tokens = self.next_line().strip().split()
            if len(self.tokens) == 0:
                return None
            self.index = 0
        token = self.tokens[self.index]
        self.index += 1
        return token

    def next_int(self):
        return int(self.next())

    def next_float(self):
        return float(self.next())

    def next_char(self):
        return chr(self.next())

    def print(self, *objects):
        for obj in objects:
            stdout.write(str(obj))

    def println(self, *objects):
        for obj in objects:
            stdout.write(str(obj))
        stdout.write('\n')


if __name__ == "__main__":
    main()
 */
public class ORANGE_L01P03 {

}
