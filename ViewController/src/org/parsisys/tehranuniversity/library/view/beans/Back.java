package org.parsisys.tehranuniversity.library.view.beans;

import fadak.base.TemplateViewObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;


import oracle.adf.model.servlet.ADFBindingFilter;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import org.parsisys.tehranuniversity.library.model.vo.FloatSubjectVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderRoleVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderVOImpl;
import org.parsisys.tehranuniversity.library.model.vo.ProviderVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.Publisher_PersianVORowImpl;
import org.parsisys.tehranuniversity.library.model.vo.SubjectVoRowImpl;
import org.parsisys.tehranuniversity.library.model.vo.UniformTitleVORowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class Back {
private String reportPath;
  private String fromStr="hello";
    private RichInputFile bookFileInput;
    private RichInputText providerName;
    private RichInputText providerForiegnName;
    private RichInputText providerBDate;
    private int readingOrder;

    public Back() {
        
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String select_role() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("copy_role_main_page");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        if(((Integer)result)==0){
            JSFUtils.addFacesErrorMessage("ابتدا پدید آور را انتخاب نمایید");
        }
        return "go";
    }

    public String provider_mainpage() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("copy_provider_main_page");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        if(((Integer)result)==0){
            JSFUtils.addFacesErrorMessage("انتخاب پدید آور با مشکل مواجه گردید.");
        }
        return "go";
    }
      public void provider_mainpage_dblClick(ClientEvent clientEvent) {
        provider_mainpage();
      }

    public String select_publisher() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr= app.select_publisher_mainpage();
    if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        return null;
      }
    }
   
        return "go";
    }

    public void setPersian(){
      ViewObject curr=JSFUtils.getViewFromIterator("VirtualBookVO1Iterator");
      curr.getRowSet().getFilteredRows("ReadingOrder", new Number(1));
      curr.executeQuery();
      
    }
    public String create_Persian() {
        Row curr=JSFUtils.getCurrentRow("VirtualBookVO1Iterator");
        curr.setAttribute("ReadingOrder", new Number(1));
        
      // System.out.println("reading order is set!");
        return null;
    }
  public String create_English() {
      Row curr=JSFUtils.getCurrentRow("VirtualBookVO1Iterator");
      curr.setAttribute("ReadingOrder", new Number(2));
      
     System.out.println("reading order is set!");
      return null;
  }
    public void create_status(){
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      UserStatus user = (UserStatus)JSFUtils.getManagedBeanValue("sessionUser");
      app.getSession().getUserData().put("labcolno",new Number(user.getLabcol()) );
      app.getSession().getUserData().put("username",user.getUsername() );
      app.getSession().getUserData().put("libartid",user.getLibartid() );
      app.getSession().getUserData().put("labcol",user.getLabcol() );
    }

    public String remove_role() {
        ViewObject vo=JSFUtils.getViewFromIterator("VbookMainProviderVO1Iterator");
        if(vo.getRowCountInRange()<2){
          vo.getCurrentRow().setAttribute("PrvroleArtId", null);
          return null;
        }
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Delete");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void setReportPath(String reportPath) {
      System.out.println(reportPath);

        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public String preview_btn() {
     
      JSFUtils.showPopup("pt1:reportPop");

        return null;
    }

    public void setFromStr(String fromStr) {
        this.fromStr = fromStr;
    }

    public String getFromStr() {
        return fromStr;
    }

    public void preview_btnp(ActionEvent actionEvent) {
//        System.out.println("from "+getFromStr());
//        System.out.println("path "+getReportPath());
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      
      FResult result=app.persianCataloging_preview_btn();
      if(result!=null){
          if(result.getType().equalsIgnoreCase("error")){
            JSFUtils.addFacesErrorMessage(result.getText());
            }
          else if(result.getType().equalsIgnoreCase("return"))
              
              setReportPath(result.getText());
          }
     

    }

    public void setBookFileInput(RichInputFile bookFileInput) {
        this.bookFileInput = bookFileInput;
    }

    public RichInputFile getBookFileInput() {
        return bookFileInput;
    }

    public void uploadActionListener(ActionEvent actionEvent) {
      InputStream is=null;
    
        try {
       UploadedFile uplodedFile=   (UploadedFile) getBookFileInput().getValue();
     
           if(uplodedFile==null) {
             JSFUtils.addFacesErrorMessage("لطفا یک فایل را انتخاب نمایید.");
             return;
           }
           is=  (uplodedFile).getInputStream();
          AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
            FResult fr=app.book_file_upload(is, uplodedFile.getFilename());
            if(fr!=null) {
              if("error".equals(fr.getType())) {
                JSFUtils.addFacesErrorMessage(fr.getText());
                return;
              }else if("info".equals(fr.getType())) {
              JSFUtils.addFacesInfoMessage(fr.getText());
                return;
              }
            }
      //            isr=new InputStreamReader(is);
      //              br=new BufferedReader(isr);
      //              System.out.println( br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadFileActionListener(FacesContext context, OutputStream out) throws IOException {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult fr=app.book_file_download();
      if(fr!=null) {
        if("error".equals(fr.getText())) {
          JSFUtils.addFacesErrorMessage(fr.getText());
        }else if("return".equals(fr.getText())) {
          InputStream is = (InputStream)fr.getResult();
          byte[] b=new byte[1024];
          int size=0;
          while((size=is.read(b))!=-1)
              out.write(b,0,size);
          
          out.flush();
        }
      }
    }

    public void providerDblClick(ClientEvent clientEvent) {
     System.out.println( provider_mainpage());
      JSFUtils.closePopup("tf");
//      AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
//      adfFacesContext.addPartialTarget(getProviderName());
//      adfFacesContext.addPartialTarget(getProviderBDate());
//      adfFacesContext.addPartialTarget(getProviderForiegnName());
    }


    public void setProviderName(RichInputText providerName) {
        this.providerName = providerName;
    }

    public RichInputText getProviderName() {
        return providerName;
    }

    public void setProviderForiegnName(RichInputText providerForiegnName) {
        this.providerForiegnName = providerForiegnName;
    }

    public RichInputText getProviderForiegnName() {
        return providerForiegnName;
    }

    public void setProviderBDate(RichInputText providerBDate) {
        this.providerBDate = providerBDate;
    }

    public RichInputText getProviderBDate() {
        return providerBDate;
    }

    public void setReadingOrder(int readingOrder) {
        this.readingOrder = readingOrder;
    }

    public int getReadingOrder() {
        return readingOrder;
    }

    public String providerBeforeCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        TemplateViewObject VO = app.getProviderVO1();
      //VO.setAccessMode(ViewObject.SCROLLABLE);
      VO.executeEmptyRowSet();
        return "ok";
    }

  public String providerPersianAfterCreate() {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    ProviderVORowImpl currRow = (ProviderVORowImpl)app.getProviderVO1().getCurrentRow();
    currRow.setReadingOrder(new Number(1));
    currRow.setProviderKind(new Number(1));
    currRow.setReferenceType(new Number(1));
    app.getProviderVO1().setRangeStart(0);
      return null;
  }

  public String providerEnglishAfterCreate() {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    ProviderVORowImpl currRow = (ProviderVORowImpl)app.getProviderVO1().getCurrentRow();
    currRow.setReadingOrder(new Number(2));
    currRow.setProviderKind(new Number(1));
    currRow.setReferenceType(new Number(1));
    app.getProviderVO1().setRangeStart(0);
      return null;
  }

    public void selectProviderQueryLsnr(QueryEvent queryEvent) {
       // providerSetAcssMdRngPg();
      invokeMethodExpression("#{bindings.ProviderVO1Query.processQuery}",
                             Object.class, QueryEvent.class,
                             queryEvent);
   
    }
  private Object invokeMethodExpression(String expr, Class returnType,

                                            Class argType, Object argument) {

          return JSFUtils.invokeMethodExpression(expr, returnType,

                                        new Class[] { argType },

                                        new Object[] { argument });

      }


    public void selectSubjectQryListener(QueryEvent queryEvent) {
     
        invokeMethodExpression("#{bindings.SubjectVO1Query.processQuery}",
                             Object.class, QueryEvent.class,
                             queryEvent);
    }
    
 
  public String subjectBeforeCreate() {
    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      TemplateViewObject VO = app.getSubjectVO1();
   
    VO.executeEmptyRowSet();
      return "ok";
  }


  

    public String subjectPersianAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     SubjectVoRowImpl currRow = (SubjectVoRowImpl)app.getSubjectVO1().getCurrentRow();
     currRow.setReferenceType(new Number(1));
     currRow.setReadingOrder(new Number(1));
      app.getSubjectVO1().setRangeStart(0);
        return null;
    }

    public String subjectEnglishAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      SubjectVoRowImpl currRow = (SubjectVoRowImpl)app.getSubjectVO1().getCurrentRow();
      currRow.setReferenceType(new Number(1));
      currRow.setReadingOrder(new Number(2));
      app.getSubjectVO1().setRangeStart(0);
        return null;
    }

    public String floatSubjectBeforeCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.getFloatSubjectVO1().executeEmptyRowSet();
        return "go";
    }

    public String floatSubjectPersianAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FloatSubjectVORowImpl currRow = (FloatSubjectVORowImpl)app.getFloatSubjectVO1().getCurrentRow();
    currRow.setReadingOrder(new Number(1));
        return null;
    }

    public String floatSubjectEnglishAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FloatSubjectVORowImpl currRow = (FloatSubjectVORowImpl)app.getFloatSubjectVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(2));
        return null;
    }

   

    public String roleBeforeCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     app.getProviderRoleVO1().executeEmptyRowSet();
        return "go";
    }

    public String rolePersianAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      ProviderRoleVORowImpl currRow = (ProviderRoleVORowImpl)app.getProviderRoleVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(1));
        return null;
    }

    public String roleEnglishAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      ProviderRoleVORowImpl currRow = (ProviderRoleVORowImpl)app.getProviderRoleVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(2));
        return null;
    }

    public String uniformTitlePersianAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      UniformTitleVORowImpl currRow = (UniformTitleVORowImpl)app.getUniformTitleVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(1));
      currRow.setReferenceType(new Number(1));
      app.getUniformTitleVO1().setRangeStart(0);
        return null;
    }

    public String uniformTitleEnglishAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      UniformTitleVORowImpl currRow = (UniformTitleVORowImpl)app.getUniformTitleVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(2));
      currRow.setReferenceType(new Number(1));
      app.getUniformTitleVO1().setRangeStart(0);
        return null;
    }

    public String uniformTitleBeforeCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.getUniformTitleVO1().executeEmptyRowSet();
        return "go";
    }

    public String publisherPersianAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      Publisher_PersianVORowImpl currRow = (Publisher_PersianVORowImpl)app.getPublisherVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(1));
      app.getPublisherVO1().setRangeStart(0);
     
        return null;
    }

    public String publisherEnglishAfterCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      Publisher_PersianVORowImpl currRow = (Publisher_PersianVORowImpl)app.getPublisherVO1().getCurrentRow();
      currRow.setReadingOrder(new Number(2));
      app.getPublisherVO1().setRangeStart(0);
        return null;
    }

    public String publisherBeforeCreate() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
   //   app.getPublisherVO1().setAccessMode(ViewObject.SCROLLABLE);
  
      app.getPublisherVO1().executeEmptyRowSet();
        return "go";
    }

  

    public void selectPublisherQryListener(QueryEvent queryEvent) {
     
     // app.getPublisherVO1().setAccessMode(ViewObject.RANGE_PAGING);
      invokeMethodExpression("#{bindings.PublisherVO1Query.processQuery}",
                           Object.class, QueryEvent.class,
                           queryEvent);
    }

    public void removeUniformTitleMainPage(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.removeUniformTitleFromCurrVbook();
    }

    public String selectSubjectAction() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
    FResult fr=  app.select_subject();
    if(fr!=null) {
      if("error".equals(fr.getType())) {
        JSFUtils.addFacesErrorMessage(fr.getText());
        return null;
      }
    }
      return "go";
    }

    public String selectOtherUniformTitleAction() {
       
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
          FResult fr=  app.select_other_uniform_title();
          if(fr!=null) {
            if("error".equals(fr.getType())) {
              JSFUtils.addFacesErrorMessage(fr.getText());
              return null;
            }
          }
            return "go";
    }

  

    public void setReadingOrderFilter() {
      ProviderVOImpl providerVo= (ProviderVOImpl)JSFUtils.getViewFromIterator("ProviderVO1Iterator");
    

//      providerVo.setWhereClause(" Provider.READING_ORDER="+  AdfFacesContext.getCurrentInstance().getPageFlowScope().get("catalogingReadingOrder"));
      

      
            providerVo.setparam_readingOrder(new Number((Long)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("catalogingReadingOrder")));
        
        providerVo.setApplyViewCriteriaName("ReadingOrderVC");
      providerVo.executeQuery();
      
     
    }
}
