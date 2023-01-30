--1
and' :: [Bool] -> Bool
and' (x:xs) = x && and' xs

concat' :: [[a]] -> [a]
concat' [] = []
concat' [[]] = []  
concat' (x:xs) = x ++ concat' xs 

--produce a list with identical elements
replicate' :: Int -> a -> [a]
replicate' 0 x = []
replicate' w x = x : replicate' (w-1) x

--select the nth element of a list:
bangbang :: [a] -> Int -> a
bangbang xs n = head (drop n xs)

--decide if a value is an element of a list
elem' :: Eq a => a -> [a] -> Bool
elem' n [] = False
elem' n (w:ws) = if n == w then True else elem' n ws

--2
--Define a recursive function
--that merges two sorted lists of values
--to give a single sorted list
merge :: Ord a => [a] -> [a] -> [a]
merge x [] = x
merge [] y = y
merge (x:xs) (y:ys) = if x < y then x:y:merge xs ys else y:x:merge xs ys

--3
--Definte a recursive function
--that implements merge sort with
--the rules: list of len <= 1 are already sorted;
--other lists can be sorted by sorting two halves and
--merging the results

msort :: Ord a => [a] -> [a]
msort [] = []
msort xs = if length xs == 1 then xs else msort xs

--msort all@(x:xs) = merge (msort smaller) (msort bigger)
--   where
--      smaller = [a | a<-take((length all)/2) all, a <= x]
--      bigger  = [b | b<-drop((length all)/2)all, b > x]
--
--cant get this one
