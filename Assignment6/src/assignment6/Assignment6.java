/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment6;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.applet.MainFrame;

@SuppressWarnings("deprecation")
public class Assignment6 extends Applet {

    public static void main(String s[]) {
        System.setProperty("sun.awt.noerasebackground", "true");
        new MainFrame(new Assignment6(), 640, 480);
    }

    public void init() {
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D cv = new Canvas3D(gc);
        setLayout(new BorderLayout());
        add(cv, BorderLayout.CENTER);
        BranchGroup bg = createSceneGraph();
        bg.compile();
        SimpleUniverse su = new SimpleUniverse(cv);
        su.getViewingPlatform().setNominalViewingTransform();
        su.addBranchGraph(bg);
    }

    private BranchGroup createSceneGraph() {
        BranchGroup root = new BranchGroup();
        //object
        Appearance ap = new Appearance();
        ap.setMaterial(new Material());
        Font3D font = new Font3D(new Font("SansSerif", Font.PLAIN, 1),
                new FontExtrusion());
        Text3D text = new Text3D(font, "Ezekiel");
        Shape3D shape = new Shape3D(text, ap);

        Text3D text2 = new Text3D(font, "Maynard");
        Shape3D shape2 = new Shape3D(text2, ap);
        //transformation
        Transform3D tr = new Transform3D();
        tr.setScale(0.5);
        tr.setTranslation(new Vector3f(-0.95f, -0.2f, 0f));
        TransformGroup tg = new TransformGroup(tr);
        root.addChild(tg);
        tg.addChild(shape);
/*
        Transform3D tr2 = new Transform3D();
        tr.setScale(0.25);
        tr.setTranslation(new Vector3f(-0.95f, -0.2f, 0f));
        TransformGroup tg2 = new TransformGroup(tr2);
        root.addChild(tg2);
        tg.addChild(shape2);
*/
        //light
        PointLight light = new PointLight(new Color3f(Color.white),
                new Point3f(1f, 1f, 1f),
                new Point3f(1f, 0.1f, 0f));
        BoundingSphere bounds = new BoundingSphere();
        light.setInfluencingBounds(bounds);
        root.addChild(light);

        Background background = new Background(new Color3f(new Color(0, 3, 123, 255)));
        background.setApplicationBounds(bounds);
        root.addChild(background);
        return root;
    }
}
