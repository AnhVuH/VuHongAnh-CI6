package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EffectObjectSpawner extends GameObject {
    private FrameCounter frameCounterShield, frameCounterShoot;
    private Random random;

    public EffectObjectSpawner(){
        this.frameCounterShield = new FrameCounter(600);
        this.frameCounterShoot = new FrameCounter(800);
        this.random = new Random();
    }

    public void run(){
        if(this.frameCounterShield.run()){
            EffectShield effectShield = GameObjectManager.instance.recycle(EffectShield.class);
            effectShield.position.set(this.random.nextInt(800)+ 50, this.random.nextInt(400)+50);
            this.frameCounterShield.reset();
        }
        if(this.frameCounterShoot.run()){
            EffectTripleShoot effectTripleShoot = GameObjectManager.instance.recycle(EffectTripleShoot.class);
            effectTripleShoot.position.set(this.random.nextInt(800)+50, this.random.nextInt(400)+50);
            this.frameCounterShoot.reset();
        }

    }

}
