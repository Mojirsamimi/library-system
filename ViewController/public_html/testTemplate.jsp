<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
${sessionUser.authorization}
<f:view locale="en">
  <af:document id="d1">
    <af:form id="f1">
      <af:pageTemplate viewId="/template/EnUTtemplate.jspx" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="Provider refers">
         <af:panelTabbed id="pt2" clientComponent="false">
              <af:showDetailItem text="See Provider" id="sdi1" stretchChildren="first">
                <f:facet name="toolbar"/>
                <af:panelSplitter id="ps2" orientation="vertical"
                                  splitterPosition="180">
                  <f:facet name="first">
                    <af:panelGroupLayout layout="vertical" id="pgl3">
                      <af:panelHeader text=" " id="ph2">
                      
                        <f:facet name="toolbar">
                        
                        <af:toolbar id="t1">
                           
                            <fadak:ToolbarSet iteratorname="LatinMainSeeProviderIterator"
                                              id="ts1" showquery="false"
                                              showcommit="false"
                                              showcreate="false"
                                              showdelete="false"
                                              showEditCommand="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"
                                              lang="english"/>
                          </af:toolbar>
                        </f:facet>
                      </af:panelHeader>
                    </af:panelGroupLayout>
                  </f:facet>
                  <f:facet name="second">
                    <af:panelBox text=" " id="pb1" showDisclosure="false">
                      <f:facet name="toolbar"/>
                      <af:panelGroupLayout id="pgl2" layout="vertical"
                                           valign="middle" halign="center"
                                        >
                        <af:panelFormLayout id="pfl2" rows="1" maxColumns="4">
                         
                        </af:panelFormLayout>
                        <af:spacer width="10" height="10" id="s1"/>
                        <af:panelCollection id="pc1"
                                            inlineStyle="width:60%; height:150.0px;">
                        
                          <f:facet name="menus"/>
                          <f:facet name="toolbar"/>
                          <f:facet name="statusbar"/>
                       
                        </af:panelCollection>
                      </af:panelGroupLayout>
                    </af:panelBox>
                  </f:facet>
                </af:panelSplitter>
              </af:showDetailItem>
             
            </af:panelTabbed>
        
        </af:panelHeader>
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>