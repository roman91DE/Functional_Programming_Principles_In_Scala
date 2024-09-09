package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   *  Pascal's Triangle
   * 1
   * 1 1
   * 1 2 1
   * 1 3 3 1
   * 1 4 6 4 1
   * 1 5 10 10 5 1
   * 1 6 15 20 15 6 1
   * 1 7 21 35 35 21 7 1
   * 1 8 28 56 70 56 28 8 1
   * 1 9 36 84 126 126 84 36 9 1
   **/


  def pascal_naive(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal_naive(c - 1, r - 1) + pascal_naive(c, r - 1)
  }

  def pascal(c: Int, r: Int): Int = {
    def recfunc(c: Int, r: Int, acc: Map[(Int, Int), Int]): Int = {
      if (c == 0 || c == r) 1
      else acc.getOrElse((c, r), {
        recfunc(c - 1, r - 1, acc) + recfunc(c, r - 1, acc)
      })
    }
    recfunc(c, r, Map.empty)
  }



  /**
   * Exercise 2
   * Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:

    (if (zero? x) max (/ 1 x))

    I told him (that it's not (yet) done). (But he wasn't listening)

    The function should return false for the following strings:

    :-)

    ())(

    The last example shows that it's not enough to verify that a string contains the same number of opening and closing parentheses.

    Do this exercise by implementing the balance function in RecFun.scala. Its signature is as follows:

    def balance(chars: List[Char]): Boolean

    There are three methods on List[Char] that are useful for this exercise:

    chars.isEmpty: Boolean returns whether a list is empty

    chars.head: Char returns the first element of the list

    chars.tail: List[Char] returns the list without the first element

    Hint: you can define an inner function if you need to pass extra parameters to your function.

    Testing: You can use the toList method to convert from a String to a List[Char]: e.g. "(just an) example".toList.
   */


//   def balance(chars: List[Char]): Boolean = {

//     def recurseString(chars: List[Char], openCount: Int, closeCount: Int): Boolean = {
//         if chars.isEmpty then {openCount == closeCount} else {
//             if chars.head.equals('(') then recurseString(chars.tail, openCount+1, closeCount) 
//             else if chars.head.equals(')') then recurseString(chars.tail, openCount, closeCount+1)
//             else recurseString(chars.tail, openCount, closeCount)
//         }
//     }
//     recurseString(chars, 0, 0)
//   }

  def balance(chars: List[Char]): Boolean = {
    def recurseString(chars: List[Char], count: Int): Boolean = {
      if chars.isEmpty then 
        count == 0
      else if count < 0 then 
        false
      else if chars.head == '(' then 
        recurseString(chars.tail, count + 1)
      else if chars.head == ')' then 
        recurseString(chars.tail, count - 1)
      else 
        recurseString(chars.tail, count)
    }
    recurseString(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def recurseCountChange(money: Int, coins: List[Int]): Int = {

        if money == 0 then 0
        else {
            if coins.isEmpty && money > 0 then 0 else {
                if coins.head > money then countChange(money, coins.tail)
                else countChange(money - coins.head, coins) + countChange(money, coins.tail)
        }
    }
  }

    recurseCountChange(money, coins.sorted)
  }

