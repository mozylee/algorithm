import sys


read = sys.stdin.readline

def get_values(N:int)->list:
    ret = []
    
N = int(read())
values = get_values(N)
print(values[N//2 + (0 if N % 2 == 1 else -1)])
