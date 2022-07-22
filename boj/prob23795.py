import sys


read = sys.stdin.readline

total_loss = 0
loss=0
while (loss := int(read())) > -1:
    total_loss += loss

print(total_loss)