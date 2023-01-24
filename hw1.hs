--1. Code the last function for lists using the built-in reverse function for lists. The last function returns the last element of a list. What will you do for the empty list? 
--

blast [] = error "no values in the list!!1"
blast [x] = x
blast (x:xs) = blast xs

--2. Code the init function for lists using the built-in reverse function for lists. The init function returns the list of all but the last element of a list. What will you do for the empty list? 
--

winit [] = error "cannot get init of empty list!!1"
winit [x] = []
winit (x:xs) = inx
		where 
		(y:ys) = reverse(x:xs)
		inx = reverse(ys)


--3. Code a function that returns the first and last elements of a list as a 2-tuple (a pair). Give a type for the function. Be sure to think about what you want to do for a list of length 0 or 1. 
--

ends :: [a] -> (a,a)
ends [] = error "no ends to the void"
ends [x] = (x,x)
ends (x:xs) = (x,y)
	where
	(y:ys) = reverse (x:xs)

--4. Code the function rangeProduct that computes according to the following examples . Return 0 if the second argument is smaller than the first. You decide what you want to do (if anything) for negative numbers. Write the program without recursion first and then write it with recursion. 
--
--without recursion

rangeProduct x y = if x > y then 0 else product [x..y]

--with recursion
rangeProduct' x y = if x > y then 0 else x * rangeProduct (x+1) y

-- 5. Code a version of the factorial function that uses your rangeProduct function . 

phactorial x = rangeProduct 1 x

-- 6. Write the power :: Integer -> Integer -> Integer function for integers without using the exponentiation operator. Code this function first without recursion and then with recursion. 

-- without recursion

powur x y = z
	where
	w = replicate x y
	z = product w

-- with recursion

powagh x 0 = 1
powagh x y = x * powagh x (y-1)



 
