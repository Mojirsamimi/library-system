<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
          xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html"
                                          xmlns:fadak="/fadak"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
          xmlns:c="http://java.sun.com/jsp/jstl/core">
  <c:set var="viewcontrollerBundle"
         value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
  <jsp:directive.page contentType="text/html;charset=UTF-8"/>
 ${sessionUser.authorization} 
  <f:view locale="ar">
    <af:document id="d1">
      <af:messages id="m1"/>
      <af:form id="f1">
        <af:pageTemplate  viewId="/template/PortalUTemplate.jspx"
                         value="#{bindings.pageTemplateBinding}" id="pt1">
            <f:facet name="popup">
      <af:group>
       
     
              <af:popup id="searchphbook">
                <af:panelWindow id="pw1"
                                inlineStyle="height:400px; width:650.0px;"
                                modal="true">
                  <af:panelHeader text="" id="ph3">
                    <f:facet name="context"/>
                    <f:facet name="menuBar"/>
                    <f:facet name="toolbar"/>
                    <f:facet name="legend"/>
                    <f:facet name="info"/>
                    <af:panelGroupLayout id="pgl7" layout="scroll"
                                         valign="middle" halign="center">
                      <af:panelSplitter id="ps2" orientation="vertical"
                                        splitterPosition="125"
                                        inlineStyle="width:95.0%;">
                        <f:facet name="first">
                          <af:panelGroupLayout layout="vertical" id="pgl5">
                            <af:panelHeader text="جستجوی کتاب" id="ph2">
                              <af:query id="qryId2" headerText="جستجو"
                                        disclosed="true"
                                        value="#{bindings.searchbarcoderegIdQuery.queryDescriptor}"
                                        model="#{bindings.searchbarcoderegIdQuery.queryModel}"
                                        queryListener="#{bindings.searchbarcoderegIdQuery.processQuery}"
                                        queryOperationListener="#{bindings.searchbarcoderegIdQuery.processQueryOperation}"
                                        rows="1" maxColumns="2"
                                        saveQueryMode="hidden"
                                        modeChangeVisible="false"/>
                            </af:panelHeader>
                          </af:panelGroupLayout>
                        </f:facet>
                        <f:facet name="second">
                          <af:panelGroupLayout layout="scroll"
                                               xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
                                               id="pgl9">
                            <af:panelCollection id="pc2">
                              <f:facet name="toolbar"/>
                              <af:table value="#{bindings.PhysicalBookVO3.collectionModel}"
                              
                                        var="row"
                                        rows="#{bindings.PhysicalBookVO3.rangeSize}"
                                        emptyText="#{bindings.PhysicalBookVO3.viewable ? 'No data to display.' : 'Access Denied.'}"
                                        fetchSize="#{bindings.PhysicalBookVO3.rangeSize}"
                                        rowBandingInterval="0"
                                        filterModel="#{bindings.searchbarcoderegIdQuery.queryDescriptor}"
                                        queryListener="#{bindings.searchbarcoderegIdQuery.processQuery}"
                                        filterVisible="true" varStatus="vs"
                                        selectedRowKeys="#{bindings.PhysicalBookVO3.collectionModel.selectedRow}"
                                        selectionListener="#{bindings.PhysicalBookVO3.collectionModel.makeCurrent}"
                                        rowSelection="single" id="t4"
                                        partialTriggers=":::qryId2">
                                <af:column sortProperty="Barcode"
                                           filterable="true" sortable="true"
                                           headerText="#{bindings.PhysicalBookVO3.hints.Barcode.label}"
                                           id="c19">
                                  <af:outputText value="#{row.Barcode}"
                                                 id="ot7"/>
                                </af:column>
                                <af:column sortProperty="RegId"
                                           filterable="true" sortable="true"
                                           headerText="#{bindings.PhysicalBookVO3.hints.RegId.label}"
                                           id="c14">
                                  <af:outputText value="#{row.RegId}" id="ot6"/>
                                </af:column>
                                <af:column sortProperty="Title"
                                           filterable="true" sortable="true"
                                           headerText="#{bindings.PhysicalBookVO3.hints.Title.label}"
                                           id="c16">
                                  <af:outputText value="#{row.Title}" id="ot3"/>
                                </af:column>
                                
                                <af:column sortProperty="PubDate"
                                           filterable="true" sortable="true"
                                           headerText="#{bindings.PhysicalBookVO3.hints.PubDate.label}"
                                           id="c18">
                                  <af:outputText value="#{row.PubDate}"
                                                 id="ot8"/>
                                </af:column>
                                <af:column sortProperty="CallNo"
                                           filterable="true" sortable="true"
                                           headerText="#{bindings.PhysicalBookVO3.hints.VirtualBookVO.CallNo.label}"
                                           id="c17">
                                  <af:outputText value="#{row.VirtualBookVO.bindings.CallNo.inputValue}"
                                                 id="ot5"/>
                                </af:column>
                              </af:table>
                              <f:facet name="afterToolbar"/>
                              <f:facet name="secondaryToolbar">
                                <af:toolbar id="t6">
                                  <af:commandButton text="انتخاب" id="cb5" partialSubmit="true"
                                                    actionListener="#{viewScope.CID_LOAN.chooseBookActionListener}"/>
                                </af:toolbar>
                              </f:facet>
                            </af:panelCollection>
                          </af:panelGroupLayout>
                        </f:facet>
                      </af:panelSplitter>
                    </af:panelGroupLayout>
                  </af:panelHeader>
                </af:panelWindow>
              </af:popup>
              <af:popup id="p_confirm_save" contentDelivery="lazyUncached">
                <af:panelWindow id="pw2">
                  <af:panelFormLayout id="pfl5">
                 
               
                    <f:facet name="footer">
                      <af:group id="g1">
                        <af:panelGroupLayout id="pgl6" layout="horizontal"
                                             valign="middle" halign="center">
                          <af:commandButton text="بلی" id="cb3"/>
                          <af:commandButton text="خیر" id="cb4"
                                            actionListener="#{viewScope.CID_LOAN.penaltyCancelActionListener}"/>
                        </af:panelGroupLayout>
                      </af:group>
                    </f:facet>
                    <af:outputText id="ot16"
                                   value="#{viewScope.CID_LOAN.tempTxt}"
                                   />
                  </af:panelFormLayout>
                </af:panelWindow>
              </af:popup>
              
              
              <af:popup id="penaltyp"
                        popupCanceledListener="#{viewScope.CID_LOAN.portalPenaltyPopupCancelListener}">
               <af:panelWindow title="محاسبه جریمه" id="pw3" modal="true"
                               closeIconVisible="false">
               
                  <af:outputText value="این کتاب مبلغ #{bindings.PenaltyOffer.inputValue} تومان جریمه دیرکرد دارد." id="ot15"/>
                  <af:spacer width="10" height="20" id="s3"/>
                  <af:panelFormLayout id="pfl6">
                    <af:panelLabelAndMessage label="مدت زمان تاخیر:" id="plam1">
                    <af:inputText value="#{bindings.DelayDay.inputValue}"
                                  label="#{bindings.DelayDay.hints.label}"
                                  required="#{bindings.DelayDay.hints.mandatory}"
                                  columns="#{bindings.DelayDay.hints.displayWidth}"
                                  maximumLength="#{bindings.DelayDay.hints.precision}"
                                  shortDesc="#{bindings.DelayDay.hints.tooltip}"
                                  id="it22" readOnly="true">
                      <f:validator binding="#{bindings.DelayDay.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.DelayDay.format}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.DelayMonth.inputValue}"
                                  label="#{bindings.DelayMonth.hints.label}"
                                  required="#{bindings.DelayMonth.hints.mandatory}"
                                  columns="#{bindings.DelayMonth.hints.displayWidth}"
                                  maximumLength="#{bindings.DelayMonth.hints.precision}"
                                  shortDesc="#{bindings.DelayMonth.hints.tooltip}"
                                  id="it21" readOnly="true">
                      <f:validator binding="#{bindings.DelayMonth.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.DelayMonth.format}"/>
                    </af:inputText>
                      <af:panelGroupLayout id="pgl10" layout="horizontal">
                        <af:inputText value="#{bindings.HolyWeek.inputValue}"
                                      label="#{bindings.HolyWeek.hints.label}"
                                      required="#{bindings.HolyWeek.hints.mandatory}"
                                      columns="#{bindings.HolyWeek.hints.displayWidth}"
                                      maximumLength="#{bindings.HolyWeek.hints.precision}"
                                      shortDesc="#{bindings.HolyWeek.hints.tooltip}"
                                      id="it23" readOnly="true">
                          <f:validator binding="#{bindings.HolyWeek.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.HolyWeek.format}"/>
                        </af:inputText>
                        <af:outputText value=" معاف از پرداخت جریمه" id="ot4"/>
                      </af:panelGroupLayout>
                    </af:panelLabelAndMessage>
                    <af:spacer width="10" height="20" id="s1"/>
                    <af:inputText value="#{bindings.PenaltyOffer.inputValue}"
                                  label="#{bindings.PenaltyOffer.hints.label}"
                                  required="#{bindings.PenaltyOffer.hints.mandatory}"
                                  columns="#{bindings.PenaltyOffer.hints.displayWidth}"
                                  maximumLength="#{bindings.PenaltyOffer.hints.precision}"
                                  shortDesc="#{bindings.PenaltyOffer.hints.tooltip}"
                                  id="it24" readOnly="true">
                      <f:validator binding="#{bindings.PenaltyOffer.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.PenaltyOffer.format}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.penalty.inputValue}"
                                  label="#{bindings.penalty.hints.label}"
                                  required="#{bindings.penalty.hints.mandatory}"
                                  columns="#{bindings.penalty.hints.displayWidth}"
                                  maximumLength="#{bindings.penalty.hints.precision}"
                                  shortDesc="#{bindings.penalty.hints.tooltip}"
                                  id="it25" visible="false">
                      <f:validator binding="#{bindings.penalty.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.penalty.format}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.penaltyDescription.inputValue}"
                                  label="#{bindings.penaltyDescription.hints.label}"
                                  required="#{bindings.penaltyDescription.hints.mandatory}"
                                  columns="#{bindings.penaltyDescription.hints.displayWidth}"
                                  maximumLength="#{bindings.penaltyDescription.hints.precision}"
                                  shortDesc="#{bindings.penaltyDescription.hints.tooltip}"
                                  id="it26" visible="false">
                      <f:validator binding="#{bindings.penaltyDescription.validator}"/>
                    </af:inputText>
                    <f:facet name="footer">
                     
                        <af:panelGroupLayout id="pgl8" halign="center"
                                             valign="middle"
                                             layout="horizontal">
                          <af:commandButton partialSubmit="true" text="ثبت" id="cb7"
                                            actionListener="#{viewScope.CID_LOAN.portalPenaltySaveActionListener}"/>
                          <af:commandButton text="انصراف" id="cb6"
                                            actionListener="#{viewScope.CID_LOAN.penaltyCancelActionListener}"/>
                        </af:panelGroupLayout>
                      
                    </f:facet>
                  </af:panelFormLayout>
                </af:panelWindow>
              </af:popup>
              <af:popup id="popup_study_at_lib">
                <af:panelWindow id="panelWindow1">
                  <af:panelFormLayout id="panelFormLayout1">
                    <f:facet name="footer">
                      <af:group id="group1">
                        <af:panelGroupLayout id="panelGroupLayout1"
                                             layout="horizontal" valign="middle"
                                             halign="center">
                          <af:commandButton text="بلی" id="commandButton1"
                                            actionListener="#{viewScope.CID_LOAN.studyAtLibYesActionListener}"/>
                          <af:commandButton text="خیر" id="commandButton2"
                                            actionListener="#{viewScope.CID_LOAN.studyAtLibNoActionListener}"/>
                        </af:panelGroupLayout>
                      </af:group>
                    </f:facet>
                    <af:outputText id="outputText1"
                                   value="#{viewScope.CID_LOAN.tempTxt}"/>
                  </af:panelFormLayout>
                </af:panelWindow>
              </af:popup>
              <af:popup id="popup_mem_pass_course">
                <af:panelWindow id="panelWindow2">
                  <af:panelFormLayout id="panelFormLayout2">
                    <f:facet name="footer">
                      <af:group id="group2">
                        <af:panelGroupLayout id="panelGroupLayout2"
                                             layout="horizontal" valign="middle"
                                             halign="center">
                          <af:commandButton text="بلی" id="commandButton3"
                                            actionListener="#{viewScope.CID_LOAN.memPassCourseYesActionListener}"/>
                          <af:commandButton text="خیر" id="commandButton4"
                                            actionListener="#{viewScope.CID_LOAN.memPassCourseNoActionListener}"/>
                        </af:panelGroupLayout>
                      </af:group>
                    </f:facet>
                    <af:outputText id="outputText2"
                                   value="#{viewScope.CID_LOAN.tempTxt}"/>
                  </af:panelFormLayout>
                </af:panelWindow>
              </af:popup>
            </af:group>
       </f:facet>
          <f:facet name="center">
          <af:panelHeader text="امانت کتاب" id="ph1">
           <f:facet name="toolbar"/>
              
                  <af:panelGroupLayout layout="scroll" 
                                       xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
                                       id="pgl2" valign="middle"
                                       halign="start">
                    <af:panelBox text="مشخصات عضو" id="pb1">
                      <af:panelGroupLayout id="pgl4" layout="horizontal">
                        <af:panelFormLayout id="pfl2" rows="5" maxColumns="2"
                                            fieldWidth="200" labelWidth="200">
                          <af:inputText value="#{bindings.Barcode.inputValue}"
                                        label="#{bindings.Barcode.hints.label}"
                                        required="#{bindings.Barcode.hints.mandatory}"
                                        columns="#{bindings.Barcode.hints.displayWidth}"
                                        maximumLength="#{bindings.Barcode.hints.precision}"
                                        shortDesc="#{bindings.Barcode.hints.tooltip}"
                                        id="it2" readOnly="true" >
                            <f:validator binding="#{bindings.Barcode.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.Fname.inputValue}"
                                        label="#{bindings.Fname.hints.label}"
                                        required="#{bindings.Fname.hints.mandatory}"
                                        columns="#{bindings.Fname.hints.displayWidth}"
                                        maximumLength="#{bindings.Fname.hints.precision}"
                                        shortDesc="#{bindings.Fname.hints.tooltip}"
                                        id="it3" readOnly="true" >
                            <f:validator binding="#{bindings.Fname.validator}"/>
                          </af:inputText>
                          <af:selectOneChoice value="#{bindings.PersType1.inputValue}"
                                              label="#{bindings.PersType1.label}"
                                              required="#{bindings.PersType1.hints.mandatory}"
                                              shortDesc="#{bindings.PersType1.hints.tooltip}"
                                              id="soc3" readOnly="true"
                                             >
                            <f:selectItems value="#{bindings.PersType1.items}"
                                           id="si3"/>
                          </af:selectOneChoice>
                          <af:selectOneChoice value="#{bindings.PersStatus1.inputValue}"
                                              label="#{bindings.PersStatus1.label}"
                                              required="#{bindings.PersStatus1.hints.mandatory}"
                                              shortDesc="#{bindings.PersStatus1.hints.tooltip}"
                                              id="soc5" readOnly="true"
                                       >
                            <f:selectItems value="#{bindings.PersStatus1.items}"
                                           id="si5"/>
                          </af:selectOneChoice>
                          <af:inputText value="#{bindings.DeptName.inputValue}"
                                        label="#{bindings.DeptName.hints.label}"
                                        required="#{bindings.DeptName.hints.mandatory}"
                                        columns="#{bindings.DeptName.hints.displayWidth}"
                                        maximumLength="#{bindings.DeptName.hints.precision}"
                                        shortDesc="#{bindings.DeptName.hints.tooltip}"
                                        id="it4" readOnly="true">
                                       
                            <f:validator binding="#{bindings.DeptName.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.Id.inputValue}"
                                        label="#{bindings.Id.hints.label}"
                                        required="#{bindings.Id.hints.mandatory}"
                                        columns="#{bindings.Id.hints.displayWidth}"
                                        maximumLength="#{bindings.Id.hints.precision}"
                                        shortDesc="#{bindings.Id.hints.tooltip}"
                                        id="it6" readOnly="true"
                                       >
                            <f:validator binding="#{bindings.Id.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.Lname.inputValue}"
                                        label="#{bindings.Lname.hints.label}"
                                        required="#{bindings.Lname.hints.mandatory}"
                                        columns="#{bindings.Lname.hints.displayWidth}"
                                        maximumLength="#{bindings.Lname.hints.precision}"
                                        shortDesc="#{bindings.Lname.hints.tooltip}"
                                        id="it7" readOnly="true"
                                       >
                            <f:validator binding="#{bindings.Lname.validator}"/>
                          </af:inputText>
                          <af:inputText value="#{bindings.PostText.inputValue}"
                                        label="#{bindings.PostText.hints.label}"
                                        required="#{bindings.PostText.hints.mandatory}"
                                        columns="#{bindings.PostText.hints.displayWidth}"
                                        maximumLength="#{bindings.PostText.hints.precision}"
                                        shortDesc="#{bindings.PostText.hints.tooltip}"
                                        id="it8" readOnly="true"
                                       >
                            <f:validator binding="#{bindings.PostText.validator}"/>
                          </af:inputText>
                          <af:selectOneChoice value="#{bindings.PersCategory1.inputValue}"
                                              label="#{bindings.PersCategory1.label}"
                                              required="#{bindings.PersCategory1.hints.mandatory}"
                                             readOnly="true"
                                              shortDesc="#{bindings.PersCategory1.hints.tooltip}"
                                              id="soc2" >
                            <f:selectItems value="#{bindings.PersCategory1.items}"
                                           id="si2"/>
                          </af:selectOneChoice>
                          <af:selectOneChoice value="#{bindings.SecArtId1.inputValue}"
                                              label="#{bindings.SecArtId1.label}"
                                              required="#{bindings.SecArtId1.hints.mandatory}"
                                              shortDesc="#{bindings.SecArtId1.hints.tooltip}"
                                              id="soc4" readOnly="true"
                                      >
                            <f:selectItems value="#{bindings.SecArtId1.items}"
                                           id="si4"/>
                          </af:selectOneChoice>
                        </af:panelFormLayout>
                        
                          <af:image id="i1" source="#{bindings.Picture1.inputValue}"/>
                       
                      </af:panelGroupLayout>
                    </af:panelBox>
                    <af:panelBox text="وضعیت عضو" id="pb2">
                       <af:panelFormLayout id="pfl1" rows="2" maxColumns="3"
                                      
                                           fieldWidth="150"
                                           labelWidth="100">
                        <af:inputText value="#{bindings.MemshipCategoryText.inputValue}"
                                      label="#{bindings.MemshipCategoryText.hints.label}"
                                      required="#{bindings.MemshipCategoryText.hints.mandatory}"
                                      columns="#{bindings.MemshipCategoryText.hints.displayWidth}"
                                      maximumLength="#{bindings.MemshipCategoryText.hints.precision}"
                                      shortDesc="#{bindings.MemshipCategoryText.hints.tooltip}"
                                      id="it5" readOnly="true"
                                       >
                          <f:validator binding="#{bindings.MemshipCategoryText.validator}"/>
                        </af:inputText>
                        <af:selectOneChoice value="#{bindings.MemshipStatus1.inputValue}"
                                            label="#{bindings.MemshipStatus1.label}"
                                            required="#{bindings.MemshipStatus1.hints.mandatory}"
                                            shortDesc="#{bindings.MemshipStatus1.hints.tooltip}"
                                            id="soc6" readOnly="true"
                                       >
                          <f:selectItems value="#{bindings.MemshipStatus1.items}"
                                         id="si6"/>
                        </af:selectOneChoice>
                        <af:inputText value="#{bindings.StartDate.inputValue}"
                                      label="#{bindings.StartDate.hints.label}"
                                      required="#{bindings.StartDate.hints.mandatory}"
                                      columns="#{bindings.StartDate.hints.displayWidth}"
                                      maximumLength="#{bindings.StartDate.hints.precision}"
                                      shortDesc="#{bindings.StartDate.hints.tooltip}"
                                      id="it9" readOnly="true"
                                     >
                          <f:validator binding="#{bindings.StartDate.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.StatStDate.inputValue}"
                                      label="#{bindings.StatStDate.hints.label}"
                                      required="#{bindings.StatStDate.hints.mandatory}"
                                      columns="#{bindings.StatStDate.hints.displayWidth}"
                                      maximumLength="#{bindings.StatStDate.hints.precision}"
                                      shortDesc="#{bindings.StatStDate.hints.tooltip}"
                                      id="it10" readOnly="true"
                                       >
                          <f:validator binding="#{bindings.StatStDate.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.EndDate.inputValue}"
                                      label="#{bindings.EndDate.hints.label}"
                                      required="#{bindings.EndDate.hints.mandatory}"
                                      columns="#{bindings.EndDate.hints.displayWidth}"
                                      maximumLength="#{bindings.EndDate.hints.precision}"
                                      shortDesc="#{bindings.EndDate.hints.tooltip}"
                                      id="it12" readOnly="true"
                                       >
                          <f:validator binding="#{bindings.EndDate.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.StatEndDate.inputValue}"
                                      label="#{bindings.StatEndDate.hints.label}"
                                      required="#{bindings.StatEndDate.hints.mandatory}"
                                      columns="#{bindings.StatEndDate.hints.displayWidth}"
                                      maximumLength="#{bindings.StatEndDate.hints.precision}"
                                      shortDesc="#{bindings.StatEndDate.hints.tooltip}"
                                      id="it13" readOnly="true"
                                        >
                          <f:validator binding="#{bindings.StatEndDate.validator}"/>
                        </af:inputText>
                       
                   
                      
                      </af:panelFormLayout>
                      
                      <f:facet name="toolbar"/>
                    </af:panelBox>
                    <af:panelBox text="تمدید امانت" id="pb3">
                      <af:panelGroupLayout id="pgl3" layout="vertical"
                                           valign="middle" halign="center">
                      
                        <af:panelFormLayout id="pfl3" rows="1" maxColumns="3"
                                          fieldWidth="150"
                                            
                                             labelWidth="100">
                        <af:inputText value="#{bindings.LoanNumber.inputValue}"
                                      label="#{bindings.LoanNumber.hints.label}"
                                      required="#{bindings.LoanNumber.hints.mandatory}"
                                      columns="#{bindings.LoanNumber.hints.displayWidth}"
                                      maximumLength="#{bindings.LoanNumber.hints.precision}"
                                    readOnly="true"
                                      shortDesc="#{bindings.LoanNumber.hints.tooltip}"
                                      id="it1">
                          <f:validator binding="#{bindings.LoanNumber.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.LoanNumber.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.DebitSum.inputValue}"
                                      label="#{bindings.DebitSum.hints.label}"
                                      required="#{bindings.DebitSum.hints.mandatory}"
                                     readOnly="true"
                                      columns="#{bindings.DebitSum.hints.displayWidth}"
                                      maximumLength="#{bindings.DebitSum.hints.precision}"
                                      shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                      id="it15">
                          <f:validator binding="#{bindings.DebitSum.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.DebitSum.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.DebitNonCashText.inputValue}"
                                      label="#{bindings.DebitNonCashText.hints.label}"
                                      required="#{bindings.DebitNonCashText.hints.mandatory}"
                                      columns="#{bindings.DebitNonCashText.hints.displayWidth}"
                                      maximumLength="#{bindings.DebitNonCashText.hints.precision}"
                                      shortDesc="#{bindings.DebitNonCashText.hints.tooltip}"
                                      id="it14" readOnly="true"
                                      >
                          <f:validator binding="#{bindings.DebitNonCashText.validator}"/>
                        </af:inputText>
                        
                      </af:panelFormLayout>
                        <af:panelCollection id="pc1"
                                            inlineStyle="width:90%; height:150.0px;"
                                          >
                          <af:table value="#{bindings.LoanVO_extend_list.collectionModel}"
                                    
                                    var="row"
                                    rows="#{bindings.LoanVO_extend_list.rangeSize}"
                                    emptyText="#{bindings.LoanVO_extend_list.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.LoanVO_extend_list.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.LoanVO_extend_listQuery.queryDescriptor}"
                                    queryListener="#{bindings.LoanVO_extend_listQuery.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.LoanVO_extend_list.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.LoanVO_extend_list.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t2"
                                    columnStretching="column:c3"
                                    partialTriggers="::cb2">
                            <af:column sortProperty="Barcode" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.Barcode.label}"
                                       id="c1" width="150">
                              <af:outputText value="#{row.Barcode}" id="ot2"/>
                            </af:column>
                            <af:column sortProperty="Title" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.Title.label}"
                                       id="c3">
                              <af:outputText value="#{row.Title}" id="ot12"/>
                            </af:column>
                            <af:column sortProperty="ExtendCnt"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.ExtendCnt.label}"
                                       id="c5">
                              <af:outputText value="#{row.ExtendCnt}" id="ot13">
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.LoanVO_extend_list.hints.ExtendCnt.format}"/>
                              </af:outputText>
                            </af:column>
                            <af:column sortProperty="LoanDate" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.LoanDate.label}"
                                       id="c2">
                              <af:outputText value="#{row.LoanDate}" id="ot11">
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.LoanVO_extend_list.hints.LoanDate.format}"/>
                              </af:outputText>
                            </af:column>
                            <af:column sortProperty="RetDate" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.RetDate.label}"
                                       id="c4">
                              <af:outputText value="#{row.RetDate}" id="ot10">
                                <af:convertNumber groupingUsed="false"
                                                  pattern="#{bindings.LoanVO_extend_list.hints.RetDate.format}"/>
                              </af:outputText>
                            </af:column>
                            <af:column sortProperty="nextRetDate" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.nextRetDate.label}"
                                       id="c6">
                              <af:outputText value="#{row.nextRetDate}"
                                             id="ot1" partialTriggers="sbc1"/>
                            </af:column>
                            <af:column sortProperty="LoanType" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.LoanVO_extend_list.hints.LoanTypeText.label}"
                                       id="c7">
                              <af:outputText value="#{row.LoanTypeText}"
                                             id="ot9"/>
                            </af:column>
                            <af:column headerText="#{bindings.LoanVO_extend_list.hints.YesOrNo.label}"
                                       id="c8" width="30">
                              <af:selectBooleanCheckbox value="#{row.bindings.YesOrNo.inputValue}"
                                                        label="#{row.bindings.YesOrNo.label}"
                                                        shortDesc="#{bindings.LoanVO_extend_list.hints.YesOrNo.tooltip}"
                                                        
                                                        id="sbc1"
                                                        autoSubmit="true"
                                                        
                                                        binding="#{viewScope.CID_LOAN.chkBoxExtentYesNo}"
                                                        disabled="#{viewScope.CID_LOAN.disableLoan}"
                                                        valueChangeListener="#{viewScope.CID_LOAN.extentYesNoValueChangeListener}"/>
                            </af:column>
                       
                      </af:table>
                      <f:facet name="statusbar">
                        <af:toolbar id="t1">
                          <af:commandButton text="بررسی تمدید امانت" id="cb1"
                                            actionListener="#{viewScope.CID_LOAN.checkLoanActionListener}"
                                            />
                          <af:commandButton text="تمدید" id="cb2" disabled="#{viewScope.CID_LOAN.disableLoan}"
                                            actionListener="#{viewScope.CID_LOAN.saveLoanActionListener}"/>
                        </af:toolbar>
                      </f:facet>
                    </af:panelCollection>
                      </af:panelGroupLayout>
                      <f:facet name="toolbar"/>
                    </af:panelBox>
                  </af:panelGroupLayout>
               
            </af:panelHeader>
          
          </f:facet>
        </af:pageTemplate>
      </af:form>
    </af:document>
  </f:view>
  <!--oracle-jdev-comment:preferred-managed-bean-name:CidLoan-->
</jsp:root>
