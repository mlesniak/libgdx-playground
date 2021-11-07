package com.mlesniak.playground

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx.app
import com.badlogic.gdx.Gdx.input
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

// TODO(mlesniak) use camera for resolution independent viewport.
class Main : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
    }

    override fun render() {
        handleGlobalInput()

        ScreenUtils.clear(24 / 255f, 24 / 255f, 24 / 255f, 1f)
        batch.begin()
        batch.end()
    }

    private fun handleGlobalInput() {
        if (input.isKeyPressed(Input.Keys.ESCAPE)) {
            app.exit()
        }
    }
}