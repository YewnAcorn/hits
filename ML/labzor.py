import numpy as np
import math


# define inputs
# needs a 3rd dimension to be able to solve XOR
# 3rd dimension is 1 for 0,0 and 0 for the rest
inputs = np.array([[0,0,1],[0,1,0],[1,0,0],[1,1,0]]) 
targets = np.array([[0],[1],[1],[0]])

# capture how many nodes are needed by examining
# how many entries is in a set of input
n_in = np.shape(inputs)[1]
        
# how many values are we expecting as output?

# in this case, we want a single value as our output
n_out = 1
        
# η is the rate of which we learn from our data
# typically, 0.1 < η < 0.4
eta = 0.2

def insert_bias(_inputs):
         
    x = np.shape(_inputs)[0]
    return np.concatenate((_inputs,np.ones((x,1))),axis=1)
    
    
inputs = insert_bias(inputs)

weights = np.random.rand(np.shape(inputs)[1],np.shape(targets)[1])*0.1-0.05

print(f'weight vector:\n{weights}')

def calculate_activations(_inputs, _weights):

    fire = np.dot(inputs, weights)
    activations = np.where(fire>0,1,0)

    return activations



def update_weights(_inputs, _targets, _activations, _weights):
    
    # complete this funtion
    # function complete
    t_inputs = np.transpose(_inputs)
    err = _activations -_targets
    weights = _weights - eta*np.dot(t_inputs, err)
    
    return weights


iterations = 50



print(f'weight vector:\n{weights}')
print("entering loop")
for i in range(iterations):
    
    print(f'weight vector:\n{weights}')

    print(f"iteration {i}")
    activations = calculate_activations(inputs, weights)
    compare = activations == targets
    if(compare.all()):
        print("success!")
        print("the machine has learned!")
        print(activations)
        break
    else:
        weights = update_weights(inputs, targets, activations, weights)
        
    
