package com.mlesniak.playground

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx.app
import com.badlogic.gdx.Gdx.gl
import com.badlogic.gdx.Gdx.input
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Main : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
    }

    override fun render() {
        handleGlobalInput()

        gl.glClearColor(0.095f, 0.095f, 0.095f, 1f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.end()
    }

    private fun handleGlobalInput() {
        if (input.isKeyPressed(Input.Keys.ESCAPE)) {
            app.exit()
        }
    }
}