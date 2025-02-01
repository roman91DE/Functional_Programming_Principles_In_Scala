trait UINT {
    def ifZeroElse(t: => UINT, f: => UINT): UINT
    def increment(): UINT = SUCC(this)
    def +(other: UINT): UINT = ifZeroElse(other, n + other.increment())
    def -(other: UINT): UINT = ???

    override def toString(): String
}

object ZERO extends UINT {
    def ifZeroElse(t: => UINT, f: => UINT): UINT = t

    override def toString(): String = "0"
}

case class SUCC(n: UINT) extends UINT {
    def ifZeroElse(t: => UINT, f: => UINT): UINT = f

    override def toString(): String = (1 + n.toString.toInt).toString
}


val n = ZERO
n


val one = SUCC(ZERO)

val two = one.increment()

val three = one + two





