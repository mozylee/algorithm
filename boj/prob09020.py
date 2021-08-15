import sys
read = sys.stdin.readline


def get_eratosthenes():
    eratosthenes = [True for _ in range(5500+1)]
    ret = list()
    for i in range(2, 5500+1):
        if not eratosthenes[i]:
            continue
        j = 2
        ret.append(i)
        while(i*j <= 5500):
            eratosthenes[i*j] = False
            j += 1
    return ret


eratosthenes = get_eratosthenes()

for _ in range(int(read())):
    n = int(read())
    goldbach = list()
    for i, k in enumerate(eratosthenes):
        if(k < n/3):
            continue
        elif(k > n):
            break
        for k2 in eratosthenes[i:]:
            if(k2 > n):
                break
            if(k+k2 == n):
                goldbach.append(tuple([k, k2]))
                break
    print(*sorted(goldbach, key=lambda x: abs(x[0]-x[1]))[0], sep=" ")
