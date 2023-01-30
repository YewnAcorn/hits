--lern you a haskell part 3 and beyond


xs = [(1,3), (4,3), (2,4), (5,3), (5,6), (3,1)]
nlist = [a+b | (a,b) <- xs]

tell :: (Show a) => [a] -> String
tell [] = "The list is empty"
tell (x:[]) = "The list has one element: " ++ show x
tell (x:y:[]) = "the list has two elements: " ++ show x ++ " and " ++ show y
tell (x:y:_) = "the list is long, the first 2 elements are: " ++ show x ++ " and " ++ show y

length' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1 + length' xs

capital :: String -> String
capital "" = "Empty string, whoops!"
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]


max' :: (Ord a) => a->a->a
max' a b
   | a > b = a
   | otherwise = b


bmiTell :: (RealFloat a) => a->a->String
bmiTell weight height
   | bmi <= 18.5 = "underweight"
   | bmi <= 25.0 = "healthy weight"
   | bmi <= 30.0 = "overweight"
   | otherwise = "very overweight"
   where bmi = weight / height ^ 2


--let bindings are like where but more local (they dont cross guards)
cylinder :: (RealFloat a) => a->a->a
cylinder r h =
   let sideArea = 2 * pi * r * h
       topArea = pi * r^2
   in  sideArea + 2 * topArea

--The form is let <bindings> in <expression>. The names that you define 
--in the let part are accessible to the expression after the in part

ex = [let square x = x * x in (square 5, square 3, square 2)]
ax = 4 * (let a = 9 in a + 1) + 2

--If we want to bind to several variables inline, we obviously can't 
--align them at columns. That's why we can separate them with semicolons.

ux = (let a = 100; b = 200; c = 300; in a*b*c, let foo="Hey "; bar = "there!" in foo++bar)


tup = (let (a,b,c) = (1,2,3) in a+b+c) * 100

calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi >= 25.0]  

--How to do case expressions in hs
case expression of pattern -> result  
	           pattern -> result  
	           pattern -> result  
	           ...  


describeList :: [a] -> String  
describeList xs = "The list is " ++ case xs of [] -> "empty."  
					      [x] -> "a singleton list."   
					       xs -> "a longer list."  
--They are useful for pattern matching against something in the middle 
--of an expression. Because pattern matching in function definitions is 
--syntactic sugar for case expressions, we could have also defined this like so:

describeList' :: [a] -> String  
describeList' xs = "The list is " ++ what xs  
    where what [] = "empty."  
          what [x] = "a singleton list."  
          what xs = "a longer list." 
