package io.github.robertaguilera712;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class GameBeta extends Game {

    protected Stage mainStage;
    protected Stage uiStage;

    @Override
    public void create() {
        mainStage = new Stage();
        uiStage = new Stage();
        initialize();
    }

    public abstract void initialize();

    @Override
    public void render() {
       float dt = Math.min(Gdx.graphics.getDeltaTime(), 1/30f);
       mainStage.act(dt);
       uiStage.act(dt);
       update(dt);

        ScreenUtils.clear(0, 0, 0, 1);

        mainStage.draw();
        uiStage.draw();
    }

    public abstract void update(float dt);
}
