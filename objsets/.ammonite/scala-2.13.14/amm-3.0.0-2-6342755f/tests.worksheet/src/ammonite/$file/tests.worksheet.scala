
package ammonite
package $file
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit,
  scalaVersion
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.compiler.CompilerExtensions.{
  CompilerInterpAPIExtensions,
  CompilerReplAPIExtensions
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.compiler.tools.{
  desugar,
  source
}
import _root_.mainargs.{
  arg,
  main
}
import _root_.ammonite.repl.tools.Util.{
  PathRead
}
import _root_.ammonite.repl.ReplBridge.value.{
  codeColorsImplicit
}


object `tests.worksheet`{
/*<script>*/abstract class BST:
    def incl(n: Int): BST
    def print(): Unit

object Empty extends BST:
    def incl(n: Int): BST = Node(n, Empty, Empty)
    def print(): Unit = {}

case class Node(v: Int, left: BST, right: BST ) extends BST:
    def incl(n: Int): BST = {
        if n <= v then left.incl(n) else right.incl(n)
    }

    def print(): Unit = {
        left.print()
        println(v)
        right.print()
    }


val s = Empty

val s1 = s.incl(2)

val s2 = s1.incl(4)

val s3 = s2.incl(1)


/*<amm>*/val res_7 = /*</amm>*/s3.print()/*</script>*/ /*<generated>*/
def $main() = { _root_.scala.Iterator[String]() }
  override def toString = "tests$u002Eworksheet"
  /*</generated>*/
}
