from datetime import datetime, timedelta


months_dict = {month: i+1 for i, month in enumerate(("January", "February", "March", "April", "May", "June",
                                                     "July", "August", "September", "October", "November", "December"))}

month, DD, YYYY, HHMM = input().split(" ")

YYYY = int(YYYY)
month = months_dict[month]
DD = int(DD[:-1])
HH, MM = map(int, HHMM.split(":"))
# print(YYYY, month, DD, HH, MM)
start = datetime(year=YYYY, month=1, day=1, hour=0, minute=0, second=0)
date = datetime(year=YYYY, month=month, day=DD, hour=HH, minute=MM, second=0)
end = datetime(year=YYYY+1, month=1, day=1, hour=0, minute=0, second=0)
# print(start, end, date)
end_date, total_date = end-date, end-start
print(100-(end_date.days*86400+end_date.seconds) /
      (total_date.days*86400+total_date.seconds) * 100)
