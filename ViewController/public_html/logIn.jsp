<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<f:view locale="ar">
  <af:document id="d1" >
    <af:messages id="m1"/>
    <af:form id="f1" defaultCommand="cb2">
     
       
        <af:panelStretchLayout id="psl1" bottomHeight="20px" topHeight="100px"
                               startWidth="0px" endWidth="0px">
         
          
          
          <f:facet name="top">
         
                                <af:panelBox text=" " id="pb1"
                                             showDisclosure="false">
                    <f:facet name="toolbar"/>
            <af:panelGroupLayout id="pgl4" layout="vertical" valign="middle"
                                 halign="center">
             
            </af:panelGroupLayout>
          </af:panelBox>
          
          
        </f:facet>
       <f:facet name="center">
          
            <af:decorativeBox id="db1" theme="dark"  centerLandmark="main">
              <f:facet name="center">
              
               <af:decorativeBox id="db2" theme="light"  centerLandmark="main">
              <f:facet name="center">
              
            <af:panelHeader text="ورود به سیستم جامع کتابخانه" id="ph1">
              <af:panelGroupLayout id="pgl2" layout="vertical" valign="middle"
                                   halign="center">
                               <af:spacer width="10" height="80" id="s2"/>
             
                <af:panelBox text="مشخصات کاربر" id="pb2" titleHalign="right"
                             inlineStyle="width:300.0px; height:200px;"
                             showDisclosure="false">
                  <af:panelFormLayout id="pfl1">
                          <af:selectOneRadio label="نوع ورود" id="sor1" value="1"
                                             binding="#{viewScope.login_bean.persCategorySOR}"
                                             autoSubmit="true"
                                             valueChangeListener="#{viewScope.login_bean.userNameChangeListener}">
                            <af:selectItem label="مسئول کتابخانه" value="1" id="si1"/>
                            <af:selectItem label="دانشجو" value="2" id="si3" disabled="false"/>
                            <af:selectItem label="کارمندان و اعضای هيات علمی" value="3" id="si4" disabled="false"/>
                             <af:selectItem label="اعضای غیر رسمی" value="4" id="si5" disabled="false"/>
                          </af:selectOneRadio>
                          <af:inputText label="نام کاربری" id="it1"
                                  autoSubmit="true"
                                  valueChangeListener="#{viewScope.login_bean.userNameChangeListener}"
                                  binding="#{viewScope.login_bean.loginUsername}"/>
                          <af:panelLabelAndMessage  label="#{bindings.Library2.label}" id="plam1"
                                                   >
                            <af:panelGroupLayout id="pgl3" layout="horizontal">
                              <af:selectOneChoice value="#{bindings.Library2.inputValue}"
                                                 required="#{bindings.Library2.hints.mandatory}"
                                                  shortDesc="#{bindings.Library2.hints.tooltip}"
                                                  id="soc2"
                                                  partialTriggers="it1 sor1"
                                                  binding="#{viewScope.login_bean.labcolSelectOneChoice}"
                                                simple="true"
                                                visible="#{viewScope.login_bean.persCategorySOR.value=='1'}"
                                                 inlineStyle="padding:6px; "
                                                  contentStyle="width:150px;">
                                <f:selectItems value="#{bindings.Library2.items}"
                                               id="si2"/>
                              </af:selectOneChoice>
                              <af:selectOneChoice value="#{bindings.InitMemberVO_Login.inputValue}"
                                                  label="#{bindings.InitMemberVO_Login.label}"
                                                  required="#{bindings.InitMemberVO_Login.hints.mandatory}"
                                                   simple="true"
                                                  shortDesc="#{bindings.InitMemberVO_Login.hints.tooltip}"
                                                  id="soc1"
                                                   partialTriggers="it1 sor1"
                                                    inlineStyle="padding:6px; "
                                                  contentStyle="width:150px;"
                                                  visible="#{viewScope.login_bean.persCategorySOR.value!='1'}">
                                <f:selectItems value="#{bindings.InitMemberVO_Login.items}"
                                               id="si6"/>
                              </af:selectOneChoice>
                              <af:commandImageLink text="" id="cil1"
                                                   icon="/icons/view-refresh.png"
                                                   actionListener="#{viewScope.login_bean.refreshLibraryActionListener}"/>
                            </af:panelGroupLayout>
                          </af:panelLabelAndMessage>
                          <af:inputText label="رمز عبور" id="it2"
                                   secret="true"
                                        binding="#{viewScope.login_bean.loginPassword}"/>
                    <f:facet name="footer">
                      <af:panelGroupLayout id="pgl1" valign="middle"
                                           halign="center" layout="vertical">
                        <af:commandButton text="ورود به سیستم" id="cb2"
                                          action="#{viewScope.login_bean.loginAction}"/>
                      </af:panelGroupLayout>
                    </f:facet>
                  </af:panelFormLayout>
                        <f:facet name="toolbar">
                         
                        </f:facet>
                      </af:panelBox>
              </af:panelGroupLayout>
            </af:panelHeader>
              </f:facet>
            </af:decorativeBox>
          </f:facet>
            </af:decorativeBox>
        </f:facet>
         <f:facet name="bottom">
         <af:panelStretchLayout id="pt_psl2" startWidth="200px"
                                 endWidth="600px" bottomHeight="1px">
            <f:facet name="center">
              <af:panelGroupLayout inlineStyle="text-align:left" valign="middle"
                                   halign="end">
                <af:outputFormatted value="Copyright &amp;copy; Parsi Group, Inc. All rights reserved "
                                    id="pt_of1" styleUsage="pageStamp"/>
              </af:panelGroupLayout>
            </f:facet>
            <f:facet name="start">
              <af:panelGroupLayout inlineStyle="text-align:right" halign="end"
                                   valign="middle">
                <af:outputFormatted value="www.parsisys.org  " id="pt_of2"
                                    styleUsage="pageStamp"/>
              </af:panelGroupLayout>
            </f:facet>
            <f:facet name="end"/>
           
          </af:panelStretchLayout>
         </f:facet>
        
         </af:panelStretchLayout>
     
        
    </af:form>
  </af:document>
</f:view>