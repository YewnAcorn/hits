import Data.Char

--UPDATED with number 7:
positions x xs = [i | (x',i) <- zip xs [0..], x' == x]
leng xs = last [l | (x, l) <- zip xs [1..], x == last xs]

destr :: String -> [Char]
destr [] = []
destr str@(x:xs) = [x | x <-str]



dord [] = []
dord (x:xs) = [ord x - ord '0'] ++ dord xs

positions' n = [n-1, n-2 .. 0]

powers xs = positions' (leng xs)

tenth [] = []
tenth (x:xs) = 10^x: tenth xs

tuple_up xs = (zip (tenth(powers xs)) (dord xs))

numnom xs =[a*b | (a,b)<-tuple_up xs]
		
onesixseven xs = sum (numnom xs)
--------------------------
-- 1.
-- 3 :: Num a => a
-- even :: Integral a => a -> Bool
-- even 3 :: Bool
-- determined because it reduces to a boolean (False)
--
-- head :: [a] -> a
-- [1,2,3] :: Num a => [a]
-- head [1,2,3] :: Num a => a
--
-- What happens when applying a polymorphic function to an actual
-- parameter? The type is what it reduces to
--
-- 2. For each type write a function with that type
-- a) (Float -> Float) -> Float
-- b) Float -> (float -> Float)
-- c) (Float -> Float) -> (Float -> Float)
--

--3 Write the ncopies function (from Tim Sheard) that works 
--according to the following examples. Code this function 
--first without recursion and then with recursion. 
--ncpoies 3 5 gives [5,5,5]
--ncopies 0 True gies []
--ncopies 2 False gives [False, False]
--ncopies 4 "a" gives ["a","a","a","a"]

import Data.Char

ncopies x y = replicate x y

ncopies_recursion 0 _ = []
ncopies_recursion x y = [y] ++ ncopies_recursion (x-1) y

-- 4 Write a function diffs that retunrs a list of the 
-- differences between adjacent items so 
-- diffs [3,5,6,8] returns [2,1,2]

diffs [] = []
diffs [x] = [x]
diffs [x,y] = [abs (x - y)]
diffs (x:y:zs) = [abs (x - y)] ++ diffs (y:zs)

-- 5. Write a function groupByN with the type
-- groupByN :: Int -> [a] -> [[a]]
-- This function splits the given list in sub-lists 
-- (which result in a list of lists), where the sublists 
-- have a given length. Only the last sub-list may be 
-- shorter, if necessary. An example application of the 
-- function is:
--
-- groupByN 3 [1,2,3,4,5,6,7,8,9,10]
-- [[1,2,3], [4,5,6], [7,8,9], [10]]

--groupByN :: Int -> [a] -> [[a]]
--groupByN x y =[ [z | z <- take x y] ++ [b | b <- take x t let t = drop x y]]
--I cant figure this one out
-- Everything I try gives me weird errors that dont make sense to me

--6 design a way to represent straight lines in a cartesian coordinate
--system as internal data in Haskell (y=mx+b) 

line (x,y) m b = show y ++ " = " ++ show l where l = m*x+b
--not sure I got this one at all or even understand what its asking

-- 7 Write a function which converts a string of digits into an int.
-- you will need the following predefined function:
-- ord ‘1’       --> 49         first char in arg to its ascii code
-- follow the following "pipeline" analysis when defining your function
-- "167"  --> ['1','6','7'] --> [49,54,55] --> [1,6,7] --> [(1,100),(6,10),(7,1)]
--  --> [100, 60, 7] --> 167
--  (hint: the first function in the pipeline is very simple. why?)
--  ( because a string is already an array of characters )
--

--strToInt str@(x:xs) = ord x:strToInt xs
--I'm getting an error saying ord isnt a function right off the bat
--theres an easy way to do this 
funtimes str = read str::Int

--InClass 1.26
read' [] =  error "no empty list!!1"
read' [x] = (ord x - ord '0') 
read' (x:xs) = read' x : read' xs

one = ord '1' - ord '0'

--strToInt str@(x:xs) = a
--   where
  --    a = sum p

--list = [ord a - ord 0, ord b - ord 0, ord c - ord 0]








