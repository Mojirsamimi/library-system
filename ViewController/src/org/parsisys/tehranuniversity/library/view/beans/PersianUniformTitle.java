package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.event.DisclosureEvent;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class PersianUniformTitle {

    private String uniTitleText;
    private String uniTitleText_also;
  private String uniTitleText_main;
  private String uniTitleText_also_main;
  private String path;
  private String tab;
   

    public PersianUniformTitle() {
    }


    public String insert_uniTitle() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

        // String newUniTitle=(String)  JSFUtils.getCurrentRow("SeeUniformTitle1Iterator").getAttribute("Title");
        FResult result =
            (FResult)app.persianUniformTitle_insert(getUniTitleText(),"fa");


        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }
        setUniTitleText(null);
        return "go";
    }

    public void setUniTitleText(String uniTitleText) {
        this.uniTitleText = uniTitleText;
    }

    public String getUniTitleText() {
        return uniTitleText;
    }

    public void uniformTitle_insert(ActionEvent actionEvent) {

    }

    public void setUniTitleText_also(String uniTitleText_also) {
        this.uniTitleText_also = uniTitleText_also;
    }

    public String getUniTitleText_also() {
        return uniTitleText_also;
    }

    public String insert_uniTitle_also() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

        // String newUniTitle=(String)  JSFUtils.getCurrentRow("SeeUniformTitle1Iterator").getAttribute("Title");
        FResult result =
            (FResult)app.persianUniformTitle_insertSeeAlsoUniTitle(getUniTitleText_also(),"fa");


        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }
        setUniTitleText_also(null);
        return "go";
    }

    public void setPath(String path) {
        this.path = path;
      }

    public String getPath() {
              return path;
    }

    public String inser_unititle_main() {
       
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

      // String newUniTitle=(String)  JSFUtils.getCurrentRow("SeeUniformTitle1Iterator").getAttribute("Title");
      FResult result =
          (FResult)app.persianUniformTitle_insertMainSeeUniformTitle(getUniTitleText_main(),"fa");


      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }
      }
      setUniTitleText_main(null);
      return "go";
    }

    public void setUniTitleText_main(String uniTitleText_main) {
        this.uniTitleText_main = uniTitleText_main;
    }

    public String getUniTitleText_main() {
        return uniTitleText_main;
    }

    public void setUniTitleText_also_main(String uniTitleText_also_main) {
        this.uniTitleText_also_main = uniTitleText_also_main;
    }

    public String getUniTitleText_also_main() {
        return uniTitleText_also_main;
    }

    public String insert_unititle_also_main() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

      // String newUniTitle=(String)  JSFUtils.getCurrentRow("SeeUniformTitle1Iterator").getAttribute("Title");
      FResult result =
          (FResult)app.persianUniformTitle_insertAlsoMainUniTitle(getUniTitleText_also_main(),"fa");


      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }
      }
      setUniTitleText_main(null);
      return "go";
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String createInsertPersianMainSeeUni() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
            return null;
        }
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

app.ref_init_MainSeeUniTitle(new Number(1), new Number(2));
        return null;
    }
  public String createInsertPersianMainSeeAlsoUni() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
      Object result = operationBinding.execute();
      if (!operationBinding.getErrors().isEmpty()) {
          JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
          return null;
      }
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

  app.ref_init_MainSeeUniTitle(new Number(1), new Number(1));
      return null;
  }

    public String selectPersianUniTitle() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

FResult fr= app.uniformTitle_insert_detail(getTab());
if(fr!=null) {
  if("error".equals(fr.getType())) {
    JSFUtils.addFacesErrorMessage(fr.getText());
    return null;
  }
}
        return "end";
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }


    public String persianUniTitleAfterCreate() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
app.ref_uniformTitle_afterCreate(new Number(1),new Number(1));
        return null;
    }

    public String removeSeeUniTitleAction() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
     FResult fr= app.uniformTitle_remove_detail("see");
     if(fr!=null) {
       if("info".equals(fr.getType())) {
         JSFUtils.addFacesInfoMessage(fr.getText());
       }else if("error".equals(fr.getType())) {
         JSFUtils.addFacesErrorMessage(fr.getText());
       }
     }
        return null;
    }
  public String removeSeeAlsoUniTitleAction() {
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
   FResult fr= app.uniformTitle_remove_detail("see also");
   if(fr!=null) {
     if("info".equals(fr.getType())) {
       JSFUtils.addFacesInfoMessage(fr.getText());
     }else if("error".equals(fr.getType())) {
       JSFUtils.addFacesErrorMessage(fr.getText());
     }
   }
      return null;
  }


    public void initParamReadingOrderActionListener(ActionEvent actionEvent) {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_uniTitle_apply_readingOrderVC(new Number(1));
    }


    public void popupCancelListener(PopupCanceledEvent popupCanceledEvent) {
      FacesContext fctx = FacesContext.getCurrentInstance();
        UIViewRoot root = fctx.getViewRoot();
        //client Id of button includes naming container like id of region.
        RichCommandButton button =
                (RichCommandButton) root.findComponent("pt1:r1:1:pc1:cb3");
        ActionEvent actionEvent = new ActionEvent(button);
        actionEvent.queue();
    }
}
