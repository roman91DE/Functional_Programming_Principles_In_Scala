abstract class BST:
    def incl(n: Int): BST
    def print(): Unit

object Empty extends BST:
    def incl(n: Int): BST = Node(n, Empty, Empty)
    def print(): Unit = {}

case class Node(v: Int, left: BST, right: BST ) extends BST:
    def incl(n: Int): BST = {
        if n <= v then left.incl(n) else right.incl(n)
    }

    def print(): Unit = {
        left.print()
        println(v)
        right.print()
    }


val s = Empty

val s1 = s.incl(2)

val s2 = s1.incl(4)

val s3 = s2.incl(1)


s3.print()