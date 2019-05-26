package bigO.orange01.lecture07;
/*
 * Largest Prime Divisor
All integer numbers are divisible by primes. If a number is divisible by more than one prime number, then it obviously has a largest prime divisor. The numbers which do not fall in this category do not have a largest prime divisor. Given a number NN, your job is to write a program that finds its largest prime divisor. An integer number nn is divisible by another integer number mm if there is an integer tt such that m*t = nm∗t=n

Input
The input file contains at most 450450 sets of inputs. Each line contains a decimal integer NN. NN does not have more than 1414 digits. Input is terminated by a line containing a single zero. So no other line except the last line contains a zero in the input. This line need not be processed.

Output
For each line of the input produce one line of output. This line contains an integer LPD, which is the largest prime divisor of the input number NN. If the input number is not divisible by more than one prime number output a '-1'

Ví dụ
input
2
6
100
0
output
-1
3
5
Ta nhận thấy việc tìm ước số nguyên tố lớn nhất của NN chính là tìm các ước số nguyên tố của NN và đưa ra ước số lớn nhất trong các ước số này. Để tìm các ước số của NN, ta chỉ cần duyệt qua từng số từ 11 đến NN và kiểm tra chia hết. Tuy nhiên, ở đây ta cần phải đảm bảo các ước phải là số nguyên tố. Vì vậy, mỗi khi gặp một ước nguyên tố xx mà NN chia hết, ta sẽ cho NN chia cho ước đó cho đến khi không thể chia nữa. Điều này là để đảm bảo ta sẽ không gặp bất kỳ một ước k*xk∗x nào khác (kk là số nguyên dương lớn hơn 11) không phải số nguyên tố.

Cách giải chi tiết:

Bước 1: Đọc vào số nguyên NN, lưu ý nếu NN là số âm thì nên lấy trị tuyệt đối để trở thành số dương.

Bước 2: Tạo biến resres lưu ước nguyên tố lớn nhất của NN, khởi tạo res = -1res=−1. Tạo biến cntcnt lưu số lượng ước nguyên tố của NN, khởi tạo cnt = 0cnt=0.

Bước 3 Dùng vòng for với biến ii chạy từ 22 đến căn bậc hai của NN: với mỗi số với mỗi số ii mà N\ mod\ i = 0N mod i=0 ta sẽ tăng biến đếm cntcnt lên thêm 11 đơn vị và gán res = ires=i, đồng thời dùng vòng lặp while chia NN cho ii đến khi không còn chia nguyên.

Bước 4: Ta có các trường hợp sau:

TH1: cnt > 0cnt>0 và N > 1N>1: ta xác định kết quả của NN sau khi thực hiện vòng lặp for chính là ước nguyên tố lớn nhất của NN ban đầu. Nếu ta gọi xx là kết quả, thì NN ban đầu có dạng N = a * xN=a∗x với aa là một số nguyên dương bé hơn xx.
TH2: cnt = 1cnt=1 (và N = 1N=1): NN ban đầu không có ước số nguyên tố lớn nhất nào thoả đề bài.
TH3: bao gồm các trường hợp còn lại:
cnt = 0cnt=0: tức NN là số nguyên tố
cnt > 0cnt>0 và N = 1N=1: tức NN là tích của nhiều thừa số nguyên tố, và tồn tại ước số nguyên tố lớn nhất theo yêu cầu.
Vậy trong trường hợp 3, ta chỉ cần in ra kết quả lưu trong biến resres.

Độ phức tạp: O(T * \sqrt{N})O(T∗√
​N
​
​​ ) với TT là số lượng test và NN có tối đa 1414 chữ số.

Mã nguồn tham khảo
#include <cmath>
#include <iostream>
using namespace std;

long long largestPrimeDivisor(long long n) {
    long long res = -1;
    int cnt = 0;
    
    for (long long i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            cnt++;
            res = i;
        }
        while (n % i == 0) {
            n /= i;
        }
    }

    if (cnt > 0 && n > 1) {
        return n;
    }
    else if (cnt == 1) {
        return -1;
    }
    
    return res;
}

int main() {
    long long n;
    while (true) {
        cin >> n;
        if (n == 0)
            break;
        
        cout << largestPrimeDivisor(abs(n)) << endl;
    }
    return 0;
}
 */
public class ORANGE_L07P02 {

}
