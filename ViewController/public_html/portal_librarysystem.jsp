<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
${sessionUser.authorization}
<f:view>
  <af:document id="d1">
    <af:form id="f1">
      <af:pageTemplate viewId="/template/PortalUTemplate.jspx" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="سیستم اینترنتی کتابخانه">
            <af:panelFormLayout id="pfl1">
              <af:commandLink text="تمدید کتاب" id="cl2" action="loan"/>
              <af:commandLink text="رزرو کتاب" id="cl1" action="reserve"/>
              <f:facet name="footer"/>
            </af:panelFormLayout>
          </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>