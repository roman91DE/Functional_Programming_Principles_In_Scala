package worksheets


final class sqrtIter$u002Eworksheet$_ {
def args = sqrtIter$u002Eworksheet_sc.args$
def scriptPath = """worksheets/sqrtIter.worksheet.sc"""
/*<script>*/
def isClose(x: Double, y: Double) = {
    Math.abs(y*y - x) < 0.001

}



def sqrt(x: Double) : Double = {

    def loop(x: Double, guess: Double) : Double = {

        if isClose(x, guess) then guess else {
            val m = (guess + x/guess) / 2
            loop(x, m)
        }
    }
    loop(x, 2)
}



sqrt(2.0)
sqrt(439)

val b = sqrt(439)

b*b
/*</script>*/ /*<generated>*//*</generated>*/
}

object sqrtIter$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new sqrtIter$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export sqrtIter$u002Eworksheet_sc.script as `sqrtIter.worksheet`

