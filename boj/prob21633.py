k = int(input())

fee = 25 + 0.01 * k
fee = 100.00 if fee <= 100 else (2000.00 if fee >= 2000 else fee)
print("%.3f" % fee)
