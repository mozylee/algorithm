# 출처: https://www.acmicpc.net/problem/1735
# 문제: 분수 합


from math import gcd

num1, deno1 = map(int, input().split())
num2, deno2 = map(int, input().split())
GCD = gcd(deno1, deno2)

sum_num = num1 * deno2 // GCD + num2 * deno1 // GCD
sum_deno = deno1 * deno2 // GCD
GCD = gcd(sum_deno, sum_num)

print(sum_num // GCD, sum_deno // GCD)
