<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<f:view locale="ar">
  <af:document id="d1">
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="تازه ها" helpTopicId="reportRecent">
            <af:panelBox text=" " id="pb1">
              <af:panelAccordion id="pa1">
                <af:showDetailItem text="تازه هاي کتاب فارسي" id="sdi1">
                 <af:panelGroupLayout id="pgl1" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s1"/>
                    <af:panelFormLayout id="pfl1" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it1"
                                    value="#{viewScope.report_recent.newPersianFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it2"
                                    value="#{viewScope.report_recent.newPersianToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb1" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_new_persian.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newPersianFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newPersianToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                <af:showDetailItem text="نمايه عنوان فارسي" id="sdi2">
                
                 <af:panelGroupLayout id="pgl2" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s2"/>
                    <af:panelFormLayout id="pfl2" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it3"
                                    value="#{viewScope.report_recent.newPersianTitleFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it4"
                                    value="#{viewScope.report_recent.newPersianTitleToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb2" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_NEW_PERSIAN_TITLE.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newPersianTitleFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newPersianTitleToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
              
                </af:showDetailItem>
                <af:showDetailItem text="نمايه نويسنده فارسي" id="sdi3">
                 <af:panelGroupLayout id="pgl3" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s3"/>
                    <af:panelFormLayout id="pfl3" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it5"
                                    value="#{viewScope.report_recent.newPersianProviderFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it6"
                                    value="#{viewScope.report_recent.newPersianProviderToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb3" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_NEW_PERSIAN_PROVDR.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newPersianProviderFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newPersianProviderToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                </af:showDetailItem>
                <af:showDetailItem text="تازه هاي کتاب لاتين" id="sdi4">
                
                
                 <af:panelGroupLayout id="pgl4" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s4"/>
                    <af:panelFormLayout id="pfl4" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it7"
                                    value="#{viewScope.report_recent.newLatinFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it8"
                                    value="#{viewScope.report_recent.newLatinToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb4" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_new_latin.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newLatinFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newLatinToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                
                </af:showDetailItem>
                 
                 <af:showDetailItem text="نمايه عنوان لاتين" id="sdi5">
                
                
                 <af:panelGroupLayout id="pgl5" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s5"/>
                    <af:panelFormLayout id="pfl5" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it9"
                                    value="#{viewScope.report_recent.newLatinTitleFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it10"
                                    value="#{viewScope.report_recent.newLatinTitleToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb5" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_new_latin_title.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newLatinTitleFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newLatinTitleToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
                       </af:commandButton>
                      
                       
                      <f:facet name="footer"/>
                       
                    </af:panelFormLayout>
                  </af:panelGroupLayout>
                
                </af:showDetailItem>
                
                 <af:showDetailItem text="نمايه نویسنده لاتين" id="sdi6">
                
                
                 <af:panelGroupLayout id="pgl6" layout="horizontal"
                                       valign="middle" halign="start">
                    <af:spacer width="10" height="50" id="s6"/>
                    <af:panelFormLayout id="pfl6" rows="2" maxColumns="2"
                                        fieldWidth="200" labelWidth="100">
                      <af:inputText label="از تاریخ" id="it11"
                                    value="#{viewScope.report_recent.newLatinProviderFromDate}"/>

                      <af:inputText label="تا تاریخ" id="it12"
                                    value="#{viewScope.report_recent.newLatinProviderToDate}"/>
                                          
                      <af:commandButton text="تهیه گزارش " id="cb6" action="#{viewScope.report_recent.runReport}">
                       <af:setActionListener from="#{initParam.reportServer}/reports/rwservlet?utdbuser&destype=cache&report=R_new_latin_provdr.rdf&P_AZ_TARIKH=#{viewScope.report_recent.newLatinProviderFromDate}&P_TA_TARIKH=#{viewScope.report_recent.newLatinProviderToDate}&labcol=#{sessionUser.labcol}" to="#{viewScope.report_recent.reportPath}"/>
                                                                                                                    
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
                   <af:goLink shortDesc="RTF" destination="#{viewScope.report_recent.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{viewScope.report_recent.reportPath}&desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                  <af:image source="/icons/htmlcss.png"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{viewScope.report_recent.reportPath}&desformat=html" targetFrame="_blank">
                  <af:image source="/icons/html.png"  />
                  </af:goLink>
                     <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{viewScope.report_recent.reportPath}&desformat=xml" targetFrame="_blank">
                  <af:image source="/icons/xml.png"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{viewScope.report_recent.reportPath}&desformat=delimiteddata" targetFrame="_blank">
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