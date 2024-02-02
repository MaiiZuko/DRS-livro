package com.book.capitulo4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// tag::image_importer[]
import static com.book.capitulo4.Attributes.*;

class ImageImporter implements Importer {
    @Override
    public javax.swing.text.Document importFile(final File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "IMAGE");

        // Create a PlainDocument and set the attributes
        javax.swing.text.PlainDocument document = new javax.swing.text.PlainDocument();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            document.putProperty(entry.getKey(), entry.getValue());
        }

        return document;
    }
}