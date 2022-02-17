W = sum(sorted(map(int, (input() for _ in range(10))), reverse=True)[:3])
K = sum(sorted(map(int, (input() for _ in range(10))), reverse=True)[:3])

print(W, K)