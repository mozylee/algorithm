import datetime


def print_working_hours(h, m, s, h2, m2, s2):
    start = datetime.timedelta(hours=h, minutes=m, seconds=s)
    end = datetime.timedelta(hours=h2, minutes=m2, seconds=s2)
    working_hours = end - start
    print(*map(int, str(working_hours).split(":")), sep=" ")


for i in range(3):
    print_working_hours(*map(int, input().split()))
