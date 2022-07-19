first, second, third = (int(input()) for _ in range(3))

print(2*min(first+third, first*2+second, second+third*2))