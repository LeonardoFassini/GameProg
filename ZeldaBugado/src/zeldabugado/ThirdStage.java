/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeldabugado;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;

/**
 *
 * @author Leonardo
 */
public class ThirdStage
{

    Boneco boneco;
    Dino dino;
    boolean gameGoing;
    int floor;

    public ThirdStage(BackGround backGround, Window window, Keyboard keyboard, Mouse mouse)
    {
        carregarObjetos(backGround);
        loop(backGround, window, keyboard, mouse);

    }

    public void carregarObjetos(BackGround backGround)
    {
        backGround.setBackGround("bg3.png");
        boneco = new Boneco(10, 500);
        gameGoing = true;
        boolean flag = true;
        floor = 550;
        dino = new Dino(750, 500, boneco);
        dino.setDinoDiff(2);
    }

    public void loop(BackGround backGround, Window window, Keyboard keyboard, Mouse mouse)
    {
        while (gameGoing == true)
        {

            backGround.draw();
            boneco.draw();
            dino.draw();
            window.update();
            boneco.move(window, keyboard);
            boneco.verifyFloor(boneco, window, -1, -1, floor);
            dino.move(boneco, window);
            if (boneco.busted(dino) == 0)
            {
            } else
            {
                if (boneco.busted(dino) == 1)
                {
                    dino.matarDino();
                } else
                {
                    boneco.matarBoneco();
                }
            }
            if (keyboard.keyDown(Keyboard.ESCAPE_KEY))
            {
                gameGoing = false;
            }
            if (boneco.getAlive() == false)
            {
                backGround.setBackGround("youDied.png");
                backGround.draw();
                window.update();
                while (!keyboard.keyDown(Keyboard.ENTER_KEY))
                {
                }
                gameGoing = false;
            }
            if (boneco.x + boneco.width > 798)
            {
                new SecondStage(backGround, window, keyboard, mouse);
                gameGoing = false;
            }
        }
    }
}
