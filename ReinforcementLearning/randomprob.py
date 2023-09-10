import random

def probability_less_than(n, threshold=0.1):
    count_less_than = 0
    
    for _ in range(n):
        random_float = random.random()
        
        if random_float < threshold:
            count_less_than += 1

    probability = count_less_than / n
    return probability

n = 1000  # Number of tries
probability = probability_less_than(n)
print("Probability of random numbers being less than 0.1:", probability)

