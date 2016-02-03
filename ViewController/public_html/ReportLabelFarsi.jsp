<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view locale="ar">
  <af:document id="d1">
    <af:messages id="m1"/>
    <af:form id="f1">
      <af:pageTemplate viewId="/template/UTtemplate.jspx"
                       value="#{bindings.pageTemplateBinding}" id="pt1">
        <f:facet name="center">
        <af:panelHeader text="">
        <af:panelBox text=" " id="pb1" showDisclosure="false">
              <af:panelGroupLayout id="pgl1" layout="scroll" valign="middle"
                                   halign="center">
                <af:table value="#{bindings.LabelFarsi_label_virtualBook.collectionModel}"
                          var="row"
                          rows="#{bindings.LabelFarsi_label_virtualBook.rangeSize}"
                          emptyText="#{bindings.LabelFarsi_label_virtualBook.viewable ? 'No data to display.' : 'Access Denied.'}"
                          fetchSize="#{bindings.LabelFarsi_label_virtualBook.rangeSize}"
                          rowBandingInterval="0"
                          filterModel="#{bindings.LabelFarsi_label_virtualBookQuery.queryDescriptor}"
                          queryListener="#{bindings.LabelFarsi_label_virtualBookQuery.processQuery}"
                          filterVisible="true" varStatus="vs"
                          selectedRowKeys="#{bindings.LabelFarsi_label_virtualBook.collectionModel.selectedRow}"
                          selectionListener="#{bindings.LabelFarsi_label_virtualBook.collectionModel.makeCurrent}"
                          rowSelection="single" id="t1"
                          inlineStyle="width:45%; height:150.0px;"
                          columnStretching="column:c2">
                  <af:column sortProperty="ArtId" filterable="true"
                             sortable="true"
                             headerText="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.label}"
                             id="c1">
                    <af:inputText value="#{row.bindings.ArtId.inputValue}"
                                  label="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.label}"
                                  required="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.mandatory}"
                                  columns="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.displayWidth}"
                                  maximumLength="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.precision}"
                                  shortDesc="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.tooltip}"
                                  id="it1">
                      <f:validator binding="#{row.bindings.ArtId.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.LabelFarsi_label_virtualBook.hints.ArtId.format}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="Title" filterable="true"
                             sortable="true"
                             headerText="#{bindings.LabelFarsi_label_virtualBook.hints.Title.label}"
                             id="c2">
                    <af:inputText value="#{row.bindings.Title.inputValue}"
                                  label="#{bindings.LabelFarsi_label_virtualBook.hints.Title.label}"
                                  required="#{bindings.LabelFarsi_label_virtualBook.hints.Title.mandatory}"
                                  columns="#{bindings.LabelFarsi_label_virtualBook.hints.Title.displayWidth}"
                                  maximumLength="#{bindings.LabelFarsi_label_virtualBook.hints.Title.precision}"
                                  shortDesc="#{bindings.LabelFarsi_label_virtualBook.hints.Title.tooltip}"
                                  id="it2">
                      <f:validator binding="#{row.bindings.Title.validator}"/>
                    </af:inputText>
                  </af:column>
                </af:table>
                <af:spacer width="10" height="20" id="s1"/>
                <af:table value="#{bindings.PhysicalBookVO2.collectionModel}"
                          var="row" rows="#{bindings.PhysicalBookVO2.rangeSize}"
                          emptyText="#{bindings.PhysicalBookVO2.viewable ? 'No data to display.' : 'Access Denied.'}"
                          fetchSize="#{bindings.PhysicalBookVO2.rangeSize}"
                          rowBandingInterval="0"
                          filterModel="#{bindings.PhysicalBookVO2Query.queryDescriptor}"
                          queryListener="#{bindings.PhysicalBookVO2Query.processQuery}"
                          filterVisible="true" varStatus="vs"
                          selectedRowKeys="#{bindings.PhysicalBookVO2.collectionModel.selectedRow}"
                          selectionListener="#{bindings.PhysicalBookVO2.collectionModel.makeCurrent}"
                          rowSelection="single" id="t2"
                          inlineStyle="width:90%; height:200.0px;"
                          partialTriggers="::t1">
                  <af:column sortProperty="Barcode" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.Barcode.label}"
                             id="c9">
                    <af:inputText value="#{row.bindings.Barcode.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.Barcode.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.Barcode.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.Barcode.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.Barcode.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.Barcode.tooltip}"
                                  id="it9">
                      <f:validator binding="#{row.bindings.Barcode.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="RegId" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.RegId.label}"
                             id="c8">
                    <af:inputText value="#{row.bindings.RegId.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.RegId.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.RegId.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.RegId.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.RegId.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.RegId.tooltip}"
                                  id="it4">
                      <f:validator binding="#{row.bindings.RegId.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="VolNo" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.VolNo.label}"
                             id="c12">
                    <af:inputText value="#{row.bindings.VolNo.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.VolNo.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.VolNo.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.VolNo.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.VolNo.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.VolNo.tooltip}"
                                  id="it3">
                      <f:validator binding="#{row.bindings.VolNo.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="PartNo" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.PartNo.label}"
                             id="c11">
                    <af:inputText value="#{row.bindings.PartNo.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.PartNo.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.PartNo.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.PartNo.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.PartNo.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.PartNo.tooltip}"
                                  id="it5">
                      <f:validator binding="#{row.bindings.PartNo.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="ReplicateNo" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.ReplicateNo.label}"
                             id="c13">
                    <af:inputText value="#{row.bindings.ReplicateNo.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.ReplicateNo.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.ReplicateNo.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.ReplicateNo.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.ReplicateNo.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.ReplicateNo.tooltip}"
                                  id="it6">
                      <f:validator binding="#{row.bindings.ReplicateNo.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.PhysicalBookVO2.hints.ReplicateNo.format}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="ExistenceStatus" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.ExistenceStatus.label}"
                             id="c3">
                    <af:selectOneChoice value="#{row.bindings.ExistenceStatus.inputValue}"
                                        label="#{row.bindings.ExistenceStatus.label}"
                                        required="#{bindings.PhysicalBookVO2.hints.ExistenceStatus.mandatory}"
                                        shortDesc="#{bindings.PhysicalBookVO2.hints.ExistenceStatus.tooltip}"
                                        id="soc2">
                      <f:selectItems value="#{row.bindings.ExistenceStatus.items}"
                                     id="si1"/>
                    </af:selectOneChoice>
                  </af:column>
                  <af:column sortProperty="LoanStatus" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.LoanStatus.label}"
                             id="c6">
                    <af:selectOneChoice value="#{row.bindings.LoanStatus.inputValue}"
                                        label="#{row.bindings.LoanStatus.label}"
                                        required="#{bindings.PhysicalBookVO2.hints.LoanStatus.mandatory}"
                                        shortDesc="#{bindings.PhysicalBookVO2.hints.LoanStatus.tooltip}"
                                        id="soc4">
                      <f:selectItems value="#{row.bindings.LoanStatus.items}"
                                     id="si3"/>
                    </af:selectOneChoice>
                  </af:column>
                  <af:column sortProperty="Place" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.Place.label}"
                             id="c4">
                    <af:selectOneChoice value="#{row.bindings.Place.inputValue}"
                                        label="#{row.bindings.Place.label}"
                                        required="#{bindings.PhysicalBookVO2.hints.Place.mandatory}"
                                        shortDesc="#{bindings.PhysicalBookVO2.hints.Place.tooltip}"
                                        id="soc1">
                      <f:selectItems value="#{row.bindings.Place.items}"
                                     id="si4"/>
                    </af:selectOneChoice>
                  </af:column>
                  <af:column sortProperty="SafetyStatus" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.SafetyStatus.label}"
                             id="c5">
                    <af:selectOneChoice value="#{row.bindings.SafetyStatus.inputValue}"
                                        label="#{row.bindings.SafetyStatus.label}"
                                        required="#{bindings.PhysicalBookVO2.hints.SafetyStatus.mandatory}"
                                        shortDesc="#{bindings.PhysicalBookVO2.hints.SafetyStatus.tooltip}"
                                        id="soc3">
                      <f:selectItems value="#{row.bindings.SafetyStatus.items}"
                                     id="si2"/>
                    </af:selectOneChoice>
                  </af:column>
                  <af:column sortProperty="UserName" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.UserName.label}"
                             id="c10">
                    <af:inputText value="#{row.bindings.UserName.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.UserName.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.UserName.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.UserName.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.UserName.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.UserName.tooltip}"
                                  id="it8">
                      <f:validator binding="#{row.bindings.UserName.validator}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="InsertDate" filterable="true"
                             sortable="true"
                             headerText="#{bindings.PhysicalBookVO2.hints.InsertDate.label}"
                             id="c7">
                    <af:inputText value="#{row.bindings.InsertDate.inputValue}"
                                  label="#{bindings.PhysicalBookVO2.hints.InsertDate.label}"
                                  required="#{bindings.PhysicalBookVO2.hints.InsertDate.mandatory}"
                                  columns="#{bindings.PhysicalBookVO2.hints.InsertDate.displayWidth}"
                                  maximumLength="#{bindings.PhysicalBookVO2.hints.InsertDate.precision}"
                                  shortDesc="#{bindings.PhysicalBookVO2.hints.InsertDate.tooltip}"
                                  id="it7">
                      <f:validator binding="#{row.bindings.InsertDate.validator}"/>
                      <af:convertNumber groupingUsed="false"
                                        pattern="#{bindings.PhysicalBookVO2.hints.InsertDate.format}"/>
                    </af:inputText>
                  </af:column>
                </af:table>
                <af:panelFormLayout id="pfl1">
                  <f:facet name="footer">
                    <af:panelGroupLayout id="pgl2">
                      <af:commandButton text="چاپ برای همه عنوان ها" id="cb1"/>
                      <af:commandButton text="چاپ برای عنوان" id="cb2"/>
                      <af:commandButton text="چاپ برای جلد" id="cb3"/>
                      <af:commandButton text="چاپ برای قسمت" id="cb4"/>
                      <af:commandButton text="چاپ برای نسخه" id="cb5"/>
                      <af:commandButton text="برگشت" id="cb6" action="goBack"/>
                    </af:panelGroupLayout>
                  </f:facet>
                </af:panelFormLayout>
              </af:panelGroupLayout>
            </af:panelBox>
        </af:panelHeader>
        
        </f:facet>
        <f:facet name="popup"/>
      </af:pageTemplate>
    </af:form>
  </af:document>
</f:view>