# 출처: https://www.acmicpc.net/problem/1620
# 문제: 나는야 포켓몬 마스터 이다솜


import sys

m, n = map(int, sys.stdin.readline().split())

pokemon_dict = dict()
pokemon_list = dict()

for i in range(1, m + 1):
    name = sys.stdin.readline().rstrip()
    pokemon_dict[name] = i
    pokemon_list[i] = name

for _ in range(n):
    command = sys.stdin.readline().rstrip()
    print(pokemon_dict[command] if command.isalpha() else pokemon_list[int(command)])
