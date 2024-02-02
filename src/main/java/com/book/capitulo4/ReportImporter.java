package com.book.capitulo4;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import static com.book.capitulo4.Attributes.BODY;
import static com.book.capitulo4.Attributes.PATIENT;
import static com.book.capitulo4.Attributes.TYPE;

class ReportImporter implements Importer {
    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORT");

        // Create a PlainDocument and set the attributes
        PlainDocument document = new PlainDocument();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            document.putProperty(entry.getKey(), entry.getValue());
        }

        return document;
    }
}
