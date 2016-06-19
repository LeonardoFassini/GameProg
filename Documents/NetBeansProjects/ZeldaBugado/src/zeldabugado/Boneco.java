package zeldabugado;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Boneco extends Sprite {
    private int sentido;
    private int sAnterior;
    boolean flag = true;
    int count = 0;
    public Boneco(int x, int y)
    {
        super("bnc.png", 8);
        setTotalDuration(1960);
        sentido = Constantes.RIGHT;
        sAnterior = Constantes.RIGHT;
        setCurrFrame(1);
        this.x = x;
        this.y = y;

    }
    
    public void move(Window tela, Keyboard teclado)
    {
        // Verificar se a seta pra esquerda esta pressionada
        if(teclado.keyDown(Keyboard.LEFT_KEY) && this.x >= 10) 
        {
            if(sentido != Constantes.LEFT)
            {
                setSequence(1,4);
                sAnterior = Constantes.LEFT;
                sentido = Constantes.LEFT;
            }
            
            this.x -= 0.5;
        }
        else
        {
            // Verificar se a seta pra direita está pressionada
            if(teclado.keyDown(Keyboard.RIGHT_KEY) && ((this.x + this.width) < tela.getWidth()))
            {
                if (sentido != Constantes.RIGHT)
                {
                    setSequence(5,8);
                    sAnterior = Constantes.RIGHT;
                    sentido = Constantes.RIGHT;
                }
                this.x += 0.5; //VERIFICAR ISSO;
            }
            
            else
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
        if(flag == false)
        {
            if (count <= 149)
            {
                this.y -= 0.5;
                count++;
            }
            if (count >= 150 && count <= 300)
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
    