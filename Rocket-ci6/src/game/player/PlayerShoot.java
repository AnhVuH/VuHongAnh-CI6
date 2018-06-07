package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.BulletPlayer;
import input.KeyboardInput;

public class PlayerShoot {



    public PlayerShoot(){


    }

    public void run(Player player){
        if(KeyboardInput.instance.spacePressed){
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));

        GameObjectManager.instance.add(bulletPlayer);

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
