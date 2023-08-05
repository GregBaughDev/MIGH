package com.migh.game.animation.michael

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.migh.game.animation.MIGHAnimation
import com.migh.game.animation.create as create

class MichaelWalk(
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
    override val speedY = 5
    override val speedX = 5

    // TO DO -> Move the below to a method that calls the appropriate method when all the sprites are done
    override fun handleInput(keycode: Int) {
        if (Gdx.input.isKeyPressed(keycode)) {
            when (keycode) {
                // Right arrow
                22 -> {
                    if (x < Gdx.graphics.width) {
                        isAnimated = true
                        x += speedX
                    }
                }
                // Left arrow
                21 -> {
                    if (x > 0) {
                        isAnimated = true
                        x -= speedX
                    }
                }
            }
        } else {
            isAnimated = false
        }
    }
}