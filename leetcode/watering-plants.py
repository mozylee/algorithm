from collections import deque


class Solution(object):
    def wateringPlants(self, plants, capacity):
        ret, step = 0, 0
        can = capacity
        plants = deque(plants)
        while plants:
            if plants[0] > can:
                ret += step * 2
                can = capacity

            step += 1
            ret += 1
            can -= plants.popleft()
        return ret


test_cases = [
    [[2, 2, 3, 3], 5],
    [[1, 1, 1, 4, 2, 3], 4],
    [[7, 7, 7, 7, 7, 7, 7], 8],
]

# 14
# 30
# 49

s = Solution()
for plants, capacity in test_cases:
    print(s.wateringPlants(plants, capacity))
