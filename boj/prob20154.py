from collections import deque

strokes = [3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1]
strokes_dict = {chr(65 + i): strokes[i] for i in range(len(strokes))}

cnt = 0
for s in input():
    cnt = (cnt + strokes_dict[s]) % 10

print("I'm a winner!" if cnt % 2 == 1 else "You're the winner?")
