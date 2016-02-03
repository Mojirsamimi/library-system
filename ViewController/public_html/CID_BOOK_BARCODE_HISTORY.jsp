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
        <af:panelHeader text="#{viewcontrollerBundle.book_barcode_history}"
                        helpTopicId="bookBarcodeHistory">
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
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" layout="scroll"
                                       valign="middle" halign="center"
                                       partialTriggers="qryId1">
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
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:60%; height:200.0px;">
                      <af:table value="#{bindings.VwBookBarcodeHistoryVO.collectionModel}"
                                var="row"
                                rows="#{bindings.VwBookBarcodeHistoryVO.rangeSize}"
                                emptyText="#{bindings.VwBookBarcodeHistoryVO.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.VwBookBarcodeHistoryVO.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.VwBookBarcodeHistoryVOQuery.queryDescriptor}"
                                queryListener="#{bindings.VwBookBarcodeHistoryVOQuery.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.VwBookBarcodeHistoryVO.collectionModel.selectedRow}"
                                selectionListener="#{bindings.VwBookBarcodeHistoryVO.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c2">
                        <af:column sortProperty="Barcode" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookBarcodeHistoryVO.hints.Barcode.label}"
                                   id="c2">
                          <af:outputText value="#{row.Barcode}" id="ot2"/>
                        </af:column>
                        <af:column sortProperty="DayDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookBarcodeHistoryVO.hints.DayDate.label}"
                                   id="c1">
                          <af:outputText value="#{row.DayDate}" id="ot1">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.VwBookBarcodeHistoryVO.hints.DayDate.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="UserName" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookBarcodeHistoryVO.hints.UserName.label}"
                                   id="c3" width="200">
                          <af:outputText value="#{row.UserName}" id="ot3"/>
                        </af:column>
                      </af:table>
                      <f:facet name="menus"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                    </af:panelCollection>
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