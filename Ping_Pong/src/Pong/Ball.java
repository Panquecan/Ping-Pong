package Pong;

import java.awt.*;
import java.util.Random;

public class Ball {
    public double x,y;
    public int WIDTH, HEIGHT;

    public double dx,dy, hitPos;
    public double speed = 1.3;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.WIDTH = 4;
        this.HEIGHT = 4;
        int angle = new Random().nextInt((120 - 45)) + 46;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }
    public void tick(){

        if (x+(dx*speed) + WIDTH >= Pong.Game.width){
            dx*=-1;
        }
        else if (x+(dx*speed) < 0){
            dx*=-1;
        }
        if (y >= Pong.Game.height){
            //Ponto do inimigo
            System.out.println("Ponto do inimigo!");
            new Pong.Game();
            return;
        }
        else if (y < 0){
            //Ponto do jogador
            System.out.println("Ponto nosso!");
            new Pong.Game();
            return;
        }

        Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),WIDTH, HEIGHT);
        Rectangle boundsPlayer = new Rectangle(Pong.Game.player.x, Pong.Game.player.y, Pong.Game.player.WIDTH, Pong.Game.player.HEIGHT);
        Rectangle boundsEnemy = new Rectangle((int) Pong.Game.enemy.x,(int) Pong.Game.enemy.y, Pong.Game.enemy.WIDTH, Pong.Game.enemy.HEIGHT);

        if (bounds.intersects(boundsPlayer)){
            dy*=-1;
            speed+=0.1;
            hitPos = (x - Pong.Game.player.x) / Pong.Game.player.WIDTH;
            dx = (hitPos - 0.5) * 2;
            if (dy > 0){
                dy--;
            }

        }
        else if(bounds.intersects(boundsEnemy)){
            dy*=-1;
            speed+=0.1;
            hitPos = (x - Pong.Game.enemy.x) / Pong.Game.enemy.WIDTH;
            dx = (hitPos - 0.5) * 2;
            if (dy < 0){
                dy--;
            }

        }

        x+=dx*speed;
        y+=dy*speed;
    }
    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }

}