package org.parsisys.tehranuniversity.library.view.beans;

import java.sql.SQLException;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class DataEntry {
   
   private String newBookPlace;
  private String newPost;
  private int catClass;
  private int shelfDelay;
  private int normalDayPenalty;
  private int noLoanDayPenalty;
    private RichSelectOneRadio catClassRadio;
    private RichSelectOneRadio shelfDelayRadio;

    public DataEntry() {
        super();
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     FResult fr= app.dataEntry_catalogPassClassValue();
     if(fr!=null)
         setCatClass(((Number)fr.getResult()).intValue());
     
       fr= app.dataEntry_catalogShelfDelayValue();
      if(fr!=null)
          setShelfDelay(((Number)fr.getResult()).intValue());
      
       fr= app.dataEntry_penaltyType1Value();
      if(fr!=null)
          setNormalDayPenalty(((Number)fr.getResult()).intValue());
       
      fr= app.dataEntry_penaltyType2Value();
      if(fr!=null)
         setNoLoanDayPenalty(((Number)fr.getResult()).intValue());
//            BindingContainer bc= getBindingContainer();
//            //Access Attribute binding for DepartmentId
//            AttributeBinding departmentIdBinding =
//            (AttributeBinding)bc.getControlBinding("PenaltyStatus1") ;
//            setNormalDayPenalty((Integer)departmentIdBinding.getInputValue());
            
      
    }
  public BindingContainer getBindingContainer(){
  return BindingContext.
  getCurrent().getCurrentBindingsEntry();
  }
    public void setNewBookPlace(String newBookPlace) {
        this.newBookPlace = newBookPlace;
    }

    public String getNewBookPlace() {
        return newBookPlace;
    }

    public void setNewPost(String newPost) {
        this.newPost = newPost;
    }

    public String getNewPost() {
        return newPost;
    }

    public String bookPlace_popUp_savebtn() {
      
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.dataEntry_insertBookPlace(getNewBookPlace());
      if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
       
      }else if("info".equals(fr.getType())) {
        JSFUtils.addFacesInfoMessage(fr.getText());
       
      }
      }
      
//      BindingContainer bc=(BindingContainer) getBindingContainer();
//      //Access Attribute binding for DepartmentId
//      AttributeBinding departmentIdBinding =
//      (AttributeBinding)bc.getControlBinding("DepartmentId") ;
//      Integer deptId=(Integer)departmentIdBinding.getInputValue();
      
        return null;
    
    }
    public String post_popUp_savebtn() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.dataEntry_insertPost(getNewPost());
      if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
       
      }else if("info".equals(fr.getType())) {
        JSFUtils.addFacesInfoMessage(fr.getText());
       
      }
      }
        return null;
      
    }

//    public void saveDayPenalty_penaltyType1(ValueChangeEvent valueChangeEvent) {
//        System.out.println(valueChangeEvent.getNewValue());
//      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//
//
//        try {
//            app.dataEntry_insertPenaltyType1(new Number(valueChangeEvent.getNewValue()));
//        } catch (SQLException e) {
//        }
//    }

//    public void saveDayPenalty_penaltyType2(ValueChangeEvent valueChangeEvent) {
//        
//        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//
//
//        try {
//            app.dataEntry_insertPenaltyType2(new Number(valueChangeEvent.getNewValue()));
//        } catch (SQLException e) {
//        }
//    }

    public void saveClass_catalogPassClass(ValueChangeEvent valueChangeEvent) {
      System.out.println(valueChangeEvent.getNewValue());

      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));


      try {
          app.dataEntry_catalogPassClass(new Number(valueChangeEvent.getNewValue()));
      } catch (SQLException e) {
      }
    }

    public void saveClass_catalogShelfDelay(ValueChangeEvent valueChangeEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));


        try {
            app.dataEntry_catalogShelfDelay(new Number(valueChangeEvent.getNewValue()));
        } catch (SQLException e) {
        }
    }

    public void setCatClassRadio(RichSelectOneRadio catClassRadio) {
        this.catClassRadio = catClassRadio;
    }

    public RichSelectOneRadio getCatClassRadio() {
        return catClassRadio;
    }

    public void setShelfDelayRadio(RichSelectOneRadio shelfDelayRadio) {
        this.shelfDelayRadio = shelfDelayRadio;
    }

    public RichSelectOneRadio getShelfDelayRadio() {
        return shelfDelayRadio;
    }

    public void otherSettingSaveActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.dataEntry_catalogPassClass(new Number(getCatClass()));
      app.dataEntry_catalogShelfDelay(new Number(getShelfDelay()));
      app.dataEntry_insertPenaltyType1(new Number(getNormalDayPenalty()));
      app.dataEntry_insertPenaltyType2(new Number(getNoLoanDayPenalty()));

      JSFUtils.addFacesInfoMessage("تغییرات با موفقیت ذخیره شد.");
    }

    public void setCatClass(int catClass) {
        this.catClass = catClass;
    }

    public int getCatClass() {
        return catClass;
    }

    public void setShelfDelay(int shelfDelay) {
        this.shelfDelay = shelfDelay;
    }

    public int getShelfDelay() {
        return shelfDelay;
    }

    public void setNormalDayPenalty(int normalDayPenalty) {
        this.normalDayPenalty = normalDayPenalty;
    }

    public int getNormalDayPenalty() {
        return normalDayPenalty;
    }

    public void setNoLoanDayPenalty(int noLoanDayPenalty) {
        this.noLoanDayPenalty = noLoanDayPenalty;
    }

    public int getNoLoanDayPenalty() {
        return noLoanDayPenalty;
    }

    public void insert_memberSetUp(ActionEvent actionEvent) {
     
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          //return null;
      }
     
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

   

    public void createInsertMemberSetupActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=app.dataEntry_checkLastToDate();
        if(fr!=null) {
          if("error".equals(fr.getType())) {
            JSFUtils.addFacesErrorMessage(fr.getText());
            return;
          }
        }
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          return;
      }
     
    }

    public void makhzanAmanatDehi_chkBx_valueChanged(ValueChangeEvent valueChangeEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=app.dataEntry_makhzanType_valueChanged((Boolean) valueChangeEvent.getNewValue());
    }

    public String insert_cataligDetail_beforeCommit() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.dataEntry_insertCatalogDetail();
      
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
}
