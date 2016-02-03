package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVOImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class IntroductionLetter {
  private String goalLibrary;
  private String Description;
  private RichCommandButton save_button;
  private String popupText;
  private  boolean flag=true;
  
  private Number introLetterId;
  private String reportPath="hiii";
  private int printCount=1;
  private RichCommandButton print_btn;
  private String libName;

    public IntroductionLetter() {
        super();
    }

    public void setGoalLibrary(String goalLibrary) {
        this.goalLibrary = goalLibrary;
    }

    public String getGoalLibrary() {
        return goalLibrary;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public String list_goal_library() {
        // Add event code here...
//        System.out.println(getGoalLibrary());
//        System.out.println(getGoalLibrary()==null);
        if(getGoalLibrary()==null || getGoalLibrary().trim().equals("")){
      String goalLib=(String)  JSFUtils.getCurrentRow("GoalLibLOV1Iterator").getAttribute("GoalLibrary");
      setGoalLibrary(goalLib);
        }
        return "end";
    }

    public void description_Changed(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ((RichInputText)valueChangeEvent.getSource()).setChanged(true);
    }

  public void insert_showResultMessage(ActionEvent actionEvent)
  {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    
    FResult result=app.insert_IntroductionLetter(getGoalLibrary(), getDescription());
    if(result!=null){
        if(result.getType().equalsIgnoreCase("error")){
        JSFUtils.addFacesErrorMessage(result.getText());
        }if(result.getType().equalsIgnoreCase("return")){
             setIntroLetterId((Number)result.getResult());
             System.out.println(getIntroLetterId());
             }
        }
    print_btn.setDisabled(false);
    
  }

  public void postSearch_initPerson(QueryEvent queryOperationEvent)
  {
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
   invokeMethodExpression("#{bindings.searchbarcodeidQuery.processQuery}",Object.class, QueryEvent.class, queryOperationEvent);
  

    FResult result=app.introductionLetter_initPerson();
   
    if(result!=null){
        if(result.getType().equalsIgnoreCase("error")){
        JSFUtils.addFacesErrorMessage(result.getText());
         return;
        } else if(result.getType().equalsIgnoreCase("yn_popup"))
      {
        setPopupText(result.getText());
          
          JSFUtils.showPopup("pt1:p1");
       
          
      }
        }
    if(flag)
    {
      save_button.setDisabled(false);
      //print_btn.setDisabled(false);
    }
   
    
  }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

  public void setSave_button(RichCommandButton save_button)
  {
    this.save_button = save_button;
  }

  public RichCommandButton getSave_button()
  {
    return save_button;
  }

  public void setPopupText(String popupText)
  {
    this.popupText = popupText;
  }

  public String getPopupText()
  {
    return popupText;
  }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void noBtnPressed(ActionEvent actionEvent) {
        // Add event code here...
        setFlag(false);
    }

    public String afterNext_fadak() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result=app.introductionLetter_initPerson();
      
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
          JSFUtils.addFacesErrorMessage(result.getText());
           return null;
          } else if(result.getType().equalsIgnoreCase("yn_popup"))
        {
          setPopupText(result.getText());
            
            JSFUtils.showPopup("pt1:p1");
        }
          }
      if(flag)
      {
        save_button.setDisabled(false);
        //print_btn.setDisabled(false);
      }
        return null;
    }

    public String afterPrevious_fadak() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        FResult result=app.introductionLetter_initPerson();
        
        if(result!=null){
            if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());
             return null;
            } else if(result.getType().equalsIgnoreCase("yn_popup"))
          {
            setPopupText(result.getText());
              
              JSFUtils.showPopup("pt1:p1");
          }
            }
        if(flag)
        {
          save_button.setDisabled(false);
          //print_btn.setDisabled(false);
        }
        return null;
    }

    public void clearing_btn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result=app.preClearing_IntroductionLetter();
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
          JSFUtils.addFacesErrorMessage(result.getText());
           return;
          } else if(result.getType().equalsIgnoreCase("yn_popup"))
        {
          setPopupText(result.getText());
            
            JSFUtils.showPopup("pt1:p1");
          
            
        }
          }
      
      
    }

    public void yesBtnPressed_clearing(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result=app.clearing_IntroductionLetter();
      if(result!=null){
          if(result.getType().equalsIgnoreCase("info")){
          JSFUtils.addFacesInfoMessage(result.getText());
           return;
          } 
          }
    }

    public void setIntroLetterId(Number introLetter) {
        this.introLetterId = introLetter;
    }

    public Number getIntroLetterId() {
        return introLetterId;
    }

    public void setReportPath(String reportPath) {
        System.out.println(reportPath);
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    public int getPrintCount() {
        return printCount;
    }
  public String view_popUp_btn() {
     
    JSFUtils.showPopup("pt1:reportPop");
     
      return null;
  }
    public void reportCountValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setPrint_btn(RichCommandButton print_btn) {
        this.print_btn = print_btn;
    }

    public RichCommandButton getPrint_btn() {
        return print_btn;
    }

    public void setLibName(String libName) {
      
       System.out.println(libName);
        this.libName = libName;
    }

    public String getLibName() {
      UserStatus a = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
      libName=a.getLibname();
        return libName;
    }
}
