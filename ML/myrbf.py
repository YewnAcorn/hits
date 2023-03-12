# Carter Gunderson
# following a youtube tutorial:
# "Raidal Basis Interpolation From Scratch Using Python"
import numpy as np
import matplotlib.pyplot as plt


xk = np.linspace(0, 1, 5)
x = np.linspace(0,1,100)

# the target
def true_fn(x): return x**2-x-np.cos(np.pi*x)


# a nifty way to get the distance between all the points
def distance(x, xn):
    return np.sqrt((xn.reshape(-1,1) - x.reshape(1,-1))**2)

# a function to calculate the gausian rbf
def gaussian(radius,eps):
    return np.exp(-(eps*radius)**2)

print(gaussian(distance(xk, xk), 2))

class radial_base(object):
    # get epsillon value
    def __init__(self, eps):
        self.eps = eps
    
    def fit(self, xk, yk):
        self.xk = xk
        transformation = gaussian(distance(xk,xk), self.eps)
        
        #get the weights by solving for them
        self.weight = np.linalg.solve(transformation, yk)
        
    #make it callable with an input
    def __call__(self,xn):
        transformation = gaussian(distance(xn,xk), self.eps)
        return transformation.dot(self.weight)

# create an object with epsillon 2
nterp = radial_base(2)

yk = true_fn(xk)

nterp.fit(xk,yk)

nterp(x)
