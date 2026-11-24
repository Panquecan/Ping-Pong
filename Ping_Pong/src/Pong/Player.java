package Pong;

import java.awt.*;

public class Player {
    public int WIDTH, HEIGHT;
    public boolean right,left;
    public int x,y;
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.WIDTH = 40;
        this.HEIGHT = 5;
    }

    public void tick(){
        if(right){
            x+=2;
        }
        else if (left){
            x-=2;
        }
        if(x+WIDTH > Game.width){
            x = Game.width - WIDTH;
        }
        else if(x < 0){
            x = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
