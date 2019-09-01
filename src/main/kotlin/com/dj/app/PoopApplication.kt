package com.dj.app

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.response.respondFile
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File

class PoopApplication : KoinComponent {
    private val poopMaker by inject<PoopMaker>()

    fun makePoop() {
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
                    call.respondText(poopMaker.makePoop(), ContentType.Text.Plain)
                }
            }
        }.start(wait = true)
    }
}