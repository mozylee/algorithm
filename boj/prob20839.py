x,y,z = map(int,input().split())
_x,_y,_ = map(int,input().split())

if _y>=y:
    if _x>=x:
        print('A')
    elif _x>=x/2:
        print('B')
    else:
        print('C')
elif _y>=y/2:
    print('D')
else:
    print('E')