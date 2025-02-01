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