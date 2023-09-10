# Carter Gunderson
# workshop week 1
"""
worked along in class

computing averages and 1-armed bandit
3 ways to compute averages

but we ran out of time so we didn't get
temporal difference so we'll do it on
thursday 

continued on thrusday: working
in class in breakout rooms with
briana, damian, andrew, davis,
duc, jadyn
pretty confused, I thought I
had an idea what these things
were, but the people in
the group have other ideas and
now I don't know.
"""


import random

print(random.randbytes(5))
print(random.random())
print(random.gauss(5, 6))


N = 1000

def average1():
    sum = 0
    for i in range(1, N):
        sum += i
    mean = sum / (N-1)
    print('avg1', mean)

"""
1 + 2 + 3 / 3
(1 + 2)/2 = avg * (2/3) =
(1 + 2)/3 + 3/3 = (1+2+3)/3
"""

def average2():
    avg = 0
    for i in range(1, N):
        avg = (avg * (i-1)/i) + i/i
    print('avg2', avg)


def average3():
# Q = Q + a*(R-Q)
# where Q is this case and R is the value to be averaged
    avg = 0
    for i in range(1, N):
        avg = avg + a * (avg + 1 - avg)
    print('avg3', avg)
# avg + (i -1)/i (i-avg)

if __name__ == '__main__':
    average1()
    average2()



