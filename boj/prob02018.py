N = int(input())

left, right = 0, 0
sum_of_natural_numbers = 0
count = 0
while left <= right and right<=N:
    if sum_of_natural_numbers == N:
        count += 1
    if sum_of_natural_numbers < N:
        right += 1
        sum_of_natural_numbers += right
        # print(left, right, sum_of_natural_numbers)
        continue
    left += 1
    sum_of_natural_numbers -= left
    # print(left, right, sum_of_natural_numbers)

print(count)
