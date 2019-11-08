package output;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.bcel.classfile.Constant;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDDocumentCatalogAdditionalActions;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;













public class Finalresult {
	
	
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	/*LocalDateTime now = LocalDateTime.now();
	String date_time = now.toString()+".docx";
	String formatedate =date_time.replace(":",".");*/
	Date date=java.util.Calendar.getInstance().getTime();  
	
   
	
	//String formate_date_time =date_time.replace();
			
	public void docconversion(String TC_ID) {

		try {
		String docpath="C:/Users/SausthavNegi/eclipse-workspace/Lovish/Output/Doc/"+TC_ID+".docx";
		String pdfpath="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Pdf/"+TC_ID+".pdf";
		String htmlpath="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Html/"+TC_ID+".docx";
		
		//doctohtml(docpath, htmlpath);
		//pdfconversion(docpath, pdfpath);
		
		/*
		
		
		Jars not available to convert to DOCX formate to HTML and PDF.. only support is availble for
			POI version 3.17   but POI used in this project is POI version 4.1.0
		
		*/
		
			
		
		}
		catch(Exception e) {
			System.out.println("Doc conversion catch block : "+e);
		}
		
	}
	
	public void OutputSetup(String TC_ID)  {
		 docOutputSetup(TC_ID);
		 //pdfOutputSetup(TC_ID);
	}
	
	public void OutputPass(String TC_ID,String msg,String pathscrnshotz)  {
		docOutputPass(TC_ID, msg, pathscrnshotz);
		
	}
	
	public void OutputFail(String TC_ID,String msg,String pathscrnshotz)  {
		
        docOutputFail(TC_ID, msg, pathscrnshotz);
	}
	
	
	
	
    public void docOutputFail(String TC_ID,String msg,String pathscrnshotz)  {
    	String docpath="C:/Users/SausthavNegi/eclipse-workspace/Lovish/Output/Doc/"+TC_ID+".docx";
		try {
			System.out.println(date);
			System.out.println("screenshot path : "+pathscrnshotz);
			System.out.println("Document path: "+docpath);
			XWPFDocument docfile = new XWPFDocument(new FileInputStream(docpath));
			//XWPFParagraph docpara = docfile.getLastParagraph();
			XWPFParagraph docpara = docfile.createParagraph();
			XWPFRun docrun = docpara.createRun();
			docpara.addRun(docrun);
			docrun.getParagraph().setAlignment(ParagraphAlignment.LEFT);
			docrun.addBreak();
			docrun.addBreak();
			docrun.addBreak();
			docrun.setText(TC_ID+"\t\t\t\t\t:    "+msg);
			docrun.setColor("FF0000");
			docrun.addPicture(new FileInputStream(pathscrnshotz),XWPFDocument.PICTURE_TYPE_PNG,pathscrnshotz,Units.toEMU(300), Units.toEMU(250));
			FileOutputStream fileout =new FileOutputStream(docpath);
			docfile.write(fileout);
			fileout.flush();
			fileout.close();
			docfile.close();
			
			
		}
		catch(Exception e) {
			System.out.println("exception file :"+e);
		}
		docconversion(TC_ID);
	}
	
	public void docOutputSetup(String TC_ID)  {
		String docpath="C:/Users/SausthavNegi/eclipse-workspace/Lovish/Output/Doc/"+TC_ID+".docx";
		try {
			System.out.println(date);
			//System.out.println("screenshot path : "+pathscrnshotz);
			XWPFDocument docfile = new XWPFDocument();
			XWPFParagraph docpara = docfile.createParagraph();
			XWPFFooter docfoot = docfile.createFooter(HeaderFooterType.FIRST);
			XWPFRun docrun = docpara.createRun();
			XWPFParagraph docfooter =docfoot.createParagraph();
			XWPFRun docfooterun =docfooter.createRun();
			docrun.setText("Test case : "+"* "+TC_ID+" *");
			docrun.addBreak();
			docrun.setText(date.toString());
			docrun.setBold(true);
			docrun.setCapitalized(true);
			docrun.setUnderline(UnderlinePatterns.THICK);
			docrun.addBreak();
		    docrun.getParagraph().setAlignment(ParagraphAlignment.CENTER);
		    docfooterun.setText("Developed by: Sausthav Negi");		    
		    docfooterun.getParagraph().setAlignment(ParagraphAlignment.RIGHT);
			//File file =new File("C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/"+TC_ID+"_"+formatedate);
			FileOutputStream fileout =new FileOutputStream(docpath);
			docfile.write(fileout);
			fileout.flush();
			fileout.close();
			docfile.close();
			//docpath ="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Doc"+TC_ID+".docx";
			//return docpath;
			
		}
		catch(Exception e) {
			System.out.println("exception file :"+e);
			
		}
		//return docpath;
		docconversion(TC_ID);
	}
	
