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
import com.google.gwt.event.dom.client.TouchStartEvent;

/**
 * A simulated TouchStartEvent is really a MS Pointer down event
 */
public class SimulatedTouchStartEvent extends TouchStartEvent {
  private int x;
  private int y;
  private final MsPointerDownEvent event;
  private boolean multiTouch;

  /**
   * <p>
   * Constructor for SimulatedTouchStartEvent.
   * </p>
   * 
   * @param event a {@link com.googlecode.mgwt.dom.client.event.pointer.MsPointerDownEvent} object.
   * @param multiTouch
   */
  public SimulatedTouchStartEvent(MsPointerDownEvent event, boolean multiTouch) {
    this.event = event;
    x = event.getClientX();
    y = event.getClientY();
    this.multiTouch = multiTouch;
    if (this.multiTouch) {
      MultiTouchMsPointerEmulator.onTouchStart(x, y);
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

		touch.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::x;
		touch.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::y;

		var toucharray = [];

		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::x;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::y;
			toucharray.push(touch_start);
		}

		toucharray.push(touch);

		return toucharray;
  }-*/;

  /** {@inheritDoc} */
  protected native JsArray<Touch> changedTouches(NativeEvent nativeEvent) /*-{
		var touch = {};

		touch.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::x;
		touch.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::y;

		var toucharray = [];

		if (this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::multiTouch) {
			var touch_start = {};
			touch_start.pageX = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::x;
			touch_start.pageY = this.@com.googlecode.mgwt.dom.client.event.pointer.SimulatedTouchStartEvent::y;
			toucharray.push(touch_start);
		}

		toucharray.push(touch);

		return toucharray;
  }-*/;

  @Override
  public void stopPropagation() {
    event.stopPropagation();
  }

}
