package com.migh.game.animation.michael

import com.badlogic.gdx.Input

class Michael {
    private val walk = MichaelWalk(1, 3, 50, 50, "M/M_walk.png")
    private val jump = MichaelJump(1, 3, 50, 50, "M/M_jump.png")

    // Need to pass current x value between actions

    fun render(keycode: Int) {
        when (keycode) {
            in Input.Keys.LEFT..Input.Keys.RIGHT -> walk.render(keycode)
            Input.Keys.SPACE -> jump.render(keycode)
        }
    }

    fun dispose() {
        walk.dispose()
    }
}