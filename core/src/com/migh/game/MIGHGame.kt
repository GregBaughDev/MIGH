package com.migh.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.migh.game.animation.michael.Michael
import com.migh.game.system.MIGHInputProcessor

class MIGHGame: ApplicationAdapter() {
    private val mighInputProcessor = MIGHInputProcessor()
    private lateinit var michael: Michael

    override fun create() {
        Gdx.input.inputProcessor = mighInputProcessor
        michael = Michael()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        michael.render(mighInputProcessor.currentKey)
    }

    override fun dispose() {
        michael.dispose()
    }
}