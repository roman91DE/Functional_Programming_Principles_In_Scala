package example

/**
 * This class implements a munit test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class ListsSuite extends munit.FunSuite:

  
  import Lists.*

// test sum function

  test("sum of a few numbers (10pts)") {
    assert(sum(List(1,2,0)) == 3)
  }

  test("sum of an empty list") {
    assert(sum(List()) == 0)
  }

  test("sum of a single number") {
    assert(sum(List(1)) == 1)
  }

  test("sum of a negative number") {
    assert(sum(List(-1, -2, -3)) == -6)
  }

  test("sum of mixed numbers") {
    assert(sum(List(1, -2, 3, -4, 5)) == 3)
  }




  test("max of a few numbers (10pts)") {
    assert(max(List(3, 7, 2)) == 7)
  }

  test("max of a single number") {
    assert(max(List(1)) == 1)
  }

  test("max of a negative number") {
    assert(max(List(-1, -2, -3)) == -1)
  }

  test("max of mixed numbers") {
    assert(max(List(1, -2, 3, -4, 5)) == 5)
  }

  test("max of an empty list") {
    try {
      max(List())
      assert(false)
    } catch {
      case e: java.util.NoSuchElementException => assert(true)
      case _ => assert(false)
    }
  }

  

  import scala.concurrent.duration.*
  override val munitTimeout = 1.seconds
