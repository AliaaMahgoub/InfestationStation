package com.badlogic.ratrun;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {

    final RatRun game;
    final BitmapFont font;
    final SpriteBatch batch;

    private Texture pizzaImage;
    private Texture appleImage;
    private Texture ratImage;
    private Texture trainImage;
    private Texture lifeImage1;
    private Texture lifeImage2;
    private Texture lifeImage3;

    private Texture[] trainImages = new Texture[5];

    private Sound trainSound;
    private Sound appleSound;
    private Sound loss;
    private Sound pizzaSound;

    private Music music;
    private OrthographicCamera camera;
    private Rectangle rat;
    private Rectangle life1;
    private Rectangle life2;
    private Rectangle life3;
    private ArrayList<Texture> lives = new ArrayList<Texture>();
    private ArrayList<Rectangle> pizzas;
    private ArrayList<Rectangle> trains;
    private ArrayList<Rectangle> apples;
    private long lastPizzaTime;
//    private long lastTrainTime;
//    private long lastAppleTime;
    private int score;
    private Texture backgroundImage;

    public GameScreen(final RatRun gam) {
        this.game = gam;

        pizzaImage = new Texture(Gdx.files.internal("pizza.png"));
        appleImage = new Texture(Gdx.files.internal("apple.png"));
        trainImages[0] = new Texture(Gdx.files.internal("7.png"));
        trainImages[1] = new Texture(Gdx.files.internal("e.png"));
        trainImages[2] = new Texture(Gdx.files.internal("g.png"));
        trainImages[3] = new Texture(Gdx.files.internal("m.png"));
        trainImages[4] = new Texture(Gdx.files.internal("r.png"));
        ratImage = new Texture(Gdx.files.internal("rat3.png"));
        backgroundImage = new Texture(Gdx.files.internal("background.png"));
        lifeImage1 = new Texture(Gdx.files.internal("heart.png"));
        lifeImage2 = new Texture(Gdx.files.internal("heart.png"));
        lifeImage3 = new Texture(Gdx.files.internal("heart.png"));

        life1 = new Rectangle();life2 = new Rectangle();life3 = new Rectangle();
        life1.x = 800+130;life1.y = 960-130;life2.x = 1600/2;
        life2.y = 830;life3.x = 800-130;life3.y = 960-130;
        lives.add(lifeImage1);lives.add(lifeImage2);lives.add(lifeImage3);
        life1.width = 130;life1.height = 130;life2.width = 130;
        life2.height = 130;life3.width = 130;life3.height = 130;
        trainSound = Gdx.audio.newSound(Gdx.files.internal("trainSound.wav")); //Music from <a href="https://pixabay.com/music/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=6268">Pixabay</a>
        appleSound = Gdx.audio.newSound(Gdx.files.internal("appleSound.mp3")); //Music from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=14588">Pixabay</a>
        pizzaSound = Gdx.audio.newSound(Gdx.files.internal("pizzaSound.mp3")); // Music from <a href="https://pixabay.com/music/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=14728">Pixabay</a>
        loss = Gdx.audio.newSound(Gdx.files.internal("loss.mp3")); //Music from <a href="https://pixabay.com/music/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=6347">Pixabay</a>
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3")); //Music by <a href="/users/wolfbeat-26300059/?tab=audio&amp;utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=audio&amp;utm_content=108750">WolfBeat</a> from <a href="https://pixabay.com/music/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=108750">Pixabay</a>
        music.setLooping(true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 960);

        rat = new Rectangle();
        rat.x = 150;
        rat.y = 960 / 2 - 150 / 2;
        rat.width = 150;
        rat.height = 150;

        pizzas = new ArrayList<Rectangle>();
        spawnPizza();
        apples = new ArrayList<Rectangle>();
        spawnApple();
        trains = new ArrayList<Rectangle>();
        trainImage = trainImages[(int) (Math.random() * (5))];
        spawnTrain();

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("rats.fnt"),false);
    }

    private void spawnPizza() {
        Rectangle pizza = new Rectangle();
        int[] spawnHeights = {830-200, 830-400, 830-600, 830-800};
        pizza.y = spawnHeights[(int) (Math.random() * (3))];
//    (MathUtils.random(0, 960 - 150);
        pizza.x = 1600;
        pizza.width = 150;
        pizza.height = 150;
        pizzas.add(pizza);
        lastPizzaTime = TimeUtils.nanoTime();
    }

    private void spawnApple() {
        Rectangle apple = new Rectangle();
        int[] spawnHeights = {830-200, 830-400, 830-600, 830-800};
        apple.y = spawnHeights[(int) (Math.random() * (3))];
//    (MathUtils.random(0, 960 - 150);
        apple.x = 1600;
        apple.width = 104;
        apple.height = 150;
        apples.add(apple);
//        lastAppleTime = TimeUtils.nanoTime();
    }

    private void spawnTrain() {
        Rectangle train = new Rectangle();
        int[] spawnHeights = {830-200, 830-400, 830-600, 830-800};
        train.y = spawnHeights[(int) (Math.random() * (3))];
//        int[] spawnX = {1600-200, 1600-400, 1600-600, 1600-800, 1600-1000, 1600-1200, 1600-1400};
//        train.x = spawnX[(int) (Math.random() * (6))];
//        train.y = MathUtils.random(0, 960 - 150);
        train.x = 1600;
        train.width = 140;
        train.height = 140;
        trains.add(train);
//        trainImage = trainImages[(int) (Math.random() * (5))];
//        lastTrainTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0);
        game.batch.draw(lifeImage1, life1.x, life1.y);
        game.batch.draw(lifeImage2, life2.x, life2.y);
        game.batch.draw(lifeImage3, life3.x, life3.y);
//        game.font.getData().setScale(4);
//        game.font.draw(game.batch, "SCORE: " + score, 800-130, 960-130);
        game.batch.draw(ratImage, rat.x, rat.y);
        for (Rectangle pizza : pizzas) {
            game.batch.draw(pizzaImage, pizza.x, pizza.y);
        }
        for (Rectangle apple : apples) {
            game.batch.draw(appleImage, apple.x, apple.y);
        }
        for (Rectangle train : trains) {
            game.batch.draw(trainImage, train.x, train.y);
        }
        game.batch.end();

        batch.begin();
        font.draw(batch, "SCORE: " + score, 800-130, 960-130);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.UP))
            rat.y += 500 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            rat.y -= 500 * Gdx.graphics.getDeltaTime();

        if (rat.y < 0)
            rat.y = 0;
        if (rat.y > 830-150)
            rat.y = 830 - 150;

