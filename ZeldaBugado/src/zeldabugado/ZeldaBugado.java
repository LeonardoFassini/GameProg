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
    }

    private void loop()
    {
        new Intro(window, keyboard, mouse);
    }
}
