# 출처: https://www.acmicpc.net/problem/2309
# 문제: 일곱 난쟁이


from itertools import combinations


for dwarfs in combinations(sorted(int(input()) for _ in range(9)), 7):
    if sum(dwarfs) == 100:
        print("\n".join(map(str, dwarfs)))
        break
