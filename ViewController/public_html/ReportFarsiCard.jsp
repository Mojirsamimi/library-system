<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
          <af:panelHeader text="#{viewcontrollerBundle.print_book_farsi_card_select_books}">
            <af:panelSplitter id="ps1" splitterPosition="300"
                              orientation="horizontal">
              <f:facet name="first">
                <af:panelGroupLayout id="pgl6" layout="scroll">
                 <af:panelBox showDisclosure="false" text="تغییر نوع کاربرگه" id="pb3">
                    <af:panelGroupLayout id="pgl7" halign="center"
                                         layout="vertical">
                      <af:commandButton text="کاربرگه لاتین" id="cb3"
                                        action="#{viewScope.report_farsi_card.setLatinVC}"
                                        visible="#{viewScope.report_farsi_card.currentReadingOrder.value==1}"/>
                      <af:commandButton text="کاربرگه فارسی" id="cb4"
                                        action="#{viewScope.report_farsi_card.setFarsiVC}"
                                        visible="#{viewScope.report_farsi_card.currentReadingOrder.value==2}"/>
                      <af:spacer id="s2" height="5"/>
                                         
                    </af:panelGroupLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                  <af:panelBox text="#{viewcontrollerBundle.print_book_farsi_card_selected_books}"
                               id="pb1" showDisclosure="false">
                    <af:panelFormLayout id="pfl1">
                      <af:selectBooleanRadio text="کد"
                      autoSubmit="true"
                                              id="sbr1"
                                             value="#{viewScope.report_farsi_card.code}" group="selected books"/>                                             
                                            
                      <af:inputText label="#{viewcontrollerBundle.print_book_farsi_card_from_code}"
                                    id="it1"
                                    partialTriggers="sbr1 sbr2"
                                    disabled="#{!viewScope.report_farsi_card.code}"
                                    value="#{viewScope.report_farsi_card.fromCode}"/>
                      <af:inputText id="it2"
                        disabled="#{!viewScope.report_farsi_card.code}"
                         partialTriggers="sbr1 sbr2"
                                    value="#{viewScope.report_farsi_card.toCode}"
                                    label="#{viewcontrollerBundle.print_book_farsi_card_to_code}"/>    
                                
                      <af:separator id="s1"/>
                       <af:selectBooleanRadio text="ردیف"
                                              id="sbr2"
                                              autoSubmit="true"
                                             value="#{viewScope.report_farsi_card.row}" group="selected books"/>
                      <af:inputText value="#{viewScope.report_farsi_card.fromRow}"
                                    label="#{viewcontrollerBundle.print_book_farsi_card_from_row}"
                                     partialTriggers="sbr1 sbr2"
                                      disabled="#{!viewScope.report_farsi_card.row}"
                                    id="it10">
                        <f:validator binding="#{bindings.from.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.from.format}"/>
                      </af:inputText>
                      <af:inputText value="#{viewScope.report_farsi_card.toRow}"
                        disabled="#{!viewScope.report_farsi_card.row}"
                         partialTriggers="sbr1 sbr2"
                                    label="#{viewcontrollerBundle.print_book_farsi_card_to_row}"
                                    id="it9">
                        <f:validator binding="#{bindings.to.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.to.format}"/>
                      </af:inputText>
                      <af:panelGroupLayout id="pgl1" layout="vertical"
                                           valign="middle" halign="center">
                        <af:commandButton text="#{viewcontrollerBundle.print_book_farsi_card_barge_madar}"
                                          id="cb11"
                                          actionListener="#{viewScope.report_farsi_card.filter_vBook_codeOrRow}"/>
                      </af:panelGroupLayout>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text="#{viewScope.report_farsi_card.currentReadingOrder.value==1?'کاربرگه فارسی':'کاربرگه لاتین'}" showDisclosure="false" id="pb2">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" valign="middle" layout="scroll"
                                       halign="center">
                  
                    <af:table value="#{bindings.VirtualBookList_farsiCardVO1.collectionModel}"
                              var="row"
                              rows="#{bindings.VirtualBookList_farsiCardVO1.rangeSize}"
                              emptyText="#{bindings.VirtualBookList_farsiCardVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                              fetchSize="#{bindings.VirtualBookList_farsiCardVO1.rangeSize}"
                              rowBandingInterval="0" autoHeightRows="25"
                              contentDelivery="immediate"
                              filterModel="#{bindings.VirtualBookList_farsiCardVO1Query.queryDescriptor}"
                              queryListener="#{bindings.VirtualBookList_farsiCardVO1Query.processQuery}"
                              filterVisible="true" varStatus="vs"
                              selectedRowKeys="#{bindings.VirtualBookList_farsiCardVO1.collectionModel.selectedRow}"
                              selectionListener="#{bindings.VirtualBookList_farsiCardVO1.collectionModel.makeCurrent}"
                              rowSelection="single" id="t1"
                              columnStretching="column:c1" width="100%"
                              partialTriggers="::cb3 ::cb4">
                      <af:column sortProperty="VbookRowNum" sortable="true"
                                 headerText="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.label}"
                                 id="c4">
                        <af:inputText value="#{row.bindings.VbookRowNum.inputValue}"
                                      label="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.label}"
                                      required="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.mandatory}"
                                      columns="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.displayWidth}"
                                      maximumLength="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.precision}"
                                      shortDesc="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.tooltip}"
                                      id="it4" readOnly="true">
                          <f:validator binding="#{row.bindings.VbookRowNum.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.VirtualBookList_farsiCardVO1.hints.VbookRowNum.format}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="ArtId" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.label}"
                                 id="c2">
                        <af:inputText value="#{row.bindings.ArtId.inputValue}"
                                      label="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.label}"
                                      required="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.mandatory}"
                                      columns="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.displayWidth}"
                                      maximumLength="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.precision}"
                                      shortDesc="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.tooltip}"
                                      id="it7" readOnly="true">
                          <f:validator binding="#{row.bindings.ArtId.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.VirtualBookList_farsiCardVO1.hints.ArtId.format}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="CallNo" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.label}"
                                 id="c5" align="left">
                        <af:inputText value="#{row.bindings.CallNo.inputValue}"
                                      label="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.label}"
                                      required="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.mandatory}"
                                      columns="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.displayWidth}"
                                      maximumLength="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.precision}"
                                      shortDesc="#{bindings.VirtualBookList_farsiCardVO1.hints.CallNo.tooltip}"
                                      id="it11" readOnly="true"
                                      styleClass="AFFieldTextLTRMarker">
                          <f:validator binding="#{row.bindings.CallNo.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="Title" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.label}"
                                 id="c1">
                        <af:inputText value="#{row.bindings.Title.inputValue}"
                                      label="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.label}"
                                      required="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.mandatory}"
                                      columns="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.displayWidth}"
                                      maximumLength="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.precision}"
                                      shortDesc="#{bindings.VirtualBookList_farsiCardVO1.hints.Title.tooltip}"
                                      id="it6" readOnly="true">
                          <f:validator binding="#{row.bindings.Title.validator}"/>
                        </af:inputText>
                      </af:column>
                      <af:column sortProperty="ProviderName" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.label}"
                                 id="c3">
                        <af:inputText value="#{row.bindings.ProviderName.inputValue}"
                                      label="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.label}"
                                      required="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.mandatory}"
                                      columns="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.displayWidth}"
                                      maximumLength="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.precision}"
                                      shortDesc="#{bindings.VirtualBookList_farsiCardVO1.hints.ProviderName.tooltip}"
                                      id="it5" readOnly="true">
                          <f:validator binding="#{row.bindings.ProviderName.validator}"/>
                        </af:inputText>
                      </af:column>
                      <f:facet name="header">
                        <af:group id="g1"/>
                      </f:facet>
                    </af:table>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup">
        <af:group>
         <af:popup id="reportPop" childCreation="deferred"
                      contentDelivery="lazyUncached">
              <af:panelWindow title="انتخاب فرمت گزارش" modal="true" id="pw1">
                <af:panelGroupLayout layout="horizontal" id="pgl13">
                 <af:goLink shortDesc="RTF"  destination="#{initParam.reportServer}#{viewScope.report_farsi_card.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                
                  <af:goLink shortDesc="Html/CSS"
                             destination="#{initParam.reportServer}#{viewScope.report_farsi_card.reportPath}&desformat=htmlcss"
                             targetFrame="_blank" inlineStyle="padding:10.0px;"
                             id="gl4">
                    <af:image source="/icons/htmlcss.png" id="i3"/>
                  </af:goLink>
                  <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.report_farsi_card.reportPath}&desformat=html"
                             targetFrame="_blank" id="gl3">
                    <af:image source="/icons/html.png" id="i4"/>
                  </af:goLink>
                  <af:goLink shortDesc="XML" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.report_farsi_card.reportPath}&desformat=xml"
                             targetFrame="_blank" id="gl2">
                    <af:image source="/icons/xml.png" id="i1"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;"
                             destination="#{initParam.reportServer}#{viewScope.report_farsi_card.reportPath}&desformat=delimiteddata"
                             targetFrame="_blank" id="gl1">
                    <af:image source="/icons/csv.png" id="i2"/>
                  </af:goLink>
                </af:panelGroupLayout>
              </af:panelWindow>
            </af:popup>
          <af:popup id="settingsPopUp">
            <af:panelWindow id="pw2">
              <af:panelHeader text="انتخاب نوع برگه درخواستی و تعداد کپی" id="ph1">
                <f:facet name="context"/>
                <f:facet name="menuBar"/>
                <f:facet name="toolbar"/>
                <f:facet name="legend"/>
                <f:facet name="info"/>
                <af:panelFormLayout id="pfl3">
                    <af:selectBooleanCheckbox 
                                              label="درخواست برگه مادر" id="sbc1"
                                              value="#{viewScope.report_farsi_card.MCheck}"/>
                    <af:selectBooleanCheckbox
                                              value="#{viewScope.report_farsi_card.UCheck}"
                                              label="درخواست برگه عنوان" id="sbc2"/>
                    <af:selectBooleanCheckbox 
                                              value="#{viewScope.report_farsi_card.SCheck}"
                                              label="درخواست برگه موضوع" id="sbc3"/>
                    <af:selectBooleanCheckbox 
                                              value="#{viewScope.report_farsi_card.PCheck}"
                                              label="درخواست برگه پدیدآور" id="sbc4"/>
                    <af:selectBooleanCheckbox 
                                              value="#{viewScope.report_farsi_card.NCheck}"
                                              label="درخواست برگه ناشر" id="sbc5"/>
                    <af:selectBooleanCheckbox 
                                              value="#{viewScope.report_farsi_card.FCheck}"
                                              label="درخواست برگه فروست" id="sbc6"/>
                    <af:selectBooleanCheckbox 
                                              value="#{viewScope.report_farsi_card.utCheck}"
                                              label="درخواست برگه عنوان فرعی" id="sbc7"/>
                    <f:facet name="footer">
                      <af:panelGroupLayout id="pgl3">
                        <af:commandButton text="تایید" id="cb9"
                                          action="#{viewScope.report_farsi_card.setReportParameters}"/>
                        <af:commandButton text="انصراف" id="cb10"/>
                      </af:panelGroupLayout>
                    </f:facet>
                </af:panelFormLayout>
              </af:panelHeader>
            </af:panelWindow>
          </af:popup>
            <af:popup id="pMainCard">
              <af:panelWindow id="pw3" inlineStyle="width:500.0px;"
                              modal="true">
                <af:panelGroupLayout id="pgl5" layout="vertical"
                                     valign="middle" halign="center">
                  <af:table value="#{bindings.Rep_VirtualBookFarsiCardVo1.collectionModel}"
                            var="row"
                            rows="#{bindings.Rep_VirtualBookFarsiCardVo1.rangeSize}"
                            emptyText="#{bindings.Rep_VirtualBookFarsiCardVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                            fetchSize="#{bindings.Rep_VirtualBookFarsiCardVo1.rangeSize}"
                            rowBandingInterval="0"
                            filterModel="#{bindings.Rep_VirtualBookFarsiCardVo1Query.queryDescriptor}"
                            queryListener="#{bindings.Rep_VirtualBookFarsiCardVo1Query.processQuery}"
                            filterVisible="true" varStatus="vs"
                            selectedRowKeys="#{bindings.Rep_VirtualBookFarsiCardVo1.collectionModel.selectedRow}"
                            selectionListener="#{bindings.Rep_VirtualBookFarsiCardVo1.collectionModel.makeCurrent}"
                            rowSelection="single" id="t2"
                            columnStretching="column:c7"
                            inlineStyle="width:90.0%;">
                    <af:column sortProperty="ArtId" filterable="true"
                               sortable="true"
                               headerText="#{bindings.Rep_VirtualBookFarsiCardVo1.hints.ArtId.label}"
                               id="c6">
                      <af:outputText value="#{row.ArtId}" id="ot7">
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.Rep_VirtualBookFarsiCardVo1.hints.ArtId.format}"/>
                      </af:outputText>
                    </af:column>
                    <af:column sortProperty="Title" filterable="true"
                               sortable="true"
                               headerText="#{bindings.Rep_VirtualBookFarsiCardVo1.hints.Title.label}"
                               id="c7">
                      <af:outputText value="#{row.Title}" id="ot6"/>
                    </af:column>
                  </af:table>
                 
                  <af:panelGroupLayout id="pgl4">
                    <af:commandButton 
                                      text="چاپ برگه مادر فارسی"
                                      disabled="#{!bindings.bookFarsiCard_madar_printOne.enabled}"
                                      
                                      id="cb1"
                                      visible="#{viewScope.report_farsi_card.currentReadingOrder.value==1}">
                      <af:fileDownloadActionListener method="#{viewScope.report_farsi_card.handleDownloadMadarOne}" contentType="application/rtf"
                                                             filename="farsi card-#{viewScope.report_farsi_card.timeStamp}.rtf"/>
                    </af:commandButton>
                    <af:commandButton
                                       text="چاپ برگه مادر فارسی کتابها"
                                      disabled="#{!bindings.bookFarsiCard_madar_printAll.enabled}"
                                      visible="#{viewScope.report_farsi_card.currentReadingOrder.value==1}"
                                      id="cb2">
                                       <af:fileDownloadActionListener method="#{viewScope.report_farsi_card.handleDownloadMadarAll}" contentType="application/rtf"
                                                             filename="farsi card all-#{viewScope.report_farsi_card.timeStamp}.rtf"/>
                                      </af:commandButton>
                    <af:commandButton text="چاپ برگه مادر لاتین" id="cb5"  visible="#{viewScope.report_farsi_card.currentReadingOrder.value==2}">
                      <af:fileDownloadActionListener method="#{viewScope.report_farsi_card.handleDownloadLatinMadarOne}" contentType="application/rtf"
                                                             filename="latin card-#{viewScope.report_farsi_card.timeStamp}.rtf"/>
                    </af:commandButton>
                    <af:commandButton text="چاپ برگه مادر لاتین کتابها" id="cb6"  visible="#{viewScope.report_farsi_card.currentReadingOrder.value==2}">
                      <af:fileDownloadActionListener method="#{viewScope.report_farsi_card.handleDownloadLatinMadarAll}" contentType="application/rtf"
                                                             filename="latin card all-#{viewScope.report_farsi_card.timeStamp}.rtf"/>
                    </af:commandButton>
                  </af:panelGroupLayout>
                </af:panelGroupLayout>
              </af:panelWindow>
            </af:popup>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>