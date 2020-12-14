package machine


class CoffeeMachine {

    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var disposableCups = 9
    private var money = 550

    fun mainMenu(input: String = "") {

        when (input) {

            "buy" -> buyMenu()
            "fill" -> fillMenu()
            "take" -> takeMenu()
            "remaining" -> printStatus()
            "exit" -> return
        }
    }


    private fun buyMenu() {

        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")

        when (readLine()!!) {

            "1" -> {
                if (water >= 250 && coffeeBeans >= 16 && disposableCups > 0) {

                    water -= 250
                    coffeeBeans -= 16
                    disposableCups -= 1
                    money += 4
                    printCoffeeMaking()

                } else {

                    print("Sorry, not enough ")
                    when {

                        water < 250 -> print("water\n")
                        coffeeBeans < 16 -> print("coffee beans\n")
                        disposableCups <= 0 -> print("disposable cups\n")
                    }
                }

            }

            "2" -> {

                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups > 0) {

                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    disposableCups -= 1
                    money += 7
                    printCoffeeMaking()

                } else {

                    print("Sorry, not enough ")
                    when {

                        water < 350 -> print("water\n")
                        milk < 75 -> print("milk\n")
                        coffeeBeans < 20 -> print("coffee beans\n")
                        disposableCups <= 0 -> print("disposable cups\n")
                    }
                }

            }

            "3" -> {
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups > 0) {

                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    disposableCups -= 1
                    money += 6
                    printCoffeeMaking()

                } else {

                    print("Sorry, not enough ")
                    when {

                        water < 200 -> print("water\n")
                        milk < 100 -> print("milk\n")
                        coffeeBeans < 12 -> print("coffee beans\n")
                        disposableCups <= 0 -> print("disposable cups\n")
                    }
                }

            }
        }

        mainMenu()
    }

    private fun fillMenu() {

        print("Write how many ml of water do you want to add: ")
        water += readLine()!!.toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readLine()!!.toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        coffeeBeans += readLine()!!.toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        disposableCups += readLine()!!.toInt()
        println()
        mainMenu()
    }

    private fun takeMenu() {

        println("I gave you \$$money")
        println()
        money = 0
        mainMenu()
    }

    private fun printStatus() {

        println()
        println("The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$coffeeBeans of coffee beans\n" +
                "$disposableCups of disposable cups\n" +
                "\$$money of money\n")

        mainMenu()
    }

    private fun printCoffeeMaking() {

        println("I have enough resources, making you a coffee!\n")
    }


}

fun main() {

    val coffeeMachine = CoffeeMachine()
    while (true) {

        print("Write action (buy, fill, take, remaining, exit): ")
        val op = readLine()!!.toString()
        if (op == "exit") break
        coffeeMachine.mainMenu(op)
    }

}

