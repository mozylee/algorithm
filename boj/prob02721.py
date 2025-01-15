import sys

def read(): return sys.stdin.readline().rstrip()

# B3: Math, Implement
T = [i*(i+1)//2 for i in range(302)]
W = [0]*301

for i in range(1, 301):
    W[i] = W[i-1] + i * T[i+1]

print("\n".join(str(W[int(read())]) for _ in range(int(read()))))