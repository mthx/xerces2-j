/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.xerces.dom;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Thread-safe implementation of NodeList that relies on the underlying
 * document being read-only as it does not support liveness. 
 * 
 * @version $Id: $
 */
public class CopyingNodeListImpl implements NodeList {

    private final ArrayList nodes = new ArrayList();

    public CopyingNodeListImpl(ParentNode parentNode) {
        Node child = parentNode.getFirstChild();
        while (child != null) {
            nodes.add(child);
            child = child.getNextSibling();
        }
    }

    public int getLength() {
        return nodes.size();
    }

    public Node item(int index) {
        return (Node) nodes.get(index);
    }

}
