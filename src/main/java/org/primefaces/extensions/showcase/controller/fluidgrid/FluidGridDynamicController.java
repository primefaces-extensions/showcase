/*
 * Copyright 2011-2013 PrimeFaces Extensions.
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
 */

package org.primefaces.extensions.showcase.controller.fluidgrid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import org.primefaces.extensions.showcase.model.fluidgrid.Image;

/**
 * FluidGridDynamicController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class FluidGridDynamicController implements Serializable {

	private List<FluidGridItem> images;

	@PostConstruct
	protected void initialize() {
		images = new ArrayList<FluidGridItem>();

		for (int j = 0; j < 3; j++) {
			for (int i = 1; i <= 10; i++) {
				images.add(new FluidGridItem(new Image(i + ".jpeg")));
			}
		}
	}

	public List<FluidGridItem> getImages() {
		return images;
	}
}
