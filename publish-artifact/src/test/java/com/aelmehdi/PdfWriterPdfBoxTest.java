package com.aelmehdi;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class PdfWriterPdfBoxTest {

   @TempDir
   static File temp;

   @Test
   void should_generate_pdf_file() {
      PdfWriterPdfBox.generate(temp.getPath());

      String pdfContent = readPdf(temp.getPath());

      assertThat(pdfContent).contains("Hello PDF");
   }

   private String readPdf(String path) {
      throw new UnsupportedOperationException();
   }
}