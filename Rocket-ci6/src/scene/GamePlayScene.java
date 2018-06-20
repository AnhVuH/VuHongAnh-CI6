package scene;

import base.GameObjectManager;
import game.background.Background;
import game.effect.EffectObjectSpawner;
import game.enemy.EnemySpawner;
import game.enemy.SpecialEnemySpawner;
import game.player.Player;
import game.star.StarSpawner;

public class GamePlayScene implements Scene {


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

        this.setupPlayer();
        GameObjectManager.instance.add(new StarSpawner());
        GameObjectManager.instance.add(new EnemySpawner());
        GameObjectManager.instance.add(new SpecialEnemySpawner());
//
        GameObjectManager.instance.add(new EffectObjectSpawner());
    }



    private  void setupPlayer(){
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        player.playerMove.velocity.set(4,0);

    }
}
