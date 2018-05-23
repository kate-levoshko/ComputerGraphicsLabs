import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Primitive;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;


public class Screen {
    public static Box getFigure(Color3f emissiveColor) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.22f, 0.3f, 0.01f, getScreenAppearence(emissiveColor));
    }

    private static Appearance getScreenAppearence(Color3f emissive) {
        Appearance ap = new Appearance();
        Color3f ambient = new Color3f(0.21f, 0.15f, .15f);
        Color3f diffuse = new Color3f(1.2f, 1.15f, .15f);
        Color3f specular = new Color3f(0.0f, 0.0f, 0.0f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}
