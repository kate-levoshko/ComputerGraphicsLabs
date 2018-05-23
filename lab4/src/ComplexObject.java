import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

public class ComplexObject implements ActionListener {
    private TransformGroup treeTransformGroup;
    private Transform3D treeTransform3D = new Transform3D();
    private Timer timer;
    private float angle = 0;
    public static void main(String[] args) {
        new ComplexObject();
    }

    public ComplexObject() {
        timer = new Timer(150, this);
        timer.start();
        BranchGroup scene = createSceneGraph();

        GraphicsConfiguration config = SimpleUniverse
                .getPreferredConfiguration();
        SimpleUniverse u = new SimpleUniverse();
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);
    }
    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        treeTransformGroup = new TransformGroup();
        treeTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        buildTree();
        objRoot.addChild(treeTransformGroup);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color,
                light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void buildTree() {
        TransformGroup tgTop = new TransformGroup();
        Transform3D transformTop = new Transform3D();
        Box coneTop = XMassTree.getCone(0.3f, 0.2f);
        Vector3f vectorTop = new Vector3f(.0f, .0f, .0f);
        transformTop.setTranslation(vectorTop);
        tgTop.setTransform(transformTop);
        tgTop.addChild(coneTop);
        treeTransformGroup.addChild(tgTop);

        for (int i = 0; i < 4; i++) {
            float y = -0.16f - 0.125f * i;
            createBall(0.03f, -0.15f, y, 0.08f, "", new Color3f(0.0f, 0.0f, 0.1f));
            createBall(0.03f, 0.01f, y, 0.08f, "", new Color3f(0.0f, 0.0f, 0.1f));
            createBall(0.03f, 0.17f, y, 0.08f, "", new Color3f(0.0f, 0.0f, 0.1f));
        }

        createScreen(0.01f, 0.25f, 0.08f, new Color3f(0.0f, 0.0f, 1.0f));
    }

    private void createBall(float radius, float x, float y, float z, String picture,
                            Color3f emissive) {
        initFigure(XMassBall.getSphere(radius, picture, emissive), x, y, z);
    }

    private void createScreen(float x, float y, float z, Color3f emissive) {
        initFigure(Screen.getFigure(emissive), x, y, z);
    }

    private void initFigure(Primitive figure, float x, float y, float z) {
        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        Vector3f vector = new Vector3f(x, y, z);
        transform.setTranslation(vector);
        tg.setTransform(transform);
        tg.addChild(figure);
        treeTransformGroup.addChild(tg);
    }

    public void actionPerformed(ActionEvent e) {
        treeTransform3D.rotY(angle);
        treeTransformGroup.setTransform(treeTransform3D);
        angle += 0.5;
    }
}