/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.dom.client.event.pointer;

import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Abstract class representing MsPointer events.
 *
 * @param <H> handler type
 *
 */
public abstract class MsPointerEvent<H extends EventHandler> extends MouseEvent<H> {

  public static String MSPOINTERDOWN = "pointerdown";
  public static String MSPOINTERMOVE = "pointermove";
  public static String MSPOINTEROUT = "pointerout";
  public static String MSPOINTEROVER = "pointerover";
  public static String MSPOINTERUP = "pointerup";
  public static String MSPOINTERCANCEL = "pointercancel";

  public final native int getPointerId() /*-{
    var e = this.@com.google.gwt.event.dom.client.DomEvent::nativeEvent;
    return e.pointerId;
  }-*/;

}
