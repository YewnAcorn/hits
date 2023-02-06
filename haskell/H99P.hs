--Problem 8
--Eliminate consecutive duplicates of list elements.
--If a list contains repeated elements they should be replaced with a single copy of the element.
--The order of the elements should not be changed. 


compress' [] = []
compress' (y:ys) = y: compress' ysTail 
      where
         ysTail = dropWhile' (\x -> x==y) ys


--Problem 9
--) Pack consecutive duplicates of list elements into sublists.
--If a list contains repeated elements they should be placed in separate sublists.


pack' [] = []
pack' (x:xs) = x: pack' xsTail
      where
         xsTail = takeWhile' (\d -> d==x) xs

pack'' xs  = group xs




takeWhile' p [] = []
takeWhile' p (x:xs) 
   |p x       = x: takeWhile' p xs 
   |otherwise = []



dropWhile' p [] = []
dropWhile' p (x:xs) 
   |p x       =  dropWhile' p xs 
   |otherwise =  (x:xs)




groupBy :: (a->a->Bool)->[a]->[[a]]
groupBy _ [] = []
groupBy eq (x:xs) = (x:ys) : groupBy eq zs
                    where (ys,zs) = span (eq x) xs


group :: Eq a => [a] -> [[a]]
group = groupBy (==)






length' [] = 0
length' (x:xs) = 1 + length xs
















--f and g
---- g :: a->b
--   f :: b->c
--   (f . g) x == f(g x)
--   f.g :: a->c
--   comp f g c = f(g x)
--
--   composition is the dot is  
--
--
--
--
