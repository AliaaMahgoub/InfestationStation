//package com.badlogic.ratrun;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.utils.ScreenUtils;
//
//public class MainMenuScreen implements Screen {
//
//    final RatRun game;
//    private Texture backgroundImage;
//    OrthographicCamera camera;
////    private GameScreen gameScreen;
//
//    public MainMenuScreen(RatRun game) {
//        this.game = game;
//
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 1600, 960);
//    }
//
//    @Override
//    public void render(float delta) {
//        backgroundImage = new Texture(Gdx.files.internal("menuBackground.png"));
//
////        ScreenUtils.clear(0, 0, 0.2f, 1);
//        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
//        game.batch.begin();
//        game.batch.draw(backgroundImage, 0, 0);
////        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
////        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
//        game.batch.end();
//
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
////            login.start();
////            game.setScreen(new GameScreen(game));
//            dispose();
//        }
////        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
////            game.setScreen(new LeaderboardScreen());
////            dispose();
////        }
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void show() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void dispose() {
//    }
//}

package com.badlogic.ratrun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final RatRun game;
    private Texture menuBackgroundImage;
    private OrthographicCamera camera;
    private Instructions instructions = new Instructions();

    public MainMenuScreen(final RatRun gam) {
        game = gam;
        menuBackgroundImage = new Texture(Gdx.files.internal("menuBackground.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 960);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(menuBackgroundImage, 0, 0);
//        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
//        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new GameScreen(game));
//            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.H)){
            instructions.show();
//            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
