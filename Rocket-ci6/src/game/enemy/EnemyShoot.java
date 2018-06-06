package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.BulletEnemy;

public class EnemyShoot {

    private FrameCounter frameCounter ;

    public EnemyShoot(){
        this.frameCounter = new FrameCounter(200);
    }

    public void run(SpecialEnemy enemy){

        if(this.frameCounter.run()){
            for(int angle=0; angle<360; angle+=30){
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.velocity= new Vector2D(5,0).rotate(angle);
                bulletEnemy.position.set(enemy.position);
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }


        //xoa cac vien dan ra ngoai man hinh

//        Iterator<game.bullet.BulletEnemy> it = bulletEnemies.iterator();
//        while (it.hasNext()) {
//            game.bullet.BulletEnemy bullet = it.next();
//            if(bullet.position.x <0 || bullet.position.x >1024 || bullet.position.y<0 ||bullet.position.y >1024) {
//                it.remove();
//            }
//        }



    }

}
