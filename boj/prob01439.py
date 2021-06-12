# 출처: https://www.acmicpc.net/problem/1439
# 문제: 뒤집기

s = input()
compressed = s[0]
count = {str(i): 0 for i in range(2)}
count[s[0]] += 1
if len(s) == 1:
    print(0)
    exit(0)
for ch in s[1:]:
    if ch != compressed[-1]:
        compressed += ch
        count[ch] += 1
print(min(count.values()))

