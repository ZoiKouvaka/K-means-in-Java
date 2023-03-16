#Vasiliki Katogianni A.M. 4696 Zoi Kouvaka A.M. 4706 Athanasios Katsilieris A.M. 3247
from matplotlib import pyplot as plt
with open('kmeans3.txt') as f:
    while True:
        line = f.readline()
        if not line:
            break
        if line=="\n":
            break
        line.strip()
        lineElements=line.split(',')
        x1=float(lineElements[0])
        x2=float(lineElements[1])
        category=int(lineElements[2])
        if category==0:
            plt.plot(x1,x2,marker='+',color='magenta')
        elif category==1:
            plt.plot(x1,x2,marker='+',color='limegreen')
        elif category==2:
            plt.plot(x1,x2,marker='+',color='blue')
        elif category==3:
            plt.plot(x1,x2,marker='+',color='cyan')
        elif category==4:
            plt.plot(x1,x2,marker='+',color='yellow')
        elif category==5:
            plt.plot(x1,x2,marker='+',color='orange')
        elif category==6:
            plt.plot(x1,x2,marker='+',color='black')
        elif category==7:
            plt.plot(x1,x2,marker='+',color='olive')
        elif category==8:
            plt.plot(x1,x2,marker='+',color='purple')
        elif category==9:
            plt.plot(x1,x2,marker='+',color='gray')
        elif category==10:
            plt.plot(x1,x2,marker='+',color='darkgreen')
        elif category==11:
            plt.plot(x1,x2,marker='+',color='brown')
        elif category==100:
            plt.plot(x1,x2,marker='*',color='red')
plt.show()
