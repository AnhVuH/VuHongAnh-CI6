package game.player;

import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import game.Particle;
import game.bullet.BulletEnemy;
import game.effect.*;
import game.enemy.Enemy;
import game.enemy.SpecialEnemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;

    public PlayerMove playerMove;

    private PlayerShoot playerShoot;

    private RunHitObject runHitObject;
    private CreateSmoke createSmoke;

//    private Shield shield;

    public boolean hitEnemy= false;

    private  int life;

   public boolean specialShoot;

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,16);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                BulletEnemy.class,
                SpecialEnemy.class,
                EffectShield.class,
                EffectTripleShoot.class);
        this.life =1;
        this.createSmoke =new CreateSmoke();
        this.specialShoot = false;

//        this.shield = new Shield();

    }


    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x,this.position.y);

        this.playerShoot.run(this);

        ((PolygonRenderer)(this.renderer)).angle = this.playerMove.angle;
        this.runHitObject.run(this);
        this.createSmoke.run(this);

    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof BulletEnemy || gameObject instanceof SpecialEnemy ){
            if(this.life==1){
                this.isAlive = false;
                if(gameObject instanceof Enemy ||gameObject instanceof SpecialEnemy){
                    this.hitEnemy = true;
                }
            }
            else{
                this.life -=1;
            }
        }
        if(gameObject instanceof EffectShield){
            this.life = 4;


        }
        if(gameObject instanceof EffectTripleShoot){
            this.specialShoot = true;
        }
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        if(this.life >1){
            graphics.setColor(Color.GREEN);
            graphics.drawOval((int)this.position.x-25, (int)this.position.y-25, 50,50);
        }


    }
}

