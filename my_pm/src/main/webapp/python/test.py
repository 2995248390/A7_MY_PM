# -*- coding: utf-8 -*-
"""
Created on Wed Aug 18 10:37:48 2021

@author: asus
"""


import sys
 
def func(a,b):
    return (a+b)
 
if __name__ == '__main__':
    a = []
    for i in range(1, len(sys.argv)):
        a.append((int(sys.argv[i])))
    print(1)
    print(func(a[0],a[1]))