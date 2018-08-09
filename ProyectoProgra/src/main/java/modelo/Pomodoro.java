/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.principal.Actividad;
import vista.CronometroPomodoro.FrameCronometro;
/**
 *
 * @author nicolas
 */
public class Pomodoro implements Runnable {
    
    
    
    private Thread hiloCronometro;
    private boolean go,live;
    private final FrameCronometro reloj;
    
    private int segundosActividad;
    private int segundosPomodoro = 1500;
    private int segundosDescanso = 300;
    
    private int pomodoroActividad;
    private int descansosActividad;
    
    private int hr;
    private int min;
    private int seg;
    
    
    private final int duracionPomodoro = 1500;
    private final int duracionDescanzo = 300;
    
    
    private int minutosRestantesPomodoro;
    private int segundosRestantesPomodoro;
    
    private int minutosRestantesDescanso;
    private int segundosRestantesDescanso;
    
    private int rest;

    public Pomodoro(FrameCronometro v, Actividad actividad) {
        reloj = v;
        this.segundosActividad = actividad.getSegundosActividad();
        this.pomodoroActividad = actividad.getCantidadPomodorosHechos();
        this.descansosActividad = actividad.getCantidadDescanzosHechos();
        verificar();
        
    }

    @Override
    public void run() {
        try {
            while (isLive()) { synchronized(this) { while (!isGo()) wait(); }
            
            //verificaFin();
            funcionar();
            
            
            }
        } catch (InterruptedException e) {}
    }

//* MÉTODOS FUNCIONES CRONOMETROS
    
    public void verificar(){
        
        if(this.pomodoroActividad > this.descansosActividad){
            this.segundosDescanso = this.segundosDescanso-(this.segundosActividad%1500);
        }
        if(this.pomodoroActividad == this.descansosActividad) {
            if(this.segundosActividad%1800 == 0){
                this.segundosPomodoro = this.segundosPomodoro-this.segundosActividad;
            }
            this.segundosPomodoro = this.segundosPomodoro-(this.segundosActividad%1800);
        }
        
        
    }
    
    public void funcionar() throws InterruptedException{
        lanzarEspera();
        segundosActividad++;
        segundosPomodoro--;
        segundosDescanso--;
        actualizarThread();
    }
    
    public void lanzarEspera() throws InterruptedException{
        Thread.sleep(1000);
    }
    
    
    private void lanzarDescanzo() throws InterruptedException {
        for (int i = 0; i <=this.duracionDescanzo; i++) {
                        Thread.sleep(1000);
                        this.rest--;
                        segundosActividad++;
                        actualizarThread();
                    }
    }

    private void actualizarThread() {
        if (isLive() == true) {
            this.hr= segundosActividad/3600;
            this.min =(segundosActividad-hr*3600)/60;
            this.seg = segundosActividad-hr*3600-min*60;
            
            if(this.pomodoroActividad > this.descansosActividad) {
                System.out.println("HAY MAS POMODOROS");
                this.minutosRestantesDescanso = segundosDescanso/60;
                this.segundosRestantesDescanso = segundosDescanso%60;
                if(this.segundosDescanso == 0){
                    this.descansosActividad++;
                    this.segundosDescanso = 300;
                }
                
            }
            
            if (this.pomodoroActividad == this.descansosActividad) {
                System.out.println("hay misma cantidad");
                this.minutosRestantesPomodoro = segundosPomodoro/60;
                this.segundosRestantesPomodoro = segundosPomodoro%60;
                if(this.segundosPomodoro == 0){
                    this.pomodoroActividad++;
                    this.segundosPomodoro = 1500;
                }
            }
            
            
            
            reloj.getDisplayPrimario().setText(""+hr+" : "+min+" : "+seg);
            reloj.displayPanelIzquierdoSuperior().setText(""+pomodoroActividad);
            reloj.displayPanelIzquierdoInferior().setText(""+descansosActividad);
            reloj.displayPanelDerechoSuperior().setText(""+minutosRestantesPomodoro+" : "+segundosRestantesPomodoro);
            reloj.displayPanelDerechoInferior().setText(""+minutosRestantesDescanso+" : "+segundosRestantesDescanso);
            
        } else {
            segundosActividad = 0;
            reloj.getDisplayPrimario().setText("0 : 0 : 0");
        }
    }

    private void finRutina(){
        System.out.println("FIN RUTINA");
        reloj.botonStart.setEnabled(true);
        reloj.botonStop.setEnabled(false);
        reloj.botonPause.setEnabled(false);
        setLive(false);
        setGo(false);
        setSegundos(0);
    }
    
    public void createThread() {
        hiloCronometro = new Thread(this);
        hiloCronometro.start();
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
        return segundosActividad;
    }
    
    public void setSegundos(int segundos) {
        this.segundosActividad = segundos;
    }

    public int getHr() {
        this.hr= segundosActividad/3600;
        return hr;
    }

    public int getMin() {
        this.min =(segundosActividad-hr*3600)/60;
        return min;
    }

    public int getSeg() {
        this.seg = segundosActividad-hr*3600-min*60;
        return seg;
    }
    
    
    public int getMinPomodoro() {
        this.minutosRestantesPomodoro = segundosPomodoro/60;
        return minutosRestantesPomodoro;
    }

    public int getSegPomodoro() {
        this.segundosRestantesPomodoro = segundosPomodoro%60;
        return segundosRestantesPomodoro;
    }
    
    public int getMinDescanso() {
        this.minutosRestantesDescanso = segundosDescanso/60;
        return minutosRestantesDescanso;
    }

    public int getSegDescanso() {
        this.segundosRestantesDescanso = segundosDescanso%60;
        return segundosRestantesDescanso;
    }

   
}