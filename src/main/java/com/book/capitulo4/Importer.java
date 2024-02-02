package com.book.capitulo4;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;

public interface Importer {
    Document importFile(File file) throws IOException;
}
