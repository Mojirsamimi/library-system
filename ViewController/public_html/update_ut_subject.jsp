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
   <af:panelHeader text="تصحیح بانک موضوعات">
            <af:panelSplitter id="ps2" orientation="horizontal"
                              splitterPosition="700">
              <f:facet name="first">
             
              
                <af:panelSplitter id="ps1" splitterPosition="115"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text="موضوعات کتابخانه ملی" id="ph1">
                        <af:query id="qryId1" headerText="جستجو"
                                  disclosed="true"
                                  value="#{bindings.SearchSubjectVCQuery.queryDescriptor}"
                                  model="#{bindings.SearchSubjectVCQuery.queryModel}"
                                  queryListener="#{bindings.SearchSubjectVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.SearchSubjectVCQuery.processQueryOperation}"
                                  modeChangeVisible="true" fieldWidth="200"
                                  saveQueryMode="hidden"/>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb1" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl2" layout="vertical"
                                           valign="middle" halign="center"
                                           partialTriggers="qryId1">
                        <af:panelCollection id="pc1" inlineStyle="width:80.0%;">
                          <af:table value="#{bindings.IsoSubjectVo1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.IsoSubjectVo1.rangeSize}"
                                    emptyText="#{bindings.IsoSubjectVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.IsoSubjectVo1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SearchSubjectVCQuery.queryDescriptor}"
                                    queryListener="#{bindings.SearchSubjectVCQuery.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.IsoSubjectVo1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.IsoSubjectVo1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t1"
                                    columnStretching="column:c1">
                            <af:column sortProperty="Subject" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.IsoSubjectVo1.hints.Subject.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.Subject.inputValue}"
                                            label="#{bindings.IsoSubjectVo1.hints.Subject.label}"
                                            required="#{bindings.IsoSubjectVo1.hints.Subject.mandatory}"
                                            columns="#{bindings.IsoSubjectVo1.hints.Subject.displayWidth}"
                                            maximumLength="#{bindings.IsoSubjectVo1.hints.Subject.precision}"
                                            shortDesc="#{bindings.IsoSubjectVo1.hints.Subject.tooltip}"
                                            id="it1" readOnly="true">
                                <f:validator binding="#{row.bindings.Subject.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column id="c2" width="15"/>
                          </af:table>
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                        </af:panelCollection>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
               
              </f:facet>
              <f:facet name="second">
                <af:panelFormLayout id="pfl1">
                  <f:facet name="footer"/>
                </af:panelFormLayout>
              </f:facet>
            </af:panelSplitter>
         
        </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>