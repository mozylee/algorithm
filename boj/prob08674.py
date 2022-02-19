a, b = map(int, input().split())

half_a, half_b = a//2, b//2

cut_a = abs(a*b - 2*half_a*b)
cut_b = abs(a*b - 2*half_b*a)

print(min(cut_a, cut_b))
