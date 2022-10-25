N = int(input())


left, right = 1, N

while left <= right:
    mid = (left+right)//2

    if mid**2 == N:
        print(mid)
        exit(0)

    if mid**2 > N:
        right = mid-1
        continue

    if mid**2 < N:
        left = mid+1
        continue
