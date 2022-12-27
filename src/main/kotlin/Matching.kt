class Matching {
    private var status: String = ""

    fun match(playerOne: String, playerTwo: String): String {
        if (playerOne.lowercase() == playerTwo.lowercase()) {
            status = "DRAW!"
        } else if (playerOne.lowercase() == "batu") {
            return if (playerTwo.lowercase() == "gunting") {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        } else if (playerOne.lowercase() == "gunting") {
            return if (playerTwo.lowercase() == "kertas") {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        } else if (playerOne.lowercase() == "kertas") {
            return if (playerTwo.lowercase() == "batu") {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        }

        return status
    }
}