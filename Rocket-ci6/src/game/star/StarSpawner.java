package game.star;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(30);
    Random random;
    public StarSpawner() {
        this.random = new Random();
        this.createAction();
    }


    public void createAction(){
        Action waitAction = new WaitAction(30);
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                Star star = GameObjectManager.instance.recycle(Star.class);star.position.set(1024, random.nextInt(600));
                star.velocity.set(-(random.nextInt(2)+1),0);
                return true;
            }
        };

        Action sequenceAction = new SequenceAction(waitAction,createAction);
        Action repeatAction = new RepeatActionForever(sequenceAction);

        this.addAction(repeatAction);
    }

    @Override
    public void run(){
        super.run();
//        if(this.frameCounter.run()){
//            Star star = GameObjectManager.instance.recycle(Star.class);
//            star.position.set(1024, random.nextInt(600));
//            star.velocity.set(-(random.nextInt(2)+1),0);
//            this.frameCounter.reset();
//        }

    }
}
