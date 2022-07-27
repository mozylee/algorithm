from collections import defaultdict


areas = defaultdict(int)

T, price = map(int, input().split())
for _ in range(T):
    area, room = input().split()
    areas[room] += int(area)

print(sum(areas.values()))
print(areas["bedroom"])
print(price * (sum(areas.values()) - areas["balcony"]/2))