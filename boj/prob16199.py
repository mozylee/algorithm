YYYY1, MM1, DD1 = map(int, input().split())
YYYY2, MM2, DD2 = map(int, input().split())

years_old = YYYY2-YYYY1
print(years_old + (0 if MM2 > MM1 else (0 if MM2 >= MM1 and DD2 >= DD1 else -1)))
print(years_old + 1)
print(years_old)
