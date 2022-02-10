from datetime import datetime, timedelta


hh, mm, ss = map(int, input().split())
cooking_second = int(input())

ret = datetime(2022, 2, 1, hh, mm, ss)+timedelta(seconds=cooking_second)
print(ret.hour, ret.minute, ret.second)
