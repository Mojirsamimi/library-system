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
        <af:panelHeader text="درخواست کتاب از مخزن">
            <af:panelSplitter id="ps1" orientation="horizontal"
                              splitterPosition="400">
              <f:facet name="first">
                <af:panelSplitter id="ps3" orientation="vertical"
                                  splitterPosition="190">
                  <f:facet name="first">
                    <af:panelAccordion id="pa1">
                      <af:showDetailItem text="جستجو مخصوص اعضای دارای بارکد" id="sdi1">
                        <af:panelGroupLayout layout="vertical" id="pgl1">
                          <af:panelHeader text=" "
                                          id="ph1">
                            <af:query id="qryId1" headerText=" "
                                      disclosed="true"
                                      value="#{bindings.CertificateNoBarcodeVCQuery.queryDescriptor}"
                                      model="#{bindings.CertificateNoBarcodeVCQuery.queryModel}"
                                      
                                      queryOperationListener="#{bindings.CertificateNoBarcodeVCQuery.processQueryOperation}"
                                      queryListener="#{viewScope.book_request_new.afterSearch_call_initperson_barcode}"
                                      modeChangeVisible="false"
                                      saveQueryMode="hidden"/>
                          </af:panelHeader>
                        </af:panelGroupLayout>
                      </af:showDetailItem>
                      <af:showDetailItem text="جستجو مخصوص اعضا با کارت های جدید" id="sdi2">
                        <af:panelGroupLayout layout="vertical" id="pgl2">
                          <af:panelHeader text=" "
                                          id="ph2">
                            <af:query id="qryId2" headerText=" "
                                      disclosed="true"
                                      value="#{bindings.CertificateNoIDVCQuery.queryDescriptor}"
                                      model="#{bindings.CertificateNoIDVCQuery.queryModel}"
                                      queryOperationListener="#{bindings.CertificateNoIDVCQuery.processQueryOperation}"
                                      queryListener="#{viewScope.book_request_new.afterSearch_call_initperson_newCard}"
                                      saveQueryMode="hidden"
                                      modeChangeVisible="false"/>
                          </af:panelHeader>
                        </af:panelGroupLayout>
                      </af:showDetailItem>
                    </af:panelAccordion>
                    </f:facet>
                  <f:facet name="second">
                    <af:panelBox text="نتیجه جستجو" id="pb1"
                                 showDisclosure="false"   partialTriggers="qryId1 qryId2">
                      <af:panelFormLayout id="pfl1"
                                        
                                          rows="4" maxColumns="2" fieldWidth="100"
                                          labelWidth="90">
                        <af:inputText value="#{bindings.Fname.inputValue}"
                                      label="#{bindings.Fname.hints.label}"
                                      required="#{bindings.Fname.hints.mandatory}"
                                      columns="#{bindings.Fname.hints.displayWidth}"
                                      maximumLength="#{bindings.Fname.hints.precision}"
                                      shortDesc="#{bindings.Fname.hints.tooltip}"
                                      id="it1" readOnly="true">
                          <f:validator binding="#{bindings.Fname.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.Lname.inputValue}"
                                      label="#{bindings.Lname.hints.label}"
                                      required="#{bindings.Lname.hints.mandatory}"
                                      columns="#{bindings.Lname.hints.displayWidth}"
                                      maximumLength="#{bindings.Lname.hints.precision}"
                                      shortDesc="#{bindings.Lname.hints.tooltip}"
                                      id="it2" readOnly="true">
                          <f:validator binding="#{bindings.Lname.validator}"/>
                        </af:inputText>
                        <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                            label="#{bindings.PersCategory.label}"
                                            required="#{bindings.PersCategory.hints.mandatory}"
                                            shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                            id="soc1" readOnly="true">
                          <f:selectItems value="#{bindings.PersCategory.items}"
                                         id="si1"/>
                        </af:selectOneChoice>
                        <af:inputText value="#{bindings.PostText.inputValue}"
                                      label="#{bindings.PostText.hints.label}"
                                      required="#{bindings.PostText.hints.mandatory}"
                                      columns="#{bindings.PostText.hints.displayWidth}"
                                      maximumLength="#{bindings.PostText.hints.precision}"
                                      shortDesc="#{bindings.PostText.hints.tooltip}"
                                      id="it4" readOnly="true">
                          <f:validator binding="#{bindings.PostText.validator}"/>
                        </af:inputText>
                       
                        <af:inputText value="#{bindings.DeptName.inputValue}"
                                      label="#{bindings.DeptName.hints.label}"
                                      required="#{bindings.DeptName.hints.mandatory}"
                                      columns="#{bindings.DeptName.hints.displayWidth}"
                                      maximumLength="#{bindings.DeptName.hints.precision}"
                                      shortDesc="#{bindings.DeptName.hints.tooltip}"
                                      id="it3"  readOnly="true" >
                          <f:validator binding="#{bindings.DeptName.validator}"/>
                        </af:inputText>
                        <af:selectOneChoice value="#{bindings.SecArtId2.inputValue}"
                                            label="#{bindings.SecArtId2.label}"
                                            required="#{bindings.SecArtId2.hints.mandatory}"
                                            shortDesc="#{bindings.SecArtId2.hints.tooltip}"
                                            id="soc3" readOnly="true">
                          <f:selectItems value="#{bindings.SecArtId2.items}"
                                         id="si3"/>
                        </af:selectOneChoice>
                        <af:selectOneChoice value="#{bindings.MemshipStatus.inputValue}"
                                            label="#{bindings.MemshipStatus.label}"
                                            required="#{bindings.MemshipStatus.hints.mandatory}"
                                            shortDesc="#{bindings.MemshipStatus.hints.tooltip}"
                                            id="soc2" readOnly="true">
                          <f:selectItems value="#{bindings.MemshipStatus.items}"
                                         id="si2"/>
                        </af:selectOneChoice>
                        <f:facet name="footer"/>
                      </af:panelFormLayout>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:separator id="s2"/>
                       <af:spacer width="10" height="10"
                                                       id="s3"/>

                      <af:panelFormLayout id="pfl2" maxColumns="2" rows="3"
                                          labelWidth="110">
                        <af:inputText value="#{bindings.LoanRemindCap.inputValue}"
                                      label="#{bindings.LoanRemindCap.hints.label}"
                                      required="#{bindings.LoanRemindCap.hints.mandatory}"
                                      columns="#{bindings.LoanRemindCap.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanRemindCap.hints.precision}"
                                      shortDesc="#{bindings.LoanRemindCap.hints.tooltip}"
                                      id="it5" readOnly="true">
                          <f:validator binding="#{bindings.LoanRemindCap.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.LoanRemindCap.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.LoanAtPlaceRemindCap.inputValue}"
                                      label="#{bindings.LoanAtPlaceRemindCap.hints.label}"
                                      required="#{bindings.LoanAtPlaceRemindCap.hints.mandatory}"
                                      columns="#{bindings.LoanAtPlaceRemindCap.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanAtPlaceRemindCap.hints.precision}"
                                      shortDesc="#{bindings.LoanAtPlaceRemindCap.hints.tooltip}"
                                      id="it6" readOnly="true">
                          <f:validator binding="#{bindings.LoanAtPlaceRemindCap.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.LoanAtPlaceRemindCap.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.DebitNonCashText.inputValue}"
                                      label="#{bindings.DebitNonCashText.hints.label}"
                                      required="#{bindings.DebitNonCashText.hints.mandatory}"
                                      columns="#{bindings.DebitNonCashText.hints.displayWidth}"
                                      maximumLength="#{bindings.DebitNonCashText.hints.precision}"
                                      shortDesc="#{bindings.DebitNonCashText.hints.tooltip}"
                                      id="it7" readOnly="true">
                          <f:validator binding="#{bindings.DebitNonCashText.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.DebitSum.inputValue}"
                                      label="#{bindings.DebitSum.hints.label}"
                                      required="#{bindings.DebitSum.hints.mandatory}"
                                      columns="#{bindings.DebitSum.hints.displayWidth}"
                                      maximumLength="#{bindings.DebitSum.hints.precision}"
                                      shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                      id="it8" readOnly="true">
                          <f:validator binding="#{bindings.DebitSum.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.DebitSum.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.LoanNumber.inputValue}"
                                      label="#{bindings.LoanNumber.hints.label}"
                                      required="#{bindings.LoanNumber.hints.mandatory}"
                                      columns="#{bindings.LoanNumber.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanNumber.hints.precision}"
                                      shortDesc="#{bindings.LoanNumber.hints.tooltip}"
                                      id="it9" readOnly="true">
                          <f:validator binding="#{bindings.LoanNumber.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.LoanNumber.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.StatStDate.inputValue}"
                                      label="#{bindings.StatStDate.hints.label}"
                                      required="#{bindings.StatStDate.hints.mandatory}"
                                      columns="#{bindings.StatStDate.hints.displayWidth}"
                                      maximumLength="#{bindings.StatStDate.hints.precision}"
                                      shortDesc="#{bindings.StatStDate.hints.tooltip}"
                                      id="it10"  readOnly="true">
                          <f:validator binding="#{bindings.StatStDate.validator}"/>
                        </af:inputText>
                        <f:facet name="footer"/>
                      </af:panelFormLayout>
                      <f:facet name="toolbar"/>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb2" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelSplitter id="ps2" orientation="vertical"
                                    splitterPosition="160">
                    <f:facet name="first">
                      <af:panelGroupLayout layout="vertical" id="pgl3">
                        <af:panelHeader text="جستجو کتاب" id="ph3">
                          <af:query id="qryId3" headerText=" "
                                    disclosed="true"
                                    value="#{bindings.SearchCallNoArtIdTitleVCBookRequestQuery.queryDescriptor}"
                                    model="#{bindings.SearchCallNoArtIdTitleVCBookRequestQuery.queryModel}"
                                    queryListener="#{bindings.SearchCallNoArtIdTitleVCBookRequestQuery.processQuery}"
                                    queryOperationListener="#{bindings.SearchCallNoArtIdTitleVCBookRequestQuery.processQueryOperation}"
                                    maxColumns="2" modeChangeVisible="false"
                                    saveQueryMode="hidden"/>
                          <f:facet name="toolbar">
                            <af:toolbar id="t1">
                              <fadak:ToolbarSet iteratorname="VirtualBookVO1Iterator" id="ts1"
                                                showcommit="false"
                                                showcreate="false"
                                                showdelete="false"
                                                showEditCommand="false"
                                                showquery="false"
                                                showrefresh="false"
                                                showrollback="false"/>
                            </af:toolbar>
                          </f:facet>
                        </af:panelHeader>
                      </af:panelGroupLayout>
                    </f:facet>
                    <f:facet name="second">
                      <af:panelBox text="نتیجه جستجو" id="pb4" showDisclosure="false">
                        <af:panelGroupLayout id="pgl5" partialTriggers="qryId3"
                                             halign="center"
                                             layout="scroll">
                          <af:panelFormLayout id="pfl4" rows="2" maxColumns="2"
                                              labelWidth="100">
                            <f:facet name="footer"/>
                            <af:inputText value="#{bindings.ArtId.inputValue}"
                                          label="#{bindings.ArtId.hints.label}"
                                          required="#{bindings.ArtId.hints.mandatory}"
                                          columns="#{bindings.ArtId.hints.displayWidth}"
                                          maximumLength="#{bindings.ArtId.hints.precision}"
                                          shortDesc="#{bindings.ArtId.hints.tooltip}"
                                          id="it13" readOnly="true">
                              <f:validator binding="#{bindings.ArtId.validator}"/>
                              <af:convertNumber groupingUsed="false"
                                                pattern="#{bindings.ArtId.format}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.Title.inputValue}"
                                          label="#{bindings.Title.hints.label}"
                                          required="#{bindings.Title.hints.mandatory}"
                                          columns="#{bindings.Title.hints.displayWidth}"
                                          maximumLength="#{bindings.Title.hints.precision}"
                                          shortDesc="#{bindings.Title.hints.tooltip}"
                                          id="it15" readOnly="true">
                              <f:validator binding="#{bindings.Title.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.CallNo.inputValue}"
                                          label="#{bindings.CallNo.hints.label}"
                                          required="#{bindings.CallNo.hints.mandatory}"
                                          columns="#{bindings.CallNo.hints.displayWidth}"
                                          maximumLength="#{bindings.CallNo.hints.precision}"
                                          shortDesc="#{bindings.CallNo.hints.tooltip}"
                                          id="it14" readOnly="true"
                                          styleClass="AFFieldTextLTRMarker">
                              <f:validator binding="#{bindings.CallNo.validator}"/>
                            </af:inputText>
                          </af:panelFormLayout>
                          <af:table value="#{bindings.VbookProviderVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.VbookProviderVO1.rangeSize}"
                                    emptyText="#{bindings.VbookProviderVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.VbookProviderVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.VbookProviderVO1Query.queryDescriptor}"
                                    queryListener="#{bindings.VbookProviderVO1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.VbookProviderVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.VbookProviderVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t2"
                                    inlineStyle="height:50.0px;"
                                    columnStretching="column:c2">
                                    
                            <af:column 
                                       sortable="true"
                                       headerText="#{bindings.VbookProviderVO1.hints.Role.label}"
                                       id="c1">
                              <af:outputText value="#{row.Role}" id="ot1"/>
                            </af:column>
                            <af:column 
                                        sortable="true"
                                       headerText="#{bindings.VbookProviderVO1.hints.Provider1.label}"
                                       id="c2">
                              <af:outputText value="#{row.Provider1}" id="ot2"/>
                            </af:column>
                          </af:table>
                         
                          <af:panelGroupLayout id="pgl4" layout="vertical">
                            <af:panelFormLayout id="pfl3" rows="1"
                                                maxColumns="2"
                                                labelAlignment="start">
                              <f:facet name="footer"/>
                              <af:inputText value="#{bindings.PubDate.inputValue}"
                                            label="#{bindings.PubDate.hints.label}"
                                            required="#{bindings.PubDate.hints.mandatory}"
                                            columns="#{bindings.PubDate.hints.displayWidth}"
                                            maximumLength="#{bindings.PubDate.hints.precision}"
                                            shortDesc="#{bindings.PubDate.hints.tooltip}"
                                            id="it11" readOnly="true">
                                <f:validator binding="#{bindings.PubDate.validator}"/>
                              </af:inputText>
                              <af:inputText value="#{bindings.Publisher1.inputValue}"
                                            label="#{bindings.Publisher1.hints.label}"
                                            required="#{bindings.Publisher1.hints.mandatory}"
                                            columns="#{bindings.Publisher1.hints.displayWidth}"
                                            maximumLength="#{bindings.Publisher1.hints.precision}"
                                            shortDesc="#{bindings.Publisher1.hints.tooltip}"
                                            id="it12" readOnly="true">
                                <f:validator binding="#{bindings.Publisher1.validator}"/>
                              </af:inputText>
                            </af:panelFormLayout>
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
                                      rowSelection="single" id="t3"
                                      inlineStyle="width:550px; height:100.0px;"
                                      autoHeightRows="5">
                              <af:column id="c8" width="20">
                                
                                <af:selectBooleanRadio autoSubmit="true"
                                text=""
                                                       label=""
                                                       id="sbr1"
                                                       value="#{bindings.SelectNoskhe.inputValue}"
                                                       group="noskhe"
                                                       valueChangeListener="#{viewScope.book_request_new.phBookSelection_changed}"
                                                       binding="#{viewScope.book_request_new.phBook_selection_changed}"/>
                                                     
                              </af:column>
                              <af:column  
                                         headerText="#{bindings.PhysicalBookVO1.hints.VolNo.label}"
                                         id="c5">
                                <af:outputText value="#{row.VolNo}" id="ot5"/>
                              </af:column>
                              <af:column  
                                         
                                         headerText="#{bindings.PhysicalBookVO1.hints.PartNo.label}"
                                         id="c6">
                                <af:outputText value="#{row.PartNo}" id="ot4"/>
                              </af:column>
                              <af:column  
                                         headerText="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.label}"
                                         id="c3">
                               
                                <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                                    label="#{row.bindings.ExistenceStatus.label}"
                                                    required="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.mandatory}"
                                                    shortDesc="#{bindings.PhysicalBookVO1.hints.ExistenceStatus.tooltip}"
                                                    id="soc4" readOnly="true">
                                  <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                                 id="si4"/>
                                </af:selectOneChoice>
                              </af:column>
                              <af:column  
                                         headerText="#{bindings.PhysicalBookVO1.hints.LoanStatus.label}"
                                         id="c4">
                                <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                                    label="#{row.bindings.LoanStatus.label}"
                                                    required="#{bindings.PhysicalBookVO1.hints.LoanStatus.mandatory}"
                                                    shortDesc="#{bindings.PhysicalBookVO1.hints.LoanStatus.tooltip}"
                                                    id="soc6" readOnly="true">
                                  <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                                 id="si6"/>
                                </af:selectOneChoice>
                              </af:column>
                              <af:column  
                                         headerText="#{bindings.PhysicalBookVO1.hints.Place.label}"
                                         id="c7">
                                <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                                    label="#{row.bindings.Place.label}"
                                                    required="#{bindings.PhysicalBookVO1.hints.Place.mandatory}"
                                                    shortDesc="#{bindings.PhysicalBookVO1.hints.Place.tooltip}"
                                                    id="soc5" readOnly="true">
                                  <f:selectItems value="#{row.bindings.Place.items}"
                                                 id="si5"/>
                                </af:selectOneChoice>
                              </af:column>
                            </af:table>
                          </af:panelGroupLayout>
                          <af:panelFormLayout id="pfl6" rows="1" maxColumns="3" labelWidth="120">
                            <af:inputText value="#{bindings.ReqNum.inputValue}"
                                          label="#{bindings.ReqNum.hints.label}"
                                          required="#{bindings.ReqNum.hints.mandatory}"
                                          columns="#{bindings.ReqNum.hints.displayWidth}"
                                          maximumLength="#{bindings.ReqNum.hints.precision}"
                                          shortDesc="#{bindings.ReqNum.hints.tooltip}"
                                          id="it16" readOnly="true"
                                          partialTriggers="cb1">
                              <f:validator binding="#{bindings.ReqNum.validator}"/>
                            </af:inputText>
                            <af:inputText value="#{bindings.ReqTime.inputValue}"
                                          label="#{bindings.ReqTime.hints.label}"
                                          required="#{bindings.ReqTime.hints.mandatory}"
                                          columns="#{bindings.ReqTime.hints.displayWidth}"
                                          maximumLength="#{bindings.ReqTime.hints.precision}"
                                          shortDesc="#{bindings.ReqTime.hints.tooltip}"
                                          id="it17" readOnly="true"
                                          partialTriggers="cb1">
                              <f:validator binding="#{bindings.ReqTime.validator}"/>
                            </af:inputText>
                            <af:selectBooleanCheckbox text=""
                                                      label="امانت در محل"
                                                      id="sbc1"
                                                      value="#{viewScope.book_request_new.loanAtPlace}"/>
                            <f:facet name="footer">
                              <af:panelGroupLayout id="pgl7"
                                                   layout="horizontal"
                                                   halign="left" valign="middle">
                                <af:commandButton partialSubmit="true"
                                                  text="ارسال درخواست" id="cb1"
                                                  actionListener="#{viewScope.book_request_new.call_print_vbook}"/>
                              </af:panelGroupLayout>
                            </f:facet>
                          </af:panelFormLayout>
                        </af:panelGroupLayout>
                        <f:facet name="toolbar">
                          <af:toolbar id="t4"/>
                        </f:facet>
                      </af:panelBox>
                    </f:facet>
                  </af:panelSplitter>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        
        </f:facet>
        <f:facet name="popup">
          <af:popup id="p1">
            <af:panelWindow id="pw1">
              <af:panelFormLayout id="pfl5">
                <af:panelLabelAndMessage label="تعداد کل کتاب درخواست شده"
                                         id="plam1">
                  <af:outputText value="#{bindings.DiReqKol.inputValue}"
                                 id="ot3">
                    <af:convertNumber groupingUsed="false"
                                      pattern="#{bindings.DiReqKol.format}"/>
                  </af:outputText>
                </af:panelLabelAndMessage>
                <af:panelLabelAndMessage label="تعداد کتاب منتظر در صف مخزن"
                                         id="plam2">
                  <af:outputText value="#{bindings.DiRecLoad.inputValue}"
                                 id="ot6">
                    <af:convertNumber groupingUsed="false"
                                      pattern="#{bindings.DiRecLoad.format}"/>
                  </af:outputText>
                </af:panelLabelAndMessage>
                <af:panelLabelAndMessage label="تعداد کتاب منتظر در صف امانت"
                                         id="plam3">
                  <af:outputText value="#{bindings.DiRecLoan.inputValue}"
                                 id="ot7">
                    <af:convertNumber groupingUsed="false"
                                      pattern="#{bindings.DiRecLoan.format}"/>
                  </af:outputText>
                </af:panelLabelAndMessage>
                <f:facet name="footer">
                  <af:panelGroupLayout id="pgl6" layout="horizontal">
                    <af:commandButton text="تایید" id="cb2"
                                      actionListener="#{viewScope.book_request_new.popUpConfirm_btn_insertBookRequest}"/>
                    <af:commandButton text="انصراف" id="cb3"/>
                  </af:panelGroupLayout>
                </f:facet>
              </af:panelFormLayout>
            </af:panelWindow>
          </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>