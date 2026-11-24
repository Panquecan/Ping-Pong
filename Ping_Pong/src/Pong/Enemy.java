package Pong;

import java.awt.*;

public class Enemy {

    public double x,y;
    public int WIDTH, HEIGHT;
    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.WIDTH = 40;
        this.HEIGHT = 5;
    }
    public void tick() {
        x += (Game.ball.x - x - 6) * 0.15;
    }
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }

}