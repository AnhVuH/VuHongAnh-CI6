package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class SpecialEnemy extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private game.enemy.EnemyShoot enemyShoot;

    //constructor
    public SpecialEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png",20,20);
        this.boxCollider = new BoxCollider(20,20);
        this.enemyShoot = new game.enemy.EnemyShoot();
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x-10,this.position.y-10);
        Player player= GameObjectManager.instance.findPlayer();
        if (player != null){
            this.velocity.set(
                    player.position
                            .subtract(this.position)
                            .normalize()
                            .multiply(2.0f));
        }

    }
}
