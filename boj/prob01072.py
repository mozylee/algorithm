# 출처: https://www.acmicpc.net/problem/1072
# 문제: 게임


def get_percent(x, y):
    return y * 100 // x


x, y = map(int, input().split())

z = get_percent(x, y)

if 99 <= z <= 100:
    print(-1)
    exit(0)

asd = []
s, e = 1, 1000000000
answer = 1000000000
while s <= e:
    mid = (s + e) // 2
    next_z = get_percent(x + mid, y + mid)

    if z < next_z:
        if mid < answer:
            answer = mid
        e = mid - 1
    else:
        s = mid + 1
print(answer)

