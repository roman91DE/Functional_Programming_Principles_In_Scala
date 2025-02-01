package funsets.worksheets


final class Rational$u002Eworksheet$_ {
def args = Rational$u002Eworksheet_sc.args$
def scriptPath = """funsets/worksheets/Rational.worksheet.sc"""
/*<script>*/
class Rational(n: Int, d: Int):

    require(d > 0, "Denominator must be non-zero")
    private val g = gcd(n, d)
    val numerator = n.abs / g
    val denominator = d / g

    override def toString = s"$numerator/$denominator"

    def add(that: Rational): Rational =
        Rational(
            this.numerator * that.denominator + that.numerator * this.denominator,
            this.denominator * that.denominator
        )

    def neg: Rational = Rational(-this.numerator, this.denominator)

    def sub(that: Rational): Rational = this.add(that.neg)

    def mul(that: Rational): Rational =
        Rational(this.numerator * that.numerator, this.denominator * that.denominator)

    def div(that: Rational): Rational =
        Rational(this.numerator * that.denominator, this.denominator * that.numerator)
    
    @annotation.tailrec
    private def gcd(a: Int, b: Int): Int =
        if a == 0 then b
        else if b == 0 then a
        else gcd(b, a % b)

// Usage remains the same
val x = Rational(1, 2)
val y = Rational(6, 10)

x.mul(y).sub(Rational(10,3))





























/*</script>*/ /*<generated>*//*</generated>*/
}

object Rational$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new Rational$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export Rational$u002Eworksheet_sc.script as `Rational.worksheet`

