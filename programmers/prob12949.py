def solution(arr1, arr2):
    n, m, l = len(arr1), len(arr1[0]), len(arr2[0])
    ret = [[0] * l for _ in range(n)]
    for i in range(n):
        for j in range(l):
            partial_sum = 0
            for k in range(m):
                partial_sum += arr1[i][k] * arr2[k][j]
            ret[i][j] = partial_sum
    return ret


test_cases = [
    [[[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]],
    [[[2, 3, 2], [4, 2, 4], [3, 1, 4]], [[5, 4, 3], [2, 4, 1], [3, 1, 1]]],
]
# [[15, 15], [15, 15], [15, 15]]
# [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
for a1, a2 in test_cases:
    print(solution(a1, a2))
