package com.migh.game.animation.michael

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.migh.game.animation.MIGHAnimation
import com.migh.game.animation.create

class MichaelJump(
    override val frameCols: Int,
    override val frameRows: Int,
    override var x: Float,
    override var y: Float,
    override val path: String
) : MIGHAnimation {
    override var stateTime = 0f
    override var spriteSheet = Texture(Gdx.files.internal(path))
    override var animation = create(frameCols, frameRows)
    override var spriteBatch = SpriteBatch()
    override var isAnimated = false
    override val speed = 5

    // TO DO: Next time -> Jump animation
    override fun handleInput(keycode: Int) {
        println("Handlin' input")
    }
}