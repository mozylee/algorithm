from collections import defaultdict
import sys


read = sys.stdin.readline

working_time = [4, 6, 4, 10]

time_dict = defaultdict(int)

for i in range(4*int(read())):
    for worker in read().rstrip().split():
        if worker == '-':
            continue

        time_dict[worker] += working_time[i % 4]

print("Yes" if len(time_dict.keys()) == 0
      or max(time_dict.values())-min(time_dict.values()) <= 12 else "No")
