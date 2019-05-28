/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cylinderarm;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.*;
import javax.swing.*;
import java.awt.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.media.j3d.Transform3D;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
//#ifdef __HAS_NIO__
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
//#endif
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.vecmath.Matrix4d;
import javax.vecmath.Vector3d;


/**
 *
 * @author Asus
 */public class CylinderArm extends JFrame implements KeyListener{
    TransformGroup obrot_animacja = new TransformGroup();
    TransformGroup obrot_animacja2 = new TransformGroup();
    TransformGroup obrot_animacja3 = new TransformGroup();
    private ColoringAttributes WHITE;
    private Matrix4d matrix = new Matrix4d();
    float x1 , x2 , y1 , y2 , z1 , z2;
  
        
        CylinderArm(){
        super("Moje Nieudolne Cylindryczne Ramie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        canvas3D.setPreferredSize(new Dimension(800,600));
        add(canvas3D);
        pack();
        setVisible(true);
        BranchGroup scena = utworzScene();
	scena.compile();
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        Transform3D przesuniecie_obserwatora = new Transform3D();
        przesuniecie_obserwatora.set(new Vector3f(0.0f,0.0f,2.75f));
        simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(przesuniecie_obserwatora);
        simpleU.addBranchGraph(scena);
 }
        BranchGroup utworzScene(){
        BranchGroup wezel_scena = new BranchGroup();
            
        
         //==============================
        
        
        obrot_animacja.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        wezel_scena.addChild(obrot_animacja);  
        wezel_scena.addChild(obrot_animacja2);  
        wezel_scena.addChild(obrot_animacja3);  
        
        

            //=============================
        
            Appearance  wygladChwytak = new Appearance();
            wygladChwytak.setColoringAttributes(new ColoringAttributes(0.0f,0.0f,0.9f,ColoringAttributes.NICEST));
            Cylinder chwytak = new Cylinder(0.03f, 0.5f,Cylinder.GENERATE_TEXTURE_COORDS , wygladChwytak);
            
            Appearance  wygladWinda = new Appearance();
            wygladWinda.setColoringAttributes(new ColoringAttributes(0.0f,0.0f,0.9f,ColoringAttributes.NICEST));
            Cylinder winda = new Cylinder(0.1f, 0.25f,Cylinder.GENERATE_TEXTURE_COORDS , wygladWinda);
           
          //==============================
            
            x1=0;
            x2=0;
            y1=0;
            y2=0;
            z1=0;
            z2=0;
            
            
            
            //==============================
            
            final Transform3D  p_chwytak   = new Transform3D();
            p_chwytak.set(new Vector3f(-0.25f,0.0f,0.0f));
            
            final Transform3D  p_winda   = new Transform3D();
            p_winda.set(new Vector3f(0.0f,0.0f,0.0f));
            
            final Transform3D  p_podstawa   = new Transform3D();
            p_podstawa.set(new Vector3f(0.0f,0.0f,0.0f));
           
            //==============================
            
            
            final Transform3D tmp_rot = new Transform3D();
            final Transform3D tmp_rot2 = new Transform3D();
            final Transform3D tmp_rot3 = new Transform3D();
            //============================

            this.addKeyListener(new KeyListener(){
     
public void keyPressed(KeyEvent e)
    {
      
    }
    
    public void keyReleased(KeyEvent e)
    {
       
    }
     
    public void keyTyped(KeyEvent e)
    {
        
        char key = e.getKeyChar();
        
        if (key == 's')
       {
            x1-=0.01f;
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
            obrot_animacja.setTransform(p_chwytak);
            
        }
        if (key == 'f')
       {
           x1+=0.01f;
           p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
           obrot_animacja.setTransform(p_chwytak);
        }
       
        if (key == 'e')
       {
            y1+=0.01f;
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
            obrot_animacja.setTransform(p_chwytak);}
            if (key == 'e')
       {
            y2+=0.01f;
            p_winda.setTranslation(new Vector3d(x2,y2,z2));
            obrot_animacja3.setTransform(p_winda);
        }
         if (key == 'd')
         {
            y1-=0.01f;
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
            obrot_animacja.setTransform(p_chwytak);}
         if (key == 'd')
         {
            y2-=0.01f;
            p_winda.setTranslation(new Vector3d(x2,y2,z2));
            obrot_animacja3.setTransform(p_winda);
        }
         if (key == 'w')
        {
            tmp_rot.rotY(-Math.PI/16);
            p_chwytak.get(matrix);
            p_chwytak.mul(tmp_rot);
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
            obrot_animacja.setTransform(p_chwytak);}
           if (key == 'w')
        {
             tmp_rot3.rotY(-Math.PI/16);
            p_winda.get(matrix);
            p_winda.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_winda.mul(tmp_rot3);
            p_winda.setTranslation(new Vector3d(x2,y2,z2));
            obrot_animacja3.setTransform(p_winda);
        }
         if (key == 'r')
        {            
            tmp_rot.rotY(Math.PI/16);
            p_chwytak.get(matrix);
            p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_chwytak.mul(tmp_rot);
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));
            obrot_animacja.setTransform(p_chwytak);
        }
          if (key == 'r')
        {
            tmp_rot3.rotY(Math.PI/16);
            p_winda.get(matrix);
            p_winda.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_winda.mul(tmp_rot3);
            p_winda.setTranslation(new Vector3d(x2,y2,z2));
            obrot_animacja3.setTransform(p_winda);         
        }   
    }
     
            }
            );
                   
            
            p_chwytak.set(new Vector3d(0.0f,0.0f,0.0f));
            p_winda.set(new Vector3d(0.0f,0.0f,0.0f));
            
            tmp_rot.rotZ(Math.PI/2);
            tmp_rot3.rotZ(Math.PI/2);
           
            p_chwytak.mul(tmp_rot);
            p_winda.mul(tmp_rot3);
             
            TransformGroup transformacja_winda = new TransformGroup(p_winda);
            TransformGroup transformacja_chwytak = new TransformGroup(p_chwytak);
            
            transformacja_chwytak.addChild(chwytak);
            transformacja_winda.addChild(winda);
            
            obrot_animacja.addChild(transformacja_chwytak);
            obrot_animacja3.addChild(transformacja_winda);
             
           
           //=================================
           Appearance  wygladPodstawa = new Appearance();
           wygladPodstawa.setColoringAttributes(new ColoringAttributes(0.2f,0.9f,0.6f,ColoringAttributes.NICEST));
           Cylinder podstawa = new Cylinder(0.1f,0.5f, wygladPodstawa);

           p_podstawa.set(new Vector3f(0.0f,0.0f,0.0f));
           p_podstawa.mul(tmp_rot2);

           TransformGroup transformacja_podstawa = new TransformGroup(p_podstawa);

           transformacja_podstawa.addChild(podstawa);
            
           obrot_animacja2.addChild(transformacja_podstawa);
            
            //==============================
       
           tmp_rot.rotZ(Math.PI/2);
           p_chwytak.mul(tmp_rot);
           p_winda.mul(tmp_rot);
            
           return wezel_scena;
        }

    
    public static void main(String[] args) {
    CylinderArm CylinderArm= new CylinderArm(); 
    
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
    

