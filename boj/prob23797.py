frogs = {'K': 0, 'P': 0}

for s in input():
    if s == 'K':
        if frogs['P'] > 0:
            frogs['P'] -= 1
        frogs['K'] += 1
    else:
        if frogs['K'] > 0:
            frogs['K'] -= 1
        frogs['P'] += 1

print(sum(frogs.values()))
