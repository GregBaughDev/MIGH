package com.migh.game.animation.michael

enum class MActions {
    WALK, JUMP
}

class Michael {
    val walk: MichaelWalk = MichaelWalk(1, 3, 50f, 50f, "M/M_walk.png")
//    val jump: MichaelMovement = MichaelMovement(1, 3, 50f, 50f, "M/M_jump.png")
    var currentAction: MActions = MActions.WALK

    fun render(keycode: Int) {
        when (currentAction) {
            MActions.WALK -> walk(keycode)
            MActions.JUMP -> println("Jumping")
        }
    }

    private fun walk(keycode: Int) {
        walk.render(keycode)
    }

    private fun jump(keycode: Int) {
//        jump.render(keycode)
    }

    fun dispose() {
        walk.dispose()
    }
}