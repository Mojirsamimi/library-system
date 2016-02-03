<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
 ${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="گزارش هزینه ها" helpTopicId="extraChargeReport">
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="110">
                              
                              
                              
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl2">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1" headerText="جستجو" disclosed="true"
                              value="#{bindings.ExtraChargeDateVCQuery.queryDescriptor}"
                              model="#{bindings.ExtraChargeDateVCQuery.queryModel}"
                              queryListener="#{viewScope.extra_charge.postSearch_call_callcalculateSum_repprt}"
                              queryOperationListener="#{bindings.ExtraChargeDateVCQuery.processQueryOperation}"
                              saveQueryMode="hidden" modeChangeVisible="false"
                              rows="1" maxColumns="2"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                 <af:panelBox text=" " id="pb1" showDisclosure="false">
                    <f:facet name="toolbar"/>
                <af:panelGroupLayout id="pgl1" halign="center" valign="middle"
                                     layout="vertical" partialTriggers="qryId1">
                  
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:70%; height:300.0px;">
                      <af:table value="#{bindings.ExtraChargeReportVO.collectionModel}"
                                var="row"
                                rows="#{bindings.ExtraChargeReportVO.rangeSize}"
                                emptyText="#{bindings.ExtraChargeReportVO.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.ExtraChargeReportVO.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.ExtraChargeDateVCQuery.queryDescriptor}"
                                queryListener="#{bindings.ExtraChargeDateVCQuery.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.ExtraChargeReportVO.collectionModel.selectedRow}"
                                selectionListener="#{bindings.ExtraChargeReportVO.collectionModel.makeCurrent}"
                                rowSelection="single" id="t1"
                                columnStretching="column:c5">
                        <af:column sortProperty="ArtId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeReportVO.hints.ArtId.label}"
                                   id="c4">
                          <af:outputText value="#{row.ArtId}" id="ot5"/>
                        </af:column>
                        <af:column sortProperty="ChargeId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeReportVO.hints.ChargeId.label}"
                                   id="c2">
                          <af:outputText value="#{row.ChargeId}" id="ot2">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ExtraChargeReportVO.hints.ChargeId.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Description" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeReportVO.hints.Description.label}"
                                   id="c5">
                          <af:outputText value="#{row.Description}" id="ot3"/>
                        </af:column>
                        <af:column sortProperty="ChargeValue" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeReportVO.hints.ChargeValue.label}"
                                   id="c1">
                          <af:outputText value="#{row.ChargeValue}" id="ot1">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ExtraChargeReportVO.hints.ChargeValue.format}"/>
                          </af:outputText>
                          <f:facet name="footer">
                            <af:panelGroupLayout id="pgl3">
                              <af:inputText value="#{bindings.SumCharge.inputValue}"
                                            required="#{bindings.ExtraChargeReportVO.hints.SumCharge.mandatory}"
                                            columns="#{bindings.ExtraChargeReportVO.hints.SumCharge.displayWidth}"
                                            maximumLength="#{bindings.ExtraChargeReportVO.hints.SumCharge.precision}"
                                            shortDesc="#{bindings.ExtraChargeReportVO.hints.SumCharge.tooltip}"
                                            id="it1">
                                <f:validator binding="#{bindings.SumCharge.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.ExtraChargeReportVO.hints.SumCharge.format}"/>
                              </af:inputText>
                            </af:panelGroupLayout>
                          </f:facet>
                        </af:column>
                        <af:column sortProperty="InsertDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.ExtraChargeReportVO.hints.InsertDate.label}"
                                   id="c3">
                          <af:outputText value="#{row.InsertDate}" id="ot4">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.ExtraChargeReportVO.hints.InsertDate.format}"/>
                          </af:outputText>
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