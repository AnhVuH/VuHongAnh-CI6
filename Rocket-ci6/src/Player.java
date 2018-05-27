import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public BufferedImage image;

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D center;
    public double angle;
    private Random random;
    private List<Vector2D> verties;
    private Polygon polygon;



    public Player(BufferedImage image) {
        this.image = image;
        this.position = new Vector2D();
        this.velocity = new Vector2D(3,0);
        this.random = new Random();
        this.polygon = new Polygon();
        this.angle =0;

    }

    public void run() {
        this.velocity = this.velocity.rotate(angle);
        this.position.addUp(this.velocity);
        this.setVerties();
        this.backtoScreen ();
    }
//
//    public void changeDicretion(double angle){
//        this.velocity = this.velocity.rotate(angle);
//        this.changeVerties(angle);
//
//    }

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
        this.center = this.position;
        this.verties = Arrays.asList(
                this.center.add(new Vector2D(-7,-5)),
                this.center.add(new Vector2D(-7,5)),
                this.center.add(new Vector2D(14, 0))

        );

    }
    private void changeVerties(double angle){
        for (Vector2D vertex:verties) {
            vertex = vertex.subtractBy(this.center);
            vertex = vertex.rotate(this.angle);
            vertex = vertex.addUp(this.center);
            System.out.println(vertex.x);
        }

    }


    public void render(Graphics graphics){
        graphics.setColor(Color.RED);
        this.polygon.reset();

        this.verties.forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
        graphics.fillPolygon(this.polygon);

        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y,null);
    }
}
