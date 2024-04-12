package io.github.robertaguilera712;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class StarfishCollector extends GameBeta {

    private Turtle turtle;
    private boolean win;

    @Override
    public void initialize() {
        BaseActor ocean = new BaseActor(0, 0, mainStage);
        ocean.loadTexture("water.jpg");
        ocean.setSize(800, 600);

        new Starfish(400, 400, mainStage);
        new Starfish(500, 100, mainStage);
        new Starfish(100, 450, mainStage);
        new Starfish(200, 250, mainStage);

        new Rock(200, 150, mainStage);
        new Rock(100, 300, mainStage);
        new Rock(300, 350, mainStage);
        new Rock(450, 200, mainStage);

        turtle = new Turtle(20, 20, mainStage);

        win = false;
    }

    @Override
    public void update(float dt) {
        for (BaseActor rockActor : BaseActor.getArray(mainStage, Rock.class.getName()))
            turtle.preventOverlap(rockActor);

        for (BaseActor starfishActor : BaseActor.getArray(mainStage, Starfish.class.getName())){
            Starfish starfish = (Starfish) starfishActor;
            if (turtle.overlaps(starfish) && !starfish.isCollected()){
                starfish.collect();

                Whirlpool whirl = new Whirlpool(0, 0, mainStage);
                whirl.centerAtActor(starfish);
                whirl.setOpacity(0.25f);
            }
        }

        if (BaseActor.count(mainStage, Starfish.class.getName()) == 0 && !win){
            win = true;
            BaseActor winMessage = new BaseActor(0, 0, mainStage);
            winMessage.loadTexture("you-win.png");
            winMessage.centerAtPosition(400, 300);
            winMessage.setOpacity(0);
            winMessage.addAction(Actions.delay(1));
            winMessage.addAction(Actions.after(Actions.fadeIn(1)));
        }


    }
}
