from datetime import datetime, timedelta
from math import ceil


YYYY, MM, DD = map(int, input().split())
birth_date = datetime(YYYY, MM, DD)

YYYY, MM, DD = map(int, input().split())
criteria_date = datetime(YYYY, MM, DD)

ages = [-1, 0, 0]

ages[1] = ceil((criteria_date-birth_date).days/365)
ages[2] = criteria_date.year-birth_date.year

while birth_date <= criteria_date:
    ages[0] += 1
    print(birth_date)
    birth_date += timedelta(days=365)


print(*ages, sep="\n")

print(birth_date, criteria_date)


