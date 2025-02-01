trait BOOL {
    def ifThenElse[T](t: => T, f: => T): T;

    def &&(other: BOOL): BOOL = ifThenElse(other, FALSE)
    def ||(other: BOOL): BOOL = ifThenElse(TRUE, other)
    def not(): BOOL = ifThenElse(FALSE, TRUE)

    override def toString(): String
}

object  TRUE extends BOOL {
    def ifThenElse[T](t: => T, f: => T): T = t
    override def toString(): String = "TRUE"

}
object  FALSE extends BOOL {
    def ifThenElse[T](t: => T, f: => T): T = f
    override def toString(): String = "FALSE"

}

TRUE && TRUE

TRUE && FALSE

TRUE || TRUE

TRUE || FALSE

TRUE.not()

FALSE.not()