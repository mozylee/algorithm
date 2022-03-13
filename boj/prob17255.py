from collections import defaultdict

N = input()
cache = defaultdict(int)
nums = set(list(N))


def make_zero(n: int):
    return n if n > 0 else 0


def dfs(s: str, count: int, max_length: int):
    if count == max_length:
        cache[s] = -1
        return 1 if s == N else 0

    if cache[s] != 0:
        return make_zero(cache[s])

    sum_child = 0
    for n in nums:
        left = 0
        if n+s != s+n:
            left = make_zero(dfs(n+s, count+1, max_length))
        right = make_zero(dfs(s+n, count+1, max_length))

        sum_child += left+right

    cache[s] = sum_child if sum_child > 0 else -1
    return cache[s]


print(dfs("", 0, len(N)))
