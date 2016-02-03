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
        <af:panelHeader text="#{viewcontrollerBundle.penalty_payment_history}"
                        helpTopicId="penaltyHistory">
         <f:facet name="toolbar">
          <af:toolbar id="t1">
                <fadak:ToolbarSet iteratorname="PersonVO1Iterator" id="ts2"
                                  showcommit="false" showcreate="false"
                                  showdelete="false" showEditCommand="false"
                                  showquery="false" showrefresh="false"
                                  showrollback="false" showsearch="false"/>
          </af:toolbar>
          </f:facet>
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="140">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}" disclosed="true"
                              value="#{bindings.searchnameidbarcodeQuery.queryDescriptor}"
                              model="#{bindings.searchnameidbarcodeQuery.queryModel}"
                              queryListener="#{viewScope.cid_member_penalty_history.preSearchPerson}"
                              queryOperationListener="#{bindings.searchnameidbarcodeQuery.processQueryOperation}"
                              rows="2" maxColumns="2" saveQueryMode="hidden"
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
                    <af:panelFormLayout id="pfl2" maxColumns="4" rows="1">
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <f:facet name="footer"/>
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.Id.validator}"/>
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
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="10" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:80%; height:200.0px;">
                      <f:facet name="menus"/>
                      <af:table value="#{bindings.VwPenaltyHistoryVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.VwPenaltyHistoryVO1.rangeSize}"
                                emptyText="#{bindings.VwPenaltyHistoryVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.VwPenaltyHistoryVO1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.VwPenaltyHistoryVO1Query.queryDescriptor}"
                                queryListener="#{bindings.VwPenaltyHistoryVO1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.VwPenaltyHistoryVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.VwPenaltyHistoryVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c2">
                        <af:column sortProperty="UserName" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwPenaltyHistoryVO1.hints.UserName.label}"
                                   id="c1">
                          <af:outputText value="#{row.UserName}" id="ot2"/>
                        </af:column>
                        <af:column sortProperty="Description" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwPenaltyHistoryVO1.hints.Description.label}"
                                   id="c2">
                          <af:outputText value="#{row.Description}" id="ot3"/>
                        </af:column>
                        <af:column sortProperty="Value" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwPenaltyHistoryVO1.hints.Value.label}"
                                   id="c3">
                          <af:outputText value="#{row.Value}" id="ot5">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.VwPenaltyHistoryVO1.hints.Value.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="RecTypeText" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwPenaltyHistoryVO1.hints.RecTypeText.label}"
                                   id="c4">
                          <af:outputText value="#{row.RecTypeText}" id="ot4"/>
                        </af:column>
                        <af:column sortProperty="DayDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.VwPenaltyHistoryVO1.hints.DayDate.label}"
                                   id="c5">
                          <af:outputText value="#{row.DayDate}" id="ot1">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.VwPenaltyHistoryVO1.hints.DayDate.format}"/>
                          </af:outputText>
                        </af:column>
                      </af:table>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                    </af:panelCollection>
                    <af:panelFormLayout id="pfl1" rows="1" maxColumns="2">
                      <af:panelLabelAndMessage label="#{bindings.Hint.hints.label}"
                                               id="plam1">
                        <af:outputText value="#{bindings.Hint.inputValue}"
                                       id="ot6"/>
                      </af:panelLabelAndMessage>
                      <af:inputText value="#{bindings.DebitSum.inputValue}"
                                    label="#{bindings.DebitSum.hints.label}"
                                    required="#{bindings.DebitSum.hints.mandatory}"
                                    columns="#{bindings.DebitSum.hints.displayWidth}"
                                    maximumLength="#{bindings.DebitSum.hints.precision}"
                                    shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.DebitSum.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.DebitSum.format}"/>
                      </af:inputText>
                      <f:facet name="footer"/>
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