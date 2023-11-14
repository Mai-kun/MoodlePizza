class PizzaPeter(
    neapolitanPizzaPrice : Double,
    romanPizzaPrice : Double,
    sicilianPizzaPrice : Double,
    tyroleanPizzaPrice : Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink
{
    override var pizzaCoffee = mutableMapOf<String, Int>(
        "neapolitanPizza" to 0,
        "romanPizza" to 0,
        "sicilianPizza" to 0,
        "tyroleanPizza" to 0
    )

    override fun showStatisticCoffee() {
        val countCustomers = sicilianPizzaCount + neapolitanPizzaCount +
                romanPizzaCount + tyroleanPizzaCount
        println("Количество проданных кофе: $countCoffee")
        println("Общая сумма выручки за кофе: $revenueCoffee")
        println("Люди купившие кофе в процентах: ${((countCoffee.toDouble() / countCustomers.toDouble()) * 100)}%")

        when(pizzaCoffee.maxBy { it.value }.key){
            "neapolitanPizza" -> println("Кофе чаще покупают к неапольтанской пицце ${pizzaCoffee["neapolitanPizza"]} из $neapolitanPizzaCount" +
                    " (${pizzaCoffee["neapolitanPizza"]!!.toDouble() / neapolitanPizzaCount.toDouble() * 100}%)")

            "romanPizza" -> println("Кофе чаще покупают к римской пицце (${pizzaCoffee["romanPizza"]} из $romanPizzaCount)" +
                    " (${pizzaCoffee["romanPizza"]!!.toDouble() / romanPizzaCount.toDouble() * 100}%)")

            "sicilianPizza" -> println("Кофе чаще покупают к сицилийской пицце (${pizzaCoffee["sicilianPizza"]} из $sicilianPizzaCount)" +
                    " (${pizzaCoffee["sicilianPizza"]!!.toDouble() / sicilianPizzaCount.toDouble() * 100}%)")

            "tyroleanPizza" -> println("Кофе чаще покупают к тирольской пицце (${pizzaCoffee["tyroleanPizza"]} из $tyroleanPizzaCount)" +
                    " (${pizzaCoffee["tyroleanPizza"]!!.toDouble() / tyroleanPizzaCount.toDouble() * 100}%)")
        }
    }

    override var countCoffee = 0
    override fun drinkSale(currentPizza : String) {
        println("Вы будете кофе?")
        println("1. Да\n" +
                "2. Нет")
        if (readln() == "1") {
            pizzaCoffee[currentPizza] = pizzaCoffee[currentPizza]!! + 1
            countCoffee++
            revenueCoffee += 200
            println("С вас 200 рублей")
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