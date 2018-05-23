import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX;

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
    }

    public void run(String direction){
        if(direction.equalsIgnoreCase("left")){
            this.x -= this.velocityX;
        }
        else if(direction.equalsIgnoreCase("right")){
            this.x += this.velocityX;
        }


    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x, this.y, this.width, this.height, null);
    }
}
