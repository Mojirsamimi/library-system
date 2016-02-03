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
        <af:panelHeader text="#{viewcontrollerBundle.book_status_history}"
                        helpTopicId="bookStatusHistory">
        
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
                              maxColumns="2" rows="1" saveQueryMode="hidden"
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
                    <af:panelFormLayout id="pfl1" rows="1" maxColumns="2">
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
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="10" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:70%; height:200.0px;">
                      <af:table value="#{bindings.VwBookStatusHistoryVO.collectionModel}"
                                var="row"
                                rows="#{bindings.VwBookStatusHistoryVO.rangeSize}"
                                emptyText="#{bindings.VwBookStatusHistoryVO.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.VwBookStatusHistoryVO.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.VwBookStatusHistoryVOQuery.queryDescriptor}"
                                queryListener="#{bindings.VwBookStatusHistoryVOQuery.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.VwBookStatusHistoryVO.collectionModel.selectedRow}"
                                selectionListener="#{bindings.VwBookStatusHistoryVO.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c5">
                        <af:column sortProperty="DayDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.DayDate.label}"
                                   id="c1">
                          <af:outputText value="#{row.DayDate}" id="ot2">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.VwBookStatusHistoryVO.hints.DayDate.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="LoanStatus" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.LoanStatus.label}"
                                   id="c7">
                          <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                              label="#{row.bindings.LoanStatus.label}"
                                              required="#{bindings.VwBookStatusHistoryVO.hints.LoanStatus.mandatory}"
                                              shortDesc="#{bindings.VwBookStatusHistoryVO.hints.LoanStatus.tooltip}"
                                              id="soc1" readOnly="true">
                            <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                           id="si1"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="ExistenceStatus"
                                   filterable="true" sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.ExistenceStatus.label}"
                                   id="c4">
                          <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                              label="#{row.bindings.ExistenceStatus.label}"
                                              required="#{bindings.VwBookStatusHistoryVO.hints.ExistenceStatus.mandatory}"
                                              shortDesc="#{bindings.VwBookStatusHistoryVO.hints.ExistenceStatus.tooltip}"
                                              id="soc2" readOnly="true">
                            <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                           id="si2"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="SafetyStatus" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.SafetyStatus.label}"
                                   id="c2">
                          <af:selectOneChoice value="#{row.bindings.SafetyStatus.inputValue}"
                                              label="#{row.bindings.SafetyStatus.label}"
                                              required="#{bindings.VwBookStatusHistoryVO.hints.SafetyStatus.mandatory}"
                                              shortDesc="#{bindings.VwBookStatusHistoryVO.hints.SafetyStatus.tooltip}"
                                              id="soc3" readOnly="true">
                            <f:selectItems value="#{row.bindings.SafetyStatus.items}"
                                           id="si3"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="Place" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.Place.label}"
                                   id="c6">
                          <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                              label="#{row.bindings.Place.label}"
                                              required="#{bindings.VwBookStatusHistoryVO.hints.Place.mandatory}"
                                              shortDesc="#{bindings.VwBookStatusHistoryVO.hints.Place.tooltip}"
                                              id="soc4" readOnly="true">
                            <f:selectItems value="#{row.bindings.Place.items}"
                                           id="si4"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="UserName" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwBookStatusHistoryVO.hints.UserName.label}"
                                   id="c5">
                          <af:outputText value="#{row.UserName}" id="ot1"/>
                        </af:column>
                      </af:table>
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