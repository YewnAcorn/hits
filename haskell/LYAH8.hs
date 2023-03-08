--data means defining a new type
--the part before the = denotes the type

-- data Bool = True | False

--the part after the = are value constructors
--they specify the different values this type can have
--the | is read as or
--
--so type Bool can have vlue of True or False
--
--like Int would be like this

--data Int = -2147483648 | -2147483648 | ... | -1 | 0 | 1 | 2 | ... | 2147482647

--Its not actually defined like this the elipses are to save time

--data Shape = Circle Float Float Float | Rectangle Float Float Float Float

--Think of it like circle value constructor has 3 fields which take floats. So when
--we write a value constructor we can optionally add some types after it and those
--types define the values it will contain. first two coordinates of center, third radius
--the rectangle value constructor has four fields which accept floats the first two are the
--coordinates to its upper left corner and the second two are coordinates to its lower right one

--Circle :: Float -> Float -> Float -> Shape
--Rectangle :: Float -> Float -> Float -> Float -> Shape

-- so value constructors are functions like everything else
-- make a function takes a shape and returns its surface

--surface :: Shape -> Float
--surface (Circle _ _ r) = pi * r ^ 2
--surface (Rectangle x1 y1 x2 y2) = (abs $ x2 -x1) * (abs $ y2 - y1)

--in order to be able to print out a type class we have to let
--haskell know it needs to be able to be part of the Show typeclass
--like so

--data Shape = Circle Float Float Float | Rectangle Float Float Float Float deriving (Show)

--now you can put in Circle or Rectangle to the interpreter and
--it will show the current values
--Value constructors are functions we can map them and partially
--apply them and everything. If we want a list of cocentric circles
--with different raii we can do this:

--Error on module Shapes
module Shapes
( Point (..)
, Shape(..)
, surface
, nudge
, baseCircle
, baseRect
) where

data Point = Point Float Float deriving (Show)
data Shape = Circle Point Float | Rectangle Point Point deriving (Show)

surface :: Shape -> Float
surface (Circle _ r) = pi * r ^ 2
surface (Rectangle (Point x1 y1) (Point x2 y2)) = (abs $ x2 - x1) * (abs $ y2 - y1)

t0 = map (Circle (Point 13 23)) [4,5,6,7]

nudge :: Shape -> Float -> Float -> Shape  
nudge (Circle (Point x y) r) a b = Circle (Point (x+a) (y+b)) r  
nudge (Rectangle (Point x1 y1) (Point x2 y2)) a b = Rectangle (Point (x1+a) (y1+b)) (Point (x2+a) (y2+b))  


nudge' :: Shape -> Float -> Float -> Shape
nudge' (Circle (Point x y) r) a b = Circle (Point (x+a) (y+b)) r


baseCircle :: Float -> Shape  
baseCircle r = Circle (Point 0 0) r  

baseRect :: Float -> Float -> Shape  
baseRect width height = Rectangle (Point 0 0) (Point width height)  

 
--A data type of a Person to include thier first name, last name
--age, height, phone number and favorite ice cream

-- data Person = Person String String Int Float String String deriving (Show)

-- To create functions to get separate info we could do it like this:
{-
firstName :: Person -> String  
firstName (Person firstname _ _ _ _ _) = firstname  

lastName :: Person -> String  
lastName (Person _ lastname _ _ _ _) = lastname  

age :: Person -> Int  
age (Person _ _ age _ _ _) = age  

height :: Person -> Float  
height (Person _ _ _ height _ _) = height  

phoneNumber :: Person -> String  
phoneNumber (Person _ _ _ _ number _) = number  

flavor :: Person -> String  
flavor (Person _ _ _ _ _ flavor) = flavor  
-}
-- but this is hard to write so haskell gives us a neater way:

data Person = Person { firstName :: String
                     , lastName :: String
                     , age :: Int
                     , height :: Float
                     , phoneNumber :: String
                     , flavor :: String
                     } deriving (Show)

guy1 = Person "Doctor" "Beechwood" 1 6.6 "123-321" "salmon"

