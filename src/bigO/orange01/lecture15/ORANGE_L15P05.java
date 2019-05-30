package bigO.orange01.lecture15;
/*
 Circular RMQ
You are given a circular array a_0, a_1, ..., a_{n-1}a
​0
​​ ,a
​1
​​ ,...,a
​n−1
​​ . There are two types of operations with it:

inc(lf,rg,v)inc(lf,rg,v) — this operation increases each element on the segment [lf,rg][lf,rg] (inclusively) by vv
rmq(lf,rg)rmq(lf,rg) — this operation returns minimal value on the segment [lf,rg][lf,rg] (inclusively). Assume segments to be circular, so if n=5n=5 and lf=3lf=3, rg=1rg=1, it means the index sequence: 3,4,0,13,4,0,1.
Write program to process given sequence of operations.

Input
The first line contains integer nn (1 \le n \le 200000)(1≤n≤200000). The next line contains initial state of the array: a_0,a_1,...,a_{n-1}a
​0
​​ ,a
​1
​​ ,...,a
​n−1
​​  (-10^6 \le a_i \le 10^6)(−10
​6
​​ ≤a
​i
​​ ≤10
​6
​​ ), a_ia
​i
​​  are integers. The third line contains integer mm (0 \le m \le 200000)(0≤m≤200000), — the number of operations. Next mm lines contain one operation each. If line contains two integer lf,rglf,rg (0 \le lf, rg \le n - 1)(0≤lf,rg≤n−1) it means rmqrmq operation. If contains three integers lf, rg, vlf,rg,v (0 \le lf, rg \le n - 1; -10^6 \le v \le 10^6)(0≤lf,rg≤n−1;−10
​6
​​ ≤v≤10
​6
​​ ) — incinc operation.

Output
For each rmqrmq operation write result for it.

Ví dụ
inputcopy
4
1 2 3 4
4
3 0
3 0 -1
0 1
2 1
outputcopy
1
0
0

 */
public class ORANGE_L15P05 {

}
