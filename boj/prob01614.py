import sys

read = sys.stdin.readline

finger, count = (int(read()) for _ in range(2))

num = 8*(count//(1 if finger in (1, 5) else 2))
count = 1 if finger not in (1, 5) and count%2==1 else 0

for i in '12345432':
    if int(i) == finger:
        if count == 0:
            break
        count -= 1
    num += 1
print(num)
