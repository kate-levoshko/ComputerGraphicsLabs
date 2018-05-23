package com;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimationPlane implements ActionListener, KeyListener {
    private Button go;
    private TransformGroup wholedog;
    private Transform3D translateTransform;
    private Transform3D rotateTransformX;
    private Transform3D rotateTransformY;
    private Transform3D rotateTransformZ;

    private JFrame mainFrame;

    private float sign=1.0f;
    private float zoom=1.5f;
    private float xloc=0.5f;
    private float yloc=-1.2f;
    private float zloc=0.0f;
    private int moveType=1;
    private Timer timer;

    public AnimationPlane(TransformGroup wholedog, Transform3D trans, JFrame frame){
        go = new Button("MOVE");
        this.wholedog=wholedog;
        this.translateTransform=trans;
        this.mainFrame=frame;

        rotateTransformX= new Transform3D();
        rotateTransformY= new Transform3D();
        rotateTransformZ= new Transform3D();

        FirstMainClass.canvas.addKeyListener(this);
        timer = new Timer(10, this);

        Panel p =new Panel();
        p.add(go);
        mainFrame.add("North",p);
        go.addActionListener(this);
        go.addKeyListener(this);
    }

    private void initialdogState(){
        sign=1.0f;
        zoom=0.5f;
        xloc=0.5f;
        yloc=-1.2f;
        zloc=0.0f;
        moveType=1;
        rotateTransformY.rotY(-Math.PI/2.8);
        translateTransform.mul(rotateTransformY);
        if(timer.isRunning()){timer.stop();}
        go.setLabel("MOVE");
    }

    public void actionPerformed(ActionEvent e) {
        // start timer when button is pressed
        if (e.getSource()==go){
            if (!timer.isRunning()) {
                timer.start();
                go.setLabel("STOP");
            }
            else {
                timer.stop();
                go.setLabel("MOVE");
            }
        }
        else {
            Move(moveType);
            translateTransform.setScale(new Vector3d(zoom,zoom,zoom));
            translateTransform.setTranslation(new Vector3f(xloc,yloc,zloc));
            wholedog.setTransform(translateTransform);
        }
    }

    private void Move(int mType){
        if(mType==1){ //fly forward and back
            xloc += 0.01 * sign;
            if (Math.abs(xloc *2) >= 1.2 ) {
                sign = -1.0f * sign;
                rotateTransformY.rotY(Math.PI);
                translateTransform.mul(rotateTransformY);
            }
        }
        if(mType==2){ //fly_away
            if(zoom< 0.03){
                initialdogState();
            }
            else{
                xloc += 0.01;
                yloc += 0.01;
                zloc -=0.005;
                zoom -=0.001;
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        //Invoked when a key has been typed.
    }

    public void keyPressed(KeyEvent e) {
        //Invoked when a key has been pressed.
        if (e.getKeyChar()=='s') {xloc = xloc + .05f;}
        if (e.getKeyChar()=='a') {xloc = xloc - .05f;}
        if (e.getKeyChar()=='w') {yloc = yloc + .05f;}
        if (e.getKeyChar()=='z') {yloc = yloc - .05f;}

        if (e.getKeyChar()=='1') {
            rotateTransformX.rotX(Math.PI/2);
            translateTransform.mul(rotateTransformX);
        }
        if (e.getKeyChar()=='2') {
            rotateTransformY.rotY(Math.PI/18);
            translateTransform.mul(rotateTransformY);
        }
        if (e.getKeyChar()=='3') {
            rotateTransformZ.rotZ(Math.PI/2);
            translateTransform.mul(rotateTransformZ);
        }
        if (e.getKeyChar()=='0'){
            rotateTransformY.rotY(Math.PI/2);
            translateTransform.mul(rotateTransformY);
            moveType=2;
        }
    }

    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }

}