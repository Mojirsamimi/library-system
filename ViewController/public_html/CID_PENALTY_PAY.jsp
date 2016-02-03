<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
       ${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
                       
      <f:facet name="popup">
      
      <af:group>
        <af:popup  id="tf" contentDelivery="lazyUncached"
        
                binding="#{pageFlowScope.TFBean.region_popup}"
                  popupFetchListener="#{pageFlowScope.TFBean.popupOpen}">
      <af:panelWindow title="#{cid_penalty_payment.title}"
                      closeIconVisible="false">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigationWithoutRefresh}"
                  
                  binding="#{pageFlowScope.TFBean.tfRegion}"/>
      </af:panelWindow>
      </af:popup>
      
        <af:popup id="reportPop" childCreation="deferred" 
                  contentDelivery="lazyUncached">
                  <af:panelWindow title="انتخاب فرمت گزارش"  modal="true">
                  <af:panelGroupLayout layout="horizontal">
                  <af:goLink shortDesc="RTF"  destination="#{initParam.reportServer}#{cid_penalty_payment.reportPath}&desformat=rtf"
                           targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                              <af:image source="/icons/word.PNG"/>
                
                </af:goLink>
                  <af:goLink shortDesc="Html/CSS"  destination="#{initParam.reportServer}#{cid_penalty_payment.reportPath}&desformat=htmlcss" targetFrame="_blank"
                             inlineStyle="padding:10.0px;">
                  <af:image source="/icons/htmlcss.png"/>
                  </af:goLink>
                     <af:goLink shortDesc="Html" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{cid_penalty_payment.reportPath}&desformat=html" targetFrame="_blank">
                  <af:image source="/icons/html.png"  />
                  </af:goLink>
                     <af:goLink shortDesc="XML"  inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{cid_penalty_payment.reportPath}&desformat=xml" targetFrame="_blank">
                  <af:image source="/icons/xml.png"/>
                  </af:goLink>
                  <af:goLink shortDesc="CSV" inlineStyle="padding:10.0px;" destination="#{initParam.reportServer}#{cid_penalty_payment.reportPath}&desformat=delimiteddata" targetFrame="_blank">
                  <af:image source="/icons/csv.png"/>
                  </af:goLink>
                  </af:panelGroupLayout>
                  </af:panelWindow>
        </af:popup>
      </af:group>
       </f:facet>
                       
        <f:facet name="center">
          <af:panelHeader text="#{viewcontrollerBundle.payment}"
                          helpTopicId="penaltyPay">
         <f:facet name="toolbar">
          <af:toolbar id="t1">
                
                <fadak:ToolbarSet debug="true" iteratorname="PersonVO1Iterator" id="ts1"
                                    disabled_delete="true"
                                    disabled_create="true" showcreate="false"
                                    showdelete="false" showcommit="false"
                                  showEditCommand="false" showquery="false"
                                  showrefresh="false" showrollback="false"
                                  showsearch="false"/>

          </af:toolbar>
          
        
          </f:facet>
            <af:panelSplitter id="ps1" orientation="vertical"
                              splitterPosition="150">
              <f:facet name="first">
                <af:panelGroupLayout layout="vertical" id="pgl1">
                  <af:panelHeader text=" " id="ph1">
                    <af:query id="qryId1"
                              headerText="#{viewcontrollerBundle.mem_search}" disclosed="true"
                              value="#{bindings.searchnameidbarcodeQuery.queryDescriptor}"
                              model="#{bindings.searchnameidbarcodeQuery.queryModel}"
                              queryListener="#{bindings.searchnameidbarcodeQuery.processQuery}"
                              queryOperationListener="#{bindings.searchnameidbarcodeQuery.processQueryOperation}"
                              rows="2" maxColumns="2" saveQueryMode="hidden"
                              modeChangeVisible="false"/>
                  </af:panelHeader>
                </af:panelGroupLayout>
              </f:facet>
              <f:facet name="second">
                <af:panelBox text=" " id="pb1" showDisclosure="false">
                  <f:facet name="toolbar"/>
                  <af:panelGroupLayout id="pgl2" layout="vertical"
                                       valign="middle" halign="center"
                                       partialTriggers="qryId1">
                    <af:panelFormLayout id="pfl1" rows="1">
                      <af:inputText value="#{bindings.Id.inputValue}"
                                    label="#{bindings.Id.hints.label}"
                                    required="#{bindings.Id.hints.mandatory}"
                                    columns="#{bindings.Id.hints.displayWidth}"
                                    maximumLength="#{bindings.Id.hints.precision}"
                                    shortDesc="#{bindings.Id.hints.tooltip}"
                                    id="it1" readOnly="true">
                        <f:validator binding="#{bindings.Id.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Barcode.inputValue}"
                                    label="#{bindings.Barcode.hints.label}"
                                    required="#{bindings.Barcode.hints.mandatory}"
                                    columns="#{bindings.Barcode.hints.displayWidth}"
                                    maximumLength="#{bindings.Barcode.hints.precision}"
                                    shortDesc="#{bindings.Barcode.hints.tooltip}"
                                    id="it2" readOnly="true">
                        <f:validator binding="#{bindings.Barcode.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Fname.inputValue}"
                                    label="#{bindings.Fname.hints.label}"
                                    required="#{bindings.Fname.hints.mandatory}"
                                    columns="#{bindings.Fname.hints.displayWidth}"
                                    maximumLength="#{bindings.Fname.hints.precision}"
                                    shortDesc="#{bindings.Fname.hints.tooltip}"
                                    id="it3" readOnly="true">
                        <f:validator binding="#{bindings.Fname.validator}"/>
                      </af:inputText>
                      <af:inputText value="#{bindings.Lname.inputValue}"
                                    label="#{bindings.Lname.hints.label}"
                                    required="#{bindings.Lname.hints.mandatory}"
                                    columns="#{bindings.Lname.hints.displayWidth}"
                                    maximumLength="#{bindings.Lname.hints.precision}"
                                    shortDesc="#{bindings.Lname.hints.tooltip}"
                                    id="it4" readOnly="true">
                        <f:validator binding="#{bindings.Lname.validator}"/>
                      </af:inputText>
                      <af:selectOneChoice value="#{bindings.MemshipStatus.inputValue}"
                                          label="#{bindings.MemshipStatus.label}"
                                          required="#{bindings.MemshipStatus.hints.mandatory}"
                                          shortDesc="#{bindings.MemshipStatus.hints.tooltip}"
                                          id="soc1" readOnly="true">
                        <f:selectItems value="#{bindings.MemshipStatus.items}"
                                       id="si1"/>
                      </af:selectOneChoice>
                      <af:inputText value="#{bindings.DebitSum.inputValue}"
                                    label="#{bindings.DebitSum.hints.label}"
                                    required="#{bindings.DebitSum.hints.mandatory}"
                                    columns="#{bindings.DebitSum.hints.displayWidth}"
                                    maximumLength="#{bindings.DebitSum.hints.precision}"
                                    shortDesc="#{bindings.DebitSum.hints.tooltip}"
                                    id="it5" readOnly="true">
                        <f:validator binding="#{bindings.DebitSum.validator}"/>
                        <af:convertNumber groupingUsed="false"
                                          pattern="#{bindings.DebitSum.format}"/>
                      </af:inputText>
                    </af:panelFormLayout>
                    
                    
                    <af:spacer width="10" height="10" id="s1"/>
                    <af:panelCollection id="pc1"
                                        inlineStyle="width:70%; height:200.0px;"
                                        defaultToolbarItemDisplay="icon">
                      <af:table value="#{bindings.PenaltyPaymentVO1.collectionModel}"
                                var="row"
                                rows="#{bindings.PenaltyPaymentVO1.rangeSize}"
                                emptyText="#{bindings.PenaltyPaymentVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                fetchSize="#{bindings.PenaltyPaymentVO1.rangeSize}"
                                rowBandingInterval="0"
                                filterModel="#{bindings.PenaltyPaymentVO1Query.queryDescriptor}"
                                queryListener="#{bindings.PenaltyPaymentVO1Query.processQuery}"
                                filterVisible="true" varStatus="vs"
                                selectedRowKeys="#{bindings.PenaltyPaymentVO1.collectionModel.selectedRow}"
                                selectionListener="#{bindings.PenaltyPaymentVO1.collectionModel.makeCurrent}"
                                rowSelection="single" id="t2"
                                columnStretching="column:c1"
                                partialTriggers=":::tf :::r1">
                        <af:column sortProperty="DayDate" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PenaltyPaymentVO1.hints.DayDate.label}"
                                   id="c2">
                          <af:outputText value="#{row.DayDate}" id="ot4">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.PenaltyPaymentVO1.hints.DayDate.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Value" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PenaltyPaymentVO1.hints.Value.label}"
                                   id="c3">
                          <af:outputText value="#{row.Value}" id="ot3">
                            <af:convertNumber groupingUsed="false"
                                              pattern="#{bindings.PenaltyPaymentVO1.hints.Value.format}"/>
                          </af:outputText>
                        </af:column>
                        <af:column sortProperty="Description" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PenaltyPaymentVO1.hints.Description.label}"
                                   id="c1">
                          <af:outputText value="#{row.Description}" id="ot2"/>
                        </af:column>
                        <af:column sortProperty="UserName" filterable="true"
                                   sortable="true"
                                   headerText="#{bindings.PenaltyPaymentVO1.hints.UserName.label}"
                                   id="c4">
                          <af:outputText value="#{row.UserName}" id="ot1"/>
                        </af:column>
                      </af:table>
                      <f:facet name="menus"/>
                      <f:facet name="toolbar"/>
                      <f:facet name="statusbar"/>
                      <f:facet name="secondaryToolbar">
                       
                          <af:toolbar id="t3">
                          <af:commandImageLink action="#{pageFlowScope.TFBean.penaltyPayment}"
                                           disabled="#{bindings.ArtId1.inputValue==null}"
                                            icon="/icons/list-add.png"
                                            shortDesc="ثبت جریمه"
                                            partialSubmit="true" id="cil1">
                            <af:setActionListener from="#{'new'}"
                                                  to="#{cid_penalty_payment.path}"/>
                            <af:setActionListener from="#{'ایجاد جریمه'}"
                                                  to="#{cid_penalty_payment.title}"/>
                          </af:commandImageLink>
                          <af:commandImageLink action="#{pageFlowScope.TFBean.penaltyPayment}"
                                          disabled="#{bindings.PenaltyPaymentVO1.currentRow==null}"
                                            icon="/icons/list-edit.png"
                                            shortDesc="ویرایش جریمه"
                                            partialSubmit="true" id="cil2">
                            <af:setActionListener from="#{'edit'}"
                                                  to="#{cid_penalty_payment.path}"/>
                            <af:setActionListener from="#{'ویرایش جریمه'}"
                                                  to="#{cid_penalty_payment.title}"/>
                          </af:commandImageLink>
                          <af:commandButton text="چاپ" id="cb2"
                          disabled="#{bindings.PenaltyPaymentVO1.currentRow==null}"
                                              action="#{cid_penalty_payment.showReportPopUp}">
                              <af:setActionListener from="/reports/rwservlet?utdbuser&destype=cache&report=penalty_payment.rdf&P_art=#{bindings.ArtId.inputValue}&labcol=#{sessionUser.labcol}"
                                                    to="#{cid_penalty_payment.reportPath}"/>
                            </af:commandButton>
                          </af:toolbar>
                     
                      </f:facet>
                    </af:panelCollection>
                  </af:panelGroupLayout>
                </af:panelBox>
              </f:facet>
            </af:panelSplitter>
          </af:panelHeader>
        </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>