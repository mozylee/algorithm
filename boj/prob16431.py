Br, Bc = map(int, input().split())
Dr, Dc = map(int, input().split())
Jr, Jc = map(int, input().split())

Td = abs(Dr-Jr)+abs(Dc-Jc)
Gr, Gc = abs(Br-Jr), abs(Bc-Jc)
Tb = Gr + Gc - min(Gr, Gc)

print("bessie" if Tb < Td else ("daisy" if Tb > Td else "tie"))
