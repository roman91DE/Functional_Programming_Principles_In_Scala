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




























