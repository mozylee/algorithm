def solution(enter, leave):
    result = [0]*len(leave)
    room = set()
    enter.reverse()
    for l in leave:
        while enter and l not in room:
            room.add(enter.pop())
        room.remove(l)
        result[l-1] += len(room)
        for r in room:
            result[r-1] += 1
    return result


test_cases = [[[1, 3, 2], [1, 2, 3]],
              [[1, 4, 2, 3], [2, 1, 3, 4]],
              [[3, 2, 1], [2, 1, 3]],
              [[3, 2, 1], [1, 3, 2]],
              [[1, 4, 2, 3], [2, 1, 4, 3]]]
for e, l in test_cases:
    print(solution(e, l))
