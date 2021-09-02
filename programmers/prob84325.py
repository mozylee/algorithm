from collections import defaultdict


def solution(table, languages, preference):
    groups = {group.split()[0]: {language: (5-i) for i, language in enumerate(group.split()[1:])}
              for group in table}
    language_dict = defaultdict(int)
    for l, p in zip(languages, preference):
        language_dict[l] = p
    return sorted(groups.keys(), key=lambda x: (-get_sum(groups[x], language_dict), x))[0]


def get_sum(group, language):
    ret = 0
    for l, p in group.items():
        ret += language[l]*p
    return ret


tables = [["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"],
          ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]]
languages = [["PYTHON", "C++", "SQL"], ["JAVA", "JAVASCRIPT"]]
preferences = [[7, 5, 5], [7, 5]]
for t, l, p in zip(tables, languages, preferences):
    print(solution(t, l, p))
