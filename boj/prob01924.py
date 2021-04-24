# Backjoon Online Judge: https://www.acmicpc.net/problem/1924
# 내용없음

from datetime import date

month, day = map(int, input().split())
now = date(year=2007, month=month, day=day)
print(['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN'][now.weekday()])
