package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.BulletPlayer;

public class PlayerShoot {


    private FrameCounter frameCounter ;

    public PlayerShoot(){

        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player){
        if(frameCounter.run()){
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));

        GameObjectManager.instance.add(bulletPlayer);
        frameCounter.reset();
        }


        //xoa cac vien dan ra ngoai man hinh
//        Iterator<game.bullet.BulletPlayer> it = bulletsPlayer.iterator();
//        while (it.hasNext()) {
//            game.bullet.BulletPlayer bullet = it.next();
//            if(bullet.position.x <0 || bullet.position.x >1024 || bullet.position.y<0 ||bullet.position.y >1024) {
//                it.remove();
//            }
//        }


    }
}
