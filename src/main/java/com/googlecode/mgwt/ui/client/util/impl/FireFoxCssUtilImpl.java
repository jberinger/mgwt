package com.googlecode.mgwt.ui.client.util.impl;

import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.dom.client.Element;

public class FireFoxCssUtilImpl implements CssUtilImpl {

	public FireFoxCssUtilImpl() {

	}

	@Override
	public void translate(Element el, int x, int y) {
		String cssText = null;
		cssText = "translate3d( " + x + "px, " + y + "px, 0px )";
		el.getStyle().setProperty("transform", cssText);

	}

	@Override
	public void setDelay(Element el, int milliseconds) {
		el.getStyle().setProperty("transitionDelay", milliseconds + "ms");

	}

	@Override
	public void setOpacity(Element el, double opacity) {
		el.getStyle().setOpacity(opacity);
	}

	@Override
	public void setDuration(Element el, int time) {
		el.getStyle().setProperty("transitionDuration", time + "ms");
	}

	@Override
	public void rotate(Element el, int degree) {
		el.getStyle().setProperty("transform", "rotate(" + degree + "deg)");
	}

	@Override
	public boolean hasTransform() {
		return true;
	}

	@Override
	public boolean hasTransistionEndEvent() {
		// TODO review this for mobile some time!
		return true;
	}

	@Override
	public boolean has3d() {
		return false;
	}

	@Override
	public String getTransformProperty() {
		return "transform";
	}

	@Override
	public int[] getPositionFromTransForm(Element element) {
		JsArrayInteger array = getPositionFromTransform(element);
		return new int[] { array.get(0), array.get(1) };
	}

	private native JsArrayInteger getPositionFromTransform(Element el)/*-{
	  if (getComputedStyle(el, null)['transform'] == null) {
	    return [ 0, 0 ];
	  }
	  var matrixString = getComputedStyle(el, null)['transform'];
	  var matrix = getComputedStyle(el, null)['transform'].replace(
        /[^0-9-.,]/g, '').split(',');
	  if (matrixString.search("matrix3d") != -1) {
	    var x = matrix[12] * 1;
      var y = matrix[13] * 1;
      return [ x, y ];
	  } else {
			var x = matrix[4] * 1;
		  var y = matrix[5] * 1;
		  return [ x, y ];
		  
		}
  }-*/;

	@Override
	public native int getTopPositionFromCssPosition(Element element) /*-{
		return getComputedStyle(element, null).top.replace(/[^0-9-]/g, '') * 1;
  }-*/;

	@Override
	public native int getLeftPositionFromCssPosition(Element element)/*-{
		return getComputedStyle(element, null).left.replace(/[^0-9-]/g, '') * 1;
  }-*/;

	@Override
	public void resetTransform(Element element) {
		element.getStyle().setProperty("transform", "");

	}

	@Override
	public native void setTransistionProperty(Element element, String string) /*-{
		element.transitionProperty = string;
  }-*/;

	@Override
	public native void setTransFormOrigin(Element el, int x, int y) /*-{
		el.transformOrigin = x + " " + y;
  }-*/;

	@Override
	public native void setTransistionTimingFunction(Element element, String string) /*-{
		el.transitionTimingFunction = string;
  }-*/;

	@Override
	public void setTranslateAndZoom(Element el, int x, int y, double scale) {
		String cssText = null;

		cssText = "translate( " + x + "px, " + y + "px ) scale( + " + scale + ")";

		el.getStyle().setProperty("transform", cssText);

	}

  @Override
  public void translatePercent(Element el, double x, double y) {

    el.getStyle().setProperty("transform", "translate3d( " + x + "%, " + y + "% , 0%)");

  }

}
