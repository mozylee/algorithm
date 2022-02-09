from datetime import datetime, timedelta


hh, mm = map(int, input().split())
cooking_minute = int(input())

ret = datetime(2022, 2, 1, hh, mm)+timedelta(minutes=cooking_minute)
print(ret.hour,ret.minute)
