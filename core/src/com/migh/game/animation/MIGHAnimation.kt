package com.migh.game.animation

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.g2d.Animation

interface MIGHAnimation {
    val frameCols: Int
    val frameRows: Int
    var x: Float
    var y: Float
    val path: String
    var animation: Animation<TextureRegion>
    var spriteSheet: Texture
    var spriteBatch: SpriteBatch
    var stateTime: Float
    var isAnimated: Boolean
    val speed: Int

    fun handleInput(keycode: Int)

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
}

fun MIGHAnimation.create(frameCols: Int, frameRows: Int): Animation<TextureRegion> {
    val tmp = TextureRegion.split(
        spriteSheet,
        spriteSheet.width / frameCols,
        spriteSheet.height / frameRows
    )
    val frames = arrayOfNulls<TextureRegion>(frameRows)

    for (row in 0 until frameRows) {
        for (col in 0 until frameCols) {
            frames[row] = tmp[row][col]
        }
    }

    return Animation(0.1f, *frames)
}