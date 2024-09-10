package excercises

object HelloFP extends App {
  println("Hello, Functional Programming!")
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
}

def productF = product(x => x)

def factorial(n: Int): Int = {
  def loop(acc: Int, n: Int): Int = {
    if (n == 0) acc
    else loop(acc * n, n - 1)
  }
  loop(1, n)
}

def factorialF = product(factorial)


def apply2Interval(f: Int => Int)(g: Int => Int)(a: Int, b: Int): Int = {
    f(g(a,b))
}

