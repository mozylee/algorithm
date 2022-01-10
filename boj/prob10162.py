from logging.handlers import TimedRotatingFileHandler


n = int(input())
A, B, C = 5 * 60, 60, 10

if n % C > 0:
    print(-1)
    exit(0)

a = n // A
n %= A
b = n // B
n %= B
c = n // C
n %= C

print(a, b, c)
