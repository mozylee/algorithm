from collections import defaultdict
import sys


read = sys.stdin.readline

decimal_36_value = {chr(ord('0' if i < 10 else 'A') + i -
                        (0 if i < 10 else 10)): i for i in range(36)}

decimal_36_key = {i: chr(ord('0' if i < 10 else 'A') + i -
                  (0 if i < 10 else 10)) for i in range(36)}

flag = True
def get_double_36_decimal(n: int) -> int:
    ret = ""
    while n > 0:
        ret += decimal_36_key[n % 36]
        n //= 36
    if len(ret)==0:
        ret = "0"
    return ret[::-1]


N = int(read())
nums = [read().rstrip()[::-1] for _ in range(N)]
K = int(read())

if N==0:
    print(0)
    exit(0)
weights = defaultdict(int)
for num in nums:
    for i, c in enumerate(num):
        weights[c] += 36**i

for n in sorted(decimal_36_value.keys(), key=lambda x: -(decimal_36_value['Z']-decimal_36_value[x])*weights[x])[:K]:
    decimal_36_value[n]=35

ans=0
for k, v in weights.items():
    ans += decimal_36_value[k] * v

print(get_double_36_decimal(ans))
