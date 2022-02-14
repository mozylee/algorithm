S = int(input())

k = 0
ret = 0
while S > k:
    ret += 1
    k += 1
    S -= k

print(ret)