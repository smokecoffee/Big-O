package bigO.orange01.lecture09;
/*
 * Camp Schedule
The new camp by widely-known over the country Spring Programming Camp is going to start soon. Hence, all the team of friendly curators and teachers started composing the camp's schedule. After some continuous discussion, they came up with a schedule ss, which can be represented as a binary string, in which the i^{th}i
​th
​​  symbol is 1 if students will write the contest in the i^{th}i
​th
​​  day and 0 if they will have a day off.

At the last moment Gleb said that the camp will be the most productive if it runs with the schedule tt (which can be described in the same format as schedule ss). Since the number of days in the current may be different from number of days in schedule tt, Gleb required that the camp's schedule must be altered so that the number of occurrences of tt in it as a substring is maximum possible. At the same time, the number of contest days and days off shouldn't change, only their order may change.

Could you rearrange the schedule in the best possible way?

Input
The first line contains string ss (1 \le |s| \le 500000)(1≤∣s∣≤500000), denoting the current project of the camp's schedule.

The second line contains string tt (1 \le |t| \le 500000)(1≤∣t∣≤500000), denoting the optimal schedule according to Gleb.

Strings ss and tt contain characters 0 and 1 only.

Output
In the only line print the schedule having the largest number of substrings equal to tt. Printed schedule should consist of characters 0and 1 only and the number of zeros should be equal to the number of zeros in ss and the number of ones should be equal to the number of ones in ss.

In case there multiple optimal schedules, print any of them.

Ví dụ
input
101101
110
output
110110
input
10
11100
output
10
input
10010110
100011
output
10001101

 */
public class ORANGE_L09P05 {

}
