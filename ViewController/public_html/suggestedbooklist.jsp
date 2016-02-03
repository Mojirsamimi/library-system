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
        <af:panelHeader text="ليست كتاب هاي سفارشي"
                        helpTopicId="suggestBookList">
            <af:panelGroupLayout id="pgl1" halign="center" valign="middle"
                                 layout="vertical">
              <af:spacer height="50" id="s1"/>
              <af:panelCollection id="pc1" inlineStyle="width:90.0%;">
                <f:facet name="menus"/>
                <f:facet name="toolbar"/>
                <f:facet name="statusbar"/>
                <af:table value="#{bindings.SuggestedVirtualBookVo1.collectionModel}"
                          var="row"
                          rows="#{bindings.SuggestedVirtualBookVo1.rangeSize}"
                          emptyText="#{bindings.SuggestedVirtualBookVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                          fetchSize="#{bindings.SuggestedVirtualBookVo1.rangeSize}"
                          rowBandingInterval="0"
                          filterModel="#{bindings.SuggestedVirtualBookVo1Query.queryDescriptor}"
                          queryListener="#{bindings.SuggestedVirtualBookVo1Query.processQuery}"
                          filterVisible="true" varStatus="vs"
                          selectedRowKeys="#{bindings.SuggestedVirtualBookVo1.collectionModel.selectedRow}"
                          selectionListener="#{bindings.SuggestedVirtualBookVo1.collectionModel.makeCurrent}"
                          rowSelection="single" id="t1">
                  <af:column sortProperty="ArtId" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.ArtId.label}"
                             id="c9">
                    <af:outputText value="#{row.ArtId}" id="ot9"/>
                  </af:column>
                  <af:column sortProperty="Title" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.Title.label}"
                             id="c7">
                    <af:outputText value="#{row.Title}" id="ot1"/>
                  </af:column>
                  <af:column sortProperty="UniformTitle" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.UniformTitle.label}"
                             id="c11">
                    <af:outputText value="#{row.UniformTitle}" id="ot11"/>
                  </af:column>
                  <af:column sortProperty="OrigTitle" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.OrigTitle.label}"
                             id="c8">
                    <af:outputText value="#{row.OrigTitle}" id="ot12"/>
                  </af:column>
                  <af:column sortProperty="ActiveStatus" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.ActiveStatus.label}"
                             id="c4">
                    <af:selectOneChoice label="وضعیت" id="soc3"
                                              value="#{row.ActiveStatus}"
                                              readOnly="true" simple="true"
                                        autoSubmit="true">
                            <af:selectItem label="فعال" value="1" id="si5"/>
                            <af:selectItem label="غیرفعال" value="0" id="si6"/>
                          </af:selectOneChoice>
                  </af:column>
                 
                  
                  
                  <af:column sortProperty="Edition" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.Edition.label}"
                             id="c12">
                    <af:outputText value="#{row.Edition}" id="ot13"/>
                  </af:column>
                  <af:column sortProperty="PhysicalDesc" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.PhysicalDesc.label}"
                             id="c1">
                    <af:outputText value="#{row.PhysicalDesc}" id="ot10"/>
                  </af:column>
                  <af:column sortProperty="PubDate" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.PubDate.label}"
                             id="c2">
                    <af:outputText value="#{row.PubDate}" id="ot8"/>
                  </af:column>
                  <af:column id="c6" headerText="موضوع">
                    <af:outputText value="#{bindings.Subject.inputValue}"
                                   id="ot4"/>
                  </af:column>
                  <af:column sortProperty="InsertDate" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.InsertDate.label}"
                             id="c3">
                    <af:outputText value="#{row.InsertDate}" id="ot7">
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.SuggestedVirtualBookVo1.hints.InsertDate.format}"/>
                    </af:outputText>
                  </af:column>
                  <af:column id="c15" headerText="زبان">
                    <af:selectOneChoice value="#{bindings.LanguageArtId.inputValue}"
                                        label="#{bindings.LanguageArtId.label}"
                                        required="#{bindings.LanguageArtId.hints.mandatory}"
                                        shortDesc="#{bindings.LanguageArtId.hints.tooltip}"
                                        id="soc1">
                      <f:selectItems value="#{bindings.LanguageArtId.items}"
                                     id="si1"/>
                    </af:selectOneChoice>
                  </af:column>
                  <af:column id="c5" headerText="ناشر">
                    <af:outputText value="#{bindings.Publisher.inputValue}"
                                   id="ot3"/>
                  </af:column>
                  <af:column id="c14" headerText="مولف">
                    <af:inputText value="#{bindings.Provider.inputValue}"
                                  label="#{bindings.Provider.hints.label}"
                                  required="#{bindings.Provider.hints.mandatory}"
                                  columns="#{bindings.Provider.hints.displayWidth}"
                                  maximumLength="#{bindings.Provider.hints.precision}"
                                  shortDesc="#{bindings.Provider.hints.tooltip}"
                                  id="it1">
                      <f:validator binding="#{bindings.Provider.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="UserName" filterable="true"
                             sortable="true"
                             headerText="#{bindings.SuggestedVirtualBookVo1.hints.UserName.label}"
                             id="c13">
                    <af:outputText value="#{row.UserName}" id="ot2"/>
                  </af:column>
                </af:table>
              </af:panelCollection>
            </af:panelGroupLayout>
          </af:panelHeader>
        
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>