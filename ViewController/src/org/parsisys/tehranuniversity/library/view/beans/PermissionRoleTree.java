package org.parsisys.tehranuniversity.library.view.beans;

import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;

import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.adfinternal.view.faces.context.AdfFacesContextImpl;
import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;
import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding.FacesModel;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;

import util.JSFUtils;

import java.util.ArrayList;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserVoImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserVoRowImpl;
import org.parsisys.tehranuniversity.library.util.FResult;
import org.parsisys.tehranuniversity.library.view.viewutils.Shuttle;


public class PermissionRoleTree {
    private RichTree permissionTree;
    private RichOutputText currentMenuArtId;
    private RichSelectManyShuttle shuttle;
    private SelectItem[] selectedIndxs;
    private ArrayList<SelectItem> selectedIndxList;
    private String secCode;
 
  private List selectedItems;
  private List allItems;
  
  private Boolean initialRender;
  private Boolean roleChanged;
  private String userName;
  private String name;
  private String password;
  private String userName_insert;
    private RichTable roleTable;
    private RichSelectManyShuttle usersShuttle;
    private RichTable itemsTable;
private String newPass;
  private String repNewPass;

    public PermissionRoleTree() {
      allItems=new ArrayList();
      
      initialRender=true;
      roleChanged=true;
    }

    public void change_val_boolean(ValueChangeEvent valueChangeEvent) {
        RowKeySet keySet = permissionTree.getSelectedRowKeys();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getClass());

        }
    }

    public void setPermissionTree(RichTree permissionTree) {
        this.permissionTree = permissionTree;
    }

    public RichTree getPermissionTree() {
        return permissionTree;
    }

    public void PermissionChkBxValueChangeListener(ValueChangeEvent valueChangeEvent) {
        
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
        Boolean newValue = (Boolean)valueChangeEvent.getNewValue();

        app.roleAndPermission_CheckChildren((Number)getCurrentMenuArtId().getValue(),
                                            newValue);

        if (newValue == true) {
            app.roleAndPermission_CheckParents((Number)getCurrentMenuArtId().getValue());
        } else {
            app.roleAndPermission_UncheckParents((Number)getCurrentMenuArtId().getValue());
        }

        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getPermissionTree());
    }

    public void setCurrentMenuArtId(RichOutputText currentMenuArtId) {
        this.currentMenuArtId = currentMenuArtId;
    }

    public RichOutputText getCurrentMenuArtId() {
        return currentMenuArtId;
    }

    public String insertRole_fadakbtn() {
        AppModuleImpl app =
            ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

        return "end2";
    }

