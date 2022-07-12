from datetime import datetime


D, H, M = map(int, input().split())
base = datetime(2011, 11, 11, 11, 11)
time = datetime(2011, 11, D, H, M)
ans = (time-base).seconds//60 + (time-base).days*1440
print(-1 if ans<0 else ans)