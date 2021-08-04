def solution(price, money, count):
    result = sum([price*(i+1) for i in range(count)])
    return result-money if result > money else 0
