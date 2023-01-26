doubleMe x = x + x

doubleUs x y = doubleMe x + doubleMe y     

doubleSmallNumber x = if x > 100 then x else x*2

doubleSmallNumber' x = (if x > 100 then x else x*2) + 1

lostNumbers = [1,2,5,666,6]

helloW = "hello" ++ " " ++ "World"

woot = ['w','o'] ++ ['o','t']

cat = 'A':" SMALL CAT"

getFirstElement x = x !! 0

b = [[1,2,3,4],[5,5,5,5],[4,3,2,1],[1,2,3]]

b' = b ++ [[7,7,7,7]]

b'' = [6,6,6]:b'

b''' = b !! 2

compareList x y = x > y

g = head lostNumbers

g' = tail lostNumbers

g'' = last lostNumbers

g''' = init lostNumbers

l = length lostNumbers

l' = null lostNumbers

l'' = null []

l''' = reverse lostNumbers

t = take 3 lostNumbers

t' = drop 3 lostNumbers

t'' = drop 100 lostNumbers

m = maximum lostNumbers

m' = minimum lostNumbers

--sum takes numbers and returns their sum
--product returns product
--elem takes a thing and a list of things and tells us if that thing is an element of the list
--its usually called as in an infix function because its easier to read that way

tElem = 4 `elem` [3,4,5,5]
--will return True
--backticks `` are used to make an infix function

--Ranges
--list all numbers 1 to 20:
twent = [1..20]

alf = ['a'..'z']

--you can also specify a step:

step = [2, 4..20]

--cycle takes a list and cycles it into an infinite list
--you have to slice it somewhere
--
cyc = take 10 (cycle [1,2,3])

--repeat takes an element and produces an infinite list of just that element
--like cycle but for just one

rep = take 10 (repeat 5)

--replicate is simpler

repl = replicate 3 6

listcomp = [x*2 | x <- [1..10], x*2 >= 12]

--How about if we wanted all numbers from 50 to 100 whose remainder when divided with the number 7 is 3? Easy.

listCompre = [ x | x <- [50..100], x `mod` 7 == 3] 

boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <-xs, odd x]

--e can include several predicates. If we wanted all numbers from 10 to 20 that are not 13, 15 or 19, we'd do:
--

notTeens = [ x | x <- [10..20], x /= 13, x /= 15, x /= 19]

-- If we have two lists, [2,5,10] and [8,10,11] and we want to get 
-- the products of all the possible combinations between numbers in 
-- those lists, here's what we'd do.
combo = [ x*y | x <- [2,5,10], y <- [8,10,11]]

--What if we wanted all possible products that are more than 50?

combo' = [ x*y | x <- [2,5,10], y <- [8,10,11], x*y > 50]

--How about a list comprehension that combines a list of adjectives and a list of nouns 
--
nouns = ["hobo","frog","pope"]
adjectives = ["lazy","grouchy","scheming"]
fun = [adjective ++  " " ++ noun | adjective <- adjectives, noun <- nouns]


length' xs = sum [1 | _ <- xs]

removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']]


--Nested list comprehensions are also possible if you're operating 
--on lists that contain lists. A list contains several lists of numbers.
--Let's remove all odd numbers without flattening the list.

xxs = [[1,3,5,2,3,1,2,4,5],[1,2,3,4,5,6,7,8,9],[1,2,4,2,1,6,3,1,3,2,3,6]]

nestd = [ [ x | x <- xs, even x ] | xs <- xxs]

--Tuples
tup = [(1,2),(8,11),(4,5)]

--functions for pairs (2-tuple)
tfst = fst (8,11) --returns first component

tsnd = snd (8, 11) --returns second component

--zip is a cool function that takes to lists and then zips them together
-- into one list by joining the matching elements into pairs
-- useful for combining two lists or traversing two lists simultaneously

zztop = zip [1,2,3,4,5] [5,5,5,5,5]
zztop'= zip [1,2,3,4,5] ["one","two","three","four","five"]

--The longer list simply gets cut off to match the 
--length of the shorter one. Because Haskell is lazy, 
--we can zip finite lists with infinite lists:

infin = zip [1..] ["apple","orange","cherry"]

triangles = [ (a,b,c) | c <- [1..10], b <- [1..10], a <- [1..10] ]

-- Next, we'll add a condition that they all have to be right 
-- triangles. We'll also modify this function by taking into 
-- consideration that side b isn't larger than the hypothenuse 
-- and that side a isn't larger than side b.

rightTriangles = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b], a^2 + b^2 == c^2, a+b+c == 24]

fac n = if n == 0 then 1 else n * fac (n-1)


--four paradigms of languages:
--logical = PROLOG
--	made by doing proofs
--	no memory
--object orient = small talk
--	memory oriented
--imperative = C, pascal
--	von neuman, updating memory locations
--	modeled by a tape and you can jump and alter the tape
--
--functional = haskell, ML
--	no memory
--each have their own virtual machine
--Turing complete: can compute anything that is computable
--lamda calculus -is turing complete
--
foo = \x -> \y -> x+y


fhead (x:_) = x
ftail (_:xs) = xs

n1 [] _ = error "empty list!"
n1 (x:_) 0 = x
n1 (_:xs) n = n1 xs (n-1)

ln [] = 0
ln (_:xs) = 1 + ln xs






