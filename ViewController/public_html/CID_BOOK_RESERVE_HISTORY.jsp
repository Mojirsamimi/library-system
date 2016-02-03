<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="سابقه رزرو کتاب" helpTopicId="reserveHistory">
           <f:facet name="toolbar">
          <af:toolbar id="t1">
                            <fadak:ToolbarSet debug="true" iteratorname="VirtualBookVO1Iterator" id="ts1"
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
                    <af:query id="qryId1" headerText="جستجوی کتاب" disclosed="true"
                              value="#{bindings.searchcallNotitleVCQuery.queryDescriptor}"
                              model="#{bindings.searchcallNotitleVCQuery.queryModel}"
                              queryListener="#{bindings.searchcallNotitleVCQuery.processQuery}"
                              queryOperationListener="#{bindings.searchcallNotitleVCQuery.processQueryOperation}"
                              rows="1" maxColumns="2"
                              modeChangeVisible="false" saveQueryMode="hidden"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" layout="scroll"
                                       valign="middle" halign="center">
                    <af:panelFormLayout id="pfl1" rows="2" maxColumns="3"
                                        partialTriggers="qryId1"
                                        fieldWidth="300" labelWidth="150">
                      <af:inputText value="#{bindings.CallNo.inputValue}"
                                    label="#{bindings.CallNo.hints.label}"
                                    required="#{bindings.CallNo.hints.mandatory}"
                                    columns="#{bindings.CallNo.hints.displayWidth}"
                                    maximumLength="#{bindings.CallNo.hints.precision}"
                                    shortDesc="#{bindings.CallNo.hints.tooltip}"
                                    id="it1" readOnly="true"
                                    styleClass="AFFieldTextLTRMarker">
                        <f:validator binding="#{bindings.CallNo.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.VbookCNT.inputValue}"
                                    label="#{bindings.VbookCNT.hints.label}"
                                    required="#{bindings.VbookCNT.hints.mandatory}"
                                    columns="#{bindings.VbookCNT.hints.displayWidth}"
                                    maximumLength="#{bindings.VbookCNT.hints.precision}"
                                    shortDesc="#{bindings.VbookCNT.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.VbookCNT.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.VbookCNT.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Title.inputValue}"
                                    label="#{bindings.Title.hints.label}"
                                    required="#{bindings.Title.hints.mandatory}"
                                    columns="#{bindings.Title.hints.displayWidth}"
                                    maximumLength="#{bindings.Title.hints.precision}"
                                    shortDesc="#{bindings.Title.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.Title.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.OrigTitle.inputValue}"
                                    label="#{bindings.OrigTitle.hints.label}"
                                    required="#{bindings.OrigTitle.hints.mandatory}"
                                    columns="#{bindings.OrigTitle.hints.displayWidth}"
                                    maximumLength="#{bindings.OrigTitle.hints.precision}"
                                    shortDesc="#{bindings.OrigTitle.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.OrigTitle.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ProviderName.inputValue}"
                                    label="#{bindings.ProviderName.hints.label}"
                                    required="#{bindings.ProviderName.hints.mandatory}"
                                    columns="#{bindings.ProviderName.hints.displayWidth}"
                                    maximumLength="#{bindings.ProviderName.hints.precision}"
                                    shortDesc="#{bindings.ProviderName.hints.tooltip}"
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.ProviderName.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="10" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:90%; height:200.0px;">
                      <af:table value="#{bindings.ReserveVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.ReserveVO1.rangeSize}"
                                emptyText="#{bindings.ReserveVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.ReserveVO1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.ReserveVO1Query.queryDescriptor}"
                                queryListener="#{bindings.ReserveVO1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.ReserveVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.ReserveVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c2"
                                partialTriggers=":::qryId1 c3 soc1">
                        <af:column sortProperty="ArtId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.ArtId.label}"
                                   id="c8" width="50">
                          <af:outputText value="#{row.ArtId}" id="ot4">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ReserveVO1.hints.ArtId.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Fname" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.Fname.label}"
                                   id="c4">
                          <af:outputText value="#{row.Fname}" id="ot5"/>
                        </af:column>
                        <af:column sortProperty="Lname" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.Lname.label}"
                                   id="c5">
                          <af:outputText value="#{row.Lname}" id="ot11"/>
                        </af:column>
                        <af:column sortProperty="Barcode" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.Barcode.label}"
                                   id="c2">
                          <af:outputText value="#{row.Barcode}" id="ot1"/>
                        </af:column>
                        <af:column sortProperty="VolNo" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.VolNo.label}"
                                   id="c6" width="50">
                          <af:outputText value="#{row.VolNo}" id="ot6"/>
                        </af:column>
                        <af:column sortProperty="PartNo" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.PartNo.label}"
                                   id="c10" width="70">
                          <af:outputText value="#{row.PartNo}" id="ot10"/>
                        </af:column>
                        <af:column sortProperty="DayDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.DayDate.label}"
                                   id="c7">
                          <af:outputText value="#{row.DayDate}" id="ot9">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ReserveVO1.hints.DayDate.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="UserName" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.UserName.label}"
                                   id="c1">
                          <af:outputText value="#{row.UserName}" id="ot8"/>
                        </af:column>
                        <af:column sortProperty="RetDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.RetDate.label}"
                                   id="c11">
                          <af:outputText value="#{row.RetDate}" id="ot3">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ReserveVO1.hints.RetDate.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Active" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ReserveVO1.hints.Active.label}"
                                   id="c3">
                          <af:selectOneChoice value="#{row.bindings.Active.inputValue}"
                                              label="#{row.bindings.Active.label}"
                                              required="#{bindings.ReserveVO1.hints.Active.mandatory}"
                                              shortDesc="#{bindings.ReserveVO1.hints.Active.tooltip}"
                                              id="soc1"
                                              autoSubmit="true"
                                              valueChangeListener="#{viewScope.book_reserve_history.active_selectionChanged}"
                                              binding="#{viewScope.book_reserve_history.activeSlctOneChoice}">
                            <f:selectItems value="#{row.bindings.Active.items}"
                                           id="si1"/>
                            <f:attribute name="rowIndexVal" value="#{row.bindings.Active.attributeValue}"/>
                          </af:selectOneChoice>
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