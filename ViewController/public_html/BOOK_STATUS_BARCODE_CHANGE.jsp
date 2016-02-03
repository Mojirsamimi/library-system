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
        <af:panelHeader text="#{viewcontrollerBundle.book_status_barcode_change}"
                        helpTopicId="bookBarcodeStatusChange">
             <f:facet name="toolbar">

          <af:toolbar id="t1">
                            <fadak:ToolbarSet debug="true" iteratorname="BookBarcodeChangeIterator" id="ts1"
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
           
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="120">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.book_search}" disclosed="true"
                              value="#{bindings.searchbarcoderegIdQuery.queryDescriptor}"
                              model="#{bindings.searchbarcoderegIdQuery.queryModel}"
                              queryListener="#{bindings.searchbarcoderegIdQuery.processQuery}"
                              queryOperationListener="#{bindings.searchbarcoderegIdQuery.processQueryOperation}"
                              rows="1" maxColumns="2" saveQueryMode="hidden"
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelGroupLayout id="pgl2" layout="vertical"
                                     valign="middle" halign="center"
                                     partialTriggers="qryId1">
                  <af:panelBox text="مشخصات کتاب" id="pb2">
                    <f:facet name="toolbar"/>
                    <af:panelFormLayout id="pfl1" maxColumns="2" rows="2">
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.RegId.inputValue}"
                                    label="#{bindings.RegId.hints.label}"
                                    required="#{bindings.RegId.hints.mandatory}"
                                    columns="#{bindings.RegId.hints.displayWidth}"
                                    maximumLength="#{bindings.RegId.hints.precision}"
                                    shortDesc="#{bindings.RegId.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.RegId.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.CallNo.inputValue}"
                                    label="#{bindings.CallNo.hints.label}"
                                    required="#{bindings.CallNo.hints.mandatory}"
                                    columns="#{bindings.CallNo.hints.displayWidth}"
                                    maximumLength="#{bindings.CallNo.hints.precision}"
                                    shortDesc="#{bindings.CallNo.hints.tooltip}"
                                    id="it3" readOnly="true"
                                    styleClass="AFFieldTextLTRMarker">
                        <f:validator binding="#{bindings.CallNo.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Title.inputValue}"
                                    label="#{bindings.Title.hints.label}"
                                    required="#{bindings.Title.hints.mandatory}"
                                    columns="#{bindings.Title.hints.displayWidth}"
                                    maximumLength="#{bindings.Title.hints.precision}"
                                    shortDesc="#{bindings.Title.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.Title.validator}"/>
                      </af:inputText>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelBox>
                  <af:panelBox text="تغییر وضعیت،بارکد کتاب" id="pb1">
                    <af:panelGroupLayout id="pgl3" layout="vertical"
                                         valign="middle" halign="center">
                      <af:panelFormLayout id="pfl2" rows="3" maxColumns="2">
                        <af:selectOneChoice value="#{bindings.ExistenceStatus.inputValue}"
                                            label="#{bindings.ExistenceStatus.label}"
                                            required="#{bindings.ExistenceStatus.hints.mandatory}"
                                            shortDesc="#{bindings.ExistenceStatus.hints.tooltip}"
                                            id="soc1">
                          <f:selectItems value="#{bindings.ExistenceStatus.items}"
                                         id="si1"/>
                        </af:selectOneChoice>
                        <af:selectOneChoice value="#{bindings.LoanStatus.inputValue}"
                                            label="#{bindings.LoanStatus.label}"
                                            required="#{bindings.LoanStatus.hints.mandatory}"
                                            shortDesc="#{bindings.LoanStatus.hints.tooltip}"
                                            id="soc2">
                          <f:selectItems value="#{bindings.LoanStatus.items}"
                                         id="si2"/>
                        </af:selectOneChoice>
                        <af:inputText id="it5"
                                      label="#{viewcontrollerBundle.book_new_barcode}"
                                      value="#{viewScope.book_status_barcode_change.newBookBarcode}"
                                      maximumLength="14"/>
                        <af:selectOneChoice value="#{bindings.SafetyStatus.inputValue}"
                                            label="#{bindings.SafetyStatus.label}"
                                            required="#{bindings.SafetyStatus.hints.mandatory}"
                                            shortDesc="#{bindings.SafetyStatus.hints.tooltip}"
                                            id="soc3">
                          <f:selectItems value="#{bindings.SafetyStatus.items}"
                                         id="si3"/>
                        </af:selectOneChoice>
                        <af:selectOneChoice value="#{bindings.Place.inputValue}"
                                            label="#{bindings.Place.label}"
                                            shortDesc="#{bindings.Place.hints.tooltip}"
                                            id="soc4">
                          <f:selectItems value="#{bindings.Place.items}"
                                         id="si4"/>
                        </af:selectOneChoice>
                       
                      </af:panelFormLayout>
                    </af:panelGroupLayout>
                    <f:facet name="toolbar">
                      <af:toolbar id="t2">
                      <af:group>
                        <fadak:ToolbarSet iteratorname="BookBarcodeChangeIterator" id="ts2" 
                        showfirst="false"
                        showlast="false"
                        shownext="false"
                        showprevious="false"
                        showcommit="false"
                        showrollback="false"
                        showcreate="false"
                        showdelete="false"
                        showEditCommand="true"
                        showrefresh="false"
                        />
                          <af:commandImageLink shortDesc="ثبت" 
                           actionListener="#{viewScope.book_status_barcode_change.bookStatusBarcodeChange}"
                                               id="cil1"
                                               icon="/icons/media-floppy.png"/>
                        </af:group>
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