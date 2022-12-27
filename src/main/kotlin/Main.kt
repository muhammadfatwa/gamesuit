import java.util.Scanner
import kotlin.system.exitProcess

fun main() {
    val greeting = Greeting()
    val matching = Matching()

    greeting.welcome()

    val input = Scanner(System.`in`)

    var currentRound: Int = 0
    var rounds: Int
    var quetionPlayerOne: String
    var quetionPlayerTwo: String
    var repeat: Char
    val pointList: MutableList<Any> = mutableListOf()

    while (true) {
        println("=== Ronde ===")
        println("1 Ronde")
        println("3 Ronde")
        println("Ketik 0 untuk keluar")
        print("Masukkan Pilihan Kamu: ")
        rounds = input.next().toInt()

        when (rounds) {
            1 -> {
                print("1. Masukkan pemain 1: ")
                quetionPlayerOne = input.next()
                print("2. Masukkan pemain 2: ")
                quetionPlayerTwo = input.next()

                matching.match(quetionPlayerOne, quetionPlayerTwo)

                print("Apakah kamu mau main lagi? (y/n) ")
                repeat = input.next().single()
                if (repeat == 'y') {
                    rounds = 2
                }
                if (repeat == 'n') {
                    println("Terimakasih sudah bermain")
                    exitProcess(0)
                }
            }

            3 -> {
                for (i in 1..10) {
                    if (currentRound < rounds) {
                        print("1. Masukkan pemain 1: ")
                        quetionPlayerOne = input.next()
                        print("2. Masukkan pemain 2: ")
                        quetionPlayerTwo = input.next()

                        val result = matching.match(quetionPlayerOne, quetionPlayerTwo)
                        println("")
                        println(result)
                        println("")
                        pointList += result
                        if (result !== "DRAW!") {
                            currentRound += 1
                        }
                    }
                    if (currentRound == rounds) {
                        val countPlayerOneIsWinner = pointList.count { it == "Pemain 1 MENANG!" }
                        val countPlayerTwoIsWinner = pointList.count { it == "Pemain 2 MENANG!" }

                        println("Skor: Player 1 ($countPlayerOneIsWinner) vs Player 2 ($countPlayerTwoIsWinner) ")
                        if (countPlayerOneIsWinner > countPlayerTwoIsWinner) {
                            println("Selamat Player 1 MENANG!")
                        } else {
                            println("Selamat Player 2 MENANG!")
                        }

                        print("Apakah kamu mau main lagi? (y/n) ")
                        repeat = input.next().single()
                        if (repeat == 'y') {
                            currentRound = 0
                            break
                        }
                        if (repeat == 'n') {
                            println("")
                            println("Terimakasih sudah bermain")
                            exitProcess(0)
                        }
                    }

                }
            }

            0 -> {
                println("")
                println("Terimakasih sudah bermain")
                exitProcess(0)
            }

            else -> println("Oops, Silahkan coba lagi")
        }
    }
}