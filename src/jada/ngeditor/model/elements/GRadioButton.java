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
package jada.ngeditor.model.elements;


import de.lessvoid.nifty.controls.radiobutton.builder.RadioButtonBuilder;
import de.lessvoid.nifty.elements.Element;
import jada.ngeditor.model.GUIFactory;
import jada.ngeditor.persistence.XmlTags;
import jada.ngeditor.model.exception.IllegalDropException;
import jada.ngeditor.model.visitor.Visitor;
import jada.ngeditor.persistence.ControlBinding;
/**
 *
 * @author cris
 */
 @ControlBinding(name= XmlTags.RADIOBUTTON)
public class GRadioButton extends GControl  {

    public GRadioButton() {
    }
  
      public GRadioButton(String id) throws IllegalArgumentException{
      super(id);
      builder = new RadioButtonBuilder();
      name="radioButton";
      
    }


    @Override
    public GElement create(String id) {
        return new GRadioButton(id);
    }

    @Override
    public void initDefault() {
       
    }
    
     @Override
    public Element getDropContext() {
        throw new IllegalDropException("You can not add elements to a radiobutton");
    }

     @Override
    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
    
}
