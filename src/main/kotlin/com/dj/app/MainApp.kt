package com.dj.app

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondFile
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.io.File

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondFile(File("./js.dagger2/src/index.html"))
            }
        }
    }.start(wait = true)
}