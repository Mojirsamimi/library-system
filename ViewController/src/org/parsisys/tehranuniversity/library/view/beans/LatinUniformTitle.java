package org.parsisys.tehranuniversity.library.view.beans;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.util.FResult;

import util.JSFUtils;

public class LatinUniformTitle {
    
  private String uniTitleText;
  private String uniTitleText_also;
  private String uniTitleText_main;
  private String uniTitleText_also_main;
  private String path;
    private String tab;
    public LatinUniformTitle() {
        super();
    }

    public void setUniTitleText(String uniTitleText) {
        this.uniTitleText = uniTitleText;
    }

    public String getUniTitleText() {
        return uniTitleText;
    }

    public void setUniTitleText_also(String uniTitleText_also) {
        this.uniTitleText_also = uniTitleText_also;
    }

    public String getUniTitleText_also() {
        return uniTitleText_also;
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

    public void setPath(String path) {
        this.path = path;
        System.out.println("set "+path);
    }

    public String getPath() {
        System.out.println("get "+path);
        return path;
    }

    public String insert_latinUniTitle_Main() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
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

    public String insert_latinUniTitle_sub() {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      FResult result =
          (FResult)app.persianUniformTitle_insert(getUniTitleText(),"en");
      if (result != null) {
          if (result.getType().equalsIgnoreCase("error")) {
              JSFUtils.addFacesErrorMessage(result.getText());
          }
      }
      setUniTitleText(null);
      return "go";
      
    }

    public String insert_latinUnititle_alsoMain() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

                FResult result =
            (FResult)app.persianUniformTitle_insertAlsoMainUniTitle(getUniTitleText_also_main(),"en");


        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }
        setUniTitleText_also_main(null);
        return "go";
    }

    public String insert_latinUniTitle_alsoSub() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        FResult result =
            (FResult)app.persianUniformTitle_insertSeeAlsoUniTitle(getUniTitleText_also(),"en");


        if (result != null) {
            if (result.getType().equalsIgnoreCase("error")) {
                JSFUtils.addFacesErrorMessage(result.getText());
            }
        }
        setUniTitleText_also(null);
        return "go";
    }
  public BindingContainer getBindings() {
      return BindingContext.getCurrent().getCurrentBindingsEntry();
  }
    public String seeUniTitleCreateInsert() {
    
          BindingContainer bindings = getBindings();
          OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
          Object result = operationBinding.execute();
          if (!operationBinding.getErrors().isEmpty()) {
              JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
              return null;
          }
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

      app.ref_init_MainSeeUniTitle(new Number(2), new Number(2));
          return null;
      
    }
    
  public String seeAlsoUniTitleCreateInsert() {
  
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("ایجاد رکورد جدید با خطا مواجه شد.");
            return null;
        }
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

    app.ref_init_MainSeeUniTitle(new Number(2), new Number(1));
        return null;
    
  }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }
  public String removeSeeUniTitleAction() {
    AppModuleImpl app =
        ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
   FResult fr= app.uniformTitle_remove_detail("latin see");
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
   FResult fr= app.uniformTitle_remove_detail("latin see also");
   if(fr!=null) {
     if("info".equals(fr.getType())) {
       JSFUtils.addFacesInfoMessage(fr.getText());
     }else if("error".equals(fr.getType())) {
       JSFUtils.addFacesErrorMessage(fr.getText());
     }
   }
      return null;
  }

    public void initUniTitleReadingOrder(ActionEvent actionEvent) {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
      app.ref_uniTitle_apply_readingOrderVC(new Number(2));
    }

    public String selectLatinUniTitle() {
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

    public String latinUniTitleAfterCreate() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        app.ref_uniformTitle_afterCreate(new Number(2),new Number(1));
        return null;
    }
}
