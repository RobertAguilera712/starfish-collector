package io.github.robertaguilera712;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseScreen implements Screen {

    protected Stage mainStage;
    protected Stage uiStage;

    public BaseScreen(){
        mainStage = new Stage();
        uiStage = new Stage();

        initialize();
    }

    public abstract void initialize();

    public abstract void update(float dt);

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        uiStage.act(dt);
        mainStage.act(dt);

        update(dt);

        ScreenUtils.clear(0, 0, 0, 1);
        mainStage.draw();
        uiStage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
