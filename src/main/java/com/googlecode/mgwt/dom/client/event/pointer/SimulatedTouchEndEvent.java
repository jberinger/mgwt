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
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.googlecode.mgwt.collection.client.JsLightArray;
import com.googlecode.mgwt.collection.shared.LightArray;

/**
 * A simulated TouchEndEvent is really a MsPointerUpEvent
 */
public class SimulatedTouchEndEvent extends TouchEndEvent {

  private final int x;
  private final int y;
  private int x_start;
  private int y_start;
  private boolean multiTouch;

  /**
   * Construct a simulated TouchEndEvent from a {@link MsPointerUpEvent}
   * 
   * @param pointerUpEvent the data for the simulated event;
   * @param multiTouch
   */
  public SimulatedTouchEndEvent(MsPointerUpEvent pointerUpEvent, boolean multiTouch) {
    x = pointerUpEvent.getClientX();
    y = pointerUpEvent.getClientY();
    this.multiTouch = multiTouch;
    if (multiTouch) {
      int[] start = MultiTouchMsPointerEmulator.getTouchStart();
      x_start = start[0];
      y_start = start[1];
    }
    setNativeEvent(pointerUpEvent.getNativeEvent());
    setSource(pointerUpEvent.getSource());
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
		var toucharray = [];
		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::x_start;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::y_start;
			toucharray.push(touch_start);
		}

		return toucharray;
  }-*/;

  /** {@inheritDoc} */
  protected native JsArray<Touch> changedTouches(NativeEvent nativeEvent) /*-{

		var toucharray = [];

		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::x_start;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::y_start;
			toucharray.push(touch_start);
		} else {
			var touch = {};
			touch.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::x;
			touch.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchEndEvent::y;
			toucharray.push(touch);
		}

		return toucharray;
  }-*/;
}