//    public void processSelection(ActionEvent actionEvent) {
//        BindingContainer bc = this.getBindings();
//        JUCtrlListBinding listBinding =
//            (JUCtrlListBinding)bc.get("LibUserVo1");
//        Object[] str = listBinding.getSelectedValues();
//        for (int i = 0; i < str.length; i++) {
//            System.out.println(str[i]);
//        }
//    }

    public void clearSelection(ActionEvent actionEvent) {
        BindingContainer bc = this.getBindings();
        JUCtrlListBinding listBinding =
            (JUCtrlListBinding)bc.get("LibUserVo1");
        listBinding.clearSelectedIndices();
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setShuttle(RichSelectManyShuttle shuttle) {
        this.shuttle = shuttle;
    }

    public RichSelectManyShuttle getShuttle() {
        return shuttle;
    }

    public void setSelectedIndxs(SelectItem[] selectedIndxs) {
        this.selectedIndxs = selectedIndxs;
    }
    //method referenced from the value property of the Select
    ////Many Shuttle component. Note that a related setter method is
    //contained in this managed bean as well

    public SelectItem[] getSelectedIndxs() {
        ViewObject v=JSFUtils.getViewFromIterator("LibUserVo1Iterator");
        System.out.println(v.getRowCount());
        selectedIndxs = null;
        selectedIndxList = new ArrayList<SelectItem>();
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        
        ////ArrayList<SelectItem>
        
             
//        DCIteratorBinding employeesInDepartmentDciter =
//            (DCIteratorBinding)bindings.get("LibUser_UserRoleVoIterator");
      
//        RowSetIterator rsi = employeesInDepartmentDciter.getRowSetIterator();
      ViewObject vo= JSFUtils.getViewFromIterator("LibUser_UserRoleVoIterator");
      
      RowSetIterator rsi =    vo.createRowSetIterator(null);
        
        
        
        //get access to the "allEmployees" list binding
        JUCtrlListBinding allEmployeesList =
            (JUCtrlListBinding)bindings.get("LibUserVo1");
        DCIteratorBinding allEmployeesIter =
            allEmployeesList.getDCIteratorBinding();
        //while (rsi.hasNext()) 
        while(rsi.hasNext() )
        {
            Row rw = (Row)rsi.next();
            allEmployeesIter.setCurrentRowWithKey(rw.getKey().toStringFormat(true));
            Row indx = allEmployeesIter.getCurrentRow();
            SelectItem si=new SelectItem(indx.getAttribute("UserName"));
            selectedIndxList.add(si);
        }
        selectedIndxs =
                selectedIndxList.toArray(new SelectItem[selectedIndxList.size()]);
        return selectedIndxs;
    }


    public void roleChanged_selectedUser(ValueChangeEvent valueChangeEvent) {
        Integer[] employeesInDepartment =
            (Integer[])valueChangeEvent.getNewValue();
        //get the DepartmentId
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        DCIteratorBinding allDepartmentsIterator =
            (DCIteratorBinding)bindings.get("allDepartmentsIterator");
        //get current row
        Row currentRow = allDepartmentsIterator.getCurrentRow();
        Number departmentId = (Number)currentRow.getAttribute("DepartmentId");
        //compare the selected values in the list and update all rows that //don't yet have the department Id of the selected department
        JUCtrlListBinding allEmployeesList =
            (JUCtrlListBinding)bindings.get("LibUserVo1Iterator");
        DCIteratorBinding allEmployeesIter =
            allEmployeesList.getDCIteratorBinding();
        if (employeesInDepartment.length > 0) {
            for (int index : employeesInDepartment) {
                Row rowToUpdate = allEmployeesIter.getRowAtRangeIndex(index);
                //check if the department Id of the selected employee is the //same as the selected department. If not, update the selected
                //employee record
                if (!((Number)rowToUpdate.getAttribute("DepartmentId")).equals(departmentId)) {
                    rowToUpdate.setAttribute("DepartmentId", departmentId);
                }
            }
            
        }
    }

    public void insertPermissiontoRole(ActionEvent actionEvent) {
      AppModuleImpl app =
          ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
       FResult fr= app.roleAndPermission_insertPermision();
       if(fr!=null) {
         if("info".equalsIgnoreCase(fr.getType())) {
           JSFUtils.addFacesInfoMessage(fr.getText());
         }else if("error".equalsIgnoreCase(fr.getType())) {
           JSFUtils.addFacesErrorMessage(fr.getText());
         }
       }
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public String getSecCode() {
        return secCode;
    }
    
    /////////////////////////////////////////////////////////////
    
    

    public List<SelectItem> getAllDepartments() {
        return Shuttle.getAll("LibUserVo1Iterator", "UserName",
                              "UserName");
    }

    public List getSelectedDepartments() {
        return Shuttle.getSelected("LibUserVo1Iterator",
                                   "UserName");
    }

    
    public  List processSelection(ActionEvent actionEvent) {
    //      BindingContainer bc = this.getBindings();
    //      JUCtrlListBinding listBinding = (JUCtrlListBinding)bc.get("LibUserVo1");
    //      Object[] str = listBinding.getSelectedValues();
    //      for (int i = 0; i < str.length; i++) {
    //          System.out.println(str[i]);
    //      }
    //      return str;
        
      for(int i = 0; i < selectedItems.size(); i++)
      System.out.println( selectedItems.get(i).toString());
        
        return selectedItems;
    }

     


      public void setSelectedItems(List selectedItems) {
          this.selectedItems = selectedItems;
          
          
        List oldSelectedItems = this.selectedItems;
            this.selectedItems = selectedItems;


            BindingContainer bindings = getBindings();
            DCIteratorBinding iterBind = (DCIteratorBinding) bindings.get("LibUser_UserRoleVoIterator");


            for (int newIndex = 0; newIndex < (this.selectedItems == null? 0: this.selectedItems.size()); newIndex++)
            {
              // traverse through all newly selected items and update model only for those items that
              // were not selected earlier and have been recently selected.
              if (oldSelectedItems == null || !oldSelectedItems.contains(this.selectedItems.get(newIndex)))
              {
                RowSetIterator rows = iterBind.getRowSetIterator();
                Row[] newlyAddedRows = rows.findByKey(new Key(new Object[]
                      { null, this.selectedItems.get(newIndex) }), 1);
    //              if (newlyAddedRows != null && newlyAddedRows.length == 1)
    //              {
    //                newlyAddedRows[0].setAttribute("AreAssociated", true);
    //              }
              }
            }


            for (int oldIndex = 0; oldIndex < (oldSelectedItems == null? 0: oldSelectedItems.size()); oldIndex++)
            {
              // traverse through all old items and update model only for those items that
              // were selected earlier and have been recently removed from selected.
              if (this.selectedItems == null || !this.selectedItems.contains(oldSelectedItems.get(oldIndex)))
              {
                RowSetIterator rows = iterBind.getRowSetIterator();
                Row[] justRemovedRows = rows.findByKey(new Key(new Object[]
                      { null, oldSelectedItems.get(oldIndex) }), 1);
    //              if (justRemovedRows != null && justRemovedRows.length == 1)
    //              {
    //                justRemovedRows[0].setAttribute("AreAssociated", false);
    //              }
              }
            }
          }
          
      

      public List getSelectedItems() {
          if(roleChanged==true)
          {
       
        if (selectedItems == null)
          {
              selectedItems = new ArrayList();
          }
          else
          {
            selectedItems.clear();
          }


          // get all selected items based on the master-detail association available in the intersection table.
          BindingContainer bindings = getBindings();
          DCIteratorBinding iterBind = (DCIteratorBinding) bindings.get("LibUserVo2Iterator");
         iterBind.executeQuery();
          Row[] rows = iterBind.getAllRowsInRange();
          for (int index = 0; index < (rows == null? 0: rows.length); index++)
          {
           // if ((Boolean) rows[index].getAttribute("AreAssociated"))
           // {
            
              selectedItems.add( rows[index].getAttribute("UserName"));
           // }
          }
         roleChanged=false;
          }
       
          return selectedItems;
      }

      public void setAllItems(List allItems) {
          this.allItems = allItems;
      }





      public List getAllItems() {
      if(initialRender==true)
      {
          allItems.clear();
       
       // ViewObject libUser=JSFUtils.getViewFromIterator("LibUserVo1Iterator");
       AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
            ArrayList<String> libUser = app.roleAndPermission_getAllUsersItem();
       
           
            for(String temp:libUser) {
           
         allItems.add(new SelectItem(temp));
            
        }
        initialRender=false;
      }
          return allItems;
      }

      public void setInitialRender(Boolean initialRender) {
          this.initialRender = initialRender;
      }

      public Boolean getInitialRender() {
          return initialRender;
      }

      public void setUserName(String userName) {
          this.userName = userName;
      }

      public String getUserName() {
          return userName;
      }

      public void searchUserName(ActionEvent actionEvent) {
        AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
        LibUserVoImpl libUser = (LibUserVoImpl)app.getLibUserVo1();
        String user=getUserName();
        if(user!=null && !"".equals(user))
        {
        libUser.setuserNameParam(user);
        libUser.setApplyViewCriteriaName("UserNameStartWith_LibUserVoCriteria");
        libUser.executeQuery();
         
        int i=0;
        String temp="";

        while(libUser.hasNext()) {
            temp=(String)libUser.next().getAttribute("UserName");
          
        i=findIndexOfAllItems(temp);
            if(i!=-1)
         allItems.add(0,  allItems.remove(i) );
            
        }
          libUser.setApplyViewCriteriaName("Labcol_LibUserVoCriteria");
        }else {
          libUser.setApplyViewCriteriaName("Labcol_LibUserVoCriteria");
            libUser.executeQuery();
            initialRender=true;
            getAllItems();
        }

      }
      
      private int findIndexOfAllItems(Object o) {
       
       
        for(int j=allItems.size()-1;j>=0;j--) {
          if(((SelectItem)allItems.get(j)).getValue().equals(o))
              return j;
        }
        return -1;
      }
      
     

      public void showAllUserName(ActionEvent actionEvent) {
          for(Object si:selectedItems) {
            System.out.println(si);
          }
          System.out.println(allItems.size());
      }


      public void roleTableSelectionListener(SelectionEvent selectionEvent) {
       
        invokeMethodExpression("#{bindings.LibRoleVO11.collectionModel.makeCurrent}",

                                        Object.class, SelectionEvent.class, selectionEvent);
        
        roleChanged=true;
     AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
     
     app.roleAndPermission_initAccessTree();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getPermissionTree());
        adfFacesContext.addPartialTarget(getItemsTable());
    
      }
      
    private Object invokeMethodExpression(String expr, Class returnType,

                                              Class argType, Object argument) {

            return JSFUtils.invokeMethodExpression(expr, returnType,

                                          new Class[] { argType },

                                          new Object[] { argument });

        }

      public void setRoleChanged(Boolean roleChanged) {
          this.roleChanged = roleChanged;
      }

      public Boolean getRoleChanged() {
          return roleChanged;
      }

      public void setName(String name) {
          this.name = name;
      }

      public String getName() {
          return name;
      }

      public void setPassword(String password) {
          this.password = password;
      }

      public String getPassword() {
          return password;
      }

      public void setUserName_insert(String userName_insert) {
          this.userName_insert = userName_insert;
      }

      public String getUserName_insert() {
          return userName_insert;
      }

      public void saveNewUser(ActionEvent actionEvent) {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
        FResult result= app.roleAndPermission_insertUser(getName(),getUserName_insert(), getPassword());
 if("info".equalsIgnoreCase(result.getType()))
          {
          JSFUtils.addFacesInfoMessage(result.getText());
            allItems.add(0,new SelectItem(getUserName_insert()));
            //selectedItems.add(getUserName_insert());
            setName("");
            setPassword("");
            setUserName_insert("");           
            AdfFacesContext.getCurrentInstance().addPartialTarget(getUsersShuttle());
            
           
          }else if("error".equalsIgnoreCase(result.getType())) {
   JSFUtils.addFacesErrorMessage(result.getText());
  
 }
     
      }
    public void saveNewUser_Role(ActionEvent actionEvent) {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
      FResult result= app.roleAndPermission_insertUserList_role(selectedItems);
        if("info".equalsIgnoreCase(result.getType()))
        {
        JSFUtils.addFacesInfoMessage(result.getText());
          
        }
    }

      public String cb1_action() {
          BindingContainer bindings = getBindings();
          OperationBinding operationBinding = bindings.getOperationBinding("roleAndPermission_insertUser");
          Object result = operationBinding.execute();
          if (!operationBinding.getErrors().isEmpty()) {
              return null;
          }
          return null;
      }

    public void setRoleTable(RichTable roleTable) {
        this.roleTable = roleTable;
    }

    public RichTable getRoleTable() {
//      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
//      app.roleAndPermission_initAccessTreeForFirst();
//         AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
//         adfFacesContext.addPartialTarget(getPermissionTree());
        return roleTable;
    }

    public void setUsersShuttle(RichSelectManyShuttle usersShuttle) {
        this.usersShuttle = usersShuttle;
    }

    public RichSelectManyShuttle getUsersShuttle() {
        return usersShuttle;
    }

    public void setItemsTable(RichTable itemsTable) {
        this.itemsTable = itemsTable;
    }

    public RichTable getItemsTable() {
        return itemsTable;
    }

    public void roleDblClick(ClientEvent clientEvent) {
       System.out.println("double click...");
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setRepNewPass(String repNewPass) {
        this.repNewPass = repNewPass;
    }

    public String getRepNewPass() {
        return repNewPass;
    }

    public String saveNewPass() {
        AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));

        FResult fResult = app.rolePermission_changePassword(getNewPass(), getRepNewPass());
        
      if(fResult!=null) {
        if("error".equalsIgnoreCase(fResult.getType())) {
          JSFUtils.addFacesErrorMessage(fResult.getText());
        }  else  if("info".equalsIgnoreCase(fResult.getType())) {
          JSFUtils.addFacesInfoMessage(fResult.getText());
        }
      }
        return null;
    }

    public String preChangePass() {
      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl"));
  FResult fResult = app.rolePermission_checkNullUser();
    
      
      if(fResult!=null) {
      if("error".equalsIgnoreCase(fResult.getType())) {
        JSFUtils.addFacesErrorMessage(fResult.getText());
        return null;
      }
      }
      setNewPass("");
      setRepNewPass("");
      JSFUtils.showPopup("pt1:passPopUp");
        return null;
    }
}
