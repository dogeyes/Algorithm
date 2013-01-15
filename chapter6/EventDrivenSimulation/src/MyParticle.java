import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-14
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public class MyParticle {
    private double rx, ry;
    private double vx, vy;
    private double s;
    private double mass;
    private Color color;
    private int count;
    public MyParticle()
    {
        rx = StdRandom.random();
        ry = StdRandom.random();
        vx = (StdRandom.random() - 0.5) * 0.01;
        vy = (StdRandom.random() - 0.5) * 0.01;
        s = StdRandom.random() * 0.01;
        mass = StdRandom.random() * 0.1;
        color = Color.BLACK;
    }
    public MyParticle(
            double rx, double ry,
            double vx, double vy,
            double s,
            double mass,
            Color color
    )
    {
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.s = s;
        this.mass = mass;
        count = 0;
        this.color = color;
    }
    public void draw()
    {
        Color color1 = StdDraw.getPenColor();
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, s);
        StdDraw.setPenColor(color1);
    }
    public void move(double dt)
    {
        rx += vx * dt;
        ry += vy * dt;
    }
    public int count()
    {
        return count;
    }
    public double timeToHit(MyParticle b)
    {

    }
    public double timeToHitHorizontalWall()
    {

    }
    public double timetoHitVerticalWall()
    {

    }
    public void bounceOff(Particle b)
    {

    }
    public void bounceHorizontalWall()
    {
        vx = -vx;
        count++;
    }
    public void bounceVerticalWall()
    {
        vy = -vy;
        count++;
    }


}
