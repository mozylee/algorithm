x, k = map(int,input().split())

can_make_snowman = lambda x, k, value : x>=value*k
print_size = lambda k, value : print(int(value*1000)*k)
 
if can_make_snowman(x, k, 7):
    print_size(k, 7)
elif can_make_snowman(x, k, 3.5):
    print_size(k, 3.5)
elif can_make_snowman(x, k, 1.75):
    print_size(k, 1.75)
else:
    print_size(k, 0)