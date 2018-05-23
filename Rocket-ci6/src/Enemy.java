import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX, velocityY;
    Random rand = new Random();


    //constructor

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(int windowWidth, int windowHeight){
        if(this.x + this.velocityX ==0){
            this.x =windowWidth;
        }
        else if(this.x + this.velocityX ==windowWidth){
            this.x =0;

        }
        else{
            this.x += this.velocityX;
        }

        if(this.y + this.velocityY ==0){
            this.y = windowHeight;
        }
        else if(this.y +this.velocityY == windowHeight){
            this.y =0;
        }
        else{
            this.y += this.velocityY;
        }

    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y,this.width,this.height,null);
    }
}
