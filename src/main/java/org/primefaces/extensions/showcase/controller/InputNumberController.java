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
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.showcase.model.Distance;

/**
 * InputNumberController
 *
 * @author  Mauricio Fenoglio / last modified by $Author$
 * @version $Revision$
 * @since   0.3
 */
@ManagedBean
@ViewScoped
public class InputNumberController implements Serializable {

	private static final long serialVersionUID = 20120316L;

	private Double input1 = new Double(0);
	private Double input2 = new Double(0);
	private Double input3 = new Double(0);
	private Double input4 = new Double(0);
	private Double input5 = new Double(0);
	private Double input6 = new Double(0);
	private Double input7 = null;
	private Double input8 = null;
	private Double input9 = new Double(0);
	private Double input10 = null;
        
        private Double input11 = new Double(0);
        private BigDecimal input12 = new BigDecimal(0);

	private String unit;
	private String roundMethod;
	private int decimalPlaces;
	private Distance distance;

	public InputNumberController() {
            
               
            
		unit = " kmh";
		roundMethod = "S";
		decimalPlaces = 2;
		distance = new Distance();

		//initialize values
		input1 = 0d;
		input2 = 0d;
		input3 = 0d;
		input4 = 0d;
		input5 = 251.31;
		input6 = 60d;    
                
                input11 = 1234.000000001 ;   
                input12 = new BigDecimal("1234.000000001");
	}

	public Double getInput1() {
		return input1;
	}

	public void setInput1(Double input1) {
		this.input1 = input1;
	}

	public Double getInput2() {
		return input2;
	}

	public void setInput2(Double input2) {
		this.input2 = input2;
	}

	public Double getInput3() {
		return input3;
	}

	public void setInput3(Double input3) {
		this.input3 = input3;
	}

	public Double getInput4() {
		return input4;
	}

	public void setInput4(Double input4) {
		this.input4 = input4;
	}

	public Double getInput5() {
		return input5;
	}

	public void setInput5(Double input5) {
		this.input5 = input5;
	}

	public Double getInput6() {
		return input6;
	}

	public void setInput6(Double input6) {
		this.input6 = input6;
	}

	public Double getInput7() {
		return input7;
	}

	public void setInput7(Double input7) {
		this.input7 = input7;
	}

	public Double getInput8() {
		return input8;
	}

	public void setInput8(Double input8) {
		this.input8 = input8;
	}

	public Double getInput9() {
		return input9;
	}

	public void setInput9(Double input9) {
		this.input9 = input9;
	}

	public Double getInput10() {
		return input10;
	}

	public void setInput10(Double input10) {
		this.input10 = input10;
	}

        public Double getInput11() {           
             return input11;
        }

        public void setInput11(Double input11) {  
            this.input11 = input11;
        }

        public BigDecimal getInput12() {          
            return input12;
        }

        public void setInput12(BigDecimal input12) {            
            this.input12 = input12;
        }

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public String getRoundMethod() {
		return roundMethod;
	}

	public void setRoundMethod(String roundMethod) {
		this.roundMethod = roundMethod;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
}
