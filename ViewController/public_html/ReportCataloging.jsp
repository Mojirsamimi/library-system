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
        <af:panelHeader text="گزارشات فهرستنویسی"
                        helpTopicId="reportCataloging">
            <af:panelBox text=" " id="pb1" showDisclosure="false">
              <af:panelAccordion id="pa1">
                <af:showDetailItem text="آمار نسخه های آماده سازی شده" id="sdi1">
                
                <af:panelGroupLayout id="pgl2" layout="horizontal"
                                       valign="middle" halign="center">
                   <af:spacer width="10" height="50" id="s2"/>
                    <af:panelFormLayout id="pfl1" rows="3" maxColumns="2"
                                        labelWidth="150">
                      
                                         
                      <af:inputText label="از تاریخ" id="it1"
                                    value="#{viewScope.report_cataloging.amarKarkardFromDate}"/>
                    <af:panelLabelAndMessage    label="محل نگهداری" id="plam15">
                      <af:panelGroupLayout id="pgl25" layout="horizontal">    
                   
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.amarKarkardPlaceChbx}"
                                          partialTriggers="sbc1"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc1">
                                          
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc1"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.amarKarkardPlaceChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s16"/>
                      <af:inputText label="تا تاریخ" id="it2"
                              value="#{viewScope.report_cataloging.amarKarkardToDate}"/>
                      <af:panelLabelAndMessage    label="نوع زبان" id="plam21">
                      <af:panelGroupLayout id="pgl32" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.amarKarkardReadOrdChbx}"
                                          partialTriggers="sbc21"
                                          required="#{bindings.ReadingOrderLOV.hints.mandatory}"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc2">
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si2"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc21"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.amarKarkardReadOrdChbx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:commandButton text="تهیه گزارش " id="cb1" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_amar_noskhe_prepared.rdf&P_AZ_TARIKH=#{viewScope.report_cataloging.amarKarkardFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.amarKarkardToDate}&P_PLACE=#{viewScope.report_cataloging.amarKarkardPlaceChbx==true?'':(bindings.PlaceLOV.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.amarKarkardReadOrdChbx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                                                                      
                       </af:commandButton>
                      
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                <af:showDetailItem text="کنترل موجودی کتاب" id="sdi2">
                <af:panelGroupLayout id="pgl1" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s1"/>
                    <af:panelFormLayout id="pfl2" maxColumns="2" rows="4"
                                        labelWidth="150">
                    
                      <af:inputText label="از تاریخ" id="it25"
                                    value="#{viewScope.report_cataloging.cntrlExistingFromDate}"/>
                      
                       <af:panelLabelAndMessage    label="محل نگهداری" id="plam1">
                      <af:panelGroupLayout id="pgl12" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                         disabled="#{viewScope.report_cataloging.cntrlExistingPlaceChbx}"
                                          partialTriggers="sbc2"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc3">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si3"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc2"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.cntrlExistingPlaceChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                       <af:panelLabelAndMessage    label="وضعیت کتاب" id="plam2">
                      <af:panelGroupLayout id="pgl13" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.SaftyStatusLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.cntrlExistingBookStChbx}"
                                          partialTriggers="sbc3"
                                          required="false"
                                          shortDesc="#{bindings.SaftyStatusLOV.hints.tooltip}"
                                          id="soc4">
                        <f:selectItems value="#{bindings.SaftyStatusLOV.items}"
                                       id="si4"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc3"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.cntrlExistingBookStChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                       <af:panelLabelAndMessage       label="وضعیت امانت"
                                                id="plam3">
                      <af:panelGroupLayout id="pgl14" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.LoanStatusLOV.inputValue}"
                                        disabled="#{viewScope.report_cataloging.cntrlExistingLoanStChbx}"
                                          partialTriggers="sbc4"
                                          required="false"
                                          shortDesc="#{bindings.LoanStatusLOV.hints.tooltip}"
                                          id="soc5">
                        <f:selectItems value="#{bindings.LoanStatusLOV.items}"
                                       id="si5"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc4"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.cntrlExistingLoanStChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:inputText label="تا تاریخ" id="it26"
                                    value="#{viewScope.report_cataloging.cntrlExistingToDate}"/>
                      
                       <af:panelLabelAndMessage    label="وضعیت موجودی" id="plam4">
                      <af:panelGroupLayout id="pgl15" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.ExistanceStatusLOV.inputValue}"
                                          disabled="#{viewScope.report_cataloging.cntrlExistingExistStChbx}"
                                          partialTriggers="sbc5"
                                          required="false"
                                          shortDesc="#{bindings.ExistanceStatusLOV.hints.tooltip}"
                                          id="soc6">
                        <f:selectItems value="#{bindings.ExistanceStatusLOV.items}"
                                       id="si6"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc5"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.cntrlExistingExistStChbx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:spacer width="10" height="10" id="s12"/>
                        <af:commandButton text="تهیه گزارش " id="cb2" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_cntl_existing.rdfP_AZ_TARIKH=#{viewScope.report_cataloging.cntrlExistingFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.cntrlExistingToDate}&P_PLACE=#{viewScope.report_cataloging.cntrlExistingPlaceChbx==true?'':(bindings.PlaceLOV.attributeValue)}&p_existence_status=#{viewScope.report_cataloging.cntrlExistingExistStChbx==true?'':(bindings.ExistanceStatusLOV.attributeValue)}&p_LOAN_STATUS=#{viewScope.report_cataloging.cntrlExistingLoanStChbx==true?'':(bindings.LoanStatusLOV.attributeValue)}&p_SAFETY_STATUS=#{viewScope.report_cataloging.cntrlExistingBookStChbx==true?'':(bindings.SaftyStatusLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>

                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                
                  <af:showDetailItem text="دفتر ثبت" id="sdi3">
                
                <af:panelGroupLayout id="pgl3" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s3"/>
                    <af:panelFormLayout id="pfl3" rows="4" maxColumns="2" labelWidth="150">
                      <af:inputText label="از شماره سریال" id="it3"
                                    value="#{viewScope.report_cataloging.bookNoskheFromArtId}"/>
                      <af:inputText label="از شماره ثبت" id="it4"
                      value="#{viewScope.report_cataloging.bookNoskheFromRegId}"/>
                       <af:panelLabelAndMessage    label="نوع زبان" id="plam5">
                      <af:panelGroupLayout id="pgl16" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.bookNoskheReadOrdChBx}"
                                          partialTriggers="sbc6"
                                          required="false"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc7" >
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si7"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc6"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookNoskheReadOrdChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                       <af:panelLabelAndMessage    label="محل نگهداری"
                                                id="plam6">
                      <af:panelGroupLayout id="pgl17" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.bookNoskhePlaceChBx}"
                                          partialTriggers="sbc7"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc8">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si8"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc7"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookNoskhePlaceChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:inputText label="تا شماره سریال" id="it5"
                      value="#{viewScope.report_cataloging.bookNoskheToArtId}"/>
                      <af:inputText label="تا شماره ثبت" id="it6"
                      value="#{viewScope.report_cataloging.bookNoskheToRegId}"/>
                      <af:inputText label="شماره راهنما" id="it7"
                      value="#{viewScope.report_cataloging.bookNoskheCallNo}"/>
                      
                       <af:commandButton text="تهیه گزارش " id="cb3" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_noskheh.rdf&P_PLACE=#{viewScope.report_cataloging.bookNoskhePlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.bookNoskheReadOrdChBx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&P_CALLNO_STR=#{viewScope.report_cataloging.bookNoskheCallNo}&P_reg_id1=#{viewScope.report_cataloging.bookNoskheFromRegId}&P_reg_id2=#{viewScope.report_cataloging.bookNoskheToRegId}&p_art_id1=#{viewScope.report_cataloging.bookNoskheFromArtId}&p_art_id2=#{viewScope.report_cataloging.bookNoskheToArtId}&labcol=#{sessionUser.labcol}&p_ord= order by ART_ID" to="#{viewScope.report_cataloging.reportPath}"/>
                        </af:commandButton>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="فهرست کتب وجین شده" id="sdi4">
                
                <af:panelGroupLayout id="pgl4" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s4"/>
                    <af:panelFormLayout id="pfl4" rows="3" maxColumns="2"
                                        labelWidth="150">
                        <af:inputText label="از تاریخ" id="it8"
                                      value="#{viewScope.report_cataloging.bookVejinFromDate}"/>
                      
                       <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam7">
                      <af:panelGroupLayout id="pgl18" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                          disabled="#{viewScope.report_cataloging.bookVejinPlaceChBx}"
                                          partialTriggers="sbc8"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc9">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si9"/>
                      </af:selectOneChoice>
                      <af:selectBooleanCheckbox text="انتخاب همه" id="sbc8"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookVejinPlaceChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:spacer width="10" height="10" id="s13"/>
                      <af:inputText label="تا تاریخ" id="it9"
                      value="#{viewScope.report_cataloging.bookVejinToDate}"/>
                      <af:inputText label="شماره راهنما" id="it10"
                      value="#{viewScope.report_cataloging.bookVejinCallNo}"
                                    styleClass="AFFieldTextLTRMarker"/>
                      
                      
                        <af:commandButton text="تهیه گزارش " id="cb4" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_vejin.rdf&P_AZ_TARIKH=#{viewScope.report_cataloging.bookVejinFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.bookVejinToDate}&P_PLACE=#{viewScope.report_cataloging.bookVejinPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&P_CALLNO_STR=#{viewScope.report_cataloging.bookVejinCallNo}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="فهرست کتب در دست صحافی" id="sdi5">
                
                <af:panelGroupLayout id="pgl5" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s5"/>
                    <af:panelFormLayout id="pfl5" rows="2" maxColumns="2"
                                        labelWidth="150">
                       <af:inputText label="از تاریخ" id="it11"
                       value="#{viewScope.report_cataloging.bookBindingFromDate}"/>
                        <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam8">
                      <af:panelGroupLayout id="pgl19" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                          disabled="#{viewScope.report_cataloging.bookBindingPlaceChBx}"
                                          partialTriggers="sbc9"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc10">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si10"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc9"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookBindingPlaceChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:inputText label="تا تاریخ" id="it12"
                      value="#{viewScope.report_cataloging.bookBindingToDate}"/> 
                      
                      <af:commandButton text="تهیه گزارش " id="cb5" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_binding.rdf&P_AZ_TARIKH=#{viewScope.report_cataloging.bookBindingFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.bookBindingToDate}&P_PLACE=#{viewScope.report_cataloging.bookBindingPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="فهرست نویسی کتب با وضعیت نامشخص" id="sdi6">
                
                <af:panelGroupLayout id="pgl6" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s6"/>
                    <af:panelFormLayout id="pfl6" rows="1" maxColumns="2"
                                        labelWidth="150">
                       <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam9">
                      <af:panelGroupLayout id="pgl20" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                            disabled="#{viewScope.report_cataloging.catalogingUndefiendPlaceChBx}"
                                          partialTriggers="sbc10"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc11">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si11"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc10"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.catalogingUndefiendPlaceChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:commandButton text="تهیه گزارش " id="cb6" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_notdefined.rdf&P_PLACE=#{viewScope.report_cataloging.catalogingUndefiendPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>               
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="فهرست کتب تک نسخه ای" id="sdi7">
                
                <af:panelGroupLayout id="pgl7" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s7"/>
                    <af:panelFormLayout id="pfl7" maxColumns="2" rows="1"
                                        labelWidth="150">
                       <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam10">
                      <af:panelGroupLayout id="pgl21" layout="horizontal">    
                     <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                            disabled="#{viewScope.report_cataloging.takNoskhePlaceChBx}"
                                          partialTriggers="sbc11"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc12">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si12"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc11"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.takNoskhePlaceChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                     <af:commandButton text="تهیه گزارش " id="cb7" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_single.rdf&P_PLACE=#{viewScope.report_cataloging.takNoskhePlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>       
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="لیست کتب آماده سازی شده" id="sdi8">
                
                <af:panelGroupLayout id="pgl8" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s8"/>
                      <af:panelFormLayout id="pfl8" rows="3" maxColumns="2"
                                        labelWidth="150">
                       <af:inputText label="از تاریخ" id="it13"
                                     value="#{viewScope.report_cataloging.bookListPreparedFromDate}"/>
                      
                        <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam11">
                      <af:panelGroupLayout id="pgl22" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                            disabled="#{viewScope.report_cataloging.bookListPreparedPlaceChBx}"
                                          partialTriggers="sbc12"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc13">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si13"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc12"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookListPreparedPlaceChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:spacer width="10" height="10" id="s15"/>
                      <af:inputText label="تا تاریخ" id="it14"
                                    value="#{viewScope.report_cataloging.bookListPreparedToDate}"/>
                     <af:panelLabelAndMessage     label="نوع زبان"
                                                id="plam12">
                      <af:panelGroupLayout id="pgl23" layout="horizontal">    
                     <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.bookListPreparedReadOrdChBx}"
                                          partialTriggers="sbc13"
                                          required="#{bindings.ReadingOrderLOV.hints.mandatory}"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc21">
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si21"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc13"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookListPreparedReadOrdChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:commandButton text="تهیه گزارش " id="cb8" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_list_prepared.rdf&P_AZ_TARIKH=#{viewScope.report_cataloging.bookListPreparedFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.bookListPreparedToDate}&P_PLACE=#{viewScope.report_cataloging.bookListPreparedPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.bookListPreparedReadOrdChBx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="آمار عنوان کتب آماده سازی شده" id="sdi9">
                
                <af:panelGroupLayout id="pgl9" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s9"/>
                    <af:panelFormLayout id="pfl9" rows="3" maxColumns="2"
                                        labelWidth="150">
                        <af:inputText label="از تاریخ" id="it15"
                        value="#{viewScope.report_cataloging.bookAmarOnvanFromDate}"/>
                      
                        <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam13">
                      <af:panelGroupLayout id="pgl24" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                         disabled="#{viewScope.report_cataloging.bookAmarPreparedPlaceChBx}"
                                          partialTriggers="sbc14"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc14">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si14"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc14"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookAmarPreparedPlaceChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:spacer width="10" height="10" id="s14"/>
                      <af:inputText label="تا تاریخ" id="it16"
                      value="#{viewScope.report_cataloging.bookAmarOnvanToDate}"/>
                        <af:panelLabelAndMessage     label="نوع زبان"
                                                id="plam14">
                      <af:panelGroupLayout id="pgl26" layout="horizontal">    
                       <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.bookAmarPreparedReadOrdChBx}"
                                          partialTriggers="sbc15"
                                          required="#{bindings.ReadingOrderLOV.hints.mandatory}"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc15">
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si15"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc15"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookAmarPreparedReadOrdChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                       <af:commandButton text="تهیه گزارش " id="cb9" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_amar_onvan_prepared.rdf&P_AZ_TARIKH=#{viewScope.report_cataloging.bookAmarOnvanFromDate}&P_TA_TARIKH=#{viewScope.report_cataloging.bookAmarOnvanToDate}&P_PLACE=#{viewScope.report_cataloging.bookAmarPreparedPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.bookAmarPreparedReadOrdChBx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="آمار عناوین کتاب بر حسب زبان" id="sdi10">
                
                <af:panelGroupLayout id="pgl10" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s10"/>
                   
                    <af:panelFormLayout id="pfl10" rows="1" maxColumns="3"
                                        labelWidth="150">
                     
                       <af:panelLabelAndMessage     label="محل نگهداری"
                                                id="plam16">
                      <af:panelGroupLayout id="pgl27" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.PlaceLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.bookTitleLangPlaceChBx}"
                                          partialTriggers="sbc16"
                                          required="false"
                                          shortDesc="#{bindings.PlaceLOV.hints.tooltip}"
                                          id="soc16">
                        <f:selectItems value="#{bindings.PlaceLOV.items}"
                                       id="si16"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc16"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookTitleLangPlaceChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                        <af:panelLabelAndMessage     label="نوع زبان"
                                                id="plam17">
                      <af:panelGroupLayout id="pgl28" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                          disabled="#{viewScope.report_cataloging.bookTitleLangReadOrdChBx}"
                                          partialTriggers="sbc17"
                                          required="#{bindings.ReadingOrderLOV.hints.mandatory}"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc17">
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si17"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc17"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.bookTitleLangReadOrdChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                      <af:commandButton text="تهیه گزارش " id="cb10" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_book_amar.rdf&P_PLACE=#{viewScope.report_cataloging.bookTitleLangPlaceChBx==true?'':(bindings.PlaceLOV.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.bookTitleLangReadOrdChBx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                      <f:facet name="footer"/>
                    </af:panelFormLayout>
                </af:panelGroupLayout>
                </af:showDetailItem>
                  <af:showDetailItem text="جستجوی کتاب" id="sdi11">
                
                <af:panelGroupLayout id="pgl11" layout="horizontal"
                                       valign="middle" halign="center">
                   
                   <af:spacer width="10" height="50" id="s11"/>
                    <af:panelFormLayout id="pfl11" maxColumns="2" rows="6"
                                        labelWidth="150">
                      <af:inputText label="یادداشت" id="it17"
                      value="#{viewScope.report_cataloging.searchBookNote}"/>
                      <af:inputText label="تاریخ نشر" id="it18"
                      value="#{viewScope.report_cataloging.searchBookPubDate}"/>
                      <af:inputText label="فروست" id="it19"
                      value="#{viewScope.report_cataloging.searchBookSeries}"/>
                      <af:inputText label="مولف" id="it20"
                      value="#{viewScope.report_cataloging.searchBookProvider}"/>
                      <af:inputText label="ناشر" id="it21"
                      value="#{viewScope.report_cataloging.searchBookProvider}"/>
                      <af:inputText label="محل نشر" id="it22"
                      value="#{viewScope.report_cataloging.searchBookPubPlace}"/>
                      <af:inputText label="شماره راهنما" id="it23"
                      value="#{viewScope.report_cataloging.searchBookCallNo}"/>
                      <af:inputText label="عنوان" id="it24"
                      value="#{viewScope.report_cataloging.searchBookTitle}"/>
                         <af:panelLabelAndMessage     label="نوع زبان"
                                                id="plam18">
                      <af:panelGroupLayout id="pgl29" layout="horizontal">    
                       <af:selectOneChoice value="#{bindings.ReadingOrderLOV.inputValue}"
                                          disabled="#{viewScope.report_cataloging.searchBookLangTypeChBx}"
                                          partialTriggers="sbc18"
                                          required="#{bindings.ReadingOrderLOV.hints.mandatory}"
                                          shortDesc="#{bindings.ReadingOrderLOV.hints.tooltip}"
                                          id="soc18">
                        <f:selectItems value="#{bindings.ReadingOrderLOV.items}"
                                       id="si18"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc18"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.searchBookLangTypeChBx}"/>
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                        <af:panelLabelAndMessage     label="زبان"
                                                id="plam19">
                      <af:panelGroupLayout id="pgl30" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.LanguageLOV.inputValue}"
                                           disabled="#{viewScope.report_cataloging.searchBookLangChBx}"
                                          partialTriggers="sbc19"
                                          required="false"
                                          shortDesc="#{bindings.LanguageLOV.hints.tooltip}"
                                          id="soc19">
                        <f:selectItems value="#{bindings.LanguageLOV.items}"
                                       id="si19"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc19"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.searchBookLangChBx}"/>
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      
                        <af:panelLabelAndMessage     label="نقش"
                                                id="plam20">
                      <af:panelGroupLayout id="pgl31" layout="horizontal">    
                      <af:selectOneChoice value="#{bindings.ProviderRoleVO1.inputValue}"
                                            disabled="#{viewScope.report_cataloging.searchBookRoleChBx}"
                                          partialTriggers="sbc20"
                                          required="false"
                                          shortDesc="#{bindings.ProviderRoleVO1.hints.tooltip}"
                                          id="soc20" >
                        <f:selectItems value="#{bindings.ProviderRoleVO1.items}"
                                       id="si20"/>
                      </af:selectOneChoice>
                       <af:selectBooleanCheckbox text="انتخاب همه" id="sbc20"
                                                    autoSubmit="true"
                                                    value="#{viewScope.report_cataloging.searchBookRoleChBx}"/>
                      
                      
                      </af:panelGroupLayout>
                      </af:panelLabelAndMessage>
                      <af:commandButton text="تهیه گزارش " id="cb11" action="#{viewScope.report_cataloging.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=r_search_book.rdf&P_TITLE=#{viewScope.report_cataloging.searchBookTitle}&P_PROVIDER=#{viewScope.report_cataloging.searchBookProvider}&P_PUBLISHER=#{viewScope.report_cataloging.searchBookPublisher}&P_PUB_PLACE=#{viewScope.report_cataloging.searchBookPubPlace}&P_PUB_DATE=#{viewScope.report_cataloging.searchBookPubDate}&P_NOTE=#{viewScope.report_cataloging.searchBookNote}&P_LANGUAGE=#{viewScope.report_cataloging.searchBookLangChBx==true?'':(bindings.LanguageLOV.attributeValue)}&P_CALLNO_STR=#{viewScope.report_cataloging.searchBookCallNo}&P_SERIES=#{viewScope.report_cataloging.searchBookSeries}&P_PROVIDER_ROLE=#{viewScope.report_cataloging.searchBookRoleChBx==true?'':(bindings.ProviderRoleVO1.attributeValue)}&P_READING_ORDER=#{viewScope.report_cataloging.searchBookLangTypeChBx==true?'':(bindings.ReadingOrderLOV.attributeValue)}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_cataloging.reportPath}"/>
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
                <af:goLink shortDesc="RTF"  destination="#{viewScope.report_cataloging.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{viewScope.report_cataloging.reportPath}&desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                  <af:image source="/icons/htmlcss.png"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{viewScope.report_cataloging.reportPath}&desformat=html" targetFrame="_blank">
                  <af:image source="/icons/html.png"  />
                  </af:goLink>
                     <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{viewScope.report_cataloging.reportPath}&desformat=xml" targetFrame="_blank">
                  <af:image source="/icons/xml.png"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{viewScope.report_cataloging.reportPath}&desformat=delimiteddata" targetFrame="_blank">
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