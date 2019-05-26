package bigO.orange01.lecture08;

/**
 * @author 
 * The Sultan's Successors
The Sultan of Nubia has no children, so she has decided that the country will be split into up to kk separate parts on her death and each part will be inherited by whoever performs best at some test. It is possible for any individual to inherit more than one or indeed all of the portions. To ensure that only highly intelligent people eventually become her successors, the Sultan has devised an ingenious test. In a large hall filled with the splash of fountains and the delicate scent of incense have been placed kk chessboards. Each chessboard has numbers in the range 11 to 9999 written on each square and is supplied with 88 jewelled chess queens. The task facing each potential successor is to place the 88 queens on the chess board in such a way that no queen threatens another one, and so that the numbers on the squares thus selected sum to a number at least as high as one already chosen by the Sultan. (For those unfamiliar with the rules of chess, this implies that each row and column of the board contains exactly one queen, and each diagonal contains no more than one.)

Write a program that will read in the number and details of the chessboards and determine the highest scores possible for each board under these conditions. (You know that the Sultan is both a good chess player and a good mathematician and you suspect that her score is the best attainable.)

Input
Input will consist of kk (the number of boards), on a line by itself, followed by kk sets of 6464 numbers, each set consisting of eight lines of eight numbers. Each number will be a positive integer less than 100100. There will never be more than 2020 boards.

Output
Output will consist of kk numbers consisting of your kk scores, each score on a line by itself and right justified in a field 55 characters wide.

Ví dụ
input
1
 1   2   3   4   5   6   7   8 
 9  10  11  12  13  14  15  16
17  18  19  20  21  22  23  24 
25  26  27  28  29  30  31  32 
33  34  35  36  37  38  39  40 
41  42  43  44  45  46  47  48 
48  50  51  52  53  54  55  56
57  58  59  60  61  62  63  64
output
260
 *
 *Giải thích ví dụ:

Trong các cách đặt 88 con hậu thì có cách đặt các con hậu ở các vị trí (0, 0), (1, 4), (2, 7), (3, 5), (4, 2), (5, 6), (6, 1), (7, 3)(0,0),(1,4),(2,7),(3,5),(4,2),(5,6),(6,1),(7,3) có tổng các con số trên ô được chọn là 1+13+24+30+35+47+50+60=2601+13+24+30+35+47+50+60=260 là lớn nhất trong các tổng.

Hướng dẫn giải:

Ở bài toán này ta phải tìm cách làm sao đặt 88 con hậu vào một bàn cờ 8*88∗8 mà không có con hậu nào “ăn” con hậu khác. Đây là một bài toán kinh điển, tuy nhiên ở đây không yêu cầu ta phải chỉ ra các cách sắp xếp này mà tìm ra tổng các con số ở mỗi ô mà ta đặt các con hậu sao cho tổng này lớn nhất có thể. Như vậy điều này cũng bắt buộc ta phải tìm ra hết các cách sắp xếp các con hậu và thêm một bước nữa tính tổng các con số ở các ô được chọn và tìm ra tổng lớn nhất. Để giải quyết bài toán này ta hoàn toàn có thể sử dụng backtracking tuy nhiên do bàn cờ hiện tại đang lưu các con số để tính tổng nên ta không thể thay đổi trực tiếp trên bàn cờ này để đặt các con hậu. Thay vào đó ta có thể sử dụng thêm một mảng 11 chiều gồm 88 phần tử, với mỗi ô trong mảng này sẽ tượng trưng cho 11 hàng của bàn cờ, giá trị tại mỗi ô chính là vị trí cột tương ứng với hàng đó để đặt con hậu.

Bước 1: Xây dựng các hàm kiểm tra có nhiều hơn 11 con hậu trên cùng 11 cột, đường chéo chính và đường chéo phụ (do ta đệ quy theo hàng, mỗi hàng chỉ đặt 11 con hậu nên có tối đa 11 con hậu trên cùng một hàng không cần hàm kiểm tra theo hàng). Đồng thời đọc các con số ở mỗi ô trên bàn cờ vào một mảng hai chiều.

Bước 2: Chạy hàm đệ quy để tìm các cách sắp 88 con hậu:

Nếu index hàng hiện tại là 88 (đã duyệt qua hết hàng cuối cùng, index hàng tính từ 00) thì tính tổng các con số trên các ô được đặt con hậu, nếu tổng này lớn hơn tổng hiện tại thì cập nhật.
Ngược lại, lần lượt duyệt qua các cột của hàng hiện tại, nếu cột nào không vi phạm bất kỳ điều kiện nào thì ta chọn cột này ở hàng hiện tại để đặt con hậu và tiếp tục đệ quy cho hàng tiếp theo. Sau khi đệ quy xong cho một cột thì quay sang xét các cột tiếp theo cho đến khi hết cột của hàng hiện tại thì kết thúc hàm hiện tại.
Độ phức tạp: O(k)O(k) với kk là số lượng bàn cờ.

Mã nguồn tham khảo
#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

#define SIZE 8
using namespace std;

bool check(int queens[SIZE], int row, int col) { 
    for (int i = 0; i < row; i++) { 
        if (queens[i] == col) return false; 
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { 
        if (queens[i] == j) return false; 
    } 
    for (int i = row - 1, j = col + 1; j < SIZE && i >= 0; i--, j++) { 
        if (queens[i] == j) return false; 
    }

    return true; 
} 

void NQueen (int chessboard[SIZE][SIZE], int queens[SIZE], int row, int &ans) {
    if (row == SIZE) {
        int sum = 0;
        for (int i = 0; i < SIZE; ++i) {
            sum += chessboard[i][queens[i]];
        }
        ans = max(ans, sum);
        return;
    }
    for (int i = 0; i < SIZE; ++i) {
        if (!check(queens, row, i)) continue;
        queens[row] = i;
        NQueen(chessboard, queens, row + 1, ans);
    }
}

int main() {
    int k;
    cin >> k;
    while (k-- > 0) {
        int chessboard[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cin >> chessboard[i][j];
            }
        }
        int ans = 0, queens[SIZE];
        NQueen(chessboard, queens, 0, ans);
        cout << setw(5) << ans << endl;
    }
}

 */
public class ORANGE_L08P02 {

}
