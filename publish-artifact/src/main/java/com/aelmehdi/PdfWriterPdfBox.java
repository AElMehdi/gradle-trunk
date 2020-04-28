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

   public static String getText(String path) throws IOException {
      PDDocument pdfDocument = load(path);

      PDFTextStripper pdfTextStripper = new PDFTextStripper();

      return pdfTextStripper.getText(pdfDocument);
   }

   public static String findReplace(String path, String oldText, String newText) throws IOException {
      // TODO EA: It's hard to find and replace text this way
      // https://stackoverflow.com/questions/53114578/why-squares-shown-instead-of-symbols-in-output-file-using-pdfbox
      //PDDocument document = load(path);
      //
      //PDPage page = document.getPage(0);
      //InputStream contents = page.getContents();
      //
      //PDFStreamParser pdfStreamParser = new PDFStreamParser(contents.readAllBytes());
      //pdfStreamParser.parse();
      //
      //List<Object> tokens = pdfStreamParser.getTokens();
      //
      //for (int i = 0; i < tokens.size(); i++) {
      //   Object current = tokens.get(i);
      //
      //   if (current instanceof Operator) {
      //      Operator operator = (Operator) current;
      //
      //      String operatorName = operator.getName();
      //
      //      if (operatorName.equals("TJ")) {
      //         COSArray previous = (COSArray) tokens.get(i - 1);
      //
      //         Iterator<COSBase> iterator = previous.iterator();
      //         while (iterator.hasNext()) {
      //            COSBase iterNext = iterator.next();
      //            if (iterNext instanceof COSString) {
      //
      //               COSString cosString = (COSString) iterNext;
      //               String string = cosString.getString();
      //               string = string.replaceFirst("Fabricant", "CHANGED");
      //
      //               cosString.setValue(string.getBytes("ISO-8859-1"));
      //               // Currently this code changes word "Solr" to "Solr123"
      //               //cosString.reset();
      //               //cosString.append(string.getBytes("ISO-8859-1"));
      //            }
      //            //COSString cosString = (COSString) previous.iterator().next();
      //            //String text = cosString.getString();
      //            //System.out.println("Let's what happened ? " + text);
      //         }
      //
      //      }
      //
      //      PDStream updatedStream = new PDStream(document);
      //      OutputStream out = updatedStream.createOutputStream();
      //      ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
      //      tokenWriter.writeTokens(tokens);
      //      page.setContents(updatedStream);
      //
      //
      //      contents.close();
      //      document.save("out.pdf");
      //      document.close();
      //   }
      //}


      return "";
   }

   private static PDDocument load(String path) throws IOException {
      URL pdfFile = PdfWriterPdfBox.class.getClassLoader().getResource(path);
      return PDDocument.load(new File(pdfFile.getPath()));
   }
}
