package org.parsisys.tehranuniversity.library.view.viewutils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;


public class Shuttle {
    public Shuttle() {
       
    }

  public static List<SelectItem> getAll(String iteratorName,
                                        String valueAttrName,
                                        String displayAttrName) {
      return ADFUtils.selectItemsForIterator(iteratorName, valueAttrName,
                                             displayAttrName);
  }

  public static List getSelected(String iteratorName, String attrName) {
      List selected = new ArrayList();
      DCIteratorBinding iterator =
          ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding(iteratorName);
      Row[] rowSet = iterator.getAllRowsInRange();
      for (Row r : rowSet) {
          selected.add(r.getAttribute(attrName));
      }
      return selected;
  }

  public static void setSelected(List selectedValues, String pkAttName,
                                 String fkIteratorName, String fk1AttName,
                                 String fk2AttName, String deleteOpName,
                                 String createInsertOpName) {
      if (selectedValues == null)
          selectedValues = new ArrayList(0);
      DCBindingContainer dcbindings =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
      Object pkAtt = ADFUtils.getBoundAttributeValue(pkAttName);
      DCIteratorBinding iterator =
          dcbindings.findIteratorBinding(fkIteratorName);
      OperationBinding deleteOp =
          dcbindings.getOperationBinding(deleteOpName);
      OperationBinding createInsertOp =
          dcbindings.getOperationBinding(createInsertOpName);

      Row[] rowSet = iterator.getAllRowsInRange();
      for (Row row : rowSet) {
          Object fk2Att = row.getAttribute(fk2AttName);
          if (!selectedValues.contains(fk2Att)) {
              iterator.setCurrentRowWithKey(row.getKey().toStringFormat(true));
              deleteOp.execute();
          } else {
              selectedValues.remove(fk2Att);
          }
      }
      for (Object val : selectedValues) {
          createInsertOp.execute();
          Row row = iterator.getCurrentRow();
          row.setAttribute(fk2AttName, val);
          row.setAttribute(fk1AttName, pkAtt);
      }
  }
    
}
