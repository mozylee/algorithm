# 출처: https://www.acmicpc.net/problem/17269
# 문제: 이름궁합 테스트


alphabet = [
    3,
    1,
    2,
    2,
    4,
    3,
    1,
    3,
    1,
    1,
    3,
    1,
    3,
    2,
    1,
    2,
    2,
    2,
    1,
    2,
    1,
    1,
    1,
    2,
    2,
    1,
]
alphabets = {chr(ord("A") + i): str(a) for i, a in enumerate(alphabet)}
length1, length2 = map(int, input().split())

names = list(input().rstrip().split())

gap = abs(length1 - length2)
bigger = 0
if gap > 0 and length2 > length1:
    bigger = 1

nums = ""
for i, j in zip(names[0], names[1]):
    nums += alphabets[i] + alphabets[j]

if gap:
    for a in names[bigger][-gap:]:
        nums += alphabets[a]


def get_percent(s):
    if s == "100" or len(s) < 3:
        print(int(s), "%", sep="")
        return
    res = ""
    for c1, c2 in zip(s[:-1], s[1:]):
        res += str((int(c1) + int(c2)) % 10)
    get_percent(res)


get_percent(nums)

