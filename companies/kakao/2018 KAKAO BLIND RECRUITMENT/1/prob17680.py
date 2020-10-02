# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/17680
# 문제: 캐시
# 레벨: 2

def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5

    answer, time = 0, 0
    cache = {}

    for city in cities:
        for key in cache:
            cache[key] += 1

        city = city.lower()
        if city in cache:
            cache[city] = 0
            answer += 1
            continue

        if len(cache) < cacheSize:
            cache[city] = 0
            answer += 5
            continue

        del cache[max(cache, key=lambda x: cache[x])]
        cache[city] = 0
        answer += 5

    return answer


print(solution(2,
               ["Jeju", "Pangyo", "NewYork", "newyork"]))
