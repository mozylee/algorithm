d = ((1, 0), (-1, 1), (0, -1))


def solution(n):
    answer = [[0] * (n - i) for i in range(n)]
    length = n
    index, r, c = 0, -1, 0
    k = 1
    for _1 in range(n):
        for _2 in range(length):
            r += d[index][0]
            c += d[index][1]
            answer[r][c] = k
            k += 1
        index = (index + 1) % 3
        length -= 1
    return [answer[i - j][j] for i in range(len(answer)) for j in range(i + 1)]


def is_out_of_bounds(x: int, y: int, index: int, n: int) -> bool:
    x += d[index][0]
    y += d[index][1]
    return not (0 <= x < n and 0 <= y < n)


test_case = [4, 5, 6]
# [1,2,9,3,10,8,4,5,6,7]
# [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
# [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
for t in test_case:
    print(solution(t))
