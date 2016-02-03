package org.parsisys.tehranuniversity.library.view.beans;

import java.io.IOException;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.util.ParsiUtil;

public class UserStatus {
    
    private String username;
    private String libname;
    private Number labcol;
    private Number libartid;
    private String name;
    private String lastname;
    private String current_page;
    private boolean authenticated = false;
    private Map securityMap;
    private int persCategory;
    private String lastPage;
    private String loginType;
   


    public UserStatus() {
        super();
    }
    public String getRand(){
      return  String.valueOf( System.currentTimeMillis());// new java.util.Date().getTime();
    }

    public String getLoginstatus() {
        System.out.println("it is login status..");
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println(context.getViewRoot().getViewId());

        return "success";
    }
public Boolean getUploadBookFileAllowed()
{
     
      if ("0".equals(ParsiUtil.StNVL((String)securityMap.get("persianCataloging/uploadfile"),"0")))
          return false;
      return true;
    }
  public Boolean getDownloadBookFileAllowed()
  {
       
        if ("0".equals(ParsiUtil.StNVL((String)securityMap.get("persianCataloging/downloadfile"),"0")))
            return false;
        return true;
      }

    public String getAuthorization() {
     
            
      FacesContext context = FacesContext.getCurrentInstance();
      try {
          if (!isAuthenticated()) {
            ControllerContext controllerCtx = null;
            controllerCtx = ControllerContext.getInstance();
            String activityURL =
              controllerCtx.getGlobalViewActivityURL("logInFirst.jspx");

            context.getExternalContext().redirect(activityURL);
           


          } else if ("0".equals(ParsiUtil.StNVL((String)securityMap.get(context.getViewRoot().getViewId().replaceFirst("/",
                                                                                               "")),
                        "0"))) {
              
            ControllerContext controllerCtx = null;
            controllerCtx = ControllerContext.getInstance();
            String activityPage=("portal".equals(getLoginType())?"PortalAccessDenied":"AccessDenied");
            String activityURL =
              controllerCtx.getGlobalViewActivityURL(activityPage);

            context.getExternalContext().redirect(activityURL);

             

          }else {
            setLastPage(context.getViewRoot().getViewId().replaceFirst("/",""));
          }
          
      } catch (IOException e) {
          e.printStackTrace();
      }


        
        
//        FacesContext context = FacesContext.getCurrentInstance();
//        try {
//            if (!isAuthenticated()) {
//                ExternalContext extContext = context.getExternalContext();
//                HttpServletResponse response =
//                    (HttpServletResponse)extContext.getResponse(); ///HttpServletResponse is not being found...
//
//
//                response.sendRedirect("/Library-ViewController-context-root/faces/logIn");
//
//
//            } else if ("0".equals(securityMap.get(context.getViewRoot().getViewId().replaceFirst("/",
//                                                                                                 "")))) {
//                ExternalContext extContext = context.getExternalContext();
//                HttpServletResponse response =
//                    (HttpServletResponse)extContext.getResponse();
//
//                response.sendRedirect("/Library-ViewController-context-root/faces/AccessDenied.jspx");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

   

    public oracle.binding.BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    

   

   
    public void setUsername(String s_username) {
        this.username = s_username;
    }

    public String getUsername() {
        return username;
    }


    public void setSecurityMap(Map securityMap) {
        this.securityMap = securityMap;
    }

    public Map getSecurityMap() {
        return securityMap;
    }

    public String logoutAction() {
        setAuthenticated(false);
        setSecurityMap(null);
       
        setUsername(null);
       
       
      FacesContext fc = FacesContext.getCurrentInstance();
              ExternalContext ectx = fc.getExternalContext();      
              HttpSession session = (HttpSession)ectx.getSession(false);
              try {
                  session.invalidate();          
                  ectx.redirect("../faces/logIn");
                  fc.responseComplete();
              } catch (Exception exp) {
                  exp.printStackTrace();
                
              }

        return null;
    }

    public void setLibname(String libname) {
        this.libname = libname;
    }

    public String getLibname() {
        return libname;
    }

    public void setLabcol(Number labcol) {
        this.labcol = labcol;
    }

    public Number getLabcol() {
        return labcol;
    }

    public void setLibartid(Number libartid) {
        this.libartid = libartid;
    }

    public Number getLibartid() {
        return libartid;
    }


    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPage() {
        return lastPage;
    }

    public void backToLastPageActionListener(ActionEvent actionEvent) {
    //  System.out.println(getLastPage());
      FacesContext context = FacesContext.getCurrentInstance();
     ControllerContext controllerCtx = null;
      controllerCtx = ControllerContext.getInstance();
      String activityURL =
        controllerCtx.getGlobalViewActivityURL(getLastPage());

        try {
            context.getExternalContext().redirect(activityURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
             
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }
}
