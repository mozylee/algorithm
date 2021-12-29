number_dict = {
    "zero": "0",
    "one": "1",
    "two": "2",
    "three": "3",
    "four": "4",
    "five": "5",
    "six": "6",
    "seven": "7",
    "eight": "8",
    "nine": "9",
}


def solution(s: str) -> int:
    for k, v in number_dict.items():
        s = s.replace(k, v)
    return int(s)


test_cases = [
    "one4seveneight",
    "23four5six7",
    "2three45sixseven",
    "123",
]
# 1478
# 234567
# 234567
# 123

for t in test_cases:
    print(solution(t))
