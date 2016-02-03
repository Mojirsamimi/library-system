<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
${sessionUser.authorization}
<f:view locale="en">
  <af:document id="d1">
    <af:resource type="javascript" source="/js/handleDblClick.js"/>
    <af:messages id="m1"/>
    <af:form id="f1" usesUpload="true">
      <af:popup id="tf" contentDelivery="lazyUncached"
                binding="#{pageFlowScope.TFBean.region_popup}">
        <af:panelWindow title="#{viewcontrollerBundle.SELECT}" id="pw3"
                        modal="true" contentHeight="600" contentWidth="700">
          <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                     regionNavigationListener="#{pageFlowScope.TFBean.navigation}"/>
        </af:panelWindow>
      </af:popup>
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
          <af:panelTabbed id="pt2">
            <af:showDetailItem stretchChildren="first"
                               text="#{viewcontrollerBundle.cataloging_phyisical_description}"
                               id="sdi2">
              <af:panelGroupLayout layout="scroll" id="pgl10">
                <af:showDetailHeader text="#{viewcontrollerBundle.cataloging_book_cataloging}"
                                     disclosed="true" id="sdh1"
                                     helpTopicId="englishCataloging">
                  <f:facet name="toolbar">
                    <af:toolbar id="t1">
                      <af:group id="g1">
                        <af:commandButton id="cb3"
                                          actionListener="#{viewScope.back.preview_btnp}"
                                          disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                          action="#{viewScope.back.preview_btn}"
                                          text="#{viewcontrollerBundle.cataloging_preview}"/>
                      </af:group>
                      <fadak:ToolbarSet debug="true"
                                        iteratorname="VirtualBookVO1Iterator"
                                        id="ts1"
                                        RollbackAfterUnsuccessfulCommit="false"
                                        after_create="#{viewScope.back.create_English}"
                                        lang="english"></fadak:ToolbarSet>
                    </af:toolbar>
                  </f:facet>
                  <af:panelBox disclosed="true" id="pb10">
                    <af:query id="qryId1" disclosed="true"
                              value="#{bindings.ImplicitViewCriteriaQuery.queryDescriptor}"
                              model="#{bindings.ImplicitViewCriteriaQuery.queryModel}"
                              queryListener="#{bindings.ImplicitViewCriteriaQuery.processQuery}"
                              queryOperationListener="#{bindings.ImplicitViewCriteriaQuery.processQueryOperation}"
                              rows="3" maxColumns="3"
                              resultComponentId="::pgl10"
                              modeChangeVisible="false" saveQueryMode="hidden"
                              headerText="#{viewcontrollerBundle.cataloging_search}"/>
                  </af:panelBox>
                  <af:panelBox id="pb1"
                               text="#{viewcontrollerBundle.cataloging_book}">
                    <af:panelFormLayout rows="4" maxColumns="4" id="pfl2"
                                        labelWidth="100">
                      <af:inputText value="#{bindings.CallNo.inputValue}"
                                    label="#{bindings.CallNo.hints.label}"
                                    required="#{bindings.CallNo.hints.mandatory}"
                                    columns="#{bindings.CallNo.hints.displayWidth}"
                                    maximumLength="#{bindings.CallNo.hints.precision}"
                                    shortDesc="#{bindings.CallNo.hints.tooltip}"
                                    id="it1" styleClass="AFFieldTextLTRMarker">
                        <f:validator binding="#{bindings.CallNo.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.CallNoType.inputValue}"
                                          label="#{bindings.CallNoType.label}"
                                          required="#{bindings.CallNoType.hints.mandatory}"
                                          shortDesc="#{bindings.CallNoType.hints.tooltip}"
                                          id="soc1">
                        <f:selectItems value="#{bindings.CallNoType.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                      <af:panelLabelAndMessage label="#{bindings.CNT.hints.label}"
                                               id="plam1">
                        <af:inputText value="#{bindings.CNT.inputValue}"
                                      disabled="true" id="ot1"/>
                      </af:panelLabelAndMessage>
                      <af:inputText value="#{bindings.InsertDate.inputValue}"
                                    label="#{bindings.InsertDate.hints.label}"
                                    required="#{bindings.InsertDate.hints.mandatory}"
                                    readOnly="true"
                                    columns="#{bindings.InsertDate.hints.displayWidth}"
                                    maximumLength="#{bindings.InsertDate.hints.precision}"
                                    shortDesc="#{bindings.InsertDate.hints.tooltip}"
                                    id="it2">
                        <f:validator binding="#{bindings.InsertDate.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.InsertDate.format}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.ActiveStatus.inputValue}"
                                          label="#{bindings.ActiveStatus.label}"
                                          required="#{bindings.ActiveStatus.hints.mandatory}"
                                          shortDesc="#{bindings.ActiveStatus.hints.tooltip}"
                                          id="soc2">
                        <f:selectItems value="#{bindings.ActiveStatus.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                      <af:selectOneChoice value="#{bindings.Cutter.inputValue}"
                                          label="#{bindings.Cutter.label}"
                                          required="#{bindings.Cutter.hints.mandatory}"
                                          shortDesc="#{bindings.Cutter.hints.tooltip}"
                                          id="soc3">
                        <f:selectItems value="#{bindings.Cutter.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox value="#{bindings.Reference.inputValue}"
                                                label="#{bindings.Reference.label}"
                                                shortDesc="#{bindings.Reference.hints.tooltip}"
                                                id="sbc1"/>
                      <af:inputText value="#{bindings.VolumeCount.inputValue}"
                                    label="#{bindings.VolumeCount.hints.label}"
                                    required="#{bindings.VolumeCount.hints.mandatory}"
                                    columns="4" maximumLength="3"
                                    shortDesc="#{bindings.VolumeCount.hints.tooltip}"
                                    id="it7">
                        <f:validator binding="#{bindings.VolumeCount.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.VolumeCount.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ArtId.inputValue}"
                                    label="#{bindings.ArtId.hints.label}"
                                    required="#{bindings.ArtId.hints.mandatory}"
                                    columns="#{bindings.ArtId.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId.hints.precision}"
                                    shortDesc="#{bindings.ArtId.hints.tooltip}"
                                    id="it8" readOnly="true">
                        <f:validator binding="#{bindings.ArtId.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.UserName.inputValue}"
                                    label="#{bindings.UserName.hints.label}"
                                    required="#{bindings.UserName.hints.mandatory}"
                                    columns="#{bindings.UserName.hints.displayWidth}"
                                    maximumLength="#{bindings.UserName.hints.precision}"
                                    shortDesc="#{bindings.UserName.hints.tooltip}"
                                    id="it28" readOnly="true">
                        <f:validator binding="#{bindings.UserName.validator}"/>
                      </af:inputText>
                      <af:panelGroupLayout id="pgl14" layout="horizontal">
                        <af:spacer id="s3" width="5"/>
                      </af:panelGroupLayout>
                    </af:panelFormLayout>
                  </af:panelBox>
                  <af:separator id="s1"/>
                  <af:panelBox id="pb2"
                               text="#{viewcontrollerBundle.cataloging_provider}"
                               inlineStyle="text-align:right;"
                               disclosed="false">
                    <f:facet name="toolbar"/>
                    <af:panelGroupLayout id="pgl3" layout="horizontal">
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_information}"
                                      id="ph1">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelFormLayout rows="3" partialTriggers="::r1"
                                            id="pfl1" maxColumns="2"
                                            labelWidth="100" fieldWidth="245">
                          <af:inputText value="#{bindings.Provider1.inputValue}"
                                        label="#{bindings.Provider1.hints.label}"
                                        required="#{bindings.Provider1.hints.mandatory}"
                                        columns="#{bindings.Provider1.hints.displayWidth}"
                                        maximumLength="#{bindings.Provider1.hints.precision}"
                                        shortDesc="#{bindings.Provider1.hints.tooltip}"
                                        id="it6" readOnly="true">
                            <f:validator binding="#{bindings.Provider1.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.ForeignName.inputValue}"
                                        label="#{bindings.ForeignName.hints.label}"
                                        required="#{bindings.ForeignName.hints.mandatory}"
                                        columns="#{bindings.ForeignName.hints.displayWidth}"
                                        maximumLength="#{bindings.ForeignName.hints.precision}"
                                        shortDesc="#{bindings.ForeignName.hints.tooltip}"
                                        id="it39" readOnly="true">
                            <f:validator binding="#{bindings.ForeignName.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.BDDate.inputValue}"
                                        label="#{bindings.BDDate.hints.label}"
                                        required="#{bindings.BDDate.hints.mandatory}"
                                        columns="#{bindings.BDDate.hints.displayWidth}"
                                        maximumLength="#{bindings.BDDate.hints.precision}"
                                        shortDesc="#{bindings.BDDate.hints.tooltip}"
                                        id="it41" readOnly="true">
                            <f:validator binding="#{bindings.BDDate.validator}"/>
                          </af:inputText>
                          <f:facet name="footer">
                            <af:commandButton text="#{viewcontrollerBundle.cataloging_select_provider}"
                                              action="#{pageFlowScope.TFBean.provider}"
                                               disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                              id="cb1" partialSubmit="true">
                              <af:setActionListener from="#{1}"
                                                    to="#{pageFlowScope.mainpage}"/>
                              <af:setActionListener from="#{2}"
                                                    to="#{pageFlowScope.catalogingReadingOrder}"/>
                            </af:commandButton>
                          </f:facet>
                        </af:panelFormLayout>
                      </af:panelHeader>
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_role}"
                                      id="ph3">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar">
                          <af:toolbar id="t23">
                            <af:commandImageLink action="#{pageFlowScope.TFBean.providerRole}"
                                                 shortDesc="#{viewcontrollerBundle.cataloging_add}"
                                                 immediate="true"
                                                 partialSubmit="true"
                                                 icon="/icons/list-add.png"
                                                 id="cil7">
                              <af:setActionListener from="#{1}"
                                                    to="#{pageFlowScope.mainpage}"/>
                              <af:setActionListener from="#{2}"
                                                    to="#{pageFlowScope.catalogingReadingOrder}"/>
                            </af:commandImageLink>
                            <af:commandImageLink shortDesc="#{viewcontrollerBundle.cataloging_remove}"
                                                 disabled="#{!bindings.Delete.enabled}"
                                                 id="cil6"
                                                 partialSubmit="true"
                                                 icon="/icons/list-remove.png"
                                                 action="#{viewScope.back.remove_role}"/>
                          </af:toolbar>
                        </f:facet>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:selectOneListbox value="#{bindings.VbookMainProviderVO11.inputValue}"
                                             label=""
                                             required="#{bindings.VbookMainProviderVO11.hints.mandatory}"
                                             shortDesc="#{bindings.VbookMainProviderVO11.hints.tooltip}"
                                             id="sol1"
                                             inlineStyle="width:200.0px;"
                                             partialTriggers="::r1 cil6">
                          <f:selectItems value="#{bindings.VbookMainProviderVO11.items}"
                                         id="si8"/>
                        </af:selectOneListbox>
                      </af:panelHeader>
                      <af:panelFormLayout id="pfl12">
                        <f:facet name="footer"/>
                        <af:inputText value="#{bindings.RepAuthor.inputValue}"
                                      label="#{bindings.RepAuthor.hints.label}"
                                      required="#{bindings.RepAuthor.hints.mandatory}"
                                      columns="50"
                                      maximumLength="#{bindings.RepAuthor.hints.precision}"
                                      shortDesc="#{bindings.RepAuthor.hints.tooltip}"
                                      id="it10">
                          <f:validator binding="#{bindings.RepAuthor.validator}"/>
                        </af:inputText>
                      </af:panelFormLayout>
                    </af:panelGroupLayout>
                  </af:panelBox>
                  <af:separator/>
                  <af:panelBox id="pb3" disclosed="false"
                               text="#{viewcontrollerBundle.cataloging_title}">
                    <af:panelGroupLayout id="pgl12" layout="horizontal">
                      <af:panelFormLayout rows="1" maxColumns="4" id="pfl3"
                                          labelWidth="100"
                                          partialTriggers="::r1">
                        <f:facet name="footer">
                          <af:commandButton action="#{pageFlowScope.TFBean.uniformtitle}"
                                            shortDesc="#{viewcontrollerBundle.cataloging_select_uniform_title}"
                                             disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                            text="#{viewcontrollerBundle.cataloging_select_uniform_title}"
                                            id="cb2" partialSubmit="true">
                            <af:setActionListener from="#{1}"
                                                  to="#{pageFlowScope.mainpage}"/>
                            <af:setActionListener from="#{2}"
                                                  to="#{pageFlowScope.catalogingReadingOrder}"/>
                          </af:commandButton>
                        </f:facet>
                        <af:panelGroupLayout layout="horizontal" id="pgl1"
                                             partialTriggers="::r1">
                          <af:inputText value="#{bindings.Title1.inputValue}"
                                        label="#{bindings.Title1.hints.label}"
                                        required="#{bindings.Title1.hints.mandatory}"
                                        columns="#{bindings.Title1.hints.displayWidth}"
                                        maximumLength="#{bindings.Title1.hints.precision}"
                                        shortDesc="#{bindings.Title1.hints.tooltip}"
                                        id="it35" partialTriggers="::r1 cil3"
                                        readOnly="true">
                            <f:validator binding="#{bindings.Title1.validator}"/>
                          </af:inputText>
                          <af:selectBooleanCheckbox value="#{bindings.UniformTitlePrintable.inputValue}"
                                                    simple="true"
                                                    shortDesc="#{bindings.UniformTitlePrintable.hints.tooltip}"
                                                    id="sbc4"/>
                          <af:commandImageLink partialSubmit="true"
                                               rendered="#{bindings.VirtualBookVO1Iterator.currentRow.uniformTitle1!=null}"
                                               id="cil3"
                                               shortDesc="#{viewcontrollerBundle.cataloging_remove}"
                                               actionListener="#{viewScope.back.removeUniformTitleMainPage}"
                                               icon="/icons/Function Free Icon/cross_16.png"/>
                        </af:panelGroupLayout>
                      </af:panelFormLayout>
                      <af:panelFormLayout id="pfl10" maxColumns="10" rows="2">
                        <f:facet name="footer"/>
                        <af:panelLabelAndMessage id="plam5"
                                                 label="#{bindings.Title.hints.label}">
                          <af:inputText value="#{bindings.Title.inputValue}"
                                        simple="true"
                                        required="true"
                                        columns="#{bindings.Title.hints.displayWidth}"
                                        maximumLength="#{bindings.Title.hints.precision}"
                                        shortDesc="#{bindings.Title.hints.tooltip}"
                                        id="it3">
                            <f:validator binding="#{bindings.Title.validator}"/>
                          </af:inputText>
                          <af:selectBooleanCheckbox value="#{bindings.TitlePrintable.inputValue}"
                                                    simple="true"
                                                    shortDesc="#{bindings.TitlePrintable.hints.tooltip}"
                                                    id="sbc3"/>
                        </af:panelLabelAndMessage>
                        <af:panelLabelAndMessage label="#{bindings.OrigTitle.hints.label}"
                                                 id="plam2">
                          <af:inputText value="#{bindings.OrigTitle.inputValue}"
                                        simple="true"
                                        required="#{bindings.OrigTitle.hints.mandatory}"
                                        columns="#{bindings.OrigTitle.hints.displayWidth}"
                                        maximumLength="#{bindings.OrigTitle.hints.precision}"
                                        shortDesc="#{bindings.OrigTitle.hints.tooltip}"
                                        id="it4">
                            <f:validator binding="#{bindings.OrigTitle.validator}"/>
                          </af:inputText>
                        </af:panelLabelAndMessage>
                      </af:panelFormLayout>
                    </af:panelGroupLayout>
                  </af:panelBox>
                  <af:separator/>
                  <af:panelBox id="pb4" 
                               text="#{viewcontrollerBundle.cataloging_publisher}"
                               disclosed="false">
                    <af:panelGroupLayout layout="horizontal" id="pgl2">
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_information}"
                                      id="ph7" size="-1" type="stretch"
                                      inlineStyle="height:150px;">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelCollection featuresOff="statusBar 	viewMenu detach"
                                            id="pc6"
                                            styleClass="AFStretchWidth">
                          <af:table value="#{bindings.VbookPublisherVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.VbookPublisherVO1.rangeSize}"
                                    emptyText="#{bindings.VbookPublisherVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.VbookPublisherVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    selectedRowKeys="#{bindings.VbookPublisherVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.VbookPublisherVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t2" first="0"
                                    contentDelivery="immediate"
                                    autoHeightRows="3" displayRow="selected"
                                    partialTriggers="::::r1 ::ts12"
                                    columnStretching="column:c1"
                                    inlineStyle="height:75.0px;">
                            <af:column id="c5" width="15">
                              <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                            label="#{bindings.VbookPublisherVO1.hints.OrderNo.label}"
                                            required="#{bindings.VbookPublisherVO1.hints.OrderNo.mandatory}"
                                            columns="#{bindings.VbookPublisherVO1.hints.OrderNo.displayWidth}"
                                            maximumLength="#{bindings.VbookPublisherVO1.hints.OrderNo.precision}"
                                            shortDesc="#{bindings.VbookPublisherVO1.hints.OrderNo.tooltip}"
                                            id="it9">
                                <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.VbookPublisherVO1.hints.OrderNo.format}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="Publisher1"
                                       sortable="false"
                                       headerText="#{bindings.VbookPublisherVO1.hints.Publisher1.label}"
                                       id="c1">
                              <af:inputText value="#{row.bindings.Publisher1.inputValue}"
                                            label="#{bindings.VbookPublisherVO1.hints.Publisher1.label}"
                                            required="#{bindings.VbookPublisherVO1.hints.Publisher1.mandatory}"
                                            columns="#{bindings.VbookPublisherVO1.hints.Publisher1.displayWidth}"
                                            maximumLength="#{bindings.VbookPublisherVO1.hints.Publisher1.precision}"
                                            shortDesc="#{bindings.VbookPublisherVO1.hints.Publisher1.tooltip}"
                                            id="it5">
                                <f:validator binding="#{row.bindings.Publisher1.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column headerText="#{bindings.VbookPublisherVO1.hints.Place.label}"
                                       id="c4">
                              <af:outputText value="#{row.Place}" id="ot4"/>
                            </af:column>
                            <af:column width="15" id="c2">
                              <af:selectBooleanCheckbox value="#{row.bindings.Printable.inputValue}"
                                                        label="#{row.bindings.Printable.label}"
                                                        shortDesc="#{bindings.VbookPublisherVO1.hints.Printable.tooltip}"
                                                        id="sbc5"/>
                            </af:column>
                          </af:table>
                          <f:facet name="toolbar">
                            <af:toolbar id="t5" partialTriggers="t2">
                              <af:commandImageLink icon="/icons/list-add.png"
                                                   id="cil8"
                                                   partialSubmit="true"
                                                    disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                   action="#{pageFlowScope.TFBean.publisher}"
                                                   shortDesc="#{viewcontrollerBundle.cataloging_add}">
                                <af:setActionListener from="#{2}"
                                                      to="#{pageFlowScope.catalogingReadingOrder}"/>
                              </af:commandImageLink>
                              <fadak:ToolbarSet iteratorname="VbookPublisherVO1Iterator"
                                                id="ts12" shownext="false"
                                                showprevious="false"
                                                showcreate="false"
                                                showlast="false"
                                                showfirst="false"
                                                showcommit="false"
                                                showrollback="false"
                                                showrefresh="false"
                                                disabled_delete="#{bindings.VbookPublisherVO1Iterator.currentRow==null}"
                                                commitafterdelete="false"/>
                            </af:toolbar>
                          </f:facet>
                        </af:panelCollection>
                      </af:panelHeader>
                      <af:panelFormLayout rows="5" id="pfl4" labelWidth="100">
                        <af:inputText value="#{bindings.Manufacturer.inputValue}"
                                      label="#{bindings.Manufacturer.hints.label}"
                                      required="#{bindings.Manufacturer.hints.mandatory}"
                                      columns="50"
                                      maximumLength="#{bindings.Manufacturer.hints.precision}"
                                      shortDesc="#{bindings.Manufacturer.hints.tooltip}"
                                      id="it11">
                          <f:validator binding="#{bindings.Manufacturer.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.Edition.inputValue}"
                                      label="#{bindings.Edition.hints.label}"
                                      required="#{bindings.Edition.hints.mandatory}"
                                      columns="50"
                                      maximumLength="#{bindings.Edition.hints.precision}"
                                      shortDesc="#{bindings.Edition.hints.tooltip}"
                                      id="it12">
                          <f:validator binding="#{bindings.Edition.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.PubDate.inputValue}"
                                      label="#{bindings.PubDate.hints.label}"
                                      required="#{bindings.PubDate.hints.mandatory}"
                                      columns="50"
                                      maximumLength="#{bindings.PubDate.hints.precision}"
                                      shortDesc="#{bindings.PubDate.hints.tooltip}"
                                      id="it13">
                          <f:validator binding="#{bindings.PubDate.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.GeoAreaCode.inputValue}"
                                      label="#{bindings.GeoAreaCode.hints.label}"
                                      required="#{bindings.GeoAreaCode.hints.mandatory}"
                                      columns="50"
                                      maximumLength="#{bindings.GeoAreaCode.hints.precision}"
                                      shortDesc="#{bindings.GeoAreaCode.hints.tooltip}"
                                      id="it14">
                          <f:validator binding="#{bindings.GeoAreaCode.validator}"/>
                        </af:inputText>
                      </af:panelFormLayout>
                    </af:panelGroupLayout>
                  </af:panelBox>
                  <af:separator/>
                  <af:panelBox id="pb5"
                               text="#{viewcontrollerBundle.farvast_shabak_others}"
                               disclosed="false">
                    <af:panelFormLayout rows="3" id="pfl5" maxColumns="3">
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_farvast}"
                                      id="ph5">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelCollection featuresOff="statusBar 	viewMenu detach"
                                            id="pc7" styleClass="AFStretchWidth"
                                            partialTriggers="ts2">
                          <af:table value="#{bindings.SeriesVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.SeriesVO1.rangeSize}"
                                    emptyText="#{bindings.SeriesVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.SeriesVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    contentDelivery="immediate"
                                    filterModel="#{bindings.SeriesVO1Query.queryDescriptor}"
                                    queryListener="#{bindings.SeriesVO1Query.processQuery}"
                                    filterVisible="false" varStatus="vs"
                                    selectedRowKeys="#{bindings.SeriesVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.SeriesVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t6"
                                    autoHeightRows="3" displayRow="selected"
                                    columnStretching="column:c6"
                                    inlineStyle="height:75.0px;">
                            <af:column width="15" id="c8">
                              <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                            label="#{bindings.SeriesVO1.hints.OrderNo.label}"
                                            required="#{bindings.SeriesVO1.hints.OrderNo.mandatory}"
                                            columns="#{bindings.SeriesVO1.hints.OrderNo.displayWidth}"
                                            maximumLength="#{bindings.SeriesVO1.hints.OrderNo.precision}"
                                            shortDesc="#{bindings.SeriesVO1.hints.OrderNo.tooltip}"
                                            id="it16">
                                <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.SeriesVO1.hints.OrderNo.format}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="Series1" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.SeriesVO1.hints.Series1.label}"
                                       id="c6">
                              <af:inputText value="#{row.bindings.Series1.inputValue}"
                                            label="#{bindings.SeriesVO1.hints.Series1.label}"
                                            required="false"
                                            columns="#{bindings.SeriesVO1.hints.Series1.displayWidth}"
                                            maximumLength="#{bindings.SeriesVO1.hints.Series1.precision}"
                                            shortDesc="#{bindings.SeriesVO1.hints.Series1.tooltip}"
                                            id="it15">
                                <f:validator binding="#{row.bindings.Series1.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column width="15" id="c3">
                              <af:selectBooleanCheckbox value="#{row.bindings.printBoolean.inputValue}"
                                                        label="#{row.bindings.printBoolean.label}"
                                                        shortDesc="#{bindings.SeriesVO1.hints.printBoolean.tooltip}"
                                                        id="sbc2"/>
                            </af:column>
                          </af:table>
                          <f:facet name="toolbar">
                            <af:toolbar id="t7" partialTriggers="t6">
                              <fadak:ToolbarSet iteratorname="SeriesVO1Iterator"
                                                id="ts2" debug="true"
                                                showcommit="false"
                                                showfirst="false"
                                                showlast="false"
                                                shownext="false"
                                                showprevious="false"
                                                showquery="false"
                                                showrefresh="false"
                                                 disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                disabled_delete="#{bindings.SeriesVO1Iterator.currentRow==null}"
                                                showrollback="false"
                                                showsearch="false"
                                                warningChanged="false"
                                                commitafterdelete="false"
                                                partialsubmit="true"
                                                lang="english"/>
                            </af:toolbar>
                          </f:facet>
                        </af:panelCollection>
                      </af:panelHeader>
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_notes}"
                                      id="ph2">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelCollection id="pc1"
                                            featuresOff="statusBar 	viewMenu detach"
                                            styleClass="AFStretchWidth"
                                            partialTriggers="ts3">
                          <f:facet name="toolbar">
                            <af:toolbar id="t9" partialTriggers="t8">
                              <fadak:ToolbarSet iteratorname="NoteVO1Iterator"
                                                id="ts3" debug="true"
                                                showcommit="false"
                                                showfirst="false"
                                                showlast="false"
                                                warningChanged="false"
                                                shownext="false"
                                                showprevious="false"
                                                 disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                disabled_delete="#{bindings.NoteVO1Iterator.currentRow==null}"
                                                showquery="false"
                                                showrefresh="false"
                                                showrollback="false"
                                                showsearch="false"
                                                partialsubmit="true"
                                                commitafterdelete="false"
                                                lang="english"/>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.NoteVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.NoteVO1.rangeSize}"
                                    emptyText="#{bindings.NoteVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.NoteVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.NoteVO1Query.queryDescriptor}"
                                    queryListener="#{bindings.NoteVO1Query.processQuery}"
                                    filterVisible="false" varStatus="vs"
                                    selectedRowKeys="#{bindings.NoteVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.NoteVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t8"
                                    contentDelivery="immediate"
                                    displayRow="selected" autoHeightRows="3"
                                    columnStretching="last"
                                    inlineStyle="height:75.0px;">
                            <af:column sortProperty="OrderNo" filterable="true"
                                       sortable="true" width="15" id="c10">
                              <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                            label="#{bindings.NoteVO1.hints.OrderNo.label}"
                                            required="#{bindings.NoteVO1.hints.OrderNo.mandatory}"
                                            columns="#{bindings.NoteVO1.hints.OrderNo.displayWidth}"
                                            maximumLength="#{bindings.NoteVO1.hints.OrderNo.precision}"
                                            shortDesc="#{bindings.NoteVO1.hints.OrderNo.tooltip}"
                                            id="it17">
                                <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.NoteVO1.hints.OrderNo.format}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="Note1" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.NoteVO1.hints.Note1.label}"
                                       id="c9">
                              <af:inputText value="#{row.bindings.Note1.inputValue}"
                                            label="#{bindings.NoteVO1.hints.Note1.label}"
                                            required="false"
                                            columns="#{bindings.NoteVO1.hints.Note1.displayWidth}"
                                            maximumLength="#{bindings.NoteVO1.hints.Note1.precision}"
                                            shortDesc="#{bindings.NoteVO1.hints.Note1.tooltip}"
                                            id="it18">
                                <f:validator binding="#{row.bindings.Note1.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelHeader>
                      <af:panelHeader text="#{viewcontrollerBundle.calaloging_descriptions}"
                                      id="ph6">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelFormLayout id="pfl9" rows="4"
                                            labelAlignment="start"
                                            maxColumns="1">
                          <af:inputText value="#{bindings.PhysicalDesc.inputValue}"
                                        label="#{bindings.PhysicalDesc.hints.label}"
                                        required="#{bindings.PhysicalDesc.hints.mandatory}"
                                        maximumLength="#{bindings.PhysicalDesc.hints.precision}"
                                        shortDesc="#{bindings.PhysicalDesc.hints.tooltip}"
                                        id="it19" columns="70">
                            <f:validator binding="#{bindings.PhysicalDesc.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.BiblioNote.inputValue}"
                                        label="#{bindings.BiblioNote.hints.label}"
                                        required="#{bindings.BiblioNote.hints.mandatory}"
                                        columns="70"
                                        maximumLength="#{bindings.BiblioNote.hints.precision}"
                                        shortDesc="#{bindings.BiblioNote.hints.tooltip}"
                                        id="it20">
                            <f:validator binding="#{bindings.BiblioNote.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.IndexNote.inputValue}"
                                        label="#{bindings.IndexNote.hints.label}"
                                        required="#{bindings.IndexNote.hints.mandatory}"
                                        columns="70"
                                        maximumLength="#{bindings.IndexNote.hints.precision}"
                                        shortDesc="#{bindings.IndexNote.hints.tooltip}"
                                        id="it21">
                            <f:validator binding="#{bindings.IndexNote.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.Contents.inputValue}"
                                        label="#{bindings.Contents.hints.label}"
                                        required="#{bindings.Contents.hints.mandatory}"
                                        maximumLength="#{bindings.Contents.hints.precision}"
                                        shortDesc="#{bindings.Contents.hints.tooltip}"
                                        id="it22" columns="70">
                            <f:validator binding="#{bindings.Contents.validator}"/>
                          </af:inputText>
                        </af:panelFormLayout>
                      </af:panelHeader>
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_isbn}"
                                      id="ph4">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelCollection id="pc2" styleClass="AFStretchWidth"
                                            featuresOff="statusBar viewMenu detach"
                                            partialTriggers="t11">
                          <f:facet name="toolbar">
                            <af:toolbar id="t22" partialTriggers="t10">
                              <fadak:ToolbarSet iteratorname="BookIsbnVO1Iterator"
                                                id="t11" debug="true"
                                                showcommit="false"
                                                showfirst="false"
                                                showlast="false"
                                                warningChanged="false"
                                                shownext="false"
                                                showprevious="false"
                                                showquery="false"
                                                 disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                disabled_delete="#{bindings.BookIsbnVO1Iterator.currentRow==null}"
                                                showrefresh="false"
                                                showrollback="false"
                                                showsearch="false"
                                                partialsubmit="true"
                                                lang="english"
                                                commitafterdelete="false"/>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.BookIsbnVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.BookIsbnVO1.rangeSize}"
                                    emptyText="#{bindings.BookIsbnVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.BookIsbnVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    selectedRowKeys="#{bindings.BookIsbnVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.BookIsbnVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t10"
                                    filterVisible="true"
                                    contentDelivery="immediate"
                                    autoHeightRows="3" displayRow="selected"
                                    queryListener="#{bindings.BookIsbnVO1Query.processQuery}"
                                    varStatus="vs" columnStretching="column:c11"
                                    inlineStyle="height:75.0px;">
                            <af:column sortProperty="OrderNo" sortable="true"
                                       id="c12" filterable="true" width="15">
                              <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                            label="#{bindings.BookIsbnVO1.hints.OrderNo.label}"
                                            required="#{bindings.BookIsbnVO1.hints.OrderNo.mandatory}"
                                            columns="#{bindings.BookIsbnVO1.hints.OrderNo.displayWidth}"
                                            maximumLength="#{bindings.BookIsbnVO1.hints.OrderNo.precision}"
                                            shortDesc="#{bindings.BookIsbnVO1.hints.OrderNo.tooltip}"
                                            id="it24">
                                <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.BookIsbnVO1.hints.OrderNo.format}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="Isbn" sortable="true"
                                       headerText="#{bindings.BookIsbnVO1.hints.Isbn.label}"
                                       id="c11" filterable="true">
                              <af:inputText value="#{row.bindings.Isbn.inputValue}"
                                            label="#{bindings.BookIsbnVO1.hints.Isbn.label}"
                                            required="#{bindings.BookIsbnVO1.hints.Isbn.mandatory}"
                                            columns="#{bindings.BookIsbnVO1.hints.Isbn.displayWidth}"
                                            maximumLength="#{bindings.BookIsbnVO1.hints.Isbn.precision}"
                                            shortDesc="#{bindings.BookIsbnVO1.hints.Isbn.tooltip}"
                                            id="it23">
                                <f:validator binding="#{row.bindings.Isbn.validator}"/>
                              </af:inputText>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelHeader>
                      <af:panelHeader text="#{viewcontrollerBundle.cataloging_language}"
                                      id="panelHeader1">
                        <f:facet name="context"/>
                        <f:facet name="menuBar"/>
                        <f:facet name="toolbar"/>
                        <f:facet name="legend"/>
                        <f:facet name="info"/>
                        <af:panelCollection id="panelCollection1"
                                            styleClass="AFStretchWidth"
                                            featuresOff="statusBar viewMenu detach"
                                            partialTriggers="ToolbarSet1">
                          <f:facet name="toolbar">
                            <af:toolbar id="toolbar1" partialTriggers="t25">
                              <fadak:ToolbarSet iteratorname="VbookLanguageVO1Iterator"
                                                id="ToolbarSet1" debug="true"
                                                showcommit="false"
                                                showfirst="false"
                                                showlast="false"
                                                warningChanged="false"
                                                shownext="false"
                                                showprevious="false"
                                                showquery="false"
                                                showrefresh="false"
                                                 disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                disabled_delete="#{bindings.VbookLanguageVO1Iterator.currentRow==null}"
                                                showrollback="false"
                                                showsearch="false"
                                                partialsubmit="true"
                                                commitafterdelete="false"
                                                lang="english"/>
                            </af:toolbar>
                          </f:facet>
                          <af:table value="#{bindings.VbookLanguageVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.VbookLanguageVO1.rangeSize}"
                                    emptyText="#{bindings.VbookLanguageVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.VbookLanguageVO1.rangeSize}"
                                    rowBandingInterval="0" autoHeightRows="3"
                                    selectedRowKeys="#{bindings.VbookLanguageVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.VbookLanguageVO1.collectionModel.makeCurrent}"
                                    filterVisible="true"
                                    contentDelivery="immediate"
                                    rowSelection="single" id="t25"
                                    displayRow="selected" varStatus="vs"
                                    inlineStyle="height:75.0px;"
                                    columnStretching="column:c44">
                            <af:column sortProperty="LangArtIdLOV"
                                       sortable="true"
                                       headerText="#{bindings.VbookLanguageVO1.hints.LangArtIdLOV.label}"
                                       id="c44">
                              <af:selectOneChoice value="#{row.bindings.LangArtIdLOV.inputValue}"
                                                  label="#{row.bindings.LangArtIdLOV.label}"
                                                  required="false"
                                                  shortDesc="#{bindings.VbookLanguageVO1.hints.LangArtIdLOV.tooltip}"
                                                  id="soc8">
                                <f:selectItems value="#{row.bindings.LangArtIdLOV.items}"
                                               id="si9"/>
                              </af:selectOneChoice>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelHeader>
                    </af:panelFormLayout>
                  </af:panelBox>
                  <af:separator/>
                </af:showDetailHeader>
              </af:panelGroupLayout>
            </af:showDetailItem>
            <af:showDetailItem text="#{viewcontrollerBundle.details_description}"
                               id="sdi1" stretchChildren="first">
              <af:panelGroupLayout id="pgl9" layout="scroll">
                <af:panelBox text="" id="pb11">
                  <f:facet name="toolbar">
                    <af:toolbar id="t4">
                      <fadak:ToolbarSet debug="true"
                                        iteratorname="VirtualBookVO1Iterator"
                                        id="ts9"
                                        RollbackAfterUnsuccessfulCommit="false"
                                        after_create="#{viewScope.back.create_English}"
                                        lang="english"/>
                    </af:toolbar>
                  </f:facet>
                  <af:panelFormLayout rows="1" id="pfl8" labelAlignment="start"
                                      fieldWidth="50" labelWidth="50">
                    <af:inputText value="#{bindings.Abstract11.inputValue}"
                                  label="#{bindings.Abstract11.hints.label}"
                                  required="#{bindings.Abstract11.hints.mandatory}"
                                  rows="8"
                                  columns="#{bindings.Abstract11.hints.displayWidth}"
                                  maximumLength="#{bindings.Abstract11.hints.precision}"
                                  shortDesc="#{bindings.Abstract11.hints.tooltip}"
                                  id="it25">
                      <f:validator binding="#{bindings.Abstract11.validator}"/>
                    </af:inputText>
                    <af:outputLabel value="#{viewcontrollerBundle.subjects}"
                                    for="pc10" id="ol3"
                                    inlineStyle="font-weight:bold;"/>
                    <af:panelCollection featuresOff="statusBar viewMenu detach"
                                        partialTriggers="ts4" id="pc10"
                                        inlineStyle="width:470px;">
                      <af:table value="#{bindings.VbookSubjectVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.VbookSubjectVO1.rangeSize}"
                                emptyText="#{bindings.VbookSubjectVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.VbookSubjectVO1.rangeSize}"
                                rowBandingInterval="0"
                                selectedRowKeys="#{bindings.VbookSubjectVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.VbookSubjectVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t12"
                                autoHeightRows="3" displayRow="selected"
                                contentDelivery="immediate"
                                partialTriggers="::::r1 ::ts4"
                                columnStretching="column:c15">
                        <af:column sortProperty="OrderNo" sortable="true"
                                   headerText="" id="c13" width="20">
                          <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                        label="#{bindings.VbookSubjectVO1.hints.OrderNo.label}"
                                        required="#{bindings.VbookSubjectVO1.hints.OrderNo.mandatory}"
                                        columns="#{bindings.VbookSubjectVO1.hints.OrderNo.displayWidth}"
                                        maximumLength="#{bindings.VbookSubjectVO1.hints.OrderNo.precision}"
                                        shortDesc="#{bindings.VbookSubjectVO1.hints.OrderNo.tooltip}"
                                        id="it29">
                            <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.VbookSubjectVO1.hints.OrderNo.format}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="SubjectText" sortable="true"
                                   headerText="#{bindings.VbookSubjectVO1.hints.SubjectText.label}"
                                   id="c15">
                          <af:inputText value="#{row.bindings.SubjectText.inputValue}"
                                        label="#{bindings.VbookSubjectVO1.hints.SubjectText.label}"
                                        required="#{bindings.VbookSubjectVO1.hints.SubjectText.mandatory}"
                                        columns="#{bindings.VbookSubjectVO1.hints.SubjectText.displayWidth}"
                                        maximumLength="#{bindings.VbookSubjectVO1.hints.SubjectText.precision}"
                                        shortDesc="#{bindings.VbookSubjectVO1.hints.SubjectText.tooltip}"
                                        id="it27" readOnly="true">
                            <f:validator binding="#{row.bindings.SubjectText.validator}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="FloatSubject2" sortable="true"
                                   headerText="#{bindings.VbookSubjectVO1.hints.FloatSubject2.label}"
                                   id="c14" width="200">
                          <af:panelGroupLayout layout="horizontal" id="pgl7">
                            <af:commandImageLink action="#{pageFlowScope.TFBean.floatSubject}"
                                                 icon="/icons/edit-find-replace.png"
                                                 immediate="true" id="cil4"
                                                 partialSubmit="true">
                              <af:setActionListener from="#{2}"
                                                    to="#{pageFlowScope.catalogingReadingOrder}"/>
                            </af:commandImageLink>
                            <af:inputText value="#{row.bindings.FloatSubject2.inputValue}"
                                          label="#{bindings.VbookSubjectVO1.hints.FloatSubject2.label}"
                                          required="#{bindings.VbookSubjectVO1.hints.FloatSubject2.mandatory}"
                                          columns="#{bindings.VbookSubjectVO1.hints.FloatSubject2.displayWidth}"
                                          maximumLength="#{bindings.VbookSubjectVO1.hints.FloatSubject2.precision}"
                                          shortDesc="#{bindings.VbookSubjectVO1.hints.FloatSubject2.tooltip}"
                                          id="it26">
                              <f:validator binding="#{row.bindings.FloatSubject2.validator}"/>
                            </af:inputText>
                          </af:panelGroupLayout>
                        </af:column>
                        <af:column headerText="" id="c7">
                          <af:selectBooleanCheckbox value="#{row.bindings.printableBoolean.inputValue}"
                                                    label="#{row.bindings.printableBoolean.label}"
                                                    shortDesc="#{bindings.VbookSubjectVO1.hints.printableBoolean.tooltip}"
                                                    id="sbc6"/>
                        </af:column>
                      </af:table>
                      <f:facet name="toolbar">
                        <af:toolbar id="t13" partialTriggers="t12">
                          <af:commandImageLink icon="/icons/list-add.png"
                                               shortDesc="#{viewcontrollerBundle.cataloging_add}"
                                               action="#{pageFlowScope.TFBean.subject}"
                                               immediate="true"
                                                disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                               partialSubmit="true" id="cil1">
                            <af:setActionListener from="#{2}"
                                                  to="#{pageFlowScope.catalogingReadingOrder}"/>
                          </af:commandImageLink>
                          <fadak:ToolbarSet iteratorname="VbookSubjectVO1Iterator"
                                            id="ts4" debug="true"
                                            showcommit="false" showfirst="false"
                                            showlast="false" shownext="false"
                                            showprevious="false"
                                            showcreate="false"
                                            commitafterdelete="false"
                                            partialsubmit="true"
                                               disabled_delete="#{bindings.VbookSubjectVO1Iterator.currentRow==null}"
                                            showquery="false"
                                            showrefresh="false"
                                            showrollback="false"
                                            showsearch="false" lang="english"/>
                        </af:toolbar>
                      </f:facet>
                    </af:panelCollection>
                  </af:panelFormLayout>
                  <af:panelBox text="#{viewcontrollerBundle.added_entries}"
                               id="pb8" showDisclosure="false">
                    <af:panelFormLayout id="pfl11" labelAlignment="start">
                      <f:facet name="footer"/>
                      <af:outputLabel value="#{viewcontrollerBundle.other_providers}"
                                      for="pc3" inlineStyle="font-weight:bold;"
                                      id="ol4"/>
                      <af:panelCollection id="pc3"
                                          featuresOff="statusBar viewMenu detach"
                                          styleClass="AFStretchWidth"
                                          inlineStyle="width:810.0px;"
                                          partialTriggers="ts5">
                        <f:facet name="toolbar">
                          <af:toolbar id="t15" partialTriggers="t14">
                            <af:commandImageLink icon="/icons/list-add.png"
                                                 shortDesc="#{viewcontrollerBundle.cataloging_add}"
                                                 partialSubmit="true"
                                               disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                 action="#{pageFlowScope.TFBean.provider}"
                                                 id="cil10">
                              <af:setActionListener from="#{2}"
                                                    to="#{pageFlowScope.catalogingReadingOrder}"/>
                              <af:setActionListener from="#{0}"
                                                    to="#{pageFlowScope.mainpage}"/>
                            </af:commandImageLink>
                            <fadak:ToolbarSet iteratorname="VbookOtherProviderVO1Iterator"
                                              id="ts5" debug="true"
                                              showcommit="false"
                                              showfirst="false" showlast="false"
                                              shownext="false"
                                              showprevious="false"
                                              warningChanged="false"
                                              showquery="false"
                                              showrefresh="false"
                                                disabled_delete="#{bindings.VbookOtherProviderVO1Iterator.currentRow==null}"
                                              showrollback="false"
                                              showsearch="false"
                                              showcreate="false"
                                              partialsubmit="true"
                                              commitafterdelete="false"
                                              lang="english"/>
                          </af:toolbar>
                        </f:facet>
                        <af:table value="#{bindings.VbookOtherProviderVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.VbookOtherProviderVO1.rangeSize}"
                                  emptyText="#{bindings.VbookOtherProviderVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                  fetchSize="#{bindings.VbookOtherProviderVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  filterModel="#{bindings.VbookOtherProviderVO1Query.queryDescriptor}"
                                  queryListener="#{bindings.VbookOtherProviderVO1Query.processQuery}"
                                  filterVisible="false" varStatus="vs"
                                  selectedRowKeys="#{bindings.VbookOtherProviderVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.VbookOtherProviderVO1.collectionModel.makeCurrent}"
                                  rowSelection="single" id="t14"
                                  partialTriggers="::::r1 ::ts5"
                                  contentDelivery="immediate" autoHeightRows="2"
                                  displayRow="selected"
                                  columnStretching="column:c18">
                          <af:column sortProperty="OrderNo" filterable="true"
                                     sortable="true" width="18" id="c22">
                            <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                          label="#{bindings.VbookOtherProviderVO1.hints.OrderNo.label}"
                                          required="#{bindings.VbookOtherProviderVO1.hints.OrderNo.mandatory}"
                                          columns="#{bindings.VbookOtherProviderVO1.hints.OrderNo.displayWidth}"
                                          maximumLength="#{bindings.VbookOtherProviderVO1.hints.OrderNo.precision}"
                                          shortDesc="#{bindings.VbookOtherProviderVO1.hints.OrderNo.tooltip}"
                                          id="it36">
                              <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.VbookOtherProviderVO1.hints.OrderNo.format}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="#{bindings.VbookOtherProviderVO1.hints.ProviderText.label}"
                                     id="c18" sortProperty="ProviderText"
                                     filterable="true" sortable="true">
                            <af:inputText value="#{row.bindings.ProviderText.inputValue}"
                                          label="#{bindings.VbookOtherProviderVO1.hints.ProviderText.label}"
                                          required="#{bindings.VbookOtherProviderVO1.hints.ProviderText.mandatory}"
                                          columns="#{bindings.VbookOtherProviderVO1.hints.ProviderText.displayWidth}"
                                          maximumLength="#{bindings.VbookOtherProviderVO1.hints.ProviderText.precision}"
                                          shortDesc="#{bindings.VbookOtherProviderVO1.hints.ProviderText.tooltip}"
                                          id="it30" readOnly="true">
                              <f:validator binding="#{row.bindings.ProviderText.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.label}"
                                     id="c19" sortProperty="ForeignNameText"
                                     filterable="true" sortable="true">
                            <af:inputText value="#{row.bindings.ForeignNameText.inputValue}"
                                          label="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.label}"
                                          required="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.mandatory}"
                                          columns="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.displayWidth}"
                                          maximumLength="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.precision}"
                                          shortDesc="#{bindings.VbookOtherProviderVO1.hints.ForeignNameText.tooltip}"
                                          id="it31" readOnly="true">
                              <f:validator binding="#{row.bindings.ForeignNameText.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="#{bindings.VbookOtherProviderVO1.hints.Role.label}"
                                     sortable="true" filterable="true"
                                     sortProperty="Role" id="c21">
                            <af:panelGroupLayout id="pgl6" layout="horizontal">
                              <af:commandImageLink action="#{pageFlowScope.TFBean.providerRole}"
                                                   icon="/icons/edit-find-replace.png"
                                                   id="cil2"
                                                   partialSubmit="true">
                                <af:setActionListener from="#{2}"
                                                      to="#{pageFlowScope.catalogingReadingOrder}"/>
                                <af:setActionListener from="#{0}"
                                                      to="#{pageFlowScope.mainpage}"/>
                              </af:commandImageLink>
                              <af:inputText value="#{row.bindings.Role.inputValue}"
                                            label="#{bindings.VbookOtherProviderVO1.hints.Role.label}"
                                            required="#{bindings.VbookOtherProviderVO1.hints.Role.mandatory}"
                                            columns="#{bindings.VbookOtherProviderVO1.hints.Role.displayWidth}"
                                            maximumLength="#{bindings.VbookOtherProviderVO1.hints.Role.precision}"
                                            shortDesc="#{bindings.VbookOtherProviderVO1.hints.Role.tooltip}"
                                            id="it34">
                                <f:validator binding="#{row.bindings.Role.validator}"/>
                              </af:inputText>
                            </af:panelGroupLayout>
                          </af:column>
                          <af:column headerText="#{bindings.VbookOtherProviderVO1.hints.BDDateText.label}"
                                     id="c23" sortProperty="BDDateText"
                                     filterable="true" sortable="true">
                            <af:inputText value="#{row.bindings.BDDateText.inputValue}"
                                          label="#{bindings.VbookOtherProviderVO1.hints.BDDateText.label}"
                                          required="#{bindings.VbookOtherProviderVO1.hints.BDDateText.mandatory}"
                                          columns="#{bindings.VbookOtherProviderVO1.hints.BDDateText.displayWidth}"
                                          maximumLength="#{bindings.VbookOtherProviderVO1.hints.BDDateText.precision}"
                                          shortDesc="#{bindings.VbookOtherProviderVO1.hints.BDDateText.tooltip}"
                                          id="it32" readOnly="true">
                              <f:validator binding="#{row.bindings.BDDateText.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="TitleRefer" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.label}"
                                     id="c20">
                            <af:inputText value="#{row.bindings.TitleRefer.inputValue}"
                                          label="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.label}"
                                          required="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.mandatory}"
                                          columns="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.displayWidth}"
                                          maximumLength="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.precision}"
                                          shortDesc="#{bindings.VbookOtherProviderVO1.hints.TitleRefer.tooltip}"
                                          id="it33" readOnly="true">
                              <f:validator binding="#{row.bindings.TitleRefer.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="" id="c16">
                            <af:selectBooleanCheckbox value="#{row.bindings.printableBoolean.inputValue}"
                                                      label="#{row.bindings.printableBoolean.label}"
                                                      shortDesc="#{bindings.VbookOtherProviderVO1.hints.printableBoolean.tooltip}"
                                                      id="sbc7"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                    </af:panelFormLayout>
                    <af:spacer id="s4" height="20"/>
                    <af:panelFormLayout maxColumns="2" rows="2" id="pfl7"
                                        labelAlignment="top">
                      <af:outputLabel value="#{viewcontrollerBundle.other_titles}"
                                      id="ol2" for="pc9"
                                      inlineStyle="font-weight:bold;"/>
                      <af:panelCollection inlineStyle="width:400px; height:150.0px;"
                                          featuresOff="statusBar viewMenu detach"
                                          id="pc9">
                        <f:facet name="toolbar">
                          <af:toolbar id="t19" partialTriggers="t18">
                            <fadak:ToolbarSet iteratorname="OtherTitleVO1Iterator"
                                              id="ts7" debug="true"
                                              showcommit="false"
                                              showfirst="false" showlast="false"
                                              shownext="false"
                                              showprevious="false"
                                              warningChanged="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                              disabled_delete="#{bindings.OtherTitleVO1Iterator.currentRow==null}"
                                              showsearch="false"
                                              commitafterdelete="false"
                                              partialsubmit="true"
                                              lang="english"/>
                          </af:toolbar>
                        </f:facet>
                        <af:table value="#{bindings.OtherTitleVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.OtherTitleVO1.rangeSize}"
                                  emptyText="#{bindings.OtherTitleVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                  fetchSize="#{bindings.OtherTitleVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  selectedRowKeys="#{bindings.OtherTitleVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.OtherTitleVO1.collectionModel.makeCurrent}"
                                  rowSelection="single" id="t18"
                                  displayRow="selected"
                                  contentDelivery="immediate"
                                  columnStretching="column:c27"
                                  partialTriggers="::ts7">
                          <af:column sortProperty="OrderNo" sortable="true"
                                     width="18" id="c28">
                            <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                          label="#{bindings.OtherTitleVO1.hints.OrderNo.label}"
                                          required="#{bindings.OtherTitleVO1.hints.OrderNo.mandatory}"
                                          columns="#{bindings.OtherTitleVO1.hints.OrderNo.displayWidth}"
                                          maximumLength="#{bindings.OtherTitleVO1.hints.OrderNo.precision}"
                                          shortDesc="#{bindings.OtherTitleVO1.hints.OrderNo.tooltip}"
                                          id="it42">
                              <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.OtherTitleVO1.hints.OrderNo.format}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="OtherTitle1" sortable="true"
                                     headerText="#{bindings.OtherTitleVO1.hints.OtherTitle1.label}"
                                     id="c27">
                            <af:inputText value="#{row.bindings.OtherTitle1.inputValue}"
                                          label="#{bindings.OtherTitleVO1.hints.OtherTitle1.label}"
                                          required="#{bindings.OtherTitleVO1.hints.OtherTitle1.mandatory}"
                                          columns="#{bindings.OtherTitleVO1.hints.OtherTitle1.displayWidth}"
                                          maximumLength="#{bindings.OtherTitleVO1.hints.OtherTitle1.precision}"
                                          shortDesc="#{bindings.OtherTitleVO1.hints.OtherTitle1.tooltip}"
                                          id="it40" autoSubmit="true">
                              <f:validator binding="#{row.bindings.OtherTitle1.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="" id="c26">
                            <af:selectBooleanCheckbox value="#{row.bindings.printBoolean.inputValue}"
                                                      label="#{row.bindings.printBoolean.label}"
                                                      shortDesc="#{bindings.OtherTitleVO1.hints.printBoolean.tooltip}"
                                                      id="sbc9"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                      <af:spacer height="20" id="s5"/>
                      <af:inputText value="#{bindings.CatalogSource.inputValue}"
                                    label="#{bindings.CatalogSource.hints.label}"
                                    required="#{bindings.CatalogSource.hints.mandatory}"
                                    columns="75"
                                    maximumLength="#{bindings.CatalogSource.hints.precision}"
                                    shortDesc="#{bindings.CatalogSource.hints.tooltip}"
                                    id="it43">
                        <f:validator binding="#{bindings.CatalogSource.validator}"/>
                      </af:inputText>
                      <af:outputLabel value="#{viewcontrollerBundle.other_uniform_titles}"
                                      id="ol1" for="pc8"
                                      inlineStyle="font-weight:bold;"/>
                      <af:panelCollection featuresOff="statusBar viewMenu detach"
                                          inlineStyle="width:400px; height:150.0px;"
                                          id="pc8" partialTriggers="ts6">
                        <f:facet name="toolbar">
                          <af:toolbar id="t17" partialTriggers="t16">
                            <af:commandImageLink shortDesc="#{viewcontrollerBundle.cataloging_add}"
                                                 icon="/icons/list-add.png"
                                                 action="#{pageFlowScope.TFBean.uniformtitle}"
                                                 disabled="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                                 partialSubmit="true"
                                                 id="cil11">
                              <af:setActionListener from="#{0}"
                                                    to="#{pageFlowScope.mainpage}"/>
                              <af:setActionListener from="#{2}"
                                                    to="#{pageFlowScope.catalogingReadingOrder}"/>
                            </af:commandImageLink>
                            <fadak:ToolbarSet iteratorname="VbookUniTtlVO1Iterator"
                                              id="ts6" debug="true"
                                              showcommit="false"
                                              showfirst="false" showlast="false"
                                              shownext="false"
                                              warningChanged="false"
                                              showprevious="false"
                                              showquery="false"
                                              disabled_delete="#{bindings.VbookUniTtlVO1Iterator.currentRow==null}"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"
                                              showcreate="false"
                                              commitafterdelete="false"
                                              partialsubmit="true"
                                              lang="english"/>
                          </af:toolbar>
                        </f:facet>
                        <af:table value="#{bindings.VbookUniTtlVO11.collectionModel}"
                                  var="row"
                                  rows="#{bindings.VbookUniTtlVO11.rangeSize}"
                                  emptyText="#{bindings.VbookUniTtlVO11.viewable ? 'No data to display.' : 'Access Denied.'}"
                                  fetchSize="#{bindings.VbookUniTtlVO11.rangeSize}"
                                  rowBandingInterval="0" id="t16"
                                  filterModel="#{bindings.VbookUniTtlVO11Query.queryDescriptor}"
                                  queryListener="#{bindings.VbookUniTtlVO11Query.processQuery}"
                                  filterVisible="false" varStatus="vs"
                                  selectedRowKeys="#{bindings.VbookUniTtlVO11.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.VbookUniTtlVO11.collectionModel.makeCurrent}"
                                  rowSelection="single"
                                  contentDelivery="immediate"
                                  displayRow="selected"
                                  partialTriggers="::::r1 ::ts6"
                                  columnStretching="column:c24">
                          <af:column sortProperty="OrderNo" filterable="true"
                                     sortable="true" width="18" id="c25">
                            <af:inputText value="#{row.bindings.OrderNo.inputValue}"
                                          label="#{bindings.VbookUniTtlVO11.hints.OrderNo.label}"
                                          required="#{bindings.VbookUniTtlVO11.hints.OrderNo.mandatory}"
                                          columns="#{bindings.VbookUniTtlVO11.hints.OrderNo.displayWidth}"
                                          maximumLength="#{bindings.VbookUniTtlVO11.hints.OrderNo.precision}"
                                          shortDesc="#{bindings.VbookUniTtlVO11.hints.OrderNo.tooltip}"
                                          id="it37">
                              <f:validator binding="#{row.bindings.OrderNo.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.VbookUniTtlVO11.hints.OrderNo.format}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.label}"
                                     id="c24" sortProperty="UniformTitleText"
                                     filterable="true" sortable="true">
                            <af:inputText value="#{row.bindings.UniformTitleText.inputValue}"
                                          label="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.label}"
                                          required="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.mandatory}"
                                          columns="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.displayWidth}"
                                          maximumLength="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.precision}"
                                          shortDesc="#{bindings.VbookUniTtlVO11.hints.UniformTitleText.tooltip}"
                                          id="it38" readOnly="true">
                              <f:validator binding="#{row.bindings.UniformTitleText.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column headerText="" id="c17">
                            <af:selectBooleanCheckbox value="#{row.bindings.printableBoolean.inputValue}"
                                                      label="#{row.bindings.printableBoolean.label}"
                                                      shortDesc="#{bindings.VbookUniTtlVO11.hints.printableBoolean.tooltip}"
                                                      id="sbc8"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                      <af:spacer height="20" id="s6"/>
                      <af:inputText value="#{bindings.NbibNo.inputValue}"
                                    label="#{bindings.NbibNo.hints.label}"
                                    required="#{bindings.NbibNo.hints.mandatory}"
                                    columns="75"
                                    maximumLength="#{bindings.NbibNo.hints.precision}"
                                    shortDesc="#{bindings.NbibNo.hints.tooltip}"
                                    id="it44">
                        <f:validator binding="#{bindings.NbibNo.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                  </af:panelBox>
                </af:panelBox>
              </af:panelGroupLayout>
            </af:showDetailItem>
            <af:showDetailItem text="#{viewcontrollerBundle.NOSKHE}">
              <af:panelBox id="pb9" showDisclosure="false" text=" ">
                <f:facet name="toolbar">
                  <af:toolbar id="t3">
                    <fadak:ToolbarSet debug="true"
                                      iteratorname="VirtualBookVO1Iterator"
                                      id="ts10"
                                      RollbackAfterUnsuccessfulCommit="false"
                                      after_create="#{viewScope.back.create_English}"
                                      lang="english"></fadak:ToolbarSet>
                  </af:toolbar>
                </f:facet>
                <af:panelGroupLayout id="pgl11" layout="scroll">
                  <af:panelCollection id="pc4" styleClass="AFStretchWidth">
                    <f:facet name="toolbar">
                      <af:toolbar id="t21" partialTriggers="t20">
                        <fadak:ToolbarSet iteratorname="PhysicalBookVO1Iterator"
                                          id="ts8" debug="true"
                                          showcommit="false" showfirst="false"
                                          showlast="false" shownext="false"
                                          showprevious="false"
                                          warningChanged="false"
                                          showquery="false" showrefresh="false"
                                           disabled_create="#{bindings.VirtualBookVO1Iterator.currentRow==null || bindings.VirtualBookVO1Iterator.currentRow.artId.value lt 0}"
                                          disabled_delete="#{bindings.PhysicalBookVO1Iterator.currentRow==null}"
                                          disabled_EditCommand="#{bindings.PhysicalBookVO1Iterator.currentRow==null}"
                                          showrollback="false"
                                          showsearch="false"
                                          showEditCommand="true"
                                          lang="english"/>
                      </af:toolbar>
                    </f:facet>
                    <af:table value="#{bindings.PhysicalBookVO1.collectionModel}"
                              var="row"
                              rows="#{bindings.PhysicalBookVO1.rangeSize}"
                              emptyText="#{bindings.PhysicalBookVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                              fetchSize="#{bindings.PhysicalBookVO1.rangeSize}"
                              rowBandingInterval="0"
                              filterModel="#{bindings.PhysicalBookVO1Query.queryDescriptor}"
                              queryListener="#{bindings.PhysicalBookVO1Query.processQuery}"
                              filterVisible="true" varStatus="vs"
                              selectedRowKeys="#{bindings.PhysicalBookVO1.collectionModel.selectedRow}"
                              selectionListener="#{bindings.PhysicalBookVO1.collectionModel.makeCurrent}"
                              rowSelection="single" id="t20" autoHeightRows="-1"
                              contentDelivery="immediate" displayRow="selected"
                              columnStretching="column:c36">
                      <af:column sortProperty="Barcode" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.Barcode.label}"
                                 id="c42">
                        <af:inputText value="#{row.bindings.Barcode.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.Barcode.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.Barcode.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.Barcode.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.Barcode.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.Barcode.tooltip}"
                                      id="it47">
                          <f:validator binding="#{row.bindings.Barcode.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="RegId" filterable="true"
                                 sortable="true" width="51"
                                 headerText="#{bindings.PhysicalBookVO1.hints.RegId.label}"
                                 id="c35">
                        <af:inputText value="#{row.bindings.RegId.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.RegId.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.RegId.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.RegId.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.RegId.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.RegId.tooltip}"
                                      id="it52">
                          <f:validator binding="#{row.bindings.RegId.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="VolNo" filterable="true"
                                 sortable="true" width="20"
                                 headerText="#{bindings.PhysicalBookVO1.hints.VolNo.label}"
                                 id="c39">
                        <af:inputText value="#{row.bindings.VolNo.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.VolNo.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.VolNo.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.VolNo.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.VolNo.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.VolNo.tooltip}"
                                      id="it50">
                          <f:validator binding="#{row.bindings.VolNo.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="PartNo" filterable="true"
                                 sortable="true" width="30"
                                 headerText="#{bindings.PhysicalBookVO1.hints.PartNo.label}"
                                 id="c38">
                        <af:inputText value="#{row.bindings.PartNo.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.PartNo.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.PartNo.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.PartNo.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.PartNo.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.PartNo.tooltip}"
                                      id="it53">
                          <f:validator binding="#{row.bindings.PartNo.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="ReplicateNo" filterable="true"
                                 sortable="true" width="30"
                                 headerText="#{bindings.PhysicalBookVO1.hints.ReplicateNo.label}"
                                 id="c40">
                        <af:inputText value="#{row.bindings.ReplicateNo.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.ReplicateNo.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.ReplicateNo.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.ReplicateNo.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.ReplicateNo.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.ReplicateNo.tooltip}"
                                      id="it45">
                          <f:validator binding="#{row.bindings.ReplicateNo.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.PhysicalBookVO1.hints.ReplicateNo.format}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="ExistenceStatus"
                                 filterable="true" sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.label}"
                                 id="c30" width="60">
                        <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                            label="#{row.bindings.ExistenceStatus.label}"
                                            required="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.mandatory}"
                                            shortDesc="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.tooltip}"
                                            id="soc7">
                          <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                         id="si6"/>
                        </af:selectOneChoice>
                      </af:column>
                      <af:column sortProperty="LoanStatus" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.LoanStatus.label}"
                                 id="c33" width="60">
                        <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                            label="#{row.bindings.LoanStatus.label}"
                                            required="#{bindings.PhysicalBookVO1.hints.LoanStatus.mandatory}"
                                            shortDesc="#{bindings.PhysicalBookVO1.hints.LoanStatus.tooltip}"
                                            id="soc5">
                          <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                         id="si4"/>
                        </af:selectOneChoice>
                      </af:column>
                      <af:column sortProperty="Place" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.Place.label}"
                                 id="c41">
                        <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                            label="#{row.bindings.Place.label}"
                                            required="#{bindings.PhysicalBookVO1.hints.Place.mandatory}"
                                            shortDesc="#{bindings.PhysicalBookVO1.hints.Place.tooltip}"
                                            id="soc4">
                          <f:selectItems value="#{row.bindings.Place.items}"
                                         id="si5"/>
                        </af:selectOneChoice>
                      </af:column>
                      <af:column sortProperty="SafetyStatus" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.SafetyStatus.label}"
                                 id="c37" width="60">
                        <af:selectOneChoice value="#{row.bindings.SafetyStatus.inputValue}"
                                            label="#{row.bindings.SafetyStatus.label}"
                                            required="#{bindings.PhysicalBookVO1.hints.SafetyStatus.mandatory}"
                                            shortDesc="#{bindings.PhysicalBookVO1.hints.SafetyStatus.tooltip}"
                                            id="soc6">
                          <f:selectItems value="#{row.bindings.SafetyStatus.items}"
                                         id="si7"/>
                        </af:selectOneChoice>
                      </af:column>
                      <af:column sortProperty="Description" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.Description.label}"
                                 id="c36">
                        <af:inputText value="#{row.bindings.Description.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.Description.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.Description.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.Description.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.Description.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.Description.tooltip}"
                                      id="it51">
                          <f:validator binding="#{row.bindings.Description.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="PubDate" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.PubDate.label}"
                                 id="c31">
                        <af:inputText value="#{row.bindings.PubDate.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.PubDate.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.PubDate.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.PubDate.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.PubDate.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.PubDate.tooltip}"
                                      id="it49">
                          <f:validator binding="#{row.bindings.PubDate.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="UserName" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.UserName.label}"
                                 id="c32">
                        <af:inputText value="#{row.bindings.UserName.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.UserName.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.UserName.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.UserName.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.UserName.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.UserName.tooltip}"
                                      id="it46">
                          <f:validator binding="#{row.bindings.UserName.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="InsertDate" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.PhysicalBookVO1.hints.InsertDate.label}"
                                 id="c34">
                        <af:inputText value="#{row.bindings.InsertDate.inputValue}"
                                      label="#{bindings.PhysicalBookVO1.hints.InsertDate.label}"
                                      required="#{bindings.PhysicalBookVO1.hints.InsertDate.mandatory}"
                                      columns="#{bindings.PhysicalBookVO1.hints.InsertDate.displayWidth}"
                                      maximumLength="#{bindings.PhysicalBookVO1.hints.InsertDate.precision}"
                                      shortDesc="#{bindings.PhysicalBookVO1.hints.InsertDate.tooltip}"
                                      id="it48">
                          <f:validator binding="#{row.bindings.InsertDate.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.PhysicalBookVO1.hints.InsertDate.format}"/>
                        </af:inputText>
                      </af:column>
                      <af:column headerText="#{viewcontrollerBundle.file}"
                                 id="c43">
                        <af:goLink text="#{row.bindings.FileName.inputValue}"
                                   id="gb1" targetFrame="_blank"
                                   disabled="#{!sessionUser.downloadBookFileAllowed}"
                                   destination="/file/#{row.bindings.FileName.inputValue}?FileName=#{row.bindings.FileName.inputValue}&PhbookArtId=#{row.bindings.ArtId.inputValue}&VbookArtId=#{bindings.ArtId.inputValue}"/>
                      </af:column>
                      <af:column id="c45"
                                 rendered="#{sessionUser.uploadBookFileAllowed}">
                        <af:commandButton rendered="#{sessionUser.uploadBookFileAllowed}"
                                          text="#{viewcontrollerBundle.upload}"
                                          id="cb4" partialSubmit="true">
                          <af:showPopupBehavior triggerType="click"
                                                popupId=":::p1"/>
                        </af:commandButton>
                      </af:column>
                    </af:table>
                  </af:panelCollection>
                </af:panelGroupLayout>
              </af:panelBox>
            </af:showDetailItem>
            <af:showDetailItem text="#{viewcontrollerBundle.ISO_REPORT}">
              <af:panelBox id="pb6" text=" " disclosed="true"
                           showDisclosure="false">
                <f:facet name="toolbar">
                  <af:toolbar id="t24">
                    <fadak:ToolbarSet debug="true"
                                      iteratorname="VirtualBookVO1Iterator"
                                      id="ts11"
                                      RollbackAfterUnsuccessfulCommit="false"
                                      after_create="#{viewScope.back.create_English}"
                                      lang="english"></fadak:ToolbarSet>
                  </af:toolbar>
                </f:facet>
                <af:panelFormLayout maxColumns="1" rows="2" id="pfl6"
                                    labelWidth="200">
                  <af:inputText value="#{bindings.IsoLog.inputValue}"
                                label="#{bindings.IsoLog.hints.label}"
                                required="#{bindings.IsoLog.hints.mandatory}"
                                columns="#{bindings.IsoLog.hints.displayWidth}"
                                rows="10"
                                maximumLength="#{bindings.IsoLog.hints.precision}"
                                shortDesc="#{bindings.IsoLog.hints.tooltip}"
                                id="it54">
                    <f:validator binding="#{bindings.IsoLog.validator}"/>
                  </af:inputText>
                </af:panelFormLayout>
              </af:panelBox>
            </af:showDetailItem>
          </af:panelTabbed>
        </f:facet>
        <f:facet name="popup">
          <af:group id="g2">
            <af:popup id="reportPop" childCreation="deferred"
                      contentDelivery="lazyUncached">
              <af:panelWindow title="انتخاب فرمت گزارش" modal="true" id="pw1">
                <af:panelGroupLayout layout="horizontal" id="pgl13">
                 <af:goLink shortDesc="RTF" destination="#{initParam.reportServer}#{viewScope.back.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"
                             destination="#{initParam.reportServer}#{viewScope.back.reportPath}&desformat=htmlcss"
                             targetFrame="_blank" inlineStyle="padding:10.0px;"
                             id="gl4">
                    <af:image source="/icons/htmlcss.png" id="i3"/>
                  </af:goLink>
                  <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.back.reportPath}&desformat=html"
                             targetFrame="_blank" id="gl3">
                    <af:image source="/icons/html.png" id="i4"/>
                  </af:goLink>
                  <af:goLink shortDesc="XML" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.back.reportPath}&desformat=xml"
                             targetFrame="_blank" id="gl2">
                    <af:image source="/icons/xml.png" id="i1"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.back.reportPath}&desformat=delimiteddata"
                             targetFrame="_blank" id="gl1">
                    <af:image source="/icons/csv.png" id="i2"/>
                  </af:goLink>
                </af:panelGroupLayout>
              </af:panelWindow>
            </af:popup>
            <af:popup id="p1">
              <af:panelWindow title="بارگذاری فایل" modal="true" id="pw2">
                <af:inputFile label="فایل:" id="if1"
                              binding="#{viewScope.back.bookFileInput}"
                              simple="false"/>
                <af:spacer height="5" id="s2"/>
                <af:commandButton text="بارگذاری فایل" id="cb6"
                                  actionListener="#{viewScope.back.uploadActionListener}"/>
              </af:panelWindow>
            </af:popup>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>