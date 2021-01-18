# 출처: https://www.acmicpc.net/problem/10816
# 문제: 숫자 카드2


import sys

cards = {}
result = []

_ = sys.stdin.readline()
for card in sys.stdin.readline().rstrip().split():
    if card not in cards:
        cards[card] = 0
    cards[card] += 1

_ = sys.stdin.readline()
for card in sys.stdin.readline().rstrip().split():
    result.append(str(cards[card]) if card in cards else '0')

print(' '.join(result))
