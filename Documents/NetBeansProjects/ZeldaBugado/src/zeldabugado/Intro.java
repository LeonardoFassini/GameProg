/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeldabugado;

import java.awt.Point;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;

/**
 *
 * @author Leonardo
 */
public class Intro
{
    // Declaracao das variaveis que vou usar nessa cena
    BackGround backGround;
    GameImage buttonStart;
    GameImage buttonExit;
    
    public Intro(Window window, Keyboard keyboard, Mouse mouse)
    {
        carregarObjetos(window);
        loop(window, keyboard, mouse);
    }

    void carregarObjetos(Window window)
    {
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
    
    void loop(Window window, Keyboard keyboard, Mouse mouse)
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
                    new FirstScene(backGround, window, keyboard, mouse);
                }
            }
        }
    }
}
