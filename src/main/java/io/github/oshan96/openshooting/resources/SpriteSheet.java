package io.github.oshan96.openshooting.resources;

import com.jogamp.opengl.util.texture.Texture;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oshan
 */
public class SpriteSheet {
    private static SpriteSheet spriteSheet = null;
    private BufferedImage image = null;
    private ImageResource imageResource = null;

    private SpriteSheet() {
        imageResource = new ImageResource();
    }

    public static SpriteSheet getInstance() {
        if(spriteSheet == null)
            spriteSheet = new SpriteSheet();

        return spriteSheet;
    }

    public SpriteSheet loadSpriteSheet(String path) {
        imageResource.setImage(path);
        image = imageResource.getImage();
        return this;
    }

    public List<Texture> getSprites(int spriteHeight, int spriteWidth ) {
        List<Texture> images = new ArrayList<>();
        int rows = 6;
        int cols = 18;

        System.out.println("rows : "+rows);
        System.out.println("cols : "+cols);

        int x=0, y=0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                BufferedImage image1 = image.getSubimage(x,y,spriteWidth,spriteHeight);
                imageResource.setImage(image1);
                images.add(imageResource.getTexture());
                x+=spriteWidth;
            }
            x=0;
            y+=spriteHeight;
        }


        return images;
    }
}
