package com.migh.game.animation.michael

import com.badlogic.gdx.Input

class Michael {
    private val walk = MichaelWalk(1, 4, 50, 50, "M/M_walk.png")
    private val jump = MichaelJump(1, 5, 50, 50, "M/M_jump.png")

    private var xPosition: Int = walk.x
    // Need to allow jump animation to play more than once?
    // Need backwards jump action
    // Also need to sort disappearing sprite -> Need to just render it
    fun render(keycode: Int) {
        when (keycode) {
            in Input.Keys.LEFT..Input.Keys.RIGHT -> {
                walk.x = xPosition
                walk.render(keycode)
                xPosition = walk.x
            }
            Input.Keys.SPACE -> {
                jump.x = xPosition
                jump.render(keycode)
                xPosition = jump.x
            }
        }
    }

    fun dispose() {
        walk.dispose()
        jump.dispose()
    }
}