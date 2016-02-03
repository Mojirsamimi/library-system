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
        <af:panelHeader text="#{viewcontrollerBundle.search_barcode}"
                        helpTopicId="barcodeSearch">
           
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="40">
              <f:facet name="first">
                <af:panelFormLayout id="pfl3" maxColumns="2" rows="1">
                  <f:facet name="footer"/>
                  <af:inputText label="بارکد" id="it7"
                                value="#{viewScope.cid_barcode_search.findBarcode}"
                                maximumLength="14"/>
                  <af:commandButton text="#{viewcontrollerBundle.search_barcode}"
                                      disabled="#{!bindings.searchBarcode.enabled}"
                                      id="cb1"
                                    actionListener="#{viewScope.cid_barcode_search.callSearchBarcode}"/>
                  
                </af:panelFormLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelGroupLayout id="pgl1" layout="vertical">
                  <af:panelBox text="#{viewcontrollerBundle.member}" id="pb1">
                    <af:panelFormLayout id="pfl1" maxColumns="5" rows="3">
                      <af:inputText value="#{bindings.ArtId.inputValue}"
                                    label="#{bindings.ArtId.hints.label}"
                                    required="#{bindings.ArtId.hints.mandatory}"
                                    columns="#{bindings.ArtId.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId.hints.precision}"
                                    shortDesc="#{bindings.ArtId.hints.tooltip}"
                                    id="it5"
                                    readOnly="true">
                        <f:validator binding="#{bindings.ArtId.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Fname.inputValue}"
                                    label="#{bindings.Fname.hints.label}"
                                    required="#{bindings.Fname.hints.mandatory}"
                                    columns="#{bindings.Fname.hints.displayWidth}"
                                    maximumLength="#{bindings.Fname.hints.precision}"
                                    shortDesc="#{bindings.Fname.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.Fname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Lname.inputValue}"
                                    label="#{bindings.Lname.hints.label}"
                                    required="#{bindings.Lname.hints.mandatory}"
                                    columns="#{bindings.Lname.hints.displayWidth}"
                                    maximumLength="#{bindings.Lname.hints.precision}"
                                    shortDesc="#{bindings.Lname.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.BarcodeType.inputValue}"
                                    label="#{bindings.BarcodeType.hints.label}"
                                    required="#{bindings.BarcodeType.hints.mandatory}"
                                    columns="#{bindings.BarcodeType.hints.displayWidth}"
                                    maximumLength="#{bindings.BarcodeType.hints.precision}"
                                    shortDesc="#{bindings.BarcodeType.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.BarcodeType.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <f:facet name="toolbar">
                   
                        <af:toolbar id="t1">
                          <fadak:ToolbarSet iteratorname="PP_PersonBarcodeSearchResultVO1Iterator"
                                            id="ts1"
                                             showdelete="false"
                                              showcreate="false"
                                              showcommit="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"/>
                        </af:toolbar>
                   
                    </f:facet>
                  </af:panelBox>
                  <af:panelBox text="#{viewcontrollerBundle.book}" id="pb2">
                    <af:panelFormLayout id="pfl2" maxColumns="5" rows="3">
                      <af:inputText value="#{bindings.ArtId1.inputValue}"
                                    label="#{bindings.ArtId1.hints.label}"
                                    required="#{bindings.ArtId1.hints.mandatory}"
                                    columns="#{bindings.ArtId1.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId1.hints.precision}"
                                    shortDesc="#{bindings.ArtId1.hints.tooltip}"
                                    id="it9" readOnly="true">
                        <f:validator binding="#{bindings.ArtId1.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId1.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Title.inputValue}"
                                    label="#{bindings.Title.hints.label}"
                                    required="#{bindings.Title.hints.mandatory}"
                                    columns="#{bindings.Title.hints.displayWidth}"
                                    maximumLength="#{bindings.Title.hints.precision}"
                                    shortDesc="#{bindings.Title.hints.tooltip}"
                                    id="it8" readOnly="true">
                        <f:validator binding="#{bindings.Title.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.CallNo.inputValue}"
                                    label="#{bindings.CallNo.hints.label}"
                                    required="#{bindings.CallNo.hints.mandatory}"
                                    columns="#{bindings.CallNo.hints.displayWidth}"
                                    maximumLength="#{bindings.CallNo.hints.precision}"
                                    shortDesc="#{bindings.CallNo.hints.tooltip}"
                                    id="it10" readOnly="true">
                        <f:validator binding="#{bindings.CallNo.validator}"/>
                      </af:inputText >
                      <af:inputText value="#{bindings.Barcode1.inputValue}"
                                    label="#{bindings.Barcode1.hints.label}"
                                    required="#{bindings.Barcode1.hints.mandatory}"
                                    columns="#{bindings.Barcode1.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode1.hints.precision}"
                                    shortDesc="#{bindings.Barcode1.hints.tooltip}"
                                    id="it6" readOnly="true">
                        <f:validator binding="#{bindings.Barcode1.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.BarcodeType1.inputValue}"
                                    label="#{bindings.BarcodeType1.hints.label}"
                                    required="#{bindings.BarcodeType1.hints.mandatory}"
                                    columns="#{bindings.BarcodeType1.hints.displayWidth}"
                                    maximumLength="#{bindings.BarcodeType1.hints.precision}"
                                    shortDesc="#{bindings.BarcodeType1.hints.tooltip}"
                                    id="it11" readOnly="true">
                        <f:validator binding="#{bindings.BarcodeType1.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <f:facet name="toolbar">
                    
                    <af:toolbar id="t2">
                          <fadak:ToolbarSet iteratorname="PP_BookBarcodeSearchResultVO1Iterator"
                                            id="ts2"
                                             showdelete="false"
                                              showcreate="false"
                                              showcommit="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"/>
                        </af:toolbar>
                    </f:facet>
                  </af:panelBox>
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