nums = [0]*10

index = int(input())
for n in map(int, input().split()):
    nums[n]+=1

print(nums[index])