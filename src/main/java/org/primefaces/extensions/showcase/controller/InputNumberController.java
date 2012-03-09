/*
 * Copyright 2012 MauriMonte.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * InputNumberController
 *
 * @author Mauricio Fenoglio / last modified by $Author$
 * @version $Revision$
 * @since 0.3
 */
@ManagedBean
@ViewScoped
public class InputNumberController implements Serializable {

        private Double inputOne;
        private double inputTwo;

        public InputNumberController() {
                //init values
                inputOne = 10d;
                inputTwo = 10d;
        }

        public void multiplicate(int input) {
               
                if (input == 1) {
                        inputOne *= 2;
                        return;
                }
                if (input == 2) {
                        inputTwo *= 2;
                        return;
                }

        }

        public Double getInputOne() {
                return inputOne;
        }

        public void setInputOne(Double inputOne) {
                this.inputOne = inputOne;
        }

        public double getInputTwo() {
                return inputTwo;
        }

        public void setInputTwo(double inputTwo) {
                this.inputTwo = inputTwo;
        }
}
