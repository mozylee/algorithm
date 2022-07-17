f1, f2, f3, f4 = (int(input()) for _ in range(4))

if f1<f2<f3<f4:
    print("Fish Rising")
elif f1>f2>f3>f4:
    print("Fish Diving")
elif f1==f2==f3==f4:
    print("Fish At Constant Depth")
else:
    print("No Fish")