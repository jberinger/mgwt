/*
 * Copyright 2010 Daniel Kurka
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

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.googlecode.mgwt.collection.client.JsLightArray;

/**
 * A simulated TouchMoveEvent is really a MS Pointer move event
 */
public class SimulatedTouchMoveEvent extends TouchMoveEvent {

  private int x;
  private int y;

  private int x_start;
  private int y_start;
  private boolean multiTouch;

  /**
   * <p>
   * Constructor for SimulatedTouchMoveEvent.
   * </p>
   * 
   * @param event a {@link com.googlecode.mgwt.dom.client.event.pointer.MsPointerMoveEvent} object.
   */
  public SimulatedTouchMoveEvent(MsPointerMoveEvent event) {
    x = event.getClientX();
    y = event.getClientY();
    multiTouch = false;

    if (event.isAltKeyDown() && MultiTouchMsPointerEmulator.isHasValues()) {
      multiTouch = true;
      int[] start = MultiTouchMsPointerEmulator.getTouchStart();
      x_start = start[0];
      y_start = start[1];
    }

    setNativeEvent(event.getNativeEvent());
    setSource(event.getSource());
  }

  @Override
  public JsArray<Touch> getTouches() {
    return touches(getNativeEvent());
  }

  @Override
  public JsArray<Touch> getChangedTouches() {
    return changedTouches(getNativeEvent());
  }

  /** {@inheritDoc} */
  protected native JsArray<Touch> touches(NativeEvent nativeEvent) /*-{
		var touch = {};

		touch.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::x;
		touch.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::y;

		var toucharray = [];

		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::x_start;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::y_start;
			toucharray.push(touch_start);
		}

		toucharray.push(touch);

		return toucharray;
  }-*/;

  /** {@inheritDoc} */
  protected native JsArray<Touch> changedTouches(NativeEvent nativeEvent) /*-{
		var touch = {};

		touch.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::x;
		touch.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::y;

		var toucharray = [];

		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::x_start;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchMoveEvent::y_start;
			toucharray.push(touch_start);
		}

		toucharray.push(touch);

		return toucharray;
  }-*/;
}
