import sys


read = sys.stdin.readline

ans = []
group = 1
while (N := int(read())) > 0:
    students = []
    for _ in range(N):
        student, *result = read().rstrip().split()
        students.append([student, result])

    nasty = []
    for i, (name, result) in enumerate(students):
        for j, r in enumerate(result):
            if r == "P":
                continue
            nasty.append(f"{students[(i-(j+1)+N)%N][0]} was nasty about {name}")

    if not nasty:
        nasty.append("Nobody was nasty")
    ans.append(f"Group {group}\n"+"\n".join(nasty)+"\n")
    group += 1

print(*ans, sep="\n", end = "")
