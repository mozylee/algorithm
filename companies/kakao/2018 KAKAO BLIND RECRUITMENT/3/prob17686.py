# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/17686
# 문제: 파일명 정렬

import re


def solution(files):
    regex = re.compile(r"(\D+)(\d{1,5})")
    dict_to_sort = {}
    for file in files:
        m = regex.search(file)
        if m.group(1).lower() not in dict_to_sort:
            dict_to_sort[m.group(1).lower()] = []
        dict_to_sort[m.group(1).lower()].append((int(m.group(2)), file))

    answer = []
    for head in sorted(dict_to_sort.keys()):
        answer.extend([x[1] for x in sorted(dict_to_sort[head], key=lambda x: x[0])])
    return answer


print(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))
