package org.parsisys.tehranuniversity.library.view.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import org.parsisys.tehranuniversity.library.model.am.AppModuleImpl;
import org.parsisys.tehranuniversity.library.model.vo.CommonVOs.LibUserVoImpl;
import org.parsisys.tehranuniversity.library.util.FResult;
import org.parsisys.tehranuniversity.library.view.viewutils.Shuttle;

import util.JSFUtils;

public class RolePermissionUserShuttle {
  private RichSelectManyShuttle shuttle;
  private List selectedItems;
  private List allItems;
  
  private Boolean initialRender;
  private Boolean roleChanged;
  private String userName;
  private String name;
  private String password;
  private String userName_insert;

    public RolePermissionUserShuttle() {
        super();
      allItems=new ArrayList();
    
      initialRender=true;
      roleChanged=true;
    }
    
//  public BindingContainer getBindings() {
//      return BindingContext.getCurrent().getCurrentBindingsEntry();
//  }
//
//  public List<SelectItem> getAllDepartments() {
//      return Shuttle.getAll("LibUserVo1Iterator", "UserName",
//                            "UserName");
//  }
//
//  public List getSelectedDepartments() {
//      return Shuttle.getSelected("LibUserVo1Iterator",
//                                 "UserName");
//  }
//
// 
//  public  List processSelection(ActionEvent actionEvent) {
////      BindingContainer bc = this.getBindings();
////      JUCtrlListBinding listBinding = (JUCtrlListBinding)bc.get("LibUserVo1");
////      Object[] str = listBinding.getSelectedValues();
////      for (int i = 0; i < str.length; i++) {
////          System.out.println(str[i]);
////      }
////      return str;
//      
//    for(int i = 0; i < selectedItems.size(); i++)
//    System.out.println( selectedItems.get(i).toString());
//      
//      return selectedItems;
//  }
//
//    public void setShuttle(RichSelectManyShuttle shuttle) {
//        
//        this.shuttle = shuttle;
//    }
//
//    public RichSelectManyShuttle getShuttle() {
//        return shuttle;
//    }
//
//
//    public void setSelectedItems(List selectedItems) {
//        this.selectedItems = selectedItems;
//        
//        
//      List oldSelectedItems = this.selectedItems;
//          this.selectedItems = selectedItems;
//
//
//          BindingContainer bindings = getBindings();
//          DCIteratorBinding iterBind = (DCIteratorBinding) bindings.get("LibUser_UserRoleVoIterator");
//
//
//          for (int newIndex = 0; newIndex < (this.selectedItems == null? 0: this.selectedItems.size()); newIndex++)
//          {
//            // traverse through all newly selected items and update model only for those items that
//            // were not selected earlier and have been recently selected.
//            if (oldSelectedItems == null || !oldSelectedItems.contains(this.selectedItems.get(newIndex)))
//            {
//              RowSetIterator rows = iterBind.getRowSetIterator();
//              Row[] newlyAddedRows = rows.findByKey(new Key(new Object[]
//                    { null, this.selectedItems.get(newIndex) }), 1);
////              if (newlyAddedRows != null && newlyAddedRows.length == 1)
////              {
////                newlyAddedRows[0].setAttribute("AreAssociated", true);
////              }
//            }
//          }
//
//
//          for (int oldIndex = 0; oldIndex < (oldSelectedItems == null? 0: oldSelectedItems.size()); oldIndex++)
//          {
//            // traverse through all old items and update model only for those items that
//            // were selected earlier and have been recently removed from selected.
//            if (this.selectedItems == null || !this.selectedItems.contains(oldSelectedItems.get(oldIndex)))
//            {
//              RowSetIterator rows = iterBind.getRowSetIterator();
//              Row[] justRemovedRows = rows.findByKey(new Key(new Object[]
//                    { null, oldSelectedItems.get(oldIndex) }), 1);
////              if (justRemovedRows != null && justRemovedRows.length == 1)
////              {
////                justRemovedRows[0].setAttribute("AreAssociated", false);
////              }
//            }
//          }
//        }
//        
//    
//
//    public List getSelectedItems() {
//        if(roleChanged==true)
//        {
//     
//      if (selectedItems == null)
//        {
//            selectedItems = new ArrayList();
//        }
//        else
//        {
//          selectedItems.clear();
//        }
//
//
//        // get all selected items based on the master-detail association available in the intersection table.
//        BindingContainer bindings = getBindings();
//        DCIteratorBinding iterBind = (DCIteratorBinding) bindings.get("LibUserVo2Iterator");
//        Row[] rows = iterBind.getAllRowsInRange();
//        for (int index = 0; index < (rows == null? 0: rows.length); index++)
//        {
//         // if ((Boolean) rows[index].getAttribute("AreAssociated"))
//         // {
//            selectedItems.add( rows[index].getAttribute("UserName"));
//         // }
//        }
//       roleChanged=false;
//        }
//     
//        return selectedItems;
//    }
//
//    public void setAllItems(List allItems) {
//        this.allItems = allItems;
//    }
//
//
//
//
//
//    public List getAllItems() {
//    if(initialRender==true)
//    {
//        allItems.clear();
//      ViewObject libUser=JSFUtils.getViewFromIterator("LibUserVo1Iterator");
//      String temp="";
//      while(libUser.hasNext()) {
//          temp=(String) libUser.next().getAttribute("UserName");
//       allItems.add(new SelectItem(temp));
//          
//      }
//      initialRender=false;
//    }
//        return allItems;
//    }
//
//    public void setInitialRender(Boolean initialRender) {
//        this.initialRender = initialRender;
//    }
//
//    public Boolean getInitialRender() {
//        return initialRender;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void searchUserName(ActionEvent actionEvent) {
//      LibUserVoImpl libUser=(LibUserVoImpl)JSFUtils.getViewFromIterator("LibUserVo1Iterator");
//      String user=getUserName();
//      if(user!=null && !"".equalsIgnoreCase(user))
//      {
//      libUser.setuserNameParam(user);
//      libUser.setApplyViewCriteriaName("LibUserVo_UserNameCriteria");
//      libUser.executeQuery();
//       
//      int i=0;
//      String temp="";
//
//      while(libUser.hasNext()) {
//          temp=(String)libUser.next().getAttribute("UserName");
//        
//      i=findIndexOfAllItems(temp);
//          if(i!=-1)
//       allItems.add(0,  allItems.remove(i) );
//      }
//      }else {
//        libUser.removeApplyViewCriteriaName("LibUserVo_UserNameCriteria");
//          libUser.executeQuery();
//          initialRender=true;
//          getAllItems();
//      }
//
//    }
//    
//    private int findIndexOfAllItems(Object o) {
//     
//     
//      for(int j=allItems.size()-1;j>=0;j--) {
//        if(((SelectItem)allItems.get(j)).getValue().equals(o))
//            return j;
//      }
//      return -1;
//    }
//    
//   
//
//    public void showAllUserName(ActionEvent actionEvent) {
//        for(Object si:selectedItems) {
//          System.out.println(si);
//        }
//        System.out.println(allItems.size());
//    }
//
//
//    public void roleTableSelectionListener(SelectionEvent selectionEvent) {
//     
//      invokeMethodExpression("#{bindings.LibRoleVO11.collectionModel.makeCurrent}",
//
//                                      Object.class, SelectionEvent.class, selectionEvent);
//      
//      roleChanged=true;
//   AppModuleImpl app = (AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
//   
//   app.roleAndPermission_initAccessTree();
//      AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
//     // adfFacesContext.addPartialTarget(getPermissionTree());
//  
//    }
//    
//  private Object invokeMethodExpression(String expr, Class returnType,
//
//                                            Class argType, Object argument) {
//
//          return JSFUtils.invokeMethodExpression(expr, returnType,
//
//                                        new Class[] { argType },
//
//                                        new Object[] { argument });
//
//      }
//
//    public void setRoleChanged(Boolean roleChanged) {
//        this.roleChanged = roleChanged;
//    }
//
//    public Boolean getRoleChanged() {
//        return roleChanged;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setUserName_insert(String userName_insert) {
//        this.userName_insert = userName_insert;
//    }
//
//    public String getUserName_insert() {
//        return userName_insert;
//    }
//
//    public String saveNewUser(ActionEvent actionEvent) {
//      AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
//      FResult result= app.roleAndPermission_insertUser(getName(),getUserName_insert(), getPassword());
//
////        BindingContainer bindings = getBindings();
////        OperationBinding operationBinding = bindings.getOperationBinding("roleAndPermission_insertUser");
////        FResult result = (FResult)operationBinding.execute();
//        
//
//        if("info".equalsIgnoreCase(result.getType()))
//        {
//        JSFUtils.addFacesErrorMessage(result.getText());
//          
//        }
//        setName("");
//        setPassword("");
//        setUserName_insert("");
//        return null;
//    }
//  public void saveNewUser_Role(ActionEvent actionEvent) {
//    AppModuleImpl app= ((AppModuleImpl)JSFUtils.getApplicationModuleForDataControl("AppModuleDataControl")); 
//    FResult result= app.roleAndPermission_insertUserList_role(selectedItems);
//      if("info".equalsIgnoreCase(result.getType()))
//      {
//      JSFUtils.addFacesErrorMessage(result.getText());
//        
//      }
//  }
//
//    public String cb1_action() {
//        BindingContainer bindings = getBindings();
//        OperationBinding operationBinding = bindings.getOperationBinding("roleAndPermission_insertUser");
//        Object result = operationBinding.execute();
//        if (!operationBinding.getErrors().isEmpty()) {
//            return null;
//        }
//        return null;
//    }
}
