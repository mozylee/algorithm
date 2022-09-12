

import sys


vowels = ("a", "i", "y", "e", "o", "u")
consonants = ("b", "k", "x", "z", "n", "h", "d", "c", "w", "g",
              "p", "v", "j", "q", "t", "s", "r", "l", "m", "f")

ROT13 = {c: consonants[(i+10) % 20] for i, c in enumerate(consonants)}
ROT13.update((v, vowels[(i+3) % 6]) for i, v in enumerate(vowels))
ROT13.update(tuple((k.upper(), v.upper()) for k, v in ROT13.items()))

for line in sys.stdin.readlines():
    print(
        *(map(lambda x: ROT13[x] if x in ROT13.keys() else x, line)), sep="", end="")
