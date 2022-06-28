counts = {'A': 1, 'B': 0}

for _ in range(int(input())):
    A = counts['A']
    counts['A'] = 0
    counts['A'] += counts['B']
    counts['B'] += A

print(counts['A'],counts['B'])
