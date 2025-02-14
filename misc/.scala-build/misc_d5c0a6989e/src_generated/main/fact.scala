

final class fact$_ {
def args = fact_sc.args$
def scriptPath = """fact.sc"""
/*<script>*/
import scala.annotation

def fact(x: Int): Option[Int] = {
  if x < 0 then return None
  @annotation.tailrec
  def loop(n: Int, acc: Int): Option[Int] = {
    if n < 2 then Some(acc) else loop(n-1, n*acc)
  }
  loop(x, 1)
}

/*</script>*/ /*<generated>*//*</generated>*/
}

object fact_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new fact$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export fact_sc.script as `fact`

