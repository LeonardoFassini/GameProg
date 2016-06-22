package zeldabugado;

import jplay.GameImage;
import jplay.Sound;

/**
 *
 * @author Leonardo
 */
public class BackGround {
    GameImage backGround;
    Sound sound;
    
    public BackGround()
    {
        backGround = new GameImage("bg001.png");
        sound = null;
    }
    
    public void draw()
    {
        backGround.draw();
    }
    
    public void setBackGround(String link)
    {
        backGround.loadImage(link);
    }
    
    public GameImage getBackGround()
    {
        return backGround;
    }
}
