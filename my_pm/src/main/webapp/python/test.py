# -*- coding: utf-8 -*-
"""
Created on Wed Aug 18 10:37:48 2021

@author: asus
"""

 
def func(a,b,c,d):
    return (a+b+c+d),d
 
if __name__ == '__main__':
    a = [1,2,3,4,5]
    print(a.pop(0))

    print(func(*a))