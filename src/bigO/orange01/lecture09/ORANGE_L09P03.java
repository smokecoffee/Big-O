package bigO.orange01.lecture09;
/*
 * Good Substrings
You've got string ss, consisting of small English letters. Some of the English letters are good, the rest are bad.

A substring s[l...r]s[l...r] (1 \le l \le r \le |s|)(1≤l≤r≤∣s∣) of string s = s_1s_2...s_{|s|}s=s
​1
​​ s
​2
​​ ...s
​∣s∣
​​  (where |s|∣s∣ is the length of string ss) is string  s_l s_{l+1} ... s_rs
​l
​​ s
​l+1
​​ ...s
​r
​​ 

The substring s[l...r]s[l...r] is good, if among the letters  s_l, s_{l+1}, ..., s_rs
​l
​​ ,s
​l+1
​​ ,...,s
​r
​​  there are at most kk bad ones (look at the sample's explanation to understand it more clear).

Your task is to find the number of distinct good substrings of the given string ss. Two substrings s[x...y]s[x...y] and s[p...q]s[p...q] are considered distinct if their content is different, i.e. s[x...y] \neq s[p...q]s[x...y]≠s[p...q].

Input
The first line of the input is the non-empty string ss, consisting of small English letters, the string's length is at most 15001500 characters.

The second line of the input is the string of characters 0 and 1, the length is exactly 2626 characters. If the i^{th}i
​th
​​  character of this string equals 1, then the i^{th}i
​th
​​  English letter is good, otherwise it's bad. That is, the first character of this string corresponds to letter "a", the second one corresponds to letter "b" and so on.

The third line of the input consists a single integer kk (0 \le k \le |s|)(0≤k≤∣s∣) — the maximum acceptable number of bad characters in a good substring.

Output
Print a single integer — the number of distinct good substrings of string ss.

Ví dụ
input
ababab
01000000000000000000000000
1
output
5
input
acbacbacaa
00000000000000000000000000
2
output
8
 */
public class ORANGE_L09P03 {

}
