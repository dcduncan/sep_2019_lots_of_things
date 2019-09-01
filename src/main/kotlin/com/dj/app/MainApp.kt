package com.dj.app

import org.koin.core.context.startKoin
import org.koin.dsl.module

fun main(args: Array<String>) {

    val module = module {
        single {
            Food("corn feed")
        }

        single {
            Pig(get()) as PoopMaker
        }
    }

    startKoin {
        printLogger()
        modules(module)
    }

    PoopApplication().makePoop()
}