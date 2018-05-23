import java.awt.Container;
import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;


public class XMassBall {
    public static Box getSphere(float radius, String picture, Color3f emissiveColor) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.06f, 0.04f, 0.02f, getXMassBallsAppearence(emissiveColor));
    }

    private static Appearance getXMassBallsAppearence(Color3f emissive) {
        Appearance ap = new Appearance();
        Color3f ambient = new Color3f(0.2f, 0.15f, .15f);
        Color3f diffuse = new Color3f(1.2f, 1.15f, .15f);
        Color3f specular = new Color3f(0.0f, 0.0f, 0.0f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}