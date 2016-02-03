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
         <af:panelHeader text="Provider refers" helpTopicId="latinProvider">
         <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="See Provider" id="sdi1" stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="150">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl3">
                      <af:panelHeader text=" " id="ph2">
                        <af:query id="qryId2" headerText="Search"
                                  disclosed="true"
                                  value="#{bindings.ProviderVCQuery.queryDescriptor}"
                                  model="#{bindings.ProviderVCQuery.queryModel}"
                                  queryListener="#{bindings.ProviderVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.ProviderVCQuery.processQueryOperation}"
                                  rows="2" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                        <f:facet name="toolbar">
                        
                        <af:toolbar id="t1">
                            
                            <fadak:ToolbarSet iteratorname="LatinMainSeeProviderIterator"
                                              id="ts1" showquery="false"
                                              showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
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
                    <af:panelBox text=" " id="pb1" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl2" layout="vertical"
                                           valign="middle" halign="center"
                                          partialTriggers="qryId2">
            <af:panelGroupLayout id="pgl5" layout="horizontal">
             <af:commandImageLink shortDesc="Create" icon="/icons/list-add.png"
                                  id="cil1"
                                  action="#{viewScope.latin_provider.latinMainSeeCreateInsert}"/>
             <af:panelFormLayout id="pfl2" rows="2" maxColumns="4"
                                 fieldWidth="200" labelWidth="200"
                                 labelAlignment="top">
              <af:inputText value="#{bindings.Provider11.inputValue}"
                            label="#{bindings.Provider11.hints.label}"
                            required="#{bindings.Provider11.hints.mandatory}"
                            columns="#{bindings.Provider11.hints.displayWidth}"
                            maximumLength="#{bindings.Provider11.hints.precision}"
                            shortDesc="#{bindings.Provider11.hints.tooltip}"
                            id="it4">
               <f:validator binding="#{bindings.Provider11.validator}"/>
              </af:inputText>
              <af:inputText value="#{bindings.ForeignName1.inputValue}"
                            label="#{bindings.ForeignName1.hints.label}"
                            required="#{bindings.ForeignName1.hints.mandatory}"
                            columns="#{bindings.ForeignName1.hints.displayWidth}"
                            maximumLength="#{bindings.ForeignName1.hints.precision}"
                            shortDesc="#{bindings.ForeignName1.hints.tooltip}"
                            id="it5">
               <f:validator binding="#{bindings.ForeignName1.validator}"/>
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
              <af:selectOneChoice value="#{bindings.ProviderKind.inputValue}"
                                  label="#{bindings.ProviderKind.label}"
                                  required="#{bindings.ProviderKind.hints.mandatory}"
                                  shortDesc="#{bindings.ProviderKind.hints.tooltip}"
                                  id="soc4">
               <f:selectItems value="#{bindings.ProviderKind.items}" id="si4"/>
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
                                    action="#{pageFlowScope.TFBean.ref_select_provider}"
                                    icon="/icons/list-add.png"
                                    shortDesc="Create" id="cil3"
                                    actionListener="#{viewScope.latin_provider.applyReadingOrderVCActionListener}">
                <af:setActionListener from="#{'2'}"
                                      to="#{pageFlowScope.refProvReadingOrder}"/>
                <af:setActionListener from="#{'latin see'}"
                                      to="#{pageFlowScope.refProvTab}"/>
               </af:commandImageLink>
               <af:commandImageLink actionListener="#{bindings.Delete.execute}"
                                  shortDesc="Remove" partialSubmit="true"
                                    disabled="#{bindings.LatinSeeProvider.currentRow==null || bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                    partialTriggers="t3"
                                    icon="/icons/list-remove.png" 
                                    id="cil4"/>
               <%--     <af:commandImageLink shortDesc="Remove" partialSubmit="true"
                                    disabled="#{bindings.ArtId.inputValue.value<0 || bindings.ArtId.inputValue==null}"
                                    actionListener="#{viewScope.latin_provider.removeDetailActionListener}"
                                    icon="/icons/list-remove.png" id="cil4">
                <af:setActionListener from="#{'latin see'}"
                                      to="#{viewScope.latin_provider.tab}"/>
               </af:commandImageLink>--%>
              </af:toolbar>
             </f:facet>
             <af:table value="#{bindings.LatinSeeProvider.collectionModel}"
                       var="row" rows="#{bindings.LatinSeeProvider.rangeSize}"
                       emptyText="#{bindings.LatinSeeProvider.viewable ? 'No data to display.' : 'Access Denied.'}"
                       fetchSize="#{bindings.LatinSeeProvider.rangeSize}"
                       rowBandingInterval="0"
                       filterModel="#{bindings.LatinSeeProviderQuery.queryDescriptor}"
                       queryListener="#{bindings.LatinSeeProviderQuery.processQuery}"
                       filterVisible="true" varStatus="vs"
                       selectedRowKeys="#{bindings.LatinSeeProvider.collectionModel.selectedRow}"
                       selectionListener="#{bindings.LatinSeeProvider.collectionModel.makeCurrent}"
                       rowSelection="single" id="t3" partialTriggers=":::r1 ::cil4"
                       columnStretching="column:c1">
              <af:column sortProperty="ProviderText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeProvider.hints.ProviderText.label}"
                         id="c1">
               <af:inputText value="#{row.bindings.ProviderText.inputValue}"
                             label="#{bindings.LatinSeeProvider.hints.ProviderText.label}"
                             required="#{bindings.LatinSeeProvider.hints.ProviderText.mandatory}"
                             columns="#{bindings.LatinSeeProvider.hints.ProviderText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeProvider.hints.ProviderText.precision}"
                             shortDesc="#{bindings.LatinSeeProvider.hints.ProviderText.tooltip}"
                             id="it9" readOnly="true"> 
                <f:validator binding="#{row.bindings.ProviderText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="ForeignNameText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeProvider.hints.ForeignNameText.label}"
                         id="c4">
               <af:inputText value="#{row.bindings.ForeignNameText.inputValue}"
                             label="#{bindings.LatinSeeProvider.hints.ForeignNameText.label}"
                             required="#{bindings.LatinSeeProvider.hints.ForeignNameText.mandatory}"
                             columns="#{bindings.LatinSeeProvider.hints.ForeignNameText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeProvider.hints.ForeignNameText.precision}"
                             shortDesc="#{bindings.LatinSeeProvider.hints.ForeignNameText.tooltip}"
                             id="it8" readOnly="true">
                <f:validator binding="#{row.bindings.ForeignNameText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="BDDateText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeProvider.hints.BDDateText.label}"
                         id="c2">
               <af:inputText value="#{row.bindings.BDDateText.inputValue}"
                             label="#{bindings.LatinSeeProvider.hints.BDDateText.label}"
                             required="#{bindings.LatinSeeProvider.hints.BDDateText.mandatory}"
                             columns="#{bindings.LatinSeeProvider.hints.BDDateText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeProvider.hints.BDDateText.precision}"
                             shortDesc="#{bindings.LatinSeeProvider.hints.BDDateText.tooltip}"
                             id="it7" readOnly="true">
                <f:validator binding="#{row.bindings.BDDateText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="ProviderKind" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeProvider.hints.ProviderKind.label}"
                         id="c3">
               <af:selectOneChoice value="#{row.bindings.ProviderKind.inputValue}"
                                   label="#{row.bindings.ProviderKind.label}"
                                   required="#{bindings.LatinSeeProvider.hints.ProviderKind.mandatory}"
                                   shortDesc="#{bindings.LatinSeeProvider.hints.ProviderKind.tooltip}"
                                   id="soc1" readOnly="true">
                <f:selectItems value="#{row.bindings.ProviderKind.items}"
                               id="si1"/>
               </af:selectOneChoice>
              </af:column>
             </af:table>
            </af:panelCollection>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
              <af:showDetailItem text="See also Provider" id="sdi2"
                                 stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps1" splitterPosition="150"
                                  orientation="vertical">
                  <f:facet name="first">
                      <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text=" " id="ph1">
                        <af:query id="qryId1" headerText="Search"
                                  disclosed="true"
                                  value="#{bindings.SeeAlsoProviderVCQuery.queryDescriptor}"
                                  model="#{bindings.SeeAlsoProviderVCQuery.queryModel}"
                                  queryListener="#{bindings.SeeAlsoProviderVCQuery.processQuery}"
                                  queryOperationListener="#{bindings.SeeAlsoProviderVCQuery.processQueryOperation}"
                                  rows="2" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                                  
                                    <f:facet name="toolbar">
                        
                        <af:toolbar id="t4">
                            
                            <fadak:ToolbarSet iteratorname="LatinMainSeeAlsoProviderIterator"
                                              id="ts2" showquery="false"
                                              showcommit="true"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
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
            <af:panelGroupLayout id="pgl6" layout="horizontal">
             <af:commandImageLink shortDesc="Create" icon="/icons/list-add.png"
                                  action="#{viewScope.latin_provider.latinMainSeeAlsoCreateInsert}"
                                  id="cil2"/>
             <af:panelFormLayout id="pfl1" rows="2" maxColumns="4"
                                 fieldWidth="200" labelWidth="200"
                                 labelAlignment="top">
              <af:inputText value="#{bindings.Provider1.inputValue}"
                            label="#{bindings.Provider1.hints.label}"
                            required="#{bindings.Provider1.hints.mandatory}"
                            columns="#{bindings.Provider1.hints.displayWidth}"
                            maximumLength="#{bindings.Provider1.hints.precision}"
                            shortDesc="#{bindings.Provider1.hints.tooltip}"
                            id="it1">
               <f:validator binding="#{bindings.Provider1.validator}"/>
              </af:inputText>
              <af:inputText value="#{bindings.ForeignName.inputValue}"
                            label="#{bindings.ForeignName.hints.label}"
                            required="#{bindings.ForeignName.hints.mandatory}"
                            columns="#{bindings.ForeignName.hints.displayWidth}"
                            maximumLength="#{bindings.ForeignName.hints.precision}"
                            shortDesc="#{bindings.ForeignName.hints.tooltip}"
                            id="it2">
               <f:validator binding="#{bindings.ForeignName.validator}"/>
              </af:inputText>
              <af:inputText value="#{bindings.BDDate.inputValue}"
                            label="#{bindings.BDDate.hints.label}"
                            required="#{bindings.BDDate.hints.mandatory}"
                            columns="#{bindings.BDDate.hints.displayWidth}"
                            maximumLength="#{bindings.BDDate.hints.precision}"
                            shortDesc="#{bindings.BDDate.hints.tooltip}"
                            id="it3">
               <f:validator binding="#{bindings.BDDate.validator}"/>
              </af:inputText>
              <af:selectOneChoice value="#{bindings.ProviderKind1.inputValue}"
                                  label="#{bindings.ProviderKind1.label}"
                                  required="#{bindings.ProviderKind1.hints.mandatory}"
                                  shortDesc="#{bindings.ProviderKind1.hints.tooltip}"
                                  id="soc3">
               <f:selectItems value="#{bindings.ProviderKind1.items}" id="si3"/>
              </af:selectOneChoice>
             </af:panelFormLayout>
             <f:facet name="separator"/>
            </af:panelGroupLayout>
            <af:spacer width="10" height="10" id="s2"/>
            <af:panelCollection id="pc2"
                                            inlineStyle="width:60%; height:150.0px;">
                         
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
             <f:facet name="secondaryToolbar">
              <af:toolbar id="t8">
               <af:commandImageLink disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                    action="#{pageFlowScope.TFBean.ref_select_provider}"
                                    icon="/icons/list-add.png"
                                    shortDesc="Create" id="cil5"
                                    actionListener="#{viewScope.latin_provider.applyReadingOrderVCActionListener}">
                <af:setActionListener from="#{'2'}"
                                      to="#{pageFlowScope.refProvReadingOrder}"/>
                <af:setActionListener from="#{'latin see also'}"
                                      to="#{pageFlowScope.refProvTab}"/>
               </af:commandImageLink>
               <af:commandImageLink actionListener="#{bindings.Delete1.execute}"
                                 disabled="#{bindings.LatinSeeAlsoProviderVo.currentRow==null || bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                    shortDesc="Remove" partialSubmit="true"
                                   partialTriggers="t2"
                                    icon="/icons/list-remove.png" 
                                    id="cil6"/>
               <%--     <af:commandImageLink disabled="#{bindings.ArtId1.inputValue.value<0 || bindings.ArtId1.inputValue==null}"
                                    shortDesc="Remove" partialSubmit="true"
                                    actionListener="#{viewScope.latin_provider.removeDetailActionListener}"
                                    icon="/icons/list-remove.png" id="cil6">
                <af:setActionListener from="#{'latin see also'}"
                                      to="#{viewScope.latin_provider.tab}"/>
               </af:commandImageLink> --%>
              </af:toolbar>
             </f:facet>
             <af:table value="#{bindings.LatinSeeAlsoProviderVo.collectionModel}"
                       var="row"
                       rows="#{bindings.LatinSeeAlsoProviderVo.rangeSize}"
                       emptyText="#{bindings.LatinSeeAlsoProviderVo.viewable ? 'No data to display.' : 'Access Denied.'}"
                       fetchSize="#{bindings.LatinSeeAlsoProviderVo.rangeSize}"
                       rowBandingInterval="0"
                       filterModel="#{bindings.LatinSeeAlsoProviderVoQuery.queryDescriptor}"
                       queryListener="#{bindings.LatinSeeAlsoProviderVoQuery.processQuery}"
                       filterVisible="true" varStatus="vs"
                       selectedRowKeys="#{bindings.LatinSeeAlsoProviderVo.collectionModel.selectedRow}"
                       selectionListener="#{bindings.LatinSeeAlsoProviderVo.collectionModel.makeCurrent}"
                       rowSelection="single" id="t2" partialTriggers=":::r1 ::cil6"
                       columnStretching="column:c5">
              <af:column sortProperty="ProviderText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.label}"
                         id="c5">
               <af:inputText value="#{row.bindings.ProviderText.inputValue}"
                             label="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.label}"
                             required="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.mandatory}"
                             columns="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.precision}"
                             shortDesc="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderText.tooltip}"
                             id="it10" readOnly="true">
                <f:validator binding="#{row.bindings.ProviderText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="ForeignNameText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.label}"
                         id="c8">
               <af:inputText value="#{row.bindings.ForeignNameText.inputValue}"
                             label="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.label}"
                             required="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.mandatory}"
                             columns="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.precision}"
                             shortDesc="#{bindings.LatinSeeAlsoProviderVo.hints.ForeignNameText.tooltip}"
                             id="it12" readOnly="true">
                <f:validator binding="#{row.bindings.ForeignNameText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="BDDateText" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.label}"
                         id="c7">
               <af:inputText value="#{row.bindings.BDDateText.inputValue}"
                             label="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.label}"
                             required="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.mandatory}"
                             columns="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.displayWidth}"
                             maximumLength="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.precision}"
                             shortDesc="#{bindings.LatinSeeAlsoProviderVo.hints.BDDateText.tooltip}"
                             id="it11" readOnly="true">
                <f:validator binding="#{row.bindings.BDDateText.validator}"/>
               </af:inputText>
              </af:column>
              <af:column sortProperty="ProviderKind" filterable="true"
                         sortable="true"
                         headerText="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderKind.label}"
                         id="c6">
               <af:selectOneChoice value="#{row.bindings.ProviderKind.inputValue}"
                                   label="#{row.bindings.ProviderKind.label}"
                                   required="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderKind.mandatory}"
                                   shortDesc="#{bindings.LatinSeeAlsoProviderVo.hints.ProviderKind.tooltip}"
                                   id="soc2" readOnly="true">
                <f:selectItems value="#{row.bindings.ProviderKind.items}"
                               id="si2"/>
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
      <af:panelWindow title="Provider" modal="true"
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