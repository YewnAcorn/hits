import random
import numpy as np

# inputs are N x m | N = input vectors; m = number of inputs| 4x3
vectors_nor_nand= np.array([[0,0,-1],[0,1,-1],[1,0,-1],[1,1,-1]]) # includes -1 for bias
vectors_not = np.array([[0,-1],[1,-1]]) # includes -1 for bias

# targets are N x n | n = number of neurons| 4x1
targets_NOT = np.array([1, 0])
targets_NOR = np.array([1, 0, 0, 0])
targets_NAND = np.array([1, 1, 1, 0])
eta = 0.25

def orlock(inputs, targets):
    # weights are m x n | 3 x 1
    s = np.shape(inputs)
    weights = np.array([random.uniform(-1,1) for i in range(s[1])])
    count = 0

    for i in range(10):
        # activations are N x n | like targets | 4x1    
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


orlock(vectors_nor_nand, targets_NOR)
orlock(vectors_nor_nand, targets_NAND)
orlock(vectors_not, targets_NOT)





