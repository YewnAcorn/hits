import numpy as np

def linreg(inputs,targets):

    inputs = np.concatenate((inputs,-np.ones((np.shape(inputs)[0],1))),axis=1)
    beta = np.dot(np.dot(np.linalg.inv(np.dot(np.transpose(inputs),inputs)),np.transpose(inputs)),targets)

    outputs = np.dot(inputs,beta)
    print(np.shape(beta))
    print(outputs)
    return beta


gInputs = np.array([[0,0],[0,1],[1,0],[1,1]])
gTargets = np.array([[0],[1],[1],[0]])

linreg(gInputs, gTargets)