	public void docOutputPass(String TC_ID,String msg,String pathscrnshotz)  {
		String docpath="C:/Users/SausthavNegi/eclipse-workspace/Lovish/Output/Doc/"+TC_ID+".docx";
		try {
			System.out.println(date);
			System.out.println("screenshot path : "+pathscrnshotz);
			System.out.println("Document path: "+docpath);
			XWPFDocument docfile = new XWPFDocument(new FileInputStream(docpath));
			//XWPFParagraph docpara = docfile.getLastParagraph();
			XWPFParagraph docpara = docfile.createParagraph();
			XWPFRun docrun = docpara.createRun();
			docpara.addRun(docrun);
			docrun.getParagraph().setAlignment(ParagraphAlignment.LEFT);
			docrun.addBreak();
			docrun.setText(TC_ID+"\t\t\t\t\t:    "+msg);
			docrun.addBreak();
			docrun.addBreak();
			docrun.addBreak();
			docrun.addPicture(new FileInputStream(pathscrnshotz),XWPFDocument.PICTURE_TYPE_PNG,pathscrnshotz,Units.toEMU(300), Units.toEMU(250));
			FileOutputStream fileout =new FileOutputStream(docpath);
			docfile.write(fileout);
			fileout.flush();
			fileout.close();
			docfile.close();			
			
		}
		catch(Exception e) {
			System.out.println("exception file :"+e);
		}
		docconversion(TC_ID);
	}
 
	
	/* public void doctohtml(String docpath, String htmlpath)
			    throws ParserConfigurationException, TransformerConfigurationException,TransformerException, IOException {       
			    //change the type from XWPFDocument to HWPFDocument
			    HWPFDocument hwpfDocument = null;
			    try {
			        FileInputStream fis = new FileInputStream(new File(docpath));
			        POIFSFileSystem fileSystem = new POIFSFileSystem(fis);          
			             hwpfDocument = new HWPFDocument(fileSystem);

			    } catch (IOException ex) {
			        ex.printStackTrace();
			    }

			    WordToHtmlConverter wordToHtmlConverter = new   WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
			    org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
			    //add processDocument method 
			    wordToHtmlConverter.processDocument(hwpfDocument);
			    ByteArrayOutputStream out = new ByteArrayOutputStream();
			    DOMSource domSource = new DOMSource(htmlDocument);
			    StreamResult streamResult = new StreamResult(htmlpath);

			    TransformerFactory tf = TransformerFactory.newInstance();
			    Transformer serializer = tf.newTransformer();
			    serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			    serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			    serializer.setOutputProperty(OutputKeys.METHOD, "html");
			    serializer.transform(domSource, streamResult);
			    out.close();

			    String result = new String(out.toByteArray());

			    String htmlText = result;
			    System.out.println(htmlText);

			    }*/
	// not using this method
	/*public void pdfconversion(String docpath,String pdfpath) {
		try {
		  //Creating the instance of OpenOfficeConnection and 
        //passing the port number to SocketOpenOfficeConnection constructor 
        OpenOfficeConnection con = new SocketOpenOfficeConnection(8100);

        //making the connection with openoffice server
        con.connect();

        // making the object of doc file and pdf file
        File inFile = new File(docpath);

        //this is the final converted pdf file
        File outFile = new File(pdfpath);

        //making the instance 
        DocumentConverter converter = new OpenOfficeDocumentConverter(con);

        //passing both files objects
        converter.convert(inFile, outFile);

        con.disconnect();
		}
		catch(Exception e) {
			System.out.println("PDF conversion exception :"+e);
		}
	}*/
	
	
	/*public void pdfOutputSetup(String TC_ID) {
		String pdfpath="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Pdf/"+TC_ID+".pdf";
		try {
			System.out.println(date);
			//System.out.println("screenshot path : "+pathscrnshotz);
			
			PDDocument pdffile= new PDDocument(Constants.A4);
			PDPage pdfpage =new PDPage();
			PDDocumentInformation pdfinfo= pdffile.getDocumentInformation();
			PDPageContentStream pdfwrite = new PDPageContentStream(pdffile,pdfpage);
			
			pdffile.addPage(pdfpage);
			//Setting up the Document Information
			pdfinfo.setAuthor("Sausthav negi");
			pdfinfo.setTitle("IBM Testing : "+TC_ID);
			
			pdfwrite.beginText();
			pdfwrite.setFont(PDType1Font.TIMES_BOLD,17);
			pdfwrite.newLineAtOffset(100, 100);
			pdfwrite.showText(TC_ID);
			pdfwrite.newLine();
			pdfwrite.showText(date.toString());
			
			
			float x = (mediaBox.getWidth() - titleWidth) / 2;
            float y= mediaBox.getHeight() - marginTop - titleHeight;
			pdfwrite.newLineAtOffset(x, y);
			
			pdfwrite.close();
		
			pdffile.save(pdfpath);
			
			//docpath ="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Doc"+TC_ID+".docx";
			//return docpath;
			
		}
		catch(Exception e) {
			System.out.println("exception file :"+e);
			
		}
		
	}*/
	
}
