package bigO.orange01.lecture08;
/*
 * Palindromic Series
Adobe wants to play a game. He is given a number NN. He has to create a alphabetical string in lower case from that number and tell whether the string is palindrome or not. a = 0a=0 , b = 1b=1….. and so on. For example : If the number is 6161 the substring gb will be printed till 7 (6 + 1)7(6+1) characters, i.e. gbgbgbg and check if palindrome or not. Adobe is weak in concepts of palindrome and strings, help him in winning the game.
Note: No number will start with zero. Consider alphabets a to j only i.e. single digit numbers from 00 to 99.

Input
The first line contains integer TT denoting the number of test cases. For each test case, there is a line containing a number NN. None of the numbers start with a zero.

Output
For each test case, print YES if the string is palindrome and NO if not.

Ví dụ
input
4
61
10101
1998
1234567
output
YES
YES
NO
NO
Giải thích ví dụ:

Ví dụ 1:

Với 6161, ta có chuỗi gbgbgbg là chuỗi đối xứng với độ dài là 77.
Với 1010110101, ta có chuỗi bab là chuỗi đối xứng với độ dài là 33.
Với 19981998, ta có chuỗi bjjibjjibjjibjjibjjibjjibjj không là chuỗi đối xứng với độ dài là 2727.
Với 12345671234567, ta có chuỗi con là bcdefgh và độ dài chuỗi là 2828, chuỗi mới được tạo không phải là chuỗi đối xứng.
Hướng dẫn giải:

Với bài này ta cần phải tạo được chuỗi mới từ số NN đã cho, vậy ta sẽ đọc các số NN dưới dạng chuỗi.
Ta sẽ duyệt các ký tự của NN để tạo được chuỗi con cơ bản.
Ta cũng tính tổng các chữ số NN để có được độ dài của chuỗi mới sẽ tạo gọi là SumSum.
Từ ví dụ của số 6161, ta nhận thấy chuỗi mới phải tạo gồm 22 phần: phần lặp hoàn toàn từ chuỗi con và phần lặp không hoàn toàn. Với phần lặp hoàn toàn ta nhận thấy số lần lặp là phần nguyên của (Sum / |N|)(Sum/∣N∣).
Với phần lặp không hoàn toàn là ta lặp lại chỉ với (Sum / |N|)(Sum/∣N∣) phần tử đầu tiên của chuỗi NN.
Sau khi tạo được chuỗi cần thiết, ta thực hiện kiểm tra tính đối xứng của nó và in kết quả.
Độ phức tạp: O(max(|N|, |S|))O(max(∣N∣,∣S∣)) – Với |N|∣N∣ là độ dài của số NN, |S|∣S∣ là độ dài của chuỗi được tạo.

Mã nguồn tham khảo
#include <bits/stdc++.h>

using namespace std;

int t;

bool isPalindromic(string check)
{
    for (int i = 0; i < check.length() / 2; i++)
        if (check[i] != check[check.length() - i - 1])
            return false;
    return true;
}

int main()
{
    cin >> t;
    while (t--)
    {
        string n;
        int sum = 0;
        cin >> n;
        for (int i = 0; i < n.length(); i++)
            sum += (n[i] - '0');

        string palin = "";
        for (int i = 0; i < sum / n.length(); i++)
            palin += n;
        for (int i = 0; i < sum % n.length(); i++)
            palin += n[i];
        if (isPalindromic(palin))
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
    return 0;
}

 */
public class ORANGE_L08P01 {

}
