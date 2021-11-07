package com.mlesniak.playground.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.mlesniak.playground.Main

class DesktopLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
           val config = Lwjgl3ApplicationConfiguration()
            Lwjgl3Application(Main(), config)
        }
    }
}