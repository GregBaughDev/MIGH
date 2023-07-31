package com.migh.game.animation

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.g2d.Animation

interface MIGHAnimation {
    var animation: Animation<TextureRegion>
    var spriteSheet: Texture
    var spriteBatch: SpriteBatch
    var stateTime: Float
    var isAnimated: Boolean
    val speed: Int

    fun render(keycode: Int)
    fun dispose()
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