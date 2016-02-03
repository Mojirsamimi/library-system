package org.parsisys.tehranuniversity.library.view.beans;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.PersonVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.PersonVORowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class ChangePersonBean implements Serializable{
    private Boolean is_post_changed=false;
    private transient Object cmemSetupCurrentValue;
    private Map<String,Boolean> attrMap;
    private transient RichSelectOneChoice post;
    private transient RichSelectOneChoice deptSOC;
    private transient RichSelectOneChoice secSOC;
    private transient RichSelectOneChoice mjrSOC;

    public ChangePersonBean() {
      
        super();
    
    }

    public void prepareFields() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.change_person_init_post();
      FResult fr= app.change_person_prepare_fields();
     setAttrMap((HashMap)fr.getResult());
    }

    public void setIs_post_changed(Boolean is_post_changed) {
        this.is_post_changed = is_post_changed;
    }

    public Boolean getIs_post_changed() {
        return is_post_changed;
    }

    public void cmemSetupPostChangeListener(ValueChangeEvent valueChangeEvent) {
       
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    
      
       
        BindingContainer bindings =
        BindingContext.getCurrent().getCurrentBindingsEntry();
        JUCtrlListBinding listBinding =
        (JUCtrlListBinding)bindings.get("CmemSetupPost"); 
        int index=(Integer)valueChangeEvent.getNewValue();
        
        Number newValue=(Number)((ViewRowImpl)listBinding.getValueFromList(index)).getAttribute("Value");
        
    FResult fr= app.change_person_cmemsetuppost_change(newValue);
    
    if(fr==null)
    {
       if(!getIs_post_changed()) {
         setCmemSetupCurrentValue(valueChangeEvent.getOldValue());
         setIs_post_changed(true);
       }else if(valueChangeEvent.getNewValue().equals(getCmemSetupCurrentValue()))
       {
       setIs_post_changed(false);
       }
    }else {
     post.setValue(valueChangeEvent.getOldValue());
      AdfFacesContext.getCurrentInstance().addPartialTarget(post);
        if("error".equalsIgnoreCase(fr.getType()))
        JSFUtils.addFacesErrorMessage(fr.getText());
        JSFUtils.addFacesErrorMessage("سمت قابل تغییر نیست.");
    }
 
    
   
    }
  
    public void setCmemSetupCurrentValue(Object cmemSetupCurrentValue) {
        this.cmemSetupCurrentValue = cmemSetupCurrentValue;
    }

    public Object getCmemSetupCurrentValue() {
        return cmemSetupCurrentValue;
    }

    public void setAttrMap(Map attrMap) {
        this.attrMap = attrMap;
    }

    public Map getAttrMap() {
        return attrMap;
    }

    public void setPost(RichSelectOneChoice post) {
        this.post = post;
    }

    public RichSelectOneChoice getPost() {
        return post;
    }

    public String saveAction() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.change_person_save();
      if(fr!=null) {
        if("error".equalsIgnoreCase(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return null;
        }else  if("info".equalsIgnoreCase(fr.getType())) {
            JSFUtils.addFacesInfoMessage(fr.getText());
            setIs_post_changed(false);
            setCmemSetupCurrentValue(null);           
            return "save";
        }
      }
       return null;
    }
    
  public void createAdfmSavePoint(){ 
    String sph= ControllerContext.getInstance().getSavePointManager().createSavePoint();
    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("AdfmSavePoint",sph);
  }
 
    public String rollbackAction() {
     
//       ViewObject personVO = JSFUtils.getViewFromIterator("PersonVO1Iterator");
//       Row currPerson = personVO.getCurrentRow();
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.change_person_role_back();
//      personVO.executeEmptyRowSet();
//      
//     // personVO = (PersonVOImpl)JSFUtils.getViewFromIterator("PersonVO1Iterator");
//       personVO.setCurrentRow(currPerson);
        return "end";
    }

    public void setDeptSOC(RichSelectOneChoice deptSOC) {
        this.deptSOC = deptSOC;
    }

    public RichSelectOneChoice getDeptSOC() {
        return deptSOC;
    }

    public void deptSecMjrValueChangeListener(ValueChangeEvent valueChangeEvent) {
      if("soc5".equals(valueChangeEvent.getComponent().getId())) {
        getSecSOC().resetValue();
        getMjrSOC().resetValue();
      }else if("soc7".equals(valueChangeEvent.getComponent().getId())) {
        getMjrSOC().resetValue();
      }
    }

    public void setSecSOC(RichSelectOneChoice secSOC) {
        this.secSOC = secSOC;
    }

    public RichSelectOneChoice getSecSOC() {
        return secSOC;
    }

    public void setMjrSOC(RichSelectOneChoice mjrSOC) {
        this.mjrSOC = mjrSOC;
    }

    public RichSelectOneChoice getMjrSOC() {
        return mjrSOC;
    }
    public void taskFlowFinalizer() {
      System.out.println("task flow finalizer");
    }
    public void savePointFinalizer() {
    //  System.out.println("save point finalizer");
    }
}
