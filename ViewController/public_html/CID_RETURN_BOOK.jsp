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
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="بازگشت کتاب" helpTopicId="return">
         <f:facet name="toolbar">
          <af:toolbar id="t1">
                <af:commandButton text="امتیاز دهی" id="cb5"
                                  disabled="#{pageFlowScope.cid_return.disableRank}">
                  <af:showPopupBehavior popupId="p2"/>
                </af:commandButton>
                <af:spacer  width="10" id="s3"/>
                <fadak:ToolbarSet debug="true" iteratorname="ReturnBookVO1Iterator" id="ts1"
                                    disabled_delete="true"
                                    disabled_create="true" showcreate="false"
                                    showdelete="false"
                                  after_next="#{pageFlowScope.cid_return.fadak_toolbar_afterNext}"
                                  after_previous="#{pageFlowScope.cid_return.fadak_toolbar_afterPrevious}"
                                  showEditCommand="false" showcommit="false"
                                  showquery="false" showrefresh="false"
                                  showrollback="false" showsearch="false"/>

          </af:toolbar>
        </f:facet>
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="105">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.book_search}" disclosed="true"
                              value="#{bindings.SearchBarcodeVCQuery.queryDescriptor}"
                              model="#{bindings.SearchBarcodeVCQuery.queryModel}"
                              queryListener="#{pageFlowScope.cid_return.afetrSearchBarcode}"
                              queryOperationListener="#{bindings.SearchBarcodeVCQuery.processQueryOperation}"
                              rows="1" maxColumns="1" labelWidth="200"
                              fieldWidth="100" saveQueryMode="hidden"
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelGroupLayout id="pgl2" layout="scroll"
                                     valign="middle" halign="start"
                                     >
                  <af:panelBox text=" " id="pb1" showDisclosure="false">
                    <af:panelFormLayout partialTriggers="qryId1" id="pfl1" rows="4" maxColumns="1">
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Title.inputValue}"
                                    label="#{bindings.Title.hints.label}"
                                    required="#{bindings.Title.hints.mandatory}"
                                    columns="#{bindings.Title.hints.displayWidth}"
                                    maximumLength="#{bindings.Title.hints.precision}"
                                    shortDesc="#{bindings.Title.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Title.validator}"/>
                      </af:inputText>
                      
                      <af:inputText value="#{bindings.ProviderName.inputValue}"
                                    label="#{bindings.ProviderName.hints.label}"
                                    required="#{bindings.ProviderName.hints.mandatory}"
                                    columns="#{bindings.ProviderName.hints.displayWidth}"
                                    maximumLength="#{bindings.ProviderName.hints.precision}"
                                    shortDesc="#{bindings.ProviderName.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.ProviderName.validator}"/>
                      </af:inputText>
                      <af:panelLabelAndMessage label="امانت گیرنده " id="plam1">
                        <af:inputText value="#{bindings.ArtId1.inputValue}"
                                      label="#{bindings.ArtId1.hints.label}"
                                      required="#{bindings.ArtId1.hints.mandatory}"
                                      columns="#{bindings.ArtId1.hints.displayWidth}"
                                      maximumLength="#{bindings.ArtId1.hints.precision}"
                                      shortDesc="#{bindings.ArtId1.hints.tooltip}"
                                      id="it14" visible="false">
                          <f:validator binding="#{bindings.ArtId1.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.LoanUser.inputValue}"
                                      label="#{bindings.LoanUser.hints.label}"
                                      required="#{bindings.LoanUser.hints.mandatory}"
                                      columns="#{bindings.LoanUser.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanUser.hints.precision}"
                                      shortDesc="#{bindings.LoanUser.hints.tooltip}"
                                      id="it15" visible="false">
                          <f:validator binding="#{bindings.LoanUser.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.Fname.inputValue}"
                                      label="#{bindings.Fname.hints.label}"
                                      required="#{bindings.Fname.hints.mandatory}"
                                      columns="#{bindings.Fname.hints.displayWidth}"
                                      maximumLength="#{bindings.Fname.hints.precision}"
                                      shortDesc="#{bindings.Fname.hints.tooltip}"
                                      id="it4" readOnly="true">
                          <f:validator binding="#{bindings.Fname.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.Lname.inputValue}"
                                      label="#{bindings.Lname.hints.label}"
                                      required="#{bindings.Lname.hints.mandatory}"
                                      columns="#{bindings.Lname.hints.displayWidth}"
                                      maximumLength="#{bindings.Lname.hints.precision}"
                                      shortDesc="#{bindings.Lname.hints.tooltip}"
                                      id="it5" readOnly="true">
                          <f:validator binding="#{bindings.Lname.validator}"/>
                        </af:inputText>
                      </af:panelLabelAndMessage>
                      <af:inputText value="#{bindings.ArtId.inputValue}"
                                    label="#{bindings.ArtId.hints.label}"
                                    required="#{bindings.ArtId.hints.mandatory}"
                                    columns="#{bindings.ArtId.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId.hints.precision}"
                                    shortDesc="#{bindings.ArtId.hints.tooltip}"
                                    id="it6" visible="false">
                        <f:validator binding="#{bindings.ArtId.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ArtId1.inputValue}"
                                    label="#{bindings.ArtId1.hints.label}"
                                    required="#{bindings.ArtId1.hints.mandatory}"
                                    columns="#{bindings.ArtId1.hints.displayWidth}"
                                    maximumLength="#{bindings.ArtId1.hints.precision}"
                                    shortDesc="#{bindings.ArtId1.hints.tooltip}"
                                    id="it7" visible="false">
                        <f:validator binding="#{bindings.ArtId1.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ArtId1.format}"/>
                      </af:inputText>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                  <af:panelBox text=" " id="pb2" showDisclosure="false"
                               partialTriggers="qryId1">
                  
                      <af:panelFormLayout id="pfl2" maxColumns="2" rows="1">
                        <af:inputText value="#{bindings.LoanStatusText.inputValue}"
                                      label="نوع کتاب"
                                      required="#{bindings.LoanStatusText.hints.mandatory}"
                                      columns="#{bindings.LoanStatusText.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanStatusText.hints.precision}"
                                      shortDesc="#{bindings.LoanStatusText.hints.tooltip}"
                                      id="it13" readOnly="true">
                          <f:validator binding="#{bindings.LoanStatusText.validator}"/>
                        </af:inputText>
                      <af:panelLabelAndMessage label="مدت زمان تاخیر"
                                               id="plam2">
                        <af:inputText value="#{bindings.DelayMonth.inputValue}"
                                      label="#{bindings.DelayMonth.hints.label}"
                                      required="#{bindings.DelayMonth.hints.mandatory}"
                                      columns="#{bindings.DelayMonth.hints.displayWidth}"
                                      maximumLength="#{bindings.DelayMonth.hints.precision}"
                                      shortDesc="#{bindings.DelayMonth.hints.tooltip}"
                                      id="it9" readOnly="true">
                          <f:validator binding="#{bindings.DelayMonth.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.DelayDay.inputValue}"
                                      label="#{bindings.DelayDay.hints.label}"
                                      required="#{bindings.DelayDay.hints.mandatory}"
                                      columns="#{bindings.DelayDay.hints.displayWidth}"
                                      maximumLength="#{bindings.DelayDay.hints.precision}"
                                      shortDesc="#{bindings.DelayDay.hints.tooltip}"
                                      id="it10" readOnly="true">
                          <f:validator binding="#{bindings.DelayDay.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.HolyWeek.inputValue}"
                                      label="#{bindings.HolyWeek.hints.label}"
                                      required="#{bindings.HolyWeek.hints.mandatory}"
                                      columns="#{bindings.HolyWeek.hints.displayWidth}"
                                      maximumLength="#{bindings.HolyWeek.hints.precision}"
                                      shortDesc="#{bindings.HolyWeek.hints.tooltip}"
                                      id="it11" readOnly="true">
                          <f:validator binding="#{bindings.HolyWeek.validator}"/>
                        </af:inputText>
                      </af:panelLabelAndMessage>
                        <af:inputText value="#{bindings.BookTypeText.inputValue}"
                                      label="#{bindings.BookTypeText.hints.label}"
                                      required="#{bindings.BookTypeText.hints.mandatory}"
                                      columns="#{bindings.BookTypeText.hints.displayWidth}"
                                      maximumLength="#{bindings.BookTypeText.hints.precision}"
                                      shortDesc="#{bindings.BookTypeText.hints.tooltip}"
                                      id="it8" readOnly="true">
                          <f:validator binding="#{bindings.BookTypeText.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.PenaltyOffer.inputValue}"
                                      label="#{bindings.PenaltyOffer.hints.label}"
                                      required="#{bindings.PenaltyOffer.hints.mandatory}"
                                      columns="#{bindings.PenaltyOffer.hints.displayWidth}"
                                      maximumLength="#{bindings.PenaltyOffer.hints.precision}"
                                      shortDesc="#{bindings.PenaltyOffer.hints.tooltip}"
                                      id="it12" readOnly="true">
                          <f:validator binding="#{bindings.PenaltyOffer.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.PenaltyOffer.format}"/>
                        </af:inputText>
                      <af:inputText label="مقدار جریمه" id="it16"
                                    partialTriggers="cb2 cb1"
                                    value="#{pageFlowScope.cid_return.penaltyValue}"
                                    disabled="#{pageFlowScope.cid_return.disablePenalty}"/>
                      <af:inputText label="توضیحات" id="it17"
                                    disabled="#{pageFlowScope.cid_return.disablePenalty}"
                                    partialTriggers="cb2 cb1"
                                    value="#{pageFlowScope.cid_return.penaltyDescription}"/>
                      <f:facet name="footer"/>
                      </af:panelFormLayout>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:panelFormLayout id="pfl5">
                        <f:facet name="footer">
                          <af:panelGroupLayout id="pgl4" layout="horizontal"
                                               halign="end" valign="middle">
                            <af:commandButton text="بازگشت" id="cb1"
                                              actionListener="#{pageFlowScope.cid_return.returnbtn_clicked}"
                                              />
                            <af:commandButton text="انصراف" id="cb2"
                                              actionListener="#{pageFlowScope.cid_return.cancelbtn_clearForm}"/>
                          </af:panelGroupLayout>
                        </f:facet>
                      </af:panelFormLayout>
                    
                  </af:panelBox>
                </af:panelGroupLayout>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        
        
        
        <f:facet name="popup">
          <af:group id="g1">
            <af:popup id="p1">
              <af:panelWindow id="pw1">
                <af:panelFormLayout id="pfl6">
                  <f:facet name="footer">
                    <h:panelGroup id="pg1">
                      <af:commandButton text="بلی" id="cb3"
                                        actionListener="#{pageFlowScope.cid_return.return_popupbtn}"
                                       />
                      <af:commandButton text="خیر" id="cb4"/>
                    </h:panelGroup>
                  </f:facet>
                  <af:outputText id="ot1"
                                 value="#{pageFlowScope.cid_return.popupText}"/>
                  <af:spacer width="10" height="20" id="s2"/>
                </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
            <af:popup id="p2">
              <af:panelWindow  id="pw2">
               <af:panelFormLayout id="pfl3">
    <f:facet name="footer">
      <af:panelGroupLayout id="pgl3">
        <af:commandButton text="ثبت" id="cb7"
                          action="#{pageFlowScope.cid_return.insert_vbook_rank}"/>
        <af:commandButton text="انصراف" id="cb6" />
      </af:panelGroupLayout>
    </f:facet>
    <af:inputText label="امتیاز" id="it18" value="#{pageFlowScope.cid_return.rank}"/>
  </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
          
            <af:popup id="reportPop" childCreation="deferred" 
                  contentDelivery="lazyUncached"
                         >
                  <af:panelWindow title="انتخاب فرمت گزارش"  modal="true"
                                  id="pw4">
                <af:outputText value="این کتاب رزرو می باشد اگر مایل به چاپ برگه رزرو می باشید نوع گزارش را انتخاب کنید." id="ot2"/>
                <af:panelGroupLayout layout="horizontal" id="pgl11">
                 <af:goLink shortDesc="RTF"  destination="#{initParam.reportServer}#{pageFlowScope.cid_return.reportPath}&amp;desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{initParam.reportServer}#{pageFlowScope.cid_return.reportPath}&amp;desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;" id="gl1"
                             >
                  <af:image source="/icons/htmlcss.png" id="i2"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{pageFlowScope.cid_return.reportPath}&amp;desformat=html" targetFrame="_blank"
                                id="gl2"  >
                  <af:image source="/icons/html.png"  id="i3"/>
                  </af:goLink>
                  
                    <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{pageFlowScope.cid_return.reportPath}&amp;desformat=xml" targetFrame="_blank"
                                id="gl3"  >
                  <af:image source="/icons/xml.png" id="i4"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{pageFlowScope.cid_return.reportPath}&amp;desformat=delimiteddata" targetFrame="_blank"
                             id="gl4"  >
                  <af:image source="/icons/csv.png" id="i5"/>
                  </af:goLink>
                  </af:panelGroupLayout>
                </af:panelWindow>
              </af:popup>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>