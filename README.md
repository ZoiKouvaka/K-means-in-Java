# K-means-in-Java
K-means algorithm in Java

java generateData1>data1.txt creates an 1200 example file with random (x1,x2) examples as following:

1) 150 examples in square [0.8,1.2]x[0.8,1.2] 
2) 150 examples in square [0,0.5]x[0,0.5], 
3) 150 examples in square [0,0.5] x [1.5,2], 
4) 150 examples in square [1.5,2]x[0,0.5], 
5) 150 examples in square [1.5,2] x [1.5,2], 
6) 75 examples in square [0.8, 1.2]x[0,0.4], 
7) 75 examples in square [0.8, 1.2] x [1.6,2], 
8) 75 examples in square [0.3,0.7]x[0.8,1.2], 
9) 75 examples in square [1.3,1.7] x [0.8,1.2], 
10) 150 examples in square [0,2]x[0,2].

java KMeans>kmeansM.txt creates clustered- examples file (M is the number of centers we used in KMeans file)
run drawData.py to see clusters created by KMeans, drawData.py should open kmeansM.txt from previous step
