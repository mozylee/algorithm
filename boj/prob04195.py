# 출처: https://www.acmicpc.net/problem/4195
# 문제: 친구 네트워크


import sys
from collections import defaultdict

read = sys.stdin.readline

for _ in range(int(read())):
    humans = {}
    networks = defaultdict(set)
    for i in range(int(read())):
        friend1, friend2 = read().rstrip().split()
        if friend1 not in humans.keys() and friend2 not in humans.keys():
            humans[friend1] = i
            humans[friend2] = i
            networks[i].update({friend1, friend2})
        elif friend1 in humans.keys() and friend2 not in humans.keys():
            humans[friend2] = humans[friend1]
            networks[humans[friend1]].add(friend2)
        elif friend1 not in humans.keys() and friend2 in humans.keys():
            humans[friend1] = humans[friend2]
            networks[humans[friend2]].add(friend1)
        else:
            min_index = min(humans[friend1], humans[friend2])
            max_index = max(humans[friend1], humans[friend2])
            if min_index == max_index:
                print(len(networks[humans[friend1]]))
                continue
            for name in networks[max_index]:
                humans[name] = min_index
            networks[min_index].update(networks[max_index])
            del networks[max_index]

        print(len(networks[humans[friend1]]))
