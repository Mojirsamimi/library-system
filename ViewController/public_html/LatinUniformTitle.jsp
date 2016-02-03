<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
  ${sessionUser.authorization}
<f:view locale="en">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/EnUTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="Uniform Title refers"
                        helpTopicId="latinUniformTitle">
            
            <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="See Uniform Title" id="sdi1"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="110">
                  <f:facet name="first">
                  <af:panelGroupLayout layout="vertical" id="pgl5">
                        <af:panelHeader text=" " id="ph3">
                          <af:query id="qryId3" headerText="Search"
                                    disclosed="true"
                                    value="#{bindings.TitleVCQuery.queryDescriptor}"
                                    model="#{bindings.TitleVCQuery.queryModel}"
                                    queryListener="#{bindings.TitleVCQuery.processQuery}"
                                    queryOperationListener="#{bindings.TitleVCQuery.processQueryOperation}"
                                    rows="1" maxColumns="2"
                                    saveQueryMode="hidden"
                                    modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t1">
                            <fadak:ToolbarSet iteratorname="LatinMainSeeUniformTitleIterator"
                                              id="ts1" showquery="false"
                                              showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showrefresh="false"
                                              showrollback="true"
                                              showsearch="false"
                                              lang="english"
                                              showprevious="true"
                                              shownext="true" showlast="true"
                                              showfirst="true"/>
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
                                           partialTriggers="qryId3">
                        <af:panelFormLayout id="pfl1">
                        
                          <f:facet name="footer"/>
                          <af:panelGroupLayout id="pgl3" layout="horizontal">
                            <af:commandImageLink 
                                                 icon="/icons/list-add.png"
                                                 
                                                 id="cil1"
                                                 action="#{viewScope.latin_uniTitle.seeUniTitleCreateInsert}"/>
                            <af:inputText value="#{bindings.Title.inputValue}"
                                          label="#{bindings.Title.hints.label}"
                                          required="#{bindings.Title.hints.mandatory}"
                                          columns="#{bindings.Title.hints.displayWidth}"
                                          maximumLength="#{bindings.Title.hints.precision}"
                                          shortDesc="#{bindings.Title.hints.tooltip}"
                                          id="it1">
                              <f:validator binding="#{bindings.Title.validator}"/>
                            </af:inputText>
                          </af:panelGroupLayout>
                        </af:panelFormLayout>
                        
                        <af:spacer width="10" height="10" id="s1"/>
                        <af:panelCollection id="pc1"
                                            inlineStyle="width:50%; height:150.0px;">
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t6">
                              <af:commandImageLink id="il"
                                                   action="#{pageFlowScope.TFBean.latin_uniformtitle}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="select"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                                   actionListener="#{viewScope.latin_uniTitle.initUniTitleReadingOrder}">
                                <af:setActionListener from="#{'2'}"
                                                      to="#{pageFlowScope.refUniTitleReadingOrder}"/>
                                <af:setActionListener from="#{'latin see'}"
                                                      to="#{pageFlowScope.refUniTitleTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete.execute}"
                                                  shortDesc="Delete"
                                                   icon="/icons/list-remove.png"
                                                   partialTriggers="t3"
                                                  disabled="#{bindings.LatinSeeUniformTitle.currentRow==null || bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                                   id="cil5"/>
                              <%-- <af:commandImageLink shortDesc="Delete"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                                   id="cil5"
                                                   icon="/icons/list-remove.png"
                                                   action="#{viewScope.latin_uniTitle.removeSeeUniTitleAction}"/>--%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.LatinSeeUniformTitle.collectionModel}"
                                    var="row"
                                    rows="#{bindings.LatinSeeUniformTitle.rangeSize}"
                                    emptyText="#{bindings.LatinSeeUniformTitle.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.LatinSeeUniformTitle.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.LatinSeeUniformTitleQuery.queryDescriptor}"
                                    queryListener="#{bindings.LatinSeeUniformTitleQuery.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.LatinSeeUniformTitle.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.LatinSeeUniformTitle.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t3"
                                    partialTriggers=":::tf :::r1"
                                    columnStretching="column:c1">
                            <af:column sortProperty="TitleText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.LatinSeeUniformTitle.hints.TitleText.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.TitleText.inputValue}"
                                            label="#{bindings.LatinSeeUniformTitle.hints.TitleText.label}"
                                            required="#{bindings.LatinSeeUniformTitle.hints.TitleText.mandatory}"
                                            columns="#{bindings.LatinSeeUniformTitle.hints.TitleText.displayWidth}"
                                            maximumLength="#{bindings.LatinSeeUniformTitle.hints.TitleText.precision}"
                                            shortDesc="#{bindings.LatinSeeUniformTitle.hints.TitleText.tooltip}"
                                            id="it4" readOnly="true">
                                <f:validator binding="#{row.bindings.TitleText.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
              <af:showDetailItem text="See also Uniform Title" id="sdi2"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps1" splitterPosition="110"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text=" " id="ph1">
                        <af:query id="qryId1" headerText="Search"
                                  disclosed="true"
                                  value="#{bindings.TitleVCQuery1.queryDescriptor}"
                                  model="#{bindings.TitleVCQuery1.queryModel}"
                                  queryListener="#{bindings.TitleVCQuery1.processQuery}"
                                  queryOperationListener="#{bindings.TitleVCQuery1.processQueryOperation}"
                                  rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t2">
                            <fadak:ToolbarSet iteratorname="LatinMainSeeAlsoUniformTitleVOIterator"
                                              id="ts2" showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="true"
                                              showsearch="false"
                                              lang="english"/>
                          </af:toolbar>
                        </f:facet>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb2" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl4" layout="vertical"
                                           valign="middle" halign="center"
                                           partialTriggers="qryId1">
                        <af:panelFormLayout id="pfl2">
                          <af:panelGroupLayout id="pgl6" layout="horizontal">
                            <af:commandImageLink icon="/icons/list-add.png"
                                                 id="cil2"
                                                 action="#{viewScope.latin_uniTitle.seeAlsoUniTitleCreateInsert}"/>
                            <af:inputText value="#{bindings.Title1.inputValue}"
                                          label="#{bindings.Title1.hints.label}"
                                          required="#{bindings.Title1.hints.mandatory}"
                                          columns="#{bindings.Title1.hints.displayWidth}"
                                          maximumLength="#{bindings.Title1.hints.precision}"
                                          shortDesc="#{bindings.Title1.hints.tooltip}"
                                          id="it2">
                              <f:validator binding="#{bindings.Title1.validator}"/>
                            </af:inputText>
                          </af:panelGroupLayout>
                          <f:facet name="footer"/>
                        </af:panelFormLayout>
                       
                        <af:spacer width="10" height="10" id="s2"/>
                        <af:panelCollection id="pc2"
                                            inlineStyle="width:50%; height:150.0px;">
                                            <f:facet name="toolbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t8">
                              <af:commandImageLink id="cil3"
                                                   action="#{pageFlowScope.TFBean.latin_uniformtitle}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="select"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                   actionListener="#{viewScope.latin_uniTitle.initUniTitleReadingOrder}">
                                <af:setActionListener from="#{'2'}"
                                                      to="#{pageFlowScope.refUniTitleReadingOrder}"/>
                                <af:setActionListener from="#{'latin see also'}"
                                                      to="#{pageFlowScope.refUniTitleTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete1.execute}"
                                                   shortDesc="Delete"
                                                   disabled="#{bindings.LatinSeeAlsoUniformTitleVo.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                  icon="/icons/list-remove.png"
                                                  partialTriggers="t4"
                                                   id="cil4"/>
                              <%--  <af:commandImageLink shortDesc="Delete"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                   id="cil4"
                                                   action="#{viewScope.latin_uniTitle.removeSeeAlsoUniTitleAction}"
                                                   icon="/icons/list-remove.png"/> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.LatinSeeAlsoUniformTitleVo.collectionModel}"
                                    var="row"
                                    rows="#{bindings.LatinSeeAlsoUniformTitleVo.rangeSize}"
                                    emptyText="#{bindings.LatinSeeAlsoUniformTitleVo.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.LatinSeeAlsoUniformTitleVo.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.LatinSeeAlsoUniformTitleVoQuery.queryDescriptor}"
                                    queryListener="#{bindings.LatinSeeAlsoUniformTitleVoQuery.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.LatinSeeAlsoUniformTitleVo.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.LatinSeeAlsoUniformTitleVo.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t4"
                                    columnStretching="column:c2"
                                    partialTriggers=":::r1">
                            <af:column sortProperty="TitleText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.label}"
                                       id="c2">
                              <af:inputText value="#{row.bindings.TitleText.inputValue}"
                                            label="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.label}"
                                            required="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.mandatory}"
                                            columns="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.displayWidth}"
                                            maximumLength="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.precision}"
                                            shortDesc="#{bindings.LatinSeeAlsoUniformTitleVo.hints.TitleText.tooltip}"
                                            id="it3" readOnly="true">
                                <f:validator binding="#{row.bindings.TitleText.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
            </af:panelTabbed>
            <f:facet name="toolbar"/>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup">
         <af:popup  id="tf" contentDelivery="lazyUncached"
                binding="#{pageFlowScope.TFBean.region_popup}">
      <af:panelWindow title="Title"
                      closeIconVisible="true" modal="true">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigation}" />
      </af:panelWindow>
      </af:popup>
        
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>