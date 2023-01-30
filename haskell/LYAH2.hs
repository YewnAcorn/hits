removeNonUpperCase :: String -> String
removeNonUpperCase st = [ c | c <- st, c `elem` ['A'..'Z'] ]

--max Int is 2147483647
addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

--Integer is Int but unbounded
factorial :: Integer -> Integer
factorial n = product [1..n]

--Float is real floating point with single precision
circumference :: Float -> Float
circumference r = 2 * pi * r

--Double is real floating point with double the 
--precision

circumference' :: Double -> Double
circumference' r = 2 * pi * r

com = "ABrakadabra" < "Zebrea"
com' = "ABrakadabra" `compare` "Zebrea"
com'' = 5 >= 2
com''' = 5 `compare` 2

shw = show 3
shw' = show 5.4
shw'' = show True

rd = read "True" || False  
 
rd' = read "8.2" + 3.8  
rd'' = read "5" - 2  
rd''' = read "[1,2,3,4]" ++ [3]  
--read is like opposite of show, but you cant just
--do read "4"
--cause it wont know the type
--you can specify the type like this:

red = read "5" :: Int
red' = read "5" :: Float
red'' = (read "5" :: Float) * 4
red''' = read "[1,2,3,4,5]" :: [Int]
red'''' = read "(3, 'a')" :: (Int, Char)


--Enum members are sequentially ordered types — they can be enumerated. The main advantage of the Enum typeclass is that we can use its types in list ranges. They also have defined successors and predecesors, which you can get with the succ and pred functions. Types in this class: (), Bool, Char, Ordering, Int, Integer, Float and Double.

en = ['a'..'e']
en' = [LT .. GT]
en'' = [3..5]
enm = succ 'B'

--Bounded means members have an upper and lower
--bound

bdnd = minBound :: Int
bdnd' = maxBound :: Char
bdnd'' = maxBound :: Bool
bdnd''' = minBound :: Bool

--minBound and maxBound are interesting because they have a type of (Bounded a) => a. In a sense they are polymorphic constants.


--All tuples are also part of Bounded if the components are also in it.
bunded = maxBound :: (Bool, Int, Char)

--Num is a numeric typeclass. Its members have the property of being able to act like numbers. 
--
--It appears that whole numbers are also polymorphic constants. They can act like any type that's a member of the Num typeclass.
--
--Integral is also a numeric typeclass. Num includes all numbers, including real numbers and integral numbers, Integral includes only integral (whole) numbers. In this typeclass are Int and Integer.
--
--Floating includes only floating point numbers, so Float and Double.
--
--A very useful function for dealing with numbers is fromIntegral. It has a type declaration of fromIntegral :: (Num b, Integral a) => a -> b. From its type signature we see that it takes an integral number and turns it into a more general number. That's useful when you want integral and floating point types to work together nicely. For instance, the length function has a type declaration of length :: [a] -> Int instead of having a more general type of (Num b) => length :: [a] -> b. I think that's there for historical reasons or something, although in my opinion, it's pretty stupid. Anyway, if we try to get a length of a list and then add it to 3.2, we'll get an error because we tried to add together an Int and a floating point number. So to get around this, we do fromIntegral (length [1,2,3,4]) + 3.2 and it all works out.
--
--Notice that fromIntegral has several class constraints in its type signature. That's completely valid and as you can see, the class constraints are separated by commas inside the parentheses.
