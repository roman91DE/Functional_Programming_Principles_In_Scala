package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)

  /**
   * This test is currently disabled (by using .ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */

    test("singleton set one contains one") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets:
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("intersect contains only elements in both sets") {
    new TestSets:
      val s12 = union(s1, s2)
      val s23 = union(s2, s3)
      val i = intersect(s12, s23)
      assert(contains(i, 2), "Intersect 2")
      assert(!contains(i, 1), "Intersect 1")
      assert(!contains(i, 3), "Intersect 3")
  }

  test("diff contains elements in first set but not in second") {
    new TestSets:
      val s123 = union(union(s1, s2), s3)
      val s23 = union(s2, s3)
      val d = diff(s123, s23)
      assert(contains(d, 1), "Diff 1")
      assert(!contains(d, 2), "Diff 2")
      assert(!contains(d, 3), "Diff 3")
  }

  test("filter returns subset of elements satisfying predicate") {
    new TestSets:
      val s1234 = union(union(union(s1, s2), s3), s4)
      val evenSet = filter(s1234, x => x % 2 == 0)
      assert(contains(evenSet, 2), "Filter 2")
      assert(contains(evenSet, 4), "Filter 4")
      assert(!contains(evenSet, 1), "Filter 1")
      assert(!contains(evenSet, 3), "Filter 3")
  }

  test("forall checks if all elements satisfy predicate") {
    new TestSets:
      val s1234 = union(union(union(s1, s2), s3), s4)
      assert(forall(s1234, x => x > 0), "Forall positive")
      assert(!forall(s1234, x => x % 2 == 0), "Forall even")
  }

  test("exists checks if any element satisfies predicate") {
    new TestSets:
      val s1234 = union(union(union(s1, s2), s3), s4)
      assert(exists(s1234, x => x % 2 == 0), "Exists even")
      assert(!exists(s1234, x => x < 0), "Exists negative")
  }

  test("map transforms elements using given function") {
    new TestSets:
      val s1234 = union(union(union(s1, s2), s3), s4)
      val doubled = map(s1234, x => x * 2)
      assert(contains(doubled, 2), "Map 2")
      assert(contains(doubled, 4), "Map 4")
      assert(contains(doubled, 6), "Map 6")
      assert(contains(doubled, 8), "Map 8")
      assert(!contains(doubled, 1), "Map 1")
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
