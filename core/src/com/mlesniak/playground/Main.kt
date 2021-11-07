package com.mlesniak.playground

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx.app
import com.badlogic.gdx.Gdx.input
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import java.util.*

// TODO(mlesniak) use camera for resolution independent viewport.
class Main : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var pixmap: Pixmap
    private lateinit var texture: Texture

    override fun create() {
        batch = SpriteBatch()
        pixmap = Pixmap(800, 600, Pixmap.Format.RGB888)

        // Randomize
        val rand = Random()
        for (x in 0..pixmap.width) {
            for (y in 0..pixmap.height) {
                pixmap.drawPixel(x, y, rand.nextInt())
            }
        }
        texture = Texture(pixmap)
    }

    override fun render() {
        handleGlobalInput()

        ScreenUtils.clear(24 / 255f, 24 / 255f, 24 / 255f, 1f)
        batch.begin()
        batch.draw(texture, 0f, 0f)
        batch.end()
    }

    private fun handleGlobalInput() {
        if (input.isKeyPressed(Input.Keys.ESCAPE)) {
            app.exit()
        }
    }
}