import random
import numpy as np

class ordinator:

    def __init__(self,inputs,targets):
        self.size = np.shape(inputs)[1]
        self.rows = np.shape(inputs)[0]
        self.num_t = np.shape(targets)[1]
        self.out = 1
        self.eta = 0.25
        
        self.weights = np.random.rand(self.size+1, self.num_t)*0.1-0.05

    def load_bias(self, inputs, x0):
        return np.concatenate((inputs,np.ones((self.rows,x0))),axis=1)
    
    
    def fire(self, inputs):
        activations = np.dot(inputs, self.weights)
        fire = np.where(activations>0,1,0)
        return fire

    def exp_up(self, inputs, targets, activations):
        error = (activations - targets)
        transinputs = np.transpose(inputs)
        self.weights -=self.eta*np.dot(transinputs, error)
        return self.weights

  
    def orlock(self, inputs, targets, iterations):
        count = 0
        inputs = self.load_bias(inputs, 1)
        for i in range(iterations):

            activations = self.fire(inputs) 
            print(f"iteration {count}") 
            
            print(f'targets = {targets}')
            print(f'fired = {activations}')

            compare = activations == targets
            if(compare.all()):
                print("success!")
                print(activations)
                return self.weights
            else:
                self.exp_up(inputs, targets, activations)
                count += 1


testin = np.array([[0,0],[0,1],[1,0],[1,1]])
testout = np.array([[0],[0],[0],[1]])
p = ordinator(testin,testout)
p.orlock(testin, testout, 10)






