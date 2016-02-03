package Servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.URLConnection;

import javax.servlet.*;
import javax.servlet.http.*;

import org.parsisys.tehranuniversity.library.view.beans.UserStatus;

public class File extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
  private String baseBookFileDir="c:\\vbookfiles";
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
      response.setContentType(CONTENT_TYPE);
        HttpSession currSession = request.getSession();
       UserStatus currUser = (UserStatus)currSession.getAttribute("sessionUser");
       if(currUser==null)
       {      
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>File</title></head>");
                out.println("<body>");
                out.println("<p>Access Denied.</p>");
                out.println("</body></html>");
                out.close();
                return;
       }
       if(!currUser.isAuthenticated())
       {                
           PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>File</title></head>");
                out.println("<body>");
                out.println("<p>Access Denied.</p>");
                out.println("</body></html>");
                out.close();
                return;
       }
       if(!currUser.getDownloadBookFileAllowed()) {
         PrintWriter out = response.getWriter();
              out.println("<html>");
              out.println("<head><title>File</title></head>");
              out.println("<body>");
              out.println("<p>Access Denied.</p>");
              out.println("</body></html>");
              out.close();
              return;
       }
     
        String fileAddr=request.getParameter("FileName");
      String VbookArtId=request.getParameter("VbookArtId");
      String PhbookArtId=request.getParameter("PhbookArtId");
             if(fileAddr==null)
                 return;
          
          
           java.io.File f=new java.io.File(baseBookFileDir+"\\"+currUser.getLabcol()+"\\"+VbookArtId+"\\"+PhbookArtId+"\\"+fileAddr);
           
           //if there is not any file for this person,
           if(!f.exists()){
             PrintWriter out = response.getWriter();
                  out.println("<html>");
                  out.println("<head><title>File</title></head>");
                  out.println("<body>");
                  out.println("<p>File Not Found.</p>");
                  out.println("</body></html>");
                  out.close();
              return;
           }
      OutputStream   out= response.getOutputStream();
     
      response.setContentType(URLConnection.guessContentTypeFromName(f.getName()));
           //read the file and write it back.
          FileInputStream fin= new FileInputStream(f);
          int a1=0;
          while ((a1=fin.read())!=-1){
              out.write(a1);
          }
          fin.close();
          out.close();
    }
}
