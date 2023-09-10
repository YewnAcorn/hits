# Carter Gunderson
# Lab 5

"""
policy iteration:
    start with random policy
    loop:
        evaluation step
        improvement step
"""

import random
import time



class Cell():
    def __init__(self, n=1):
        self.state = n # money
        self.actions = list(range(n+1)) #bet between 1 and n
        self.values = [0.0] * (n+1) #how good is the bet?
        self.action_values = dict(zip(self.actions, self.values)) # each bet and its corresponding value
        self.reward = 0
       
    def print_c(self):
        print(f"state: {self.state}")
        for action, value in self.action_values.items():
            print(f"{action} : {value}", end=' ')
        print()


class Agent():
    def __init__(self, debug=False):
        self.states = []
        self.c_state = 15
        self.debug = debug
        self.ph = 0.4 # probability of heads
        self.reward = 0

    def init_states(self):
        for i in range(101):
            self.states.append(Cell(i))


    def print_debug(self):
        if self.debug == True:
            for a in range(len(self.states)):
                self.states[a].print_c()

    
    def chooseStakes(self, rand=False):
        if rand == True: # exploration
                                #choose from the possible actions
            random.seed(time.time())
            return random.choice(self.states[self.c_state].actions)
        else: # exploitation
                             #choose the maximum action
            return max(self.states[self.c_state].action_values.values())
    
    def evaluation(self):
        #next state
        #myReturn = (0.9 * self.states[self.c_state].action_values ) + self.reward
        #current state
        #self.states[self.c_state].action_valies += 0.1*myReturn 
        return 0

    def coinFlip(self, wager):
        random.seed(time.time())
        coin = random.random()
        if coin < self.ph:
            print("heads")
            return wager
        else:
            print("tails")
            return -wager
    
    def game_logic(self, debug=True):
        stake = self.chooseStakes(rand=True)
        prev = self.c_state
        self.c_state += self.coinFlip(stake)
        if debug:
            print(f"state {prev}")
            print(f"bet {stake}")
            print(f"state {self.c_state}")
        if self.c_state == 0:
            self.reward -=1 
            myReturn = (0.9 * self.states[self.c_state].action_values[stake]) - 1
            self.states[prev].action_values[stake] += 0.1*myReturn
            print("game over: money gone")

        elif self.c_state >= 100:
            self.reward +=1
            myReturn = (0.9 * self.states[prev].action_values[stake]) + 1
            self.states[prev].action_values[stake] += 0.1*myReturn
            print("game over: 100 dollars")

willie = Agent(debug=False)
willie.print_debug()
willie.init_states()
willie.print_debug()
wager = willie.chooseStakes(rand=True)
willie.coinFlip(wager)

