import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D center;
    private Random random;
    private List<Vector2D> verties;
    private Polygon polygon;


    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D(3,0);
        this.random = new Random();
        this.polygon = new Polygon();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.backtoScreen ();
    }

    public void changeDicretion(double angle){
        this.velocity = this.velocity.rotate(angle);
        this.verties.forEach(vertex-> vertex = vertex.rotate(angle));
    }


    private void backtoScreen(){
        if(this.position.x >1024){
            this.position.set(0, this.random.nextInt(600));
        }

        if(this.position.x <0){
            this.position.set(1024, this.random.nextInt(600));
        }
        if(this.position.y >600){
            this.position.set(this.random.nextInt(1024),0);
        }
        if(this.position.y <0){
            this.position.set(this.random.nextInt(1024),600);
        }

    }
    private void setVerties(){
        // tam giac can chieu cao 21, canh day 10
        this.center = this.position.copy();
        this.verties = Arrays.asList(
                new Vector2D(this.center.x-7, this.center.y-5),
                new Vector2D(this.center.x-7 ,this.center.y+5),
                new Vector2D(this.center.x+ 14,this.center.y)
        );
    }


    public void render(Graphics graphics){
        graphics.setColor(Color.RED);
        this.polygon.reset();
        this.setVerties();
        this.verties.forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
        graphics.fillPolygon(this.polygon);
    }
}
