<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<jsp:directive.page contentType="text/html;charset=UTF-8"/>
  ${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
     
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="تازه های کتاب" helpTopicId="recentbook">
            <af:panelSplitter id="ps1" splitterPosition="110"
                              orientation="vertical">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl2">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1" headerText="جستجو" disclosed="true"
                              value="#{bindings.RecentBooksPeriodVCQuery.queryDescriptor}"
                              model="#{bindings.RecentBooksPeriodVCQuery.queryModel}"
                              queryListener="#{bindings.RecentBooksPeriodVCQuery.processQuery}"
                              queryOperationListener="#{bindings.RecentBooksPeriodVCQuery.processQueryOperation}"
                              rows="1" maxColumns="2" saveQueryMode="hidden"
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <af:panelGroupLayout id="pgl1" halign="center" valign="middle"
                                       layout="vertical"
                                       partialTriggers="qryId1">
                    <af:spacer width="10" height="20" id="s1"/>
                    <af:panelCollection id="pc1" inlineStyle="width:95.0%;">
                      <f:facet name="menus"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                      <af:table value="#{bindings.RecentBooksVo1.collectionModel}"
                                var="row"
                                rows="#{bindings.RecentBooksVo1.rangeSize}"
                                emptyText="#{bindings.RecentBooksVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.RecentBooksVo1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.RecentBooksVo1Query.queryDescriptor}"
                                queryListener="#{bindings.RecentBooksVo1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.RecentBooksVo1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.RecentBooksVo1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t1"
                                columnStretching="column:c6">
                        <af:column sortProperty="ArtId" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.ArtId.label}"
                                   id="c1">
                          <af:outputText value="#{row.ArtId}" id="ot8">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.RecentBooksVo1.hints.ArtId.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Title" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.Title.label}"
                                   id="c6">
                          <af:outputText value="#{row.Title}" id="ot7"/>
                        </af:column>
                        <af:column sortProperty="CallNo" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.CallNo.label}"
                                   id="c5" align="left">
                          <af:inputText value="#{row.bindings.CallNo.inputValue}"
                                        label="#{bindings.RecentBooksVo1.hints.CallNo.label}"
                                        required="#{bindings.RecentBooksVo1.hints.CallNo.mandatory}"
                                        columns="#{bindings.RecentBooksVo1.hints.CallNo.displayWidth}"
                                        maximumLength="#{bindings.RecentBooksVo1.hints.CallNo.precision}"
                                        shortDesc="#{bindings.RecentBooksVo1.hints.CallNo.tooltip}"
                                        id="it1" styleClass="AFFieldTextLTRMarker" readOnly="true">
                            <f:validator binding="#{row.bindings.CallNo.validator}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="OrigTitle" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.OrigTitle.label}"
                                   id="c2">
                          <af:outputText value="#{row.OrigTitle}" id="ot9"/>
                        </af:column>
                        <af:column sortProperty="PubDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.PubDate.label}"
                                   id="c4">
                          <af:outputText value="#{row.PubDate}" id="ot5"/>
                        </af:column>
                        <af:column sortProperty="VolumeCount" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.VolumeCount.label}"
                                   id="c9">
                          <af:outputText value="#{row.VolumeCount}" id="ot1">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.RecentBooksVo1.hints.VolumeCount.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="InsertDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.RecentBooksVo1.hints.InsertDate.label}"
                                   id="c8">
                          <af:outputText value="#{row.InsertDate}" id="ot4">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.RecentBooksVo1.hints.InsertDate.format}"/>
                          </af:outputText>
                        </af:column>
                      </af:table>
                    </af:panelCollection>
                  </af:panelGroupLayout>
                  <f:facet name="toolbar"/>
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