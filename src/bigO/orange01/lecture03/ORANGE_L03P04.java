package bigO.orange01.lecture03;

/**
 * @author ThinkPad-PC
 *The Boggle Game
The language PigEwu has a very simple syntax. Each word in this language has exactly 44 letters. Also each word contains exactly two vowels (y is consider a vowel in PigEwu). For instance, “maar” and “even” are legitimate words, “arts” is not a legal word.

In the game boggle, you are given a 4 * 44∗4 array of letters and asked to find all words contained in it. A word in our case (PigEwu) will thus be a sequence of 44 distinct squares (letters) that form a legal word and such that each square touches (have a corner or edge in common) the next square.

For example:

	A S S D
	S B E Y
	G F O I
	H U U K
In this board a (partial) list of legal words include:

ASGU	SABO	FOIK	FOYD SYDE HUFO

BEBO is a legal word but it is not on this boggle board (there are no two B’s here).

Write a program that reads a pair of Boggle boards and lists all PigEwu words that are common to both boards.

Input
Input will include a few data sets.

Each data set will be a pair of boards as shown in the sample input. All entries will be upper case letters. Two consecutive entries on same board will be separated by one blank.

The first row in the first board will be on the same line as the first row of the second board. They will be separated by four spaces, the same will hold for the remaining 33 rows. Board pairs will be separated by a blank line.

Input will be terminated by '#'.

Output
For each pair of boggle boards, output an alphabetically-sorted list of all common words, each word on a separate line; or the statement 'There are no common words for this pair of boggle boards.'

Separate the output for each pair of boggle boards with a blank line.

Ví dụ
input
D F F B    W A S U
T U G I    B R E T
O K J M    Y A P Q
K M B E    L O Y R

Z W A V    G S F U
U N C O    A H F T
Y T G I    G N A L
H G P M    B O O B

#
output
There are no common words for this pair of boggle boards.

ANGO
AOGN
GNAO
GOAN
NAOG
NGOA
OANG
OGNA

========
Bài này có 22 bước quan trọng là tìm tất cả các từ PigEwu trong 22 bảng Boggle và sau đó lọc ra các từ chung tìm được ở 22 bảng đó.

Tìm các từ PigEwu trong mỗi bảng: chúng ta sử dụng backtracking để tìm ra tất cả các từ 44 ký tự rồi lưu lại những từ có đúng 22 nguyên âm. Ý tưởng backtracking là thử chọn 11 ô làm ký tự đầu tiên, sau đó trong các ô kề của ô đó ta chọn 11 ô làm ký tự thứ 22, rồi chọn 1 ô trong các ô kề của ô thứ 22 mà chưa được chọn để làm ký tự thứ 33, tương tự với ký tự thứ 44.

Gọi find_words(x, y, cur_word) là thủ tục để thử tìm tất cả các cách chọn 44 ô phân biệt kề nhau trên bảng, và đang đứng ở ô (x, y)(x,y), với cur\_wordcur_word là từ đã có được bằng cách nối các ký tự đang được chọn:

Nếu cur\_wordcur_word đã đủ 44 ký tự: nếu nó có 22 nguyên âm thì lưu cur\_wordcur_word lại, ngược lại không làm gì cả. Tới đây thoát hàm vì không cần tìm thêm ký tự thứ 55 nữa.
Đánh dấu ô (x, y)(x,y) là đang được chọn.
Với mọi ô (x', y')(x
​′
​​ ,y
​′
​​ ) kề với ô (x, y)(x,y): nếu ô này nằm trên bảng và chưa được chọn thì gọi thủ tục find_words(x', y', cur_word + ký tự ở ô (x', y')) để thử cho ký tự tiếp theo là (x', y')(x
​′
​​ ,y
​′
​​ ) rồi thử tiếp.
Cuối cùng đánh dấu ô (x, y)(x,y) là hiện đang chưa được chọn và thoát khỏi thủ tục.
Với mỗi ô (x, y)(x,y) trên bảng ta đều gọi thủ tục find_words, tức là thử cho ô (x, y)(x,y) làm ký tự đầu tiên một cách thủ công, còn việc tìm các ký tự còn lại để hàm find_words lo.

Giả sử có tối đa WW từ trên bảng (kể cả từ không phải từ PigEwu). Chi phí để thêm 11 từ là O(log(W))O(log(W)) nếu sử dụng cấu trúc Tree Set, hoặc O(1)O(1) nếu dùng Hash Table. Vậy thao tác tìm và lưu lại tất cả các từ là O(Wlog(W))O(Wlog(W)) hoặc O(W)O(W).

Số ô bắt đầu gọi find_words là 1616 ô của bảng. Với mỗi ô bắt đầu (chọn ký tự đầu tiên), có không quá 88 cách chọn ký tự thứ 22; với mỗi cách chọn ký tự thứ 22 lại có không quá 77 cách chọn ký tự thứ 33; cuối cùng có không quá 77 cách chọn ký tự cuối cùng.
Vậy có nhiều nhất khoảng 16 * 8 * 7 * 7 = 627216∗8∗7∗7=6272 từ.
Sau khi tìm được 22 tập các từ PigEwu của 22 bảng thì ta duyệt mỗi từ trong một tập và kiểm tra xem nó có nằm trong tập kia không. Thao tác này tốn O(Wlog(W))O(Wlog(W)) (nếu dùng Hash Table thì sau khi tìm xong phải sắp xếp lại các từ cho đúng thứ tự từ điển nữa, còn Tree Set thì nó đã đúng thứ tự từ điển rồi nên cả 22 cách có cùng chi phí).

Độ phức tạp: O(T * W * log(W))O(T∗W∗log(W)) với TT là số bộ test và WW là số từ tối đa có trên bảng.

Mã nguồn tham khảo
#include <iostream>
#include <string.h>
#include <set>
#include <vector>
using namespace std;

const string VOWELS = "AEOYIU";
const pair<int, int> DIRs[] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

int count_vowels(const string& word) {
    int res = 0;
    for (char c : word) {
        res += (VOWELS.find(c) != string::npos);
    }
    return res;
}

/**
 * board: current board to find words
 * x, y: current cell
 * cur_word: current cummulative word
 * visited: visiting state for each cell
 * found_words: target location for legal words
**/
/*void find_words(char board[4][4], int x, int y, const string& cur_word, bool visited[4][4], set<string>& found_words) {
    if (cur_word.length() == 4) {
        if (count_vowels(cur_word) == 2) {
            found_words.insert(cur_word);
        }
        return;
    }
    
    visited[x][y] = true;
    for (auto d : DIRs) {
        int nx = x + d.first, ny = y + d.second;
        if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !visited[nx][ny]) {
            string new_cur_word = cur_word + board[nx][ny];
            find_words(board, nx, ny, new_cur_word, visited, found_words);
        }
    }
    visited[x][y] = false;
}

bool start = true; // just for checking whether to print new lines between test cases

void solve() {
    char board[2][4][4];
	char ch;
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 8; ++j) {
			cin >> ch;
			if (ch == '#') exit(0);
            board[j >> 2][i][j & 3] = ch; // characters 0..3 -> board[0][i][0..3], characters 4..7 -> board[1][i][0..3]
        }
    }
    
    if (!start) {
        cout << endl;
    }
    start = false;
    
    // find words for both boards
    bool visited[4][4];
	memset(visited, 0, sizeof(visited));

    set<string> words[2];
    for (int board_id : {0, 1}) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                string cur_word(1, board[board_id][i][j]);
                find_words(board[board_id], i, j, cur_word, visited, words[board_id]);
            }
        }
    }
    
    vector<string> common_words;
    for (const string& word : words[0]) {
        if (words[1].find(word) != words[1].end()) {
            common_words.push_back(word);
        }
    }
    
    if (common_words.size() == 0) {
        cout << "There are no common words for this pair of boggle boards.\n";
    }
    else {
        for (const string& word : common_words) {
            cout << word << endl;
        }
    }
}

int main() {
    while (true) {
        solve();
    }
}*/
-----------java
/*import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;

public class Main {
    static final private String VOWELS = "AEOYIU";
    static final private int[][] DIRs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static private boolean start;
    static private Scanner sc;

    static int count_vowels(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (VOWELS.indexOf(word.charAt(i)) > -1) {
                res += 1;
            }
        }
        return res;
    }*/

    /**
     * board: current board to find words
     * x, y: current cell
     * cur_word: current cummulative word
     * visited: visiting state for each cell
     * found_words: target location for legal words
     **/
    /*static void find_words(char[][] board, int x, int y, String cur_word, boolean[][] visited, TreeSet<String> found_words) {
        if (cur_word.length() == 4) {
            if (count_vowels(cur_word) == 2) {
                found_words.add(cur_word);
            }
            return;
        }

        visited[x][y] = true;
        for (int[] d : DIRs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !visited[nx][ny]) {
                String new_cur_word = cur_word + board[nx][ny];
                find_words(board, nx, ny, new_cur_word, visited, found_words);
            }
        }
        visited[x][y] = false;
    }

    static void solve() {
        char[][][] board = new char[2][4][4];

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 8; ++j) {
                char ch = sc.next().charAt(0);
                if (ch == '#') {
                    System.exit(0);
                }
                board[j >> 2][i][j & 3] = ch; // characters 0..3 -> board[0][i][0..3], characters 4..7 -> board[1][i][0..3]
            }
        }

        if (!start) {
            System.out.print('\n');
        }
        start = false;

        // find words for both boards
        boolean[][] visited = new boolean[4][4];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
      
        TreeSet<String>[] words = new TreeSet[2];
        for (int i = 0; i < words.length; i++) {
            words[i] = new TreeSet<>();
        }
      
        for (int board_id : new int[] {0, 1}) {
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    String cur_word = "";
                    cur_word += board[board_id][i][j];
                    find_words(board[board_id], i, j, cur_word, visited, words[board_id]);
                }
            }
        }

        ArrayList<String> common_words = new ArrayList<>();
        for (String word : words[0]) {
            if (words[1].contains(word)) {
                common_words.add(word);
            }
        }

        if (common_words.size() == 0) {
            System.out.print("There are no common words for this pair of boggle boards.\n");
        }
        else {
            for (String word : common_words) {
                System.out.print(word + "\n");
            }
        }
    }

    public static void main(String[] args) {
        start = true;
        sc = new Scanner(System.in);
        while (true) {
            solve();
        }
    }
}*/
/*
VOWELS = "AEOYIU"
DIRs = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]]
start = True

def count_vowels(word):
        res = 0
        for w in word:
                if w in VOWELS:
                        res += 1
        return res

def find_words(board, x, y, cur_word, visited, found_words):
        if len(cur_word) == 4:
                if count_vowels(cur_word) == 2:
                        found_words.add(cur_word)
                return
        
        visited[x][y] = True
        for d in DIRs:
                nx = x + d[0]
                ny = y + d[1]
                if 0 <= nx < 4 and 0 <= ny < 4 and not visited[nx][ny]:
                   new_cur_word = cur_word + board[nx][ny]
                   find_words(board, nx, ny, new_cur_word, visited, found_words)
        visited[x][y] = False

def solve():
        global start

        board = [[[0 for _ in range(4)] for _ in range(4)] for _ in range(2)]

        if not start:
            input()

        for i in range(4):
                line = list(input().split())
                if line[0] == '#':
                        exit()
                for j in range(8):
                        board[j >> 2][i][j & 3] = line[j]

        if not start:
            print()
        start = False

        visited = [[False for _ in range(4)] for _ in range(4)]
        words = [set() for _ in range(2)]

        for board_id in [0, 1]:
                for i in range(4):
                        for j in range(4):
                                cur_word = ""
                                cur_word += board[board_id][i][j]
                                find_words(board[board_id], i, j, cur_word, visited, words[board_id])
        
        common_words = list()
        for word in words[0]:
                if word in words[1]:
                        common_words.append(word)
        
        common_words.sort()
        if len(common_words) == 0:
            print("There are no common words for this pair of boggle boards.")
        else:
                for word in common_words:
                    print(word)


if __name__ == "__main__":
    while True:
        solve()*/

 */
public class ORANGE_L03P04 {

}
