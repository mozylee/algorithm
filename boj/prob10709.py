import sys


read = sys.stdin.readline

H, W = map(int, read().split())
sky = [[-1 if c == '.' else 0 for c in read().rstrip()] for _ in range(H)]

for i in range(H):
    for j in range(1, W):
        sky[i][j] = min(sky[i][j] if sky[i][j] >= 0 else 1e9, sky[i][j-1]+1) if sky[i][j-1] >= 0 else sky[i][j]

print("\n".join(" ".join(map(str, line)) for line in sky))
