package com.migh.game.animation.michael

enum class MActions {
    WALK, JUMP
}

class Michael {
    private val walk = MichaelWalk(1, 3, 50f, 50f, "M/M_walk.png")
    private val jump = MichaelJump(1, 3, 50f, 50f, "M/M_jump.png")
    var currentAction: MActions = MActions.WALK

    fun render(keycode: Int) {
        when (currentAction) {
            MActions.WALK -> walk.render(keycode)
            MActions.JUMP -> jump.render(keycode)
        }
    }

    fun dispose() {
        walk.dispose()
    }
}