package com.aelmehdi;

import static org.apache.pdfbox.pdmodel.font.PDType1Font.TIMES_ROMAN;
import static org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfWriterPdfBox {


   private static final String PDF_FILE_NAME = "/pdfBox.pdf";
   private static final int P_X = 30;

   public static void main(String[] args) throws IOException {
      generate("./", "test.pdf");
   }

   public static void generate(String dest, String fileName) throws IOException {
      PDDocument pdDocument = new PDDocument();
      PDPage pdPage = addPage(pdDocument);

      addPdfContent(pdDocument, pdPage);

      pdDocument.save(dest + "/" + fileName);
      pdDocument.close();
   }

   private static void addPdfContent(PDDocument pdDocument, PDPage pdPage) throws IOException {
      PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);

      addTextWithIcon(pdDocument, contentStream, "factory.png",
            "VIDAL France",
            730);

      addText(contentStream, "21 rue Camille Desmoulins", P_X, 705);
      addText(contentStream, "F - 92130 Issy-les-Moulineaux", P_X, 685);
      addText(contentStream, "VIDAL Sécurisation 2020.05", P_X, 650);

      addImage(pdDocument, contentStream, "ce.png", P_X, 600);

      addTextWithIcon(pdDocument, contentStream, "instruction.png",
            "http://www.vidalfrance.com/wp-content/download/info/user-manual-vidal-securisation.pdf",
            560);

      addLink(pdPage,
            "http://www.vidalfrance.com/wp-content/download/info/user-manual-vidal-securisation.pdf",
            560);

      contentStream.close();
   }

   private static void addLink(PDPage pdPage,
                               String hyperlink,
                               int pY) throws IOException {
      PDAnnotationLink annotationLink = new PDAnnotationLink();

      PDRectangle annotationPosition = new PDRectangle();
      PDBorderStyleDictionary underline = new PDBorderStyleDictionary();
      underline.setStyle(STYLE_UNDERLINE);
      annotationLink.setBorderStyle(underline);

      int box_width = 470;
      int text_line_height = 20;

      annotationPosition.setLowerLeftX(P_X + 15);
      annotationPosition.setLowerLeftY(pY);
      annotationPosition.setUpperRightX(P_X + box_width);
      annotationPosition.setUpperRightY(pY + text_line_height);

      annotationLink.setRectangle(annotationPosition);

      PDActionURI action = new PDActionURI();
      action.setURI(hyperlink);
      annotationLink.setAction(action);
      annotationLink.setContents(hyperlink);

      pdPage.getAnnotations().add(annotationLink);
   }

   private static void addTextWithIcon(PDDocument pdDocument,
                                       PDPageContentStream contentStream,
                                       String imagePath,
                                       String text,
                                       int pY) throws IOException {
      addImage(pdDocument, contentStream, imagePath, P_X, pY - 5);
      addText(contentStream, text, P_X + 35, pY);
   }

   private static void addImage(PDDocument pdDocument, PDPageContentStream contentStream, String s, int i, int i2) throws IOException {
      PDImageXObject factoryIcon = createImageFromResource(pdDocument, s);

      contentStream.drawImage(factoryIcon, i, i2);
   }

   private static void addText(PDPageContentStream contentStream, String text, int tx, int ty) throws IOException {
      contentStream.beginText();

      contentStream.setFont(TIMES_ROMAN, 12);
      contentStream.newLineAtOffset(tx, ty);
      contentStream.showText(text);

      contentStream.endText();
   }

   private static PDPage addPage(PDDocument pdDocument) {
      PDPage pdPage = new PDPage();
      pdDocument.addPage(pdPage);
      return pdPage;
   }

   private static PDImageXObject createImageFromResource(PDDocument pdDocument, String imagePath) throws IOException {
      URL resource = PdfWriterPdfBox.class.getClassLoader().getResource(imagePath);
      return PDImageXObject.createFromFile(resource.getPath(), pdDocument);
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
      //URL pdfFile = PdfWriterPdfBox.class.getClassLoader().getResource(path);
      return PDDocument.load(new File(path));
   }
}
