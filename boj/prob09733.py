from collections import defaultdict
import sys


job_dict = defaultdict(int)
for job in sys.stdin.read().rstrip().split():
    job_dict[job] += 1
total = sum(job_dict.values())

jobs = ["Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"]
for job in jobs:
    print(f"{job} {job_dict[job]} {job_dict[job]/total:.2f}")

print(f"Total {total} 1.00")
