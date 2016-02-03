package org.parsisys.tehranuniversity.library.util.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import oracle.jbo.Row;
import oracle.jbo.XMLInterface;

import oracle.jbo.server.RowImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

import oracle.xml.parser.v2.XMLNode;

public class ReportGenerator {
    public ReportGenerator() {
        super();
    }
  private static void writeXmlToFile(ByteArrayOutputStream outputStream) {
      OutputStream out;
      try {
          out = new FileOutputStream("c:/a.xml");
          outputStream.writeTo(out);
          out.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
    
    public static byte[] getXMLData(ViewObjectImpl vo,int level) {
        
        byte[] dataBytes = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //The following statement will generate xml representation of the view data.
            //the first param of writeXML takes the number of levels of child nodes to consider.
            //the entire xml is then printed into the outputStream.
            ((XMLNode)vo.writeXML(level, XMLInterface.XML_OPT_ALL_ROWS)).print(outputStream);
            //Simple and Dirty way to generate sample XML data is to print the outputStream to log
            //Then copy the data into xml file.
            //However it will not be possible to generate large xml file in this way
  //            System.out.println(""+outputStream.toString());
          writeXmlToFile(outputStream);
            //
            //The reason we convert to byte[] is that outputStream is not serializable
            //while byte[] is serializable and can be used in client class when needed.
            dataBytes = outputStream.toByteArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return dataBytes;
    }

  public static byte[] getRowXMLData(ViewObjectImpl vo,int level) {
      Row currRow = vo.getCurrentRow();
     
      byte[] dataBytes = null;
      try {
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          //The following statement will generate xml representation of the view data.
          //the first param of writeXML takes the number of levels of child nodes to consider.
          //the entire xml is then printed into the outputStream.
          ((XMLNode)currRow.writeXML(level, XMLInterface.XML_OPT_ALL_ROWS)).print(outputStream);
          //Simple and Dirty way to generate sample XML data is to print the outputStream to log
          //Then copy the data into xml file.
          //However it will not be possible to generate large xml file in this way
  //            System.out.println(""+outputStream.toString());
        writeXmlToFile(outputStream);
          //
          //The reason we convert to byte[] is that outputStream is not serializable
          //while byte[] is serializable and can be used in client class when needed.
          dataBytes = outputStream.toByteArray();
      } catch (IOException e) {
          System.out.println(e.getMessage());
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } 
      
      return dataBytes;
  }

    /**
     * getReport method obtains the xml data of the view object and combines it with the template passed to it.
     * It then converts the report in the desired format and returns the byte[] array.
     * 
     * The reason byte[] is passed instead of OutputStream is that OutputStream is not serializable.
     * 
     * @param templateFile: File Name with Path of the RTF template file.
     * @param outFileType: eg HTML, PDF, RTF
     */
    public static byte[] getReport(String type,int level,String templateFile, String outFileType,ViewObjectImpl vo) {
        
        byte[] dataBytes = null;
        try {
            //Process RTF template to convert to XSL-FO format
            RTFProcessor rtfp = new RTFProcessor(templateFile);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();

            //Use XSL Template and Data from the VO to generate report and return the OutputStream of report
            ByteArrayInputStream xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            ByteArrayInputStream dataStream = new ByteArrayInputStream(("row".equals(type)? getRowXMLData(vo,level):getXMLData(vo,level)));
            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
            byte outFileTypeByte = FOProcessor.FORMAT_PDF;
            if ("HTML".equalsIgnoreCase(outFileType)) {
                outFileTypeByte = FOProcessor.FORMAT_HTML;
            } else if("RTF".equalsIgnoreCase(outFileType)) {
                outFileTypeByte = FOProcessor.FORMAT_RTF;
            }
            processor.setOutputFormat(outFileTypeByte); //FOProcessor.FORMAT_HTML
            processor.generate();

            dataBytes = pdfOutStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException when generating pdf "+ e);
            
        } catch (XDOException e) {
            e.printStackTrace();
            System.out.println("XDOException when generating pdf "+ e);
            
        }
        return dataBytes;
    }
}
