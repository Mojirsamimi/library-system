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
        <af:panelHeader text="ارجاعات موضوع" helpTopicId="persianSubject">
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
                                  value="#{bindings.SubjectVCQuery.queryDescriptor}"
                                  model="#{bindings.SubjectVCQuery.queryModel}"
                                  queryListener="#{bindings.SubjectVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.SubjectVCQuery.processQueryOperation}"
                                  rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t2">
                            <fadak:ToolbarSet iteratorname="MainSeeSubjectVo1Iterator" id="ts1"
                                              showsearch="false"
                                              showrollback="true"
                                              showrefresh="false"
                                              showquery="false"
                                              showEditCommand="false"
                                              showdelete="false"
                                              showcreate="false"
                                              showcommit="true"/>
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
                          <af:panelGroupLayout id="pgl5" layout="horizontal">
                            <af:commandImageLink shortDesc="ایجاد" id="cil1"
                                                 icon="/icons/list-add.png"
                                                 action="#{viewScope.persian_subject.createInsertPersianMainSeeSub}"/>
                            <af:inputText value="#{bindings.Subject1.inputValue}"
                                          label="#{bindings.Subject1.hints.label}"
                                          required="#{bindings.Subject1.hints.mandatory}"
                                          columns="#{bindings.Subject1.hints.displayWidth}"
                                          maximumLength="#{bindings.Subject1.hints.precision}"
                                          shortDesc="#{bindings.Subject1.hints.tooltip}"
                                          id="it1" >
                              <f:validator binding="#{bindings.Subject1.validator}"/>
                            </af:inputText>
                          </af:panelGroupLayout>
                          <f:facet name="footer"/>
                        </af:panelFormLayout>
                        <af:spacer width="10" height="10" id="s1"/>
                       
                        <af:panelCollection id="pc1"  inlineStyle="width:50%; height:150.0px;">
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t5">
                              <af:commandImageLink id="il"
                                                   action="#{pageFlowScope.TFBean.ref_select_subject}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                   actionListener="#{viewScope.persian_subject.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refSubReadingOrder}"/>
                                <af:setActionListener from="#{'see'}"
                                                      to="#{pageFlowScope.refSubTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete.execute}"
                                                    shortDesc="حذف"
                                                   disabled="#{bindings.SeeSubjectVo.currentRow==null || bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                partialTriggers="t1"
                                                partialSubmit="true"
                                                   icon="/icons/list-remove.png"
                                                   id="cil3"/>
                              <%-- <af:commandImageLink shortDesc="حذف"
                                                   disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                   id="cil3"
                                                   icon="/icons/list-remove.png"
                                                   action="#{viewScope.persian_subject.removeFromDetail}">
                                <af:setActionListener from="#{'see'}"
                                                      to="#{viewScope.persian_subject.tab}"/>
                              </af:commandImageLink>--%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeSubjectVo.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeSubjectVo.rangeSize}"
                                    emptyText="#{bindings.SeeSubjectVo.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeSubjectVo.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeSubjectVoQuery.queryDescriptor}"
                                    queryListener="#{bindings.SeeSubjectVoQuery.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeSubjectVo.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeSubjectVo.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t1" partialTriggers=":::r1 ::cil3"
                                    columnStretching="column:c1">
                            <af:column sortProperty="SubjectText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeSubjectVo.hints.SubjectText.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.SubjectText.inputValue}"
                                            label="#{bindings.SeeSubjectVo.hints.SubjectText.label}"
                                            required="#{bindings.SeeSubjectVo.hints.SubjectText.mandatory}"
                                            columns="#{bindings.SeeSubjectVo.hints.SubjectText.displayWidth}"
                                            maximumLength="#{bindings.SeeSubjectVo.hints.SubjectText.precision}"
                                            shortDesc="#{bindings.SeeSubjectVo.hints.SubjectText.tooltip}"
                                            id="it3" readOnly="true">
                                <f:validator binding="#{row.bindings.SubjectText.validator}"/>
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
                <af:panelSplitter id="ps1" splitterPosition="120"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl3">
                      <af:panelHeader text=" " id="ph2">
                        <af:query id="qryId2" headerText="جستجو"
                                  disclosed="true"
                                  value="#{bindings.SubjectVCQuery1.queryDescriptor}"
                                  model="#{bindings.SubjectVCQuery1.queryModel}"
                                  queryListener="#{bindings.SubjectVCQuery1.processQuery}"
                                  queryOperationListener="#{bindings.SubjectVCQuery1.processQueryOperation}"
                                  rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t3">
                            <fadak:ToolbarSet iteratorname="MainSeeAlsoSubjectVo1Iterator" id="ts2" showcreate="false"
                            showdelete="false" showrefresh="false"/>
                          </af:toolbar>
                        </f:facet>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb2" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl4" layout="scroll"
                                           valign="middle" halign="center"
                                           partialTriggers="qryId2">
                        <af:panelFormLayout id="pfl2">
                          <af:panelGroupLayout id="pgl6" layout="horizontal">
                            <af:commandImageLink shortDesc="ایجاد" id="cil2"
                                                 icon="/icons/list-add.png"
                                                 action="#{viewScope.persian_subject.createInsertPersianMainSeeAlsoSub}"/>
                            <af:inputText value="#{bindings.Subject11.inputValue}"
                                          label="#{bindings.Subject11.hints.label}"
                                          required="#{bindings.Subject11.hints.mandatory}"
                                          columns="#{bindings.Subject11.hints.displayWidth}"
                                          maximumLength="#{bindings.Subject11.hints.precision}"
                                          shortDesc="#{bindings.Subject11.hints.tooltip}"
                                          id="it2" >
                              <f:validator binding="#{bindings.Subject11.validator}"/>
                            </af:inputText>
                          </af:panelGroupLayout>
                          <f:facet name="footer"/>
                        </af:panelFormLayout>
                        <af:spacer width="10" height="10" id="s2"/>
                        <af:panelCollection id="pc2" inlineStyle="width:50%; height:150.0px;">
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t8">
                              <af:commandImageLink id="cil4"
                                                   action="#{pageFlowScope.TFBean.ref_select_subject}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   actionListener="#{viewScope.persian_subject.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refSubReadingOrder}"/>
                                <af:setActionListener from="#{'see also 1'}"
                                                      to="#{pageFlowScope.refSubTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete1.execute}"
                                                   shortDesc="حذف"
                                                  partialTriggers="t4"
                                                   disabled="#{bindings.SeeAlsoSubjectVO_rtype1.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                  partialSubmit="true"
                                                   icon="/icons/list-remove.png"
                                                   id="cil5"/>
                              <%--   <af:commandImageLink shortDesc="حذف"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   id="cil5"
                                                   icon="/icons/list-remove.png"
                                                   action="#{viewScope.persian_subject.removeFromDetail}">
                                <af:setActionListener from="#{'see also 1'}"
                                                      to="#{viewScope.persian_subject.tab}"/>
                              </af:commandImageLink> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeAlsoSubjectVO_rtype1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeAlsoSubjectVO_rtype1.rangeSize}"
                                    emptyText="#{bindings.SeeAlsoSubjectVO_rtype1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeAlsoSubjectVO_rtype1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeAlsoSubjectVO_rtype1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeAlsoSubjectVO_rtype1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeAlsoSubjectVO_rtype1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeAlsoSubjectVO_rtype1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t4" partialTriggers=":::r1 ::cil5"
                                    columnStretching="column:c2">
                            <af:column sortProperty="SubjectText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.label}"
                                       id="c2">
                              <af:inputText value="#{row.bindings.SubjectText.inputValue}"
                                            label="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.label}"
                                            required="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.mandatory}"
                                            columns="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.precision}"
                                            shortDesc="#{bindings.SeeAlsoSubjectVO_rtype1.hints.SubjectText.tooltip}"
                                            id="it4" readOnly="true">
                                <f:validator binding="#{row.bindings.SubjectText.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                        <af:panelCollection id="pc3" inlineStyle="width:50%; height:150.0px;">
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t9">
                              <af:commandImageLink id="cil6"
                                                   action="#{pageFlowScope.TFBean.ref_select_subject}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   actionListener="#{viewScope.persian_subject.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refSubReadingOrder}"/>
                                <af:setActionListener from="#{'see also 2'}"
                                                      to="#{pageFlowScope.refSubTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete2.execute}"
                                                   shortDesc="حذف"
                                                   partialTriggers="t6"
                                                   disabled="#{bindings.SeeAlsoSubjectVO_rtype2.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                  partialSubmit="true"
                                                   icon="/icons/list-remove.png"
                                                   id="cil7"/>
                              <%--  <af:commandImageLink shortDesc="حذف"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   id="cil7"
                                                   icon="/icons/list-remove.png"
                                                   action="#{viewScope.persian_subject.removeFromDetail}">
                                <af:setActionListener from="#{'see also 2'}"
                                                      to="#{viewScope.persian_subject.tab}"/>
                              </af:commandImageLink>--%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeAlsoSubjectVO_rtype2.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeAlsoSubjectVO_rtype2.rangeSize}"
                                    emptyText="#{bindings.SeeAlsoSubjectVO_rtype2.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeAlsoSubjectVO_rtype2.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeAlsoSubjectVO_rtype2Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeAlsoSubjectVO_rtype2Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeAlsoSubjectVO_rtype2.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeAlsoSubjectVO_rtype2.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t6"
                                    columnStretching="column:c3" partialTriggers=":::r1 ::cil7">
                            <af:column sortProperty="SubjectText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.label}"
                                       id="c3">
                              <af:inputText value="#{row.bindings.SubjectText.inputValue}"
                                            label="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.label}"
                                            required="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.mandatory}"
                                            columns="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.precision}"
                                            shortDesc="#{bindings.SeeAlsoSubjectVO_rtype2.hints.SubjectText.tooltip}"
                                            id="it5" readOnly="true">
                                <f:validator binding="#{row.bindings.SubjectText.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                        <af:panelCollection id="pc4" inlineStyle="width:50%; height:150.0px;">
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t10">
                              <af:commandImageLink id="cil8"
                                                   action="#{pageFlowScope.TFBean.ref_select_subject}"
                                                   icon="/icons/list-add.png"
                                                   partialSubmit="true"
                                                   shortDesc="ایجاد"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   actionListener="#{viewScope.persian_subject.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refSubReadingOrder}"/>
                                <af:setActionListener from="#{'see also 3'}"
                                                      to="#{pageFlowScope.refSubTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete3.execute}"
                                                  shortDesc="حذف"
                                                   partialTriggers="t7"
                                                   disabled="#{bindings.SeeAlsoSubjectVO_rtype3.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                  partialSubmit="true"
                                                   icon="/icons/list-remove.png"
                                                   id="cil9"/>
                              <%--      <af:commandImageLink shortDesc="حذف"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   id="cil9"
                                                   icon="/icons/list-remove.png"
                                                   action="#{viewScope.persian_subject.removeFromDetail}">
                                <af:setActionListener from="#{'see also 3'}"
                                                      to="#{viewScope.persian_subject.tab}"/>
                              </af:commandImageLink> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeAlsoSubjectVO_rtype3.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeAlsoSubjectVO_rtype3.rangeSize}"
                                    emptyText="#{bindings.SeeAlsoSubjectVO_rtype3.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeAlsoSubjectVO_rtype3.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeAlsoSubjectVO_rtype3Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeAlsoSubjectVO_rtype3Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeAlsoSubjectVO_rtype3.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeAlsoSubjectVO_rtype3.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t7" partialTriggers=":::r1 ::cil9"
                                    columnStretching="column:c4">
                            <af:column sortProperty="SubjectText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.label}"
                                       id="c4">
                              <af:inputText value="#{row.bindings.SubjectText.inputValue}"
                                            label="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.label}"
                                            required="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.mandatory}"
                                            columns="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.precision}"
                                            shortDesc="#{bindings.SeeAlsoSubjectVO_rtype3.hints.SubjectText.tooltip}"
                                            id="it6" readOnly="true">
                                <f:validator binding="#{row.bindings.SubjectText.validator}"/>
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
        
        </af:panelHeader>
        </f:facet>
         <f:facet name="popup">
         <af:popup  id="tf" contentDelivery="lazyUncached"
                binding="#{pageFlowScope.TFBean.region_popup}">
      <af:panelWindow title="موضوع"
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