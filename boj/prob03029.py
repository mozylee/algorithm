import sys
from datetime import *


read = sys.stdin.readline

before = datetime(2023, 1, 1, *map(int, read().split(":")))
after = datetime(2023, 1, 1, *map(int, read().split(":")))

td = after-before
if td.days < 0:
    td += timedelta(days=1)

td = str(td) if td.seconds > 0 else "24:00:00"
print(("0" if len(td) < 8 else "") + td)
