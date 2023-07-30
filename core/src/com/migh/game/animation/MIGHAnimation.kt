package com.migh.game.animation

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.g2d.Animation

abstract class MIGHAnimation(
    frameCols: Int,
    frameRows: Int,
    private var x: Float,
    private var y: Float,
    path: String
) {
    private var animation: Animation<TextureRegion>
    private var spriteSheet: Texture = Texture(Gdx.files.internal(path))
    private var spriteBatch: SpriteBatch
    private var stateTime: Float = 0f
    private var isAnimated = false
    private val speed = 5

    init {
        val tmp = TextureRegion.split(
            spriteSheet,
            spriteSheet.width / frameCols,
            spriteSheet.height / frameRows
        )
        val frames = arrayOfNulls<TextureRegion>(frameRows)

        frames.forEachIndexed {
                index, _ -> frames[index] = tmp[index][0]
        }

        animation = Animation(0.1f, *frames)
        spriteBatch = SpriteBatch()
    }

    fun render(keycode: Int) {
        stateTime += Gdx.graphics.deltaTime

        spriteBatch.begin()

        handleInput(keycode)

        val currentFrame = animation.getKeyFrame(stateTime, isAnimated)
        spriteBatch.draw(currentFrame, x, y, 150f, 150f)
        spriteBatch.end()
    }

    fun dispose() {
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