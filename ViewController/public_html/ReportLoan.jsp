<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
  ${sessionUser.authorization}

<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="گزارشات میز امانت" helpTopicId="reportLoan">
            <af:panelBox text=" " id="pb1" showDisclosure="false">
              <af:panelAccordion id="pa1">
                <af:showDetailItem text="جریمه دریافتی توسط کارکنان" id="sdi1">
                  <af:panelGroupLayout id="pgl1" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s1"/>
                    <af:panelFormLayout id="pfl1" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it1"
                                    value="#{viewScope.reportLoan.penaltyPaymentFromDate}"/>
                      <af:inputText label="تا تاریخ" id="it2"
                                    value="#{viewScope.reportLoan.penaltyPaymentToDate}"/>
                      <af:inputText label="نام کاربر" id="it3"
                                    value="#{viewScope.reportLoan.penaltyPaymentUsername}"/>
                      
                      <af:commandButton text="تهیه گزارش " id="cb1" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_penalty_payment.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.penaltyPaymentFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.penaltyPaymentToDate}&P_USERNAM=#{viewScope.reportLoan.penaltyPaymentUsername}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                <af:showDetailItem text="اعضای دارای تاخیر در بازگشت کتاب" id="sdi2">
                 <af:panelGroupLayout id="pgl2" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s2"/>
                    <af:panelFormLayout id="pfl4" rows="2" maxColumns="3"
                                        fieldWidth="200" labelWidth="200">
                      <af:inputText label="تا اکنون" id="it4"
                                    value="#{viewScope.reportLoan.listDelayTaCurrDate}"/>
                      <af:panelLabelAndMessage   label="سمت" id="plam1">
                        <af:panelGroupLayout id="pgl11" layout="horizontal">
                          <af:selectOneChoice value="#{bindings.CMemSetupPostLOV.inputValue}"
                                            simple="true"
                                              disabled="#{viewScope.reportLoan.delayPostChbx}"
                                              required="#{bindings.CMemSetupPostLOV.hints.mandatory}"
                                              shortDesc="#{bindings.CMemSetupPostLOV.hints.tooltip}"
                                              id="soc1" partialTriggers="sbc1"
                                              inlineStyle="margin-right:6px;">
                            <f:selectItems value="#{bindings.CMemSetupPostLOV.items}"
                                           id="si1"/>
                          </af:selectOneChoice>
                          <af:selectBooleanCheckbox text="انتخاب همه" id="sbc1"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.delayPostChbx}"/>
                        </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:panelLabelAndMessage   label="نوع عضویت" id="plam2">
                      <af:panelGroupLayout id="pgl12" layout="horizontal">
                      <af:selectOneChoice value="#{bindings.PersTypeLOV.inputValue}"
                                          disabled="#{viewScope.reportLoan.delayPersTypeChbx}"
                                          required="false"
                                          shortDesc="#{bindings.PersTypeLOV.hints.tooltip}"
                                          partialTriggers="sbc2"
                                          id="soc2">
                        <f:selectItems value="#{bindings.PersTypeLOV.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc2"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.delayPersTypeChbx}"/>
                     </af:panelGroupLayout> 
                     </af:panelLabelAndMessage>
                      <af:panelLabelAndMessage    label="دانشکده" id="plam3">
                      <af:panelGroupLayout id="pgl13" layout="horizontal">
                      <af:selectOneChoice value="#{bindings.DeptLOV.inputValue}"
                                         required="#{bindings.DeptLOV.hints.mandatory}"
                                          shortDesc="#{bindings.DeptLOV.hints.tooltip}"
                                          disabled="#{viewScope.reportLoan.delayDepChbx}"
                                          partialTriggers="sbc3"
                                          id="soc3">
                        <f:selectItems value="#{bindings.DeptLOV.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                        <af:selectBooleanCheckbox text="انتخاب همه" id="sbc3"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.delayDepChbx}"/>
                                                    
                        </af:panelGroupLayout>
                        </af:panelLabelAndMessage>
                      <af:spacer width="10" height="20" id="s5"/>
                        <af:commandButton text="تهیه گزارش " id="cb2" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_list_delay.rdf&P_cur_libid=#{viewScope.reportLoan.libArtId}&P_TA_cur_date=#{viewScope.reportLoan.listDelayTaCurrDate}&P_DEPT_ART_ID=#{viewScope.reportLoan.delayDepChbx==true?'':(bindings.DeptLOV.attributeValue)}&P_PERS_TYPE=#{viewScope.reportLoan.delayPersTypeChbx==true?'':(bindings.PersTypeLOV.attributeValue)}&P_CMEMSETUP_ART_ID=#{viewScope.reportLoan.delayPostChbx==true?'':(bindings.CMemSetupPostLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                       
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                <af:showDetailItem text="کتاب های رزرو شده" id="sdi3">
                 <af:panelGroupLayout id="pgl3" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s4"/>
                    <af:panelFormLayout id="pfl2" rows="2" maxColumns="3"
                                        fieldWidth="200" labelWidth="200">
                      <af:inputText label="از تاریخ" id="it10" value="#{viewScope.reportLoan.fromDate}"/>
                      <af:inputText label="تا تاریخ" id="it11" value="#{viewScope.reportLoan.toDate}"/>
                      <af:inputText label="تعداد کتاب های رزرو شده بیش از" id="it12" value="#{viewScope.reportLoan.reserveCnt}"/>
                       <af:commandButton text="تهیه گزارش " id="cb4" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_reserve_cnt.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.fromDate}&P_TA_TARIKH=#{viewScope.reportLoan.toDate}&P_CNT_RESERVE=#{viewScope.reportLoan.reserveCnt}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                       </af:commandButton>
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                 <af:showDetailItem id="sdi4"
                                    text="کتاب های دارای بیشترین  رزرو">
                 <af:panelGroupLayout id="pgl4" layout="horizontal"
                                       valign="middle" halign="center">
                   <af:spacer width="10" height="50" id="s3"/>
                    <af:panelFormLayout id="pfl3" rows="2" maxColumns="4"
                                        fieldWidth="200" labelWidth="150">
                      <af:inputText label="از تاریخ" id="it7"
                                    value="#{viewScope.reportLoan.reserveMaxFromDate}"/>
                      <af:inputText label="کتاب دارای بیشترین رزرو" id="it9"
                                                          
                                    value="#{viewScope.reportLoan.reserveMaxRecCnt }"/>
                      <af:inputText label="تا تاریخ" id="it8"  value="#{viewScope.reportLoan.reserveMaxToDate}"/>
                        <af:commandButton text="تهیه گزارش " id="cb3" action="#{viewScope.reportLoan.runReport}">
                       
                      <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_reserve_max.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.reserveMaxFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.reserveMaxToDate}&P_MAX_RESERVE=#{viewScope.reportLoan.reserveMaxRecCnt}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>   
                       </af:commandButton>
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                 <af:showDetailItem id="sdi5"
                                    text="کتاب های دارای بیشترین امانت">
                 <af:panelGroupLayout id="pgl5" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s6"/>
                    <af:panelFormLayout id="pfl5" rows="2" maxColumns="3"
                                        fieldWidth="200" labelWidth="170">
                      <af:inputText label="از تاریخ" id="it5"
                                    value="#{viewScope.reportLoan.loanMaxFromDate}"/>
                      <af:inputText label="تا تاریخ" id="it13"
                       value="#{viewScope.reportLoan.loanMaxToDate}"/>
                      <af:inputText label="حروف آغازین رده بندی" id="it14" styleClass="AFFieldTextLTRMarker"
                       value="#{viewScope.reportLoan.loanMaxCallNo}"/>
                      <af:inputText label="کتاب های دارای بیشترین امانت" id="it6" 
                       value="#{viewScope.reportLoan.loanMaxMoreThan}"/>
                      <af:spacer width="10" height="20" id="s16"/>
                      <af:commandButton text="تهیه گزارش " id="cb5" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_loan_max.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.loanMaxFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.loanMaxToDate}&P_MAX_LOAN=#{viewScope.reportLoan.loanMaxMoreThan}&P_CALLNO_STR=#{viewScope.reportLoan.loanMaxCallNo}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                   
                   
                  </af:panelGroupLayout>
                </af:showDetailItem>
                 <af:showDetailItem id="sdi6" text="فعالیت کاربران">
                 <af:panelGroupLayout id="pgl6" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:panelFormLayout id="pfl6" rows="1" maxColumns="3"
                                        labelWidth="200">
                      <af:inputText label="نام کاربری" id="it21"
                                    value="#{viewScope.reportLoan.amarKarkardUsername}"/>
                      <af:spacer width="10" height="10" id="s11"/>
                     <af:commandButton text="تهیه گزارش " id="cb6" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_amar_karkrd1.rdf&P_USERNAM=#{viewScope.reportLoan.amarKarkardUsername}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
              
                 <af:showDetailItem id="sdi7"
                                    text="تعداد اعضای کتابخانه">
                 <af:panelGroupLayout id="pgl7" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s8"/>
                    <af:panelFormLayout id="pfl7" rows="5" maxColumns="3"
                                        fieldWidth="200" labelWidth="170">
                      
                       <af:panelLabelAndMessage    label="دانشکده" id="plam4">
                      <af:panelGroupLayout id="pgl14" layout="horizontal">
                      <af:selectOneChoice value="#{bindings.DeptArtId.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountDepChbx}"
                                          partialTriggers="sbc4"
                                          required="#{bindings.DeptArtId.hints.mandatory}"
                                          shortDesc="#{bindings.DeptArtId.hints.tooltip}"
                                          id="soc12" autoSubmit="true">
                        <f:selectItems value="#{bindings.DeptArtId.items}"
                                       id="si12"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc4"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountDepChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                               
                               
                      <af:panelLabelAndMessage    label="مقطع" id="plam5">
                      <af:panelGroupLayout id="pgl15" layout="horizontal">                             
                      <af:selectOneChoice value="#{bindings.Degree.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountDegChbx}"
                                          partialTriggers="sbc5"
                                          required="#{bindings.Degree.hints.mandatory}"
                                          shortDesc="#{bindings.Degree.hints.tooltip}"
                                          id="soc10">
                        <f:selectItems value="#{bindings.Degree.items}"
                                       id="si10"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc5"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountDegChbx}"/>
                        </af:panelGroupLayout>
                        </af:panelLabelAndMessage>
                      
                      <af:panelLabelAndMessage    label="وضعیت شخص" id="plam6">
                      <af:panelGroupLayout id="pgl16" layout="horizontal">                             
                      <af:selectOneChoice value="#{bindings.PersStatus.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountPersStChbx}"
                                          partialTriggers="sbc6"
                                          required="#{bindings.PersStatus.hints.mandatory}"
                                          shortDesc="#{bindings.PersStatus.hints.tooltip}"
                                          id="soc15">
                        <f:selectItems value="#{bindings.PersStatus.items}"
                                       id="si15"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc6"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountPersStChbx}"/>
                                                    
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:panelLabelAndMessage    label="سازمان" id="plam7">
                      <af:panelGroupLayout id="pgl17" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.Affiliation.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountAffilChbx}"
                                          partialTriggers="sbc7"
                                          required="#{bindings.Affiliation.hints.mandatory}"
                                          shortDesc="#{bindings.Affiliation.hints.tooltip}"
                                          id="soc11" >
                        <f:selectItems value="#{bindings.Affiliation.items}"
                                       id="si11"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc7"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountAffilChbx}"/>
                                                    
                        </af:panelGroupLayout>
                        </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s12"/>
                      
                    <af:panelLabelAndMessage    label="گروه" id="plam8">
                      <af:panelGroupLayout id="pgl18" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                        disabled="#{viewScope.reportLoan.memCountSecChbx}"
                                          partialTriggers="soc12 sbc8"
                                          required="#{bindings.SecArtId.hints.mandatory}"
                                          shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                          id="soc17"
                                          autoSubmit="true">
                        <f:selectItems value="#{bindings.SecArtId.items}"
                                       id="si17"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc8"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountSecChbx}"/>
                    </af:panelGroupLayout>
                    </af:panelLabelAndMessage>
                          
                    <af:panelLabelAndMessage    label="سمت" id="plam9">
                      <af:panelGroupLayout id="pgl19" layout="horizontal">                                 
                      <af:selectOneChoice value="#{bindings.CmemSetupPost.inputValue}"
                                         disabled="#{viewScope.reportLoan.memCountPostChbx}"
                                          partialTriggers="sbc9"
                                          required="#{bindings.CmemSetupPost.hints.mandatory}"
                                          shortDesc="#{bindings.CmemSetupPost.hints.tooltip}"
                                          id="soc14">
                        <f:selectItems value="#{bindings.CmemSetupPost.items}"
                                       id="si14"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc9"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountPostChbx}"/>
                                                    
                        </af:panelGroupLayout>
                        </af:panelLabelAndMessage>
                       <af:panelLabelAndMessage    label="نوع عضویت" id="plam10">
                      <af:panelGroupLayout id="pgl20" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                         disabled="#{viewScope.reportLoan.memCountPersTypeChbx}"
                                          partialTriggers="sbc10"
                                          required="false"
                                          shortDesc="#{bindings.PersType.hints.tooltip}"
                                          id="soc13">
                        <f:selectItems value="#{bindings.PersType.items}"
                                       id="si13"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc10"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountPersTypeChbx}"/>
                                                    
                        </af:panelGroupLayout>
                        </af:panelLabelAndMessage>
                        
                         <af:panelLabelAndMessage    label="جنسیت" id="plam11">
                      <af:panelGroupLayout id="pgl21" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.Origine.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountOriginChbx}"
                                          partialTriggers="sbc11"
                                          required="#{bindings.Origine.hints.mandatory}"
                                          shortDesc="#{bindings.Origine.hints.tooltip}"
                                          id="soc9">
                        <f:selectItems value="#{bindings.Origine.items}"
                                       id="si9"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc11"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountOriginChbx}"/>
                     </af:panelGroupLayout>
                     </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s13"/>
                      
                       <af:panelLabelAndMessage    label="رشته" id="plam12">
                      <af:panelGroupLayout id="pgl22" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.MjrArtId.inputValue}"
                      disabled="#{viewScope.reportLoan.memCountMjrChbx}"
                                          partialTriggers="sbc12  soc17"
                                          required="#{bindings.MjrArtId.hints.mandatory}"
                                          shortDesc="#{bindings.MjrArtId.hints.tooltip}"
                                          id="soc18" >
                        <f:selectItems value="#{bindings.MjrArtId.items}"
                                       id="si18"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc12"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountMjrChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                       <af:panelLabelAndMessage    label="شغل" id="plam13">
                      <af:panelGroupLayout id="pgl23" layout="horizontal">       
                      <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                          disabled="#{viewScope.reportLoan.memCountPersCatChbx}"
                                          partialTriggers="sbc13"
                                          required="#{bindings.PersCategory.hints.mandatory}"
                                          shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                          id="soc16">
                        <f:selectItems value="#{bindings.PersCategory.items}"
                                       id="si16"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc13"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memCountPersCatChbx}"/>
                            </af:panelGroupLayout>
                            </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s14"/>
                      <af:commandButton text="تهیه گزارش " id="cb10" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_member_cnt.rdf&P_cur_libid=#{viewScope.reportLoan.libArtId}&P_DEPT_ART_ID=#{viewScope.reportLoan.memCountDepChbx==true?'':(bindings.DeptArtId.attributeValue)}&P_SEC_ART_ID=#{viewScope.reportLoan.memCountSecChbx==true?'':(bindings.SecArtId.attributeValue)}&P_MJR_ART_ID=#{viewScope.reportLoan.memCountMjrChbx==true?'':(bindings.MjrArtId.attributeValue)}&P_PERS_CATEGORY=#{viewScope.reportLoan.memCountPersCatChbx==true?'':(bindings.PersCategory.attributeValue)}&P_ORIGINE=#{viewScope.reportLoan.memCountOriginChbx==true?'':(bindings.Origine.attributeValue)}&P_PERS_STATUS=#{viewScope.reportLoan.memCountPersStChbx==true?'':(bindings.PersStatus.attributeValue)}&P_DEGREE=#{viewScope.reportLoan.memCountDegChbx==true?'':(bindings.Degree.attributeValue)}&P_PERS_TYPE=#{viewScope.reportLoan.memCountPersTypeChbx==true?'':(bindings.PersType.attributeValue)}&P_CMEMSETUP_ART_ID=#{viewScope.reportLoan.memCountPostChbx==true?'':(bindings.CmemSetupPost.attributeValue)}&P_ORGAN=#{viewScope.reportLoan.memCountAffilChbx==true?'':(bindings.Affiliation.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                   
                   
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                  <af:showDetailItem id="sdi8"
                                    text="بیشترین/کمترین استفاده کنندگان">
                 <af:panelGroupLayout id="pgl8" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s7"/>
                    <af:panelFormLayout id="pfl8" rows="3" maxColumns="3"
                                        fieldWidth="200" labelWidth="150">
                      <af:inputText label="از تاریخ" id="it19"
                                    value="#{viewScope.reportLoan.memberMaxMinFromDate}"/>
                      <af:inputText label="تا تاریخ" id="it23"
                                    value="#{viewScope.reportLoan.memberMaxMinToDate}"/>
                      
                       <af:panelLabelAndMessage    label="مقطع" id="plam14">
                      <af:panelGroupLayout id="pgl24" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.Degree.inputValue}"
                                           disabled="#{viewScope.reportLoan.memberMaxMinDegree}"
                                          partialTriggers="sbc14"
                                          required="#{bindings.Degree.hints.mandatory}"
                                          shortDesc="#{bindings.Degree.hints.tooltip}"
                                          id="soc5" >
                        <f:selectItems value="#{bindings.Degree.items}"
                                       id="si5"/>
                      </af:selectOneChoice>
                        <af:selectBooleanCheckbox text="انتخاب همه" id="sbc14"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memberMaxMinDegree}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                       <af:panelLabelAndMessage    label="دانشکده" id="plam15">
                      <af:panelGroupLayout id="pgl25" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.DeptArtId.inputValue}"
                                           disabled="#{viewScope.reportLoan.memberMaxMinDep}"
                                          partialTriggers="sbc15"
                                          required="#{bindings.DeptArtId.hints.mandatory}"
                                          shortDesc="#{bindings.DeptArtId.hints.tooltip}"
                                          id="soc6" autoSubmit="true">
                        <f:selectItems value="#{bindings.DeptArtId.items}"
                                       id="si6"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc15"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memberMaxMinDep}"/>
                      
                     </af:panelGroupLayout>
                     </af:panelLabelAndMessage>
                     
                      <af:panelLabelAndMessage    label="گروه" id="plam16">
                      <af:panelGroupLayout id="pgl26" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                          disabled="#{viewScope.reportLoan.memberMaxMinSec}"
                                          partialTriggers="sbc16 soc6 "
                                          required="#{bindings.SecArtId.hints.mandatory}"
                                          shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                          id="soc19" 
                                          autoSubmit="true">
                        <f:selectItems value="#{bindings.SecArtId.items}"
                                       id="si19"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc16"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memberMaxMinSec}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                       <af:panelLabelAndMessage    label="رشته" id="plam17">
                      <af:panelGroupLayout id="pgl27" layout="horizontal">    
                       <af:selectOneChoice value="#{bindings.MjrArtId.inputValue}"
                                          disabled="#{viewScope.reportLoan.memberMaxMinMjr}"
                                          partialTriggers="sbc17 soc19"
                                          required="#{bindings.MjrArtId.hints.mandatory}"
                                          shortDesc="#{bindings.MjrArtId.hints.tooltip}"
                                          id="soc7" >
                        <f:selectItems value="#{bindings.MjrArtId.items}"
                                       id="si7"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc17"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memberMaxMinMjr}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                       <af:panelLabelAndMessage    label="جنسیت" id="plam18">
                      <af:panelGroupLayout id="pgl28" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.Origine.inputValue}"
                                           disabled="#{viewScope.reportLoan.memberMaxMinOrigin}"
                                          partialTriggers="sbc18"
                                          required="#{bindings.Origine.hints.mandatory}"
                                          shortDesc="#{bindings.Origine.hints.tooltip}"
                                          id="soc4" unselectedLabel="...">
                        <f:selectItems value="#{bindings.Origine.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc18"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memberMaxMinOrigin}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s15"/>
                      <af:commandButton text="تهیه گزارش " id="cb7" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_member_max_min.rdf&P_cur_libid=#{viewScope.reportLoan.libArtId}&P_AZ_TARIKH=#{viewScope.reportLoan.memberMaxMinFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.memberMaxMinToDate}&P_DEPT_ART_ID=#{viewScope.reportLoan.memberMaxMinDep==true?'':(bindings.DeptArtId.attributeValue)}&P_DEGREE=#{viewScope.reportLoan.memberMaxMinDegree==true?'':(bindings.Degree.attributeValue)}&P_ORIGINE=#{viewScope.reportLoan.memberMaxMinOrigin==true?'':(bindings.Origine.attributeValue)}&P_MJR_ART_ID=#{viewScope.reportLoan.memberMaxMinMjr==true?'':(bindings.MjrArtId.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                   
                   
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                 <af:showDetailItem id="sdi9"
                                    text="اعضا با بیشترین/کمترین تاخیر امانت">
                 <af:panelGroupLayout id="pgl9" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s9"/>
                    <af:panelFormLayout id="pfl9" rows="3" maxColumns="2"
                                        fieldWidth="200" labelWidth="170">
                      <af:inputText label="از تاریخ" id="it20"
                                    value="#{viewScope.reportLoan.memberDelayFromDate}"/>
                      <af:inputText label="عضو دارای بیشترین/کمترین تاخیر" id="it25"
                                    value="#{viewScope.reportLoan.memberDelayCnt}"/>
                      <af:selectOneChoice label=" افراد دارای تاخیر " id="soc23"
                                          value="#{viewScope.reportLoan.memberDelaySort}"
                                          simple="true">
                        <af:selectItem label="بیشترین تاخیر" value="DESC"
                                       id="si24"/>
                        <af:selectItem label="کمترین تاخیر" value="ASC"
                                       id="si23"/>
                      </af:selectOneChoice>
                      <af:inputText label="تا تاریخ" id="it24"
                                     value="#{viewScope.reportLoan.memberDelayToDate}"/>
                      <af:spacer width="10" height="10" id="s23"/>
                      <af:commandButton text="تهیه گزارش " id="cb8" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_member_delay.rdf&P_MAX_MIN_DELAY=#{viewScope.reportLoan.memberDelaySort}&P_AZ_TARIKH=#{viewScope.reportLoan.memberDelayFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.memberDelayToDate}&P_CUR_LIBID=#{viewScope.reportLoan.libArtId}&P_CNT_MEM_DELAY=#{viewScope.reportLoan.memberDelayCnt}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                    </af:panelFormLayout>
                   
                   
                  </af:panelGroupLayout>
                </af:showDetailItem>
                <af:showDetailItem id="sdi10"
                                    text="اعضای فاقد سابقه امانت کتاب">
                 <af:panelGroupLayout id="pgl10" layout="horizontal"
                                       valign="middle" halign="center">
                    <af:spacer width="10" height="50" id="s10"/>
                    <af:panelFormLayout id="pfl10" rows="1" maxColumns="4"
                                        fieldWidth="200" labelWidth="150">
                      
                       <af:panelLabelAndMessage    label="دانشکده" id="plam19">
                      <af:panelGroupLayout id="pgl29" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.DeptLOV.inputValue}"
                                           disabled="#{viewScope.reportLoan.memNoLoanDepChBx}"
                                          partialTriggers="sbc19"
                                          required="#{bindings.DeptLOV.hints.mandatory}"
                                          shortDesc="#{bindings.DeptLOV.hints.tooltip}"
                                          id="soc8">
                        <f:selectItems value="#{bindings.DeptLOV.items}"
                                       id="si8"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc19"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.memNoLoanDepChBx}"/>
                     </af:panelGroupLayout>
                     </af:panelLabelAndMessage>
                      <f:facet name="footer"/>
                       <af:commandButton text="تهیه گزارش " id="cb9" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_mem_ziro_loan.rdf&P_CUR_LIBID=#{viewScope.reportLoan.libArtId}&P_DEPT_ART_ID=#{viewScope.reportLoan.memNoLoanDepChBx==true?'':(bindings.DeptLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                    </af:panelFormLayout>
                   
                   
                  </af:panelGroupLayout>
                </af:showDetailItem>
            
            
            <af:showDetailItem text="میزان استفاده از صندوق و اعضا" id="sdi11">
                  <af:panelGroupLayout id="pgl30" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s17"/>
                    <af:panelFormLayout id="pfl11" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it15"
                                    value="#{viewScope.reportLoan.usageKeyFromDate}"/>
                      <af:spacer width="10" height="10" id="s20"/>
                      <af:inputText label="تا تاریخ" id="it16"
                                    value="#{viewScope.reportLoan.usageKeyToDate}"/>
                    
                      <af:commandButton text="تهیه گزارش " id="cb11" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_USAGE_KEY.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.usageKeyFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.usageKeyToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
             <af:showDetailItem text="کلید های دارای تاخیر"
                                id="sdi12">
                 <af:panelGroupLayout id="pgl31" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s18"/>
                    <af:panelFormLayout id="pfl12" rows="3" maxColumns="3"
                                        fieldWidth="200" labelWidth="150">
                      <af:inputText label="از تاریخ" id="it17"
                                    value="#{viewScope.reportLoan.listDelayKeyFromDate}"/>
                    
                      <af:panelLabelAndMessage   label="سمت" id="plam20">
                        <af:panelGroupLayout id="pgl32" layout="horizontal">
                          <af:selectOneChoice value="#{bindings.CMemSetupPostLOV.inputValue}"
                                            simple="true"
                                              disabled="#{viewScope.reportLoan.listDelayKeyPstChBx}"
                                              required="#{bindings.CMemSetupPostLOV.hints.mandatory}"
                                              shortDesc="#{bindings.CMemSetupPostLOV.hints.tooltip}"
                                              id="soc20" partialTriggers="sbc20"
                                              inlineStyle="margin-right:6px;">
                            <f:selectItems value="#{bindings.CMemSetupPostLOV.items}"
                                           id="si20"/>
                          </af:selectOneChoice>
                          <af:selectBooleanCheckbox text="انتخاب همه" id="sbc20"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.listDelayKeyPstChBx}"/>
                        </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:panelLabelAndMessage label="نوع عضویت" id="plam21">
                        <af:panelGroupLayout id="pgl33" layout="horizontal">
                          <af:selectOneChoice value="#{bindings.PersTypeLOV.inputValue}"
                                              disabled="#{viewScope.reportLoan.listDelayKeyPersTypeChbx}"
                                              required="false"
                                              shortDesc="#{bindings.PersTypeLOV.hints.tooltip}"
                                              partialTriggers="sbc21"
                                              id="soc21">
                            <f:selectItems value="#{bindings.PersTypeLOV.items}"
                                           id="si21"/>
                          </af:selectOneChoice>
                          <af:selectBooleanCheckbox text="انتخاب همه" id="sbc21"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.listDelayKeyPersTypeChbx}"/>
                        </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:inputText label="تا تاریخ" id="it18"
                                    value="#{viewScope.reportLoan.listDelayKeyToDate}"/>
                      <af:panelLabelAndMessage label="دانشکده" id="plam22">
                        <af:panelGroupLayout id="pgl34" layout="horizontal">
                          <af:selectOneChoice value="#{bindings.DeptLOV.inputValue}"
                                              required="#{bindings.DeptLOV.hints.mandatory}"
                                              shortDesc="#{bindings.DeptLOV.hints.tooltip}"
                                              disabled="#{viewScope.reportLoan.listDelayKeyDepChbx}"
                                              partialTriggers="sbc22"
                                              id="soc22">
                            <f:selectItems value="#{bindings.DeptLOV.items}"
                                           id="si22"/>
                          </af:selectOneChoice>
                          <af:selectBooleanCheckbox text="انتخاب همه" id="sbc22"
                                                    autoSubmit="true"
                                                    value="#{viewScope.reportLoan.listDelayKeyDepChbx}"/>
                        </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:spacer width="10" height="20" id="s19"/>
                       <af:spacer width="10" height="10" id="s21"/>
                        <af:spacer width="10" height="10" id="s22"/>
                        <af:commandButton text="تهیه گزارش " id="cb12" action="#{viewScope.reportLoan.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_LIST_DELAY_KEY.rdf&P_AZ_TARIKH=#{viewScope.reportLoan.listDelayKeyFromDate}&P_TA_TARIKH=#{viewScope.reportLoan.listDelayKeyToDate}&P_DEPT_ART_ID=#{viewScope.reportLoan.listDelayKeyDepChbx==true?'':(bindings.DeptLOV.attributeValue)}&P_PERS_TYPE=#{viewScope.reportLoan.listDelayKeyPersTypeChbx==true?'':(bindings.PersTypeLOV.attributeValue)}&P_CMEMSETUP_ART_ID=#{viewScope.reportLoan.listDelayKeyPstChBx==true?'':(bindings.CMemSetupPostLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.reportLoan.reportPath}"/>
                                                   
                       </af:commandButton>
                       
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
              </af:panelAccordion>
              <f:facet name="toolbar"/>
            </af:panelBox>
          </af:panelHeader>
                </f:facet>
        <f:facet name="popup">
        <af:popup id="reportPop" childCreation="deferred" 
                  contentDelivery="lazyUncached">
                  <af:panelWindow title="انتخاب فرمت گزارش"  modal="true">
                  <af:panelGroupLayout layout="horizontal">
                   <af:goLink shortDesc="RTF"  destination="#{viewScope.reportLoan.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{viewScope.reportLoan.reportPath}&desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                  <af:image source="/icons/htmlcss.png"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{viewScope.reportLoan.reportPath}&desformat=html" targetFrame="_blank">
                  <af:image source="/icons/html.png"  />
                  </af:goLink>
                     <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{viewScope.reportLoan.reportPath}&desformat=xml" targetFrame="_blank">
                  <af:image source="/icons/xml.png"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{viewScope.reportLoan.reportPath}&desformat=delimiteddata" targetFrame="_blank">
                  <af:image source="/icons/csv.png"/>
                  </af:goLink>
                  </af:panelGroupLayout>
                  </af:panelWindow>
        </af:popup>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>