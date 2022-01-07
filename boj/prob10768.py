# solve 1
def solution1(month, day):
    FAB, EIGHT_TEENth = 2, 18

    if month < FAB:
        return "Before"
    elif month > FAB:
        return "After"
    else:
        if day < EIGHT_TEENth:
            return "Before"
        elif day > EIGHT_TEENth:
            return "After"
        else:
            return "Special"


# solve 2
def solution2(month, day):
    import datetime

    FAB_EIGHTTEEN = datetime.date(year=2222, month=2, day=18)
    date = datetime.date(year=2222, month=month, day=day)
    message = (
        "Special"
        if date == FAB_EIGHTTEEN
        else "Before"
        if date < FAB_EIGHTTEEN
        else "AFTER"
    )
    return message


month, day = int(input()), int(input())
print(solution1(month, day))
print(solution2(month, day))
