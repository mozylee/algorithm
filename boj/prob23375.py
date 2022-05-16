x, y = map(int, input().split())
r = int(input())

left = x-r
right = x+r
up = y+r
down = y-r

print(left, up)
print(right, up)
print(right, down)
print(left, down)
