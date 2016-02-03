package org.parsisys.tehranuniversity.library.view.beans;



import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;


import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;



import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.PersonVORowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;


import util.JSFUtils;

public class LoginBean {
    private RichSelectOneChoice labcolSelectOneChoice;
    private RichInputText loginUsername;
    private RichInputText loginPassword;
    private String username;
  
   
    private RichSelectOneRadio persCategorySOR;


    public LoginBean() {
        //getPersCategorySOR().setValue(arg0);
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

   

   




    public void userNameChangeListener(ValueChangeEvent valueChangeEvent) {
      AppModuleImpl app =
          (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
        if("1".equals(getPersCategorySOR().getValue()))
        {
      
        app.login_apply_LibUser_UserNameVC((String)getLoginUsername().getValue());
        }else if("2".equals(getPersCategorySOR().getValue()) || "3".equals(getPersCategorySOR().getValue())){
            app.login_apply_person_IDVC((String)getLoginUsername().getValue(),("2".equals(getPersCategorySOR().getValue())?"student":"staff"));
        }else  if("4".equals(getPersCategorySOR().getValue())){
          app.login_apply_person_BarcodeVC((String)getLoginUsername().getValue());
        }
        //System.out.println(getLabcolSelectOneChoice().getLocalValue());
        //  AdfFacesContext.getCurrentInstance().addPartialTarget(getLabcolSelectOneChoice());
    }

    public oracle.binding.BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setLabcolSelectOneChoice(RichSelectOneChoice labcolSelectOneChoice) {
        this.labcolSelectOneChoice = labcolSelectOneChoice;
    }

    public RichSelectOneChoice getLabcolSelectOneChoice() {
        return labcolSelectOneChoice;
    }

    public String loginAction() {
      
        AppModuleImpl app =
            (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
      FResult fr=null;
      String returnVal=null;
      String loginType=null;
      String username_temp=null;
        if("1".equals(getPersCategorySOR().getValue()))
        {
//        getLoginUsername().setValue("s_a36");
//        getLoginPassword().setValue("*******");
      fr  =
            app.login_checkUserPass_libOperator((String)getLoginUsername().getValue(), (String)getLoginPassword().getValue());
      returnVal="lib_operator_success";
      loginType="operator";
        username_temp=  (String)app.getSession().getUserData().get("username");
        }else if("2".equals(getPersCategorySOR().getValue())) {
          fr=app.login_checkUserPass_student((String)getLoginUsername().getValue(), (String)getLoginPassword().getValue());
          returnVal="login_portal_success";
          loginType="portal";
          PersonVORowImpl currPerson = (PersonVORowImpl)app.getPersonVO1().getCurrentRow();
          if(currPerson!=null){ username_temp=currPerson.getFname()+" "+currPerson.getLname();}
        }else if("3".equals(getPersCategorySOR().getValue())){
        fr=app.login_checkUserPass_staff((String)getLoginUsername().getValue(), (String)getLoginPassword().getValue());
        
          returnVal="login_portal_success";
          loginType="portal";
          PersonVORowImpl currPerson = (PersonVORowImpl)app.getPersonVO1().getCurrentRow();
         if(currPerson!=null){ username_temp=currPerson.getFname()+" "+currPerson.getLname();}
        }else if("4".equals(getPersCategorySOR().getValue())) {
            fr=   app.login_checkUserPass_unofficial_member((String)getLoginUsername().getValue(), (String)getLoginPassword().getValue());
               returnVal="login_portal_success";
               loginType="portal";
               PersonVORowImpl currPerson = (PersonVORowImpl)app.getPersonVO1().getCurrentRow();
             if(currPerson!=null){  username_temp=currPerson.getFname()+" "+currPerson.getLname();  }
             }
        if (fr != null) {
            if ("error".equalsIgnoreCase(fr.getType())) {
                JSFUtils.addFacesErrorMessage(fr.getText());
            } else if ("info".equalsIgnoreCase(fr.getType())) {
                JSFUtils.addFacesInfoMessage(fr.getText());
            } else if ("return".equalsIgnoreCase(fr.getType())) {
                UserStatus us = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
                us.setSecurityMap((Map)fr.getResult());
                us.setAuthenticated(true);
                us.setUsername(username_temp);
                us.setLibname((String)app.getSession().getUserData().get("libname"));
              us.setLabcol((Number)app.getSession().getUserData().get("labcolno"));
              us.setLibartid((Number)app.getSession().getUserData().get("libartid"));
              us.setLoginType(loginType);
                return returnVal;
            }
        }
        return null;
    }

    public void setLoginUsername(RichInputText userName) {
        this.loginUsername = userName;
    }

    public RichInputText getLoginUsername() {
        return loginUsername;
    }

    public void setLoginPassword(RichInputText password) {
        this.loginPassword = password;
    }

    public RichInputText getLoginPassword() {
        return loginPassword;
    }

    public void setUsername(String s_username) {
        this.username = s_username;
    }

    public String getUsername() {
        return username;
    }



  
    public String logoutAction() {
       
        
        getLoginUsername().setValue(null);
        setUsername(null);
        setLoginPassword(null);
        getLabcolSelectOneChoice().resetValue();
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

  


    public void refreshLibraryActionListener(ActionEvent actionEvent) {
      AppModuleImpl app =
          (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
      if("1".equals(getPersCategorySOR().getValue()))
      {
      
      app.login_apply_LibUser_UserNameVC((String)getLoginUsername().getValue());
        }else if("2".equals(getPersCategorySOR().getValue()) || "3".equals(getPersCategorySOR().getValue())){
            app.login_apply_person_IDVC((String)getLoginUsername().getValue(),
                    ("2".equals(getPersCategorySOR().getValue())?"student":"staff"));
        }else if("4".equals(getPersCategorySOR().getValue()) ) {
        app.login_apply_person_BarcodeVC((String)getLoginUsername().getValue());
      }
      
    }

    public void setPersCategorySOR(RichSelectOneRadio persCategorySOR) {
        this.persCategorySOR = persCategorySOR;
    }

    public RichSelectOneRadio getPersCategorySOR() {
        return persCategorySOR;
    }
}
