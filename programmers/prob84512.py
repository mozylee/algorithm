from itertools import product


def solution(word):
    words = get_words()
    return words[word]


def get_words():
    word = {'A', 'E', 'I', 'O', 'U'}
    words = set()
    for i in range(5):
        words.update(''.join(c)
                     for c in product(word, repeat=i+1))
    return {word: i+1 for i, word in enumerate(sorted(words))}


words = ["AAAAE", "AAAE", "I", "EIO"]

for w in words:
    print(solution(w))
