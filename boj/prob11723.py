# 출처: https://www.acmicpc.net/problem/11723
# 문제: 집합


class MySet:
    def __init__(self):
        self.data = []

    def check(self, x):
        return 1 if x in self.data else 0

    def add(self, x):
        if not self.check(x):
            self.data.append(x)

    def remove(self, x):
        if self.check(x):
            self.data.remove(x)

    def all(self):
        self.data = [i for i in range(1, 21)]

    def empty(self):
        if len(self.data):
            self.data.clear()

    def toggle(self, x):
        self.remove(x) if self.check(x) else self.add(x)


from sys import stdin


mySet = MySet()
n = int(stdin.readline())
for _ in range(n):
    command = stdin.readline().rstrip().split()

    if command[0] == 'add':
        mySet.add(int(command[1]))
    elif command[0] == 'remove':
        mySet.remove(int(command[1]))
    elif command[0] == 'toggle':
        mySet.toggle(int(command[1]))
    elif command[0] == 'check':
        print(mySet.check(int(command[1])))
    elif command[0] == 'all':
        mySet.all()
    elif command[0] == 'empty':
        mySet.empty()
