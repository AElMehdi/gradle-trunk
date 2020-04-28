package com.aelmehdi;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class PdfWriterPdfBoxTest {

   @TempDir
   static File temp;

   @Test
   void should_generate_pdf_file() throws IOException {
      PdfWriterPdfBox.generate(temp.getPath());

      assertThat(new File(temp.getPath() + "/pdfBox.pdf").exists()).isTrue();
   }

   @Test
   void should_get_text_from_an_existing_pdf_file() throws IOException {
      String content = PdfWriterPdfBox.getText("pdfToChange.pdf");

      assertThat(content).contains("camisa");
   }

   @Test
   void should_get_text_from_an_existing_pdf_file_containing_images() throws IOException {
      String content = PdfWriterPdfBox.getText("pdfWithImages.pdf");

      assertThat(content).contains("Fabricant");
   }

   @Test
   @Disabled("Back to it later on")
   void replace_text_in_an_existing_pdf_file() throws IOException {
      String content = PdfWriterPdfBox.findReplace("pdfToChange.pdf", "Fabricant", "CHANGED");

      assertThat(content).contains("CHANGED");
   }
}