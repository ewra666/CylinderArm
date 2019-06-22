/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cylinderarm;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
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
import static java.lang.Math.cos;
import static java.lang.Math.sin;
//#ifdef __HAS_NIO__
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
//#endif
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.vecmath.Matrix4d;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.geometry.Box;


/**
 *
 * @author Asus
 */public class CylinderArm extends JFrame implements KeyListener{
    TransformGroup obrot_animacja = new TransformGroup();
    TransformGroup obrot_animacja2 = new TransformGroup();
    TransformGroup obrot_animacja3 = new TransformGroup();
    private ColoringAttributes BLACK;
    private Matrix4d matrix = new Matrix4d();
    float x1 , x2 , y1 , y2 , z1 , z2;
    
 
     private float kat=0.0f;
        private float kx=0.0f;
        private Matrix4d macierz = new Matrix4d();
        private Matrix4d macierz2 = new Matrix4d();
    
  
        
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
        OrbitBehavior orbit = new OrbitBehavior(canvas3D, OrbitBehavior.REVERSE_ROTATE);
        orbit.setSchedulingBounds(new BoundingSphere());
        simpleU.getViewingPlatform().setViewPlatformBehavior(orbit);
        simpleU.addBranchGraph(scena);
 }
        BranchGroup utworzScene(){
        BranchGroup wezel_scena = new BranchGroup();
         x1=0.1f;
        
        //==============================
        BoundingSphere Wiezy = new BoundingSphere();
        AmbientLight Swiatlo = new AmbientLight();
        Swiatlo.setInfluencingBounds(Wiezy);
        wezel_scena.addChild(Swiatlo);
        //==============================
        Texture TeksturaMur = new TextureLoader("obrazki/trawka.jpg", this).getTexture();
        Appearance WygladMur = new Appearance();
        WygladMur.setTexture(TeksturaMur);
         //==============================
        Texture TeksturaBrick = new TextureLoader("obrazki/brick.jpg", this).getTexture();
        Appearance WygladBrick = new Appearance();
        WygladBrick.setTexture(TeksturaBrick);
         //==============================
        Texture TeksturaTrawka = new TextureLoader("obrazki/trawka.jpg", this).getTexture();
        Appearance WygladTrawka = new Appearance();
        WygladTrawka.setTexture(TeksturaTrawka);
         //==============================
        
        
        obrot_animacja.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        obrot_animacja3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        wezel_scena.addChild(obrot_animacja);  
        wezel_scena.addChild(obrot_animacja2);  
        wezel_scena.addChild(obrot_animacja3);  
        
        
            //=============================
        

            //==============================
        
            Appearance  wygladChwytak = new Appearance();
            wygladChwytak.setColoringAttributes(new ColoringAttributes(80.0f,80.0f,80.0f,ColoringAttributes.NICEST));
            Box chwytak = new Box(0.2f, 0.03f,0.03f,Box.GENERATE_TEXTURE_COORDS , WygladBrick);
            
            Appearance  wygladnaped = new Appearance();
            wygladnaped.setColoringAttributes(new ColoringAttributes(0.0f,0.0f,0.9f,ColoringAttributes.NICEST));
            Box naped = new Box(0.13f, 0.1f,0.1f,Cylinder.GENERATE_TEXTURE_COORDS,wygladnaped);
           
          //==============================
         
            
           
         
            
            
            //==============================
            
            final Transform3D  p_chwytak   = new Transform3D();
            p_chwytak.set(new Vector3f(0.1f,0.0f,0.0f));
            p_chwytak.setTranslation(new Vector3d(x1,y1,z1));  
            obrot_animacja.setTransform(p_chwytak);
          
            //==============================
           final Transform3D  p_naped   = new Transform3D();
            p_naped.set(new Vector3f(0.0f,0.0f,0.0f));
            p_naped.setTranslation(new Vector3d(x1,y1,z1));  
            obrot_animacja2.setTransform(p_naped);
          
            //==============================
            
            
            final Transform3D  p_podstawa   = new Transform3D();
            p_podstawa.set(new Vector3f(0.0f,0.0f,0.0f));
           
            //==============================
            
            
            final Transform3D tmp_rot = new Transform3D();
            
            //============================
              
            
           
           
           //==============================
         

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
        
        if (key == 'a')
       {
           if(x1>-0.08f)
           {x1-=0.01f;
            p_chwytak.get(macierz);
            macierz2.m03=x1;
              p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
       
        p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja.setTransform(p_chwytak);
           }
        }
        if (key == 'd')
       {
           if(x1<0.4f)
           {x1+=0.01f;
           p_chwytak.get(macierz);
            macierz2.m03=x1;
              p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
       
        p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja.setTransform(p_chwytak);
           }
        }
       
        if (key == 'w')
       {
           if(y1<0.15f)
           {y1+=0.01f;
            p_chwytak.get(macierz);
            macierz2.m13=y1;
            p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja.setTransform(p_chwytak);
            
            
            p_naped.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_naped.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja2.setTransform(p_naped);
            
            
           }
       }
       
         if (key == 's')
         {
            if(y1>-0.15f)
            {y1-=0.01f;
            p_chwytak.get(macierz);
            macierz2.m13=y1;
              p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
       
        p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja.setTransform(p_chwytak);
            
           
            p_naped.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
            p_naped.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
            obrot_animacja2.setTransform(p_naped);
            
                   }
         }
   
         if (key == 'q')
        {
            kat=(float) (Math.PI/32);
        kx=(float) (kx+Math.PI/32);
        tmp_rot.rotY(Math.PI/32);
        
        p_chwytak.get(macierz);         // obrot ramieniem chwytaka
        macierz2.m03=macierz.m03*cos(kat)+macierz.m23*sin(kat);
        macierz2.m13=y1;
        macierz2.m23=-macierz.m03*sin(kat)+macierz.m23*cos(kat);
        p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        p_chwytak.mul(tmp_rot);
        p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
        obrot_animacja.setTransform(p_chwytak);
        
         p_naped.get(macierz);         // obrot ramieniem chwytaka
        macierz2.m03=macierz.m03*cos(kat)+macierz.m23*sin(kat);
        macierz2.m13=y1;
        macierz2.m23=-macierz.m03*sin(kat)+macierz.m23*cos(kat);
        p_naped.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        p_naped.mul(tmp_rot);
        p_naped.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
        obrot_animacja2.setTransform(p_naped);
        
        
        
        }
        
         if (key == 'e')
        {            
              kat=(float) (-Math.PI/32);
        kx=(float) (kx+Math.PI/32);
        tmp_rot.rotY(-Math.PI/32);
        
        p_chwytak.get(macierz);         // obrot ramieniem chwytaka
        macierz2.m03=macierz.m03*cos(kat)+macierz.m23*sin(kat);
        macierz2.m13=y1;
        macierz2.m23=-macierz.m03*sin(kat)+macierz.m23*cos(kat);
        p_chwytak.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        p_chwytak.mul(tmp_rot);
        p_chwytak.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
        obrot_animacja.setTransform(p_chwytak);
        
        
        p_naped.get(macierz);         // obrot ramieniem chwytaka
        macierz2.m03=macierz.m03*cos(kat)+macierz.m23*sin(kat);
        macierz2.m13=y1;
        macierz2.m23=-macierz.m03*sin(kat)+macierz.m23*cos(kat);
        p_naped.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        p_naped.mul(tmp_rot);
        p_naped.setTranslation(new Vector3d(macierz2.m03,macierz2.m13,macierz2.m23));
        obrot_animacja2.setTransform(p_naped);
        } 
           
         
        
    }
     
            }
            );
                   
            
            
            
          
            TransformGroup transformacja_chwytak = new TransformGroup(p_chwytak);
           TransformGroup transformacja_naped = new TransformGroup(p_naped);
            
            transformacja_chwytak.addChild(chwytak);
           transformacja_naped.addChild(naped);
          
            obrot_animacja.addChild(transformacja_chwytak);
          obrot_animacja2.addChild(transformacja_naped);
            
             
           
           //=================================
           Appearance  wygladPodstawa = new Appearance();
           wygladPodstawa.setColoringAttributes(new ColoringAttributes(0.2f,0.9f,0.6f,ColoringAttributes.NICEST));
           Cylinder podstawa = new Cylinder(0.1f,0.5f, Cylinder.GENERATE_TEXTURE_COORDS,WygladTrawka);

           p_podstawa.set(new Vector3f(0.0f,0.0f,0.0f));
         

           TransformGroup transformacja_podstawa = new TransformGroup(p_podstawa);

           transformacja_podstawa.addChild(podstawa);
            
           obrot_animacja3.addChild(transformacja_podstawa);
            
            //==============================
          
       
          
            
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
    

