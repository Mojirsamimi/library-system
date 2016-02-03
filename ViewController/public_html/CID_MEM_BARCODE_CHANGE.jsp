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
        
        <af:panelHeader text="#{viewcontrollerBundle.mem_barcode_change}"
                        helpTopicId="memBarcodeChange">
           
            <f:facet name="toolbar">
          <af:toolbar id="t1">
                  <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    showcommit="false" showcreate="false"
                                    showdelete="false" showEditCommand="false"
                                    showprevious="true" showquery="false"
                                    showrefresh="false" showrollback="false"
                                    showsearch="false"/>

          </af:toolbar>
          </f:facet>
            <af:panelSplitter id="ps1" splitterPosition="140"
                              orientation="vertical">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}" disclosed="true"
                              value="#{bindings.searchnameidbarcodeQuery.queryDescriptor}"
                              model="#{bindings.searchnameidbarcodeQuery.queryModel}"
                              queryListener="#{viewScope.cid_mem_barcode_change.search_person}"
                              queryOperationListener="#{bindings.searchnameidbarcodeQuery.processQueryOperation}"
                              rows="2" maxColumns="2" saveQueryMode="hidden"
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" layout="vertical"
                                       valign="middle" halign="start">
                    <af:panelFormLayout id="pfl1" rows="6" maxColumns="2"
                                        partialTriggers="qryId1"
                                        fieldWidth="200" labelWidth="100">
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
                                    id="it6" readOnly="true">
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
                      <af:selectOneChoice value="#{bindings.PersStatus1.inputValue}"
                                          label="#{bindings.PersStatus1.label}"
                                          required="#{bindings.PersStatus1.hints.mandatory}"
                                          shortDesc="#{bindings.PersStatus1.hints.tooltip}"
                                          id="soc3" readOnly="true">
                        <f:selectItems value="#{bindings.PersStatus1.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.MemshipCategoryText.inputValue}"
                                    label="#{bindings.MemshipCategoryText.hints.label}"
                                    required="#{bindings.MemshipCategoryText.hints.mandatory}"
                                    columns="#{bindings.MemshipCategoryText.hints.displayWidth}"
                                    maximumLength="#{bindings.MemshipCategoryText.hints.precision}"
                                    shortDesc="#{bindings.MemshipCategoryText.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.MemshipCategoryText.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.DeptName.inputValue}"
                                    label="#{bindings.DeptName.hints.label}"
                                    required="#{bindings.DeptName.hints.mandatory}"
                                    columns="#{bindings.DeptName.hints.displayWidth}"
                                    maximumLength="#{bindings.DeptName.hints.precision}"
                                    shortDesc="#{bindings.DeptName.hints.tooltip}"
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.DeptName.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it7" readOnly="true">
                        <f:validator binding="#{bindings.Id.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Lname.inputValue}"
                                    label="#{bindings.Lname.hints.label}"
                                    required="#{bindings.Lname.hints.mandatory}"
                                    columns="#{bindings.Lname.hints.displayWidth}"
                                    maximumLength="#{bindings.Lname.hints.precision}"
                                    shortDesc="#{bindings.Lname.hints.tooltip}"
                                    id="it8" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.PostText.inputValue}"
                                    label="#{bindings.PostText.hints.label}"
                                    required="#{bindings.PostText.hints.mandatory}"
                                    columns="#{bindings.PostText.hints.displayWidth}"
                                    maximumLength="#{bindings.PostText.hints.precision}"
                                    shortDesc="#{bindings.PostText.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.PostText.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                          label="#{bindings.PersCategory.label}"
                                          required="#{bindings.PersCategory.hints.mandatory}"
                                          shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                          id="soc4" readOnly="true">
                        <f:selectItems value="#{bindings.PersCategory.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:selectOneChoice value="#{bindings.SecArtId1.inputValue}"
                                          label="#{bindings.SecArtId1.label}"
                                          required="#{bindings.SecArtId1.hints.mandatory}"
                                          shortDesc="#{bindings.SecArtId1.hints.tooltip}"
                                          id="soc2" readOnly="true">
                        <f:selectItems value="#{bindings.SecArtId1.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                    </af:panelFormLayout>
                    <af:spacer width="30" height="10" id="s2"/>
                    <af:panelFormLayout id="pfl2">
                      <f:facet name="footer"/>
                      <af:panelLabelAndMessage id="plam1">
                        <af:panelGroupLayout id="pgl3" layout="horizontal">
                          <af:inputText label="#{viewcontrollerBundle.mem_new_barcode}"
                                        id="it2"
                                        value="#{viewScope.cid_mem_barcode_change.persNewBarcode}"
                                        maximumLength="14"/>
                          <af:spacer width="10" height="30" id="s3"/>
                          <af:commandButton text="#{viewcontrollerBundle._U062B_U0628_U062A__U0628_U062}"
                                            id="cb1"
                                            actionListener="#{viewScope.cid_mem_barcode_change.showResultMessage}"
                                            binding="#{viewScope.cid_mem_barcode_change.save_btn}"
                                            partialTriggers="qryId1"
                                            disabled="#{viewScope.cid_mem_barcode_change.save_btn_disable}"/>
                        </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>