package zeldabugado;

import jplay.Collision;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Boneco extends Sprite
{

    private int sentido;
    private int sAnterior;
    private boolean flag;
    private int count;
    private boolean alive;
    private boolean gonnaDie;

    public Boneco(int x, int y)
    {
        super("bnc.png", 8);
        setTotalDuration(1960);
        sentido = Constantes.RIGHT;
        sAnterior = Constantes.RIGHT;
        setCurrFrame(1);
        this.x = x;
        this.y = y;
        flag = true;
        count = 0;
        alive = true;
        gonnaDie = false;
    }

    public void move(Window tela, Keyboard teclado)
    {
        if (!this.gonnaDie)
        {
            // Verificar se a seta pra esquerda esta pressionada
            if (teclado.keyDown(Keyboard.LEFT_KEY) && this.x >= 10)
            {
                if (sentido != Constantes.LEFT)
                {
                    setSequence(1, 4);
                    sAnterior = Constantes.LEFT;
                    sentido = Constantes.LEFT;
                }

                this.x -= 0.5;
            } else
            {
                // Verificar se a seta pra direita está pressionada
                if (teclado.keyDown(Keyboard.RIGHT_KEY) && ((this.x + this.width) < tela.getWidth()))
                {
                    if (sentido != Constantes.RIGHT)
                    {
                        setSequence(5, 8);
                        sAnterior = Constantes.RIGHT;
                        sentido = Constantes.RIGHT;
                    }
                    this.x += 0.5; //VERIFICAR ISSO;
                } else
                {
                    // Se nenhuma das duas esta pressionada, entao ele esta parado
                    sentido = Constantes.STOP;
                    if (sAnterior == Constantes.LEFT)
                    {
                        setCurrFrame(1); //VERIFICAR!
                    } else
                    {
                        setCurrFrame(5);
                    }
                }
            }
            // Verifico se eu pressionei o botao de pula
            if (teclado.keyDown(Keyboard.UP_KEY))
            {
                flag = false;
            }

            // Se o botao de pular foi pressionado uma vez, entao ele faz a animacao
            if (flag == false)
            {
                if (count <= 149)
                {
                    this.y -= 0.5;
                    count++;
                }
                if (count >= 150 && count <= 299)
                {
                    this.y += 0.5;
                    count++;
                }
                if (count == 300)
                {
                    count = 0;
                    flag = true;
                }
            }
            // Se ele nao esta parado, eu atualizo
            if (sentido != Constantes.STOP && flag == true)
            {
                update();
            }
        }
    }

    public void verifyFloor(Boneco boneco, Window window, int xburaco, int xburacoTamanho, int floor)
    {
        //verificar se ele está em um buraco
        System.out.println(this.x + this.width + " ... " + floor + " ... " + this.y + this.height);
        if (this.x > xburaco && this.x + this.width < xburaco + xburacoTamanho && this.y + this.height >= floor)
        {
            this.y += 0.5;
            this.gonnaDie = true;
        }

    }

    public int busted(Dino dino)
    {
        if (dino.getAlive())
        {
            if ((dino.x > this.x && dino.x < this.x + this.width) || (dino.x + dino.width > this.x && dino.x + dino.width < this.x + this.width))
            {
                if (this.y + this.height == dino.y)
                {
                    return 1;

                } else
                {
                    if (this.y + this.height > dino.y)
                    {
                        if ((this.x > dino.x && this.x < dino.x + dino.width) || (this.x + this.width > dino.x && this.x + this.width < dino.x + dino.width))
                        {
                            return 2;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void matarBoneco()
    {
        this.alive = false;
    }

    public boolean getAlive()
    {
        return this.alive;
    }
}
