import sys
import math

def Combination(n,r):
    return (int)(math.factorial(n)/(math.factorial(r)*math.factorial(n-r)))

def getRow(rowIndex):
    res = [1,1]
    for i in range (1, rowIndex):
        res.insert(1,Combination(rowIndex,i))
    return res

if __name__ == "__main__" :
    print(getRow(5))