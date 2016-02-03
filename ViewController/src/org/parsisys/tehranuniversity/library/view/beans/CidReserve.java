package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;


import oracle.binding.BindingContainer;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import org.apache.myfaces.trinidad.model.CollectionModel;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.PersonVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.VirtualBookVOImpl;

import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class CidReserve {
    private RichCommandButton volNo_btn;
    private RichCommandButton partNo_btn;
    private RichCommandButton reserve1_btn;
    private RichCommandButton reserveList_btn;
    private RichCommandButton showDetail_btn;
    private String popUpTxt;
    private Boolean Capacity_Full=false;
    private Boolean INTER_LIB_NEW_MEM=false;
    private Boolean UPDATE_MEMSHIP_ST=false;
    private RichPopup ynPopUp;
    private RichInputText newEmail;
    private RichCommandButton mem_reserve_btn;
    private RichInputText email;

    public CidReserve() {
    }
    
    
  public void search_person(QueryEvent queryOperationEvent){
    invokeMethodExpression("#{bindings.searchbarcodeQuery.processQuery}",

                                    Object.class, QueryEvent.class, queryOperationEvent);
    init_person();
//    setCapacity_Full(false);
//    setINTER_LIB_NEW_MEM(false);
//    setUPDATE_MEMSHIP_ST(false);
//  
//    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
//    FResult fr1= app.cid_reserve_mem_after_search_barcode();
//    if(fr1!=null) {
//      if("error".equalsIgnoreCase(fr1.getType()))
//      {
//          JSFUtils.addFacesErrorMessage(fr1.getText());
//       
//          return;
//      }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
//          getMem_reserve_btn().setDisabled(false);
//        Boolean[] result= (Boolean[])fr1.getResult();
//          setUPDATE_MEMSHIP_ST(result[1]);
//          setCapacity_Full(result[0]);
//        setPopUpTxt(fr1.getText());        
//        JSFUtils.showPopup("pt1:r1:1:p2");
//        return;
//        
//      }else if("return".equalsIgnoreCase(fr1.getType())) {
//        getMem_reserve_btn().setDisabled(false);
//        Boolean[] result= (Boolean[])fr1.getResult();
//        setUPDATE_MEMSHIP_ST(result[1]);
//        setCapacity_Full(result[0]);
//      }
//    }
  }
    private boolean init_person() {
      setCapacity_Full(false);
      setINTER_LIB_NEW_MEM(false);
      setUPDATE_MEMSHIP_ST(false);
      
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr1= app.cid_reserve_mem_after_search_barcode();
      if(fr1!=null) {
        if("error".equalsIgnoreCase(fr1.getType()))
        {
            JSFUtils.addFacesErrorMessage(fr1.getText());
         
            return false;
        }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
            getMem_reserve_btn().setDisabled(false);
          Boolean[] result= (Boolean[])fr1.getResult();
            setUPDATE_MEMSHIP_ST(result[1]);
            setCapacity_Full(result[0]);
          setPopUpTxt(fr1.getText());        
          JSFUtils.showPopup("pt1:r1:1:p2");
          return false;
          
        }else if("return".equalsIgnoreCase(fr1.getType())) {
          getMem_reserve_btn().setDisabled(false);
          Boolean[] result= (Boolean[])fr1.getResult();
          setUPDATE_MEMSHIP_ST(result[1]);
          setCapacity_Full(result[0]);
          return true;
        }
      }
      return false;
    }
    
  private boolean init_person_portal() {
    setCapacity_Full(false);
    setINTER_LIB_NEW_MEM(false);
    setUPDATE_MEMSHIP_ST(false);
    
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr1= app.cid_reserve_mem_after_search_barcode();
    if(fr1!=null) {
      if("error".equalsIgnoreCase(fr1.getType()))
      {
          JSFUtils.addFacesErrorMessage(fr1.getText());
       
          return false;
      }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
         // getMem_reserve_btn().setDisabled(false);
        Boolean[] result= (Boolean[])fr1.getResult();
          setUPDATE_MEMSHIP_ST(result[1]);
          setCapacity_Full(result[0]);
        setPopUpTxt(fr1.getText());        
        JSFUtils.showPopup("pt1:r1:1:p2");
        return false;
        
      }else if("return".equalsIgnoreCase(fr1.getType())) {
        //getMem_reserve_btn().setDisabled(false);
        Boolean[] result= (Boolean[])fr1.getResult();
        setUPDATE_MEMSHIP_ST(result[1]);
        setCapacity_Full(result[0]);
        return true;
      }
    }
    return false;
  }
  public void search_virtual_book(QueryEvent queryOperationEvent){
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

    String callNo=((VirtualBookVOImpl)app.getVirtualBookVO1()).getCallNoParam();
 
    if(callNo!=null)
      ((VirtualBookVOImpl)app.getVirtualBookVO1()).setCallNoParam(callNo.trim());
    

    
    //////////////////////////////////////////////////////////////////////////
     invokeMethodExpression("#{bindings.SearchCallNoArtIdTitleVCQuery.processQuery}",

                                     Object.class, QueryEvent.class, queryOperationEvent);
     //////////////////////////////////////////////////////////////////////////
     getVolNo_btn().setDisabled(true);
     getPartNo_btn().setDisabled(true);
     getReserve1_btn().setDisabled(true);
     getReserveList_btn().setDisabled(true);
    getShowDetail_btn().setDisabled(true);
//          getVolNo_btn().setDisabled(false);
//     getPartNo_btn().setDisabled(false);
//     getReserve1_btn().setDisabled(false);
//     getReserveList_btn().setDisabled(false);
//    getShowDetail_btn().setDisabled(false);
     int[] result=app.cid_reserve_enable_btns();
     if(result!=null) {
         if(result[0]>0) {
         if(result[1]>0) {
        
           getPartNo_btn().setDisabled(false);
           getVolNo_btn().setDisabled(false);
         }
           getReserve1_btn().setDisabled(false);
             getReserveList_btn().setDisabled(false);
             getShowDetail_btn().setDisabled(false);
           
         }
     }
      
     
  }
    
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }

    public void setVolNo_btn(RichCommandButton volNo_btn) {
        this.volNo_btn = volNo_btn;
    }

    public RichCommandButton getVolNo_btn() {
        return volNo_btn;
    }

    public void setPartNo_btn(RichCommandButton partNo_btn) {
        this.partNo_btn = partNo_btn;
    }

    public RichCommandButton getPartNo_btn() {
        return partNo_btn;
    }

    public void setReserve1_btn(RichCommandButton reserve1_btn) {
        this.reserve1_btn = reserve1_btn;
    }

    public RichCommandButton getReserve1_btn() {
        return reserve1_btn;
    }

    public void setReserveList_btn(RichCommandButton reserveList_btn) {
        this.reserveList_btn = reserveList_btn;
    }

    public RichCommandButton getReserveList_btn() {
        return reserveList_btn;
    }

    public void setShowDetail_btn(RichCommandButton showDetail_btn) {
        this.showDetail_btn = showDetail_btn;
    }

    public RichCommandButton getShowDetail_btn() {
        return showDetail_btn;
    }

    public void setCapacity_Full(Boolean Capacity_Full) {
        this.Capacity_Full = Capacity_Full;
    }

    public Boolean getCapacity_Full() {
        return Capacity_Full;
    }

    public void setINTER_LIB_NEW_MEM(Boolean INTER_LIB_NEW_MEM) {
        this.INTER_LIB_NEW_MEM = INTER_LIB_NEW_MEM;
    }

    public Boolean getINTER_LIB_NEW_MEM() {
        return INTER_LIB_NEW_MEM;
    }

    public void setUPDATE_MEMSHIP_ST(Boolean UPDATE_MEMSHIP_ST) {
        this.UPDATE_MEMSHIP_ST = UPDATE_MEMSHIP_ST;
    }

    public Boolean getUPDATE_MEMSHIP_ST() {
        return UPDATE_MEMSHIP_ST;
    }

    public String memReserveBtnAction() {
     
     
    
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        
        FResult fr1 = app.cid_reserve_mem_reserveBtn(true,getINTER_LIB_NEW_MEM(),getUPDATE_MEMSHIP_ST());
        
        if(fr1!=null) {
          if("error".equalsIgnoreCase(fr1.getType())) {
            JSFUtils.addFacesErrorMessage(fr1.getText());
            return null;
          }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
              setPopUpTxt(fr1.getText());
            JSFUtils.showPopup("pt1:r1:1:p3");
            return null;
          }else {
            JSFUtils.addFacesInfoMessage("کتاب با موفقیت رزرو شد.");
          }
        }
     
        return "end";
    }
    
  public String memReserveBtnAction_portal() {
   
   
  
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     ((PersonVOImpl) app.getPersonVO1()).setbarcode_param2("12345");
      FResult fr1 = app.cid_reserve_mem_reserveBtn(true,getINTER_LIB_NEW_MEM(),getUPDATE_MEMSHIP_ST());
      
      if(fr1!=null) {
        if("error".equalsIgnoreCase(fr1.getType())) {
          JSFUtils.addFacesErrorMessage(fr1.getText());
          return null;
        }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
            setPopUpTxt(fr1.getText());
          JSFUtils.showPopup("pt1:r1:1:p3");
          return null;
        }else {
          JSFUtils.addFacesInfoMessage("کتاب با موفقیت رزرو شد.");
        }
      }
   
      return "end";
  }

    public void setPopUpTxt(String popUpTxt) {
        this.popUpTxt = popUpTxt;
    }

    public String getPopUpTxt() {
        return popUpTxt;
    }

    public void popUpYesBtn(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_reserve_mem_after_search_barcode_after_popup(getCapacity_Full());
      setINTER_LIB_NEW_MEM(true);
      if(fr!=null) {
        if("error".equalsIgnoreCase(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
        }
      }
    }

    public void popUpNoBtn(ActionEvent actionEvent) {
        return;
    }

    public void setYnPopUp(RichPopup ynPopUp) {
        this.ynPopUp = ynPopUp;
    }

    public RichPopup getYnPopUp() {
        return ynPopUp;
    }


    public void popUp_memReserveBtn_Yes(ActionEvent actionEvent) {
      JSFUtils.showPopup("pt1:r1:1:p1");
        
    }

    public void popUp_memReserveBtn_No(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        
        
        FResult fr1 = app.cid_reserve_mem_reserveBtn(false,getINTER_LIB_NEW_MEM(),getUPDATE_MEMSHIP_ST());
      if(fr1!=null) {
        if("error".equalsIgnoreCase(fr1.getType())) {
          JSFUtils.addFacesErrorMessage(fr1.getText());
        }else if("yn_popup".equalsIgnoreCase(fr1.getType())) {
        Boolean[] result= (Boolean[])fr1.getResult();
          setUPDATE_MEMSHIP_ST(result[1]);
          setCapacity_Full(result[0]);
        setPopUpTxt(fr1.getText());        
        JSFUtils.showPopup("pt1:r1:1:p2");
        return;
        }
      }
    }

    public String reserveBtnAction() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=app.cid_reserve_reserveBook_btn();
      if(fr!=null) {
        if("error".equalsIgnoreCase(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return null;
        }
      }else {
//          app.getPersonVO1().applyViewCriteria(null);
//          app.getPersonVO1().executeQuery();
//        app.getPersonVO1().reset();
       return ((TaskFlowBean) JSFUtils.getManagedBeanValue("pageFlowScope.TFBean")).reserve_mem();
      }
      return null;
    }
    
  public String reserveBtnAction_portal() {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr=app.cid_reserve_reserveBook_btn();
    if(fr!=null) {
      if("error".equalsIgnoreCase(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        return null;
      }
    }else {
  //          app.getPersonVO1().applyViewCriteria(null);
  //          app.getPersonVO1().executeQuery();
  //        app.getPersonVO1().reset();
        if(init_person_portal()==true)
        {
 return ((TaskFlowBean) JSFUtils.getManagedBeanValue("pageFlowScope.TFBean")).reserve_mem_portal();
        }
      
    }
    return null;
  }

    public void PhbookVolPartSelectionListener(SelectionEvent selectionEvent) {
        invokeMethodExpression("#{bindings.PhysicalBookVolPartVO1.collectionModel.makeCurrent}", Object.class, SelectionEvent.class, selectionEvent);
       
      getReserve1_btn().setDisabled(false);
        getReserveList_btn().setDisabled(false);
        getShowDetail_btn().setDisabled(false);
        

    }

    public void saveNewEmailActionListener(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr= app.cid_reserve_reserveBtn_newEmail((String)getNewEmail().getValue());
      if(fr!=null) {
        if("error".equalsIgnoreCase(fr.getType())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
          return;
        }
      }else{
          JSFUtils.closePopup("pt1:r1:1:p1");
          AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
          adfFacesContext.addPartialTarget(getEmail());
        }
    }

    public void cancelNewEmailActionListener(ActionEvent actionEvent) {
        return;
    }

    public void setNewEmail(RichInputText newEmail) {
        this.newEmail = newEmail;
    }

    public RichInputText getNewEmail() {
        return newEmail;
    }

    public void setMem_reserve_btn(RichCommandButton mem_reserve_btn) {
        this.mem_reserve_btn = mem_reserve_btn;
    }

    public RichCommandButton getMem_reserve_btn() {
        return mem_reserve_btn;
    }

    public void setEmail(RichInputText email) {
        this.email = email;
    }

    public RichInputText getEmail() {
        return email;
    }


    public String checkReserveBtn() {
      init_person();
        return null;
    }
}
