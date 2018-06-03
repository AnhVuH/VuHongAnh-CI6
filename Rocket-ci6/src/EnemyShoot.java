import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;

    private FrameCounter frameCounter = new FrameCounter(200);

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(SpecialEnemy enemy){

        if(this.frameCounter.run()){
            for(int angle=0; angle<360; angle+=30){
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.velocity= new Vector2D(5,0).rotate(angle);
                bulletEnemy.position.set(enemy.position);
                this.bulletEnemies.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }


        //xoa cac vien dan ra ngoai man hinh

        Iterator<BulletEnemy> it = bulletEnemies.iterator();
        while (it.hasNext()) {
            BulletEnemy bullet = it.next();
            if(bullet.position.x <0 || bullet.position.x >1024 || bullet.position.y<0 ||bullet.position.y >1024) {
                it.remove();
            }
        }



    }

}
