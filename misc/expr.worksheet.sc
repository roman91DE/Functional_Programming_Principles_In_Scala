trait Expr:
    def eval(): Expr

case class Number(n: Int) extends  Expr:
    def eval(): Expr = this
    override def toString(): String = n.toString()    

case class Variable(name: String) extends Expr:
    def eval(): Expr = this
    override def toString(): String = name

trait Operator extends Expr

abstract class BinaryOperator(left: Expr, right: Expr) extends Operator

case class Addition(left: Expr, right: Expr) extends BinaryOperator(left: Expr, right: Expr):
    def eval(): Expr = (left, right) match {
        case (Number(l), Number(r)) => Number(l + r)
        case _ => Addition(left.eval(), right.eval())
    }
    override def toString(): String = s"(${left.eval()} + ${right.eval()}}"





val one = Number(1)

val two = Number(2)

val oneAddTwo = Addition(one, two)

val three = Addition(one, two).eval()

val x = Variable("x")

val xAddThree = Addition(x, three)


Addition(
    Addition(one, two),
    xAddThree
)

xAddThree.isInstanceOf[Expr]
xAddThree.isInstanceOf[Addition]
xAddThree.isInstanceOf[Variable]




