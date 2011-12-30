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

package org.primefaces.extensions.showcase.controller.blockui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * TreeBean
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class FileSystemController implements Serializable {

	private static final long serialVersionUID = 20111229L;

	private TreeNode root;
	private TreeNode selectedNode;

	public FileSystemController() {
		root = new DefaultTreeNode("Root", null);

		TreeNode node0 = new DefaultTreeNode("Folder 0", root);
		TreeNode node1 = new DefaultTreeNode("Folder 1", root);
		TreeNode node2 = new DefaultTreeNode("Folder 2", root);
		TreeNode node00 = new DefaultTreeNode("Folder 0.0", node0);
		TreeNode node01 = new DefaultTreeNode("Folder 0.1", node0);
		TreeNode node10 = new DefaultTreeNode("Folder 1.0", node1);
		new DefaultTreeNode("File 1.1", node1);
		new DefaultTreeNode("File 2.0", node2);
		new DefaultTreeNode("File 0.0.0", node00);
		new DefaultTreeNode("File 0.0.1", node00);
		new DefaultTreeNode("File 0.1.0", node01);
		new DefaultTreeNode("File 1.0.0", node10);
	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void onNodeExpand(NodeExpandEvent event) {
		doSomething();
	}

	public void onNodeSelect(NodeSelectEvent event) {
		selectedNode = event.getTreeNode();
		doSomething();
	}

	public void onNodeUnselect(NodeUnselectEvent event) {
		selectedNode = null;
		doSomething();
	}

	public void doSomething() {
		try {
			// simulate a long running request
			Thread.sleep(1200);
		} catch (Exception e) {
			// ignore
		}
	}
}
