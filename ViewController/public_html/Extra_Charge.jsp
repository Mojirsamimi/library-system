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
        <af:panelHeader text="هزینه ها" helpTopicId="extraCharge">
         <f:facet name="toolbar">
              <af:toolbar id="t3">
                <fadak:ToolbarSet iteratorname="PersonVO1Iterator" id="ts1"
                                  showcommit="true" showcreate="false"
                                  showdelete="false" showEditCommand="false"
                                  showquery="false" showrefresh="false"
                                  showrollback="true" showsearch="false"/>
              </af:toolbar>
            </f:facet>
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="120">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1" headerText="جستجوی عضو" disclosed="true"
                              value="#{bindings.searchbarcodeidQuery.queryDescriptor}"
                              model="#{bindings.searchbarcodeidQuery.queryModel}"
                              queryListener="#{viewScope.extra_charge.postSearch_call_callcalculateSum}"
                              queryOperationListener="#{bindings.searchbarcodeidQuery.processQueryOperation}"
                              rows="1" maxColumns="2"
                              modeChangeVisible="false" saveQueryMode="hidden"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" partialTriggers="qryId1"
                                       layout="vertical" valign="middle"
                                       halign="center">
                    <af:panelFormLayout id="pfl1" rows="1" maxColumns="4"
                                        labelWidth="100">
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it1"  readOnly="true">
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
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Lname.inputValue}"
                                    label="#{bindings.Lname.hints.label}"
                                    required="#{bindings.Lname.hints.mandatory}"
                                    columns="#{bindings.Lname.hints.displayWidth}"
                                    maximumLength="#{bindings.Lname.hints.precision}"
                                    shortDesc="#{bindings.Lname.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ArtId.inputValue}"
                                    label="#{bindings.ArtId.hints.label}"
                                    required="#{bindings.ArtId.hints.mandatory}"
                                    columns="#{bindings.ArtId.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId.hints.precision}"
                                    shortDesc="#{bindings.ArtId.hints.tooltip}"
                                    id="it5" visible="false">
                        <f:validator binding="#{bindings.ArtId.validator}"/>
                      </af:inputText>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                 <af:spacer height="20" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:90%; height:200.0px;">
                      <af:table value="#{bindings.ExtraChargeVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.ExtraChargeVO1.rangeSize}"
                                emptyText="#{bindings.ExtraChargeVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.ExtraChargeVO1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.ExtraChargeVO1Query.queryDescriptor}"
                                queryListener="#{bindings.ExtraChargeVO1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.ExtraChargeVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.ExtraChargeVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t1"
                                partialTriggers="::ts2"
                                columnStretching="column:c6"
                                binding="#{viewScope.extra_charge.chargeTable}">
                        <af:column sortProperty="ChargeId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeVO1.hints.ChargeId.label}"
                                   id="c1">
                          <af:selectOneChoice value="#{row.bindings.ChargeId.inputValue}"
                                              label="#{row.bindings.ChargeId.label}"
                                              required="#{bindings.ExtraChargeVO1.hints.ChargeId.mandatory}"
                                              shortDesc="#{bindings.ExtraChargeVO1.hints.ChargeId.tooltip}"
                                              id="soc1">
                            <f:selectItems value="#{row.bindings.ChargeId.items}"
                                           id="si1"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="Description" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeVO1.hints.Description.label}"
                                   id="c6">
                          <af:inputText value="#{row.bindings.Description.inputValue}"
                                        label="#{bindings.ExtraChargeVO1.hints.Description.label}"
                                        required="#{bindings.ExtraChargeVO1.hints.Description.mandatory}"
                                        columns="#{bindings.ExtraChargeVO1.hints.Description.displayWidth}"
                                        maximumLength="#{bindings.ExtraChargeVO1.hints.Description.precision}"
                                        shortDesc="#{bindings.ExtraChargeVO1.hints.Description.tooltip}"
                                        id="it8">
                            <f:validator binding="#{row.bindings.Description.validator}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="ChargeValue" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeVO1.hints.ChargeValue.label}"
                                   id="c2">
                          <af:inputText value="#{row.bindings.ChargeValue.inputValue}"
                                        label="#{bindings.ExtraChargeVO1.hints.ChargeValue.label}"
                                        required="#{bindings.ExtraChargeVO1.hints.ChargeValue.mandatory}"
                                        columns="#{bindings.ExtraChargeVO1.hints.ChargeValue.displayWidth}"
                                        maximumLength="#{bindings.ExtraChargeVO1.hints.ChargeValue.precision}"
                                        shortDesc="#{bindings.ExtraChargeVO1.hints.ChargeValue.tooltip}"
                                        id="it11">
                            <f:validator binding="#{row.bindings.ChargeValue.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ExtraChargeVO1.hints.ChargeValue.format}"/>
                          </af:inputText>
                          <f:facet name="footer">
                            <af:panelGroupLayout id="pgl3" halign="center"
                                                 valign="middle"
                                                 layout="vertical"
                                                 partialTriggers="::ts2 :::qryId1">
                              
                              <af:inputText value="#{bindings.SumCharge.inputValue}"
                                            required="#{bindings.ExtraChargeVO1.hints.SumCharge.mandatory}"
                                            columns="#{bindings.ExtraChargeVO1.hints.SumCharge.displayWidth}"
                                            maximumLength="#{bindings.ExtraChargeVO1.hints.SumCharge.precision}"
                                            shortDesc="#{bindings.ExtraChargeVO1.hints.SumCharge.tooltip}"
                                            partialTriggers="::ts2 :::qryId1"
                                            id="it6" readOnly="true">
                                <f:validator binding="#{bindings.SumCharge.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.ExtraChargeVO1.hints.SumCharge.format}"/>
                              </af:inputText>
                            </af:panelGroupLayout>
                          </f:facet>
                        </af:column>
                        <af:column sortProperty="InsertDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeVO1.hints.InsertDate.label}"
                                   id="c4">
                          <af:inputText value="#{row.bindings.InsertDate.inputValue}"
                                        label="#{bindings.ExtraChargeVO1.hints.InsertDate.label}"
                                        required="#{bindings.ExtraChargeVO1.hints.InsertDate.mandatory}"
                                        columns="#{bindings.ExtraChargeVO1.hints.InsertDate.displayWidth}"
                                        maximumLength="#{bindings.ExtraChargeVO1.hints.InsertDate.precision}"
                                        shortDesc="#{bindings.ExtraChargeVO1.hints.InsertDate.tooltip}"
                                        id="it9" readOnly="true">
                            <f:validator binding="#{row.bindings.InsertDate.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ExtraChargeVO1.hints.InsertDate.format}"/>
                          </af:inputText>
                        </af:column>
                      </af:table>
                      
                      <f:facet name="menus"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                      <f:facet name="secondaryToolbar">
                        <af:toolbar id="t2">
                          <fadak:ToolbarSet iteratorname="ExtraChargeVO1Iterator" id="ts2"
                          disabled_create="#{bindings.ArtId1.inputValue==null}"
                          disabled_delete="#{bindings.ExtraChargeVO1.currentRow==null}"
                          shownext="false"
                          showprevious="false"
                          showlast="false"
                          showfirst="false"
                          showcommit="false"
                          showrollback="false"
                          showrefresh="false"
                          partialsubmit="true"
                          showEditCommand="true"
                          disabled_EditCommand="#{bindings.ExtraChargeVO1.currentRow==null}"
                          
                          before_create="#{viewScope.extra_charge.extraChargeBeforeCreate}"/>
                        </af:toolbar>
                      </f:facet>
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