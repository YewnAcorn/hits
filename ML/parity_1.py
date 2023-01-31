## Carter Gunderson
## Machine Learning week 3 HW
## problem 3.3
## the parity problem returns 1 if the number of inputs that are 1 is even
## and 0 otherwise. Can a perceptron learn this problem for three inputs?
## Design the network and try it

"""
---------------
 in1 in2 in3 t 
 --------------
  0   0   0  0
  0   0   1  0
  0   1   0  0
  0   1   1  1
  1   0   0  0
  1   0   1  1
  1   1   0  1
  1   1   1  0 

"""

import random
import numpy as np

# inputs are N x m | N = input vectors; m = number of inputs| 8x4
vectors = np.array([[0,0,0,-1], [0,0,1,-1], [0,1,0,-1],[0,1,1,-1],[1,0,0,-1],[1,0,1,-1],[1,1,0,-1],[1,1,1,-1]]) # includes -1 for bias

# targets are N x n | n = number of neurons| 8x1
targets = np.array([0,0,0,1,0,1,1,0])
eta = 0.25

def orlock(inputs, targets):
    # weights are m x n | 
    s = np.shape(inputs)
    weights = np.array([random.uniform(-1,1) for i in range(s[1])])
    count = 0

    for i in range(90):
        # activations are N x n | like targets | 8x1    
        activations = np.dot(inputs, weights)
       
        print(f"weights{weights}")
        print(f"iteration {count}") 
        print(activations)
        
        fire = np.where(activations>0,1,0) # matric where 1 is for activated and 0 for unactivated
        print(f" targets: {targets}")
        print(fire)
        compare = fire == targets
        if(compare.all()):
            print("success!")
            print(activations)
            break
        else:
            weights -= eta*np.dot(np.transpose(inputs), fire-targets)
            count += 1


orlock(vectors, targets)


## the perceptron never finds it even with 90 tries
## the it can find OR, NAND, etc in < 10 tries

