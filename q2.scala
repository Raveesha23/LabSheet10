class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")

  private val gcd = greatestCommonDivisor(n.abs, d.abs)
  val numerator: Int = n / gcd
  val denominator: Int = d / gcd

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numerator, denominator)

  def sub(that: Rational): Rational = {
    val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    new Rational(newNumerator, newDenominator)
  }

  override def toString: String = s"$numerator/$denominator"

  private def greatestCommonDivisor(a: Int, b: Int): Int = {
    if (b == 0) a else greatestCommonDivisor(b, a % b)
  }
}

object TestSubRational extends App{
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)
    println(s"$x - $y - $z = $result") 
}
