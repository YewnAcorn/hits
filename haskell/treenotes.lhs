foldr (\x y -> x:y) [] [2,3,4,5]
[2,3,4,5]

foldr 
This is a generic tree -- values held at all nodes
both internal and leaves. Allows an Empty tree

> data Tree a = Empty | Leaf a | Node (Tree a) a (Tree a)
>   deriving Show

could have done:
data Tree a  = Empty | Node (Tree a) a (Tree a)

Node Empty 1 Empty

> preOrder Empty = []
> preOrder (Leaf v) = [v]
> preOrder (Node l v r) = v : (preOrder l) ++ (preOrder r)

> inOrder Empty = []
> inOrder (Leaf v) = [v]
> inOrder (Node l v r) = (inOrder l) ++ [v] ++ (inOrder r)

postOrder

> mapT f Empty = Empty
> mapT f (Leaf v) = (Leaf (f v))
> mapT f (Node l v r) = Node (mapT f l) (f v) (mapT f r)

 foldrT f v Empty = v
 foldrT f v (Leaf v1) = f v1 v
 foldrT f v (Node l v1 r) = f v1 flr
   where
      fll = fodlrT f v l
       flr = foldrT f fll r

 foldlT f v Empty = v
 foldlT f v (Leaf v1) = f v1 v
 foldlT f v (Node l v1 r) f flr v1
   where
      fl




