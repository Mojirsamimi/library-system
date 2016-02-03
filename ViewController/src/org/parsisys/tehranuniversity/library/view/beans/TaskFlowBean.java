package org.parsisys.tehranuniversity.library.view.beans;

import java.io.Serializable;

import java.util.List;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import oracle.adf.controller.TaskFlowId;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupCanceledListener;
import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.adf.view.rich.event.RegionNavigationEvent;


import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import util.JSFUtils;

public class TaskFlowBean implements Serializable{
    private  RichRegion tfRegion;

    public static void invokePopup(String popupId)
     {
       invokePopup(popupId, null, null);
     }

     /**
      * Shows the specified popup and uses the specified hints to align the popup.
      * @param popupId is the clientId of the popup to be shown - clientId is derived from backing bean for the af:popup using getClientId method
      * @param align is a hint for the popup display. Check AdfRichPopup js javadoc for valid values. Supported value includes: "AdfRichPopup.ALIGN_START_AFTER", "AdfRichPopup.ALIGN_BEFORE_START" and "AdfRichPopup.ALIGN_END_BEFORE"
      * @param alignId is the clientId of the component the popup should align to - clientId is derived from backing bean for the component using getClientId method
      * align and alignId need to be specified together - specifying null for either of them will have no effect.
      */
     public static void invokePopup(String popupId, String align,
                                    String alignId)
     {
       if (popupId != null)
       {
         ExtendedRenderKitService service =
           Service.getRenderKitService(FacesContext.getCurrentInstance(),
                                       ExtendedRenderKitService.class);

         StringBuffer showPopup = new StringBuffer();
         showPopup.append("var hints = new Object();");
         //Add hints only if specified - see javadoc for AdfRichPopup js for details on valid values and behavior
         if (align != null && alignId != null)
         {
           showPopup.append("hints[AdfRichPopup.HINT_ALIGN] = " + align +
                            ";");
           showPopup.append("hints[AdfRichPopup.HINT_ALIGN_ID] ='" + alignId +
                            "';");
         }
         showPopup.append("var popupObj=AdfPage.PAGE.findComponent('" +
                          popupId + "'); popupObj.show(hints);");
         service.addScript(FacesContext.getCurrentInstance(),
                           showPopup.toString());
       }
     }

     /**
      * Hides the specified popup.
      * @param popupId is the clientId of the popup to be hidden
      * clientId is derived from backing bean for the af:popup using getClientId method
      */
     public static void hidePopup(String popupId)
     {
       if (popupId != null)
       {
         ExtendedRenderKitService service =
           Service.getRenderKitService(FacesContext.getCurrentInstance(),
                                       ExtendedRenderKitService.class);

         String hidePopup =
           "var popupObj=AdfPage.PAGE.findComponent('" + popupId +
           "'); popupObj.hide();";
         service.addScript(FacesContext.getCurrentInstance(), hidePopup);
       }
     }


  

    String uniform_title="/WEB-INF/uniform-title.xml#uniform-title";
    private String taskFlowId = "";
    private String emptyFlowId="";
    private transient RichPopup region_popup;
    

    public TaskFlowBean() {
    }

    public String getDynamicTaskFlowId() {
       
        return (taskFlowId);
    }


    public void navigation(RegionNavigationEvent event) {
      //  public void navigationListener(RegionNavigationEvent event){
          String newViewId = event.getNewViewId();
          //System.out.println("navigation task flow...");
//System.out.println(newViewId);
          //null new view id indicates the taskflow has ended
          if (newViewId == null) {
             
          //    System.out.println("it is null");
            RichRegion region = (RichRegion)event.getSource();
          // region.getRegionModel().refresh(JSFUtils.getFacesContext());
            taskFlowId=emptyFlowId;
            //look for the parent popup
            boolean found = false;
            UIComponent component = region.getParent();
            do {
              if (component instanceof RichPopup) {
                found = true;
              } else {
                component = component.getParent();
                if (component == null) {
                  break;
                }
              }

            } while (!found);
            if (found) {
            //  System.out.println("found!");
              //send script to the client to hide the popup
              FacesContext context = FacesContext.getCurrentInstance();
          
              Service.getRenderKitService(context,
                ExtendedRenderKitService.class).addScript(context,
                 "var popup = AdfPage.PAGE.findComponent('"+ 
                 component.getClientId(context) + "');" +
                 "popup.hide();");
            }
          }
        
    }
  // RegionNavigationEvent regionEvent;
  public void navigationWithoutRefresh(RegionNavigationEvent event) {
    //  public void navigationListener(RegionNavigationEvent event){
        String newViewId = event.getNewViewId();
//regionEvent=event;
        //null new view id indicates the taskflow has ended
        System.out.println(newViewId);
        if (newViewId == null) {
        //    System.out.println("it is null");
          RichRegion region = (RichRegion)event.getSource();
  //           region.getRegionModel().
 //if(event.getOldViewId()==null)
 //region.refresh(JSFUtils.getFacesContext());
  taskFlowId=emptyFlowId;
          //look for the parent popup
          boolean found = false;
          UIComponent component = region.getParent();
          do {
            if (component instanceof RichPopup) {
              found = true;
            } else {
              component = component.getParent();
              if (component == null) {
                break;
              }
            }

          } while (!found);
          if (found) {
          //  System.out.println("found!");
            //send script to the client to hide the popup
            FacesContext context = FacesContext.getCurrentInstance();
        
            Service.getRenderKitService(context,
              ExtendedRenderKitService.class).addScript(context,
               "var popup = AdfPage.PAGE.findComponent('"+ 
               component.getClientId(context) + "');" +
               "popup.hide();");
          }
        }
      
  }
  
