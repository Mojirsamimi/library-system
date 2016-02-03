<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/fadak" prefix="fadak"%>
<c:set var="viewcontrollerBundle"
       value="#{adfBundle['org.parsisys.tehranuniversity.library.view.UTBundle']}"/>
${sessionUser.authorization}
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/PortalUTemplate.jspx" id="pt1">
        <f:facet name="popup">
        <af:popup  id="tf" contentDelivery="lazyUncached"
                binding="#{pageFlowScope.TFBean.region_popup}"
                  autoCancel="disabled">
      <af:panelWindow title="#{ReserveTitle.popupTitle}"
                      partialTriggers="cb3 cb1" id="pw1"
                      
                      stretchChildren="first" contentHeight="400"
                      contentWidth="500" inlineStyle="text-align:center;"
                      closeIconVisible="false" modal="true">
       <af:region value="#{bindings.dynamicRegion1.regionModel}" id="r1"
                  regionNavigationListener="#{pageFlowScope.TFBean.navigation}"
                  
                  />
      </af:panelWindow>
      
      </af:popup>  
       </f:facet>
          <f:facet name="center">
          <af:panelHeader text="رزرو کتاب" id="ph2" type="stretch">
            <f:facet name="toolbar">
       
         
         </f:facet>
            <af:panelGroupLayout id="pgl3" layout="scroll">
              <af:panelBox text="مشخصات عضو" id="pb2">
                <af:panelFormLayout id="pfl4" rows="4" maxColumns="10">
                  <af:inputText value="#{bindings.Barcode.inputValue}"
                                label="#{bindings.Barcode.hints.label}"
                                required="#{bindings.Barcode.hints.mandatory}"
                                columns="#{bindings.Barcode.hints.displayWidth}"
                                maximumLength="#{bindings.Barcode.hints.precision}"
                                shortDesc="#{bindings.Barcode.hints.tooltip}"
                                id="it7"
                                readOnly="true">
                    <f:validator binding="#{bindings.Barcode.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.Fname.inputValue}"
                                label="#{bindings.Fname.hints.label}"
                                required="#{bindings.Fname.hints.mandatory}"
                                columns="#{bindings.Fname.hints.displayWidth}"
                                maximumLength="#{bindings.Fname.hints.precision}"
                                shortDesc="#{bindings.Fname.hints.tooltip}"
                                id="it8"
                                  readOnly="true">
                    <f:validator binding="#{bindings.Fname.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.Lname.inputValue}"
                                label="#{bindings.Lname.hints.label}"
                                required="#{bindings.Lname.hints.mandatory}"
                                columns="#{bindings.Lname.hints.displayWidth}"
                                maximumLength="#{bindings.Lname.hints.precision}"
                                shortDesc="#{bindings.Lname.hints.tooltip}"
                                id="it5"
                                  readOnly="true">
                    <f:validator binding="#{bindings.Lname.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.CertificateNo.inputValue}"
                                label="#{bindings.CertificateNo.hints.label}"
                                required="#{bindings.CertificateNo.hints.mandatory}"
                                columns="#{bindings.CertificateNo.hints.displayWidth}"
                                maximumLength="#{bindings.CertificateNo.hints.precision}"
                                shortDesc="#{bindings.CertificateNo.hints.tooltip}"
                                id="it9"
                                  readOnly="true">
                    <f:validator binding="#{bindings.CertificateNo.validator}"/>
                  </af:inputText>
                  <af:selectOneChoice value="#{bindings.Origine.inputValue}"
                                      label="#{bindings.Origine.label}"
                                      required="#{bindings.Origine.hints.mandatory}"
                                      shortDesc="#{bindings.Origine.hints.tooltip}"
                                      id="soc6"   readOnly="true">
                    <f:selectItems value="#{bindings.Origine.items}" id="si1"/>
                  </af:selectOneChoice>
                  <af:inputText value="#{bindings.Id.inputValue}"
                                label="#{bindings.Id.hints.label}"
                                required="#{bindings.Id.hints.mandatory}"
                                columns="#{bindings.Id.hints.displayWidth}"
                                maximumLength="#{bindings.Id.hints.precision}"
                                shortDesc="#{bindings.Id.hints.tooltip}"
                                id="it11"   readOnly="true">
                    <f:validator binding="#{bindings.Id.validator}"/>
                  </af:inputText>
                  <af:inputListOfValues id="affiliationId"
                                        popupTitle="Search and Select: #{bindings.Affiliation.hints.label}"
                                        value="#{bindings.Affiliation.inputValue}"
                                        label="#{bindings.Affiliation.hints.label}"
                                        model="#{bindings.Affiliation.listOfValuesModel}"
                                        required="#{bindings.Affiliation.hints.mandatory}"
                                        columns="#{bindings.Affiliation.hints.displayWidth}"
                                        shortDesc="#{bindings.Affiliation.hints.tooltip}"
                                          readOnly="true">
                    <f:validator binding="#{bindings.Affiliation.validator}"/>
                  </af:inputListOfValues>
                  <af:selectOneChoice value="#{bindings.PersType.inputValue}"
                                      label="#{bindings.PersType.label}"
                                      required="#{bindings.PersType.hints.mandatory}"
                                      shortDesc="#{bindings.PersType.hints.tooltip}"
                                      id="soc5"   readOnly="true">
                    <f:selectItems value="#{bindings.PersType.items}" id="si7"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.Degree.inputValue}"
                                      label="#{bindings.Degree.label}"
                                      required="#{bindings.Degree.hints.mandatory}"
                                      shortDesc="#{bindings.Degree.hints.tooltip}"
                                      id="soc2"   readOnly="true">
                    <f:selectItems value="#{bindings.Degree.items}" id="si2"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.PersStatus.inputValue}"
                                      label="#{bindings.PersStatus.label}"
                                      required="#{bindings.PersStatus.hints.mandatory}"
                                      shortDesc="#{bindings.PersStatus.hints.tooltip}"
                                      id="soc9"   readOnly="true">
                    <f:selectItems value="#{bindings.PersStatus.items}"
                                   id="si9"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.SecArtId.inputValue}"
                                      label="#{bindings.SecArtId.label}"
                                      required="#{bindings.SecArtId.hints.mandatory}"
                                      shortDesc="#{bindings.SecArtId.hints.tooltip}"
                                      id="soc3"   readOnly="true">
                    <f:selectItems value="#{bindings.SecArtId.items}" id="si3"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.PersCategory.inputValue}"
                                      label="#{bindings.PersCategory.label}"
                                      required="#{bindings.PersCategory.hints.mandatory}"
                                      shortDesc="#{bindings.PersCategory.hints.tooltip}"
                                      id="soc7"   readOnly="true">
                    <f:selectItems value="#{bindings.PersCategory.items}"
                                   id="si8"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.MjrArtId.inputValue}"
                                      label="#{bindings.MjrArtId.label}"
                                      required="#{bindings.MjrArtId.hints.mandatory}"
                                      shortDesc="#{bindings.MjrArtId.hints.tooltip}"
                                      id="soc4"   readOnly="true">
                    <f:selectItems value="#{bindings.MjrArtId.items}" id="si6"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.CmemsetupArtId.inputValue}"
                                      label="#{bindings.CmemsetupArtId.label}"
                                      required="#{bindings.CmemsetupArtId.hints.mandatory}"
                                      shortDesc="#{bindings.CmemsetupArtId.hints.tooltip}"
                                      id="soc8"   readOnly="true">
                    <f:selectItems value="#{bindings.CmemsetupArtId.items}"
                                   id="si5"/>
                  </af:selectOneChoice>
                  <af:selectOneChoice value="#{bindings.DeptArtId.inputValue}"
                                      label="#{bindings.DeptArtId.label}"
                                      required="#{bindings.DeptArtId.hints.mandatory}"
                                      shortDesc="#{bindings.DeptArtId.hints.tooltip}"
                                      id="soc1"    readOnly="true">
                    <f:selectItems value="#{bindings.DeptArtId.items}"
                                   id="si4"/>
                  </af:selectOneChoice>
                  <af:inputText value="#{bindings.Email.inputValue}"
                                label="#{bindings.Email.hints.label}"
                                required="#{bindings.Email.hints.mandatory}"
                                columns="#{bindings.Email.hints.displayWidth}"
                                maximumLength="#{bindings.Email.hints.precision}"
                                shortDesc="#{bindings.Email.hints.tooltip}"
                                id="it6"   readOnly="true" partialTriggers="r1">
                    <f:validator binding="#{bindings.Email.validator}"/>
                  </af:inputText>
                  <af:inputText value="#{bindings.Description.inputValue}"
                                label="#{bindings.Description.hints.label}"
                                required="#{bindings.Description.hints.mandatory}"
                                columns="#{bindings.Description.hints.displayWidth}"
                                maximumLength="#{bindings.Description.hints.precision}"
                                shortDesc="#{bindings.Description.hints.tooltip}"
                                id="it10"   readOnly="true">
                    <f:validator binding="#{bindings.Description.validator}"/>
                  </af:inputText>
                </af:panelFormLayout>
                <f:facet name="toolbar"/>
              </af:panelBox>
              <af:panelSplitter id="ps1" orientation="vertical"
                                splitterPosition="150"
                                styleClass="AFStretchWidth"
                                inlineStyle="height:500.0px;">
                <f:facet name="first">
                  <af:panelGroupLayout layout="vertical" id="pgl1">
                    <af:panelHeader text=" " id="ph1">
                      <af:query id="qryId1" headerText="جستجوی کتاب"
                                disclosed="true"
                                value="#{bindings.SearchCallNoArtIdTitleVCQuery.queryDescriptor}"
                                model="#{bindings.SearchCallNoArtIdTitleVCQuery.queryModel}"
                                queryListener="#{viewScope.cid_reserve.search_virtual_book}"
                                queryOperationListener="#{bindings.SearchCallNoArtIdTitleVCQuery.processQueryOperation}"
                                rows="2" maxColumns="2"
                                modeChangeVisible="false"
                                saveQueryMode="hidden"/>
                    </af:panelHeader>
                  </af:panelGroupLayout>
                </f:facet>
                <f:facet name="second">
                  <af:panelBox text=" " id="pb1" showDisclosure="false"
                            >
                    <f:facet name="toolbar">
                     <af:toolbar id="t1">
                            <fadak:ToolbarSet debug="true" iteratorname="VirtualBookVO1Iterator" id="ts1"
                                              showdelete="false"
                                              showcreate="false"
                                              showEditCommand="false"
                                              showcommit="false"
                                              showquery="false"
                                              showrefresh="false"
                                              showrollback="false"
                                              showsearch="false"/>

          </af:toolbar>
                    </f:facet>
                    <af:panelGroupLayout id="pgl2" layout="scroll"
                                         valign="middle" halign="center"
                                         partialTriggers="qryId1"
                                        >
                      <af:panelFormLayout id="pfl1" rows="2" maxColumns="3"
                                          labelWidth="100">
                        <af:inputText value="#{bindings.CallNo.inputValue}"
                                      label="#{bindings.CallNo.hints.label}"
                                      required="#{bindings.CallNo.hints.mandatory}"
                                      columns="#{bindings.CallNo.hints.displayWidth}"
                                      maximumLength="#{bindings.CallNo.hints.precision}"
                                      shortDesc="#{bindings.CallNo.hints.tooltip}"
                                      id="it3" readOnly="true"  partialTriggers="qryId1"
                                      styleClass="AFFieldTextLTRMarker">
                          <f:validator binding="#{bindings.CallNo.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.Title.inputValue}"
                                      label="#{bindings.Title.hints.label}"
                                      required="#{bindings.Title.hints.mandatory}"
                                      columns="#{bindings.Title.hints.displayWidth}"
                                      maximumLength="#{bindings.Title.hints.precision}"
                                      shortDesc="#{bindings.Title.hints.tooltip}"
                                      id="it4" readOnly="true" partialTriggers="qryId1">
                          <f:validator binding="#{bindings.Title.validator}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.VbookCNT.inputValue}"
                                      label="#{bindings.VbookCNT.hints.label}"
                                      required="#{bindings.VbookCNT.hints.mandatory}"
                                      columns="#{bindings.VbookCNT.hints.displayWidth}"
                                      maximumLength="#{bindings.VbookCNT.hints.precision}"
                                      shortDesc="#{bindings.VbookCNT.hints.tooltip}"
                                      id="it12" readOnly="true"  partialTriggers="qryId1">
                          <f:validator binding="#{bindings.VbookCNT.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.VbookCNT.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.ArtId.inputValue}"
                                      label="#{bindings.ArtId.hints.label}"
                                      required="#{bindings.ArtId.hints.mandatory}"
                                      columns="#{bindings.ArtId.hints.displayWidth}"
                                      maximumLength="#{bindings.ArtId.hints.precision}"
                                      shortDesc="#{bindings.ArtId.hints.tooltip}"
                                      id="it1" readOnly="true">
                          <f:validator binding="#{bindings.ArtId.validator}"/>
                          <af:convertNumber groupingUsed="false"
                                            pattern="#{bindings.ArtId.format}"/>
                        </af:inputText>
                        <af:inputText value="#{bindings.ProviderName.inputValue}"
                                      label="#{bindings.ProviderName.hints.label}"
                                      required="#{bindings.ProviderName.hints.mandatory}"
                                      columns="#{bindings.ProviderName.hints.displayWidth}"
                                      maximumLength="#{bindings.ProviderName.hints.precision}"
                                      shortDesc="#{bindings.ProviderName.hints.tooltip}"
                                      id="it2" readOnly="true">
                          <f:validator binding="#{bindings.ProviderName.validator}"/>
                        </af:inputText>
                        <af:panelLabelAndMessage label="#{bindings.OrigTitle.hints.label}"
                                                 id="plam4">
                          <af:outputText value="#{bindings.OrigTitle.inputValue}"
                                         id="ot4" partialTriggers="qryId1"/>
                        </af:panelLabelAndMessage>
                      </af:panelFormLayout>
                      <af:spacer width="10" height="10" id="s1"/>
                      <af:group id="g1">
                        <af:panelFormLayout id="pfl3" rows="1" maxColumns="2">
                          <af:commandButton id="cb2"
                                            text="#{viewcontrollerBundle.part_no}"
                                            binding="#{viewScope.cid_reserve.partNo_btn}"
                                            disabled="true"/>
                          <af:commandButton text="#{viewcontrollerBundle.vol_no}"
                                            id="cb5"
                                            binding="#{viewScope.cid_reserve.volNo_btn}"
                                            disabled="true"/>
                        </af:panelFormLayout>
                        <af:panelCollection id="pc1"
                                            inlineStyle="width:25%; height:150.0px;">
                          <af:table value="#{bindings.PhysicalBookVolPartVO1.collectionModel}"
                                    var="row"
                                    rows="#{bindings.PhysicalBookVolPartVO1.rangeSize}"
                                    emptyText="#{bindings.PhysicalBookVolPartVO1.viewable ? 'No data to display.' : 'Access Denied.'}"
                                    fetchSize="#{bindings.PhysicalBookVolPartVO1.rangeSize}"
                                    rowBandingInterval="0"
                                    filterModel="#{bindings.PhysicalBookVolPartVO1Query.queryDescriptor}"
                                    queryListener="#{bindings.PhysicalBookVolPartVO1Query.processQuery}"
                                    filterVisible="true" varStatus="vs"
                                    selectedRowKeys="#{bindings.PhysicalBookVolPartVO1.collectionModel.selectedRow}"
                                    selectionListener="#{viewScope.cid_reserve.PhbookVolPartSelectionListener}"
                                    rowSelection="single" id="t2"
                                    columnStretching="last">
                            <af:column sortProperty="VolNo" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.PhysicalBookVolPartVO1.hints.VolNo.label}"
                                       id="c2">
                              <af:outputText value="#{row.VolNo}" id="ot5"/>
                            </af:column>
                            <af:column sortProperty="PartNo" filterable="true"
                                       sortable="true"
                                       headerText="#{bindings.PhysicalBookVolPartVO1.hints.PartNo.label}"
                                       id="c1">
                              <af:outputText value="#{row.PartNo}" id="ot6"/>
                            </af:column>
                          </af:table>
                        </af:panelCollection>
                      </af:group>
                      <af:spacer width="10" height="10" id="s2"/>
                      <af:panelFormLayout id="pfl2" rows="1" maxColumns="3">
                        <af:commandButton action="#{pageFlowScope.TFBean.reserve_detail}"
                                          id="cb3"
                                          text="#{viewcontrollerBundle.detail_ver}"
                                          shortDesc="#{viewcontrollerBundle.ADD_ROLE}"
                                          partialSubmit="true"
                                          binding="#{viewScope.cid_reserve.showDetail_btn}"
                                          disabled="true"
                                          partialTriggers="pc1:t2">
                          <af:setActionListener from="#{viewcontrollerBundle.detail_ver}"
                                                to="#{ReserveTitle.popupTitle}"/>
                        </af:commandButton>
                        <af:commandButton text="commandButton 1" id="cb4"
                                          visible="false"
                                          binding="#{viewScope.cid_reserve.reserveList_btn}"/>
                        <af:commandButton id="cb1"
                                          text="#{viewcontrollerBundle.book_reserve}"
                                          partialSubmit="true"
                                          binding="#{viewScope.cid_reserve.reserve1_btn}"
                                          disabled="true"
                                          action="#{viewScope.cid_reserve.reserveBtnAction_portal}"
                                          partialTriggers="pc1:t2"
                                          windowModalityType="applicationModal">
                          <af:setActionListener from="#{viewcontrollerBundle.book_reserve}"
                                                to="#{ReserveTitle.popupTitle}"/>
                        </af:commandButton>
                        <f:facet name="footer"/>
                      </af:panelFormLayout>
                    </af:panelGroupLayout>
                  </af:panelBox>
                </f:facet>
              </af:panelSplitter>
            </af:panelGroupLayout>
          </af:panelHeader>
          </f:facet>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>