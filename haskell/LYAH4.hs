multThree :: (Num a) => a -> a -> a -> a
multThree x y z = x * y * z

multTwoWithNine = multThree 9
--multTwoWithNine 2 3
--54

multWithEighteen = multTwoWithNine 2
--multWithEighteen 10
--180

--multThree 3 5 9 is really
--((multThree 3) 5) 9)
--where each function returns a function
--because they all only really have 
--one argument

compareWithHundred x = compare 100 x
compareWithHundred' = compare 100
--these work the same because compare takes
--two arguments, so leaving it out leaves it
--hanging for compareWithHundred' to need
--its like an invisible vaccuum
--called partial application

--can also use partial application with
--infix functions using sections
--like this
divideByTen :: (Floating a) => a -> a
divideByTen = (/10)

--a function that checks if a character
--supplied is an uppercase letter:
isUpperAlphanum :: Char -> Bool
isUpperAlphanum = (`elem` ['A'..'Z'])




