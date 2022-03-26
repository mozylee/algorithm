from datetime import datetime


hh, mm, ss = map(int, input().split(":"))
first = datetime(year=2022, month=4, day=27, hour=hh, minute=mm, second=ss)

hh, mm, ss = map(int, input().split(":"))
second = datetime(year=2022, month=4, day=27, hour=hh, minute=mm, second=ss)

print((second - first).seconds)