import patmat.*

def string2Chars(str: String): List[Char] = str.toList



def times(chars: List[Char]): List[(Char, Int)] = chars.map((c: Char) => (c, 1)).groupMapReduce(_._1)(_._2)((a, b) => a + b).toList
  


val chars = string2Chars("aaabbc")

val counts = times(chars)


  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.map((c, n) => Leaf(c, n)).sortBy(leaf => leaf.weight)
  }


  makeOrderedLeafList(counts)



val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))

val shouldBe = List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4))

val is = Huffman.combine(leaflist)