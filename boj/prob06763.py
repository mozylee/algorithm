limit = int(input())
speed = int(input())

if speed <= limit:
    print("Congratulations, you are within the speed limit!")
    exit(0)

Fee = 100
if 1 <= speed-limit <= 20:
    Fee = 100
elif 21 <= speed-limit <= 30:
    Fee = 270
else:
    Fee = 500

print("You are speeding and your fine is $", Fee, ".", sep="")
