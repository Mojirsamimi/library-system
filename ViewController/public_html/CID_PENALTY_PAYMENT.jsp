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
        <af:panelHeader text="#{viewcontrollerBundle.payment}">
         <f:facet name="toolbar">
          <af:toolbar id="t1">
                
                <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    disabled_delete="true"
                                    disabled_create="true" showcreate="false"
                                    showdelete="false"/>

          </af:toolbar>
          
        
          </f:facet>
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="150">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}" disclosed="true"
                              value="#{bindings.searchnameidbarcodeQuery.queryDescriptor}"
                              model="#{bindings.searchnameidbarcodeQuery.queryModel}"
                              queryListener="#{bindings.searchnameidbarcodeQuery.processQuery}"
                              queryOperationListener="#{bindings.searchnameidbarcodeQuery.processQueryOperation}"
                              rows="2" maxColumns="2"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelGroupLayout id="pgl2" layout="vertical"
                                     valign="middle" halign="center"
                                     partialTriggers="qryId1">
                  <af:panelFormLayout id="pfl1" rows="1">
                    <af:inputText value="#{bindings.Barcode.inputValue}"
                                  label="#{bindings.Barcode.hints.label}"
                                  required="#{bindings.Barcode.hints.mandatory}"
                                  columns="#{bindings.Barcode.hints.displayWidth}"
                                  maximumLength="#{bindings.Barcode.hints.precision}"
                                  shortDesc="#{bindings.Barcode.hints.tooltip}"
                                  id="it1" readOnly="true">
                      <f:validator binding="#{bindings.Barcode.validator}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.Id.inputValue}"
                                  label="#{bindings.Id.hints.label}"
                                  required="#{bindings.Id.hints.mandatory}"
                                  columns="#{bindings.Id.hints.displayWidth}"
                                  maximumLength="#{bindings.Id.hints.precision}"
                                  shortDesc="#{bindings.Id.hints.tooltip}"
                                  id="it2" readOnly="true">
                      <f:validator binding="#{bindings.Id.validator}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.Fname.inputValue}"
                                  label="#{bindings.Fname.hints.label}"
                                  required="#{bindings.Fname.hints.mandatory}"
                                  columns="#{bindings.Fname.hints.displayWidth}"
                                  maximumLength="#{bindings.Fname.hints.precision}"
                                  shortDesc="#{bindings.Fname.hints.tooltip}"
                                  id="it3" readOnly="true">
                      <f:validator binding="#{bindings.Fname.validator}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.Lname.inputValue}"
                                  label="#{bindings.Lname.hints.label}"
                                  required="#{bindings.Lname.hints.mandatory}"
                                  columns="#{bindings.Lname.hints.displayWidth}"
                                  maximumLength="#{bindings.Lname.hints.precision}"
                                  shortDesc="#{bindings.Lname.hints.tooltip}"
                                  id="it4"  readOnly="true">
                      <f:validator binding="#{bindings.Lname.validator}"/>
                    </af:inputText>
                    <af:selectOneChoice value="#{bindings.MemshipStatus.inputValue}"
                                        label="#{bindings.MemshipStatus.label}"
                                        required="#{bindings.MemshipStatus.hints.mandatory}"
                                        shortDesc="#{bindings.MemshipStatus.hints.tooltip}"
                                        id="soc1"  readOnly="true">
                      <f:selectItems value="#{bindings.MemshipStatus.items}"
                                     id="si1"/>
                    </af:selectOneChoice>
                    <af:inputText value="#{bindings.DebitSum.inputValue}"
                                  label="#{bindings.DebitSum.hints.label}"
                                  required="#{bindings.DebitSum.hints.mandatory}"
                                  columns="#{bindings.DebitSum.hints.displayWidth}"
                                  maximumLength="#{bindings.DebitSum.hints.precision}"
                                  shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                  id="it5"  readOnly="true">
                      <f:validator binding="#{bindings.DebitSum.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.DebitSum.format}"/>
                    </af:inputText>
                  </af:panelFormLayout>
                   <af:spacer width="30" height="10" id="s1"/>
                
                </af:panelGroupLayout>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>