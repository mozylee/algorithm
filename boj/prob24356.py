t1, m1, t2, m2 = map(int, input().split())

T1 = t1*60 + m1
T2 = t2*60 + m2

if T1>T2:
    ret = T2 + 60*24 -T1
else:
    ret = T2-T1

print(ret, ret//30)
