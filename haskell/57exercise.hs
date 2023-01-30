--Exercises 5.7

--1
ta = sum [x^2 | x <- [1..100]] 

--2
gridd m n = [(x,y) | x<-[0..m], y<-[0..n]]

--3
square n = [(x, y) | x<-[0..n], y<-[0..n], x /= y]

--4
replic 0 x = []
replic n x = x : replic (n-1) x

--5
pyths n = [(x,y,z) |  x <- [1..n], y <- [1..n], z <- [1..n], x^2 + y^2 == z^2]

--6
factors n = [x | x <- [1..n], n `mod` x == 0]
perfects n = [x | x <-[1..n], x == (sum (factors x) -x) ] 

--7
--not sure how to do this one




