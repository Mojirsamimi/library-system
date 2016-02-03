<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<jsp:useBean id= "sessionUser" scope= "session"
             class= "org.parsisys.tehranuniversity.library.view.beans.UserStatus"/>
${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
          <af:panelGroupLayout id="pgl2" layout="scroll" valign="middle"
                               halign="center">
            <af:panelHeader text="عضویت" id="ph1"
                            helpTopicId="member">
              <af:panelBox id="pb2" text=" ">
                <af:panelFormLayout partialTriggers="soc5 r1" id="pfl1" maxColumns="3" rows="6"
                                    labelWidth="200"
                                    labelAlignment="start" fieldWidth="200">
                  <af:panelLabelAndMessage  id="plam2" for="it10">
                    <af:inputText value="#{bindings.ArtId.inputValue}"
                                  label="#{bindings.ArtId.hints.label}"
                                  readOnly="true"
                                  required="#{bindings.ArtId.hints.mandatory}"
                                  columns="#{bindings.ArtId.hints.displayWidth}"
                                  maximumLength="#{bindings.ArtId.hints.precision}"
                                  shortDesc="#{bindings.ArtId.hints.tooltip}"
                                  id="it10" visible="false">
                      <f:validator binding="#{bindings.ArtId.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.ArtId.format}"/>
                    </af:inputText>
                  </af:panelLabelAndMessage>
                  <af:inputText value="#{bindings.Barcode.inputValue}"
                                label="#{bindings.Barcode.hints.label}"
                                required="#{bindings.Barcode.hints.mandatory}"
                                columns="#{bindings.Barcode.hints.displayWidth}"
                                maximumLength="14"
                                shortDesc="#{bindings.Barcode.hints.tooltip}"
                                id="it7"
                                readOnly="#{pageFlowScope.cid_member_bean.readonly}">
                    <f:validator binding="#{bindings.Barcode.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.Fname.inputValue}"
                  label="#{bindings.Fname.hints.label}"
                                readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                columns="#{bindings.Fname.hints.displayWidth}"
                                maximumLength="#{bindings.Fname.hints.precision}"
                                shortDesc="#{bindings.Fname.hints.tooltip}"
                                id="it13" simple="false"
                              >
                    <f:validator binding="#{bindings.Fname.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.CertificateNo.inputValue}"
                                label="#{bindings.CertificateNo.hints.label}"
                                required="#{bindings.CertificateNo.hints.mandatory}"
                                columns="#{bindings.CertificateNo.hints.displayWidth}"
                                maximumLength="#{bindings.CertificateNo.hints.precision}"
                                shortDesc="#{bindings.CertificateNo.hints.tooltip}"
                                id="it4" readOnly="#{pageFlowScope.cid_member_bean.readonly}">
                    <f:validator binding="#{bindings.CertificateNo.validator}"/>
                  </af:inputText>
                 
                  <af:selectOneChoice value="#{bindings.CmemsetupArtId.inputValue}"
                                      label="#{bindings.CmemsetupArtId.label}"
                                      required="#{bindings.CmemsetupArtId.hints.mandatory}"
                                      shortDesc="#{bindings.CmemsetupArtId.hints.tooltip}"
                                      id="soc9" readOnly="#{pageFlowScope.cid_member_bean.readonly}" partialTriggers="soc5"
                                      rendered="#{bindings.PersType.attributeValue!='2' || !pageFlowScope.cid_member_bean.readonly}"
                                      disabled="#{bindings.PersType.attributeValue=='2'}">
                                      
                    <f:selectItems value="#{bindings.CmemsetupArtId.items}"
                                   id="si9"/>
                  </af:selectOneChoice>
                 
                  <af:inputText value="#{bindings.PostText.inputValue}"
                                label="#{bindings.PostText.hints.label}"
                                required="#{bindings.PostText.hints.mandatory}"
                                columns="#{bindings.PostText.hints.displayWidth}"
                                maximumLength="#{bindings.PostText.hints.precision}"
                                shortDesc="#{bindings.PostText.hints.tooltip}"
                                id="it6"
                                readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                rendered="#{bindings.PersType.attributeValue=='2' && pageFlowScope.cid_member_bean.readonly}">
                    <f:validator binding="#{bindings.PostText.validator}"/>
                  </af:inputText>
                  
                  <af:inputListOfValues id="affiliationId"
                                        popupTitle="Search and Select: #{bindings.Affiliation.hints.label}"
                                        value="#{bindings.Affiliation.inputValue}"
                                        label="#{bindings.Affiliation.hints.label}"
                                        model="#{bindings.Affiliation.listOfValuesModel}"
                                        required="#{bindings.Affiliation.hints.mandatory}"
                                        readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                        shortDesc="#{bindings.Affiliation.hints.tooltip}"
                        >
                    <f:validator binding="#{bindings.Affiliation.validator}"/>
                  </af:inputListOfValues>
                  

                  <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                      label="#{bindings.PersType.label}"
                                      shortDesc="#{bindings.PersType.hints.tooltip}"
                                      id="soc5"
                                      readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      autoSubmit="true">
                    <f:selectItems value="#{bindings.PersType.items}" id="si4"/>
                  </af:selectOneChoice>
                  <af:inputText value="#{bindings.Lname.inputValue}"
                                label="#{bindings.Lname.hints.label}"
                               readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                columns="30"
                                maximumLength="#{bindings.Lname.hints.precision}"
                                shortDesc="#{bindings.Lname.hints.tooltip}"
                                id="it5">
                    <f:validator binding="#{bindings.Lname.validator}"/>
                  </af:inputText>
                  <af:selectOneChoice value="#{bindings.Origine.inputValue}"
                                      label="#{bindings.Origine.label}"
                                      required="#{bindings.Origine.hints.mandatory}"
                                      shortDesc="#{bindings.Origine.hints.tooltip}"
                                      id="soc7"
                                      readOnly="#{pageFlowScope.cid_member_bean.readonly}">
                    <f:selectItems value="#{bindings.Origine.items}" id="si2"/>
                  </af:selectOneChoice>
                  <af:inputText value="#{bindings.EndDate.inputValue}"
                                label="#{bindings.EndDate.hints.label}"
                                required="#{bindings.EndDate.hints.mandatory}"
                                columns="#{bindings.EndDate.hints.displayWidth}"
                                maximumLength="#{bindings.EndDate.hints.precision}"
                                shortDesc="#{bindings.EndDate.hints.tooltip}"
                               readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                id="it3">
                    <f:validator binding="#{bindings.EndDate.validator}"/>
                  </af:inputText>
               
                                             <af:inputText value="#{bindings.Pers_Offstat_Desc.inputValue}"
                                label="#{bindings.Pers_Offstat_Desc.hints.label}"
                                required="#{bindings.Pers_Offstat_Desc.hints.mandatory}"
                                columns="#{bindings.Pers_Offstat_Desc.hints.displayWidth}"
                                maximumLength="#{bindings.Pers_Offstat_Desc.hints.precision}"
                                shortDesc="#{bindings.Pers_Offstat_Desc.hints.tooltip}"
                               readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                id="it9">
                                 <f:validator binding="#{bindings.Pers_Offstat_Desc.validator}"/>
                  </af:inputText>
                   
                
                  <af:selectOneChoice value="#{bindings.PersStatus.inputValue}"
                                      label="#{bindings.PersStatus.label}"
                                      required="#{bindings.PersStatus.hints.mandatory}"
                                     readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      shortDesc="#{bindings.PersStatus.hints.tooltip}"
                                      id="soc3">
                    <f:selectItems value="#{bindings.PersStatus.items}"
                                   id="si5"/>
                  </af:selectOneChoice>
                  <af:inputText value="#{bindings.Picture1.inputValue}"
                                label="#{bindings.Picture1.hints.label}"
                                required="#{bindings.Picture1.hints.mandatory}"
                                columns="#{bindings.Picture1.hints.displayWidth}"
                                maximumLength="#{bindings.Picture1.hints.precision}"
                                
                                shortDesc="#{bindings.Picture1.hints.tooltip}"
                                id="it1">
                    <f:validator binding="#{bindings.Picture1.validator}"/>
                  </af:inputText>
                  <f:facet name="footer"/>
                </af:panelFormLayout>
                
              </af:panelBox>
              <af:panelBox text="مختص اعضای رسمی" id="pb3">
                <af:panelFormLayout rows="2" maxColumns="3" id="pfl3">
                  <af:inputText value="#{bindings.Id.inputValue}"
                                label="#{bindings.Id.hints.label}"
                                required="#{bindings.Id.hints.mandatory}"
                                columns="#{bindings.Id.hints.displayWidth}"
                                maximumLength="#{bindings.Id.hints.precision}"
                                readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                shortDesc="#{bindings.Id.hints.tooltip}"
                                id="it12">
                    <f:validator binding="#{bindings.Id.validator}"/>
                  </af:inputText>
                  <af:selectOneChoice value="#{bindings.DeptArtId.inputValue}"
                                      label="#{bindings.DeptArtId.label}"
                                      required="#{bindings.DeptArtId.hints.mandatory}"
                                     readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      shortDesc="#{bindings.DeptArtId.hints.tooltip}"
                                      id="soc1"
                                      autoSubmit="true"
                                      valueChangeListener="#{pageFlowScope.cid_member_bean.deptSecDegreeValueChangeListener}"
                                      >
                    <f:selectItems value="#{bindings.DeptArtId.items}"
                                   id="si6"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                      label="#{bindings.PersCategory.label}"
                                      required="#{bindings.PersCategory.hints.mandatory}"
                                     readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                      id="soc6">
                    <f:selectItems value="#{bindings.PersCategory.items}"
                                   id="si3"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                      label="#{bindings.SecArtId.label}"
                                      required="#{bindings.SecArtId.hints.mandatory}"
                                      shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                      id="soc4"
                                      autoSubmit="true"
                                      readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      partialTriggers="soc1"
                                      binding="#{pageFlowScope.cid_member_bean.sectSelectOneChoice}">
                    <f:selectItems value="#{bindings.SecArtId.items}" id="si7"/>
                  </af:selectOneChoice>
                  
                  <af:selectOneChoice value="#{bindings.Degree.inputValue}"
                                      label="#{bindings.Degree.label}"
                                      required="#{bindings.Degree.hints.mandatory}"
                                     readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      shortDesc="#{bindings.Degree.hints.tooltip}"
                                      id="soc2">
                    <f:selectItems value="#{bindings.Degree.items}" id="si1"/>
               
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.MjrArtId1.inputValue}"
                                      label="#{bindings.MjrArtId1.label}"
                                      required="#{bindings.MjrArtId1.hints.mandatory}"
                                    readOnly="#{pageFlowScope.cid_member_bean.readonly}"
                                      shortDesc="#{bindings.MjrArtId1.hints.tooltip}"
                                      id="soc10" 
                                      partialTriggers="soc4"
                                      binding="#{pageFlowScope.cid_member_bean.mjrSelectOneChoice}">
                    <f:selectItems value="#{bindings.MjrArtId1.items}"
                                   id="si10"/>
                  </af:selectOneChoice>
                  
                </af:panelFormLayout>
              </af:panelBox>
              <af:panelBox text=" " id="pb1">
                <af:panelGroupLayout id="pgl1" layout="vertical"
                                     valign="middle" halign="center">
                  <af:panelFormLayout id="pfl2" rows="2" maxColumns="2"
                                      labelAlignment="top" fieldWidth="50"
                                      labelWidth="20">
                    <f:facet name="footer"/>
                    <af:panelHeader text="آدرس" id="ph4">
                      <f:facet name="context"/>
                      <f:facet name="menuBar"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="legend"/>
                      <f:facet name="info"/>
                      <af:panelCollection id="pc1" inlineStyle="width:400.0px;">
                        <af:table value="#{bindings.AddressVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.AddressVO1.rangeSize}"
                                  emptyText="#{bindings.AddressVO1.viewable ? 'رکوردی برای نمایش وجود ندارد' : 'Access Denied.'}"
                                  fetchSize="#{bindings.AddressVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  filterModel="#{bindings.AddressVO1Query.queryDescriptor}"
                                  queryListener="#{bindings.AddressVO1Query.processQuery}"
                                  filterVisible="true" varStatus="vs"
                                  selectedRowKeys="#{bindings.AddressVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.AddressVO1.collectionModel.makeCurrent}"
                                  rowSelection="single" id="t2"
                                  contentDelivery="immediate"
                                  columnStretching="column:c1"
                                  autoHeightRows="2" 
                                  displayRow="selected"
                                  clientComponent="true"
                                  contextMenuSelect="false"
                                  partialTriggers=":::r1">
                          <af:column headerText="#{bindings.AddressVO1.hints.OrderNo.label}"
                                     id="c3" width="20">
                            <af:outputText value="#{row.OrderNo}" id="ot4">
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.AddressVO1.hints.OrderNo.format}"/>
                            </af:outputText>
                          </af:column>
                          <af:column headerText="#{bindings.AddressVO1.hints.Address1.label}"
                                     id="c1">
                            <af:outputText value="#{row.Address1}" id="ot2"/>
                          </af:column>
                          <af:column headerText="#{bindings.AddressVO1.hints.Active.label}"
                                     id="c2">
                            <af:selectBooleanCheckbox value="#{row.bindings.Active.inputValue}"
                                                      label="#{row.bindings.Active.label}"
                                                      readOnly="true"
                                                      shortDesc="#{bindings.AddressVO1.hints.Active.tooltip}"
                                                      id="sbc3"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                    </af:panelHeader>
                    <af:panelHeader text="ایمیل" id="ph3">
                      <f:facet name="context"/>
                      <f:facet name="menuBar"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="legend"/>
                      <f:facet name="info"/>
                      <af:panelCollection id="pc2" inlineStyle="width:400.0px;">
                        <af:table value="#{bindings.EmailVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.EmailVO1.rangeSize}"
                                  emptyText="#{bindings.EmailVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                  fetchSize="#{bindings.EmailVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  filterModel="#{bindings.EmailVO1Query.queryDescriptor}"
                                  queryListener="#{bindings.EmailVO1Query.processQuery}"
                                  filterVisible="true" varStatus="vs"
                                  selectedRowKeys="#{bindings.EmailVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.EmailVO1.collectionModel.makeCurrent}"
                                  autoHeightRows="2"
                                  contentDelivery="immediate"
                                  clientComponent="true"
                                  displayRow="selected"
                                  rowSelection="single" columnStretching="column:c5" id="t3"
                                  contextMenuSelect="false"
                                  partialTriggers=":::r1">
                          <af:column sortProperty="OrderNo" filterable="true"
                                     sortable="true" width="20"
                                     headerText="#{bindings.EmailVO1.hints.OrderNo.label}"
                                     id="c6">
                            <af:outputText value="#{row.OrderNo}" id="ot7">
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.EmailVO1.hints.OrderNo.format}"/>
                            </af:outputText>
                          </af:column>
                          <af:column sortProperty="Email1" filterable="true"
                                     sortable="true"
                                     headerText="#{bindings.EmailVO1.hints.Email1.label}"
                                     id="c5">
                            <af:outputText value="#{row.Email1}" id="ot6"/>
                          </af:column>
                          <af:column headerText="#{bindings.EmailVO1.hints.Active.label}"
                                     id="c4">
                            <af:selectBooleanCheckbox value="#{row.bindings.Active.inputValue}"
                                                      readOnly="true"
                                                      label="#{row.bindings.Active.label}"
                                                      shortDesc="#{bindings.EmailVO1.hints.Active.tooltip}"
                                                      id="sbc2"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                    </af:panelHeader>
                    <af:panelHeader text="تلفن" id="ph2">
                      <f:facet name="context"/>
                      <f:facet name="menuBar"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="legend"/>
                      <f:facet name="info"/>
                      <af:panelCollection id="pc3" inlineStyle="width:400.0px;">
                        <af:table value="#{bindings.TelephoneVO1.collectionModel}"
                                  var="row"
                                  rows="#{bindings.TelephoneVO1.rangeSize}"
                                  emptyText="#{bindings.TelephoneVO1.viewable ? 'رکوردی برای نمایش وجود ندارد' : 'Access Denied.'}"
                                  fetchSize="#{bindings.TelephoneVO1.rangeSize}"
                                  rowBandingInterval="0"
                                  filterModel="#{bindings.TelephoneVO1Query.queryDescriptor}"
                                  queryListener="#{bindings.TelephoneVO1Query.processQuery}"
                                  filterVisible="true" varStatus="vs"
                                  selectedRowKeys="#{bindings.TelephoneVO1.collectionModel.selectedRow}"
                                  selectionListener="#{bindings.TelephoneVO1.collectionModel.makeCurrent}"
                                  rowSelection="single" id="t4"
                                  columnStretching="column:c7"
                                  autoHeightRows="2" displayRow="selected"
                                  contentDelivery="immediate"
                                  partialTriggers=":::r1">
                          <af:column headerText="#{bindings.TelephoneVO1.hints.OrderNo.label}"
                                     id="c8" width="20">
                            <af:outputText value="#{row.OrderNo}" id="ot8">
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.TelephoneVO1.hints.OrderNo.format}"/>
                            </af:outputText>
                          </af:column>
                          <af:column headerText="#{bindings.TelephoneVO1.hints.Telephone1.label}"
                                     id="c7" width="10">
                            <af:outputText value="#{row.Telephone1}" id="ot10"/>
                          </af:column>
                          <af:column headerText="#{bindings.TelephoneVO1.hints.Active.label}"
                                     id="c9">
                            <af:selectBooleanCheckbox value="#{row.bindings.Active.inputValue}"
                                                      label="#{row.bindings.Active.label}"
                                                     readOnly="true"
                                                      shortDesc="#{bindings.TelephoneVO1.hints.Active.tooltip}"
                                                      id="sbc1"/>
                          </af:column>
                        </af:table>
                      </af:panelCollection>
                    </af:panelHeader>
                    <af:panelHeader text="توضیحات" id="ph5">
                      <f:facet name="context"/>
                      <f:facet name="menuBar"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="legend"/>
                      <f:facet name="info"/>
                      <af:inputText value="#{bindings.Description1.inputValue}"
                                    label="#{bindings.Description1.hints.label}"
                                    required="#{bindings.Description1.hints.mandatory}"
                                    columns="#{bindings.Description1.hints.displayWidth}"
                                    maximumLength="#{bindings.Description1.hints.precision}"
                                    shortDesc="#{bindings.Description1.hints.tooltip}"
                                    id="it2"
                                    partialTriggers="r1">
                        <f:validator binding="#{bindings.Description1.validator}"/>
                      </af:inputText>
                    </af:panelHeader>
                  </af:panelFormLayout>
                </af:panelGroupLayout>
                <f:facet name="toolbar"/>
              </af:panelBox>
              <af:panelBox text=" " id="pb4">
                <af:panelGroupLayout id="pgl3" layout="vertical"
                                     valign="middle" halign="center">
                  <af:panelCollection id="pc4" inlineStyle="width:95.0%;">
                    <af:table value="#{bindings.InitMemberVO1.collectionModel}"
                              var="row"
                              rows="#{bindings.InitMemberVO1.rangeSize}"
                              emptyText="#{bindings.InitMemberVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                              fetchSize="#{bindings.InitMemberVO1.rangeSize}"
                              rowBandingInterval="0"
                              filterModel="#{bindings.InitMemberVO1Query.queryDescriptor}"
                              queryListener="#{bindings.InitMemberVO1Query.processQuery}"
                              filterVisible="true" varStatus="vs"
                              selectedRowKeys="#{bindings.InitMemberVO1.collectionModel.selectedRow}"
                              selectionListener="#{bindings.InitMemberVO1.collectionModel.makeCurrent}"
                              rowSelection="single" id="t5" autoHeightRows="6"
                              displayRow="selected" contentDelivery="immediate"
                              columnStretching="column:c17"
                              partialTriggers=":::cb4 :::cb6">
                      <af:column sortProperty="LibName" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.InitMemberVO1.hints.LibName.label}"
                                 id="c17">
                        <af:outputText value="#{row.LibName}" id="ot19"/>
                      </af:column>
                      <af:column sortProperty="LoanedCount" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.InitMemberVO1.hints.LoanedCount.label}"
                                 id="c10">
                        <af:outputText value="#{row.LoanedCount}" id="ot15">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.InitMemberVO1.hints.LoanedCount.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="LoanedInPlaceCount"
                                 filterable="true" sortable="true" headerText="#{bindings.InitMemberVO1.hints.RecalledCount.label}"
                                 id="c19">
                        <af:outputText value="#{row.RecalledCount}" id="ot20">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.InitMemberVO1.hints.RecalledCount.format}"/>
                        </af:outputText>
                      </af:column>
                     
                      <af:column sortProperty="ReservedCount" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.InitMemberVO1.hints.ReservedCount.label}"
                                 id="c15" width="50">
                        <af:outputText value="#{row.ReservedCount}" id="ot17">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.InitMemberVO1.hints.ReservedCount.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="DebitNonCash" filterable="true"
                                 sortable="true" headerText="#{bindings.InitMemberVO1.hints.DebitNonCashText.label}"
                                 id="c12">
                        <af:outputText value="#{row.DebitNonCashText}"
                                       id="ot11"/>
                      </af:column>
                      
                      <af:column sortProperty="DebitSum" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.InitMemberVO1.hints.DebitSum.label}"
                                 id="c14">
                        <af:outputText value="#{row.DebitSum}" id="ot12">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.InitMemberVO1.hints.DebitSum.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="IntroductionLetterCount"
                                 filterable="true" sortable="true"
                                 headerText="#{bindings.InitMemberVO1.hints.IntroductionLetterCount.label}"
                                 id="c11">
                        <af:outputText value="#{row.IntroductionLetterCount}"
                                       id="ot18">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.InitMemberVO1.hints.IntroductionLetterCount.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="MemshipCategory"
                                 filterable="true" sortable="true" headerText="#{bindings.InitMemberVO1.hints.MemshipCategoryText.label}"
                                 id="c16">
                        <af:outputText value="#{row.MemshipCategoryText}"
                                       id="ot14"/>
                      </af:column>
                      <af:column  sortProperty="MemshipStatus" filterable="true"
                                 sortable="true" headerText="#{bindings.InitMemberVO1.hints.MemshipStatus.label}"
                                 id="c18" width="80">
                        <af:selectOneChoice value="#{row.bindings.MemshipStatus.inputValue}"
                                            label="#{row.bindings.MemshipStatus.label}"
                                            required="#{bindings.InitMemberVO1.hints.MemshipStatus.mandatory}"
                                            shortDesc="#{bindings.InitMemberVO1.hints.MemshipStatus.tooltip}"
                                            id="soc8" readOnly="true">
                          <f:selectItems value="#{row.bindings.MemshipStatus.items}"
                                         id="si8"/>
                        </af:selectOneChoice>
                      </af:column>
                     
                    </af:table>
                    <f:facet name="menus"/>
                   
                  </af:panelCollection>
                </af:panelGroupLayout>
                <f:facet name="toolbar"/>
              </af:panelBox>
              <f:facet name="toolbar">
                <af:toolbar id="t1">
                 
                  
                  <af:group id="g1">
                                     <af:commandButton actionListener="#{bindings.Find.execute}"
                                    text="آماده جستجو"
                                    visible="#{pageFlowScope.cid_member_bean.readonly}"
                                    id="cb1">
                    <af:setActionListener from="#{false}"
                                          to="#{pageFlowScope.cid_member_bean.readonly}"/>
                  </af:commandButton>
                  <af:commandButton actionListener="#{bindings.Execute.execute}"
                                    text="جستجو"
                                    visible="#{!pageFlowScope.cid_member_bean.readonly}"
                                    id="cb2">
                                    <af:setActionListener from="#{true}"
                                          to="#{pageFlowScope.cid_member_bean.readonly}"/>
                                    </af:commandButton>
                    <af:commandButton text="ثبت عضویت در کتابخانه" id="cb4"
                                      actionListener="#{pageFlowScope.cid_member_bean.saveInitMemberActionListener}" disabled="#{!pageFlowScope.cid_member_bean.readonly}"/>
                  </af:group>
                                    <af:group id="g2">
                                     <af:commandButton text="ویرایش عضو" id="cb5" action="#{pageFlowScope.cid_member_bean.updateMemberAction}"
                                    disabled="#{!pageFlowScope.cid_member_bean.readonly}"/>
                                    <af:commandButton text="عضو جدید" id="cb3" action="#{pageFlowScope.TFBean.newPerson}"
                                    disabled="#{!pageFlowScope.cid_member_bean.readonly}"/>
                                    </af:group>
                                    
                  <fadak:ToolbarSet debug="true"
                                    iteratorname="PersonVO1Iterator" id="ts1"
                                    disabled_create="true"
                                    disabled_refresh="true" showcreate="false"
                                    showrefresh="false" showdelete="false"/>
                 
                </af:toolbar>
              </f:facet>
            </af:panelHeader>
          </af:panelGroupLayout>
        </f:facet>
        <f:facet name="popup">
        <af:group id="g3">
        <af:popup id="post_popup">
              <af:panelWindow id="pw2" modal="true" title="سمت شخص">
                <af:panelGroupLayout id="pgl5" layout="vertical">
                 <af:outputText value="لطفا سمت شخص را انتخاب نمایید" id="ot3"/>
                 <af:spacer id="s1" height="10"/>
                  <af:panelFormLayout id="pfl4">
                    <af:selectOneChoice value="#{bindings.CmemSetupPost.inputValue}"
                                        label="#{bindings.CmemSetupPost.label}"
                                        required="#{bindings.CmemSetupPost.hints.mandatory}"
                                        shortDesc="#{bindings.CmemSetupPost.hints.tooltip}"
                                        id="soc11" autoSubmit="true">
                      <f:selectItems value="#{bindings.CmemSetupPost.items}"
                                     id="si11"/>
                    </af:selectOneChoice>
                    <af:inputText value="#{bindings.PostEndDate.inputValue}"
                                  label="#{bindings.PostEndDate.hints.label}"
                                  required="#{bindings.PostEndDate.hints.mandatory}"
                                  columns="#{bindings.PostEndDate.hints.displayWidth}"
                                  maximumLength="#{bindings.PostEndDate.hints.precision}"
                                  readOnly="true"
                                  shortDesc="#{bindings.PostEndDate.hints.tooltip}"
                                  id="it8" partialTriggers="soc11">
                      <f:validator binding="#{bindings.PostEndDate.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.PostEndDate.format}"/>
                    </af:inputText>
                    <f:facet name="footer">
                      <af:panelGroupLayout id="pgl4" layout="horizontal">
                        <af:commandButton text="تایید" id="cb6" partialSubmit="true"
                                          actionListener="#{pageFlowScope.cid_member_bean.post_popup_confirm_actionListener}"/>
                        <af:commandButton text="انصراف" id="cb7" partialSubmit="true"
                                          actionListener="#{pageFlowScope.cid_member_bean.post_popup_cancel_actionListener}"/>
                      </af:panelGroupLayout>
                    </f:facet>
                  </af:panelFormLayout>
                </af:panelGroupLayout>
              </af:panelWindow>
            </af:popup>
         <af:popup  id="tf" contentDelivery="lazyUncached"
                binding="#{pageFlowScope.TFBean.region_popup}"
                   animate="default"
                   
                  >
      <af:panelWindow title="#{viewcontrollerBundle.SELECT}"
                       closeIconVisible="false" 
                      modal="true" id="pw1">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigation}"/>
      </af:panelWindow>
      </af:popup>
       
       </af:group>
       </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>