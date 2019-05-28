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
    private ColoringAttributes WHITE;
    private Matrix4d matrix = new Matrix4d();
  
        
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
        BoundingSphere Wiezy = new BoundingSphere();
        AmbientLight Swiatlo = new AmbientLight();
        Swiatlo.setInfluencingBounds(Wiezy);
        wezel_scena.addChild(Swiatlo);
        
        
        
         //==============================
        
        final TransformGroup obrot_animacja = new TransformGroup();
         final TransformGroup obrot_animacja2 = new TransformGroup();
         final TransformGroup obrot_animacja3 = new TransformGroup();
        obrot_animacja.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        wezel_scena.addChild(obrot_animacja);  
        wezel_scena.addChild(obrot_animacja2);  
         wezel_scena.addChild(obrot_animacja3);  
        
        

            //=============================
        
            Appearance  wygladRamie = new Appearance();
            wygladRamie.setColoringAttributes(new ColoringAttributes(0.0f,0.0f,0.9f,ColoringAttributes.NICEST));
            Cylinder ramie = new Cylinder(0.1f, 0.5f,Cylinder.GENERATE_TEXTURE_COORDS , wygladRamie);
           
          
            //==============================
            final Transform3D  p_ramie   = new Transform3D();
            p_ramie.set(new Vector3f(0.0f,0.0f,0.0f));
            
            final Transform3D tmp_rot = new Transform3D();
            
            //==============================
            final Transform3D  p_stozek   = new Transform3D();
            p_stozek.set(new Vector3f(0.0f,0.0f,0.0f));
            final Transform3D tmp_rot2 = new Transform3D();
             final Transform3D tmp_rot3 = new Transform3D();
            //============================
            final Transform3D  p_stozka   = new Transform3D();
            //============================
            
           
           // p_ramie.setTranslation(new Vector3d(0.25f,0.0f,0.0f));
           // p_ramie.mul(tmp_rot3);
            //obrot_animacja.setTransform(p_ramie);
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
           
          
            
          
           
            p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
          
            p_ramie.setTranslation(new Vector3d(matrix.m03-0.01f,matrix.m13,matrix.m23));
              obrot_animacja.setTransform(p_ramie);
            
        }
        if (key == 'f')
       {
           
          
            
           
            p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
           
            p_ramie.setTranslation(new Vector3d(matrix.m03+0.01f,matrix.m13,matrix.m23));
            obrot_animacja.setTransform(p_ramie);
        }
       
        if (key == 'e')
       {
           
          
            
             p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
           
            p_ramie.setTranslation(new Vector3d(matrix.m03,matrix.m13+0.01f,matrix.m23));
            obrot_animacja.setTransform(p_ramie);
        }
         if (key == 'd')
         {
           
          
            
           
           p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
           
            p_ramie.setTranslation(new Vector3d(matrix.m03,matrix.m13-0.01f,matrix.m23));
            obrot_animacja.setTransform(p_ramie);
        }
         if (key == 'w')
        {
           
          
            
            tmp_rot.rotY(-Math.PI/16);
            p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
            p_ramie.mul(tmp_rot);
            p_ramie.setTranslation(new Vector3d(matrix.m03,matrix.m13,matrix.m23));
            obrot_animacja.setTransform(p_ramie);
        }
         if (key == 'r')
        {
           
          
            
            tmp_rot.rotY(Math.PI/16);
            p_ramie.get(matrix);
            p_ramie.setTranslation(new Vector3d(0.25f,0.15f,0.0f));
            p_ramie.mul(tmp_rot);
            p_ramie.setTranslation(new Vector3d(matrix.m03,matrix.m13,matrix.m23));
            
            obrot_animacja.setTransform(p_ramie);
        }
        
    }
     
            }
            );
                   
            //p_ramie.mul(tmp_rot);
            p_ramie.set(new Vector3d(0.25f,0.15f,0.0f));
             tmp_rot.rotZ(Math.PI/2);
           
           p_ramie.mul(tmp_rot);
            
             
             
              TransformGroup transformacja_ramienia = new TransformGroup(p_ramie);
            transformacja_ramienia.addChild(ramie);
            obrot_animacja.addChild(transformacja_ramienia);
            
           
           //=================================
           Appearance  wygladStozka = new Appearance();
           
           //====================
           //Texture Teksturatrawnik = new TextureLoader("obrazki/trawka.gif", this).getTexture();
           // wygladStozka.setTexture(Teksturatrawnik);
           
           
           
      wygladStozka.setColoringAttributes(new ColoringAttributes(0.2f,0.9f,0.6f,ColoringAttributes.NICEST));

      Cylinder stozek = new Cylinder(0.1f,0.5f, wygladStozka);

      
      p_stozka.set(new Vector3f(0.0f,0.0f,0.0f));

     
      
      p_stozka.mul(tmp_rot2);

      TransformGroup transformacja_sto = new TransformGroup(p_stozka);

      transformacja_sto.addChild(stozek);
      obrot_animacja2.addChild(transformacja_sto);
            
            //==============================
       //p_ramie.set(new Vector3d(0.0f,0.0f,0.0f));
              tmp_rot.rotZ(Math.PI/2);
           p_ramie.mul(tmp_rot);
            
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
    

