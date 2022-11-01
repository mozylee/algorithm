import sys


read = sys.stdin.readline

word = read().rstrip()

length = len(word)
print(min(word[0:i][::-1] + word[i:j][::-1] + word[j:][::-1]
      for i in range(1, length-1) for j in range(i+1, length)))
