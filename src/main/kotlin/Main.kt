
fun main(){

    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        187.0, 215.0
    )

    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.0, 240.0
    )

    val pizzaVolgograd = PizzaVolgograd(
        215.0, 250.5,
        180.0, 240.0,
    )

    var currentPizzaCity : PizzaCity

    while(true) {
        println("Добрый день! Выберите город")
        println(
            "1. Москва \n" +
            "2. Санкт-Петербург\n" +
            "3. Волгоград\n" +
            "0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaVolgograd
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println()
        println("Выберите пиццу:")
        println(
            "1. Неаполитанская пицца\n" +
            "2. Римская пицца\n" +
            "3. Сицилийская пицца\n" +
            "4. Тирольская пицца\n" +
            "0. Показать статистику")

        selectPizza(currentPizzaCity)
        println()
    }
}


private fun selectPizza(currentPizzaCity: PizzaCity) {
    val currentPizza : String
    when (readln()) {
        "1" -> {
            currentPizza = "neapolitanPizza"
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity, currentPizza)
        }

        "2" -> {
            currentPizza = "romanPizza"
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity, currentPizza)
        }

        "3" -> {
            currentPizza = "sicilianPizza"
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity, currentPizza)
        }

        "4" -> {
            currentPizza = "tyroleanPizza"
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity, currentPizza)
        }

        "0" -> {
            currentPizzaCity.showStatistics()
            when(currentPizzaCity){
                is PizzaMoscow -> currentPizzaCity.showStatisticCheque()
                is PizzaPeter -> currentPizzaCity.showStatisticCoffee()
                is PizzaVolgograd -> {
                    currentPizzaCity.showStatisticCheque()
                    currentPizzaCity.showStatisticCoffee()
                    currentPizzaCity.showStatisticSauce()
                }
            }

        }

        else -> {
            println("ERROR")
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, currentPizza : String){
    when (currentPizzaCity){
        is PizzaMoscow -> currentPizzaCity.showCheckPhoto(currentPizza)
        is PizzaPeter -> currentPizzaCity.drinkSale(currentPizza)
        is PizzaVolgograd -> {
            currentPizzaCity.drinkSale(currentPizza)
            currentPizzaCity.showCheckPhoto(currentPizza)
            currentPizzaCity.sauceSale(currentPizza)
        }
    }
}