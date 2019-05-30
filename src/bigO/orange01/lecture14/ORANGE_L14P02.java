package bigO.orange01.lecture14;
/*
 Text Editor
One of the most useful tools nowadays are text editors, their use is so important that the Unique Natural Advanced Language (UNAL) organization has studied many of the benefits working with them.

They are interested specifically in the feature "find", that option looks when a pattern occurs in a text, furthermore, it counts the number of times the pattern occurs in a text. The tool is so well designed that while writing each character of the pattern it updates the number of times that the corresponding prefix of the total pattern appears on the text.

Now the UNAL is working with the editor, finding patterns in some texts, however, they realize that many of the patterns appear just very few times in the corresponding texts, as they really want to see more number of appearances of the patterns in the texts, they put a lower bound on the minimum number of times the pattern should be found in the text and use only prefixes of the original pattern. On the other hand, the UNAL is very picky about language, so they will just use the largest non-empty prefix of the original pattern that fit into the bound.

Input
The first line contains the text A(1 \le |A| \le 10^5)A(1≤∣A∣≤10
​5
​​ ). The second line contains the original pattern B(1 \le |B| \le |A|)B(1≤∣B∣≤∣A∣). The third line contains an integer n (1 \le n \le |A|)n(1≤n≤∣A∣) - the minimum number of times a pattern should be found on the text.

Output
A single line, with the prefix of the original pattern used by the UNAL, if there is no such prefix then print IMPOSSIBLE

Ví dụ
inputcopy
aaaaa
aaa
4
outputcopy
aa
inputcopy
programming
unal
1
outputcopy
IMPOSSIBLE
inputcopy
abracadabra
abra
1
outputcopy
abra
inputcopy
Hello World!
H W
5
outputcopy
IMPOSSIBLE
 */
public class ORANGE_L14P02 {

}
