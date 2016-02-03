<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
       ${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="#{viewcontrollerBundle.cid_extend}"
         helpTopicId="extend">
            <f:facet name="toolbar">
          <af:toolbar id="t1">
                  <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    after_next="#{viewScope.cid_extend.afterNext_fadak}"
                                    after_previous="#{viewScope.cid_extend.afterPrevious_fadak}"
                                    showcommit="false" showcreate="false"
                                    showdelete="false" showEditCommand="false"
                                    showquery="false" showrefresh="false"
                                    showrollback="false"/>
                
              </af:toolbar>
          </f:facet>
            <af:panelSplitter id="ps1" splitterPosition="105"
                              orientation="vertical">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}"
                              disclosed="true"
                              value="#{bindings.searchbarcodeVCQuery.queryDescriptor}"
                              model="#{bindings.searchbarcodeVCQuery.queryModel}"
                             queryListener="#{viewScope.cid_extend.preSearchPerson}"
                            queryOperationListener="#{bindings.searchbarcodeVCQuery.processQueryOperation}"
                              rows="1" maxColumns="1"  saveQueryMode="hidden"
                                
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout layout="vertical" id="pgl2"
                                       partialTriggers="qryId1" valign="middle"
                                       halign="start">
                    <af:panelFormLayout id="pfl1" rows="6" maxColumns="2">
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Fname.inputValue}"
                                    label="#{bindings.Fname.hints.label}"
                                    required="#{bindings.Fname.hints.mandatory}"
                                    columns="#{bindings.Fname.hints.displayWidth}"
                                    maximumLength="#{bindings.Fname.hints.precision}"
                                    shortDesc="#{bindings.Fname.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.Fname.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                          label="#{bindings.PersType.label}"
                                          required="#{bindings.PersType.hints.mandatory}"
                                          shortDesc="#{bindings.PersType.hints.tooltip}"
                                          id="soc1" readOnly="true">
                        <f:selectItems value="#{bindings.PersType.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                      <af:selectOneChoice value="#{bindings.MemshipStatus.inputValue}"
                                          label="#{bindings.MemshipStatus.label}"
                                          required="#{bindings.MemshipStatus.hints.mandatory}"
                                          shortDesc="#{bindings.MemshipStatus.hints.tooltip}"
                                          id="soc2" readOnly="true">
                        <f:selectItems value="#{bindings.MemshipStatus.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                      <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                          label="#{bindings.PersCategory.label}"
                                          required="#{bindings.PersCategory.hints.mandatory}"
                                          shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                          id="soc3" readOnly="true">
                        <f:selectItems value="#{bindings.PersCategory.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.StartDate.inputValue}"
                                    label="#{bindings.StartDate.hints.label}"
                                    required="#{bindings.StartDate.hints.mandatory}"
                                    columns="#{bindings.StartDate.hints.displayWidth}"
                                    maximumLength="#{bindings.StartDate.hints.precision}"
                                    shortDesc="#{bindings.StartDate.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.StartDate.validator}"/>
                      </af:inputText>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:inputText value="#{bindings.Lname.inputValue}"
                                    label="#{bindings.Lname.hints.label}"
                                    required="#{bindings.Lname.hints.mandatory}"
                                    columns="#{bindings.Lname.hints.displayWidth}"
                                    maximumLength="#{bindings.Lname.hints.precision}"
                                    shortDesc="#{bindings.Lname.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.MemshipCategoryText.inputValue}"
                                    label="#{bindings.MemshipCategoryText.hints.label}"
                                    required="#{bindings.MemshipCategoryText.hints.mandatory}"
                                    columns="#{bindings.MemshipCategoryText.hints.displayWidth}"
                                    maximumLength="#{bindings.MemshipCategoryText.hints.precision}"
                                    shortDesc="#{bindings.MemshipCategoryText.hints.tooltip}"
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.MemshipCategoryText.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="30" id="s2"/>
                    <af:panelFormLayout id="pfl2" rows="2" maxColumns="3"
                                        labelWidth="100">
                      <af:inputText value="#{bindings.PostText.inputValue}"
                                    label="#{bindings.PostText.hints.label}"
                                    required="#{bindings.PostText.hints.mandatory}"
                                    columns="#{bindings.PostText.hints.displayWidth}"
                                    maximumLength="#{bindings.PostText.hints.precision}"
                                    shortDesc="#{bindings.PostText.hints.tooltip}"
                                    id="it6" readOnly="true">
                        <f:validator binding="#{bindings.PostText.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.EndDate.inputValue}"
                                    label="#{bindings.EndDate.hints.label}"
                                    required="#{bindings.EndDate.hints.mandatory}"
                                    columns="#{bindings.EndDate.hints.displayWidth}"
                                    maximumLength="#{bindings.EndDate.hints.precision}"
                                    shortDesc="#{bindings.EndDate.hints.tooltip}"
                                    id="it8" readOnly="true">
                        <f:validator binding="#{bindings.EndDate.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.CmemSetupPost.inputValue}"
                                          label="سمت جدید"
                                          
                                          required="#{bindings.CmemSetupPost.hints.mandatory}"
                                          shortDesc="#{bindings.CmemSetupPost.hints.tooltip}"
                                          id="soc4" autoSubmit="true"
                                          valueChangeListener="#{viewScope.cid_extend.post_changed}"
                                          binding="#{viewScope.cid_extend.newPostSOC}">
                        <f:selectItems value="#{bindings.CmemSetupPost.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.NewEndDate.inputValue}"
                                    label="تاریخ خاتمه جدید"
                                    required="#{bindings.NewEndDate.hints.mandatory}"
                                    columns="#{bindings.NewEndDate.hints.displayWidth}"
                                    maximumLength="#{bindings.NewEndDate.hints.precision}"
                                    shortDesc="#{bindings.NewEndDate.hints.tooltip}"
                                    id="it7" partialTriggers="soc4"
                                    binding="#{viewScope.cid_extend.inputtext_newEndDate}"
                                    readOnly="true">
                        <f:validator binding="#{bindings.NewEndDate.validator}"/>
                      </af:inputText>
                      <af:commandButton text="#{viewcontrollerBundle.create}"
                                        id="cb1"
                                        disabled="true"
                                        actionListener="#{viewScope.cid_extend.save_btn_action_listener}"
                                        binding="#{viewScope.cid_extend.save_button}"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        
        </f:facet>
        <f:facet name="popup">
        <af:popup id="p1">
            <af:panelWindow id="pw1">
              <af:panelFormLayout id="pfl6">
                <f:facet name="footer">
                  <h:panelGroup id="pg1">
                    <af:commandButton text="بلی" id="cb3"
                                     actionListener="#{viewScope.cid_extend.popUpYes_btn}"/>
                    <af:commandButton text="خیر" id="cb4"/>
                  </h:panelGroup>
                </f:facet>
                <af:outputText id="ot1"
                               value="#{viewScope.cid_extend.popUpText}"/>
                <af:spacer width="10" height="20" id="s3"/>
              </af:panelFormLayout>
            </af:panelWindow>
          </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>
<%-- 
  oracle-jdev-comment:preferred-managed-bean-name:cid_extend
--%>