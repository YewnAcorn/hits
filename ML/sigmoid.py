import math
import matplotlib.pyplot as plt
import numpy as np

'''
x = np.linspace(-1, 1, 100)

y = 2 ** (-x)

a = plt.plot(x,y)

plt.show(a)
'''
""" the sigmoid function

a = g(h) = 1 / (1 + exp(-b + h)

    1
------------
1 + e**(-b*x)

"""
x = np.linspace(-5, 5, 100)
sigmoid = 1.0 / (1.0 + math.exp(5)) 

a = plt.plot(x, sigmoid)
plt.show(a)
