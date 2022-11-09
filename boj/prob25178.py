from collections import defaultdict
import sys


read = sys.stdin.readline


def is_same_first_and_end(A: str, B: str) -> bool:
    return A[0] == B[0] and A[-1] == B[-1]


def is_same_word_with_out_vowel(A: str, B: str) -> bool:
    _A, _B = A[:], B[:]

    for v in ("a", "e", "i", "o", "u"):
        _A = _A.replace(v, "")
        _B = _B.replace(v, "")

    return _A == _B


def is_similar(A: str, B: str) -> bool:
    dict_A = defaultdict(int)
    dict_B = defaultdict(int)

    for a, b in zip(A, B):
        dict_A[a] += 1
        dict_B[b] += 1

    for k, v in dict_A.items():
        if k not in dict_B or dict_B[k] != v:
            return False

    return True

read()

A, B = map(str.rstrip, (read(), read()))


print("YES"
      if is_same_first_and_end(A, B)
      and is_same_word_with_out_vowel(A, B)
      and is_similar(A, B)
      else "NO")
