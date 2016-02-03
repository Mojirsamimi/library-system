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
        <af:panelHeader text="#{viewcontrollerBundle.book_existence}"
                        helpTopicId="bookExistence">
         <f:facet name="toolbar">

          <af:toolbar id="t1">
             
                <fadak:ToolbarSet debug="true" iteratorname="VirtualBookVO1Iterator" id="ts1"
                                              showdelete="false"
                                              showcreate="false"
                                  showcommit="false" showEditCommand="false"
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
                              headerText="#{viewcontrollerBundle.book_search}" disclosed="true"
                              value="#{bindings.SearchCallNoArtIdTitleVCQuery.queryDescriptor}"
                              model="#{bindings.SearchCallNoArtIdTitleVCQuery.queryModel}"
                              queryListener="#{bindings.SearchCallNoArtIdTitleVCQuery.processQuery}"
                              queryOperationListener="#{bindings.SearchCallNoArtIdTitleVCQuery.processQueryOperation}"
                               styleClass="AFFieldTextLTRMarker"
                              maxColumns="2" rows="2"
                              modeChangeVisible="false"
                              saveQueryMode="hidden"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" layout="scroll"
                                       valign="middle" halign="center"
                                       partialTriggers="qryId1">
                    <af:panelFormLayout id="pfl1" rows="1" maxColumns="4"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText value="#{bindings.CallNo.inputValue}"
                                    label="#{bindings.CallNo.hints.label}"
                                    required="#{bindings.CallNo.hints.mandatory}"
                                    columns="#{bindings.CallNo.hints.displayWidth}"
                                    maximumLength="#{bindings.CallNo.hints.precision}"
                                    shortDesc="#{bindings.CallNo.hints.tooltip}"
                                     styleClass="AFFieldTextLTRMarker"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.CallNo.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ArtId.inputValue}"
                                    label="#{bindings.ArtId.hints.label}"
                                    required="#{bindings.ArtId.hints.mandatory}"
                                    columns="#{bindings.ArtId.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId.hints.precision}"
                                    shortDesc="#{bindings.ArtId.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.ArtId.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId.format}"/>
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
                      <af:inputText value="#{bindings.ProviderName.inputValue}"
                                    label="#{bindings.ProviderName.hints.label}"
                                    required="#{bindings.ProviderName.hints.mandatory}"
                                    columns="#{bindings.ProviderName.hints.displayWidth}"
                                    maximumLength="#{bindings.ProviderName.hints.precision}"
                                    shortDesc="#{bindings.ProviderName.hints.tooltip}"
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.ProviderName.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ProviderForeignName.inputValue}"
                                    label="#{bindings.ProviderForeignName.hints.label}"
                                    required="#{bindings.ProviderForeignName.hints.mandatory}"
                                    columns="#{bindings.ProviderForeignName.hints.displayWidth}"
                                    maximumLength="#{bindings.ProviderForeignName.hints.precision}"
                                    shortDesc="#{bindings.ProviderForeignName.hints.tooltip}"
                                    id="it9" readOnly="true">
                        <f:validator binding="#{bindings.ProviderForeignName.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="10" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:95%; height:200.0px;">
                      <af:table value="#{bindings.PhysicalBookVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.PhysicalBookVO1.rangeSize}"
                                emptyText="#{bindings.PhysicalBookVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.PhysicalBookVO1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.PhysicalBookVO1Query.queryDescriptor}"
                                queryListener="#{bindings.PhysicalBookVO1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.PhysicalBookVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.PhysicalBookVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c4">
                        <af:column sortProperty="Barcode" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.Barcode.label}"
                                   id="c3">
                          <af:outputText value="#{row.Barcode}" id="ot8">
                            <af:showPopupBehavior popupId=":::p1"
                                                  triggerType="dblClick"
                                                  align="endAfter"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="RegId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.RegId.label}"
                                   id="c8">
                          <af:outputText value="#{row.RegId}" id="ot5"/>
                        </af:column>
                        <af:column sortProperty="VolNo" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.VolNo.label}"
                                   id="c2">
                          <af:outputText value="#{row.VolNo}" id="ot6"/>
                        </af:column>
                        <af:column sortProperty="PartNo" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.PartNo.label}"
                                   id="c6">
                          <af:outputText value="#{row.PartNo}" id="ot4"/>
                        </af:column>
                        <af:column sortProperty="ExistenceStatus"
                                   filterable="true" sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.label}"
                                   id="c9">
                          <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                              label="#{row.bindings.ExistenceStatus.label}"
                                              required="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.mandatory}"
                                              shortDesc="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.tooltip}"
                                              id="soc1" readOnly="true">
                            <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                           id="si1"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="LoanStatus" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.LoanStatus.label}"
                                   id="c1">
                          <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                              label="#{row.bindings.LoanStatus.label}"
                                              required="#{bindings.PhysicalBookVO1.hints.LoanStatus.mandatory}"
                                              shortDesc="#{bindings.PhysicalBookVO1.hints.LoanStatus.tooltip}"
                                              id="soc2" readOnly="true">
                            <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                           id="si2"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="SafetyStatus" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.SafetyStatus.label}"
                                   id="c5">
                          <af:selectOneChoice value="#{row.bindings.SafetyStatus.inputValue}"
                                              label="#{row.bindings.SafetyStatus.label}"
                                              required="#{bindings.PhysicalBookVO1.hints.SafetyStatus.mandatory}"
                                              shortDesc="#{bindings.PhysicalBookVO1.hints.SafetyStatus.tooltip}"
                                              id="soc3" readOnly="true">
                            <f:selectItems value="#{row.bindings.SafetyStatus.items}"
                                           id="si3"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="Place" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PhysicalBookVO1.hints.Place.label}"
                                   id="c4">
                          <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                              label="#{row.bindings.Place.label}"
                                              required="#{bindings.PhysicalBookVO1.hints.Place.mandatory}"
                                              shortDesc="#{bindings.PhysicalBookVO1.hints.Place.tooltip}"
                                              id="soc4" readOnly="true">
                            <f:selectItems value="#{row.bindings.Place.items}"
                                           id="si4"/>
                          </af:selectOneChoice>
                        </af:column>
                      </af:table>
                      <f:facet name="menus"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                    </af:panelCollection>
                    <af:panelFormLayout id="pfl3">
                      <af:outputText value="#{viewcontrollerBundle.show_userInfo_bdClic}"
                                     id="ot1"/>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup">
         <af:popup id="p1" contentDelivery="lazyUncached">
              <af:panelWindow id="pw1" title=""
                              inlineStyle="width:300.0px;">
                <af:panelFormLayout id="pfl2"  rows="6"
                                    maxColumns="1" partialTriggers="pc1:t2">
                <af:inputText value="#{bindings.Fname.inputValue}"
                              label="#{bindings.Fname.hints.label}"
                              required="#{bindings.Fname.hints.mandatory}"
                              columns="#{bindings.Fname.hints.displayWidth}"
                              maximumLength="#{bindings.Fname.hints.precision}"
                              shortDesc="#{bindings.Fname.hints.tooltip}"
                              id="it6">
                  <f:validator binding="#{bindings.Fname.validator}"/>
                </af:inputText>
                <af:inputText value="#{bindings.Lname.inputValue}"
                              label="#{bindings.Lname.hints.label}"
                              required="#{bindings.Lname.hints.mandatory}"
                              columns="#{bindings.Lname.hints.displayWidth}"
                              maximumLength="#{bindings.Lname.hints.precision}"
                              shortDesc="#{bindings.Lname.hints.tooltip}"
                              id="it7">
                  <f:validator binding="#{bindings.Lname.validator}"/>
                </af:inputText>
                <af:inputText value="#{bindings.Barcode.inputValue}"
                              label="#{bindings.Barcode.hints.label}"
                              required="#{bindings.Barcode.hints.mandatory}"
                              columns="#{bindings.Barcode.hints.displayWidth}"
                              maximumLength="#{bindings.Barcode.hints.precision}"
                              shortDesc="#{bindings.Barcode.hints.tooltip}"
                              id="it8">
                  <f:validator binding="#{bindings.Barcode.validator}"/>
                </af:inputText>
              </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>