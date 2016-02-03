<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="فرم انتخاب کتاب های مورد نظر">
            <af:panelSplitter id="ps1" splitterPosition="300"
                              orientation="horizontal">
              <f:facet name="first">
                <af:panelGroupLayout id="pgl4" layout="scroll">
                  <af:panelBox text="تغییر نوع برچسب" id="pb3" showDisclosure="false">
                    <f:facet name="toolbar"/>
                    <af:panelGroupLayout id="pgl5" layout="vertical"
                                         halign="center">
                      <af:commandButton text="برچسب فارسی" id="cb7"
                                        action="#{viewScope.report_farsi_label.setFarsiVc}"
                                        visible="#{viewScope.report_farsi_label.currentReadingOrder.value==2}"/>
                      <af:commandButton text="برچسب انگلیسی" id="cb8"
                                        visible="#{viewScope.report_farsi_label.currentReadingOrder.value==1}"
                                        action="#{viewScope.report_farsi_label.setLatinVC}"/>
                    </af:panelGroupLayout>
                  </af:panelBox>
                  <af:panelBox text="کتاب های انتخابی" id="pb1"
                               showDisclosure="false">
                    <af:panelFormLayout id="pfl1">
                    
                      <af:inputText label="ازکد" id="it1"
                                    value="#{viewScope.report_farsi_label.fromCode}"/>
                      <af:inputText label="تا کد" id="it2"
                                    value="#{viewScope.report_farsi_label.toCode}"/>
                      <af:spacer width="10" height="10" id="s1"/>
                      <f:facet name="footer">
                        <af:panelGroupLayout id="pgl1">
                          <af:commandButton text="برچسب عطف به کتاب" id="cb1"
                                            actionListener="#{viewScope.report_farsi_label.bookLabelBtnActionListener}"/>
                        </af:panelGroupLayout>
                      </f:facet>
                    </af:panelFormLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                  <af:panelBox text="تنظیمات" id="pb4" showDisclosure="false">
                    <af:panelGroupLayout id="pgl6" halign="center"
                                         layout="vertical">
                      <af:commandButton partialSubmit="true" text="حروف اختصاری"
                                        id="cb9">
                        <af:showPopupBehavior popupId="settings_popup"
                                              triggerType="click"/>
                      </af:commandButton>
                    </af:panelGroupLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox showDisclosure="false" id="pb2"
                             text="#{viewScope.report_farsi_label.currentReadingOrder.value==1?'برچسب فارسی' :'برچسب انگلیسی'}">
                  <af:table value="#{bindings.VirtualBookList_FarsiLabelVO1.collectionModel}"
                            var="row"
                            rows="#{bindings.VirtualBookList_FarsiLabelVO1.rangeSize}"
                            emptyText="#{bindings.VirtualBookList_FarsiLabelVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                            fetchSize="#{bindings.VirtualBookList_FarsiLabelVO1.rangeSize}"
                            rowBandingInterval="0"
                            filterModel="#{bindings.VirtualBookList_FarsiLabelVO1Query.queryDescriptor}"
                            queryListener="#{bindings.VirtualBookList_FarsiLabelVO1Query.processQuery}"
                            filterVisible="true" varStatus="vs"
                            selectedRowKeys="#{bindings.VirtualBookList_FarsiLabelVO1.collectionModel.selectedRow}"
                            selectionListener="#{bindings.VirtualBookList_FarsiLabelVO1.collectionModel.makeCurrent}"
                            rowSelection="single" id="t1"
                            columnStretching="column:c3" >
                             <af:column 
                               id="c5" headerText="#{viewcontrollerBundle.row}"
                                        width="50">
                      <af:outputText value="#{vs.index+1}" id="ot1"/>
                    </af:column>
                    <af:column sortProperty="ArtId" filterable="true"
                               sortable="true"
                               headerText="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.label}"
                               id="c2">
                      <af:inputText  value="#{row.bindings.ArtId.inputValue}"
                                    label="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.label}"
                                    required="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.mandatory}"
                                    columns="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.displayWidth}"
                                    maximumLength="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.precision}"
                                    shortDesc="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.tooltip}"
                                    id="it4" readOnly="true"
                                    >
                        <f:validator binding="#{row.bindings.ArtId.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ArtId.format}"/>
                      </af:inputText readOnly="true">
                    </af:column>
                    <af:column sortProperty="CallNo" filterable="true"
                               sortable="true"
                               headerText="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.label}"
                               id="c1" align="left">
                      <af:inputText readOnly="true" value="#{row.bindings.CallNo.inputValue}"
                                    label="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.label}"
                                    required="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.mandatory}"
                                    columns="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.displayWidth}"
                                    maximumLength="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.precision}"
                                    shortDesc="#{bindings.VirtualBookList_FarsiLabelVO1.hints.CallNo.tooltip}"
                                    id="it5" styleClass="AFFieldTextLTRMarker">
                        <f:validator binding="#{row.bindings.CallNo.validator}"/>
                      </af:inputText readOnly="true">
                    </af:column>
                    <af:column sortProperty="Title" filterable="true"
                               sortable="true"
                               headerText="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.label}"
                               id="c3">
                      <af:inputText readOnly="true" value="#{row.bindings.Title.inputValue}"
                                    label="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.label}"
                                    required="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.mandatory}"
                                    columns="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.displayWidth}"
                                    maximumLength="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.precision}"
                                    shortDesc="#{bindings.VirtualBookList_FarsiLabelVO1.hints.Title.tooltip}"
                                    id="it3">
                        <f:validator binding="#{row.bindings.Title.validator}"/>
                      </af:inputText readOnly="true">
                    </af:column>
                    <af:column headerText="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.label}"
                               id="c4" sortable="true" sortProperty="ProviderName" filterable="true">
                      <af:inputText  value="#{row.bindings.ProviderName.inputValue}"
                                    label="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.label}"
                                    required="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.mandatory}"
                                    columns="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.displayWidth}"
                                    maximumLength="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.precision}"
                                    shortDesc="#{bindings.VirtualBookList_FarsiLabelVO1.hints.ProviderName.tooltip}"
                                    id="it6" readOnly="true">
                        <f:validator binding="#{row.bindings.ProviderName.validator}"/>
                      </af:inputText readOnly="true">
                    </af:column>
                  </af:table>
                  <f:facet name="toolbar"/>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup">
          <af:group id="g1">
            <af:popup id="p1">
              <af:panelWindow id="pw1"
                              title="#{viewScope.report_farsi_label.currentReadingOrder.value==1?'چاپ برچسب فارسی':'چاپ برچسب لاتین'}"
                              modal="true"
                              inlineStyle="width:700px; height:400.0px;">
                <af:panelHeader text=" " id="ph1">
                  <f:facet name="context"/>
                  <f:facet name="menuBar"/>
                  <f:facet name="toolbar"/>
                  <f:facet name="legend"/>
                  <f:facet name="info"/>
                  <af:panelGroupLayout id="pgl3" layout="scroll">
                    <af:panelSplitter styleClass="AFStretchWidth"
                                      splitterPosition="150" id="ps2"
                                      orientation="vertical">
                      <f:facet name="first">
                        <af:panelSplitter id="ps3" styleClass="AFStretchWidth"
                                          splitterPosition="400">
                          <f:facet name="first">
                            <af:table value="#{bindings.Rep_VirtualBook_FarsiLabelVO1.collectionModel}"
                                      var="row"
                                      rows="#{bindings.Rep_VirtualBook_FarsiLabelVO1.rangeSize}"
                                      emptyText="#{bindings.Rep_VirtualBook_FarsiLabelVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                      fetchSize="#{bindings.Rep_VirtualBook_FarsiLabelVO1.rangeSize}"
                                      rowBandingInterval="0"
                                      filterModel="#{bindings.Rep_VirtualBook_FarsiLabelVO1Query.queryDescriptor}"
                                      queryListener="#{bindings.Rep_VirtualBook_FarsiLabelVO1Query.processQuery}"
                                      filterVisible="true" varStatus="vs"
                                      autoHeightRows="5"
                                      contentDelivery="immediate"
                                      selectedRowKeys="#{bindings.Rep_VirtualBook_FarsiLabelVO1.collectionModel.selectedRow}"
                                      selectionListener="#{bindings.Rep_VirtualBook_FarsiLabelVO1.collectionModel.makeCurrent}"
                                      rowSelection="single" id="t2"
                                      columnStretching="column:c7"
                                      inlineStyle="height:120px;">
                              <af:column sortProperty="ArtId" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.label}"
                                         id="c6">
                                <af:inputText readOnly="true"
                                              value="#{row.bindings.ArtId.inputValue}"
                                              label="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.label}"
                                              required="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.mandatory}"
                                              columns="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.displayWidth}"
                                              maximumLength="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.precision}"
                                              shortDesc="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.tooltip}"
                                              id="it8">
                                  <f:validator binding="#{row.bindings.ArtId.validator}"/>
                                  <af:convertNumber groupingUsed="false"
                                                    pattern="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.ArtId.format}"/>
                                </af:inputText>
                              </af:column>
                              <af:column sortProperty="Title" filterable="true"
                                         sortable="true"
                                         headerText="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.label}"
                                         id="c7">
                                <af:inputText readOnly="true"
                                              value="#{row.bindings.Title.inputValue}"
                                              label="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.label}"
                                              required="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.mandatory}"
                                              columns="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.displayWidth}"
                                              maximumLength="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.precision}"
                                              shortDesc="#{bindings.Rep_VirtualBook_FarsiLabelVO1.hints.Title.tooltip}"
                                              id="it7">
                                  <f:validator binding="#{row.bindings.Title.validator}"/>
                                </af:inputText>
                              </af:column>
                            </af:table>
                          </f:facet>
                          <f:facet name="second">
                            <af:panelGroupLayout id="pgl2" layout="vertical">
                              <af:selectOneChoice label="شروع چاپ از"
                                                  id="soc5" autoSubmit="true"
                                                  value="#{viewScope.report_farsi_label.print_column}">
                                <af:selectItem label="ستون 1" value="1"
                                               id="si7"/>
                                <af:selectItem label="ستون 2" value="2"
                                               id="si13"/>
                                <af:selectItem label="ستون 3" value="3"
                                               id="si12"/>
                                <af:selectItem label="ستون 4" value="4"
                                               id="si10"/>
                                <af:selectItem label="ستون 5" value="5"
                                               id="si9"/>
                                <af:selectItem label="ستون 6" value="6"
                                               id="si11"/>
                                <af:selectItem label="ستون 7" value="7"
                                               id="si8"/>
                              </af:selectOneChoice>
                              <af:commandButton text="چاپ برای همه عنوان ها"
                                                disabled="#{!bindings.labelFarsi_printAllTitles.enabled}"
                                                id="cb2">
                                <af:fileDownloadActionListener method="#{viewScope.report_farsi_label.handleDownloadAllTitles}"
                                                               contentType="application/rtf"
                                                               filename="farsi label all titles-#{viewScope.report_farsi_label.timeStamp}.rtf"/>
                              </af:commandButton>
                              <af:commandButton text="چاپ برای عنوان"
                                                disabled="#{!bindings.labelFarsi_printTitle.enabled}"
                                                id="cb3">
                                <af:fileDownloadActionListener method="#{viewScope.report_farsi_label.handleDownloadTitle}"
                                                               contentType="application/rtf"
                                                               filename="farsi label title-#{viewScope.report_farsi_label.timeStamp}.rtf"/>
                              </af:commandButton>
                              <af:commandButton text="چاپ برای جلد"
                                                disabled="#{!bindings.labelFarsi_printVolNo.enabled}"
                                                id="cb4">
                                <af:fileDownloadActionListener method="#{viewScope.report_farsi_label.handleDownloadVolNo}"
                                                               contentType="application/rtf"
                                                               filename="farsi label volNo-#{viewScope.report_farsi_label.timeStamp}.rtf"/>
                              </af:commandButton>
                              <af:commandButton text="چاپ برای قسمت"
                                                disabled="#{!bindings.labelFarsi_printPartNo.enabled}"
                                                id="cb5">
                                <af:fileDownloadActionListener method="#{viewScope.report_farsi_label.handleDownloadPartNo}"
                                                               contentType="application/rtf"
                                                               filename="farsi label partNo-#{viewScope.report_farsi_label.timeStamp}.rtf"/>
                              </af:commandButton>
                              <af:commandButton text="چاپ برای نسخه"
                                                disabled="#{!bindings.labelFarsi_printRepNo.enabled}"
                                                id="cb6">
                                <af:fileDownloadActionListener method="#{viewScope.report_farsi_label.handleDownloadRepNo}"
                                                               contentType="application/rtf"
                                                               filename="farsi label repNo-#{viewScope.report_farsi_label.timeStamp}.rtf"/>
                              </af:commandButton>
                            </af:panelGroupLayout>
                          </f:facet>
                        </af:panelSplitter>
                      </f:facet>
                      <f:facet name="second">
                        <af:table value="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.rangeSize}"
                                  emptyText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                  fetchSize="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  filterModel="#{bindings.Rep_PhysicalBook_FarsiLabelVO1Query.queryDescriptor}"
                                  queryListener="#{bindings.Rep_PhysicalBook_FarsiLabelVO1Query.processQuery}"
                                  filterVisible="true" varStatus="vs"
                                  selectedRowKeys="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.collectionModel.makeCurrent}"
                                  rowSelection="single" id="t3"
                                  partialTriggers="::t2">
                          <af:column sortProperty="Barcode" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.label}"
                                     id="c15">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.Barcode.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Barcode.tooltip}"
                                          id="it12">
                              <f:validator binding="#{row.bindings.Barcode.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="RegId" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.label}"
                                     id="c9">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.RegId.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.RegId.tooltip}"
                                          id="it18">
                              <f:validator binding="#{row.bindings.RegId.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="VolNo" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.label}"
                                     id="c18">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.VolNo.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.VolNo.tooltip}"
                                          id="it17">
                              <f:validator binding="#{row.bindings.VolNo.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="PartNo" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.label}"
                                     id="c16">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.PartNo.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.PartNo.tooltip}"
                                          id="it19">
                              <f:validator binding="#{row.bindings.PartNo.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="ReplicateNo"
                                     filterable="true" sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.label}"
                                     id="c11">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.ReplicateNo.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.tooltip}"
                                          id="it10">
                              <f:validator binding="#{row.bindings.ReplicateNo.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ReplicateNo.format}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="ExistenceStatus"
                                     filterable="true" sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ExistenceStatus.label}"
                                     id="c10">
                            <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                                label="#{row.bindings.ExistenceStatus.label}"
                                                required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ExistenceStatus.mandatory}"
                                                shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.ExistenceStatus.tooltip}"
                                                id="soc1" readOnly="true">
                              <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                             id="si1"/>
                            </af:selectOneChoice>
                          </af:column>
                          <af:column sortProperty="LoanStatus" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.LoanStatus.label}"
                                     id="c17">
                            <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                                label="#{row.bindings.LoanStatus.label}"
                                                required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.LoanStatus.mandatory}"
                                                shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.LoanStatus.tooltip}"
                                                id="soc2" readOnly="true">
                              <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                             id="si2"/>
                            </af:selectOneChoice>
                          </af:column>
                          <af:column sortProperty="Place" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Place.label}"
                                     id="c8">
                            <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                                label="#{row.bindings.Place.label}"
                                                required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Place.mandatory}"
                                                shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.Place.tooltip}"
                                                id="soc4" readOnly="true">
                              <f:selectItems value="#{row.bindings.Place.items}"
                                             id="si4"/>
                            </af:selectOneChoice>
                          </af:column>
                          <af:column sortProperty="SafetyStatus"
                                     filterable="true" sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.SafetyStatus.label}"
                                     id="c13">
                            <af:selectOneChoice value="#{row.bindings.SafetyStatus.inputValue}"
                                                label="#{row.bindings.SafetyStatus.label}"
                                                required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.SafetyStatus.mandatory}"
                                                shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.SafetyStatus.tooltip}"
                                                id="soc3" readOnly="true">
                              <f:selectItems value="#{row.bindings.SafetyStatus.items}"
                                             id="si3"/>
                            </af:selectOneChoice>
                          </af:column>
                          <af:column sortProperty="UserName" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.label}"
                                     id="c14">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.UserName.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.UserName.tooltip}"
                                          id="it16">
                              <f:validator binding="#{row.bindings.UserName.validator}"/>
                            </af:inputText>
                          </af:column>
                          <af:column sortProperty="InsertDate" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.label}"
                                     id="c12">
                            <af:inputText readOnly="true"
                                          value="#{row.bindings.InsertDate.inputValue}"
                                          label="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.label}"
                                          required="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.mandatory}"
                                          columns="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.displayWidth}"
                                          maximumLength="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.precision}"
                                          shortDesc="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.tooltip}"
                                          id="it13">
                              <f:validator binding="#{row.bindings.InsertDate.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.Rep_PhysicalBook_FarsiLabelVO1.hints.InsertDate.format}"/>
                            </af:inputText>
                          </af:column>
                        </af:table>
                      </f:facet>
                    </af:panelSplitter>
                  </af:panelGroupLayout>
                </af:panelHeader>
              </af:panelWindow>
            </af:popup>
            <af:popup id="settings_popup">
              <af:panelWindow id="pw2" title="تنظیمات">
                <af:selectOneRadio label="برچسب عطف به کتاب" id="sor1" autoSubmit="true"
                                   value="#{viewScope.report_farsi_label.p_latin_farsi}">
                  <af:selectItem label="Volume(v), Part(p), Copy(c)" value="1"
                                 id="si6" />
                  <af:selectItem label="جلد(ج)، قسمت(ق)، نسخه(ن)" value="2"
                                 id="si5"/>
                </af:selectOneRadio>
              </af:panelWindow>
            </af:popup>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>