//        if (TimeUtils.nanoTime() - lastPizzaTime > 1000000000)
        if (TimeUtils.nanoTime() - lastPizzaTime > 1000000000/2)
        {
            int choice = (int) (Math.random() * (5));
            if (choice==0) spawnPizza();
            if (choice==1 || choice==2) spawnApple();
            else spawnTrain();
        }
//        if (TimeUtils.nanoTime() - lastTrainTime > 1000000000)
//            spawnTrain();
//
//        if (TimeUtils.nanoTime() - lastAppleTime > 1000000000)
//            spawnApple();

        Iterator<Rectangle> iter = pizzas.iterator();
        Iterator<Rectangle> trainIter = trains.iterator();
        Iterator<Rectangle> appleIter = apples.iterator();

        while (iter.hasNext() && trainIter.hasNext() && appleIter.hasNext()) {
            Rectangle train = trainIter.next();
            Rectangle pizza = iter.next();
            Rectangle apple = appleIter.next();
            train.x -= 550 * Gdx.graphics.getDeltaTime();
            pizza.x -= 550 * Gdx.graphics.getDeltaTime();
            apple.x -= 550 * Gdx.graphics.getDeltaTime();
            if (pizza.x < -200)
                iter.remove();
            if (train.x < -200)
                trainIter.remove();
            if (apple.x < -200)
                appleIter.remove();
            if (train.overlaps(rat)) {
                trainIter.remove();
                trainSound.play();
                if (lives.size()==1)
                {
                    loss.play();
                    music.pause();
                    game.setScreen(new MainMenuScreen(game));
                }
                lives.get(lives.size()-1).dispose();
                lives.remove(lives.size()-1);
            }
            if (pizza.overlaps(rat)) {
                pizzaSound.play();
                score += 10;
                iter.remove();
            }
            if (apple.overlaps(rat)) {
                appleSound.play();
                score += 5;
                appleIter.remove();
            }
            if (pizza.overlaps(train) || pizza.overlaps(apple)) {
                iter.remove();
            }
            if (apple.overlaps(train)) {
                appleIter.remove();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        music.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

//    public void dispose() {
////        pizzaImage.dispose();
////        trainImage.dispose();
////        backgroundImage.dispose();
////        ratImage.dispose();
////        dropSound.dispose();
////        music.dispose();
//    }

}
