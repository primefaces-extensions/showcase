/*
 * Copyright 2012 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id$
 */
package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * TriSateManyCheckboxController
 *
 * @author  Mauricio Fenoglio / last modified by $Author: $
 * @version $Revision: $
 * @since   0.3
 */
@ManagedBean
@ViewScoped
public class TriSateManyCheckboxController implements Serializable {

        

        private Map<String, String> selectedOptionsTriStateBasic;
        private Map<String, String> selectedOptionsTriStateAjax;
        private Map<String,String> basicOptions;

        public TriSateManyCheckboxController() {       
                
                basicOptions = new HashMap<String, String>();  
                basicOptions.put("Label for Dog", "Dog");  
                basicOptions.put("Label for Cat", "Cat");  
                basicOptions.put("Label for Fish", "Fish");                  

                //default will created with state=0
                selectedOptionsTriStateBasic = new HashMap<String, String>();
                          
                selectedOptionsTriStateAjax = new HashMap<String, String>();
                selectedOptionsTriStateAjax.put("Tamara", "1");
                selectedOptionsTriStateAjax.put("Mauricio", "1");                 
        }

        public Map<String, String> getSelectedOptionsTriStateAjax() {
                return selectedOptionsTriStateAjax;
        }

        public void setSelectedOptionsTriStateAjax(Map<String, String> selectedOptionsTriStateAjax) {
                this.selectedOptionsTriStateAjax = selectedOptionsTriStateAjax;
        }

        public Map<String, String> getSelectedOptionsTriStateBasic() {
                return selectedOptionsTriStateBasic;
        }

        public void setSelectedOptionsTriStateBasic(Map<String, String> selectedOptionsTriStateBasic) {
                this.selectedOptionsTriStateBasic = selectedOptionsTriStateBasic;
        }
        
        public void addMessage() {              
                String message="";
                for(String key : selectedOptionsTriStateAjax.keySet()){
                        message += key + "=" +selectedOptionsTriStateAjax.get(key) +"  ";                      
                }
                
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed",message.trim());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

        public Map<String, String> getBasicOptions() {
                return basicOptions;
        }

        public void setBasicOptions(Map<String, String> basicOptions) {
                this.basicOptions = basicOptions;
        }
        
        
}
