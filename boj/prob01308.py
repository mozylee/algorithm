from datetime import datetime
import sys


read = sys.stdin.readline

yyyy, mm, dd = map(int, read().split())
start = datetime(yyyy, mm, dd)
end = datetime(*map(int, read().split()))
after_1000_years = datetime(yyyy+1000, mm, dd)

print("gg" if end >= after_1000_years else f"D-{(end-start).days}")
