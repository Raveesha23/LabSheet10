class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")

  private val gcd = greatestCommonDivisor(n.abs, d.abs)
  val numerator: Int = n / gcd
  val denominator: Int = d / gcd

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String = s"$numerator/$denominator"

  private def greatestCommonDivisor(a: Int, b: Int): Int = {
    if (b == 0) a else greatestCommonDivisor(b, a % b)
  }
}

object TestRational extends App{
    val x = new Rational(3, 4)
    println(x)
    println(x.neg) 
}

