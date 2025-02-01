package funsets.worksheets


final class fsets$u002Eworksheet$_ {
def args = fsets$u002Eworksheet_sc.args$
def scriptPath = """funsets/worksheets/fsets.worksheet.sc"""
/*<script>*/
type FunSet = Int => Boolean

def singletonSet(elem: Int): FunSet = {
    (x: Int) => if x == elem then true else false
}

def inTwoSet = singletonSet(2)

inTwoSet(2)

inTwoSet(-2)



/*</script>*/ /*<generated>*//*</generated>*/
}

object fsets$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new fsets$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export fsets$u002Eworksheet_sc.script as `fsets.worksheet`

