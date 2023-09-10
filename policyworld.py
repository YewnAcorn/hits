#!/usr/bin/python3
import random
import time 


# Carter Gunderson
# Lab 4 (Lab 3 continued)
# Now I need to implement the optimal policy
# 

def initGrid():
    grid = []
    rows = 5
    cols = 5
    for i in range(rows):
        row = []
        for j in range(cols):
            row.append(Cell(i, j))
        grid.append(row)
    return grid

def printGrid(grid):
    for rows in grid:
        for cell in rows:
            print(f"({cell.x}, {cell.y})", end=", ")
        print()


# so I think it will be something like 
# grid[3][3].updateValue('n', 0.99)

class Cell:
    def __init__(self, x, y):
        self.value = -1
        self.x = x
        self.y = y
        self.position = [x,y]
    

    def printCell(self):
        print(f"cell ({self.x}, {self.y})")
        print(f"{self.value}")

    
# max(a, key=a.get)
# how to get the key of the highest value


class Agent:
    #step1 takeAction:
        #update choice
        #update state
    #step2 getReward:
        #calculate reward
        #update state if necessary
        #update Cell object at 

    def __init__(self, grid):
        self.state = [3,3]
        self.nextState = [0,0]
        self.actions = ['n', 'e', 'w', 's'] # North, East, West, or South
        self.choice = ''
        self.reward = 0
        self.grid = grid
        self.greedy = False
    
    #Step 1: take action
    def takeAction(self):
        if self.greedy:
            self.greedyChoice()
            self.greedy = not self.greedy
        #self.makeChoice()  # updates choice variable
        else:
            self.makeChoice()
            self.makeMove()
            self.greedy = not self.greedy
        # print(self.choice)
        # print(self.state)
   
    # improvement step
    def greedyChoice(self):
        choices = {}
       
        if self.state[1] < 4:
            north = self.grid[self.state[0]][self.state[1] + 1]
            choice_N = self.grid[self.state[0]][self.state[1] + 1].value
            choices[north] = choice_N
        
        if self.state[0] < 4:
            east = self.grid[(self.state[0] + 1)][self.state[1]]
            choice_E = self.grid[self.state[0] + 1][self.state[1]].value
            choices[east] = choice_E
        
        if self.state[0] > 0:
            west = self.grid[self.state[0] - 1][self.state[1]]
            choice_W = self.grid[self.state[0] - 1][self.state[1]].value
            choices[west] = choice_W

        if self.state[1] > 0:
            south = self.grid[self.state[0]][self.state[1] - 1]
            choice_S = self.grid[self.state[0]][self.state[1] - 1].value
            choices[south] = choice_S
        

        greedy = max(choices, key=choices.get)
        next_x = greedy.x
        next_y = greedy.y
        self.nextState = [next_x, next_y]
        print("greedy choice:", self.nextState)
            


    # evaluation step:
    def makeChoice(self):
        random.seed(time.time())
        self.choice = random.choice(self.actions)
    
    def makeMove(self):
        if self.choice == 'e':
                self.nextState = [self.state[0] + 1, self.state[1]]
        elif self.choice == 'n':
                self.nextState = [self.state[0], self.state[1] + 1]
        elif self.choice == 's':
                self.nextState = [self.state[0], self.state[1] - 1]
        elif self.choice == 'w':
                self.nextState = [self.state[0] - 1, self.state[1]]
        
        print("random choice", self.nextState)
    #Step2 get reward
    def getReward(self):
        if self.nextState[0] < 0:
            self.nextState[0]+=1
            self.reward-=1

        elif self.nextState[1] < 0:
            self.nextState[1]+=1
            self.reward-=1

        elif self.nextState[0] > 4:
            self.nextState[0]-=1
            self.reward-=1

        elif self.nextState[1] > 4:
            self.nextState[1]-=1
            self.reward-=1

        elif self.nextState == [0,2]:
            self.reward += 10
#            print("Square A, jup to [2,2]")
 #           print(self.nextState)

        elif self.nextState == [0,4]:
            self.reward += 5
  #          print("Square B, jup to [3,4]")
   #         print(self.nextState)
        
        #update reward:
        #self.state = [yb,xb]

    def evaluation(self):
        x = self.nextState[0]
        y = self.nextState[1]

        myReturn = (0.9 * self.grid[x][y].value) + self.reward
        
        x = self.state[0]
        y = self.state[1]

        self.grid[x][y].value += myReturn * (0.01) 

        if self.nextState == [0,2]:
            self.nextState = [2,2] # the A square jump
            self.grid[0][2].value += myReturn * (0.01) 

        if self.nextState == [0,4]:
            self.nexState = [3,4] # the B square jump
            self.grid[0][4].value += myReturn * (0.01) 

        #print(self.state, self.reward, ' ', myReturn)
        self.state = self.nextState
        self.reward = 0


    #def improvement(self):

        



g0 = initGrid()
printGrid(g0)
t0 = Agent(g0)

for i in range(500):
    t0.takeAction()
    t0.getReward()
    t0.evaluation()

for rows in g0:
    for cell in rows:
        cell.printCell()


