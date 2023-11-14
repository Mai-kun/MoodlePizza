class PizzaVolgograd (
    neapolitanPizzaPrice : Double,
    romanPizzaPrice : Double,
    sicilianPizzaPrice : Double,
    tyroleanPizzaPrice : Double,
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink, CheckPhoto, Sauce
{

    override var pizzaSauce = mutableMapOf<String, Int>(
        "Cheese" to 0,
        "Garlic" to 0,
    )

    override var pizzaCoffee = mutableMapOf<String, Int>(
        "neapolitanPizza" to 0,
        "romanPizza" to 0,
        "sicilianPizza" to 0,
        "tyroleanPizza" to 0
    )

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

    override var countSauce = 0
    override fun sauceSale(currentPizza: String) {
        println("Выберите соус к пиццe:")
        println("1. Сырный\n" +
                "2. Чесночный\n" +
                "0. Отказаться")
        when (readln()){
             "1" -> {
                pizzaSauce["Cheese"] = pizzaSauce["Cheese"]!! + 25
                countSauce++
                revenueSause += 25
                println("С вас 25 рублей")

             }
             "2" -> {
                pizzaSauce["Garlic"] = pizzaSauce["Garlic"]!! + 35
                countSauce++
                revenueSause += 35
                println("С вас 35 рублей")
             }
        }
    }

    override fun showStatisticSauce() {
        println("Количество проданных соусов: $countSauce")
        println("Общая сумма выручки за соусы: $revenueSause")
        println("Выручка за каждый из соусов:\n" +
                "\tСырный - ${pizzaSauce["Cheese"]}\n" +
                "\tЧесночный - ${pizzaSauce["Garlic"]}")
    }

    override fun showStatisticCheque(){
        val countCustomers = sicilianPizzaCount + neapolitanPizzaCount +
                romanPizzaCount + tyroleanPizzaCount
        println("Количество показанных чеков: $countCheque")
        println("Общая сумма скидок: $sumSale")
        println("Люди показывающие чек в процентах: ${((countCheque.toDouble() / countCustomers.toDouble()) * 100)}%")
    }

    override fun showStatisticCoffee() {
        val countCustomers = sicilianPizzaCount + neapolitanPizzaCount +
                romanPizzaCount + tyroleanPizzaCount
        println("Количество проданных кофе: $countCoffee")
        println("Общая сумма выручки за кофе: $revenueCoffee")
        println("Люди купившие кофе в процентах: ${((countCoffee.toDouble() / countCustomers.toDouble()) * 100)}%")

        when(pizzaCoffee.maxBy { it.value }.key){
            "neapolitanPizza" -> println("Кофе чаще покупают к неапольтанской пицце (${pizzaCoffee["neapolitanPizza"]} из $neapolitanPizzaCount)" +
                    " (${pizzaCoffee["neapolitanPizza"]!!.toDouble() / neapolitanPizzaCount.toDouble() * 100}%)")

            "romanPizza" -> println("Кофе чаще покупают к римской пицце (${pizzaCoffee["romanPizza"]} из $romanPizzaCount)" +
                    " (${pizzaCoffee["romanPizza"]!!.toDouble() / romanPizzaCount.toDouble() * 100}%)")

            "sicilianPizza" -> println("Кофе чаще покупают к сицилийской пицце (${pizzaCoffee["sicilianPizza"]} из $sicilianPizzaCount)" +
                    " (${pizzaCoffee["sicilianPizza"]!!.toDouble() / sicilianPizzaCount.toDouble() * 100}%)")

            "tyroleanPizza" -> println("Кофе чаще покупают к тирольской пицце (${pizzaCoffee["tyroleanPizza"]} из $tyroleanPizzaCount)" +
                    " (${pizzaCoffee["tyroleanPizza"]!!.toDouble() / tyroleanPizzaCount.toDouble() * 100}%)")
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