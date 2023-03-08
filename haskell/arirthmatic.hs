

data Op = Add | Sub | Mul | Div

instance Show Op where
   show Add = "+"
   show Sub = "-"
   show Mul = "*"
   show Div = "/"

apply :: Op -> Int -> Int -> Int
apply Add x y = x + y
apply Sub x y = x - y
apply Mul x y = x * y
apply Div x y = x `div` y


data Expr = Val Int | App Op Expr Expr



instance Show Expr where
   show (Val n)     = show n
   show (App o l r) = brak l ++ show o ++ brak r
                      where
                         brak (Val n) = show n
                         brak e       = "(" ++ show e ++ ")"

t0 = ( App Add (Val 1) ( App Mul (Val 2) (Val 3) ) ) 
-- prints out 1+(2*3)

values :: Expr -> [Int]
values (Val n)  = [n]
values (App _ l r) = values l ++ values r

eval :: Expr -> [Int]
eval (Val n) = [n]
eval (App o l r) = [apply o x y | x <- eval l,
                                  y <- eval r ]

t1 = eval (App Sub (Val 2) (Val 3))
--prints [-1]





