A, B, C, D, E = (int(input()) for _ in range(5))

print((B-max(A, 0)) * E + (0 if A > 0 else D + abs(A)*C))
