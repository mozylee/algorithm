Apples= sum((3-i)*int(input()) for i in range(3))
Bananas = sum((3-i)*int(input()) for i in range(3))


print('T' if Apples==Bananas else ('A' if Apples>Bananas else 'B'))
