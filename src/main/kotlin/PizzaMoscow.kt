class PizzaMoscow(
    neapolitanPizzaPrice : Double,
    romanPizzaPrice : Double,
    sicilianPizzaPrice : Double,
    tyroleanPizzaPrice : Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice,
), CheckPhoto
{
    override fun showStatisticCheque(){
        val countCustomers = sicilianPizzaCount + neapolitanPizzaCount +
                romanPizzaCount + tyroleanPizzaCount
        println("Количество показанных чеков: $countCheque")
        println("Общая сумма скидок: $sumSale")
        println("Люди показывающие чек в процентах: ${((countCheque.toDouble() / countCustomers.toDouble()) * 100)}%")
    }

    override var countCheque = 0
    override fun showCheckPhoto(currentPizza : String) {
        println("У вас есть фотография чека?")
        println("1. Да\n" +
                "2. Нет")
        if (readln() == "1") {
            countCheque++
            sumSale += 50
            println("Вам будет скидка 50 рублей с покупки")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++;
        println("Спасибо за покупку неаполитанской пиццы")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++;
        println("Спасибо за покупку сицилийской пиццы")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы")
    }
}