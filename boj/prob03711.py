import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    student_numbers = [int(input()) for _ in range(int(input()))]

    remainders = set()
    for i in range(1, max(student_numbers)+2):
        flag = True
        for n in student_numbers:
            if n % i in remainders:
                flag = False
                break
            remainders.add(n % i)

        if flag:
            ans.append(i)
            break
        remainders.clear()

print(*ans, sep = "\n")