import scala.annotation

def fact(x: Int): Option[Int] = {
  if x < 0 then return None
  @annotation.tailrec
  def loop(n: Int, acc: Int): Option[Int] = {
    if n < 2 then Some(acc) else loop(n-1, n*acc)
  }
  loop(x, 1)
}
