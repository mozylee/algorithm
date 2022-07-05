import sys

read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    h, w = map(int, read().split())
    bmi = w/(h/100)**2
    if h <= 140:
        ans.append('6')
    elif h < 146:
        ans.append('5')
    elif h < 159:
        ans.append('4')
    elif h < 161:
        ans.append('3' if 16 <= bmi < 35 else '4')
    elif h < 204:
        if 20 <= bmi < 25:
            ans.append('1')
        elif 18.5 <= bmi < 20 or 25 <= bmi < 30:
            ans.append('2')
        elif 16 <= bmi < 18.5 or 30 <= bmi < 35:
            ans.append('3')
        else:
            ans.append('4')
    else:
        ans.append('4')

print(*ans, sep="\n")
