package com.mlesniak.playground

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx.app
import com.badlogic.gdx.Gdx.input
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import java.util.*

// TODO(mlesniak) use camera for resolution independent viewport.
class Main : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var pixmap: Pixmap
    private lateinit var texture: Texture

    private lateinit var camera: Camera
    private lateinit var viewport: Viewport

    override fun create() {
        batch = SpriteBatch()
        pixmap = Pixmap(128, 128, Pixmap.Format.RGB888)

        // Randomize
        val rand = Random()
        for (x in 0..pixmap.width) {
            for (y in 0..pixmap.height) {
                pixmap.drawPixel(x, y, rand.nextInt())
            }
        }
        texture = Texture(pixmap)

        camera = OrthographicCamera(128f, 128f)
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f)
        viewport = FitViewport(camera.viewportWidth, camera.viewportHeight)
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun render() {
        handleGlobalInput()

        ScreenUtils.clear(24 / 255f, 24 / 255f, 24 / 255f, 1f)
        camera.update()
        batch.projectionMatrix = camera.combined
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