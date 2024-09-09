package recfun

import scala.compiletime.ops.boolean

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do print(s"${pascal(col, row)} ")
      println()

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if a > b then 0 else f(a) + sum(f, a + 1, b)

  def sum_tail(f: Int => Int, a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int = {
      if a > b then acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  def pascal_naive(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal_naive(c - 1, r - 1) + pascal_naive(c, r - 1)
  }

  def pascal(c: Int, r: Int): Int = {
    def recfunc(c: Int, r: Int, acc: Map[(Int, Int), Int]): Int = {
      if (c == 0 || c == r) 1
      else
        acc.getOrElse(
          (c, r), {
            recfunc(c - 1, r - 1, acc) + recfunc(c, r - 1, acc)
          }
        )
    }
    recfunc(c, r, Map.empty)
  }

  def balance(chars: List[Char]): Boolean = {
    def recurseString(chars: List[Char], count: Int): Boolean = {
      if chars.isEmpty then count == 0
      else if count < 0 then false
      else if chars.head == '(' then recurseString(chars.tail, count + 1)
      else if chars.head == ')' then recurseString(chars.tail, count - 1)
      else recurseString(chars.tail, count)
    }
    recurseString(chars, 0)
  }

  /** Exercise 3
    */
  def countChangeSlow(money: Int, coins: List[Int]): Int = {

    def isPossible(money: Int, coins: List[Int], newCoin: Int): Boolean = {
      (coins.sum + newCoin) <= money
    }

    var foundSolutions: List[List[Int]] = Nil

    def loop(money: Int, usedCoins: List[Int]): Unit = {
      if usedCoins.sum == money then {
        foundSolutions = foundSolutions.appendedAll(List(usedCoins))
        return ()
      } else if usedCoins.sum > money then {
        return ()
      } else {
        for (coin <- coins) {
          if isPossible(money, usedCoins, coin) then
            loop(money, usedCoins.appendedAll(List(coin)))
        }
      }

    }

    loop(money, Nil)
    val uniqueSolutions = foundSolutions.map(_.sorted).distinct
    uniqueSolutions.length
  }

  def countChange(money: Int, coins: List[Int]): Int = {

    // Remove duplicate coins
    if !(coins.distinct.length == coins.length) then
      return countChange(money, coins.distinct)

    // Remove negative or zero coins
    val positiveCoins = coins.filter(_ > 0)
    if !(positiveCoins.length == coins.length) then
      return countChange(money, positiveCoins)

    // Remove coins that are greater than money and sort the rest in descending order
    val sortedCoins = coins.filter(_ <= money).sorted.reverse

    // Memoization:
    val memo = collection.mutable.Map[(Int, List[Int]), Int]()

    def loop(remaining: Int, availableCoins: List[Int]): Int = {
      if (remaining == 0) return 1
      if (remaining < 0 || availableCoins.isEmpty) return 0

      memo.getOrElseUpdate(
        (remaining, availableCoins), {
          val withFirstCoin =
            loop(remaining - availableCoins.head, availableCoins)
          val withoutFirstCoin = loop(remaining, availableCoins.tail)
          withFirstCoin + withoutFirstCoin
        }
      )
    }

    loop(money, sortedCoins)
  }
