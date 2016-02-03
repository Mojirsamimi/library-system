<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
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
        <af:panelHeader text="#{viewcontrollerBundle.mem_clearing}"
                        helpTopicId="clearing">
        
         <f:facet name="toolbar">
          <af:toolbar id="t1">
                  <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    after_next="#{viewScope.cid_clearing.afterNext_fadak}"
                                    after_previous="#{viewScope.cid_clearing.afterprevious_fadak}"
                                    showcommit="false" showcreate="false"
                                    showdelete="false" showEditCommand="false"
                                    showquery="false" showrefresh="false"
                                    showrollback="false" showsearch="false"/>

          </af:toolbar>
          </f:facet>
            <af:panelSplitter id="ps1" splitterPosition="120"
                              orientation="vertical">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}" disclosed="true"
                              value="#{bindings.searchbarcodeidQuery.queryDescriptor}"
                              model="#{bindings.searchbarcodeidQuery.queryModel}"
                              queryOperationListener="#{bindings.searchbarcodeidQuery.processQueryOperation}"
                              rows="1" maxColumns="2"
                              queryListener="#{viewScope.cid_clearing.checkPerson}"
                              saveQueryMode="hidden" modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout layout="scroll" id="pgl2">
                    <af:panelFormLayout id="pfl1" rows="8" maxColumns="2"
                                        partialTriggers="qryId1">
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Fname.inputValue}"
                                    label="#{bindings.Fname.hints.label}"
                                    required="#{bindings.Fname.hints.mandatory}"
                                    columns="#{bindings.Fname.hints.displayWidth}"
                                    maximumLength="#{bindings.Fname.hints.precision}"
                                    shortDesc="#{bindings.Fname.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Fname.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                          label="#{bindings.PersType.label}"
                                          required="#{bindings.PersType.hints.mandatory}"
                                          shortDesc="#{bindings.PersType.hints.tooltip}"
                                          id="soc1" readOnly="true">
                        <f:selectItems value="#{bindings.PersType.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                      <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                          label="#{bindings.SecArtId.label}"
                                          required="#{bindings.SecArtId.hints.mandatory}"
                                          shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                          id="soc2" readOnly="true">
                        <f:selectItems value="#{bindings.SecArtId.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.PostText.inputValue}"
                                    label="#{bindings.PostText.hints.label}"
                                    required="#{bindings.PostText.hints.mandatory}"
                                    columns="#{bindings.PostText.hints.displayWidth}"
                                    maximumLength="#{bindings.PostText.hints.precision}"
                                    shortDesc="#{bindings.PostText.hints.tooltip}"
                                    id="it3" readOnly="true"
                                    binding="#{viewScope.cid_clearing.postTextInputText}">
                        <f:validator binding="#{bindings.PostText.validator}"/>
                      </af:inputText>
                      
                      
                      <af:inputText value="#{bindings.LoanNumber_cidClearing.inputValue}"
                                    label="#{bindings.LoanNumber_cidClearing.hints.label}"
                                    required="#{bindings.LoanNumber_cidClearing.hints.mandatory}"
                                    columns="#{bindings.LoanNumber_cidClearing.hints.displayWidth}"
                                    maximumLength="#{bindings.LoanNumber_cidClearing.hints.precision}"
                                    shortDesc="#{bindings.LoanNumber_cidClearing.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.LoanNumber_cidClearing.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.LoanNumber_cidClearing.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.DebitSum.inputValue}"
                                    label="#{bindings.DebitSum.hints.label}"
                                    required="#{bindings.DebitSum.hints.mandatory}"
                                    columns="#{bindings.DebitSum.hints.displayWidth}"
                                    maximumLength="#{bindings.DebitSum.hints.precision}"
                                    shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                    id="it9" readOnly="true">
                        <f:validator binding="#{bindings.DebitSum.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.DebitSum.format}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.MemshipStatus1.inputValue}"
                                          label="#{bindings.MemshipStatus1.label}"
                                          required="#{bindings.MemshipStatus1.hints.mandatory}"
                                          shortDesc="#{bindings.MemshipStatus1.hints.tooltip}"
                                          id="soc3" readOnly="true">
                        <f:selectItems value="#{bindings.MemshipStatus1.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it10" readOnly="true">
                        <f:validator binding="#{bindings.Id.validator}"/>
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
                      <af:inputText value="#{bindings.DeptName.inputValue}"
                                    label="#{bindings.DeptName.hints.label}"
                                    required="#{bindings.DeptName.hints.mandatory}"
                                    columns="#{bindings.DeptName.hints.displayWidth}"
                                    maximumLength="#{bindings.DeptName.hints.precision}"
                                    shortDesc="#{bindings.DeptName.hints.tooltip}"
                                    id="it6" readOnly="true">
                        <f:validator binding="#{bindings.DeptName.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.MjrArtId.inputValue}"
                                          label="#{bindings.MjrArtId.label}"
                                          required="#{bindings.MjrArtId.hints.mandatory}"
                                          shortDesc="#{bindings.MjrArtId.hints.tooltip}"
                                          id="soc4" readOnly="true">
                        <f:selectItems value="#{bindings.MjrArtId.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                      <af:spacer width="30" height="20" id="s2"/>
                      <af:inputText value="#{bindings.IntroductionLetterCount1.inputValue}"
                                    label="#{bindings.IntroductionLetterCount1.hints.label}"
                                    required="#{bindings.IntroductionLetterCount1.hints.mandatory}"
                                    columns="#{bindings.IntroductionLetterCount1.hints.displayWidth}"
                                    maximumLength="#{bindings.IntroductionLetterCount1.hints.precision}"
                                    shortDesc="#{bindings.IntroductionLetterCount1.hints.tooltip}"
                                    id="it7" readOnly="true">
                        <f:validator binding="#{bindings.IntroductionLetterCount1.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.IntroductionLetterCount1.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.DebitNonCashText.inputValue}"
                                    label="#{bindings.DebitNonCashText.hints.label}"
                                    required="#{bindings.DebitNonCashText.hints.mandatory}"
                                    columns="#{bindings.DebitNonCashText.hints.displayWidth}"
                                    maximumLength="#{bindings.DebitNonCashText.hints.precision}"
                                    shortDesc="#{bindings.DebitNonCashText.hints.tooltip}"
                                    id="it11" readOnly="true">
                        <f:validator binding="#{bindings.DebitNonCashText.validator}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    <af:spacer width="10" height="30" id="s1"/>
                    <af:panelFormLayout id="pfl2" rows="1" maxColumns="2">
                      <f:facet name="footer"/>
                      <af:inputText label="#{viewcontrollerBundle.thesis_letter_no}"
                                    id="it8"
                                    disabled="#{viewScope.cid_clearing.enablebtn}"
                                    value="#{viewScope.cid_clearing.thesisLetterNo}"/>
                      <af:commandButton text="#{viewcontrollerBundle.clearing_save}"
                                        id="cb1"
                                        actionListener="#{viewScope.cid_clearing.preSave}"
                                        disabled="#{viewScope.cid_clearing.enablebtn}"
                                        partialTriggers="qryId1">
                        <af:setActionListener from="/reports/rwservlet?utdbuser&destype=cache&report=clearing.rdf&P_BARCODE=#{bindings.Barcode.inputValue}&P_POST_TEXT=#{viewScope.cid_clearing.encodedPostTxt}&labcol=#{sessionUser.labcol}"
                                              to="#{viewScope.cid_clearing.reportPath}"/>
                      </af:commandButton>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup">
        
        <af:group>
          <af:popup id="p1">
            <af:panelWindow id="pw1">
              <af:panelFormLayout id="pfl3" rows="2" maxColumns="1">
                <f:facet name="footer"/>
                <af:outputText value="#{viewScope.cid_clearing.popUpText}"
                               id="ot1"/>
                <af:spacer width="10" height="30" id="s3"/>
                <af:panelGroupLayout id="pgl3" layout="horizontal"
                                     valign="middle" halign="center">
                  
                  
                  <af:commandButton text="#{viewcontrollerBundle.yes}"
                                    id="cb2"
                                    actionListener="#{viewScope.cid_clearing.savebtn}"/>
                  <af:commandButton text="#{viewcontrollerBundle.no}"
                                    id="cb3"
                                    actionListener="#{viewScope.cid_clearing.canclPopupbtn}"/>
                </af:panelGroupLayout>
              </af:panelFormLayout>
            </af:panelWindow>
          </af:popup>
      <af:popup id="reportPop" childCreation="deferred" 
                  contentDelivery="lazyUncached">
                  <af:panelWindow title="انتخاب فرمت گزارش"  modal="true">
                  <af:panelGroupLayout layout="horizontal">
                  <af:goLink shortDesc="RTF"  destination="#{initParam.reportServer}#{viewScope.cid_clearing.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{initParam.reportServer}#{viewScope.cid_clearing.reportPath}&desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                  <af:image source="/icons/htmlcss.png"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.cid_clearing.reportPath}&desformat=html" targetFrame="_blank">
                  <af:image source="/icons/html.png"  />
                  </af:goLink>
                     <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.cid_clearing.reportPath}&desformat=xml" targetFrame="_blank">
                  <af:image source="/icons/xml.png"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.cid_clearing.reportPath}&desformat=delimiteddata" targetFrame="_blank">
                  <af:image source="/icons/csv.png"/>
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