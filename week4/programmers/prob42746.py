# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42746
# 문제: 가장 큰 수

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    lesser_arr, equal_arr, greater_arr = [], [], []
    for num in arr:
        if num + pivot > pivot + num:
            lesser_arr.append(num)
        elif num + pivot < pivot + num:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)


def solution(numbers):
    answer = ''.join(quick_sort(list((map(str, numbers)))))
    return answer if int(answer) > 0 else '0'


print(solution([0, 0, 0, 0, 0]))
