# 출처: https://www.acmicpc.net/problem/10866
# 문제: 덱


class deque:
    def __init__(self):
        self.data = list()

    def empty(self):
        return 1 if len(self.data) == 0 else 0

    def size(self):
        return len(self.data)

    def front(self):
        return self.data[0] if not self.empty() else -1

    def back(self):
        return self.data[-1] if not self.empty() else -1

    def pop_front(self):
        return self.data.pop(0) if not self.empty() else -1

    def pop_back(self):
        return self.data.pop() if not self.empty() else -1

    def push_front(self, value):
        self.data.insert(0, value)

    def push_back(self, value):
        self.data.append(value)


from sys import stdin

n = int(stdin.readline())

my_deque = deque()
for _ in range(n):
    command = stdin.readline().rstrip().split()

    if command[0] == 'push_front':
        my_deque.push_front(int(command[1]))
    elif command[0] == 'push_back':
        my_deque.push_back(int(command[1]))
    elif command[0] == 'pop_front':
        print(my_deque.pop_front())
    elif command[0] == 'pop_back':
        print(my_deque.pop_back())
    elif command[0] == 'front':
        print(my_deque.front())
    elif command[0] == 'back':
        print(my_deque.back())
    elif command[0] == 'size':
        print(my_deque.size())
    elif command[0] == 'empty':
        print(my_deque.empty())
