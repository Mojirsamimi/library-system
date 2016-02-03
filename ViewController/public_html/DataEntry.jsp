<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
     <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        
        <af:panelHeader text="تنظیم سیستم" helpTopicId="settings">
         
              <af:panelTabbed id="pt2">
                <af:showDetailItem text="مخازن کتاب" id="sdi1">
                <af:panelBox text=" " id="pb3" showDisclosure="false">
                  <f:facet name="toolbar">
                    <af:toolbar id="t8">
                      <af:commandButton
                                        text="ثبت تغییرات"
                                       
                                        id="cb9"
                                        action="#{viewScope.data_entry.insert_cataligDetail_beforeCommit}"/>
                    </af:toolbar>
                  </f:facet>
                  <af:spacer width="10" height="20" id="s3"/>
                  <af:panelGroupLayout id="pgl1" valign="middle" halign="center"
                                       layout="horizontal">
                    <af:panelCollection id="pc1">
                      <f:facet name="menus"/>
                      <f:facet name="toolbar">
                        <af:toolbar id="t4">
                          <af:commandButton text="جدید" id="cb1"
                                            partialSubmit="true">
                            <af:showPopupBehavior popupId="::bookPlacePopUp"
                                                  triggerType="click"/>
                          </af:commandButton>
                        </af:toolbar>
                      </f:facet>
                      <f:facet name="statusbar"/>
                      <af:table value="#{bindings.CatalogPlaceVo.collectionModel}"
                                var="row"
                                rows="#{bindings.CatalogPlaceVo.rangeSize}"
                                emptyText="#{bindings.CatalogPlaceVo.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.CatalogPlaceVo.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.CatalogPlaceVoQuery.queryDescriptor}"
                                queryListener="#{bindings.CatalogPlaceVoQuery.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.CatalogPlaceVo.collectionModel.selectedRow}"
                                selectionListener="#{bindings.CatalogPlaceVo.collectionModel.makeCurrent}"
                                rowSelection="single" id="t1"
                                columnStretching="column:c3">
                        <af:column headerText="مخزن شامل کتاب های قابل امانت دهی"
                                   id="c14" minimumWidth="30">
                          <af:selectBooleanCheckbox value="#{row.bindings.MakhzanType.inputValue}"
                                                    label="#{row.bindings.MakhzanType.label}"
                                                    shortDesc="#{bindings.CatalogPlaceVo.hints.MakhzanType.tooltip}"
                                                    id="sbc1"
                                                    valueChangeListener="#{viewScope.data_entry.makhzanAmanatDehi_chkBx_valueChanged}"
                                                    autoSubmit="true"/>
                        </af:column>
                        <af:column sortProperty="Value" filterable="true"
                                   sortable="true" headerText="شماره" id="c1">
                          <af:outputText value="#{row.Value}" id="ot1">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.CatalogPlaceVo.hints.Value.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Text" filterable="true"
                                   sortable="true" headerText="نام مخزن"
                                   id="c3">
                          <af:outputText value="#{row.Text}" id="ot2"/>
                        </af:column>
                        <af:column sortProperty="Active" filterable="true"
                                   sortable="true" headerText="وضعیت" id="c2">
                          <af:selectOneChoice label="وضعیت" id="soc1"
                                              value="#{row.Active}"
                                              autoSubmit="true">
                            <af:selectItem label="فعال" value="1" id="si2"/>
                            <af:selectItem label="غیرفعال" value="0" id="si1"/>
                          </af:selectOneChoice>
                        </af:column>
                      </af:table>
                    </af:panelCollection>
                  </af:panelGroupLayout>
                </af:panelBox>
              </af:showDetailItem>
              <af:showDetailItem text="سمت اعضای غیر رسمی" id="sdi2"
                                 >
                <af:panelBox text=" " id="pb4" showDisclosure="false"
                             >
                  <f:facet name="toolbar">
                    <af:toolbar id="t7">
                      <af:commandButton actionListener="#{bindings.Commit.execute}"
                                        text="ثبت تغییرات"
                                        id="cb8"/>
                                        
                    </af:toolbar>
                  </f:facet>
                  <af:panelGroupLayout id="pgl2" layout="scroll"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="20" id="s1"/>
                    <af:panelCollection id="pc3"
                                        inlineStyle="height:150px; border-color:Background; border-style:dotted; border-width:thin;">
                      <f:facet name="menus"/>
                      <f:facet name="toolbar">
                        <af:toolbar id="t5">
                          <af:commandImageLink partialSubmit="true"
                                            icon="/icons/list-add.png"
                                               id="cil1">
                                                 <af:showPopupBehavior popupId="::postPlace"
                                                  triggerType="click"/>
                                               </af:commandImageLink>
                        </af:toolbar>
                      </f:facet>
                      <f:facet name="statusbar"/>
                      <af:table value="#{bindings.CatalogPrivatePostVo1.collectionModel}"
                                var="row"
                                rows="#{bindings.CatalogPrivatePostVo1.rangeSize}"
                                emptyText="#{bindings.CatalogPrivatePostVo1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.CatalogPrivatePostVo1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.CatalogPrivatePostVoQuery.queryDescriptor}"
                                queryListener="#{bindings.CatalogPrivatePostVoQuery.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.CatalogPrivatePostVo1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.CatalogPrivatePostVo1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c4">
                        <af:column sortProperty="Text" filterable="true"
                                   sortable="true" headerText="سمت" id="c4">
                          <af:outputText value="#{row.Text}" id="ot5"/>
                        </af:column>
                        <af:column sortProperty="Active" filterable="true"
                                   sortable="true"
                                   headerText="وضعیت"
                                   id="c5">
                          <af:selectOneChoice label="وضعیت" id="soc2"
                                              value="#{row.Active}">
                            <af:selectItem label="فعال" value="1" id="si3"/>
                            <af:selectItem label="غیرفعال" value="0" id="si4"/>
                          </af:selectOneChoice>
                        </af:column>
                      </af:table>
                    </af:panelCollection>
                    <af:spacer width="10" height="20" id="spacer2"/>
                    <af:panelCollection id="pc2" 
                                        inlineStyle="height:200px; width:60%; border-color:Background; border-style:dotted; border-width:thin;"
                                        partialTriggers="::pc3:t2">
                      <af:table value="#{bindings.MemberSetUpVo11.collectionModel}"
                                var="row"
                                rows="#{bindings.MemberSetUpVo11.rangeSize}"
                                emptyText="#{bindings.MemberSetUpVo11.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.MemberSetUpVo11.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.MemberSetUpVo1Query.queryDescriptor}"
                                queryListener="#{bindings.MemberSetUpVo1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.MemberSetUpVo11.collectionModel.selectedRow}"
                                selectionListener="#{bindings.MemberSetUpVo11.collectionModel.makeCurrent}"
                                rowSelection="single" id="t3"
                                partialTriggers=":::pc3:t2 ::cil2"
                                columnStretching="last">
                        <af:column sortProperty="Active" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo1.hints.Active.label}"
                                   id="c12">
                          <af:selectOneChoice label="وضعیت" id="soc3"
                                              value="#{row.Active}"
                                              readOnly="true">
                            <af:selectItem label="فعال" value="1" id="si5"/>
                            <af:selectItem label="غیرفعال" value="0" id="si6"/>
                          </af:selectOneChoice>
                        </af:column>
                        <af:column sortProperty="LoanDuration" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.LoanDuration.label}"
                                   id="c11">
                          <af:inputText value="#{row.bindings.LoanDuration.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.LoanDuration.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.LoanDuration.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.LoanDuration.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.LoanDuration.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.LoanDuration.tooltip}"
                                        id="it9" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.LoanDuration.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.LoanDuration.format}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="LoanQuota" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.LoanQuota.label}"
                                   id="c6">
                          <af:inputText value="#{row.bindings.LoanQuota.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.LoanQuota.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.LoanQuota.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.LoanQuota.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.LoanQuota.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.LoanQuota.tooltip}"
                                        id="it5" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.LoanQuota.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.LoanQuota.format}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="MemshipDuration"
                                   filterable="true" sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.MemshipDuration.label}"
                                   id="c8">
                          <af:inputText value="#{row.bindings.MemshipDuration.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.MemshipDuration.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.MemshipDuration.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.MemshipDuration.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.MemshipDuration.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.MemshipDuration.tooltip}"
                                        id="it8" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.MemshipDuration.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.MemshipDuration.format}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="PloanQuota" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.PloanQuota.label}"
                                   id="c9">
                          <af:inputText value="#{row.bindings.PloanQuota.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.PloanQuota.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.PloanQuota.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.PloanQuota.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.PloanQuota.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.PloanQuota.tooltip}"
                                        id="it7" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.PloanQuota.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.PloanQuota.format}"/>
                          </af:inputText>
                        </af:column>
                        <af:column sortProperty="ReserveQuota" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.ReserveQuota.label}"
                                   id="c10">
                          <af:inputText value="#{row.bindings.ReserveQuota.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.ReserveQuota.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.ReserveQuota.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.ReserveQuota.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.ReserveQuota.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.ReserveQuota.tooltip}"
                                        id="it3" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.ReserveQuota.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.ReserveQuota.format}"/>
                          </af:inputText>
                        </af:column>
                       
                        <af:column sortProperty="FromDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.FromDate.label}"
                                   id="c7">
                          <af:inputText value="#{row.bindings.FromDate.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.FromDate.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.FromDate.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.FromDate.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.FromDate.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.FromDate.tooltip}"
                                        id="it6" readOnly="true">
                            <f:validator binding="#{row.bindings.FromDate.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.FromDate.format}"/>
                          </af:inputText>
                        </af:column>
                         <af:column sortProperty="ToDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.MemberSetUpVo11.hints.ToDate.label}"
                                   id="c13">
                          <af:inputText value="#{row.bindings.ToDate.inputValue}"
                                        label="#{bindings.MemberSetUpVo11.hints.ToDate.label}"
                                        required="#{bindings.MemberSetUpVo11.hints.ToDate.mandatory}"
                                        columns="#{bindings.MemberSetUpVo11.hints.ToDate.displayWidth}"
                                        maximumLength="#{bindings.MemberSetUpVo11.hints.ToDate.precision}"
                                        shortDesc="#{bindings.MemberSetUpVo11.hints.ToDate.tooltip}"
                                        id="it4" readOnly="#{row.bindings.LoanDuration.inputValue!=null}">
                            <f:validator binding="#{row.bindings.ToDate.validator}"/>
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.MemberSetUpVo11.hints.ToDate.format}"/>
                          </af:inputText>
                        </af:column>
                      </af:table>
                      <f:facet name="menus"/>
                      <f:facet name="toolbar">
                        <af:toolbar id="t9">
                          <af:commandImageLink partialTriggers="t3"
                          icon="/icons/list-add.png"
                                            partialSubmit="true"
                                            actionListener="#{viewScope.data_entry.createInsertMemberSetupActionListener}"
                                               id="cil2"/>
                            </af:toolbar>
                      </f:facet>
                      <f:facet name="statusbar"/>
                    </af:panelCollection>
                  </af:panelGroupLayout>
                </af:panelBox>
              </af:showDetailItem>
              
               <af:showDetailItem text="تنظیمات دیگر ..." id="sdi3">
                <f:facet name="toolbar"/>
                <af:panelBox text=" " id="pb2" showDisclosure="false">
                  <af:panelBox text="جریمه روزانه دیرکرد کتاب" id="pb1"
                               showDisclosure="false">
                    <f:facet name="toolbar"/>
                    <af:panelGroupLayout id="pgl6" layout="horizontal"
                                         valign="middle" halign="start">
                      <af:outputText id="ot3" value="عادی"/>
                      <af:spacer width="130" height="10" id="s6"/>
                      <af:selectOneRadio id="sor1" autoSubmit="true"
                                         layout="horizontal"
                                        
                        value="#{viewScope.data_entry.normalDayPenalty}">
                        <af:selectItem label="دریافت نشود" value="2" id="si14"/>
                        <af:selectItem label="دریافت شود" value="1" id="si15"/>
                      </af:selectOneRadio>
                      
                      <af:inputText value="#{bindings.DayPenalty.inputValue}"
                                    label=""
                                    required="#{bindings.DayPenalty.hints.mandatory}"
                                    columns="#{bindings.DayPenalty.hints.displayWidth}"
                                    maximumLength="#{bindings.DayPenalty.hints.precision}"
                                    shortDesc="#{bindings.DayPenalty.hints.tooltip}"
                                    id="it1">
                        <f:validator binding="#{bindings.DayPenalty.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.DayPenalty.format}"/>
                      </af:inputText>
                    </af:panelGroupLayout>
                    <af:separator id="s4"/>
                    <af:panelGroupLayout id="pgl7" layout="horizontal"
                                         valign="middle" halign="start">
                      <af:spacer width="10" height="30" id="s5"/>
                      <af:outputText value="امانت داده نمی شود" id="ot6"/>
                      <af:spacer width="50" height="10" id="s7"/>
                      <af:selectOneRadio id="sor2" autoSubmit="true"
                                         layout="horizontal"
                                        
                                         value="#{viewScope.data_entry.noLoanDayPenalty}">
                        <af:selectItem label="دریافت نشود" value="2" id="si7"/>
                        <af:selectItem label="دریافت شود" value="1" id="si8"/>
                      </af:selectOneRadio>
                      <af:inputText value="#{bindings.DayPenalty1.inputValue}"
                                    label=""
                                    required="#{bindings.DayPenalty1.hints.mandatory}"
                                    columns="#{bindings.DayPenalty1.hints.displayWidth}"
                                    maximumLength="#{bindings.DayPenalty1.hints.precision}"
                                    shortDesc="#{bindings.DayPenalty1.hints.tooltip}"
                                    id="it2">
                        <f:validator binding="#{bindings.DayPenalty1.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.DayPenalty1.format}"/>
                      </af:inputText>
                    </af:panelGroupLayout>
                  </af:panelBox>
                  <af:spacer width="10" height="20" id="s8"/>
                  <af:panelGroupLayout id="pgl8" layout="horizontal"
                                       valign="middle" halign="right">
                    <af:spacer width="10" height="20" id="s10"/>
                    <af:outputText value="به اعضایی که در کلاس توجیهی شرکت نکرده اند کتاب امانت داده"
                                   id="ot4"/>
                    <af:selectOneRadio id="sor3" autoSubmit="true"
                                       layout="horizontal"
                                       
                                       binding="#{viewScope.data_entry.catClassRadio}"
                                       value="#{viewScope.data_entry.catClass}">
                      <af:selectItem label="شود" value="2" id="si9"/>
                      <af:selectItem label="نشود" value="1" id="si10"/>
                    </af:selectOneRadio>
                  </af:panelGroupLayout>
                  <af:spacer width="10" height="20" id="s9"/>
                  <af:panelGroupLayout id="pgl9" layout="horizontal"
                                       valign="middle" halign="right">
                    <af:spacer width="10" height="20" id="spacer1"/>
                    <af:outputText value="کتاب ها پس از بازگشت از امانت وارد قفسه بازگشت"
                                   id="ot13"/>
                    <af:selectOneRadio id="sor4" autoSubmit="true"
                                       layout="horizontal"
                                      
                                       binding="#{viewScope.data_entry.shelfDelayRadio}"
                                       value="#{viewScope.data_entry.shelfDelay}">
                      <af:selectItem label="شود" value="1" id="si11"/>
                      <af:selectItem label="نشود" value="2" id="si12"/>
                    </af:selectOneRadio>
                  </af:panelGroupLayout>
                  <f:facet name="toolbar">
                   
                      <af:toolbar id="t6">
                   
                         <af:commandButton text="ثبت تغییرات" id="cb7"
                                           actionListener="#{viewScope.data_entry.otherSettingSaveActionListener}"/>
                          
                      </af:toolbar>
                   
                   
                  </f:facet>
                </af:panelBox>
              </af:showDetailItem>
              
            </af:panelTabbed>
             
          </af:panelHeader>
        </f:facet>
        
        <f:facet name="popup">
          
          <af:group>
          <af:popup id="bookPlacePopUp">
            <af:panelWindow id="pw1">
              <af:panelFormLayout id="pfl1">
                <af:inputText label="عنوان مخزن جدید" id="it11"
                value="#{viewScope.data_entry.newBookPlace}"/>
                <f:facet name="footer">
                  <af:panelGroupLayout id="pgl4" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:commandButton text="ثبت" id="cb2"
                                      action="#{viewScope.data_entry.bookPlace_popUp_savebtn}"/>
                    <af:commandButton text="انصراف" id="cb3"/>
                  </af:panelGroupLayout>
                </f:facet>
              </af:panelFormLayout>
            </af:panelWindow>
          </af:popup>
           <af:popup id="postPlace">
            <af:panelWindow id="pw2">
              <af:panelFormLayout id="pfl2">
                <af:inputText label="سمت جدید" id="it12"
                              value="#{viewScope.data_entry.newPost}"/>
                <f:facet name="footer">
                  <af:panelGroupLayout id="pgl5" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:commandButton text="ثبت" id="cb4"
                                      action="#{viewScope.data_entry.post_popUp_savebtn}"/>
                    <af:commandButton text="انصراف" id="cb5"/>
                  </af:panelGroupLayout>
                </f:facet>
              </af:panelFormLayout>
            </af:panelWindow>
          </af:popup>
          </af:group>
     </f:facet>
    </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>