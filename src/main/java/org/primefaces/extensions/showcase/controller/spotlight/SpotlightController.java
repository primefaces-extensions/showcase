/*
 * Copyright 2011 PrimeFaces Extensions.
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
package org.primefaces.extensions.showcase.controller.spotlight;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * SpotlightController
 *
 * @author Pavol Slany / last modified by $Author$
 * @version $Revision$
 * @since 0.5
 */
@ManagedBean
@ViewScoped
public class SpotlightController implements Serializable {

    private static final long serialVersionUID = 20120401L;

    private AddressData addr1;
    private AddressData addr2;
    private AddressData addr3;

    @PostConstruct
    public void init() {
        addr1 = new AddressData();
        addr2 = new AddressData();
        addr3 = new AddressData();
    }

    public AddressData getAddr1() {
        return addr1;
    }

    public AddressData getAddr2() {
        return addr2;
    }

    public AddressData getAddr3() {
        return addr3;
    }
}
