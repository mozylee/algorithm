P = int(input())
C = int(input())
B = int(input())
E = int(input())
H = int(input())
G = int(input())

print(sum([P, C, B, E])-min(P, C, B, E)+max(H, G))
