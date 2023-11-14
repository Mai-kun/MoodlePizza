abstract class PizzaCity(
    private val neapolitanPizzaPrice : Double,
    private val romanPizzaPrice : Double,
    private val sicilianPizzaPrice : Double,
    private val tyroleanPizzaPrice : Double,
)
{
    protected var neapolitanPizzaCount = 0
    protected var romanPizzaCount = 0
    protected var sicilianPizzaCount = 0
    protected var tyroleanPizzaCount = 0
    protected var sumSale = 0
    protected var revenueCoffee = 0
    protected var revenueSause = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showStatistics(){
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val money = (neapolitanPizzaCount * neapolitanPizzaPrice) +
                (sicilianPizzaCount * sicilianPizzaPrice) +
                (romanPizzaCount * romanPizzaPrice) +
                (tyroleanPizzaCount * tyroleanPizzaPrice) +
                revenueCoffee + revenueSause - sumSale

        println("Всего заработано денег: $money")
    }
}