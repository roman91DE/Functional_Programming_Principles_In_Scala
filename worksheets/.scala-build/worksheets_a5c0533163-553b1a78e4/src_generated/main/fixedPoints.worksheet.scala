

final class fixedPoints$u002Eworksheet$_ {
def args = fixedPoints$u002Eworksheet_sc.args$
def scriptPath = """fixedPoints.worksheet.sc"""
/*<script>*/
// a number x is called a fixed point of f if f(x) = x

def exp(x: Double, n: Int): Double = {
    if n == 0 then 1
    else if n < 0 then
        if x == 0 then throw new ArithmeticException("Cannot raise 0 to a negative power")
        else 1.0 / exp(x, -n)
    else x * exp(x, n - 1)
}


def polynom(x: Double): Double = {
    // Limit the input to prevent overflow
    val limitedX = Math.max(Math.min(x, 100), -100)
    2 * Math.pow(limitedX, 3) + 4 * Math.pow(limitedX, 2) - 3 * limitedX
}

def loop(x: Double, tolerance: Double = 1e-6, maxIterations: Int = 100): Double = {
    val fx = polynom(x)
    println(s"x: $x, f(x): $fx")
    if (Math.abs(fx - x) < tolerance || maxIterations <= 0 || fx.isNaN) x
    else loop(fx, tolerance, maxIterations - 1)
}

loop(0.1)


/*</script>*/ /*<generated>*//*</generated>*/
}

object fixedPoints$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new fixedPoints$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export fixedPoints$u002Eworksheet_sc.script as `fixedPoints.worksheet`

