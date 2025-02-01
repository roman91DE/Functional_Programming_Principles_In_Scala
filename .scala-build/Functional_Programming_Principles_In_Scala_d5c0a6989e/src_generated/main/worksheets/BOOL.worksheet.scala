package worksheets


final class BOOL$u002Eworksheet$_ {
def args = BOOL$u002Eworksheet_sc.args$
def scriptPath = """worksheets/BOOL.worksheet.sc"""
/*<script>*/
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
/*</script>*/ /*<generated>*//*</generated>*/
}

object BOOL$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new BOOL$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export BOOL$u002Eworksheet_sc.script as `BOOL.worksheet`

