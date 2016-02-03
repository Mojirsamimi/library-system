<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1" >
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        
         <af:panelHeader text="صندوق" helpTopicId="sandoogh">
             <f:facet name="toolbar">

          <af:toolbar id="t1">
                           <fadak:ToolbarSet iteratorname="PersonVO1Iterator" id="ts2"
                                             showcreate="false"
                                             showcommit="false"
                                             showdelete="false"
                                             showEditCommand="false"
                                             showquery="false"
                                             showrollback="false"
                                             showsearch="false"
                                             showrefresh="false"/>
                <af:commandButton text="لیست" id="cb1" partialSubmit="true"
                                  actionListener="#{pageFlowScope.sandoogh_cashierList.showListActionListener}">
                  <af:showPopupBehavior popupId="p1" triggerType="click"
                                        align="afterEnd"/>
                </af:commandButton>
              </af:toolbar>
         </f:facet>
         
          <af:panelSplitter id="ps1" splitterPosition="130"
                                  orientation="vertical">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl1">
                      <af:panelHeader text=" " id="ph1">
                        <af:query id="qryId1" headerText="جستجوی عضو"
                                  disclosed="true"
                                  value="#{bindings.searchbarcodeidQuery.queryDescriptor}"
                                  model="#{bindings.searchbarcodeidQuery.queryModel}"
                                  
                                  queryOperationListener="#{bindings.searchbarcodeidQuery.processQueryOperation}"
                                  queryListener="#{pageFlowScope.sandoogh_cashierList.postSearch_initPerson}"
                                  rows="1" maxColumns="2"
                                  saveQueryMode="hidden"
                                  modeChangeVisible="false"/>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                <af:panelGroupLayout id="pgl2" layout="scroll" valign="middle"
                                     halign="start"
                                     partialTriggers="qryId1 cb1">
                  <af:panelBox text=" " id="pb1" showDisclosure="false">
                    <f:facet name="toolbar"/>
                    <af:panelFormLayout id="pfl1" rows="3" maxColumns="3">
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
                      </af:inputText  readOnly="true">
                      <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                          label="#{bindings.PersType.label}"
                                          required="#{bindings.PersType.hints.mandatory}"
                                          shortDesc="#{bindings.PersType.hints.tooltip}"
                                          id="soc1" readOnly="true">
                        <f:selectItems value="#{bindings.PersType.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                      <af:selectOneChoice value="#{bindings.PersStatus.inputValue}"
                                          label="#{bindings.PersStatus.label}"
                                          required="#{bindings.PersStatus.hints.mandatory}"
                                          shortDesc="#{bindings.PersStatus.hints.tooltip}"
                                          id="soc2" readOnly="true">
                        <f:selectItems value="#{bindings.PersStatus.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it4" readOnly="true">
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
                      <af:inputText value="#{bindings.PostText.inputValue}"
                                    label="#{bindings.PostText.hints.label}"
                                    required="#{bindings.PostText.hints.mandatory}"
                                    columns="#{bindings.PostText.hints.displayWidth}"
                                    maximumLength="#{bindings.PostText.hints.precision}"
                                    shortDesc="#{bindings.PostText.hints.tooltip}"
                                    id="it6" readOnly="true">
                        <f:validator binding="#{bindings.PostText.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                          label="#{bindings.PersCategory.label}"
                                          required="#{bindings.PersCategory.hints.mandatory}"
                                          shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                          id="soc3" readOnly="true">
                        <f:selectItems value="#{bindings.PersCategory.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.DeptName.inputValue}"
                                    label="#{bindings.DeptName.hints.label}"
                                    required="#{bindings.DeptName.hints.mandatory}"
                                    columns="#{bindings.DeptName.hints.displayWidth}"
                                    maximumLength="#{bindings.DeptName.hints.precision}"
                                    shortDesc="#{bindings.DeptName.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.DeptName.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                          label="#{bindings.SecArtId.label}"
                                          required="#{bindings.SecArtId.hints.mandatory}"
                                          shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                          id="soc4" readOnly="true">
                        <f:selectItems value="#{bindings.SecArtId.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                    </af:panelFormLayout>
                  </af:panelBox>
                  <af:panelBox text=" " id="pb2" showDisclosure="false"   partialTriggers="qryId1">
                    <af:panelFormLayout id="pfl2" rows="2" maxColumns="3"
                                        labelWidth="120" fieldWidth="200">
                      <af:inputText value="#{bindings.MemshipCategoryText.inputValue}"
                                    label="#{bindings.MemshipCategoryText.hints.label}"
                                    required="#{bindings.MemshipCategoryText.hints.mandatory}"
                                    columns="#{bindings.MemshipCategoryText.hints.displayWidth}"
                                    maximumLength="#{bindings.MemshipCategoryText.hints.precision}"
                                    shortDesc="#{bindings.MemshipCategoryText.hints.tooltip}"
                                    id="it7" readOnly="true">
                        <f:validator binding="#{bindings.MemshipCategoryText.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.MemshipStatus.inputValue}"
                                          label="#{bindings.MemshipStatus.label}"
                                          required="#{bindings.MemshipStatus.hints.mandatory}"
                                          shortDesc="#{bindings.MemshipStatus.hints.tooltip}"
                                          id="soc5" readOnly="true">
                        <f:selectItems value="#{bindings.MemshipStatus.items}"
                                       id="si5"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.StartDate.inputValue}"
                                    label="#{bindings.StartDate.hints.label}"
                                    required="#{bindings.StartDate.hints.mandatory}"
                                    columns="#{bindings.StartDate.hints.displayWidth}"
                                    maximumLength="#{bindings.StartDate.hints.precision}"
                                    shortDesc="#{bindings.StartDate.hints.tooltip}"
                                    id="it8" readOnly="true">
                        <f:validator binding="#{bindings.StartDate.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.StatStDate.inputValue}"
                                    label="#{bindings.StatStDate.hints.label}"
                                    required="#{bindings.StatStDate.hints.mandatory}"
                                    columns="#{bindings.StatStDate.hints.displayWidth}"
                                    maximumLength="#{bindings.StatStDate.hints.precision}"
                                    shortDesc="#{bindings.StatStDate.hints.tooltip}"
                                    id="it9" readOnly="true">
                        <f:validator binding="#{bindings.StatStDate.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.EndDate.inputValue}"
                                    label="#{bindings.EndDate.hints.label}"
                                    required="#{bindings.EndDate.hints.mandatory}"
                                    columns="#{bindings.EndDate.hints.displayWidth}"
                                    maximumLength="#{bindings.EndDate.hints.precision}"
                                    shortDesc="#{bindings.EndDate.hints.tooltip}"
                                    id="it10" readOnly="true">
                        <f:validator binding="#{bindings.EndDate.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.StatEndDate.inputValue}"
                                    label="#{bindings.StatEndDate.hints.label}"
                                    required="#{bindings.StatEndDate.hints.mandatory}"
                                    columns="#{bindings.StatEndDate.hints.displayWidth}"
                                    maximumLength="#{bindings.StatEndDate.hints.precision}"
                                    shortDesc="#{bindings.StatEndDate.hints.tooltip}"
                                    id="it11" readOnly="true">
                        <f:validator binding="#{bindings.StatEndDate.validator}"/>
                      </af:inputText>
                      
                      
                      
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                    <f:facet name="toolbar"/>
                  </af:panelBox>
                  <af:panelBox text=" " id="pb3" showDisclosure="false"  partialTriggers="qryId1">
                    <f:facet name="toolbar"/>
                    <af:panelFormLayout id="pfl3" rows="3" maxColumns="3"
                                        labelWidth="120" fieldWidth="200">
                      <af:inputText value="#{bindings.ReceiptTime.inputValue}"
                                    label="#{bindings.ReceiptTime.hints.label}"
                                    required="#{bindings.ReceiptTime.hints.mandatory}"
                                    columns="#{bindings.ReceiptTime.hints.displayWidth}"
                                    maximumLength="#{bindings.ReceiptTime.hints.precision}"
                                    shortDesc="#{bindings.ReceiptTime.hints.tooltip}"
                                    readOnly="true"
                                    id="it12">
                        <f:validator binding="#{bindings.ReceiptTime.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ReturnTime.inputValue}"
                                    label="#{bindings.ReturnTime.hints.label}"
                                    required="#{bindings.ReturnTime.hints.mandatory}"
                                    columns="#{bindings.ReturnTime.hints.displayWidth}"
                                    readOnly="true" partialTriggers="cb5"
                                    maximumLength="#{bindings.ReturnTime.hints.precision}"
                                    shortDesc="#{bindings.ReturnTime.hints.tooltip}"
                                    id="it13">
                        <f:validator binding="#{bindings.ReturnTime.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.KeyNumber.inputValue}"
                                    label="#{bindings.KeyNumber.hints.label}"
                                    required="#{bindings.KeyNumber.hints.mandatory}"
                                    columns="#{bindings.KeyNumber.hints.displayWidth}"
                                    maximumLength="#{bindings.KeyNumber.hints.precision}"
                                    readOnly="#{!pageFlowScope.sandoogh_cashierList.disableExit}"
                                    shortDesc="#{bindings.KeyNumber.hints.tooltip}"
                                    id="it14">
                        <f:validator binding="#{bindings.KeyNumber.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.KeyNumber.format}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.ReceiptDate.inputValue}"
                                    label="#{bindings.ReceiptDate.hints.label}"
                                    required="#{bindings.ReceiptDate.hints.mandatory}"
                                    columns="#{bindings.ReceiptDate.hints.displayWidth}"
                                    maximumLength="#{bindings.ReceiptDate.hints.precision}"
                                    shortDesc="#{bindings.ReceiptDate.hints.tooltip}"
                                    id="it22"
                                    readOnly="true"
                                    visible="#{!pageFlowScope.sandoogh_cashierList.disableExit}">
                        <f:validator binding="#{bindings.ReceiptDate.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.ReceiptDate.format}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.CashType.inputValue}"
                                          label="#{bindings.CashType.label}"
                                          required="#{bindings.CashType.hints.mandatory}"
                                          shortDesc="#{bindings.CashType.hints.tooltip}"
                                          id="soc6" disabled="#{!pageFlowScope.sandoogh_cashierList.disableExit}">
                        <f:selectItems value="#{bindings.CashType.items}"
                                       id="si6"/>
                      </af:selectOneChoice>
                      <f:facet name="footer">
                        <af:panelGroupLayout id="pgl5" layout="horizontal"
                                             halign="center">
                          <af:commandButton text="ثبت ورود" id="cb4" 
                                            actionListener="#{pageFlowScope.sandoogh_cashierList.save_enter}"
                                            partialTriggers="cb5"
                                            disabled="#{!pageFlowScope.sandoogh_cashierList.disableExit}">
                           
                          </af:commandButton>
                          <af:commandButton text="ثبت خروج" id="cb5" 
                                            disabled="#{pageFlowScope.sandoogh_cashierList.disableExit}"
                                            actionListener="#{pageFlowScope.sandoogh_cashierList.save_exit}"
                                            partialTriggers="cb4"/>
                        </af:panelGroupLayout>
                        </f:facet>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:spacer width="10" height="10" id="s2"/>
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
              <af:panelWindow id="pw1" closeIconVisible="false"
                              inlineStyle="width:500.0px;"
                              clientComponent="false">
                <af:panelFormLayout id="pfl4">
                  <f:facet name="footer">
                    <af:panelGroupLayout id="pgl3" layout="horizontal"
                                         halign="center">
                      <af:commandButton text="انتخاب" id="cb2"
                                        action="#{pageFlowScope.sandoogh_cashierList.selectPerson_btn}"/>
                      <af:commandButton text="بازگشت" id="cb3"/>
                    </af:panelGroupLayout>
                  </f:facet>
                  <af:panelCollection id="pc1">
                    <f:facet name="menus"/>
                    <f:facet name="toolbar"/>
                    <f:facet name="statusbar"/>
                    <af:table value="#{bindings.CashierListVo1.collectionModel}"
                              var="row"
                              rows="#{bindings.CashierListVo1.rangeSize}"
                              emptyText="#{bindings.CashierListVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                              fetchSize="#{bindings.CashierListVo1.rangeSize}"
                              rowBandingInterval="0"
                              filterModel="#{bindings.CashierListVo1Query.queryDescriptor}"
                              queryListener="#{bindings.CashierListVo1Query.processQuery}"
                              filterVisible="true" varStatus="vs"
                              selectedRowKeys="#{bindings.CashierListVo1.collectionModel.selectedRow}"
                              selectionListener="#{bindings.CashierListVo1.collectionModel.makeCurrent}"
                              rowSelection="single" id="t2">
                      <af:column sortProperty="Fname" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.Fname.label}"
                                 id="c3">
                        <af:outputText value="#{row.Fname}" id="ot2"/>
                      </af:column>
                      <af:column sortProperty="Lname" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.Lname.label}"
                                 id="c6">
                        <af:outputText value="#{row.Lname}" id="ot7"/>
                      </af:column>
                      <af:column sortProperty="Barcode" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.Barcode.label}"
                                 id="c5">
                        <af:outputText value="#{row.Barcode}" id="ot4"/>
                      </af:column>
                      <af:column sortProperty="KeyNumber" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.KeyNumber.label}"
                                 id="c1">
                        <af:outputText value="#{row.KeyNumber}" id="ot5">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.CashierListVo1.hints.KeyNumber.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="ReceiptTime" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.ReceiptTime.label}"
                                 id="c2">
                        <af:outputText value="#{row.ReceiptTime}" id="ot1">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.CashierListVo1.hints.ReceiptTime.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="ReceiptDate" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.ReceiptDate.label}"
                                 id="c4">
                        <af:outputText value="#{row.ReceiptDate}" id="ot6">
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.CashierListVo1.hints.ReceiptDate.format}"/>
                        </af:outputText>
                      </af:column>
                      <af:column sortProperty="CasheType" filterable="true"
                                 sortable="true"
                                 headerText="#{bindings.CashierListVo1.hints.CasheType.label}"
                                 id="c7">
                        <af:selectOneChoice value="#{row.bindings.CasheType.inputValue}"
                                            label="#{row.bindings.CasheType.label}"
                                            required="#{bindings.CashierListVo1.hints.CasheType.mandatory}"
                                            shortDesc="#{bindings.CashierListVo1.hints.CasheType.tooltip}"
                                            id="soc7" readOnly="true">
                          <f:selectItems value="#{row.bindings.CasheType.items}"
                                         id="si7"/>
                        </af:selectOneChoice>
                      </af:column>
                    </af:table>
                  </af:panelCollection>
                </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
            <af:popup id="penalty">
             <af:panelWindow title="محاسبه جریمه" id="pw3" modal="true">
               
                 
                  <af:panelFormLayout id="pfl6">
                    <af:panelLabelAndMessage label="مدت زمان تاخیر:" id="plam1">
                  
                   
                    <af:inputText value="#{bindings.DelayMonth.inputValue}"
                                  label="#{bindings.DelayMonth.hints.label}"
                                  required="#{bindings.DelayMonth.hints.mandatory}"
                                  columns="#{bindings.DelayMonth.hints.displayWidth}"
                                  maximumLength="#{bindings.DelayMonth.hints.precision}"
                                  shortDesc="#{bindings.DelayMonth.hints.tooltip}"
                                  id="it16" readOnly="true">
                      <f:validator binding="#{bindings.DelayMonth.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.DelayMonth.format}"/>
                    </af:inputText>
                    <af:inputText value="#{bindings.DelayDay.inputValue}"
                                  label="#{bindings.DelayDay.hints.label}"
                                  required="#{bindings.DelayDay.hints.mandatory}"
                                  columns="#{bindings.DelayDay.hints.displayWidth}"
                                  maximumLength="#{bindings.DelayDay.hints.precision}"
                                  shortDesc="#{bindings.DelayDay.hints.tooltip}"
                                  id="it17" readOnly="true">
                      <f:validator binding="#{bindings.DelayDay.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.DelayDay.format}"/>
                    </af:inputText>
                    <af:panelGroupLayout id="pgl4" layout="horizontal">
                      <af:inputText value="#{bindings.HolyWeek.inputValue}"
                                    label="#{bindings.HolyWeek.hints.label}"
                                    required="#{bindings.HolyWeek.hints.mandatory}"
                                    columns="#{bindings.HolyWeek.hints.displayWidth}"
                                    maximumLength="#{bindings.HolyWeek.hints.precision}"
                                    shortDesc="#{bindings.HolyWeek.hints.tooltip}"
                                    id="it18" readOnly="true">
                        <f:validator binding="#{bindings.HolyWeek.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.HolyWeek.format}"/>
                      </af:inputText>
                      <af:outputText value="معاف از پرداخت جریمه" id="ot3"/>
                    </af:panelGroupLayout>
                  </af:panelLabelAndMessage>
                  <af:panelLabelAndMessage label="جریمه : " id="plam2">
                  <af:inputText value="#{bindings.PenaltyOffer.inputValue}"
                                label="#{bindings.PenaltyOffer.hints.label}"
                                required="#{bindings.PenaltyOffer.hints.mandatory}"
                                columns="#{bindings.PenaltyOffer.hints.displayWidth}"
                                maximumLength="#{bindings.PenaltyOffer.hints.precision}"
                                shortDesc="#{bindings.PenaltyOffer.hints.tooltip}"
                                id="it19" readOnly="true">
                    <f:validator binding="#{bindings.PenaltyOffer.validator}"/>
                    <af:convertNumber groupingUsed="false"
                                      pattern="#{bindings.PenaltyOffer.format}"/>
                  </af:inputText>
                    <af:inputText label="مقدار جریمه" id="it15"
                                  value="#{pageFlowScope.sandoogh_cashierList.penaltyValue}"/>
                    <af:inputText label="توضیحات" id="it20"
                                  value="#{pageFlowScope.sandoogh_cashierList.penaltyDescription}"/>
                  </af:panelLabelAndMessage>
                     
                       
                  <f:facet name="footer">
                   <af:panelGroupLayout id="pgl8" halign="center"
                                             valign="middle"
                                             layout="horizontal">
                          <af:commandButton partialSubmit="true" text="ثبت" id="cb7"
                                            action="#{pageFlowScope.sandoogh_cashierList.show_penalty_confirmPopUp}"/>
                          <af:commandButton text="انصراف" id="cb6"
                                           />
                        </af:panelGroupLayout>
                  </f:facet>
                </af:panelFormLayout>
                </af:panelWindow>
            
            </af:popup>
            <af:popup id="penaltyConfirm">
              <af:panelWindow id="pw2">
                <af:panelFormLayout id="pfl5">
                  <f:facet name="footer">
                   <af:panelGroupLayout id="pgl6" halign="center"
                                             valign="middle"
                                             layout="horizontal">
                          <af:commandButton  text="بلی"
                                            id="cb8"
                                            actionListener="#{pageFlowScope.sandoogh_cashierList.penaltyConfirmPopUp_yesbtn}"/>
                                          
                          <af:commandButton text="خیر" id="cb9"
                                           />
                        </af:panelGroupLayout>
                        
                  </f:facet>
                  <af:outputText value="#{pageFlowScope.sandoogh_cashierList.popUpText}" id="ot8"/>
                </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
            <af:popup id="passcourse">
             <af:panelWindow id="pw4">
                <af:panelFormLayout id="pfl7">
                  <f:facet name="footer">
                   <af:panelGroupLayout id="pgl7" halign="center"
                                             valign="middle"
                                             layout="horizontal">
                          <af:commandButton  text="بلی"
                                            id="cb10"
                                            actionListener="#{pageFlowScope.sandoogh_cashierList.cinfirmbtn_memPassCoursePopUp}"/>
                                          
                          <af:commandButton text="خیر" id="cb11"
                                           />
                        </af:panelGroupLayout>
                        
                  </f:facet>
                  <af:outputText value="#{pageFlowScope.sandoogh_cashierList.popUpText}"
                                 id="ot9"/>
                </af:panelFormLayout>
              </af:panelWindow>
            </af:popup>
          </af:group>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>