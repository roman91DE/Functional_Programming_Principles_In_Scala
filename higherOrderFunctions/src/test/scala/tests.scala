package excercises

class testSuite extends munit.FunSuite:
  import excercises.*

  test("product of range") {
    assertEquals(productF(3, 4), 12)
  }

  test("factorialF of range (1, 3)") {
    assertEquals(factorialF(1, 3), 12) // 1! * 2! * 3! = 1 * 2 * 6 = 12
  }

  test("factorialF of single number (4, 4)") {
    assertEquals(factorialF(4, 4), 24) // 4! = 24
  }

  test("factorialF with invalid interval (3, 2)") {
    assertEquals(factorialF(3, 2), 1) // Should return base case
  }

  test("factorialF of range (2, 5)") {
    assertEquals(
      factorialF(2, 5),
      34560
    ) // 2! * 3! * 4! * 5! = 2 * 6 * 24 * 120 = 34560
  }

  test("factorialF including 1 (1, 4)") {
    assertEquals(
      factorialF(1, 4),
      288
    ) // 1! * 2! * 3! * 4! = 1 * 2 * 6 * 24 = 288
  }

  test("factorialF of larger range (1, 6)") {
    assertEquals(
      factorialF(1, 6),
      24883200
    ) // 1! * 2! * 3! * 4! * 5! * 6! = 1 * 2 * 6 * 24 * 120 * 720 = 24883200
  }
