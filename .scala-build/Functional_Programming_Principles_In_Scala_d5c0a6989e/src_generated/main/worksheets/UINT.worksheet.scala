package worksheets


final class UINT$u002Eworksheet$_ {
def args = UINT$u002Eworksheet_sc.args$
def scriptPath = """worksheets/UINT.worksheet.sc"""
/*<script>*/
trait UINT {
    def ifZeroElse[T](t: T, f: T): T
}

object ZERO extends UINT {
    def ifZeroElse[T](t: T, f: T): T = t
}
/*</script>*/ /*<generated>*//*</generated>*/
}

object UINT$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new UINT$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export UINT$u002Eworksheet_sc.script as `UINT.worksheet`

