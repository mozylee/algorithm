count = 0

ans = []
while True:
    if input() == '0':
        break
    count += 1
    ans.append(f'Case {count}: Sorting... done!')

print(*ans, sep="\n")
