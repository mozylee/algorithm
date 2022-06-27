wins = sum(1 if input() == "W" else 0 for _ in range(6))

value = -1
if wins >= 5:
    value = 1
elif wins >= 3:
    value = 2
elif wins >= 1:
    value = 3

print(value)    
