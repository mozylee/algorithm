N, B, H, W = map(int, input().split())

min_value = 1e9
for _ in range(H):
    p = int(input())
    for w in map(int, input().split()):
        min_value = min(min_value, N*p if w >= N and N*p<=B else min_value)

print(min_value if min_value < 1e9 else "stay home")
