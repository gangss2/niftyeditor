/* Copyright 2012 Aguzzi Cristiano

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package jada.ngeditor.listeners;


import jada.ngeditor.controller.ElementEditor;
import jada.ngeditor.controller.CommandProcessor;
import jada.ngeditor.controller.commands.EditAttributeCommand;
import jada.ngeditor.controller.commands.RemoveAttributeCommand;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 *
 * @author cris
 */
public class ProprietiesListener implements TableModelListener{
    
    
    public ProprietiesListener(){
      
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        
        if (e.getType() == TableModelEvent.UPDATE) {
            EditAttributeCommand command = CommandProcessor.getInstance().getCommand(EditAttributeCommand.class);
            RemoveAttributeCommand removecommand = CommandProcessor.getInstance().getCommand(RemoveAttributeCommand.class);
            TableModel mod = (TableModel) e.getSource();
            String proName = (String) mod.getValueAt(e.getLastRow(), 0);
            String proVal = (String) mod.getValueAt(e.getLastRow(), 1);
            if (proName != null && !proName.isEmpty()) {
                try{
                if (proVal == null || proVal.isEmpty()) {
                    removecommand.setAttributeKey(proName);
                    CommandProcessor.getInstance().excuteCommand(removecommand);
                } else {
                   command.setAttribute(proName);
                   command.setValue(proVal);
                   CommandProcessor.getInstance().excuteCommand(command);
                }
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Can't set the attribute. " + ex.getMessage());
                }
            }
        }
    }
    
  
    
}
