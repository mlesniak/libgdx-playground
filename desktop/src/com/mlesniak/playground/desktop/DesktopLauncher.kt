package com.mlesniak.playground.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mlesniak.playground.Main

class DesktopLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
           val config = LwjglApplicationConfiguration()
            LwjglApplication(Main(), config)
        }
    }
}