/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysds.runtime.compress.utils;

import java.util.Arrays;

/**
 * Helper class used for bitmap extraction.
 */
public class DblArray {
	private double[] _arr;

	private int hash = 0;

	public DblArray() {
		_arr = null;
	}

	public DblArray(double[] arr) {
		_arr = arr;
	}

	public DblArray(DblArray that) {
		this(Arrays.copyOf(that._arr, that._arr.length));
	}

	public double[] getData() {
		return _arr;
	}

	public void resetHash(){
		hash = 0;
	}

	public boolean isEmpty(){
		return _arr == null;
	}

	@Override
	public int hashCode() {
		if(hash != 0)
			return hash;
		hash = _arr == null ? 0 : Arrays.hashCode(_arr);
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		return(o instanceof DblArray && Arrays.equals(_arr, ((DblArray) o)._arr));
	}

	@Override
	public String toString() {
		return Arrays.toString(_arr);
	}

	public static boolean isZero(DblArray val) {
		return val._arr == null;
	}
}
