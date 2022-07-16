p1, q1, p2, q2 = map(int, input().split())

A, B = p1/q1, p2/q2
area = (p1*p2)/(q1*q2*2)

print(1 if area == int(area) else 0)