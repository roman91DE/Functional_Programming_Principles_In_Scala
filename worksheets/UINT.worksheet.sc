trait UINT {
    def ifZeroElse[T](t: => T, f: => T): T

    def increment(): UINT = SUCC(this)
    def decrement(): UINT

    def +(other: UINT): UINT = ifZeroElse(other, decrement() + (other.increment()))
    def - (other: UINT): UINT = {
        ifZeroElse(
            ZERO,
            other.ifZeroElse(
                this,
                if this <= other then ZERO else decrement() - other.decrement()
            ))}

    def *(other: UINT): UINT = {
        ifZeroElse(
            ZERO,
            other.ifZeroElse(
                ZERO, decrement().ifZeroElse(
                    other,
                    decrement() * (other + other))))
    };

    def /(other: UINT): UINT = ???
    def %(other: UINT): UINT = ???



    def == (other: UINT): Boolean = ifZeroElse[Boolean](other.ifZeroElse[Boolean](true, false), other.decrement() == decrement())
    def < (other: UINT): Boolean = ifZeroElse[Boolean](other.ifZeroElse[Boolean](false, true), decrement() < other.decrement())
    def <= (other: UINT): Boolean = ==(other) | <(other)

    def > (other: UINT): Boolean = ! <(other)
    def >= (other: UINT): Boolean = >(other) | ==(other)


    override def toString(): String
}

object ZERO extends UINT {
    def ifZeroElse[T](t: => T, f: => T): T = t
    def decrement(): UINT = this

    override def toString(): String = "0"
}

case class SUCC(n: UINT) extends UINT {
    def ifZeroElse[T](t: => T, f: => T): T = f
    def decrement(): UINT = n

    override def toString(): String = (1 + n.toString.toInt).toString
}


val zero = ZERO
val one = SUCC(zero)
val two = one.increment()

one + two

zero + two

two + two

zero * two

one * one

one * two

two * zero

zero * two

two * two

two == one

two == two

zero == zero

zero == one


two < one

two < two

zero < zero

zero < one

zero < two

zero <= zero

zero <= two

two <= two


two > one
one > two


one - one

two - one

two - zero

zero - zero

one - two























