interface Drink {
    fun showStatisticCoffee()
    fun drinkSale(currentPizza : String)

    var countCoffee : Int

    var pizzaCoffee : MutableMap<String, Int>
}

interface CheckPhoto{
    fun showStatisticCheque()
    fun showCheckPhoto(currentPizza : String)

    var countCheque : Int
}

interface Sauce {
    fun showStatisticSauce()
    fun sauceSale(currentPizza : String)

    var countSauce : Int

    var pizzaSauce : MutableMap<String, Int>
}