# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42579
# 문제: 베스트앨범

def solution(genres, plays):
    songs = {g: [] for g in set(genres)}
    for i, (g, p) in enumerate(zip(genres, plays)):
        songs[g].append((i, p))
    g = sorted(list(set(genres)), key=lambda x: sum(map(lambda y: y[1], songs[x])), reverse=True)

    answer = []
    for genre in g:
        answer += [number for number, play in sorted(songs[genre], key=lambda x: x[1], reverse=True)[:2]]
    return answer


solution(['classic', 'pop', 'classic', 'classic', 'pop'], [500, 600, 150, 800, 2500])
