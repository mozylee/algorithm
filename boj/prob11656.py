# 출처: https://www.acmicpc.net/problem/11656
# 문제: 접미사 배열

s = input()
print('\n'.join(sorted([s[i:] for i in range(len(s))])))
