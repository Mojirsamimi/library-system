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
        <af:panelHeader text="ارجاعات عنوان" helpTopicId="persianUniformTitle">
            
            <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="نگاه کنید به" id="sdi1"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="110">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text=" " id="ph1">
                        <af:query id="qryId1" headerText="جستجو"
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
                            <fadak:ToolbarSet iteratorname="MainSeeUniformTitle1Iterator"
                                              id="ts1" showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="true"
                                              showsearch="false" debug="true"
                                              warningChanged="false"/>
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
                        <af:panelFormLayout id="pfl1">
                        
                          <f:facet name="footer"/>
                          <af:panelGroupLayout id="pgl5" layout="horizontal">
                            <af:commandImageLink shortDesc="ایجاد" id="cil1"
                                                 icon="/icons/list-add.png"
                                                 disabled="#{!bindings.CreateInsert.enabled}"
                                                 action="#{persian_uniTitle.createInsertPersianMainSeeUni}">
                            
                              <%-- 
                                action="#{pageFlowScope.TFBean.persian_uniformtitle}"
                              --%>
                            </af:commandImageLink>
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
                          <f:facet name="afterToolbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t6">
                              <af:commandImageLink id="il"
                                                   action="#{pageFlowScope.TFBean.ref_select_uni_title}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                                   actionListener="#{persian_uniTitle.initParamReadingOrderActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refUniTitleReadingOrder}"/>
                                <af:setActionListener from="#{'see'}"
                                                      to="#{pageFlowScope.refUniTitleTab}"/>
                              </af:commandImageLink>
                           
                             
                              <af:commandImageLink actionListener="#{bindings.Delete.execute}"
                                              shortDesc="حذف"
                                            icon="/icons/list-remove.png"
                                            disabled="#{bindings.SeeUniformTitle1.currentRow==null || bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                              partialTriggers="t4"
                                                   id="cil3"/>
                              <%--       <af:commandImageLink shortDesc="حذف"
                                                   rendered="false"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue.value==null}"
                                                   id="cil3"
                                                   
                                                   action="#{persian_uniTitle.removeSeeUniTitleAction}"/> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeUniformTitle1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeUniformTitle1.rangeSize}"
                                    emptyText="#{bindings.SeeUniformTitle1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeUniformTitle1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeUniformTitle1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeUniformTitle1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeUniformTitle1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeUniformTitle1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t4"
                                    columnStretching="column:c2"
                                    partialTriggers=":::tf :::r1">
                            <af:column sortProperty="TitleText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeUniformTitle1.hints.TitleText.label}"
                                       id="c2">
                              <af:inputText value="#{row.bindings.TitleText.inputValue}"
                                            label="#{bindings.SeeUniformTitle1.hints.TitleText.label}"
                                            required="#{bindings.SeeUniformTitle1.hints.TitleText.mandatory}"
                                            columns="#{bindings.SeeUniformTitle1.hints.TitleText.displayWidth}"
                                            maximumLength="#{bindings.SeeUniformTitle1.hints.TitleText.precision}"
                                            shortDesc="#{bindings.SeeUniformTitle1.hints.TitleText.tooltip}"
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
              <af:showDetailItem text="نیز نگاه کنید به" id="sdi2"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps1" splitterPosition="110"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl3">
                      <af:panelHeader text=" " id="ph2">
                        <af:query id="qryId2" headerText="جستجو"
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
                            <fadak:ToolbarSet iteratorname="MainSeeAlsoUniformTitleVO1Iterator" id="ts2"
                                              showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="true"  warningChanged="false"
                                              showsearch="false" debug="true"/>
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
                                           partialTriggers="qryId2">
                        <af:panelFormLayout id="pfl2">
                          <af:panelGroupLayout id="pgl6" layout="horizontal">
                            <af:commandImageLink actionListener="#{bindings.CreateInsert1.execute}"
                                                shortDesc="ایجاد"
                                                 icon="/icons/list-add.png"
                                                 
                                                 id="cil2"
                                                 action="#{persian_uniTitle.createInsertPersianMainSeeAlsoUni}"/>
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
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t8">
                              <af:commandImageLink id="commandImageLink1"
                                                   action="#{pageFlowScope.TFBean.ref_select_uni_title}"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   actionListener="#{persian_uniTitle.initParamReadingOrderActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refUniTitleReadingOrder}"/>
                                <af:setActionListener from="#{'see also'}"
                                                      to="#{pageFlowScope.refUniTitleTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete1.execute}"
                                                   icon="/icons/list-remove.png"
                                                   shortDesc="حذف"
                                                   partialTriggers="t3"
                                                   disabled="#{bindings.SeeAlsoUniformTitleVo1.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                   id="cil4"/>
                              <%--     <af:commandImageLink shortDesc="حذف"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue.value==null}"
                                                   id="cil4"
                                                   icon="/icons/list-remove.png"
                                                   action="#{persian_uniTitle.removeSeeAlsoUniTitleAction}"/> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeAlsoUniformTitleVo1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeAlsoUniformTitleVo1.rangeSize}"
                                    emptyText="#{bindings.SeeAlsoUniformTitleVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeAlsoUniformTitleVo1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeAlsoUniformTitleVo1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeAlsoUniformTitleVo1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeAlsoUniformTitleVo1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeAlsoUniformTitleVo1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t3"
                                    partialTriggers=":::r1"
                                    columnStretching="column:c1">
                            <af:column sortProperty="TitleText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.TitleText.inputValue}"
                                            label="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.label}"
                                            required="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.mandatory}"
                                            columns="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.precision}"
                                            shortDesc="#{bindings.SeeAlsoUniformTitleVo1.hints.TitleText.tooltip}"
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
                binding="#{pageFlowScope.TFBean.region_popup}"
                  >
      <af:panelWindow title="عنوان"
                      closeIconVisible="true" modal="true">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigation}"
                 />
      </af:panelWindow>
      </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>