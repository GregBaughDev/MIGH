package com.migh.game.animation.michael

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.migh.game.animation.MIGHAnimation
import com.migh.game.animation.create as create

class MichaelWalk(
    frameCols: Int,
    frameRows: Int,
    private var x: Float,
    private var y: Float,
    path: String
    ) : MIGHAnimation {
    override var stateTime: Float = 0f
    override lateinit var animation: Animation<TextureRegion>
    override var spriteSheet: Texture = Texture(Gdx.files.internal(path))
    override var spriteBatch: SpriteBatch = SpriteBatch()
    override var isAnimated = false
    override val speed: Int = 5

    init {
        animation = create(frameCols, frameRows)
    }

    override fun render(keycode: Int) {
        stateTime += Gdx.graphics.deltaTime

        spriteBatch.begin()

        handleInput(keycode)

        val currentFrame = animation.getKeyFrame(stateTime, isAnimated)
        spriteBatch.draw(currentFrame, x, y, 150f, 150f)
        spriteBatch.end()
    }

    override fun dispose() {
        spriteBatch.dispose()
        spriteSheet.dispose()
    }

    // TO DO -> Move the below to a method that calls the appropriate method when all the sprites are done
    private fun handleInput(keycode: Int) {
        if (Gdx.input.isKeyPressed(keycode)) {
            when (keycode) {
                22 -> {
                    if (x < Gdx.graphics.width) {
                        isAnimated = true
                        x += speed
                    }
                }
                21 -> {
                    if (x > 0) {
                        isAnimated = true
                        x -= speed
                    }
                }
            }
        } else {
            isAnimated = false
        }
    }
}