    public String providerRole(){
      taskFlowId = "/WEB-INF/provider_role.xml#provider_role";
      invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
      return null;
    }
    
  public String newPerson(){
    taskFlowId = "/WEB-INF/new_personflow.xml#new_personflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
    
  public String userRole(){
    taskFlowId = "/WEB-INF/userRole_flow.xml#userRole_flow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String publicCashPenalty(){
    taskFlowId = "/WEB-INF/public_cash_penalty_flow.xml#public_cash_penalty_flow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String reserve_history(){
    taskFlowId = "/WEB-INF/reserve_historyflow.xml#reserve_historyflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  
  public String reserve_mem(){
    taskFlowId = "/WEB-INF/reserve_memflow.xml#reserve_memflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  
  public String reserve_mem_portal(){
    taskFlowId = "/WEB-INF/portal_reserve_memflow.xml#portal_reserve_memflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String reserve_detail(){
    taskFlowId = "/WEB-INF/reserve_detailflow.xml#reserve_detailflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String publicNonCashPenalty(){
    taskFlowId = "/WEB-INF/public_non_cash_penaltyflow.xml#public_non_cash_penaltyflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String registerLost(){
    taskFlowId = "/WEB-INF/register_lostflow.xml#register_lostflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String penaltyPayment(){
    taskFlowId = "/WEB-INF/penalty_paymentflow.xml#penalty_paymentflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  
  public String loanCashPenalty_new(){
    taskFlowId = "/WEB-INF/loan_cash_penaltyFlow_new.xml#loan_cash_penaltyFlow_new";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String loanCashPenalty_edit(){
    taskFlowId = "/WEB-INF/loan_cash_penaltyFlow_edit.xml#loan_cash_penaltyFlow_edit";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  public String introductionLetter(){
    taskFlowId = "/WEB-INF/Introduction_letterflow.xml#Introduction_letterflow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
  
    public String provider(){
      taskFlowId = "/WEB-INF/provider.xml#provider";
      invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
      return null;
    }
  public String department(){
    taskFlowId = "/WEB-INF/department_flow.xml#department_flow";
    invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
    return null;
  }
    public String subject(){
      taskFlowId = "/WEB-INF/subject.xml#subject";
      invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
      return null;
    }
    
  public String floatSubject(){
      taskFlowId = "/WEB-INF/FloatSubject.xml#FloatSubject";
      invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
      return null;
    }
    public String uniformtitle() {
        taskFlowId = "/WEB-INF/uniform-title.xml#uniform-title";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }

  public String ref_select_uni_title() {
        taskFlowId = "/WEB-INF/ref_select_uni_title.xml#ref_select_uni_title";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
  public String latin_uniformtitle() {
        taskFlowId = "/WEB-INF/ref_select_uni_title.xml#ref_select_uni_title";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
  
  public String ref_select_provider() {
        taskFlowId = "/WEB-INF/ref_select_provider.xml#ref_select_provider";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
  public String latin_provider() {
        taskFlowId = "/WEB-INF/latin_provider_flow.xml#latin_provider_flow";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
  
  public String ref_select_subject() {
        taskFlowId = "/WEB-INF/ref_select_subject.xml#ref_select_subject";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
  
  public String publisher() {
        taskFlowId = "/WEB-INF/publisher.xml#publisher";
       invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
        return null;
    }
    public void setRegion_popup(RichPopup region_popup) {
        this.region_popup = region_popup;
    }

    public RichPopup getRegion_popup() {
        if(region_popup!=null)
        {
         //   System.out.println("it is assigned...");
        region_popup.addPopupCanceledListener(new closedpopup());
        }
        return region_popup;
    }

    public String changePerson() {
      
      taskFlowId = "/WEB-INF/change_person_flow.xml#change_person_flow";
      //getRegion_popup().refresh(FacesContext.getCurrentInstance());
      invokePopup(region_popup.getClientId(JSFUtils.getFacesContext()));
      return null;
    }

    public void closedPopUp(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        taskFlowId="";
    }

    class closedpopup implements PopupCanceledListener, Serializable{

        public void processPopupCanceled(PopupCanceledEvent popupCanceledEvent) {
            taskFlowId=emptyFlowId;
            //System.out.println("it is canceled...");
        }
    }
    public void popupOpen(PopupFetchEvent popupFetchEvent) {
      
   // getTfRegion().refresh(FacesContext.getCurrentInstance());
     // taskFlowId=null;
            
    
    }

    public void setTfRegion(RichRegion tfRegion) {
        this.tfRegion = tfRegion;
    }

    public RichRegion getTfRegion() {
        return tfRegion;
    }
}
