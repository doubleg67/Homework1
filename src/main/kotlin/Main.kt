import kotlin.math.pow
import kotlin.math.sqrt

fun main() {

    val fra = Fraction(3, 9)
    val fra2 = Fraction(2, 8)
    val coords = Point(2.0, 3.0)

    print("წილადების ჯამი: ")
    println(fra.damateba(fra2))
    print("წილადების ნამრავლი: ")
    println(fra.gamravleba(fra2))
    print("სათავის მიმართ იქსისა და იგრეკის სიმეტრიული წერტილებია: ")
    println(coords.simetria())
    print("პირველი წილადის შეკვეცილი ვარიანტი: ")
    println(fra.shekveca())
    print("მეორე წილადის შეკვეცილი ვარიანტი: ")
    println(fra2.shekveca())

}

class Point( val x: Double, val y:Double) {

    override fun toString(): String {
        return "x=$x, y=$y"
    }

    private val negativeX = -x
    private val negativeY = -y

    fun simetria(): String {
        return "x=$negativeX, y=$negativeY"
    }

    override fun equals(second: Any?): Boolean {
        return this.toString() == second.toString()
    }

}
class Fraction(private var numerator: Int, private var denominator: Int){
    fun shekveca():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num = num / i
                den = den / i
            }
        }
        return "$num / $den"
    }

    fun gamravleba(frc:Fraction):String{
        val a : Int = numerator*frc.numerator
        val b : Int = denominator*frc.denominator
        val saboloo1 = Fraction(a, b)
        return saboloo1.shekveca()
    //return  "$a / $b"
    }

    fun damateba(frc:Fraction):String{
        var a1:Int = numerator
        var b1:Int = denominator
        var a2:Int = frc.numerator
        var b2:Int = frc.denominator
        val tmp:Int = denominator

        if (denominator!=frc.denominator){
            a1*=b2
            b1*=b2
            a2*=tmp
            b2*=tmp
        }

        val shekreba :Int = a1+a2
        val saboloo2 = Fraction(shekreba, b2)
        return saboloo2.shekveca()
    }
}