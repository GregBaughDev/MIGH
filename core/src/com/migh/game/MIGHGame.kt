package com.migh.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.migh.game.animation.michael.MichaelWalk
import com.migh.game.system.MIGHInputProcessor

class MIGHGame: ApplicationAdapter() {
    private val mighInputProcessor = MIGHInputProcessor()
    private lateinit var michaelWalk: MichaelWalk

    override fun create() {
        Gdx.input.inputProcessor = mighInputProcessor
        michaelWalk = MichaelWalk(1, 3, 50f, 50f, "M/M_walk.png")
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        michaelWalk.render(mighInputProcessor.currentKey)
    }

    override fun dispose() {
        michaelWalk.dispose()
    }
}