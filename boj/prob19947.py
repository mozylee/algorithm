import sys


read = sys.stdin.readline

H, Y = map(int, read().split())

money = [H]+[0]*Y
ONE, THREE, FIVE = 1, 3, 5
rate = [0, 1.05, 0, 1.2, 0, 1.35]
for i in range(1, Y+1):
    money[i] = max(money[i], int(money[i-ONE]*rate[ONE]))

    if i >= 3:
        money[i] = max(money[i], int(money[i-THREE]*rate[THREE]))

    if i >= 5:
        money[i] = max(money[i], int(money[i-FIVE]*rate[FIVE]))


print(money[Y])
