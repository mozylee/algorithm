# AC

def solution(id_list, report, k):
    reported = {id: 0 for id in id_list}
    reports = {id: set() for id in id_list}

    for r in report:
        id, _id = r.split()
        if _id not in reports[id]:
            reported[_id] += 1
        reports[id].add(_id)
    return [len(list(filter(lambda x: reported[x] >= k, reports[id]))) for id in id_list]


test_cases = [[["muzi", "frodo", "apeach", "neo"],	["muzi frodo",
                                                    "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],	2], [["con", "ryan"],	["ryan con", "ryan con", "ryan con", "ryan con"], 3]]

for i, r, k in test_cases:
    print(solution(i, r, k))
    print()


# [2,1,1,0]
# [0,0]
