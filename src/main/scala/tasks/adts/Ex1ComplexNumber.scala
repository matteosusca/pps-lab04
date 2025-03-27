package tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    // Change assignment below: should probably define a case class and use it?
    type Complex = (Double, Double)
    def complex(re: Double, im: Double): Complex = (re, im)
    extension (complex: Complex)
      def re(): Double = complex match
        case (re, _) => re
      def im(): Double = complex match
        case (_, im) => im
      def sum(other: Complex): Complex = (complex, other) match
        case (Complex(re1, im1), Complex(re2, im2)) => (re1 + re2, im1 + im2)
      def subtract(other: Complex): Complex = (complex, other) match
        case (Complex(re1, im1), Complex(re2, im2)) => (re1 - re2, im1 - im2)
      def asString(): String = complex match
        case Complex(re, im) => im match
          case 0 => re match
            case 0 => "0.0"
            case _ => re + ""
          case _ => re match
            case 0 => im + "i"
            case _ => re + (if im > 0 then " + " else " - ") + math.abs(im) + "i"