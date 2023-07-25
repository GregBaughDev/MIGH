package com.migh.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion

class MIGHGame: ApplicationAdapter() {
    private val FRAME_COLS = 1
    private val FRAME_ROWS = 3

    lateinit var walkAnimation: Animation<TextureRegion>
    lateinit var walkSheet: Texture
    lateinit var spriteBatch: SpriteBatch
    var stateTime: Float = 0f

    private var x = 50f
    private var y = 50f

    override fun create() {
        walkSheet = Texture(Gdx.files.internal("M/M_walk.png"))
        val tmp = TextureRegion.split(
            walkSheet,
            walkSheet.width / FRAME_COLS,
            walkSheet.height / FRAME_ROWS
        )
        val walkFrames = Array(FRAME_ROWS) { TextureRegion() }

        walkFrames.forEachIndexed { index, _ -> walkFrames[index] = tmp[index][0] }

        walkAnimation = Animation(0.1f, *walkFrames)
        spriteBatch = SpriteBatch()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stateTime += Gdx.graphics.deltaTime

        val currentFrame: TextureRegion = walkAnimation.getKeyFrame(stateTime, true)
        spriteBatch.begin()

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 10
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 10

        spriteBatch.draw(currentFrame, x, y, 150f, 150f)
        spriteBatch.end()
    }

    override fun dispose() {
        spriteBatch.dispose()
        walkSheet.dispose()
    }
}