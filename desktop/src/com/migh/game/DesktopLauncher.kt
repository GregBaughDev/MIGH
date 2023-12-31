package com.migh.game

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
fun main() {
    val windowWidth = 800
    val windowHeight = 700

    val config = Lwjgl3ApplicationConfiguration()
    config.setForegroundFPS(60)
    config.setTitle("Michael Is Going Home")
    config.setWindowedMode(windowWidth, windowHeight)
    Lwjgl3Application(MIGHGame(), config)
}