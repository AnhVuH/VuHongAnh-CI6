package scene;

import base.GameObjectManager;
import game.background.Background;

import game.star.StarSpawner;

public class GameOverScene implements Scene {
    @Override
    public void inint() {
        this.setupCharacter();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }

    private void setupCharacter(){
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new StarSpawner());
    }
}
