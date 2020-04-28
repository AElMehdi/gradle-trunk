package com.aelmehdi;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfWriterPdfBox {


   private static final String PDF_FILE_NAME = "/pdfBox.pdf";

   public static void generate(String dest) throws IOException {
      PDDocument pdDocument = new PDDocument();

      pdDocument.save(dest + PDF_FILE_NAME);

      PDPage pdPage = new PDPage();
      pdDocument.addPage(pdPage);

      pdDocument.close();
   }

   public static String load(String path) throws IOException {
      URL pdfFile = PdfWriterPdfBox.class.getClassLoader().getResource(path);

      PDDocument pdfDocument = PDDocument.load(new File(pdfFile.getPath()));

      PDFTextStripper pdfTextStripper = new PDFTextStripper();

      return pdfTextStripper.getText(pdfDocument);
   }
}
