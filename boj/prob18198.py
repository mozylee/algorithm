from collections import defaultdict


scores = defaultdict(int)
opposite = {'A': 'B', 'B': 'A'}

flag = False
record = input()
for i in range(len(record)//2):
    s = record[2*i:2*(i+1)]
    player, c = s[0], int(s[1])
    scores[player] += c
    # print(scores)
    if not flag:
        if scores[player] >= 11:
            print(player)
            break
        elif scores[player] == scores[opposite[player]] == 10:
            flag = True
    elif flag and scores[player] >= scores[opposite[player]]+2:
        print(player)
        break
