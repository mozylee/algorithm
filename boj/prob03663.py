# UNSOLVED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


from collections import deque
import sys

read = sys.stdin.readline

alphabet = {chr(i+65): (i, 26-i) for i in range(26)}


def get_joystick(s: str) -> int:
    ret = 0
    for c in s:
        ret += min(alphabet[c])
    return ret


def get_movement(s: str) -> int:
    dq = deque(s)
    while dq and dq[-1] == 'A':
        dq.pop()

    ret = 0
    while dq:
        ret += min(alphabet[dq.popleft()])+1
    return ret


ans = []
for _ in range(int(read())):
    name = read().rstrip()
    joystick = get_joystick(name)
    cursor_movement = get_movement(name)
    ans.append(joystick+cursor_movement)

print(*ans, sep="\n")
