type FunSet = Int => Boolean

def singletonSet(elem: Int): FunSet = {
    (x: Int) => if x == elem then true else false
}

def inTwoSet = singletonSet(2)

inTwoSet(2)

inTwoSet(-2)


