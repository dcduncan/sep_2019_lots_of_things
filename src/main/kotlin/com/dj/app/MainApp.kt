package com.dj.app

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.http.content.staticRootFolder
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
            static("static") {
                files("build/static")
            }
            
            get("/") {
                val file = File("build/index.html")
                call.respondFile(file)
            }

            get("/hi") {
                call.respondText("poop", ContentType.Text.Plain)
            }
        }
    }.start(wait = true)
}