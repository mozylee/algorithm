antennas, eyes = map(int, (int(input()) for _ in range(2)))

if antennas>=3 and eyes<=4:
    print("TroyMartian")
if antennas<=6 and  eyes>=2:
    print("VladSaturnian")
if antennas<=2 and eyes<=3:
    print("GraemeMercurian")