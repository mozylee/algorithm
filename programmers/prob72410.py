import re


def solution(new_id):
    # 1단계
    id = new_id.lower()
    # 2단계
    id = re.sub("[^a-z0-9\-_\.]", "", id)
    # 3단계
    id = re.sub("\.{2,}", ".", id)
    # 4단계
    id = re.sub("^\.{1,}", "", id)
    id = re.sub("\.{1,}$", "", id)
    # 5단계
    if len(id) == 0:
        id += "a"
    # 6단계
    id = id[:15]
    id = re.sub("\.{1,}$", "", id)
    # 7단계
    if len(id) < 3:
        id += id[-1]*(3-len(id))
    return id


new_ids = ["...!@BaT#*..y.abcdefghijklm", "z-+.^.",
           "=.=", "123_.def", "abcdefghijklmn.p"]


for n in new_ids:
    print(solution(n))
