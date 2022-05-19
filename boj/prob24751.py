A = 0.25
C = 1.0

opt1 = int(input())
opt2 = 100-opt1

A_count = A*opt1
C_count = C*opt2


print((100*A)/A_count, (100*C)/C_count, sep="\n")
