package io.github.robertaguilera712;

public class StarfishGame extends BaseGame{
    @Override
    public void create() {
        setActiveScreen(new MenuScreen());
    }
}
