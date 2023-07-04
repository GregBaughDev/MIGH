package com.migh.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MIGHGame extends ApplicationAdapter {
	private static final int FRAME_COLS = 1;
	private static final int FRAME_ROWS = 3;

	Animation<TextureRegion> walkAnimation;
	Texture walkSheet;
	SpriteBatch spriteBatch;
	float stateTime;

	int x = 50;
	int y = 50;

	@Override
	public void create () {
		walkSheet = new Texture(Gdx.files.internal("M/M_walk.png"));
		TextureRegion[][] tmp = TextureRegion.split(
				walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);
		TextureRegion[] walkFrames = new TextureRegion[FRAME_ROWS];

		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			walkFrames[index++] = tmp[i][0];
		}

		walkAnimation = new Animation<>(0.1f, walkFrames);
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();

		TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		spriteBatch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x += 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			x -= 10;
		}
		spriteBatch.draw(currentFrame, x, y, 150, 150);
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		walkSheet.dispose();
	}
}
