# teaching a perceptron about OR
# using a supervised learning model

bias = -1

"""
In1 In2 t
0   0   0
0   1   1
1   0   1
1   1   1
"""

w0 = -0.05
w1 = -0.02
w2 = 0.02

def fire(y):
    if y > 0 :
        return 1
    else :
        return 0

def update33(wij, yj, tj, xi):
    w = wij - 0.25 * (yj-tj) * xi
    return w


def feed(In1, In2):
    y = w0 * bias + In1 * w1 + In2 * w2
    return y

def perceptron(inputs, targets, weights)
    y = feed(inputs[0], inputs[1])
    t = fire(y)
    if t == targets[0]:
        # good
    else:
        weights[0] = update33(weights[0], t, targets[0], inputs[0]
