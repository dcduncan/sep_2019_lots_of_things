package com.dj.app

data class Food(val name: String)

class Pig(private val food: Food): PoopMaker {
    override fun makePoop(): String {
        return "Piggy ${food.name} poop"
    }
}