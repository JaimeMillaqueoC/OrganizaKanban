/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.CronometroPomodoro.frameCronometro;

/**
 *
 * @author nicolas
 */
public class Pomodoro implements Runnable {
    private Thread hiloCronometro;
    private boolean go,live;
    private int segundos;
    private frameCronometro reloj;

    public Pomodoro(frameCronometro v) {
        reloj = v;
    }

    public void run() {
        try {
            while (isLive()) {
                synchronized(this) {
                    while (!isGo())
                        wait();
                }
                Thread.sleep(1000);
                segundos++;
                actualizarThread();
            }
        } catch (InterruptedException e) {}
    }

    public void createThread() {
        hiloCronometro = new Thread(this);
        hiloCronometro.start();
    }

    private void actualizarThread() {
        if (isLive() == true) {
            int hr= segundos/3600;
            int min =(segundos-hr*3600)/60;
            int seg = segundos-hr*3600-min*60;
            reloj.getDisplay().setText(""+hr+" : "+min+" : "+seg);
        } else {
            segundos = 0;
            reloj.getDisplay().setText("0 : 0 : 0");
        }
    }

    public void suspenderThread() {
        setGo(false);
    }

    public synchronized void continuarThread() {
        setGo(true);
        notify();
    }

    //* MÉTODOS SET Y GET DE LAS VARIABLES DE TIPO BOOLEAN e INT

    public boolean isLive() {
        return live;
    }
    
    public void setLive(boolean live) {
        this.live = live;
    }
    
    public boolean isGo() {
        return go;
    }
    
    public void setGo(boolean go) {
        this.go = go;
    }
    
    public int getSegundos() {
        return segundos;
    }
    
    public void setSegundos(int segundos) {
        this.segundos = segundos;
        System.out.println("Valor de SEgundos:" + this.segundos);
    }
}