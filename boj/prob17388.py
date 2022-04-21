scores = list(map(int, input().split()))

if sum(scores) >= 100:
    print("OK")
    exit(0)

university = ["Soongsil", "Korea", "Hanyang"]
print(university[min(range(3), key=lambda x: scores[x])])
