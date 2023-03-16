#Vasiliki Katogianni A.M. 4696 Zoi Kouvaka A.M. 4706 Athanasios Katsilieris A.M. 3247
from matplotlib import pyplot as plt
with open('data1.txt') as f:
    while True:
        line = f.readline()
        if not line:
            break
        line.strip()
        lineElements=line.split(',')
        x1=float(lineElements[0])
        x2=float(lineElements[1])
        plt.plot(x1,x2,marker='+',color='blue')
plt.show()
