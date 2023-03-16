#Vasiliki Katogianni A.M. 4696 Zoi Kouvaka A.M. 4706 Athanasios Katsilieris A.M. 3247
from matplotlib import pyplot as plt 

M = [3,6,9,12]
E = [614.9371503221791,321.5393858287461,220.04217292074122,198.55918464398846]

plt.plot(M,E,marker='.')
plt.xlabel('Number of teams')
plt.ylabel('Minimum error')
plt.show()