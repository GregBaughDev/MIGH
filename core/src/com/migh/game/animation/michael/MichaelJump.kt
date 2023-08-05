package com.migh.game.animation.michael

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.migh.game.animation.MIGHAnimation
import com.migh.game.animation.create

class MichaelJump(
    override val frameCols: Int,
    override val frameRows: Int,
    override var x: Int,
    override var y: Int,
    override val path: String
) : MIGHAnimation {
    override var stateTime = 0f
    override var spriteSheet = Texture(Gdx.files.internal(path))
    override var animation = create(frameCols, frameRows)
    override var spriteBatch = SpriteBatch()
    override var isAnimated = false
    override var speedY = 10
    override var speedX = 5

    enum class JumpState {
        ASCENDING, DESCENDING, STATIC
    }

    private var jumpState = JumpState.ASCENDING

    override fun handleInput(keycode: Int) {
        jump()
    }

    private fun jump() {
        isAnimated = true

        if (jumpState == JumpState.ASCENDING) {
            ascend()
        }

        if (jumpState == JumpState.DESCENDING) {
            descend()
        }

        isAnimated = false
    }

    private fun ascend() {
        if (y < 200) {
            y += speedY
            x += 2
        }

        if (y == 200) {
            jumpState = JumpState.DESCENDING
        }
    }

    private fun descend() {
        if (y > 50) {
            y -= speedY
            x += 3
        }

        if (y == 50) {
            jumpState = JumpState.STATIC
        }
    }
}