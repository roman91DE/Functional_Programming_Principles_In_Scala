package recfun

class RecFunSuite extends munit.FunSuite:
  import RecFun.*

  // ------ balance tests -----------------------------------------------------

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(
      balance(
        "I told him (that it's not (yet) done).\n(But he wasn't listening)".toList
      )
    )
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  // Additional balance tests
  test("balance: empty string is balanced") {
    assert(balance("".toList))
  }

  test("balance: single opening parenthesis is unbalanced") {
    assert(!balance("(".toList))
  }

  test("balance: single closing parenthesis is unbalanced") {
    assert(!balance(")".toList))
  }

  test("balance: nested parentheses are balanced") {
    assert(balance("((()))".toList))
  }

  test("balance: mismatched nested parentheses are unbalanced") {
    assert(!balance("((())".toList))
  }

  test("balance: balanced parentheses with other characters") {
    assert(balance("(hello (world))".toList))
  }

  test("balance: unbalanced parentheses with other characters") {
    assert(!balance("(hello (world)".toList))
  }

  test("balance: alternating parentheses are unbalanced") {
    assert(!balance("()()())()".toList))
  }

  test("balance: complex balanced expression") {
    assert(balance("((()())())((()))".toList))
  }

  test("balance: complex unbalanced expression") {
    assert(!balance("((()())())((())))".toList))
  }

//   // ------ countChange tests -------------------------------------------------

  test("countChange: example given in instructions") {
    assertEquals(countChange(4, List(1, 2)), 3)
  }

  test("countChange: sorted CHF") {
    assertEquals(countChange(300, List(5, 10, 20, 50, 100, 200, 500)), 1022)
  }

  test("countChange: no pennies") {
    assertEquals(countChange(301, List(5, 10, 20, 50, 100, 200, 500)), 0)
  }

  test("countChange: unsorted CHF") {
    assertEquals(countChange(300, List(500, 5, 50, 100, 20, 200, 10)), 1022)
  }

  test("countChange: empty coin list") {
    assertEquals(countChange(100, List()), 0)
  }

  test("countChange: amount is 0") {
    assertEquals(countChange(0, List(1, 2, 5)), 1)
  }

  test("countChange: single coin") {
    assertEquals(countChange(5, List(5)), 1)
  }

  test("countChange: no solution possible") {
    assertEquals(countChange(3, List(2, 4)), 0)
  }

  test("countChange: large amount with small coins") {
    assertEquals(countChange(1000, List(1, 2)), 501)
  }

  test("countChange: amount smaller than smallest coin") {
    assertEquals(countChange(2, List(5, 10, 20)), 0)
  }

  test("countChange: large number of coins") {
    assertEquals(countChange(100, (1 to 100).toList), 190569292)
  }

  test("countChange: repeated coins") {
    assertEquals(countChange(4, List(1, 1, 2, 2)), 3)
  }

  test("countChange: negative amount") {
    assertEquals(countChange(-5, List(1, 2, 5)), 0)
  }

  test("countChange: negative coins") {
    assertEquals(
      countChange(5, List(-1, 2, 3)),
      1
    ) // Should ignore negative coins
  }

  // ------ pascal tests ------------------------------------------------------

  test("pascal: col=0,row=0") {
    assertEquals(pascal_naive(0, 0), 1)
  }

  test("pascal: col=1,row=2") {
    assertEquals(pascal_naive(1, 2), 2)
  }

  test("pascal: col=1,row=3") {
    assertEquals(pascal_naive(1, 3), 3)
  }

  test("pascal: col=0,row=2") {
    assertEquals(pascal(0, 2), 1)
  }

  test("pascal: col=1,row=2") {
    assertEquals(pascal(1, 2), 2)
  }

  test("pascal: col=1,row=3") {
    assertEquals(pascal(1, 3), 3)
  }

  // Additional pascal tests
  test("pascal: col=2,row=4") {
    assertEquals(pascal(2, 4), 6)
  }

  test("pascal: col=1,row=4") {
    assertEquals(pascal(1, 4), 4)
  }

  test("pascal: col=2,row=5") {
    assertEquals(pascal(2, 5), 10)
  }

  test("pascal: col=4,row=8") {
    assertEquals(pascal(4, 8), 70)
  }

  test("pascal: col=0,row=10") {
    assertEquals(pascal(0, 10), 1)
  }

  test("pascal: col=10,row=10") {
    assertEquals(pascal(10, 10), 1)
  }

  test("pascal: col=5,row=10") {
    assertEquals(pascal(5, 10), 252)
  }

  // write a test case for this function: def sum(f: Int => Int, a: Int, b: Int): Int = {
  //     if a > b then 0 else f(a) + sum(f, a-1, b)
  // }
  test("sum: sum of integers from 1 to 5") {
    assertEquals(sum(x => x, 1, 5), 15)
  }

  test("sum: sum of integers from 1 to 5") {
    assertEquals(sum(x => x * x, 1, 5), 55)
  }

  test("sum: sum of integers from 1 to 5") {
    assertEquals(sum(x => x * x * x, 1, 5), 225)
  }

  test("invalid range") {
    assertEquals(sum(x => x, 5, 1), 0)
  }

  // Additional test cases for sum_tail
  test("sum_tail: sum of integers from 1 to 5") {
    assertEquals(sum_tail(x => x, 1, 5), 15)
  }

  test("sum_tail: sum of squares from 1 to 5") {
    assertEquals(sum_tail(x => x * x, 1, 5), 55)
  }

  test("sum_tail: sum of cubes from 1 to 5") {
    assertEquals(sum_tail(x => x * x * x, 1, 5), 225)
  }

  test("sum_tail: invalid range") {
    assertEquals(sum_tail(x => x, 5, 1), 0)
  }

  test("sum_tail: empty range") {
    assertEquals(sum_tail(x => x, 1, 0), 0)
  }

  test("sum_tail: single element range") {
    assertEquals(sum_tail(x => x * 2, 3, 3), 6)
  }

  test("sum_tail: large range") {
    assertEquals(sum_tail(x => 1, 1, 1000000), 1000000)
  }
  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
