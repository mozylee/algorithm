import re
import sys


read = sys.stdin.readline

include_vowel = re.compile('[aeiou]')
double = re.compile('|'.join(
    chr(i)*2 for i in range(ord('a'), ord('z')+1) if chr(i) not in ('e', 'o')))
triple_consonant = re.compile('[^aeiou]{3}')
triple_vowel = re.compile('[aeiou]{3}')

ans = []
while (line := read().rstrip()) != "end":
    flag = include_vowel.search(line
    ) and not double.search(line
    ) and not triple_consonant.search(line
    ) and not triple_vowel.search(line)
    ans.append(f"<{line}> is " +
               ("acceptable." if flag else "not acceptable."))

print(*ans, sep="\n")
