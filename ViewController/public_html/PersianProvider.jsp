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
        
         <af:panelHeader text="ارجاعات پدیدآور" helpTopicId="persianProvider">
         <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="نگاه کنید به" id="sdi1" stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="150">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text=" " id="ph1">
                        <af:query id="qryId1" headerText="جستجو"
                                  disclosed="true"
                                  value="#{bindings.ProviderVCQuery.queryDescriptor}"
                                  model="#{bindings.ProviderVCQuery.queryModel}"
                                  queryListener="#{bindings.ProviderVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.ProviderVCQuery.processQueryOperation}"
                                  rows="1" maxColumns="2"
                                  modeChangeVisible="false"
                                  saveQueryMode="hidden"/>
                        <f:facet name="toolbar">
                        
                            <af:toolbar id="t2">
                              <fadak:ToolbarSet iteratorname="MainSeeProvider1Iterator" id="ts1"
                                                showcommit="true"
                                                showcreate="false"
                                                showdelete="false"
                                                showEditCommand="false"
                                                showfirst="true"
                                                showlast="true"
                                                shownext="true"
                                                showprevious="true"
                                                showquery="false"
                                                showrefresh="false"
                                                showrollback="true"
                                                showsearch="false"
                                                debug="true"/>
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
                        <af:panelGroupLayout id="pgl5" layout="horizontal">
                          <af:commandImageLink shortDesc="ایجاد"
                                               icon="/icons/list-add.png"
                                               id="cil1"
                                               action="#{viewScope.persian_provider.mainSeeProviderCreateInsert}"/>
                          <af:panelFormLayout id="pfl2" rows="2" maxColumns="2"
                                              fieldWidth="200" labelWidth="200"
                                              labelAlignment="top">
                            <af:inputText value="#{bindings.Provider12.inputValue}"
                                          label="#{bindings.Provider12.hints.label}"
                                          required="#{bindings.Provider12.hints.mandatory}"
                                          columns="#{bindings.Provider12.hints.displayWidth}"
                                          maximumLength="#{bindings.Provider12.hints.precision}"
                                          shortDesc="#{bindings.Provider12.hints.tooltip}"
                                          id="it4">
                              <f:validator binding="#{bindings.Provider12.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.ForeignName2.inputValue}"
                                          label="#{bindings.ForeignName2.hints.label}"
                                          required="#{bindings.ForeignName2.hints.mandatory}"
                                          columns="#{bindings.ForeignName2.hints.displayWidth}"
                                          maximumLength="#{bindings.ForeignName2.hints.precision}"
                                          shortDesc="#{bindings.ForeignName2.hints.tooltip}"
                                          id="it5">
                              <f:validator binding="#{bindings.ForeignName2.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.BDDate1.inputValue}"
                                          label="#{bindings.BDDate1.hints.label}"
                                          required="#{bindings.BDDate1.hints.mandatory}"
                                          columns="#{bindings.BDDate1.hints.displayWidth}"
                                          maximumLength="#{bindings.BDDate1.hints.precision}"
                                          shortDesc="#{bindings.BDDate1.hints.tooltip}"
                                          id="it6">
                              <f:validator binding="#{bindings.BDDate1.validator}"/>
                            </af:inputText>
                            <af:selectOneChoice value="#{bindings.ProviderKind2.inputValue}"
                                                label="#{bindings.ProviderKind2.label}"
                                                required="#{bindings.ProviderKind2.hints.mandatory}"
                                                shortDesc="#{bindings.ProviderKind2.hints.tooltip}"
                                                id="soc3">
                              <f:selectItems value="#{bindings.ProviderKind2.items}"
                                             id="si3"/>
                            </af:selectOneChoice>
                           
                          </af:panelFormLayout>
                        </af:panelGroupLayout>
                        <af:spacer width="10" height="10" id="s1"/>
                        <af:panelCollection id="pc1"
                                            inlineStyle="width:60%; height:150.0px;">
                         
                          <f:facet name="toolbar"/>
                          <f:facet name="menus"/>
                         
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t6">
                              <af:commandImageLink disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                   id="il"
                                                   action="#{pageFlowScope.TFBean.ref_select_provider}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   actionListener="#{viewScope.persian_provider.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refProvReadingOrder}"/>
                                <af:setActionListener from="#{'see'}"
                                                      to="#{pageFlowScope.refProvTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete.execute}"
                                                   disabled="#{bindings.SeeProvider1.currentRow==null || bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                   shortDesc="حذف"
                                                   partialSubmit="true"
                                                 partialTriggers="t1"
                                                   icon="/icons/list-remove.png"
                                                   id="cil3"/>
                              <%--      <af:commandImageLink disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                                   shortDesc="حذف"
                                                   partialSubmit="true"
                                                   actionListener="#{viewScope.persian_provider.removeDetailActionListener}"
                                                   icon="/icons/list-remove.png"
                                                   id="cil3">
                                <af:setActionListener from="#{'see'}"
                                                      to="#{viewScope.persian_provider.tab}"/>
                              </af:commandImageLink>--%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeProvider1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeProvider1.rangeSize}"
                                    emptyText="#{bindings.SeeProvider1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeProvider1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeProvider1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeProvider1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeProvider1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeProvider1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t1" partialTriggers=":::r1 ::cil3" 
                                    columnStretching="column:c4">
                            <af:column sortProperty="ProviderText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeProvider1.hints.ProviderText.label}"
                                       id="c4">
                              <af:inputText value="#{row.bindings.ProviderText.inputValue}"
                                            label="#{bindings.SeeProvider1.hints.ProviderText.label}"
                                            required="#{bindings.SeeProvider1.hints.ProviderText.mandatory}"
                                            columns="#{bindings.SeeProvider1.hints.ProviderText.displayWidth}"
                                            maximumLength="#{bindings.SeeProvider1.hints.ProviderText.precision}"
                                            shortDesc="#{bindings.SeeProvider1.hints.ProviderText.tooltip}"
                                            id="it7" readOnly="true">
                                <f:validator binding="#{row.bindings.ProviderText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="ForeignNameText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeProvider1.hints.ForeignNameText.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.ForeignNameText.inputValue}"
                                            label="#{bindings.SeeProvider1.hints.ForeignNameText.label}"
                                            required="#{bindings.SeeProvider1.hints.ForeignNameText.mandatory}"
                                            columns="#{bindings.SeeProvider1.hints.ForeignNameText.displayWidth}"
                                            maximumLength="#{bindings.SeeProvider1.hints.ForeignNameText.precision}"
                                            shortDesc="#{bindings.SeeProvider1.hints.ForeignNameText.tooltip}"
                                            id="it8" readOnly="true">
                                <f:validator binding="#{row.bindings.ForeignNameText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="BDDateText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeProvider1.hints.BDDateText.label}"
                                       id="c3">
                              <af:inputText value="#{row.bindings.BDDateText.inputValue}"
                                            label="#{bindings.SeeProvider1.hints.BDDateText.label}"
                                            required="#{bindings.SeeProvider1.hints.BDDateText.mandatory}"
                                            columns="#{bindings.SeeProvider1.hints.BDDateText.displayWidth}"
                                            maximumLength="#{bindings.SeeProvider1.hints.BDDateText.precision}"
                                            shortDesc="#{bindings.SeeProvider1.hints.BDDateText.tooltip}"
                                            id="it9" readOnly="true">
                                <f:validator binding="#{row.bindings.BDDateText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="ProviderKind"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeProvider1.hints.ProviderKind.label}"
                                       id="c2">
                              <af:selectOneChoice value="#{row.bindings.ProviderKind.inputValue}"
                                                  label="#{row.bindings.ProviderKind.label}"
                                                  required="#{bindings.SeeProvider1.hints.ProviderKind.mandatory}"
                                                  shortDesc="#{bindings.SeeProvider1.hints.ProviderKind.tooltip}"
                                                  id="soc1" readOnly="true">
                                <f:selectItems value="#{row.bindings.ProviderKind.items}"
                                               id="si1"/>
                              </af:selectOneChoice>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                        <f:facet name="separator">
                          
                        </f:facet>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
              <af:showDetailItem text="نیز نگاه کنید به" id="sdi2"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps1" splitterPosition="150"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl3">
                      <af:panelHeader text=" " id="ph2">
                        
                            <af:query id="qryId2" headerText="جستجو"
                                      disclosed="true"
                                      value="#{bindings.SeeAlsoProviderVCQuery.queryDescriptor}"
                                      model="#{bindings.SeeAlsoProviderVCQuery.queryModel}"
                                      queryListener="#{bindings.SeeAlsoProviderVCQuery.processQuery}"
                                      queryOperationListener="#{bindings.SeeAlsoProviderVCQuery.processQueryOperation}"
                                      rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        
                        <f:facet name="toolbar">
                     
                            <af:toolbar id="t3">
                            <fadak:ToolbarSet iteratorname="MainSeeAlsoProvider1Iterator" id="ts2"
                                                showcommit="true"
                                                showcreate="false"
                                                showdelete="false"
                                                showEditCommand="false"
                                                showquery="false"
                                                showrefresh="false"
                                                showrollback="true"
                                                showsearch="false"/>
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
                        <af:panelGroupLayout id="pgl6" layout="horizontal">
                          <af:commandImageLink shortDesc="ایجاد"
                                               icon="/icons/list-add.png"
                                               id="cil2"
                                               action="#{viewScope.persian_provider.mainSeeAlsoProviderCreateInsert}"/>
                          <af:panelFormLayout id="pfl1" rows="2" maxColumns="4"
                            fieldWidth="200" labelWidth="200"
                                              labelAlignment="top">
                            <af:inputText value="#{bindings.Provider11.inputValue}"
                                          label="#{bindings.Provider11.hints.label}"
                                          required="#{bindings.Provider11.hints.mandatory}"
                                          columns="#{bindings.Provider11.hints.displayWidth}"
                                          maximumLength="#{bindings.Provider11.hints.precision}"
                                          shortDesc="#{bindings.Provider11.hints.tooltip}"
                                          id="it1" >
                              <f:validator binding="#{bindings.Provider11.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.ForeignName1.inputValue}"
                                          label="#{bindings.ForeignName1.hints.label}"
                                          required="#{bindings.ForeignName1.hints.mandatory}"
                                          columns="#{bindings.ForeignName1.hints.displayWidth}"
                                          maximumLength="#{bindings.ForeignName1.hints.precision}"
                                          shortDesc="#{bindings.ForeignName1.hints.tooltip}"
                                          id="it2" >
                              <f:validator binding="#{bindings.ForeignName1.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.BDDate.inputValue}"
                                          label="#{bindings.BDDate.hints.label}"
                                          required="#{bindings.BDDate.hints.mandatory}"
                                          columns="#{bindings.BDDate.hints.displayWidth}"
                                          maximumLength="#{bindings.BDDate.hints.precision}"
                                          shortDesc="#{bindings.BDDate.hints.tooltip}"
                                          id="it3" >
                              <f:validator binding="#{bindings.BDDate.validator}"/>
                            </af:inputText>
                            <af:selectOneChoice value="#{bindings.ProviderKind1.inputValue}"
                                                label="#{bindings.ProviderKind1.label}"
                                                required="#{bindings.ProviderKind1.hints.mandatory}"
                                                shortDesc="#{bindings.ProviderKind1.hints.tooltip}"
                                                id="soc2" >
                              <f:selectItems value="#{bindings.ProviderKind1.items}"
                                             id="si2"/>
                            </af:selectOneChoice>
                          </af:panelFormLayout>
                        </af:panelGroupLayout>
                        <af:spacer width="10" height="10" id="s2"/>
                        <af:panelCollection id="pc2"
                                            inlineStyle="width:60%; height:150.0px;">
                       
                       <f:facet name="toolbar"/>
                          <f:facet name="menus"/>
                          
                          <f:facet name="statusbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t5">
                              <af:commandImageLink disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   id="cil4"
                                                   action="#{pageFlowScope.TFBean.ref_select_provider}"
                                                   icon="/icons/list-add.png"
                                                   shortDesc="ایجاد"
                                                   actionListener="#{viewScope.persian_provider.applyReadingOrderVCActionListener}">
                                <af:setActionListener from="#{'1'}"
                                                      to="#{pageFlowScope.refProvReadingOrder}"/>
                                <af:setActionListener from="#{'see also'}"
                                                      to="#{pageFlowScope.refProvTab}"/>
                              </af:commandImageLink>
                              <af:commandImageLink actionListener="#{bindings.Delete1.execute}"
                                               shortDesc="حذف"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.SeeAlsoProviderVo1.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                 partialTriggers="t4"
                                                   icon="/icons/list-remove.png"
                                                   id="cil5"/>
                              <%--    <af:commandImageLink shortDesc="حذف"
                                                   partialSubmit="true"
                                                   disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                                   actionListener="#{viewScope.persian_provider.removeDetailActionListener}"
                                                   icon="/icons/list-remove.png"
                                                   id="cil5">
                                <af:setActionListener from="#{'see also'}"
                                                      to="#{viewScope.persian_provider.tab}"/>
                              </af:commandImageLink> --%>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.SeeAlsoProviderVo1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeeAlsoProviderVo1.rangeSize}"
                                    emptyText="#{bindings.SeeAlsoProviderVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeeAlsoProviderVo1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.SeeAlsoProviderVo1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeeAlsoProviderVo1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeeAlsoProviderVo1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeeAlsoProviderVo1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t4" partialTriggers=":::r1 ::cil5"
                                    columnStretching="column:c8">
                            <af:column sortProperty="ProviderText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.label}"
                                       id="c8">
                              <af:inputText value="#{row.bindings.ProviderText.inputValue}"
                                            label="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.label}"
                                            required="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.mandatory}"
                                            columns="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.precision}"
                                            shortDesc="#{bindings.SeeAlsoProviderVo1.hints.ProviderText.tooltip}"
                                            id="it11" readOnly="true">
                                <f:validator binding="#{row.bindings.ProviderText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="ForeignNameText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.label}"
                                       id="c5">
                              <af:inputText value="#{row.bindings.ForeignNameText.inputValue}"
                                            label="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.label}"
                                            required="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.mandatory}"
                                            columns="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.precision}"
                                            shortDesc="#{bindings.SeeAlsoProviderVo1.hints.ForeignNameText.tooltip}"
                                            id="it10" readOnly="true">
                                <f:validator binding="#{row.bindings.ForeignNameText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="BDDateText"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.label}"
                                       id="c6">
                              <af:inputText value="#{row.bindings.BDDateText.inputValue}"
                                            label="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.label}"
                                            required="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.mandatory}"
                                            columns="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.displayWidth}"
                                            maximumLength="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.precision}"
                                            shortDesc="#{bindings.SeeAlsoProviderVo1.hints.BDDateText.tooltip}"
                                            id="it12" readOnly="true">
                                <f:validator binding="#{row.bindings.BDDateText.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="ProviderKind"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.SeeAlsoProviderVo1.hints.ProviderKind.label}"
                                       id="c7">
                              <af:selectOneChoice value="#{row.bindings.ProviderKind.inputValue}"
                                                  label="#{row.bindings.ProviderKind.label}"
                                                  required="#{bindings.SeeAlsoProviderVo1.hints.ProviderKind.mandatory}"
                                                  shortDesc="#{bindings.SeeAlsoProviderVo1.hints.ProviderKind.tooltip}"
                                                  id="soc4" readOnly="true">
                                <f:selectItems value="#{row.bindings.ProviderKind.items}"
                                               id="si4"/>
                              </af:selectOneChoice>
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
      <af:panelWindow title="پدید آور" modal="true"
                      closeIconVisible="true">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigation}" />
      </af:panelWindow>
      </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>