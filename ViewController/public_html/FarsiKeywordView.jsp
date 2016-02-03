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
         <af:panelHeader text="ارجاعات کلید واژه ها">
         <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="نکاه کنید به" id="sdi1"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="140">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text="FarsiDescriptor" id="ph1">
                        <af:query id="qryId1" headerText="Search"
                                  disclosed="true"
                                  value="#{bindings.DescVCQuery.queryDescriptor}"
                                  model="#{bindings.DescVCQuery.queryModel}"
                                  queryListener="#{bindings.DescVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.DescVCQuery.processQueryOperation}"
                                  rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t3">
                            <fadak:ToolbarSet iteratorname="FarsiDescriptorVo1Iterator" id="ts1"
                                              showcommit="false"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"/>
                          </af:toolbar>
                        </f:facet>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb1" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl2" layout="vertical"
                                           valign="middle" halign="center"
                                          partialTriggers="qryId1">
                        
                        
                        <af:panelFormLayout id="pfl1" rows="1" maxColumns="2">
                          <af:inputText value="#{bindings.Descriptor.inputValue}"
                                        label="#{bindings.Descriptor.hints.label}"
                                        required="#{bindings.Descriptor.hints.mandatory}"
                                        columns="#{bindings.Descriptor.hints.displayWidth}"
                                        maximumLength="#{bindings.Descriptor.hints.precision}"
                                        shortDesc="#{bindings.Descriptor.hints.tooltip}"
                                        id="it1" readOnly="true">
                            <f:validator binding="#{bindings.Descriptor.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.FdescArtId.inputValue}"
                                        label="#{bindings.FdescArtId.hints.label}"
                                        required="#{bindings.FdescArtId.hints.mandatory}"
                                        columns="#{bindings.FdescArtId.hints.displayWidth}"
                                        maximumLength="#{bindings.FdescArtId.hints.precision}"
                                        shortDesc="#{bindings.FdescArtId.hints.tooltip}"
                                        id="it4">
                            <f:validator binding="#{bindings.FdescArtId.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.FdescArtId.format}"/>
                          </af:inputText>
                         
                          <af:inputText value="#{bindings.FqualArtId.inputValue}"
                                        label="#{bindings.FqualArtId.hints.label}"
                                        required="#{bindings.FqualArtId.hints.mandatory}"
                                        columns="#{bindings.FqualArtId.hints.displayWidth}"
                                        maximumLength="#{bindings.FqualArtId.hints.precision}"
                                        shortDesc="#{bindings.FqualArtId.hints.tooltip}"
                                        id="it3">
                            <f:validator binding="#{bindings.FqualArtId.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.FqualArtId.format}"/>
                          </af:inputText>
                        </af:panelFormLayout>
                        
                        <af:panelGroupLayout id="pgl5" layout="horizontal"
                                             valign="middle" halign="center">
                          <af:panelCollection id="pc1"
                                              inlineStyle="height:200px; width:415.0px;">
                            <af:table value="#{bindings.FarsiEnglishKeywordVo1.collectionModel}"
                                      var="row"
                                      rows="#{bindings.FarsiEnglishKeywordVo1.rangeSize}"
                                      emptyText="#{bindings.FarsiEnglishKeywordVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                      fetchSize="#{bindings.FarsiEnglishKeywordVo1.rangeSize}"
                                      rowBandingInterval="0"
                                      filterModel="#{bindings.FarsiEnglishKeywordVo1Query.queryDescriptor}"
                                      queryListener="#{bindings.FarsiEnglishKeywordVo1Query.processQuery}"
                                      filterVisible="true" varStatus="vs"
                                      selectedRowKeys="#{bindings.FarsiEnglishKeywordVo1.collectionModel.selectedRow}"
                                      selectionListener="#{bindings.FarsiEnglishKeywordVo1.collectionModel.makeCurrent}"
                                      rowSelection="single" id="t1">
                              <af:column sortProperty="Equal" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.FarsiEnglishKeywordVo1.hints.Equal.label}"
                                         id="c1">
                                <af:outputText value="#{row.Equal}" id="ot2"/>
                              </af:column>
                              <af:column sortProperty="Edesc" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.FarsiEnglishKeywordVo1.hints.Edesc.label}"
                                         id="c2">
                                <af:outputText value="#{row.Edesc}" id="ot1"/>
                              </af:column>
                            </af:table>
                          </af:panelCollection>
                         
                          <af:panelCollection id="pc2"
                                              inlineStyle="height:200px; width:415.0px;">
                            <f:facet name="menus"/>
                            <f:facet name="toolbar"/>
                            <f:facet name="statusbar"/>
                            <af:table value="#{bindings.SeeFarsiKeywordVo1.collectionModel}"
                                      var="row"
                                      rows="#{bindings.SeeFarsiKeywordVo1.rangeSize}"
                                      emptyText="#{bindings.SeeFarsiKeywordVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                      fetchSize="#{bindings.SeeFarsiKeywordVo1.rangeSize}"
                                      rowBandingInterval="0"
                                      filterModel="#{bindings.SeeFarsiKeywordVo1Query.queryDescriptor}"
                                      queryListener="#{bindings.SeeFarsiKeywordVo1Query.processQuery}"
                                      filterVisible="true" varStatus="vs"
                                      selectedRowKeys="#{bindings.SeeFarsiKeywordVo1.collectionModel.selectedRow}"
                                      selectionListener="#{bindings.SeeFarsiKeywordVo1.collectionModel.makeCurrent}"
                                      rowSelection="single" id="t2">
                              <af:column sortProperty="Fqual" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.SeeFarsiKeywordVo1.hints.Fqual.label}"
                                         id="c4">
                                <af:outputText value="#{row.Fqual}" id="ot4"/>
                              </af:column>
                              <af:column sortProperty="Fdesc" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.SeeFarsiKeywordVo1.hints.Fdesc.label}"
                                         id="c3">
                                <af:outputText value="#{row.Fdesc}" id="ot3"/>
                              </af:column>
                            </af:table>
                          </af:panelCollection>
                        </af:panelGroupLayout>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
              <af:showDetailItem text="نیز نگاه کنید به" id="sdi2"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps1" splitterPosition="140"
                                  orientation="vertical">
                  <f:facet name="first">
                   
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb2" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl4" layout="vertical"
                                           valign="middle" halign="center"
                                          >
                        <af:panelFormLayout id="pfl2">
                         
                          <f:facet name="footer"/>
                        </af:panelFormLayout>
                        <af:spacer width="10" height="10" id="s2"/>
                       
                       
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
            </af:panelTabbed>
        
        </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>