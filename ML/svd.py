'''
create a 2d array
take svd
'''

import random
import numpy as np


def test_covar():
    x = []
    for i in range(10):
        x.append(random.random())
    return x

def test_scv():
    a = np.eye(5)
    b = np.array([[4,0,0],[0,3,0]])
    c = np.array([[1,1],[1,2]])
    u, s, vh = np.linalg.svd(c)
    
    #figure out how to get eigenvectors from this

    print(s)
    print(u)
    print(vh)

if __name__ == '__main__':
    test_scv()



