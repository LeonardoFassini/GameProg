package zeldabugado;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Point;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;

public class ZeldaBugado
{

    Window window;
    Mouse mouse;
    Keyboard keyboard;
    BackGround backGround;
    GameImage buttonStart;
    GameImage buttonExit;
    Boneco boneco;

    /**
     *
     */
    public ZeldaBugado()
    {
        carregarObjetos();
        DisplayMode[] d = window.getCompatibleDisplayMode();
        loop();
        window.exit();

    }

    private void carregarObjetos()
    {
        window = new Window(800, 600); // Criar uma janela
        keyboard = window.getKeyboard(); // Inicializar o Keyboard
        keyboard.addKey(KeyEvent.VK_Z, Keyboard.DETECT_INITIAL_PRESS_ONLY); // Adicionar a tecla Z
        mouse = window.getMouse(); //Inicializar o Mouse
        backGround = new BackGround(); // BackGround
        buttonStart = new GameImage("buttonStart.png");
        buttonExit = new GameImage("buttonExit.png");
        //Coordenadas dos botoes do menu001;
        //buttons
        buttonStart.y = (window.getHeight() / 4); // Botão de iniciar
        buttonStart.x = 250.0;
        buttonStart.height = 50;
        buttonStart.width = 341;
        buttonExit.y = (3 * (window.getHeight() / 4)); // Botão de sair
        buttonExit.x = 250.0;
        buttonExit.height = 50;
        buttonExit.width = 341;
    }

    private void loop()
    {
        boolean executing = true;
        int floor = 550;
        while (executing)
        {
            backGround.setBackGround("bgInicio.png");
            backGround.draw();
            buttonStart.draw();
            buttonExit.draw();
            window.update();
            if (mouse.isLeftButtonPressed() == true)
            {
                Point posicao = mouse.getPosition();
                if (mouse.isOverObject(buttonExit))
                {
                    executing = false;
                }
                if (mouse.isOverObject(buttonStart))
                {
                    backGround.setBackGround("bg1.png");
                    boneco = new Boneco(10, 500);
                    boolean gameGoing = true;
                    boolean flag = true;
                    while (gameGoing == true)
                    {

                        backGround.draw();
                        boneco.draw();
                        window.update();
                        boneco.move(window, keyboard);
                        if (keyboard.keyDown(Keyboard.ESCAPE_KEY))    
                        {
                            gameGoing = false;
                        }

                    }
                }
            }
        }
    }
}
