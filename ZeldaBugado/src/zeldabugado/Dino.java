package zeldabugado;

import jplay.Sprite;
import jplay.Window;

/**
 *
 * @author Leonardo
 */
public class Dino extends Sprite
{

    private int sentido;
    private int sAnterior;
    boolean flag = true;
    private boolean vivo = true;
    private int dinoDiff = 1;

    public Dino(int x, int y, Boneco boneco)
    {
        super("dino.png", 20);
        setTotalDuration(3500);
        sentido = Constantes.RIGHT;
        sAnterior = Constantes.RIGHT;
        setCurrFrame(1);
        this.x = x;
        this.y = y;
    }

    public void move(Boneco boneco, Window window)
    {
        if (this.vivo == true)
        {
            if (boneco.y == this.y && this.x > 10)
            {
                if (boneco.x + boneco.width <= this.x)
                {
                    if (sentido != Constantes.LEFT)
                    {
                        sentido = Constantes.LEFT;
                        setSequence(11, 20);
                    }
                    this.x -= 0.25 * this.dinoDiff;
                } else
                {
                    if (boneco.x >= this.x + boneco.width)
                    {
                        if (sentido != Constantes.RIGHT)
                        {
                            sentido = Constantes.RIGHT;
                            setSequence(1, 10);
                        }
                        this.x += 0.25 * this.dinoDiff;
                    }
                }
            } else
            {
                if (boneco.x < this.x && this.x + this.width < window.getWidth() && this.x - boneco.x < 150)
                {
                    if (window.getWidth() - (this.x + this.width) < 2)
                    {
                        this.x -= 250;
                    }
                    if (sentido != Constantes.RIGHT)
                    {
                        sentido = Constantes.RIGHT;
                        setSequence(1, 10);
                    }
                    this.x += 0.25 * this.dinoDiff;
                } else
                {
                    if (boneco.x > this.x && this.x > 1 && boneco.x - this.x < 150)
                    {
                        if (window.getWidth() - (this.x + this.width) < 590)
                        {
                            if (sentido != Constantes.LEFT)
                            {
                                sentido = Constantes.LEFT;
                                setSequence(11, 20);
                            }
                        }
                        this.x -= 0.25 * this.dinoDiff;
                    }
                }
            }
            update();
        }
    }

    public void matarDino()
    {
        this.vivo = false;
        this.x = 999999;
    }

    public boolean getAlive()
    {
        return this.vivo;
    }
    
    public void setDinoDiff(int i)
    {
        dinoDiff = i;
    }
}
