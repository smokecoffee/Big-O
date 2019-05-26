package bigO.orange01.lecture04;

/**
 * @author ThinkPad-PC
 *Bit Maps
The bitmap is a data structure that arises in many areas of computing. In the area of graphics, for example, a bitmap can represent an image by having a 11 represent a black pixel and a 00 represent a white pixel.

Consider the following two ways of representing a rectangular bit map. In the first, it is simply represented as a two dimensional array of 11’s and 00’s. The second is based on a decomposition technique. First, the entire bit map is considered. If all bits within it are 11, a 11 is output. If all bits within it are 00, a 00 is output. Otherwise, a DD is output, the bit map is divided into quarters (as described below), and each of those is processed in the same way as the original bit map. The quarters are processed in top left, top right, bottom left, bottom right order. Where a bit map being divided has an even number of rows and an even number of columns, all quarters have the same dimensions. Where the number of columns is odd, the left quarters have one more column than the right. Where the number of rows is odd the top quarters have one more row than the bottom. Note that if a region having only one row or one column is divided then two halves result, with the top half processed before the bottom where a single column is divided, and the left half before the right if a single row is divided.

Write a program that will read in bitmaps of either form and transform them to the other form.

Input
Input will consist of a series of bit maps. Each bit map begins with a line giving its format (BB or DD) and its dimensions (rows and columns). Neither dimension will be greater than 200200. There will be at least one space between each of the items of information. Following this line will be one or more lines containing the sequence of 11, 00 and DD characters that represent the bit map, with no intervening spaces. Each line (except the last, which may be shorter) will contain 5050 characters. A BB type bitmap will be written left to right, top to bottom. The file will be terminated by a line consisting of a single #.

Output
Output will consist of a series of bitmaps, one for each bit map of the input. Output of each bit map begins on a new line and will be in the same format as the input. The width and height are to be output right justified in fields of width four.

Ví dụ
input
B 3 4
001000011011
D 2 3
DD10111
#

output
D 3 4
D0D1001D101
B 2 3
101111

========
Hướng dẫn giải:

Bài toán này sẽ giải chia thành 22 phần chính
Chuyển từ chuỗi loại BB sang chuỗi loại DD.
Ta đưa hết toàn bộ ký tự trong chuỗi s về thành một ma trận 22 chiều kích thước WW * HH.
Gọi hàm B2D(x, y, w, h) là hàm chuyển ma trận gồm các phần tử gồm các hàng đánh số từ xx đến x + w - 1x+w−1 và các cột đánh số từ yy đến y + h - 1y+h−1.
Trước hết, nếu như w = 0w=0 hoặc h = 0h=0, hiển nhiên ma trận này hoàn toàn không tồn tại, ta sẽ return về một chuỗi rỗng.
Nếu toàn bộ ký tự trong ma trận này bằng 0 hoặc bằng 1 thì ta return về chuỗi 0 hoặc 1 tương ứng. Ta có thể kiểm tra đoạn này trong O(W * H)O(W∗H).
Ngược lại, ta sẽ tách ma trận này thành 44 ma trận con
B2D(x, y, (h + 1) / 2, (w + 1) / 2)
B2D(x, y + (w + 1) / 2, (h + 1) / 2, w / 2)
B2D(x + (h + 1) / 2, y, h / 2, (w + 1) / 2)
B2D(x + (h + 1) / 2, y + (w + 1) / 2, h / 2, w / 2)
Và ta return DD ghép với 44 chuỗi của 44 ma trận con.
Đối với bài toán chuyển từ chuỗi loại DD sang chuỗi loại BB, ta thực hiện như sau:
Gọi D2B(A, x, y, w, h, is) là ta chuyển chuỗi ss loại DD sang ma trận nhị phân và đưa vào ma trận AA, gồm các phần tử đánh số các hàng từ xx đến x + w - 1x+w−1 và từ yy đến y + h - 1y+h−1. Phần tử của chuỗi ss hiện tại ta xét là khi với hiện tại, ta đang nhập chúng vào bằng istream is.
Nếu như w = 0w=0 hoặc h = 0h=0 thì không làm gì ở hàm này nữa.
Nếu như ký tự đang xét hiện tại là 0 hoặc 1, ta điền toàn bộ các phần tử trong ma trận từ xx đến x + w - 1x+w−1 và từ yy đến y + h - 1y+h−1 toàn là số 0 và số 1 tương ứng.
Ngược lại là ký tự DD, ta chia thành 44 ma trận con theo đúng cách chia ở trên và gọi lại hàm này. Kết quả là toàn bộ các ký tự trong ma trận A.
Độ phức tạp: Mỗi phần tử trong chuỗi ss đều xét đúng 11 lần. Do đó, độ phức tạp là O(T * W * H)O(T∗W∗H) với TT là số lượng test và W, HW,H là kích thước của ma trận.

Mã nguồn tham khảo
=java
package javaapplication4;

import java.util.*;
import java.io.*;

public class Main {
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    static InputReader sc = new InputReader(System.in);
    static int index = 0;
    static int _count = 0;
    static int _h,_w;
    static boolean flag;
    static String t = "";

    
    public static void main(String[] args) throws FileNotFoundException {
        flag = false;
        while(true){
            boolean uti = Solve();
            if (uti == false){
                return;
            }
        }
        
    }
    static void D2B(ArrayList<StringBuilder> dest, int x, int y, int h, int w, String str) {
        if (h == 0 || w == 0) {
            return;
        }

        char c = str.charAt(index);
        index++;
        if(index == str.length()){
            index = 0;
            str = sc.next();
            if(str.equals("D") ||str.equals("B") || str.equals("#") ){
                t = str;
                flag = true;
            }
        }
        if (c == '1') {
            for (int i = x; i < x + h; ++i) {
                for (int j = y; j < y + w; ++j) {
                    dest.get(i).setCharAt(j, '1');
                }
            }
        }
        else if (c == 'D') {
            D2B(dest, x, y, (h + 1) / 2, (w + 1) / 2, str);
            D2B(dest, x, y + (w + 1) / 2, (h + 1) / 2, w / 2, str);
            D2B(dest, x + (h + 1) / 2, y, h / 2, (w + 1) / 2, str);
            D2B(dest, x + (h + 1) / 2, y + (w + 1) / 2, h / 2, w / 2, str);
        }
    }
    
    static int get(ArrayList<ArrayList<Integer> > f, int x, int y, int h, int w) {
        ++x; ++y;
        return f.get(x + h - 1).get(y + w - 1) 
                - f.get(x-1).get(y + w - 1) 
                - f.get(x + h - 1).get(y - 1) 
                + f.get(x-1).get(y - 1);
    }
    static String B2D(ArrayList<ArrayList<Integer> > f,int x , int y, int h, int w){
        if (h == 0 || w == 0) {
            return "";
        }

        int sum = get(f, x, y, h, w);
        if (sum == 0) {
            return "0";
        }
        else if (sum == h * w) {
            return "1";
        }
        else {
            return "D" + B2D(f, x, y, (h + 1) / 2, (w + 1) / 2)
                       + B2D(f, x, y + (w + 1) / 2, (h + 1) / 2, w / 2)
                       + B2D(f, x + (h + 1) / 2, y, h / 2, (w + 1) / 2)
                       + B2D(f, x + (h + 1) / 2, y + (w + 1) / 2, h / 2, w / 2);
        }
    }
    static boolean Solve(){
        index = 0;
        _count = 0;
        
        _h = 0; _w = 0;
        if(flag == false){
            t = sc.next();
        }
        flag = false;
        if(t.equals("#")){
            return false;
        }
        _h = sc.nextInt();
        _w = sc.nextInt();
        _count = _w*_h;
        ArrayList<ArrayList<Integer> >  f = new ArrayList<>();
        for(int i = 0; i < _h+1; i++){
            f.add(new ArrayList());
            for(int j = 0; j < _w+1;j++){
                f.get(i).add(0);
            }
        }
        if(t.equals("B")){
            String str = "";
            str = sc.next();
            int ii = 0;
            for (int i = 0; i < _h; ++i) {
                for (int j = 0; j < _w; ++j) {
                    f.get(i+1).set(j+1, f.get(i).get(j+1) + f.get(i+1).get(j) 
                        - f.get(i).get(j) + (Character.getNumericValue(str.charAt(ii))));
                    ii++;
                    _count--;
                    if(ii == str.length() && _count > 0 ){
                        ii = 0;
                        str = sc.next();
                    }
                }
            }
        }
        System.out.printf("%c %3d %3d\n", t.equals("B") ? 'D' : 'B', _h, _w);
        String res = "";
        if (t.equals("B")) {
            res = B2D(f, 0, 0, _h, _w);
        }
        else {
            ArrayList<StringBuilder> dest = new ArrayList<>();
            for(int i = 0; i < _h; i ++){
                dest.add(new StringBuilder(new String()));
                for(int j = 0 ;  j < _w; j++){
                    dest.get(i).append('0');
                }
            }
            String str ="";
            str = sc.next();
          
            D2B(dest, 0, 0, _h, _w, str);
            for(int i = 0; i < _h; i ++){
                res += dest.get(i);
            }
        }
        for (int i = 0; i < res.length(); ++i) {
            System.out.print(res.charAt(i));
           if ((i + 1) % 50 == 0 || i == res.length() - 1) {
                System.out.println();
            }
        }
        return true;
    }
    
}
------python3
def get(x,y,h,w):
  res = 0
  for i in range(x,x+h):
    for j in range(y,y+w):
      if a[i][j] == '1':
        res += 1
  return res

def B2D(x,y,h,w):
  if h == 0 or w == 0:
    return ""

  sum = get(x,y,h,w)
  
  if sum == 0:
    return "0"
  elif sum == h * w:
    return "1"

  s1 = B2D(x, y, (h + 1) // 2, (w + 1) // 2)
  s2 = B2D(x, y + (w + 1) // 2, (h + 1) // 2, w // 2)
  s3 = B2D(x + (h + 1) // 2, y, h // 2, (w + 1) // 2)
  s4 = B2D(x + (h + 1) // 2, y + (w + 1) // 2, h // 2, w // 2)

  return "D" + s1 + s2 + s3 + s4

def D2B(x,y,h,w):
  global string_it
  if h == 0 or w == 0:
    return

  c = stream[string_it]
  string_it += 1

  if c == '1':
    for i in range(x, x + h):
      for j in range(y, y + w):
        dest[i][j] = '1'
    return 
  elif c == '0':
    for i in range(x, x + h):
      for j in range(y, y + w):
        dest[i][j] = '0'
    return
  
  D2B(x, y, (h + 1) // 2, (w + 1) // 2)
  D2B(x, y + (w + 1) // 2, (h + 1) // 2, w // 2)
  D2B(x + (h + 1) // 2, y, h // 2, (w + 1) // 2)
  D2B(x + (h + 1) // 2, y + (w + 1) // 2, h // 2, w // 2)


if __name__ == "__main__":
  line = input()
  while True:
    if line == '#':
      break
    line = line.split()
    h = int(line[1])
    w = int(line[2])
    x = line[0]
    iterator = 0
    stream = ""
    while True:
      line = input()
      if line == "#" or ' ' in line:
        break
      stream += line

    if x == 'B':
      a = [stream[i:i + w] for i in range(0, h * w, w)]
      print('D', end = '')
      res = B2D(0, 0, h, w)
    else:
      print('B',end='')
      string_it = 0
      dest = [ ['0' for i in range(w)] for j in range(h)]
      D2B(0, 0, h, w)
      res = ''.join([''.join(line) for line in dest])

    print("%4d %3d" % (h, w))
    l = len(res)
    for i in range(l):
      print(res[i],end='')
      if (i + 1) % 50 == 0 or i == l - 1:
        print()
--cpp14

#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>

using namespace std;

string s;
vector <vector <int> > a;

int get(int x, int y, int h, int w) {
    int res = 0; 
    for (int i = x; i < x + h; i++) {
        for (int j = y; j < y + w; j++) {
            if (a[i][j] == 1) {
                res++;
            }
        }
    }

    return res;
}

string B2D(int x, int y, int h, int w) {
    if (h == 0 || w == 0) {
        return "";
    }

    int sum = get(x, y, h, w);
    if (sum == 0) {
        return "0";
    }
    else {
        if (sum == h * w) {
            return "1";
        }
    }

    return "D" + B2D(x, y, (h + 1) / 2, (w + 1) / 2) 
                         + B2D(x, y + (w + 1) / 2, (h + 1) / 2, w / 2)
                         + B2D(x + (h + 1) / 2, y, h / 2, (w + 1) / 2)
                         + B2D(x + (h + 1) / 2, y + (w + 1) / 2, h / 2, w / 2);
}

void D2B(vector <string> &dest, int x, int y, int h, int w) {
    if (h == 0 || w == 0) {
        return;
    }

    char c;
    cin >> c;
    if (c == '1') {
        for (int i = x; i < x + h; i++) {
            for (int j = y; j < y + w; j++) {
                dest[i][j] = '1';
            }
        }
        return;
    }
    else {
        if (c == '0') {
            for (int i = x; i < x + h; i++) {
                for (int j = y; j < y + w; j++) {
                    dest[i][j] = '0'; 
                }
            }
            return;
        }
    }

    D2B(dest, x, y, (h + 1) / 2, (w + 1) / 2); 
    D2B(dest, x, y + (w + 1) / 2, (h + 1) / 2, w / 2);
    D2B(dest, x + (h + 1) / 2, y, h / 2, (w + 1) / 2);
    D2B(dest, x + (h + 1) / 2, y + (w + 1) / 2, h / 2, w / 2);
}

int main () {
    while (1) {
        char c;
        int h, w;
        cin >> c;

        if (c == '#') {
            break;
        }

        cin >> h >> w;
        a.clear();

        if (c == 'B') {
            for (int i = 0; i < h; i++) {
                vector <int> tmp; 
                for (int j = 0; j < w; j++) {
                    char cc;
                    cin >> cc; 
                    if (cc == '0') {
                        tmp.push_back(0);
                    }
                    else {
                        tmp.push_back(1);
                    }
                }
                a.push_back(tmp);
            }
        }

        string res = "";
        if (c == 'B') {
            cout << 'D';
            res = B2D(0, 0, h, w);
        }
        else {
            cout << 'B';
            vector <string> dest(h, string(w, '0'));
            D2B(dest, 0, 0, h, w);

            for (int i = 0; i < (int) dest.size(); i++) {
                res += dest[i];
            }
        }

        printf("%4d %3d\n", h, w);
        for (int i = 0; i < (int) res.size(); i++) {
            cout << res[i]; 
            if ((i + 1) % 50 == 0 || i == (int) res.size() - 1) {
                cout << endl;
            }
        }
    }
    return 0;
}
 */
public class ORANGE_L04P04 {

}
