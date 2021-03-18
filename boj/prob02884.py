# Backjoon Online Judge: https://www.acmicpc.net/problem/2884
# 내용없음

import sys
from datetime import timedelta

hour, minute = map(int, sys.stdin.readline().split())
sang_geun = timedelta(hours=hour, minutes=minute)
sec = (sang_geun - timedelta(minutes=45)).seconds

print(sec // 3600, sec % 3600 // 60)
