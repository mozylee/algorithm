import sys


read = sys.stdin.readline

alphabets = {}
ans = []
pangrams = ["Not a pangram", "Pangram!",
            "Double pangram!!", "Triple pangram!!!"]
for i in range(int(read())):
    for k in range(26):
        alphabets[chr(ord('a')+k)] = 0
    
    for c in read().rstrip():
        if not c.isalpha():
            continue

        alphabets[c.lower()] += 1

    ans.append(f"Case {i+1}: "+pangrams[min(alphabets.values())])

print(*ans, sep="\n")
