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
        <af:pageTemplate viewId="/template/UTtemplate.jspx"
                         value="#{bindings.pageTemplateBinding}" id="pt1">
            <f:facet name="popup">
      <af:group>
       
     
              <af:popup id="searchphbook">
                <af:panelWindow id="pw1"
                                inlineStyle="height:500px; width:800.0px;"
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
                            <af:panelCollection id="pc2"
                                                styleClass="AFStretchWidth">
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
                                        partialTriggers=":::qryId2"
                                        columnStretching="column:c16">
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
              
              
              <af:popup id="penaltyp">
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
                                  id="it25">
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
                                  id="it26">
                      <f:validator binding="#{bindings.penaltyDescription.validator}"/>
                    </af:inputText>
                    <f:facet name="footer">
                     
                        <af:panelGroupLayout id="pgl8" halign="center"
                                             valign="middle"
                                             layout="horizontal">
                          <af:commandButton partialSubmit="true" text="ثبت" id="cb7"
                                            actionListener="#{viewScope.CID_LOAN.penaltySaveActionListener}"/>
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
              
               <af:popup id="reportPop" childCreation="deferred" 
                  contentDelivery="lazyUncached"
                         >
                  <af:panelWindow title="انتخاب فرمت گزارش"  modal="true"
                                  id="pw4">
                  <af:selectOneRadio label="برگه های خروج"
                                    id="sor1"
                                    autoSubmit="true" layout="horizontal"
                                    value="#{viewScope.CID_LOAN.printCount}"
                                    valueChangeListener="#{viewScope.CID_LOAN.reportCountValueChangeListener}">
                      <af:selectItem label="یک برگ"
                                     value="1" id="si25"/>
                      <af:selectItem label="دو برگ"
                                     value="2" id="si26"/>
                    </af:selectOneRadio>
                  <af:selectOneListbox label="بارکد کتابهای امانت داده شده"
                                       id="sol1"
                                       valueChangeListener="#{viewScope.CID_LOAN.reportListBoxValueChangeListener}"
                                       autoSubmit="true"
                                      
                                       
                                      >
                    <f:selectItems value="#{viewScope.CID_LOAN.reportSelectItms}"
                                   id="si7"/>
                  </af:selectOneListbox>
                  <af:panelGroupLayout layout="horizontal" id="pgl11">
                  <af:goLink shortDesc="RTF"  destination="#{initParam.reportServer}#{viewScope.CID_LOAN.reportPath}&amp;desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{initParam.reportServer}#{viewScope.CID_LOAN.reportPath}&amp;desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;" id="gl1"
                             partialTriggers="sol1 si7 sor1">
                  <af:image source="/icons/htmlcss.png" id="i2"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.CID_LOAN.reportPath}&amp;desformat=html" targetFrame="_blank"
                                id="gl2"  partialTriggers="sol1 si7 sor1">
                  <af:image source="/icons/html.png"  id="i3"/>
                  </af:goLink>
                  
                    <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.CID_LOAN.reportPath}&amp;desformat=xml" targetFrame="_blank"
                                id="gl3"  partialTriggers="sol1 si7 sor1">
                  <af:image source="/icons/xml.png" id="i4"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{viewScope.CID_LOAN.reportPath}&amp;desformat=delimiteddata" targetFrame="_blank"
                             id="gl4"  partialTriggers="sol1 si7 sor1">
                  <af:image source="/icons/csv.png" id="i5"/>
                  </af:goLink>
                  </af:panelGroupLayout>
                </af:panelWindow>
              </af:popup>
            </af:group>
       </f:facet>
          <f:facet name="center">
          <af:panelHeader text="امانت کتاب" helpTopicId="loan">
           <f:facet name="toolbar">
          
          <af:toolbar id="t1">
           <af:group id="g2">
                  
                  
                    <af:commandButton text="ثبت امانت" id="cb1" partialSubmit="true"
                                    actionListener="#{viewScope.CID_LOAN.saveLoanActionListener}"
                                    disabled="#{viewScope.CID_LOAN.disableLoan}"
                                    partialTriggers="qryId1 commandButton3">
                  
                  </af:commandButton>
                    <af:commandButton text="چاپ برگه خروج" id="cb8" partialSubmit="true"
                                   disabled="#{viewScope.CID_LOAN.disablePrint}"
                                   partialTriggers="qryId1 commandButton3 cb1"
                                   action="#{viewScope.CID_LOAN.view_popUp_btn}">
                  
                  </af:commandButton>
                  
                 </af:group>
                 
                  <af:spacer width="20" height="10" id="s2"/>
                  
                  <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    disabled_delete="true"
                                    disabled_create="true" showcreate="false"
                                    showdelete="false" showquery="false"
                                    showcommit="false" showEditCommand="false"
                                    disabled_first="true" disabled_last="true"
                                    disabled_next="true"
                                    disabled_previous="true"
                                    showrefresh="false" showrollback="false"
                                    showsearch="false"/>
                </af:toolbar>
                    </f:facet>
              <af:panelSplitter id="ps1" splitterPosition="120"
                                orientation="vertical">
                <f:facet name="first">
                  <af:panelGroupLayout layout="vertical" id="pgl1">
                    <af:panelHeader text=" " id="ph1">
                      <af:query id="qryId1" headerText="جستجوی عضو" disclosed="true"
                                value="#{bindings.searchbarcodeidQuery.queryDescriptor}"
                                model="#{bindings.searchbarcodeidQuery.queryModel}"
                                queryListener="#{viewScope.CID_LOAN.searchPerson}"
                                queryOperationListener="#{bindings.searchbarcodeidQuery.processQueryOperation}"
                                rows="1" maxColumns="2" saveQueryMode="hidden"
                                modeChangeVisible="false"/>
                    </af:panelHeader>
                  </af:panelGroupLayout>
                </f:facet>
                <f:facet name="second">
                  <af:panelGroupLayout layout="scroll" partialTriggers="qryId1"
                                       xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
                                       id="pgl2" valign="middle"
                                       halign="start">
                    <af:panelBox text="مشخصات عضو" id="pb1">
                      <af:panelGroupLayout id="pgl4" layout="horizontal">
                        <af:panelFormLayout id="pfl2" rows="5" maxColumns="2"
                                        partialTriggers="qryId1"    fieldWidth="200" labelWidth="200">
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
                                       styleClass="AFFieldTextLTRMarker">
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
                                        partialTriggers="qryId1"
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
                                             partialTriggers="qryId1"
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
                                            partialTriggers="::qryId1">
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
                                    partialTriggers=":::cb1">
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
                                       id="c6" partialTriggers="sbc1">
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
                                                        valueChangeListener="#{viewScope.CID_LOAN.extentYesNoValueChangeListener}"
                                                        binding="#{viewScope.CID_LOAN.chkBoxExtentYesNo}"
                                                        disabled="#{viewScope.CID_LOAN.disableLoan}"/>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:panelGroupLayout>
                      <f:facet name="toolbar"/>
                    </af:panelBox>
                    <af:panelBox text="امانت" id="pb4">
                    
                      <af:panelGroupLayout layout="vertical" valign="middle"
                                           halign="center">
                      <af:panelFormLayout id="pfl4" rows="1" maxColumns="3"
                                          fieldWidth="200" >
                          <af:inputText value="#{bindings.LoanRemindCap.inputValue}"
                                        label="#{bindings.LoanRemindCap.hints.label}"
                                        required="#{bindings.LoanRemindCap.hints.mandatory}"
                                        columns="#{bindings.LoanRemindCap.hints.displayWidth}"
                                        maximumLength="#{bindings.LoanRemindCap.hints.precision}"
                                        shortDesc="#{bindings.LoanRemindCap.hints.tooltip}"
                                        id="it16" readOnly="true">
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
                                        id="it11" readOnly="true">
                            <f:validator binding="#{bindings.LoanAtPlaceRemindCap.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.LoanAtPlaceRemindCap.format}"/>
                          </af:inputText>
                        </af:panelFormLayout>
                        <af:panelCollection inlineStyle="width:90%; height:150.0px;">
                          <af:table value="#{bindings.PP_LoanVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.PP_LoanVO1.rangeSize}"
                                    emptyText="#{bindings.PP_LoanVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.PP_LoanVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.PP_LoanVO1Query.queryDescriptor}"
                                    queryListener="#{bindings.PP_LoanVO1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.PP_LoanVO1.collectionModel.selectedRow}"
                                    selectionListener="#{bindings.PP_LoanVO1.collectionModel.makeCurrent}"
                                    rowSelection="single" id="t3"
                                    columnStretching="column:c11"
                                    partialTriggers="::cil1 ::cil2 :::pc2:cb5 :::cb1">
                            
                            <af:column id="c31" headerText="جستجوی کتاب">
                              <af:commandButton text="جستجو"
                                                id="cb2" partialSubmit="true">
                                <af:showPopupBehavior popupId=":::searchphbook"
                                                      triggerType="click"
                                                      align="beforeEnd"/>
                              </af:commandButton>
                            </af:column>
                            
                            <af:column sortProperty="PhBookBarcode"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.PP_LoanVO1.hints.PhBookBarcode.label}"
                                       id="c12" width="150">
                              <af:inputText value="#{row.bindings.PhBookBarcode.inputValue}"
                                            label="#{bindings.PP_LoanVO1.hints.PhBookBarcode.label}"
                                            required="#{bindings.PP_LoanVO1.hints.PhBookBarcode.mandatory}"
                                            columns="#{bindings.PP_LoanVO1.hints.PhBookBarcode.displayWidth}"
                                            maximumLength="#{bindings.PP_LoanVO1.hints.PhBookBarcode.precision}"
                                            shortDesc="#{bindings.PP_LoanVO1.hints.PhBookBarcode.tooltip}"
                                            id="it17"
                                            readOnly="true">
                                <f:validator binding="#{row.bindings.PhBookBarcode.validator}"/>
                              </af:inputText>
                            </af:column>
                            
                            
                            <af:column sortProperty="VbookTitle"
                                       filterable="true" sortable="true"
                                       headerText="#{bindings.PP_LoanVO1.hints.VbookTitle.label}"
                                       id="c11">
                              <af:inputText value="#{row.bindings.VbookTitle.inputValue}"
                                            label="#{bindings.PP_LoanVO1.hints.VbookTitle.label}"
                                            required="#{bindings.PP_LoanVO1.hints.VbookTitle.mandatory}"
                                            columns="#{bindings.PP_LoanVO1.hints.VbookTitle.displayWidth}"
                                            maximumLength="#{bindings.PP_LoanVO1.hints.VbookTitle.precision}"
                                            shortDesc="#{bindings.PP_LoanVO1.hints.VbookTitle.tooltip}"
                                            id="it18"
                                            readOnly="true">
                                <f:validator binding="#{row.bindings.VbookTitle.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="Provider" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.PP_LoanVO1.hints.Provider.label}"
                                       id="c20" width="200">
                              <af:inputText value="#{row.bindings.Provider.inputValue}"
                                            label="#{bindings.PP_LoanVO1.hints.Provider.label}"
                                            required="#{bindings.PP_LoanVO1.hints.Provider.mandatory}"
                                            columns="#{bindings.PP_LoanVO1.hints.Provider.displayWidth}"
                                            maximumLength="#{bindings.PP_LoanVO1.hints.Provider.precision}"
                                            shortDesc="#{bindings.PP_LoanVO1.hints.Provider.tooltip}"
                                            id="it19"
                                            readOnly="true">
                                <f:validator binding="#{row.bindings.Provider.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="RetDate" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.PP_LoanVO1.hints.RetDate.label}"
                                       id="c13" partialTriggers="soc1">
                              <af:inputText value="#{row.bindings.RetDate.inputValue}"
                                            label="#{bindings.PP_LoanVO1.hints.RetDate.label}"
                                            required="#{bindings.PP_LoanVO1.hints.RetDate.mandatory}"
                                            columns="#{bindings.PP_LoanVO1.hints.RetDate.displayWidth}"
                                            maximumLength="#{bindings.PP_LoanVO1.hints.RetDate.precision}"
                                            shortDesc="#{bindings.PP_LoanVO1.hints.RetDate.tooltip}"
                                            id="it20"
                                            readOnly="true">
                                <f:validator binding="#{row.bindings.RetDate.validator}"/>
                              </af:inputText>
                            </af:column>
                            <af:column sortProperty="LoanType" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.PP_LoanVO1.hints.LoanType.label}"
                                       id="c10">
                              <af:selectOneChoice value="#{row.bindings.LoanType.inputValue}"
                                                  label="#{row.bindings.LoanType.label}"
                                                  required="#{bindings.PP_LoanVO1.hints.LoanType.mandatory}"
                                                  shortDesc="#{bindings.PP_LoanVO1.hints.LoanType.tooltip}"
                                                  id="soc1" autoSubmit="true"
                                                  disabled="#{row.bindings.PhBookBarcode.inputValue==null}"
                                                  
                                                  valueChangeListener="#{viewScope.CID_LOAN.loanTypeValueChangeListener}">
                                <f:selectItems value="#{row.bindings.LoanType.items}"
                                               id="si1"/>
                              </af:selectOneChoice>
                            </af:column>
                            <af:column headerText="#{bindings.PP_LoanVO1.hints.YesNo.label}"
                                       id="c9" width="30" minimumWidth="12">
                              <af:selectBooleanCheckbox value="#{row.bindings.YesNo.inputValue}"
                                                        label="#{row.bindings.YesNo.label}"
                                                        shortDesc="#{bindings.PP_LoanVO1.hints.YesNo.tooltip}"
                                                        id="sbc2"
                                                        autoSubmit="true"
                                                        valueChangeListener="#{viewScope.CID_LOAN.loanListYesNoChangeValueListener}"
                                                        binding="#{viewScope.CID_LOAN.chkBoxLoanYesNo}"/>
                            </af:column>
                          </af:table>
                          <f:facet name="toolbar"/>
                          <f:facet name="secondaryToolbar">
                            <af:toolbar id="t5">
                              <af:commandImageLink text="" shortDesc="جدید"
                                                   partialSubmit="true"
                                                   id="cil1"
                                                   icon="/icons/list-add.png"
                                                   actionListener="#{bindings.CreateInsert.execute}"
                                                   disabled="#{bindings.ArtId.inputValue==null or viewScope.CID_LOAN.disableLoan or !bindings.CreateInsert.enabled}"/>
                              <af:commandImageLink text="" shortDesc="حذف"
                                                   id="cil2"
                                                   partialSubmit="true"
                                                   icon="/icons/list-remove.png"
                                                   actionListener="#{bindings.Delete.execute}"
                                                   disabled="#{!bindings.Delete.enabled or viewScope.CID_LOAN.disableLoan}"/>
                            </af:toolbar>
                          </f:facet>
                        </af:panelCollection>
                    </af:panelGroupLayout>
                      
                      
                    </af:panelBox>
                  </af:panelGroupLayout>
                </f:facet>
              </af:panelSplitter>
            </af:panelHeader>
          
          </f:facet>
        </af:pageTemplate>
      </af:form>
    </af:document>
  </f:view>
  <!--oracle-jdev-comment:preferred-managed-bean-name:CidLoan-->
</jsp:root>
