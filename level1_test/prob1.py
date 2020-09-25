from collections import Counter


def solution(s):
    return ''.join(sorted(s, reverse=True))
