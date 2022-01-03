C4, A3, A4 = map(int, input().split())

C4_size = 0.229 * 0.324
A3_size = 0.297 * 0.420
A4_size = 0.210 * 0.297

print(C4 * 2 * C4_size + A3 * 2 * A3_size + A4 * A4_size)
