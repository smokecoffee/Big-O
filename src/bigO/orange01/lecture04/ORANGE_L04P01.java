package bigO.orange01.lecture04;

/**
 * @author ThinkPad-PC
 *The Closest Pair Problem
Given a set of points in a two dimensional space, you will have to find the distance between the closest two points.

Input
The input contains several testcases.

Each testcase starts with an integer NN (0 \le N \le 100000≤N≤10000), which denotes the number of points in this test.

The next NN line contains the coordinates of NN two-dimensional points. The first of the two numbers denotes the XX-coordinate and the latter denotes the YY-coordinate.

The input is terminated by a test in which N = 0N=0. This test should not be processed.

The value of the coordinates will be less than 4000040000 and non-negative.

Output
For each test produce a single line of output containing a floating point number (with four digits after the decimal point) denoting the distance between the closest two points. If there is no such two points whose distance is less than 1000010000, print the line INFINITY.

Ví dụ
input
3
0 0
10000 10000
20000 20000
5
0 2
6 67
43 71
39 107
189 140
0
output
INFINITY
36.2215
----------Huong dan giai
Bước 1: Sắp xếp tọa độ điểm theo thứ tự tăng dần của hoành độ OxOx.
Bước 2: Chia mảng ra làm 2 phần (bên trái và bên phải). Tìm khoảng cách ngắn nhất mỗi bên. So sánh bên nào ngắn hơn chọn khoảng cách đó. Gọi là dist\_min.dist_min.
Bước 3: Trường hợp khoảng cách ngắn nhất nằm 2 điểm thuộc nửa này và nửa kia. Dùng dist\_mindist_min để chọn các điểm giữa 2 phần.
Bước 4: Tránh việc so sánh nhiều lần các điểm trong tập vừa tìm được, sắp xếp các điểm theo tung độ (Oy)(Oy). Tạo thành khung so sánh hình chữ nhật. Tính khoảng cách các điểm và cập nhật dist\_mindist_min.
Bước 5: Nếu dist\_min > 10000dist_min>10000 thì xuất INFINITY, ngược lại xuất dist\_mindist_min.
Độ phức tạp: O(N* logN * T)O(N∗logN∗T) với TT là số test set, NN là số lượng điểm có trong một test set.
Mã nguồn tham khảo
INF = 1e9
 
--------python 3 
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
 
 
def distance(p1, p2):
    x = p1.x - p2.x
    y = p1.y - p2.y
    return (x * x + y * y) ** 0.5
 
 
def brute_force(point_set, left, right):
    min_dist = INF
    for i in range(left, right):
        for j in range(i + 1, right):
            min_dist = min(min_dist, distance(point_set[i], point_set[j]))
    return min_dist
 
 
def strip_closest(point_set, left, right, mid, dist_min):
    point_mid = point_set[mid]
    splitted_points = []
    for i in range(left, right):
        if abs(point_set[i].x - point_mid.x) <= dist_min:
            splitted_points.append(point_set[i])
    splitted_points.sort(key=lambda p: p.y)
 
    smallest = INF
    l = len(splitted_points)
    for i in range(0, l):
        for j in range(i + 1, l):
            if not (splitted_points[j].y - splitted_points[i].y) < dist_min:
                break
            d = distance(splitted_points[i], splitted_points[j])
            smallest = min(smallest, d)
    return smallest
 
 
def closest_util(point_set, left, right):
    if right - left <= 3:
        return brute_force(point_set, left, right)
    mid = (right + left) // 2
    dist_left = closest_util(point_set, left, mid)
    dist_right = closest_util(point_set, mid + 1, right)
    dist_min = min(dist_left, dist_right)
    return min(dist_min, strip_closest(point_set, left, right, mid, dist_min))
 
 
if __name__ == '__main__':
    while True:
        n = int(input())
        if n == 0:
            break
        point_set = []
        for i in range(n):
            x, y = map(float, input().split())
            point_set.append(Point(x, y))
 
        point_set.sort(key=lambda p: p.x)
        ans = closest_util(point_set, 0, n)
        if ans < 10000:
            print('%.4f' % ans)
        else:
            print('INFINITY')
---------Java8
import java.util.*;
 
public class Main {
    static final double INF = 1E9;
 
    static class Point {
        double x = 0, y = 0;
 
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static double distance(Point p1, Point p2) {
        double x = p1.x - p2.x;
        double y = p1.y - p2.y;
        return Math.sqrt(x * x + y * y);
    }
 
    static double bruteForce(ArrayList<Point> point_set, int left, int right) {
        double min_dist = INF;
        for (int i = left; i < right; ++i) {
            for (int j = i + 1; j < right; ++j) {
                min_dist = Math.min(min_dist, distance(point_set.get(i), point_set.get(j)));
            }
        }
        return min_dist;
    }
 
    static double stripClosest(ArrayList<Point> point_set, int left, int right, int mid, double dist_min) {
        Point point_mid = point_set.get(mid);
        ArrayList<Point> splitted_points = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (Math.abs(point_set.get(i).x - point_mid.x) <= dist_min) {
                splitted_points.add(point_set.get(i));
            }
        }
 
        Collections.sort(splitted_points, (o1, o2) -> Double.compare(o1.y, o2.y));
 
        double smallest = INF;
        int l = splitted_points.size();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l && (splitted_points.get(j).y - splitted_points.get(i).y) < dist_min; j++) {
                double d = distance(splitted_points.get(i), splitted_points.get(j));
                smallest = Math.min(smallest, d);
            }
        }
        return smallest;
    }
 
    static double closestUtil(ArrayList<Point> point_set, int left, int right) {
        if (right - left <= 3)
            return bruteForce(point_set, left, right);
 
        int mid = (right + left) / 2;
        double dist_left = closestUtil(point_set, left, mid);
        double dist_right = closestUtil(point_set, mid + 1, right);
        double dist_min = Math.min(dist_left, dist_right);
 
        return Math.min(dist_min, stripClosest(point_set, left, right, mid, dist_min));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double x, y;
        while (true) {
            n = sc.nextInt();
            if (n == 0)
                break;
            ArrayList<Point> point_set = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                x = sc.nextDouble();
                y = sc.nextDouble();
                point_set.add(new Point(x, y));
            }
 
            Collections.sort(point_set, ((o1, o2) -> Double.compare(o1.x, o2.x)));
            double ans = closestUtil(point_set, 0, n);
            if (ans < 10000)
                System.out.format("%.4f\n", ans);
            else
                System.out.println("INFINITY");
        }
 
        sc.close();
    }
}

--------cpp14
#include <stdio.h>
#include <float.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>
using namespace std;
#define INF 1e9
 
struct Point {
    double x, y;
    Point(double x = 0, double y = 0) : x(x), y(y) {}
};
 
bool xCompare(const Point &p1, const Point &p2) {
    return p1.x < p2.x;
}
 
bool yCompare(const Point &p1, const Point &p2) {
    return p1.y < p2.y;
}
 
double distance(Point &p1, Point &p2) {
    double x = p1.x - p2.x;
    double y = p1.y - p2.y;
    return sqrt(x * x + y * y);
}
 
double bruteForce(vector<Point> &point_set, int left, int right) {
    double min_dist = INF;
    for (int i = left; i < right; ++i) {
        for (int j = i + 1; j < right; ++j) {
            min_dist = min(min_dist, distance(point_set[i], point_set[j]));
        }
    }
    return min_dist;
}
 
double stripClosest(vector<Point> &point_set, int left, int right, int mid, double dist_min) {
    Point point_mid = point_set[mid];
    vector<Point> splitted_points;
    for (int i = left; i < right; i++) {
        if (abs(point_set[i].x - point_mid.x) <= dist_min) {
            splitted_points.push_back(point_set[i]);
        }
    }
 
    sort(splitted_points.begin(), splitted_points.end(), yCompare);
 
    double smallest = INF;
    int l = splitted_points.size();
    for (int i = 0; i < l; i++) {
        for (int j = i + 1; j < l && (splitted_points[j].y - splitted_points[i].y) < dist_min; j++) {
            double d = distance(splitted_points[i], splitted_points[j]);
            smallest = min(smallest, d);
        }
    }
    return smallest;
}
 
double closestUtil(vector<Point> &point_set, int left, int right) {
    if (right - left <= 3)
        return bruteForce(point_set, left, right);
 
    int mid = (right + left) / 2;
    double dist_left = closestUtil(point_set, left, mid);
    double dist_right = closestUtil(point_set, mid + 1, right);
    double dist_min = min(dist_left, dist_right);
 
    return min(dist_min, stripClosest(point_set, left, right, mid, dist_min));
}
 
int main() {
    int n;
    double x, y;
    while (true)
    {
        cin >> n;
        if (n == 0)
	break;
        vector<Point> point_set;
        for (int i = 0; i < n; i++) {
            cin >> x >> y;
            point_set.push_back(Point(x, y));
        }
 
        sort(point_set.begin(), point_set.end(), xCompare);
        double ans = closestUtil(point_set, 0, n);
        if (ans < 10000)
            cout << fixed << setprecision(4) << ans << endl;
        else
            cout << "INFINITY" << endl;
    }
 
    return 0;
}            
            
 */
public class ORANGE_L04P01 {

}
