n = int(input())
fibo = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]
for i in range(18, n+1):
    fibo.append(fibo[i-1]+fibo[i-2])
print(fibo[n])
