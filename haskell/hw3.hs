--Carter Gunderson
--Haskell HW 3
--
--1 Write a function flatten that takes a list of lists and flattens it to a single list.
--For example, flatten [[1,2,3], [4,5,6,7], [8,9,10,11,12] ] 
--produces the list [1,2,3,4,5,6,7,8,9,10,11,12]

flatten' :: [[a]] -> [a]

flatten' [[]] = []
flatten' [] = []
flatten' (x:xs) = x ++ flatten' xs


--2 Write a function remdups that removes all duplicates from a list. 
remdups ::(Eq a) => [a] -> [a]
remdups [] = []
remdups (x:xs) 
      | elem x xs = remdups xs
      | otherwise = x: remdups xs


--3 Write a function scanSum that adds the items in a list and
--returns a list of the running totals. 
--So, scanSum [2,3,4,5] returns [2,5,9,14]. (from HWIB, Lists II)
--
--after getting help from Sherri I have the right answer,
--one way is to get it to work in the way I was thinking
--with the sum of all - the sum of xs and the other way
--its sort of what I first thought it would be, in that same
--kind of clever way as other haskell things in this chapter:

--way with sums
--

scanSum''' xs = map sum (reverse (subLists (length xs) xs))
   where
      subLists 0 xs = []
      subLists n xs = take n xs : subLists (n-1) xs

--way that looks like haskell in the chapter

scanSum'[] = []
scanSum' (x:y:zs) = x:scanSum' ((x+y):zs)


--4. Write a function group that takes a list and returns a list of lists 
--such that the concatenation of the result is equal to the original 
--argument. Each sublist in the result contains only equal elements.
--For example, group "Mississippi" produces 
--[ "M", "i", "ss", "i", "ss", "i", "pp", "i"]. 
--

group [] = []
group (x:xs) = (x: takeWhile (\d -> d==x) xs) : group (dropWhile (\d -> d==x) xs)
  


--5  Write a function listDiff with two lists as parameters that deletes 
--every occurrence of every element of the second list from the first list. 
--This is analogous to a set difference. 

lastDiff xs [] = xs
lastDiff xs (y:ys) = lastDiff (filter (/=y) xs) ys
-- I was stuck on this one for a couple hours tring to use takeWhile /dropWhile
-- then I looked at the example on canvas and saw what I really wanted was the
-- filter function!


