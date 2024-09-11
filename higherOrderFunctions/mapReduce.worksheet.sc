def mapReduceList[A](mapF: (List[A] => List[A]))(reduceF: (List[A] => A))(list: List[A]): A = {
    reduceF(mapF(list))
}

// generic/numeric map functions
def square[A: Numeric](list: List[A]): List[A] = {
  list.map(x => implicitly[Numeric[A]].times(x, x))
}

// generic/numeric sumValues function
def sumValues[A: Numeric](list: List[A]): A = {
    def loop(list: List[A], acc: A): A = {
        if (list.isEmpty) acc
        else {
            val num = implicitly[Numeric[A]]
            loop(list.tail, num.plus(acc, list.head))
        }
    }
    loop(list, implicitly[Numeric[A]].zero)
}
// create a map reduce function from the map and reduce components 
def sumSquares[A: Numeric](list: List[A]): A = mapReduceList(square[A])(sumValues[A])(list)

// Example with ints
val intList = (1 to 5).toList
sumSquares(intList)

// Example with doubles
val doubleList = List(1.5, 2.7, 3.2, 4.8, 5.1)
sumSquares(doubleList)

