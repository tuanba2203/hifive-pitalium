/*
 * Copyright (C) 2015-2017 NS Solutions Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.htmlhifive.pitalium.image.model;

import java.awt.Rectangle;

/**
 * This class has information about location shift of given rectangle area.
 */
public class ComparedRectangleArea extends RectangleArea {

	private DiffCategory category = null;

	/**
	 * The negative value of xShift means the left side, the positive value of it means the right side, and the negative
	 * value of yShift means the upper side, the positive value of it means the lower side.
	 */
	private int xShift = 0;
	private int yShift = 0;

	// difference norm method comparing Pixel by Pixel
	private SimilarityUnit similarityUnit;

	/**
	 * Constructor Set the area information.
	 *
	 * @param rectangle the rectangle area of template image
	 */
	public ComparedRectangleArea(Rectangle rectangle) {
		super(rectangle);
	}

	/**
	 * Constructor Set the location and size information.
	 *
	 * @param rectangle the rectangle area of template image
	 */
	public ComparedRectangleArea(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	/**
	 * Constructor Set the shift information when the template image is contained in the entire image.
	 *
	 * @param rectangle the rectangle area of template image
	 * @param xShift how many pixels the template image is shifted rightward
	 * @param yShift how many pixels the template image is shifted downward
	 */
	public ComparedRectangleArea(Rectangle rectangle, int xShift, int yShift) {
		this(rectangle);
		this.xShift = xShift;
		this.yShift = yShift;
		this.category = DiffCategory.SHIFT;
	}

	/**
	 * Constructor
	 *
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param category
	 * @param xShift
	 * @param yShift
	 * @param similarityUnit
	 */
	public ComparedRectangleArea(int x, int y, int width, int height, DiffCategory category, int xShift, int yShift,
			SimilarityUnit similarityUnit) {
		super(x, y, width, height);
		this.category = category;
		this.xShift = xShift;
		this.yShift = yShift;
		this.similarityUnit = similarityUnit;
	}

	public ComparedRectangleArea() {
		this(0, 0, 0, 0, null, 0, 0, null);
	}

	public DiffCategory getCategory() {
		return category;
	}

	public void setCategory(DiffCategory category) {
		this.category = category;
	}

	public int getXShift() {
		return xShift;
	}

	public void setXShift(int xShift) {
		this.xShift = xShift;
	}

	public int getYShift() {
		return yShift;
	}

	public void setYShift(int yShift) {
		this.yShift = yShift;
	}

	public SimilarityUnit getSimilarityUnit() {
		return similarityUnit;
	}

	public void setSimilarityUnit(SimilarityUnit similarityUnit) {
		this.similarityUnit = similarityUnit;
	}
}
