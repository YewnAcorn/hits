#!/usr/bin/python3
# Carter Gunderson
# Simulation of a RL agent
# learning to estimated value
# of a 10 armed bandit
"""
need:
    actual value of bandits
    estimated value of bandits
    number of turns on each bandit
    reward from each bandit so far
    epsillon value for exploration

steps:
intiialize bandits
loop for number of steps
choose an action
get reward
update bandit (value and counts)
update total rewards and total counts

"""

import random
import time


def banditInit():
    random.seed(22)
    means_actual = []

    for i in range(10):
        means_actual.append(random.randint(-2,7))

    return means_actual


def tenArmedBandit(choice, means_actual):  #0-9

    result = random.gauss(means_actual[choice], 1)
    
    return result


class Agent:
    def __init__(self):
        self.estimation = [0,0,0,0,0,0,0,0,0,0]
        self.moves = [0,0,0,0,0,0,0,0,0,0]
        self.reward = [0,0,0,0,0,0,0,0,0,0]
        self.epsilon = 0.1
        self.choice = 0

    def makeChoice(self):
        random.seed(time.time())
        spin = random.random()
        if (spin  > self.epsilon):
            self.choice = self.estimation.index(max(self.estimation))
            ties = []
            # needs to break ties randomly
            for i in self.estimation:
                if self.estimation[self.choice] == i:
                   ties.append(self.estimation.index(i))

            if len(ties) > 1:
                random.seed(time.time())
                self.choice = random.choice(ties)
            # print(f"greedy move. estimated reward {self.estimation[self.choice]} at {self.choice}")
          
        #explore
        elif self.epsilon >= spin:
            random.seed(time.time())
            self.choice = random.randint(0,9)
            # print(f"exploratory move, chosing {self.choice}")
        
        #print(f"choice made: {self.choice}")


    def playBandit(self):
        #print(f"playing at choice {self.choice}")
        self.moves[self.choice] += 1
        k = self.moves[self.choice]
        new_reward = tenArmedBandit(self.choice, banditInit())
        #temporal difference
        self.estimation[self.choice] += (1/k)  * (new_reward - (self.reward[self.choice]
                                                             /self.moves[self.choice]))
        self.reward[self.choice] += new_reward
        # print(f"new reward! {self.reward[self.choice]} estimated reward {self.estimation[self.choice]}")



if __name__ == '__main__':
    print("in the main")
    estimatron = Agent()
    print("starting game")
    for i in range(20000):
        estimatron.makeChoice()
        estimatron.playBandit()
    print("done!")
    mean_actual = banditInit()
    print(f"mean actual = {mean_actual}")
    print(f"estimation = {estimatron.estimation}")






#Testing
"""
a = banditInit()


for i in range(10):
    print(tenArmedBandit(i, a))

print()

for i in range(10):
    print(tenArmedBandit(i, a))

"""







