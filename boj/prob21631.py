white, black = map(int, input().split())

white = black - 1 if white >= black-1 else white

print(white+1)