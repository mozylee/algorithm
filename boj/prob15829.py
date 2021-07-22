alphabets = {chr(ord('a')+i-1): i for i in range(1, 26+1)}
r, m, _ = 31, 1234567891, input()
result = sum(((ord(ch)-ord('a')+1)*pow(r, i, m)) % m
             for i, ch in enumerate(input().rstrip()))
print(result)
