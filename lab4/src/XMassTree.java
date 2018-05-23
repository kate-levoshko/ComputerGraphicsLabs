import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.vecmath.Color3f;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;

public class XMassTree {
    public static Box getCone(float height, float radius) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.28f, 0.65f, 0.08f, getXMassTreeAppearence());
    }
    private static Appearance getXMassTreeAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(0.1f, 0.1f, 0.1f);
        Color3f ambient = new Color3f(0.1f, 0.1f, 0.1f);
        Color3f diffuse = new Color3f(0.1f, 0.1f, .01f);
        Color3f specular = new Color3f(0.1f, 0.1f, 0.1f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}